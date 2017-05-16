package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.service.appManagement.NewStatisticService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;

/**
 * 新版统计
 * YYF on 2015/4/16.
 */
public class NewStatisticAction extends BaseAction {

    private NewStatisticService newStatisticService;
    private MarketStatInput marketStatInput;
    private Integer cid;

    private LoginService loginService;


    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;

    private ValidMachineStatisticsService validMachineStatisticsService;

    /**
     * 新版统计
     *
     * @return
     */
    public String newStatistic() {
        Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
        Integer cid = validMachineStatisticsService.channelId(userId);
        if (cid != null) {
            Result res = new Result();
            res.addDefaultModel("userCid", cid);
            toVm(res);
        }
        return SUCCESS;
    }

    /**
     * 新版统计--安装总量查询
     *
     * @return
     */
    public String appInstallTotal() {
        Result result = newStatisticService.appIntallTotal(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 安装总量按应用查看
     *
     * @return
     */
    public String totalByApp() {
        Result result = newStatisticService.totalByApp(marketStatInput, page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 安装总量按渠道查看
     *
     * @return
     */
    public String totalByChannel() {
        Result result = newStatisticService.totalByChannel(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 按渠道类型查看
     *
     * @return
     */
    public String channelType() {
        Result result = newStatisticService.channelType(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 查看渠道下店长和督导的安装量
     *
     * @return
     */
    public String channelBySaler() {
        Result result = newStatisticService.channelBySaler(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 查看督导或者店长下促销员的安装详情
     *
     * @return
     */
    public String channelBySalerDetails() {
        Result result = newStatisticService.channelBySalerDetails(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 查看促销员的安装的应用
     *
     * @return
     */
    public String appBySalerNo() {
        Result result = newStatisticService.appBySalerNo(marketStatInput);
        toVm(result);
        return SUCCESS;
    }

    public void setNewStatisticService(NewStatisticService newStatisticService) {
        this.newStatisticService = newStatisticService;
    }

    public MarketStatInput getMarketStatInput() {
        return marketStatInput;
    }

    public void setMarketStatInput(MarketStatInput marketStatInput) {
        this.marketStatInput = marketStatInput;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    @Override
    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }
}
