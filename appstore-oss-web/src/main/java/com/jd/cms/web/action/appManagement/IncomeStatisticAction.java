package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.service.appManagement.IncomeStatisticService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * YYF on 2015/5/19.
 */
public class IncomeStatisticAction extends BaseAction {

    private IncomeStatisticService incomeStatisticService;
    private ValidMachineStatisticsService validMachineStatisticsService;
    private IncomeParameter incomeParameter;

    private LoginService loginService;
    private Integer flag;


    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;

    public String incomeStatistic() {
        Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
        Integer cid = validMachineStatisticsService.channelId(userId);
        Result result = new Result();
        result.addDefaultModel("cid", cid);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 各省份结算统计
     *
     * @return
     */
    public String incomeStatisticContent() {
        Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
        Integer cid = validMachineStatisticsService.channelId(userId);
        if (cid != null && cid.intValue() != 138) {
            incomeParameter.setCid(cid);
        }
        Result result = incomeStatisticService.provinceIncomeStatistic(incomeParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 按渠道类型查看
     *
     * @return
     */
    public String incomeStatisticChannelType() {
        Result result = incomeStatisticService.incomeStatisticChannelType(incomeParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 按督导或者店长查看
     *
     * @return
     */
    public String incomeStatisticSaler() {
        Result result = incomeStatisticService.incomeSaler(incomeParameter);
        toVm(result);
        return SUCCESS;
    }


    /**
     * 按店员查看
     *
     * @return
     */
    public String incomeStatisticBySalerDetails() {
        Result result = incomeStatisticService.incomeStatisticBySalerDetails(incomeParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 导出EXCEL文件
     *
     * @throws JSONException
     * @throws IOException
     */
    public void incomeStatisExcel() throws JSONException, IOException {
        ValidMachineJSON validMachineJSON = null;
        try {
            if (incomeParameter != null && incomeParameter.getExcelFlag().intValue() == 1) {
                Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
                Integer cid = validMachineStatisticsService.channelId(userId);
                if (cid != null && cid.intValue() != 138) {
                    incomeParameter.setCid(cid);
                }
            } else if (incomeParameter.getExcelFlag().intValue() == 2) { //    如果excelFlag为2,那么导出的数据为所有促销的数据
                flag = 5;
            }
            validMachineJSON = incomeStatisticService.exportExcel(incomeParameter, flag);
        } catch (Exception e) {
            validMachineJSON.setStatus(0);
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(validMachineJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public void setIncomeStatisticService(IncomeStatisticService incomeStatisticService) {
        this.incomeStatisticService = incomeStatisticService;
    }

    public IncomeParameter getIncomeParameter() {
        return incomeParameter;
    }

    public void setIncomeParameter(IncomeParameter incomeParameter) {
        this.incomeParameter = incomeParameter;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
