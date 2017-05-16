package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.AppsDao;
import com.jd.cms.domain.clientmanager.AppResult;
import com.jd.cms.domain.clientmanager.QueryApp;
import com.jd.cms.domain.clientmanager.QueryAppForCategory;
import com.jd.cms.manager.clientmanager.AppManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */
public class AppManagerImpl extends BaseManager implements AppManager{
    private AppsDao appsDao;

    public void setAppsDao(AppsDao appsDao) {
        this.appsDao = appsDao;
    }


    public PaginatedList<AppResult> findApps(int pageIndex, int pageSize, String name) {
        BaseQuery baseQuery = new BaseQuery();
        if(0 ==  pageIndex){
            pageIndex = 1;
        }
        int totalItem = appsDao.findAppsCount(name);
        PaginatedList<AppResult> apps = new PaginatedArrayList<AppResult>(pageIndex,pageSize);
        apps.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        baseQuery.setValue(name);
        List<AppResult> app = appsDao.findApps(baseQuery);
        apps.addAll(app);
        return apps;  
    }

    public PaginatedList<AppResult> findAppsForTopic(int pageIndex, int pageSize, String name, String mobileGameId, String mobileSoftId) {
        QueryApp baseQuery = new QueryApp();
        if(0 ==  pageIndex){
            pageIndex = 1;
        }
        baseQuery.setValue(name);
        baseQuery.setMobileGameId(mobileGameId);
        baseQuery.setMobileSoftId(mobileSoftId);
        int totalItem = appsDao.findAppsCountForTopic(baseQuery);
        PaginatedList<AppResult> apps = new PaginatedArrayList<AppResult>(pageIndex,pageSize);
        apps.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        List<AppResult> app = appsDao.findAppsForTopic(baseQuery);
        apps.addAll(app);
        return apps;
    }

    public PaginatedList<AppResult> findAppsForModule(int pageIndex, int pageSize, String name, String categoryId) {
        QueryAppForCategory baseQuery = new QueryAppForCategory();
        if(0 ==  pageIndex){
            pageIndex = 1;
        }
        baseQuery.setName(name);
        baseQuery.setCategoryId(categoryId);
        int totalItem = appsDao.findAppsCountForModule(baseQuery);
        PaginatedList<AppResult> apps = new PaginatedArrayList<AppResult>(pageIndex,pageSize);
        apps.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        List<AppResult> app = appsDao.findAppsForModule(baseQuery);
        apps.addAll(app);
        return apps;
    }
}
