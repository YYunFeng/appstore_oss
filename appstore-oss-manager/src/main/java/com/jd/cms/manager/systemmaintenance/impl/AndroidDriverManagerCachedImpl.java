package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.systemmaintenance.AndroidDriverManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 下午12:09
 * To change this template use File | Settings | File Templates.
 */
public class AndroidDriverManagerCachedImpl implements AndroidDriverManager {
    private AndroidDriverManager androidDriverManager;
    private CacheUtils cacheUtils;

    public AndroidDriverManager getAndroidDriverManager() {
        return androidDriverManager;
    }

    public void setAndroidDriverManager(AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public PaginatedList<AndroidDriver> findAndroidDriver(int pageIndex, int pageSize) {
        PaginatedList<AndroidDriver> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_ANDROIDDRIVERMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        paginatedList = androidDriverManager.findAndroidDriver(pageIndex, pageSize);
        if (0 == paginatedList.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_ANDROIDDRIVERMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            paginatedList = findAndroidDriver(pageIndex, pageSize);

        } else {
            cacheUtils.set(CategoryConstants.CMS_ANDROIDDRIVERMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return paginatedList;
    }

    public void deleteAndroidDriver(AndroidDriver androidDriver) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createAndroidDriver(AndroidDriver androidDriver) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public AndroidDriver findAndroidDriverById(AndroidDriver androidDriver) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateAndroidDriver(AndroidDriver androidDriver) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
