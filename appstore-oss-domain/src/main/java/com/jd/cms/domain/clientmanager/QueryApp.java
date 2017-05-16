package com.jd.cms.domain.clientmanager;

import com.jd.common.util.base.BaseQuery;


/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-10
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
public class QueryApp extends BaseQuery {
    private String mobileGameId;
    private String mobileSoftId;
    private String webAppId;

    public String getMobileGameId() {
        return mobileGameId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public String getMobileSoftId() {
        return mobileSoftId;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public String getWebAppId() {
        return webAppId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }
}
