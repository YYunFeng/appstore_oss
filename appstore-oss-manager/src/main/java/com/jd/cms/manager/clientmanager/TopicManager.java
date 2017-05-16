package com.jd.cms.manager.clientmanager;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.clientmanager.TopicAppResult;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:11
 * To change this template use File | Settings | File Templates.
 */
public interface TopicManager {
    List<Topic> findTopicByName(String query);

    Topic findTopicById(Topic topic);

    List<TopicAppResult> findTopicAppByTopicId(Topic topicApp);

    PaginatedList<Topic> findTopic(int pageIndex, int pageSize, int type);

    PaginatedList<Topic> findTopicByNamePage(int pageIndex, int pageSize, String topicName);

    PaginatedList<Topic> findTopicByPub(int pageIndex, int pageSize, int pubedStatus);

    int updateTopicPubedStatus(Topic topic);

    int deleteTopic(Topic topic);

    int findTopicBySeq(Topic topic);

    int findTopicAppBySeq(TopicApp topicApp);

    int updateAddTopicSeq(Topic topic);

    int updateAddTopicAppSeq(TopicApp topicApp);

    int updateDelTopicSeq(Topic topic);

    int updateDelTopicAppSeq(TopicApp topicApp);

    int updateTopicSeq(Topic topic);

    int updateTopicAppSeq(TopicApp topicApp);

    int addTopic(Topic topic);

    int addTopicApp(TopicApp topicApp);

    int deleteTopicApp(TopicApp topicApp);

    int deleteTopicAppById(TopicApp topicApp);

    int updateTopic(Topic topic);

    void updateChannelTopic(ChannelTopic channelTopic);

    List<ChannelTopic> getChannelTopic(int topicId);

    /**
     * 修改激活状态
     *
     * @param topicApp
     */
    void updateActivation(TopicApp topicApp);

    /**
     * 修改专题下应用的上下线状态
     *
     * @param topicApp
     */
    void changeStatusForApp(TopicApp topicApp);

}
