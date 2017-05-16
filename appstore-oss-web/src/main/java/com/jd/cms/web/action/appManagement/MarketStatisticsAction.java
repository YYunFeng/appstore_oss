package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.service.appManagement.MarketStatisticsService;
import com.jd.cms.util.CreateInstallLogExcel;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 上午11:51
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatisticsAction extends BaseAction {
    private MarketStatisticsService marketStatisticsService;
    private CreateInstallLogExcel createInstallLogExcel;
    private MarketStatInput marketStatInput;
    private String startTime;
    private String endTime;
    private Integer appId;
    private Integer channelId;
    private String saler;
    private Integer flag; // 0:离线应用  1：在线应用
    private Integer methodFlag;

    public String marketStatistics() {
        return "INIT";
    }

    /**
     * 统计离线应用的总安装量
     *
     * @return
     */
    public String getMarketStat() {
        Result result = marketStatisticsService.getMarketStat(startTime, endTime, flag);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 按应用查看
     *
     * @return
     */
    public String statByApp() {
        try{
            Result result = marketStatisticsService.statByApp(startTime, endTime, page, PAGE_SIZE, flag, 0);
            toVm(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 某个应用按渠道统计安装次数
     * 离线应用
     *
     * @return
     */
    public String appGetMarketStatByChannel() {
        Result result = marketStatisticsService.appGetMarketStatByChannel(startTime, endTime, appId, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 应用每个渠道下按促销员查看
     *
     * @return
     */
    public String appStatsChannelBySaler() {
        Result result = marketStatisticsService.appStatsChannelBySaler(startTime, endTime, appId, channelId, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 按渠道查看
     *
     * @return
     */
    public String statByChannel() {
        Result result = marketStatisticsService.statByChannel(startTime, endTime, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 离线应用 渠道下按应用查看
     *
     * @return
     */
    public String statChannelByApps() {
        Result result = marketStatisticsService.statChannelByApps(startTime, endTime, channelId, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 渠道下按促销员查看安装次数
     *
     * @return
     */
    public String channlStatBySaler() {
        Result result = marketStatisticsService.channlStatBySaler(startTime, endTime, channelId, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 促销员按应用查看安装次数
     *
     * @return
     */
    public String salerStatsByApps() {
        Result result = marketStatisticsService.salerStatsByApps(startTime, endTime, channelId, saler, page, PAGE_SIZE, flag, 0);
        toVm(result);
        return SUCCESS;
    }


    public void exportExcel() throws IOException, JSONException {
        ExportExcelJSON exportExcelJSON = new ExportExcelJSON();
        try {
            exportExcelJSON.setStatus(1);
            exportExcelJSON.setExcelDownAddress(createInstallLogExcel.CreateInstallLogExcel(startTime, endTime, appId, channelId, saler, methodFlag, flag));
            exportExcelJSON.setMess("导出报表成功");
        } catch (Exception e) {
            exportExcelJSON.setStatus(0);
            exportExcelJSON.setMess(e.getMessage());
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(exportExcelJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setMarketStatisticsService(MarketStatisticsService marketStatisticsService) {
        this.marketStatisticsService = marketStatisticsService;
    }

    public MarketStatInput getMarketStatInput() {
        return marketStatInput;
    }

    public void setMarketStatInput(MarketStatInput marketStatInput) {
        this.marketStatInput = marketStatInput;
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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public void setCreateInstallLogExcel(CreateInstallLogExcel createInstallLogExcel) {
        this.createInstallLogExcel = createInstallLogExcel;
    }

    public Integer getMethodFlag() {
        return methodFlag;
    }

    public void setMethodFlag(Integer methodFlag) {
        this.methodFlag = methodFlag;
    }
}
