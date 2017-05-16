package com.jd.cms.service.clientmanager;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:15
 * To change this template use File | Settings | File Templates.
 */
public interface TopicService {
    Result findTopicByName(String query);

    Result findTopic(int pageIndex, int pageSize, int id);

    Result findTopicByNamePage(int pageIndex, int pageSize, String topicName);

    Result findTopicByPub(int pageIndex, int pageSize, int pubedStatus);

    int updateTopicPubedStatus(Topic topic);

    int deleteTopic(Topic topic);

    int findTopicBySeq(Topic topic);

    int updateAddTopicSeq(Topic topic);

    int updateDelTopicSeq(Topic topic);

    int updateTopicSeq(Topic topic);

    int updateTopicAppSeq(TopicApp topicApp);

    Result addTopic(Topic topic);

    Result addTopicApp(TopicApp topicApp);

    Result editTopic(Topic topic);

    int deleteTopicAppById(TopicApp topicApp);

    int updateTopic(Topic topic);

    int deleteTopicApp(TopicApp topicApp);

    int findTopicAppBySeq(TopicApp topicApp);

    int updateAddTopicAppSeq(TopicApp topicApp);

    int updateDelTopicAppSeq(TopicApp topicApp);

    void updateChannelTopic(ChannelTopic channelTopic);

    Result getChannelTopic(int topicId);

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
