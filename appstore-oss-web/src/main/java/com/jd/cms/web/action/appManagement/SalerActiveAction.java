package com.jd.cms.web.action.appManagement;

import com.jd.cms.service.appManagement.SalerActiveService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;

/**
 * Created by YYF on 14-5-9.
 */
public class SalerActiveAction extends BaseAction {

    private String startTime;
    private String endTime;
    private SalerActiveService salerActiveService;
    private LoginService loginService;
    private ValidMachineStatisticsService validMachineStatisticsService;


    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;


    public String salerActive() {
        return SUCCESS;
    }


    public String salerActiveContent() {
        try {
            Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
            Integer cid = validMachineStatisticsService.channelId(userId);
            Result result = salerActiveService.salerActive(page, PAGE_SIZE, startTime, endTime, cid);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setSalerActiveService(SalerActiveService salerActiveService) {
        this.salerActiveService = salerActiveService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }
}
