package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachinesAction extends BaseAction {
    private ValidMachineStatisticsService validMachineStatisticsService;

    private IncomeParameter incomeParameter;

    private Integer flag;

    private LoginService loginService;


    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;


    public String validMachines() {
        return SUCCESS;
    }

    public String validMachinesContent() {
        try {
            if (incomeParameter == null) {
                incomeParameter = new IncomeParameter();
            }
            Result result = validMachineStatisticsService.totalIncome(incomeParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 按渠道查看
     *
     * @return
     */
    public String getChannelMachines() {
        try {
            if (incomeParameter == null) {
                incomeParameter = new IncomeParameter();
            }
            Result result = validMachineStatisticsService.incomeByChannel(incomeParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String validMachinesByTime() {
        try {
            if (incomeParameter != null) {
                Result result = validMachineStatisticsService.incomeByTime(incomeParameter);
                toVm(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String validMachinesBySaler() {
        try {
            if (incomeParameter != null) {
                Result result = validMachineStatisticsService.incomeBySaler(incomeParameter);
                toVm(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void validMachineExcel() throws JSONException, IOException {
        ValidMachineJSON validMachineJSON = null;
        try {
            if (incomeParameter != null && incomeParameter.getExcelFlag().intValue() == 1) {
                Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
                Integer cid = validMachineStatisticsService.channelId(userId);
                if (cid != null && cid.intValue() != 138) {
                    incomeParameter.setCid(cid);
                }
            } else if (incomeParameter.getExcelFlag().intValue() == 2) { //    如果excelFlag为2,那么导出的数据为所有促销的数据
                flag = 4;
            }
            validMachineJSON = validMachineStatisticsService.validMachineExcel(incomeParameter, flag);
        } catch (Exception e) {
            validMachineJSON.setStatus(0);
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(validMachineJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 省办统计
     *
     * @return
     */
    public String provinceStatis() {
        Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
        Integer cid = validMachineStatisticsService.channelId(userId);
        if (cid != null) {
            Result res = new Result();
            res.addDefaultModel("cid", cid);
            toVm(res);
        }
        return SUCCESS;
    }

    /**
     * 省办统计信息
     *
     * @return
     */
    public String provinceStatisContent() {
        try {
            Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
            Integer cid = validMachineStatisticsService.channelId(userId);
            if (cid != null && cid.intValue() != 138) {
                incomeParameter.setCid(cid);
            }
            Result result = validMachineStatisticsService.incomeByChannel(incomeParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 省办统计信息--按时间查看
     *
     * @return
     */
    public String provinceStatisByTime() {
        Result result = validMachineStatisticsService.incomeByTime(incomeParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 省办统计信息--按促销员查看
     *
     * @return
     */
    public String provinceStatisBySaler() {
        Result result = validMachineStatisticsService.incomeBySaler(incomeParameter);
        toVm(result);
        return SUCCESS;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public IncomeParameter getIncomeParameter() {
        return incomeParameter;
    }

    public void setIncomeParameter(IncomeParameter incomeParameter) {
        this.incomeParameter = incomeParameter;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }
}
