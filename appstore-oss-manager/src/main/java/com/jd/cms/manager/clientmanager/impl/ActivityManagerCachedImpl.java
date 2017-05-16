package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.manager.clientmanager.ActivityManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-9
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class ActivityManagerCachedImpl implements ActivityManager {
    private CacheUtils cacheUtils;
    private ActivityManager activityManager;

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public PaginatedList<Activity> getActivityList(int pageIndex, int pageSize) {
        PaginatedList<Activity> activities;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }

        activities =activityManager.getActivityList(pageIndex, pageSize);
        if (0 == activities.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            activities = getActivityList(pageIndex, pageSize);

        } else {
            cacheUtils.set(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }

        return activities;
    }

    public void createActivity(Activity activity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Integer findActivityBySeq(Integer seq) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateActivitySeq(Integer seq) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateDelActivitySeq(Integer seq) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deletActivity(Integer Id, Integer seq) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateActivityPubedStatus(Activity activity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Activity getActivityById(Activity activity) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateActivity(Activity activity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateActivitySeqBySeq(Activity activity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<PadChannel> getPadChannel() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<ActivityChannel> getActivityChannel(Integer activityId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createActivityReleanceChannel(Integer activityId, ActivityChannel activityChannel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }
}
