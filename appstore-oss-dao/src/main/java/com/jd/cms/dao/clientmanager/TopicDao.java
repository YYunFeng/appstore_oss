package com.jd.cms.dao.clientmanager;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.clientmanager.TopicAppResult;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
public interface TopicDao {
    /*
     *通过专题名查找专题
     */
    List<Topic> findTopicByName(String query);

    List<Topic> findTopicByNamePage(Query query);

    int findTopicCount(Query query);

    /*
     * 通过Id查找专题信息
     */
    Topic findTopicById(Topic topic);

    /*
     * 通过专题Id查找专题内容表中的关联信息
     */
    List<TopicAppResult> findTopicAppByTopicId(Topic topic);

    /*
     *查找所有专题
     */
    List<Topic> findTopic(Query query);

    /*
     *根据发布状态检索专题
     */
    List<Topic> findTopicByPub(Query query);

    /*
     *获取专题的总条数
     */
    int getTopicCount(int id);

    /*
     *获取此发布状态下的专题总数目
     */
    int getTopicCountByPub(Query query);

    /**
     * 更新专题的上下线状态
     */
    void updateTopicPubedStatus(Topic topic);

    /**
     * 从推荐列表中移除下线的专题(不含手机、PAD)
     */
    void removeTopicFromRecommend(Topic topic);

    /**
     * 从推荐列表中重置手机、PAD下线的专题记录
     */
    void resetTopicFromRecommend(Topic topic);

    /**
     * 通过序号查找是否存在数据
     *
     * @param topic
     * @return
     */
    int findTopicBySeq(Topic topic);

    /*
     * 通过序号查找专题详情表
     */
    int findTopicAppBySeq(TopicApp topicApp);

    /**
     * 删除专题
     *
     * @param topic
     */
    void deleteTopic(Topic topic);

    /**
     * 更新排序
     *
     * @param topic
     */
    void updateTopicSeq(Topic topic);

    void updateTopicAppSeq(TopicApp topicApp);

    /**
     * 添加专题时更新其他专题的排序
     *
     * @param topic
     */
    void updateAddTopicSeq(Topic topic);

    void updateAddTopicAppSeq(TopicApp topicApp);

    /**
     * 删除专题时更新其他专题的排序
     *
     * @param topic
     */
    void updateDelTopicSeq(Topic topic);

    void updateDelTopicAppSeq(TopicApp topicApp);

    /*
     * 添加专题
     */
    void addTopic(Topic topic);

    /*
     * 添加专题内容表
     */
    void addTopicApp(TopicApp topicApp);

    /*
     * 删除专题时专题内容表中的关联数据也删除
     */
    void deleteTopicApp(TopicApp topicApp);

    void deleteTopicAppById(TopicApp topicApp);

    void updateTopic(Topic topic);

    void createChannelTopic(ChannelTopic channelTopic);

    void deleteChannelTopic(int topicId);

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
