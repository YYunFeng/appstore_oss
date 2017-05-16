package com.jd.cms.service.systemmaintenance.impl;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.cms.manager.systemmaintenance.AndroidDriverManager;
import com.jd.cms.service.systemmaintenance.AndroidDriverService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 下午12:16
 * To change this template use File | Settings | File Templates.
 */
public class AndroidDriverServiceImpl implements AndroidDriverService{
    private AndroidDriverManager androidDriverManager;
    private AndroidDriverManager androidDriverManagerCached;
    public AndroidDriverManager getAndroidDriverManager() {
        return androidDriverManager;
    }

    public void setAndroidDriverManager(AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public AndroidDriverManager getAndroidDriverManagerCached() {
        return androidDriverManagerCached;
    }

    public void setAndroidDriverManagerCached(AndroidDriverManager androidDriverManagerCached) {
        this.androidDriverManagerCached = androidDriverManagerCached;
    }

    public Result findAndroidDriver(int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("androidDrivers", androidDriverManagerCached.findAndroidDriver(pageIndex, pageSize));
        return result;
    }

    public void deleteAndroidDriver(AndroidDriver androidDriver) {
        androidDriverManager.deleteAndroidDriver(androidDriver);
    }

    public void createAndroidDriver(AndroidDriver androidDriver) {
        androidDriverManager.createAndroidDriver(androidDriver);
    }

    public Result findAndroidDriverById(AndroidDriver androidDriver) {
        Result result = new Result();
        result.addDefaultModel("androidDriver", androidDriverManager.findAndroidDriverById(androidDriver));
        result.setSuccess(true);

        return result;
    }

    public void updateAndroidDriver(AndroidDriver androidDriver) {
        androidDriverManager.updateAndroidDriver(androidDriver);
    }

}
