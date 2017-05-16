package com.jd.cms.web.action.clientmanager;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.service.clientmanager.TopicService;
import com.jd.cms.service.cpQualityManagement.CpQualityManagementService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * User: hqj
 * Date: 12-7-24
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class TopicAction extends BaseAction {
    private TopicService topicService;
    private CpQualityManagementService cpQualityManagementService;
    private int pageSize = 10;
    private int topicType = 1;
    private Topic topic;
    private int pubedStatus;
    private TopicApp topicApp;
    protected CookieUtils cookieUtils;
    private ChannelTopic channelTopic;

    public ChannelTopic getChannelTopic() {
        return channelTopic;
    }

    public void setChannelTopic(ChannelTopic channelTopic) {
        this.channelTopic = channelTopic;
    }

    public TopicApp getTopicApp() {
        return topicApp;
    }

    public void setTopicApp(TopicApp topicApp) {
        this.topicApp = topicApp;
    }

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getTopicType() {
        return topicType;
    }

    public void setTopicType(int topicType) {
        this.topicType = topicType;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public TopicService getTopicService() {
        return topicService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public String getTopicList() throws Exception {
        Result topics = topicService.findTopic(page, pageSize, topicType);
        toVm(topics);
        return "topicList";
    }

    public String getTopicListByPub() throws Exception {
        Result topics = topicService.findTopicByPub(page, pageSize, pubedStatus);
        toVm(topics);
        return "topicList";
    }

    public String addTopic() throws Exception {
        Result result = new Result();
        String cookieValue = cookieUtils.getCookieValue(request, "ossAccount");
        result.addDefaultModel("cookieValue", cookieValue);
        toVm(result);
        return "addTopic";
    }

    public void doAddTopic() throws Exception {
        Result result = new Result();
        int isExist = findTopicBySeq();
        if (0 != isExist) {
            topicService.updateAddTopicSeq(topic);
            result = topicService.addTopic(topic);
        } else {
            result = topicService.addTopic(topic);
        }
        toVm(result);
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public String updateTopicPubedStatus() throws Exception {
        int isSuccess = topicService.updateTopicPubedStatus(topic);
        return null;
    }

    public void updateTopicSeq() throws Exception {
        int isExist = findTopicBySeq();
        if (0 != isExist) {
            topicService.updateAddTopicSeq(topic);
            topicService.updateTopicSeq(topic);
        } else {
            topicService.updateTopicSeq(topic);
        }
    }

    public void updateTopicAppSeq() throws Exception {
        int isExist = topicService.findTopicAppBySeq(topicApp);
        if (0 != isExist) {
            topicService.updateAddTopicAppSeq(topicApp);
            topicService.updateTopicAppSeq(topicApp);
        } else {
            topicService.updateTopicAppSeq(topicApp);
        }

    }

    public String padRelevanceTopic() {
        PadChannel padChannel = new PadChannel();
        Result result = cpQualityManagementService.getChannelCp(padChannel, page, 10000);
        result.addDefaultModel("topic", topic);
        toVm(result);
        Result channelTopic = topicService.getChannelTopic(topic.getTopicId());
        toVm(channelTopic);
        return "padRelevanceTopic";
    }

    public void saveRelenvanceTopic() {
        try {
            topicService.updateChannelTopic(channelTopic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int findTopicBySeq() throws Exception {
        int count = topicService.findTopicBySeq(topic);
        return count;
    }

    public void updateAddTopicSeq() throws Exception {
        topicService.updateAddTopicSeq(topic);
    }

    public void updateDelTopicSeq() throws Exception {
        topicService.updateDelTopicSeq(topic);
    }

    public void deleteTopic() throws Exception {
        updateDelTopicSeq();
        int isSuccess = topicService.deleteTopic(topic);
    }

    public void deleteTopicApp() throws Exception {
        try {
            int isSuccess = topicService.deleteTopicApp(topicApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTopicApp() throws Exception {
        try {
            int isExist = 0;
            Result isSuccess = new Result();
            isExist = topicService.findTopicAppBySeq(topicApp);
            if (0 != isExist) {
                topicService.updateAddTopicAppSeq(topicApp);
                isSuccess = topicService.addTopicApp(topicApp);
            } else {
                isSuccess = topicService.addTopicApp(topicApp);
            }
            toVm(isSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String editTopic() throws Exception {
        try {
            Result result = topicService.editTopic(topic);
            toVm(result);
            return "editTopic";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTopic() throws Exception {
        Result result = new Result();
        int isSuccess = 0;
        try {
            //int isExist = findTopicBySeq();
            //if (0 != isExist) {
            //    topicService.updateAddTopicSeq(topic);
            //    isSuccess = topicService.updateTopic(topic);
            //} else {
            isSuccess = topicService.updateTopic(topic);
            //}
            if (0 != isSuccess) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
            toVm(result);
            String json = JSONUtil.serialize(result);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTopicAppById() throws Exception {
        topicService.updateDelTopicAppSeq(topicApp);
        int isSuccess = topicService.deleteTopicAppById(topicApp);
        Result result = new Result();
        if (0 != isSuccess) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        toVm(result);
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void changeActivation() throws Exception {
        try {
            topicService.updateActivation(topicApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeStatusForApp() throws IOException, JSONException {
        try {
            topicService.changeStatusForApp(topicApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public CpQualityManagementService getCpQualityManagementService() {
        return cpQualityManagementService;
    }

    public void setCpQualityManagementService(CpQualityManagementService cpQualityManagementService) {
        this.cpQualityManagementService = cpQualityManagementService;
    }
}
