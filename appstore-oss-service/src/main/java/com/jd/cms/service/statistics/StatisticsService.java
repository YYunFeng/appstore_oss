package com.jd.cms.service.statistics;


import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.common.web.result.Result;


/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsService {

    /**
     * 按日期段查询全站下载总量
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param pageSize  每页显示数量
     * @param pageNum   页号
     * @return
     */
    Result findAllStatisticsByDate(String startDate, String endDate,Integer appType, Integer pageSize, Integer pageNum);

    /**
     * 按日期段查询应用下载总量
     *
     * @param appId     应用编号
     * @param appName   应用名称
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param pageSize  每页显示数量
     * @param pageNum   页号
     * @return
     */
    Result findAppStatisticsByDate(Integer appId, String appName, String startDate, String endDate, Integer pageSize, Integer pageNum);

    /**
     * 按日期段查询TOP应用下载总量
     *
     * @param startDate 开日日期
     * @param endDate   结束日期
     * @param topCount  TOP数量
     * @return
     */
    Result findTopAppStatisticsByDate(String startDate, String endDate,Integer appType, Integer topCount);


    /**
     * 查询全站总下载量以及过去7天全站总下载量
     *
     * @return
     */
    StatisticsOutput findAllCountAndNever7DaysCount();
}
