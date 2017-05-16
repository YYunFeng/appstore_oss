package com.jd.cms.service.statistics.impl;

import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.cms.manager.statistics.StatisticsManager;
import com.jd.cms.service.statistics.StatisticsService;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsManager statisticsManager;

    /**
     * 按日期段查询全站下载总量
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param pageSize 每页显示数量
     * @param pageNum 页号
     * @return
     */
    public Result findAllStatisticsByDate(String startDate, String endDate,Integer appType,Integer pageSize, Integer pageNum) {
        Result result = new Result();
        result.addDefaultModel("result", statisticsManager.findAllStatisticsByDate(startDate, endDate,appType,pageSize, pageNum));
        return result;
    }

    /**
     * 按日期段查询应用下载总量
     * @param appId 应用编号
     * @param appName 应用名称
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param pageSize 每页显示数量
     * @param pageNum 页号
     * @return
     */
    public Result findAppStatisticsByDate(Integer appId, String appName, String startDate, String endDate, Integer pageSize, Integer pageNum) {
        Result result = new Result();
        result.addDefaultModel("result", statisticsManager.findAppStatisticsByDate(appId, appName, startDate, endDate, pageSize, pageNum));
        return result;
    }

    /**
     * 按日期段查询TOP应用下载总量
     * @param startDate 开日日期
     * @param endDate 结束日期
     * @param topCount TOP数量
     * @return
     */
    public Result findTopAppStatisticsByDate(String startDate, String endDate,Integer appType,Integer topCount) {
        Result result = new Result();
        result.addDefaultModel("result", statisticsManager.findTopAppStatisticsByDate(startDate, endDate,appType, topCount));
        return result;
    }

    /**查询全站总下载量以及过去7天全站总下载量
     *
     * @return
     */
    public StatisticsOutput findAllCountAndNever7DaysCount() {
        StatisticsOutput statisticsOutput = new StatisticsOutput();
        statisticsOutput.setAllStatisticsCount(statisticsManager.findAllStatisticsCount());
        statisticsOutput.setNever7DaysStatisticsCount(statisticsManager.findNever7DaysStatisticsCount());
        return statisticsOutput;
    }

    public void setStatisticsManager(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
    }
}
