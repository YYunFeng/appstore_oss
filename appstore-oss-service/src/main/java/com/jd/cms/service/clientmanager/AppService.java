package com.jd.cms.service.clientmanager;

import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
public interface AppService {
    Result findApps(int pageIndex, int pageSize, String name);

    Result findAppsForTopic(int pageIndex, int pageSize, String name, String mobileGameId, String mobileSoftId);

    Result findAppsByModule(int pageIndex, int pageSize, String name, String categoryId);

    String getMobileSoftId();

    String getMobileGameId();

    String getWebAppId();
}
