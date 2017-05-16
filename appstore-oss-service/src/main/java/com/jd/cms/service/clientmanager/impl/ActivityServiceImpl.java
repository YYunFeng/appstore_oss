package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.manager.clientmanager.ActivityManager;
import com.jd.cms.manager.clientmanager.impl.ActivityManagerCachedImpl;
import com.jd.cms.service.clientmanager.ActivityService;
import com.jd.common.web.result.Result;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 下午12:12
 * To change this template use File | Settings | File Templates.
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityManager activityManager;
    private ActivityManager activityManagerCached;
    /**
     * 获得活动列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result getActivityList(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("activityList", activityManagerCached.getActivityList(pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 创建活动
     *
     * @param activity
     */
    public void createActivity(Activity activity) {
        try {
            activityManager.createActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer findActivityBySeq(Integer seq) {
        return activityManager.findActivityBySeq(seq);
    }

    public void updateActivitySeq(Integer seq) {
        try {
            activityManager.updateActivitySeq(seq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDelActivitySeq(Integer seq) {
        try {
            activityManager.updateDelActivitySeq(seq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletActivity(Integer Id, Integer seq) {
        try {
            activityManager.deletActivity(Id, seq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateActivityPubedStatus(Activity activity) {
        try {
            activityManager.updateActivityPubedStatus(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Result getActivityById(Activity activity) {
        Result result = new Result();
        try {
            result.addDefaultModel("activity", activityManager.getActivityById(activity));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateActivity(Activity activity) {
        try {
            activityManager.updateActivity(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateActivitySeqBySeq(Activity activity) {
        try {
            activityManager.updateActivitySeqBySeq(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Result activityReleanceChannel(Integer activityId) {
        Result result = new Result();
        try {
            result.addDefaultModel("padChannelList", activityManager.getPadChannel());
            result.addDefaultModel("channelActivityList", activityManager.getActivityChannel(activityId));
            result.addDefaultModel("activityId", activityId);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createActivityReleanceChannel(ActivityChannel activityChannel) {
        try {
            activityManager.createActivityReleanceChannel(activityChannel.getActivityId(), activityChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    public void setActivityManagerCached(ActivityManager activityManagerCached) {
        this.activityManagerCached = activityManagerCached;
    }
}
