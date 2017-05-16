package com.jd.cms.manager.clientmanager.impl;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.clientmanager.TopicAppResult;
import com.jd.cms.manager.clientmanager.TopicManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class TopicManagerCachedImpl implements TopicManager {
    private CacheUtils cacheUtils;
    private TopicManager topicManager;

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public TopicManager getTopicManager() {
        return topicManager;
    }

    public void setTopicManager(TopicManager topicManager) {
        this.topicManager = topicManager;
    }

    public List<Topic> findTopicByName(String query) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Topic findTopicById(Topic topic) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<TopicAppResult> findTopicAppByTopicId(Topic topicApp) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public PaginatedList<Topic> findTopic(int pageIndex, int pageSize, int type) {
        PaginatedList<Topic> topics;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_TOPICMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        topics = topicManager.findTopic(pageIndex, pageSize, type);
        if (0 == topics.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_TOPICMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            topics = findTopic(pageIndex, pageSize, type);

        } else {
            cacheUtils.set(CategoryConstants.CMS_TOPICMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return topics;
    }

    public PaginatedList<Topic> findTopicByNamePage(int pageIndex, int pageSize, String topicName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaginatedList<Topic> findTopicByPub(int pageIndex, int pageSize, int pubedStatus) {
        PaginatedList<Topic> topics;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_TOPICMANAGER_PUB_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        topics = topicManager.findTopicByPub(pageIndex, pageSize, pubedStatus);
        if (0 == topics.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_TOPICMANAGER_PUB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            topics = findTopicByPub(pageIndex, pageSize, pubedStatus);

        } else {
            cacheUtils.set(CategoryConstants.CMS_TOPICMANAGER_PUB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }

        return topics;
    }

    public int updateTopicPubedStatus(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteTopic(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findTopicBySeq(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findTopicAppBySeq(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddTopicSeq(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddTopicAppSeq(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelTopicSeq(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelTopicAppSeq(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopicSeq(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopicAppSeq(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int addTopic(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int addTopicApp(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteTopicApp(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteTopicAppById(TopicApp topicApp) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopic(Topic topic) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateChannelTopic(ChannelTopic channelTopic) {
        topicManager.updateChannelTopic(channelTopic);
    }

    public List<ChannelTopic> getChannelTopic(int topicId) {
        return topicManager.getChannelTopic(topicId);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateActivation(TopicApp topicApp) {
        topicManager.updateActivation(topicApp);
    }

    public void changeStatusForApp(TopicApp topicApp) {
        topicManager.changeStatusForApp(topicApp);
    }


}
