package com.jd.cms.dao.statistics;

import com.jd.cms.domain.statistics.StatisticsInput;
import com.jd.cms.domain.statistics.StatisticsOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午2:34
 * To change this template use File | Settings | File Templates.
 */
public interface StatisticsDao {

    Integer findNever7DaysStatistics();

    Integer findAllStatistics();

    List<StatisticsOutput> findAllStatisticsByDate(StatisticsInput statisticsInput);

    Integer findAllStatisticsByDateCount(StatisticsInput statisticsInput);

    List<StatisticsOutput> findAppStatisticsByDate(StatisticsInput statisticsInput);

    Integer findAppStatisticsByDateCount(StatisticsInput statisticsInput);

    List<StatisticsOutput> findTopAppStatisticsByDate(StatisticsInput statisticsInput);


}
