package com.jd.cms.dao.statistics.impl;

import com.jd.cms.dao.statistics.StatisticsDao;
import com.jd.cms.domain.statistics.StatisticsInput;
import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsDaoImpl extends BaseDao implements StatisticsDao {

    public Integer findNever7DaysStatistics() {
        return (Integer) queryForObject("Statistics.findNever7DaysStatistics");
    }

    public Integer findAllStatistics() {
        return (Integer) queryForObject("Statistics.findAllStatistics");
    }

    public List<StatisticsOutput> findAllStatisticsByDate(StatisticsInput statisticsInput) {
        return queryForList("Statistics.findAllStatisticsByDate", statisticsInput);
    }

    public Integer findAllStatisticsByDateCount(StatisticsInput statisticsInput) {
        return (Integer) queryForObject("Statistics.findAllStatisticsByDateCount", statisticsInput);
    }


    public List<StatisticsOutput> findAppStatisticsByDate(StatisticsInput statisticsInput) {
        return queryForList("Statistics.findAppStatisticsByDate", statisticsInput);
    }

    public Integer findAppStatisticsByDateCount(StatisticsInput statisticsInput) {
        return (Integer) queryForObject("Statistics.findAppStatisticsByDateCount", statisticsInput);
    }


    public List<StatisticsOutput> findTopAppStatisticsByDate(StatisticsInput statisticsInput) {
        return queryForList("Statistics.findTopAppStatisticsByDate", statisticsInput);
    }

}
