package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.cms.service.statistics.StatisticsService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-11-15
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
public class AppStatisticsAction extends BaseAction {
    private StatisticsService statisticsService;
    private String starTime;
    private String endTime;
    private int pageSize = 30;
    private Integer appId;
    private String appName;
    private Integer topCount;
    private Integer appType;

    public String appStatistics() {
        return "INIT";
    }

    public void getDownload() throws JSONException, IOException {
        StatisticsOutput statisticsOutput = statisticsService.findAllCountAndNever7DaysCount();
        String json = JSONUtil.serialize(statisticsOutput);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public String allStatisticsCount() {
        Result result = statisticsService.findAllStatisticsByDate(starTime, endTime,appType, pageSize, page);
        toVm(result);
        return "allStatisticsCount";
    }

    public String findAppStatisticsByDate() {
        Result result = statisticsService.findAppStatisticsByDate(appId, appName, starTime, endTime, pageSize, page);
        toVm(result);
        return "findAppStatistics";
    }

    public String findTopAppStatisticsByDate() {
        Result result = statisticsService.findTopAppStatisticsByDate(starTime, endTime,appType,topCount);
        toVm(result);
        return "findTopAppStatistics";
    }

    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getTopCount() {
        return topCount;
    }

    public void setTopCount(Integer topCount) {
        this.topCount = topCount;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}
