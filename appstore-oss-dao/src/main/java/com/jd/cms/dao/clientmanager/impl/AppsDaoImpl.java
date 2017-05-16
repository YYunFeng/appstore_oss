package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.AppsDao;
import com.jd.cms.domain.clientmanager.AppResult;
import com.jd.cms.domain.clientmanager.QueryApp;
import com.jd.cms.domain.clientmanager.QueryAppForCategory;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class AppsDaoImpl extends BaseDao implements AppsDao{
    public List<AppResult> findApps(Query query) {
        return queryForList("ClientManager.findAppResult",query);
    }

    public List<AppResult> findAppsForTopic(QueryApp query) {
        return queryForList("ClientManager.findAppResultForTopic",query);
    }

    public List<AppResult> findAppsForModule(QueryAppForCategory queryAppForCategory){
        return queryForList("ClientManager.findAppsForModule", queryAppForCategory);
    }

    public int findAppsCount(String name) {
        return (Integer)queryForObject("ClientManager.findAppCount",name);
    }

    public int findAppsCountForTopic(QueryApp queryApp) {
        return (Integer)queryForObject("ClientManager.findAppCountForTopic", queryApp);
    }

    public int findAppsCountForModule(QueryAppForCategory queryAppForCategory){
        return (Integer)queryForObject("ClientManager.findAppsCountForModule", queryAppForCategory);
    }
}
