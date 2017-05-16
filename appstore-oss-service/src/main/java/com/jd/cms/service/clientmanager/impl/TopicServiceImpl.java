package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.aliyun.AliyunService;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.manager.clientmanager.TopicManager;
import com.jd.cms.service.clientmanager.TopicService;
import com.jd.common.util.StringUtils;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:15
 * To change this template use File | Settings | File Templates.
 */
public class TopicServiceImpl implements TopicService {
    private TopicManager topicManager;
    private TopicManager topicManagerCached;

    private AliyunService aliyunService;

    public TopicManager getTopicManagerCached() {
        return topicManagerCached;
    }

    public void setTopicManagerCached(TopicManager topicManagerCached) {
        this.topicManagerCached = topicManagerCached;
    }

    public void setTopicManager(TopicManager topicManager) {
        this.topicManager = topicManager;
    }

    public Result findTopicByName(String query) {
        Result result = new Result();
        result.addDefaultModel("topics", topicManager.findTopicByName(query));
        result.setSuccess(true);
        return result;
    }

    public Result editTopic(Topic topic) {
        Result result = new Result();
        result.addDefaultModel("topicResult", topicManager.findTopicById(topic));
        result.addDefaultModel("topicAppResult", topicManager.findTopicAppByTopicId(topic));
        result.setSuccess(true);
        return result;
    }

    public int deleteTopicAppById(TopicApp topicApp) {
        return topicManager.deleteTopicAppById(topicApp);
    }

    public int updateTopic(Topic topic) {
        Boolean flag = false;
        int i = 0;
        try {
            // 上传专题图片到文件到阿里云
            if (StringUtils.isNotBlank(topic.getLogoUrl())) {
                aliyunService.copyObject("topicImage/" + topic.getLogoUrl(), "topicImage/" + topic.getLogoUrl());
                flag = true;
            }
            if (flag) {
                i = topicManager.updateTopic(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public Result findTopic(int pageIndex, int pageSize, int id) {
        Result result = new Result();
        result.addDefaultModel("topics", topicManagerCached.findTopic(pageIndex, pageSize, id));
        result.setSuccess(true);
        return result;
    }

    public Result findTopicByNamePage(int pageIndex, int pageSize, String topicName) {
        Result result = new Result();
        result.addDefaultModel("topics", topicManager.findTopicByNamePage(pageIndex, pageSize, topicName));
        result.setSuccess(true);
        return result;
    }

    public Result findTopicByPub(int pageIndex, int pageSize, int pubedStatus) {
        Result result = new Result();
        result.addDefaultModel("topics", topicManagerCached.findTopicByPub(pageIndex, pageSize, pubedStatus));
        result.addDefaultModel("path", PicResolutionEnum.IMG_N0.getPrefix());
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopicPubedStatus(Topic topic) {
        return topicManager.updateTopicPubedStatus(topic);
    }

    public int deleteTopic(Topic topic) {
        return topicManager.deleteTopic(topic);
    }

    public int findTopicBySeq(Topic topic) {
        return topicManager.findTopicBySeq(topic);
    }

    public int updateAddTopicSeq(Topic topic) {
        return topicManager.updateAddTopicSeq(topic);
    }

    public int updateDelTopicSeq(Topic topic) {
        return topicManager.updateDelTopicSeq(topic);
    }

    public int updateTopicSeq(Topic topic) {
        return topicManager.updateTopicSeq(topic);
    }

    public int updateTopicAppSeq(TopicApp topicApp) {
        return topicManager.updateTopicAppSeq(topicApp);
    }

    public Result addTopic(Topic topic) {
        Result result = new Result();
        try {
            try {
                // 上传专题图片到文件到阿里云
                if (StringUtils.isNotBlank(topic.getLogoUrl())) {
                    aliyunService.copyObject("topicImage/" + topic.getLogoUrl(), "topicImage/" + topic.getLogoUrl());
                }
                result.setSuccess(true);
            } catch (Exception e) {
                result.setSuccess(false);
                e.printStackTrace();
            }
            if (result.getSuccess()) {
                int id = topicManager.addTopic(topic);
                result.addDefaultModel("topicId", id);
            }
            result.setSuccess(true);
        } catch (Exception e) {
            result.setResultCode("system.error");
        }
        return result;
    }

    public Result addTopicApp(TopicApp topicApp) {
        Result result = new Result();
        try {
            int id = topicManager.addTopicApp(topicApp);
            result.addDefaultModel("id", id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setResultCode("system.error");
        }
        return result;
    }

    public int deleteTopicApp(TopicApp topicApp) {
        return topicManager.deleteTopicApp(topicApp);
    }

    public int findTopicAppBySeq(TopicApp topicApp) {
        return topicManager.findTopicAppBySeq(topicApp);
    }

    public int updateAddTopicAppSeq(TopicApp topicApp) {
        return topicManager.updateAddTopicAppSeq(topicApp);
    }

    public int updateDelTopicAppSeq(TopicApp topicApp) {
        return topicManager.updateDelTopicAppSeq(topicApp);
    }

    public void updateChannelTopic(ChannelTopic channelTopic) {
        topicManager.updateChannelTopic(channelTopic);
    }

    public Result getChannelTopic(int topicId) {
        Result result = new Result();
        try {
            result.addDefaultModel("ChannelTopics", topicManager.getChannelTopic(topicId));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateActivation(TopicApp topicApp) {
        topicManager.updateActivation(topicApp);
    }

    public void changeStatusForApp(TopicApp topicApp) {
        topicManager.changeStatusForApp(topicApp);
    }


    public void setAliyunService(AliyunService aliyunService) {
        this.aliyunService = aliyunService;
    }
}
