package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;
import com.jd.cms.service.appManagement.ProvinceArrStatisService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * 省办到达率统计
 */
public class ProvinceArrStatisAction extends BaseAction {

    private ProvinceArrStatisService provinceArrStatisService;
    private ProvinceArrStatisParameter provinceArrStatisParameter;
    private ValidMachineStatisticsService validMachineStatisticsService;
    private Integer metohFlag;
    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;
    private LoginService loginService;


    public String provinceArrStatis() {
        return SUCCESS;
    }

    public String provinceArrStatisTotal() {
        try {
            Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
            Integer cid = validMachineStatisticsService.channelId(userId);
            if (cid != null && cid.intValue() != 138) {
                provinceArrStatisParameter.setCid(cid);
            }
            Result result = provinceArrStatisService.provinceArrStatis(provinceArrStatisParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String provinceArrStatisByCid() {
        try {
            Result result = provinceArrStatisService.provinceArrStatisByCid(provinceArrStatisParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public String provinceArrStatisBySaler() {
        try {
            Result result = provinceArrStatisService.provinceArrStatisBySaler(provinceArrStatisParameter);
            Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
            if (userId != null && userId.intValue() == 1) {
                result.addDefaultModel("userId", userId);
            }
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public void exportProvinceArrExcel() throws IOException, JSONException {
        ExportExcelJSON exportExcelJSON = provinceArrStatisService.getCountAppExcel(provinceArrStatisParameter, metohFlag);
        String json = JSONUtil.serialize(exportExcelJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public void setProvinceArrStatisService(ProvinceArrStatisService provinceArrStatisService) {
        this.provinceArrStatisService = provinceArrStatisService;
    }


    public ProvinceArrStatisParameter getProvinceArrStatisParameter() {
        return provinceArrStatisParameter;
    }

    public void setProvinceArrStatisParameter(ProvinceArrStatisParameter provinceArrStatisParameter) {
        this.provinceArrStatisParameter = provinceArrStatisParameter;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    public Integer getMetohFlag() {
        return metohFlag;
    }

    public void setMetohFlag(Integer metohFlag) {
        this.metohFlag = metohFlag;
    }
}
