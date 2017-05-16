package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public interface ActivityDao {
    /**
     * 获得活动列表
     *
     * @return
     */
    List<Activity> getActivityList(Query query);

    /**
     * 计算活动条数
     *
     * @return
     */
    Integer getActivityCount();

    /**
     * 创建活动项
     *
     * @param activity
     */
    void createActivity(Activity activity);

    /**
     * 查看是否存在该排序的活动
     *
     * @param seq
     * @return
     */
    Integer findActivityBySeq(Integer seq);

    /**
     * 将所以排序数量加一---从中间插入一条数据
     *
     * @param seq
     */
    void updateActivitySeq(Integer seq);

    /**
     * 当删除一条活动时候，所有的活动排序减一
     *
     * @param seq
     */
    void updateDelActivitySeq(Integer seq);

    /**
     * 删除活动
     *
     * @param Id
     */
    void deletActivity(Integer Id);

    /**
     * 更新活动上下线
     *
     * @param activity
     */
    void updateActivityPubedStatus(Activity activity);

    /**
     * 得到活动详情
     *
     * @param activity
     * @return
     */
    Activity getActivityById(Activity activity);

    /**
     * 更新活动详情
     *
     * @param activity
     */
    void updateActivity(Activity activity);

    /**
     * 修改排序
     *
     * @param activity
     */
    void updateActivitySeqBySeq(Activity activity);

    /**
     * 取得渠道列表
     *
     * @return
     */
    List<PadChannel> getPadChannel();

    /**
     * 得到活动关联渠道信息
     *
     * @return
     */
    List<ActivityChannel> getActivityChannel(Integer activityId);

    /**
     * 删除关联渠道活动信息
     *
     * @param activityId
     */
    void deleteActivityChannel(Integer activityId);

    /**
     * 创建活动关联渠道信息
     *
     * @param activityChannel
     */
    void createActivityChannel(ActivityChannel activityChannel);
}
