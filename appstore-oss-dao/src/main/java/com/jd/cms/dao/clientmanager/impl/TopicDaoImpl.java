package com.jd.cms.dao.clientmanager.impl;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.dao.clientmanager.TopicDao;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.clientmanager.TopicAppResult;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
public class TopicDaoImpl extends BaseDao implements TopicDao {
    public List<Topic> findTopicByName(String query) {
        return queryForList("ClientManager.findTopicResultByName", query);
    }

    public List<Topic> findTopicByNamePage(Query query) {
        return queryForList("ClientManager.findTopicResultByNamePage", query);
    }

    public int findTopicCount(Query query) {
        return (Integer) queryForObject("ClientManager.findTopicCount", query);
    }

    public Topic findTopicById(Topic topic) {
        return (Topic) queryForObject("ClientManager.findTopicById", topic);
    }

    public List<TopicAppResult> findTopicAppByTopicId(Topic topicApp) {
        return queryForList("ClientManager.findTopicAppByTopicId", topicApp);
    }

    public List<Topic> findTopic(Query query) {
        return queryForList("ClientManager.findTopicResult", query);
    }

    public List<Topic> findTopicByPub(Query query) {
        return queryForList("ClientManager.findTopicResultByPub", query);
    }

    public int getTopicCount(int id) {
        return (Integer) queryForObject("ClientManager.getTopicCount", id);
    }

    public int getTopicCountByPub(Query query) {
        return (Integer) queryForObject("ClientManager.getTopicCountByPub", query);
    }

    public void updateTopicPubedStatus(Topic topic) {
        update("ClientManager.updateTopicPubedStatu", topic);
    }

    /**
     * 从推荐列表中移除下线的专题
     */
    public void removeTopicFromRecommend(Topic topic) {
        update("ClientManager.removeTopicFromRecommend", topic);
    }

    /**
     * 从推荐列表中重置手机、PAD下线的专题记录
     */
    public void resetTopicFromRecommend(Topic topic) {
        update("ClientManager.resetTopicFromRecommend", topic);
    }

    public int findTopicBySeq(Topic topic) {
        return (Integer) queryForObject("ClientManager.findTopicBySeq", topic);
    }

    public int findTopicAppBySeq(TopicApp topicApp) {
        return (Integer) queryForObject("ClientManager.findTopicAppBySeq", topicApp);
    }

    public void deleteTopic(Topic topic) {
        delete("ClientManager.deleteTopic", topic);
    }

    public void updateTopicSeq(Topic topic) {
        update("ClientManager.updateTopicSeq", topic);
    }

    public void updateTopicAppSeq(TopicApp topicApp) {
        update("ClientManager.updateTopicAppSeq", topicApp);
    }

    public void updateAddTopicSeq(Topic topic) {
        update("ClientManager.updateAddTopicSeq", topic);
    }

    public void updateAddTopicAppSeq(TopicApp topicApp) {
        update("ClientManager.updateAddTopicAppSeq", topicApp);
    }

    public void updateDelTopicSeq(Topic topic) {
        update("ClientManager.updateDelTopicSeq", topic);
    }

    public void updateDelTopicAppSeq(TopicApp topicApp) {
        update("ClientManager.updateDelTopicAppSeq", topicApp);
    }

    public void addTopic(Topic topic) {
        insert("ClientManager.addTopic", topic);
    }

    public void addTopicApp(TopicApp topicApp) {
        insert("ClientManager.addTopicApp", topicApp);
    }

    public void deleteTopicApp(TopicApp topicApp) {
        delete("ClientManager.deleteTopicApp", topicApp);
    }

    public void deleteTopicAppById(TopicApp topicApp) {
        delete("ClientManager.deleteTopicAppById", topicApp);
    }

    public void updateTopic(Topic topic) {
        update("ClientManager.updateTopic", topic);
    }

    public void createChannelTopic(ChannelTopic channelTopic) {
        insert("ClientManager.createChannelTopic", channelTopic);
    }

    public void deleteChannelTopic(int topicId) {
        delete("ClientManager.deleteChannelTopic", topicId);
    }

    public List<ChannelTopic> getChannelTopic(int topicId) {
        return queryForList("ClientManager.getChannelTopic", topicId);
    }

    public void updateActivation(TopicApp topicApp) {
        update("ClientManager.updateActivation", topicApp);
    }

    public void changeStatusForApp(TopicApp topicApp) {
        try {
            update("ClientManager.changeStatusForApp", topicApp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
