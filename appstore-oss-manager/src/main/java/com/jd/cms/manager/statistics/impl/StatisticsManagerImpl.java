package com.jd.cms.manager.statistics.impl;

import com.jd.cms.dao.statistics.StatisticsDao;
import com.jd.cms.domain.statistics.StatisticsInput;
import com.jd.cms.domain.statistics.StatisticsOutput;
import com.jd.cms.manager.statistics.StatisticsManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsManagerImpl extends BaseManager implements StatisticsManager {

    private StatisticsDao statisticsDao;

    public PaginatedList<StatisticsOutput> findAllStatisticsByDate(String startDate, String endDate, Integer appType, Integer pageSize, Integer pageNum) {
        if (pageSize == null)
            pageSize = 20;
        if (pageNum == null)
            pageNum = 1;
        PaginatedList<StatisticsOutput> paginatedList = new PaginatedArrayList<StatisticsOutput>(pageNum, pageSize);
        try {
            StatisticsInput statisticsInput = new StatisticsInput();
            statisticsInput.setStartDate(startDate);
            statisticsInput.setEndDate(endDate);
            statisticsInput.setAppType(appType);
            int totalItem = statisticsDao.findAllStatisticsByDateCount(statisticsInput);
            paginatedList.setTotalItem(totalItem);
            statisticsInput.setOffset(paginatedList.getStartRow() == 0 ? paginatedList.getStartRow() : paginatedList.getStartRow() - 1);
            statisticsInput.setLimit(pageSize);
            List<StatisticsOutput> statisticsOutputList = statisticsDao.findAllStatisticsByDate(statisticsInput);
            paginatedList.addAll(statisticsOutputList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginatedList;
    }

    public PaginatedList<StatisticsOutput> findAppStatisticsByDate(Integer appId, String appName, String startDate, String endDate, Integer pageSize, Integer pageNum) {
        if (pageSize == null)
            pageSize = 20;
        if (pageNum == null)
            pageNum = 1;
        PaginatedList<StatisticsOutput> paginatedList = new PaginatedArrayList<StatisticsOutput>(pageNum, pageSize);
        try {
            StatisticsInput statisticsInput = new StatisticsInput();
            statisticsInput.setAppId(appId);
            statisticsInput.setAppName(appName);
            statisticsInput.setStartDate(startDate);
            statisticsInput.setEndDate(endDate);
            int totalItem = statisticsDao.findAppStatisticsByDateCount(statisticsInput);
            paginatedList.setTotalItem(totalItem);
            statisticsInput.setOffset(paginatedList.getStartRow() == 0 ? paginatedList.getStartRow() : paginatedList.getStartRow() - 1);
            statisticsInput.setLimit(pageSize);
            List<StatisticsOutput> statisticsOutputList = statisticsDao.findAppStatisticsByDate(statisticsInput);
            paginatedList.addAll(statisticsOutputList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginatedList;
    }

    public List<StatisticsOutput> findTopAppStatisticsByDate(String startDate, String endDate, Integer appType, Integer topCount) {
        List<StatisticsOutput> statisticsOutputList = null;
        if (topCount == null)
            topCount = 50;
        try {
            StatisticsInput statisticsInput = new StatisticsInput();
            statisticsInput.setStartDate(startDate);
            statisticsInput.setEndDate(endDate);
            statisticsInput.setAppType(appType);
            statisticsInput.setTopCount(topCount);
            statisticsOutputList = statisticsDao.findTopAppStatisticsByDate(statisticsInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticsOutputList;
    }

    public Integer findAllStatisticsCount() {
        Integer result = null;
        try {
            result = statisticsDao.findAllStatistics();
            result = result == null ? 0 : result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer findNever7DaysStatisticsCount() {
        Integer result = null;
        try {
            result = statisticsDao.findNever7DaysStatistics();
            result = result == null ? 0 : result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setStatisticsDao(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }
}
