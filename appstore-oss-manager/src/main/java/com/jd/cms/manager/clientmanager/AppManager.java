

package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.AppResult;
import com.jd.common.util.PaginatedList;


/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:42
 * To change this template use File | Settings | File Templates.
 */
public interface AppManager {
    PaginatedList<AppResult> findApps(int pageIndex, int pageSize, String name);
    PaginatedList<AppResult> findAppsForTopic(int pageIndex, int pageSize, String name, String mobileGameId, String mobileSoftId);
    PaginatedList<AppResult> findAppsForModule(int pageIndex, int pageSize, String name, String categoryId);
}
