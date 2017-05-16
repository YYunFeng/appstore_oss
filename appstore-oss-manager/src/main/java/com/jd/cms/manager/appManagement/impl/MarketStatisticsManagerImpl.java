package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.InstallStat;
import com.jd.appstore.domain.utils.DateConversion;
import com.jd.cms.dao.appManagement.MarketStatisticsDao;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.MarketStatOutput;
import com.jd.cms.manager.appManagement.MarketStatisticsManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatisticsManagerImpl extends BaseManager implements MarketStatisticsManager {
    private MarketStatisticsDao marketStatisticsDao;
    private String installLogExcelPath;

    /**
     * 统计应用的总安装量
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @return
     */
    public MarketStatOutput getMarketStat(String startTime, String endTime, Integer flag) {
        MarketStatOutput marketStat = new MarketStatOutput();
        try {
            MarketStatInput marketStatInput = new MarketStatInput();
            marketStatInput.setStartTime(startTime);
            marketStatInput.setEndTime(endTime);
            marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
            marketStatInput.setFlag(flag);
            marketStat = marketStatisticsDao.getMarketStat(marketStatInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marketStat;
    }


    /**
     * 按应用查看
     *
     * @param startTime
     * @param endTime
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public PaginatedList<MarketStatOutput> statByApp(String startTime, String endTime, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> statOfflineByAppPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setFlag(flag);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.statByAppCount(marketStatInput);
            statOfflineByAppPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.statByApp(marketStatInput);
        statOfflineByAppPaginatedList.addAll(statInputList);
        return statOfflineByAppPaginatedList;
    }


    /**
     * 某个应用按渠道统计安装次数
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param appId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<MarketStatOutput> appGetMarketStatByChannel(String startTime, String endTime, Integer appId, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> appStatMarketByChannelPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setAppId(appId);
        marketStatInput.setFlag(flag);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.appGetMarketStatByChannelCount(marketStatInput);
            appStatMarketByChannelPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.appGetMarketStatByChannel(marketStatInput);
        appStatMarketByChannelPaginatedList.addAll(statInputList);
        return appStatMarketByChannelPaginatedList;
    }

    /**
     * 应用每个渠道下按促销员查看
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param appId
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<MarketStatOutput> appStatsChannelBySaler(String startTime, String endTime, Integer appId, Integer cId, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> appStatsChannelBySalerPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setFlag(flag);
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setAppId(appId);
        marketStatInput.setCid(cId);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.appStatsChannelBySalerCount(marketStatInput);
            appStatsChannelBySalerPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.appStatsChannelBySaler(marketStatInput);
        appStatsChannelBySalerPaginatedList.addAll(statInputList);
        return appStatsChannelBySalerPaginatedList;
    }

    /**
     * 按渠道查看
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<MarketStatOutput> statByChannel(String startTime, String endTime, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> statOfflineByChannelPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setFlag(flag);
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.statByChannelCount(marketStatInput);
            statOfflineByChannelPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.statByChannel(marketStatInput);
        statOfflineByChannelPaginatedList.addAll(statInputList);
        return statOfflineByChannelPaginatedList;
    }

    /**
     * 渠道下按应用查看
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<MarketStatOutput> statChannelByApps(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> statChannelByAppsPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setFlag(flag);
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setCid(cId);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.statChannelByAppsCount(marketStatInput);
            statChannelByAppsPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.statChannelByApps(marketStatInput);
        statChannelByAppsPaginatedList.addAll(statInputList);
        return statChannelByAppsPaginatedList;
    }

    /**
     * 渠道下按促销员查看安装次数
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public PaginatedList<MarketStatOutput> channlStatBySaler(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> channlStatBySalerPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setFlag(flag);
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setCid(cId);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.channlStatBySalerCount(marketStatInput);
            channlStatBySalerPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.channlStatBySaler(marketStatInput);
        channlStatBySalerPaginatedList.addAll(statInputList);
        return channlStatBySalerPaginatedList;
    }

    /**
     * 促销员按应用查看安装次数
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param saler
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public PaginatedList<MarketStatOutput> salerStatsByApps(String startTime, String endTime, int cId, String saler, int pageIndex, int pageSize, Integer flag, Integer statsFlag) {
        PaginatedList<MarketStatOutput> salerStatsByAppsPaginatedList = new PaginatedArrayList<MarketStatOutput>(pageIndex, pageSize);
        MarketStatInput marketStatInput = new MarketStatInput();
        marketStatInput.setFlag(flag);
        marketStatInput.setStartTime(startTime);
        marketStatInput.setEndTime(endTime);
        marketStatInput.setPartisionsEndTime(DateConversion.lastDay(endTime));
        marketStatInput.setCid(cId);
        marketStatInput.setSaler(saler);
        marketStatInput.setStatsFlag(statsFlag);
        // 分页
        if (statsFlag != null && statsFlag.intValue() == 0) {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            Integer totalItem = marketStatisticsDao.salerStatsByAppsCount(marketStatInput);
            salerStatsByAppsPaginatedList.setTotalItem(totalItem.intValue());
            marketStatInput.setOffset((pageIndex - 1) * pageSize);
            marketStatInput.setLimit(pageSize);
        }
        List<MarketStatOutput> statInputList = marketStatisticsDao.salerStatsByApps(marketStatInput);
        salerStatsByAppsPaginatedList.addAll(statInputList);
        return salerStatsByAppsPaginatedList;
    }

    public void insertOfflineAppStat(InstallStat installStat) {
        installStat.setId((int) sequenceUtil.get(SequenceConstants.INSTALLSTATS));
        marketStatisticsDao.insertOfflineAppStat(installStat);
    }

    public List<Integer> getAppIdFromTopicApp() {
        return marketStatisticsDao.getAppIdFromTopicApp();
    }

    public String getInstallLogExcelPath() {
        return installLogExcelPath;
    }

    public void setInstallLogExcelPath(String installLogExcelPath) {
        this.installLogExcelPath = installLogExcelPath;
    }

    public void setMarketStatisticsDao(MarketStatisticsDao marketStatisticsDao) {
        this.marketStatisticsDao = marketStatisticsDao;
    }

}
