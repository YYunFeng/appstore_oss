package com.jd.cms.web.action.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.cms.service.systemmaintenance.AndroidDriverService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class DriverManagerAction extends BaseAction {
    private AndroidDriverService androidDriverService;
    private AndroidDriver androidDriver;
    private String url;
    private JssAppManager jssAppManager;


    public String findAndroidDriver() throws Exception {
        Result result = null;
        try {
            result = androidDriverService.findAndroidDriver(page, PAGE_SIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        toVm(result);
        return "androidDriverList";
    }

    public void updateAndroidDriver() throws Exception{
        androidDriverService.updateAndroidDriver(androidDriver);
    }

    public String addAndroidDriver() throws Exception{
        return "addAndroidDriver";
    }

    public String findAndroidDriverById() throws Exception{

        Result result = androidDriverService.findAndroidDriverById(androidDriver);
        toVm(result);
        return "editAndroidDriver";
    }

    public void downloadDriver() throws Exception{
        try {
            String token = jssAppManager.getToken();
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(url+"?token="+token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doAddAndroidDriver() throws Exception{
        androidDriverService.createAndroidDriver(androidDriver);
    }

    public void deleteAndroidDriver() throws Exception{
        androidDriverService.deleteAndroidDriver(androidDriver);
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public AndroidDriverService getAndroidDriverService() {
        return androidDriverService;
    }

    public void setAndroidDriverService(AndroidDriverService androidDriverService) {
        this.androidDriverService = androidDriverService;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JssAppManager getJssAppManager() {
        return jssAppManager;
    }

    public void setJssAppManager(JssAppManager jssAppManager) {
        this.jssAppManager = jssAppManager;
    }
}
