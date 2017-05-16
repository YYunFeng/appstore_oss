package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.ActivityDao;
import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
public class ActivityDaoImpl extends BaseDao implements ActivityDao {
    /**
     * 获得活动列表
     *
     * @param query
     * @return
     */
    public List<Activity> getActivityList(Query query) {
        return queryForList("ClientManager.getActivityList", query);
    }

    /**
     * 计算活动条数---用于分页
     *
     * @return
     */
    public Integer getActivityCount() {
        return (Integer) queryForObject("ClientManager.getActivityCount");
    }

    /**
     * 创建活动
     *
     * @param activity
     */
    public void createActivity(Activity activity) {
        insert("ClientManager.createActivity", activity);
    }

    /**
     * 查看是否存在该排序的活动
     *
     * @param seq
     * @return
     */
    public Integer findActivityBySeq(Integer seq) {
        return (Integer) queryForObject("ClientManager.findActivityBySeq", seq);
    }

    /**
     * 将所以排序数量加一---从中间插入一条数据
     *
     * @param seq
     */
    public void updateActivitySeq(Integer seq) {
        update("ClientManager.updateActivitySeq", seq);
    }

    /**
     * 当删除一条活动时候，所有的活动排序减一
     *
     * @param seq
     */
    public void updateDelActivitySeq(Integer seq) {
        update("ClientManager.updateDelActivitySeq", seq);
    }

    /**
     * 删除活动
     *
     * @param Id
     */
    public void deletActivity(Integer Id) {
        delete("ClientManager.deletActivity", Id);
    }

    /**
     * 更新活动上下线
     *
     * @param activity
     */
    public void updateActivityPubedStatus(Activity activity) {
        update("ClientManager.updateActivityPubedStatus", activity);
    }

    /**
     * 获得活动详情
     *
     * @param activity
     * @return
     */
    public Activity getActivityById(Activity activity) {
        return (Activity) queryForObject("ClientManager.getActivityById", activity);
    }

    /**
     * 更新活动
     *
     * @param activity
     */
    public void updateActivity(Activity activity) {
        update("ClientManager.updateActivity", activity);
    }

    public void updateActivitySeqBySeq(Activity activity) {
        update("ClientManager.updateActivitySeqBySeq", activity);
    }

    public List<PadChannel> getPadChannel() {
        return queryForList("ClientManager.getPadChannel");
    }

    public List<ActivityChannel> getActivityChannel(Integer activityId) {
        return queryForList("ClientManager.getActivityChannel", activityId);
    }

    public void deleteActivityChannel(Integer activityId) {
        delete("ClientManager.deleteActivityChannel", activityId);
    }

    public void createActivityChannel(ActivityChannel activityChannel) {
        insert("ClientManager.createActivityChannel", activityChannel);
    }
}
