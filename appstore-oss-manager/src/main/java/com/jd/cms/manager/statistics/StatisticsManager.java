package com.jd.cms.manager.statistics;


import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsManager {

    PaginatedList<StatisticsOutput> findAllStatisticsByDate(String startDate, String endDate,Integer appType, Integer pageSize, Integer pageNum);

    PaginatedList<StatisticsOutput> findAppStatisticsByDate(Integer appId, String appName, String startDate, String endDate, Integer pageSize, Integer pageNum);

    List<StatisticsOutput> findTopAppStatisticsByDate(String startDate, String endDate,Integer appType, Integer topCount);

    Integer findAllStatisticsCount();

    Integer findNever7DaysStatisticsCount();
}
