
package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.AppResult;
import com.jd.cms.domain.clientmanager.QueryApp;
import com.jd.cms.domain.clientmanager.QueryAppForCategory;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:31
 * To change this template use File | Settings | File Templates.
 */
public interface AppsDao {
    /**
     * 根据应用名称和上下线状态查找相应应用
     * @param query
     * @return
     */
    List<AppResult> findApps(Query query);

    /**
     * 专题关联应用时搜索应用
     * @param queryApp
     * @return
     */
    List<AppResult> findAppsForTopic(QueryApp queryApp);

    /**
     * 按区块搜索相应的应用
     * @param queryAppForCategory
     * @return
     */
    List<AppResult> findAppsForModule(QueryAppForCategory queryAppForCategory);

    int findAppsCount(String name);
    int findAppsCountForTopic(QueryApp queryApp);
    int findAppsCountForModule(QueryAppForCategory queryAppForCategory);
}
