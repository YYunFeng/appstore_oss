package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.manager.clientmanager.AppManager;
import com.jd.cms.service.clientmanager.AppService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
public class AppServiceImpl implements AppService{
    private AppManager appManager;
    private String mobileSoftId;
    private String mobileGameId;
    private String webAppId;

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public void setAppManager(AppManager appManager) {
        this.appManager = appManager;
    }


    public Result findApps(int pageIndex, int pageSize, String name) {
        Result result = new Result();
        result.addDefaultModel("apps", appManager.findApps(pageIndex,pageSize,name));
        result.addDefaultModel("appPath", PicResolutionEnum.COVER_N5.getPrefix()+"/");
        result.addDefaultModel("IMG_N5", PicResolutionEnum.IMG_N5.getPrefix());
        result.setSuccess(true);
        return result;  
    }

    public Result findAppsForTopic(int pageIndex, int pageSize, String name, String mobileGameId, String mobileSoftId){
        Result result = new Result();
        result.addDefaultModel("apps", appManager.findAppsForTopic(pageIndex,pageSize,name,mobileGameId,mobileSoftId));
        result.addDefaultModel("appPath", PicResolutionEnum.COVER_N5.getPrefix()+"/");
        result.addDefaultModel("imgPath", PicResolutionEnum.IMG_N5.getPrefix());
        result.setSuccess(true);
        return result;
    }

    public Result findAppsByModule(int pageIndex, int pageSize, String name, String categoryId){
        Result result = new Result();
        result.addDefaultModel("apps", appManager.findAppsForModule(pageIndex, pageSize,name, categoryId));
        result.addDefaultModel("appPath", PicResolutionEnum.COVER_N5.getPrefix()+"/");
        result.setSuccess(true);
        return result;
    }

    public String getMobileSoftId() {
        return mobileSoftId;
    }

    public String getMobileGameId() {
        return mobileGameId;
    }

    public String getWebAppId() {
        return webAppId;
    }
}
