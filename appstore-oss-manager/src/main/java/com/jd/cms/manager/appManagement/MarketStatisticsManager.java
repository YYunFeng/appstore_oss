package com.jd.cms.manager.appManagement;

import com.jd.appstore.domain.InstallStat;
import com.jd.cms.domain.appManagement.MarketStatOutput;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public interface MarketStatisticsManager {
    /**
     * 统计应用的总安装量
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @return
     */
    MarketStatOutput getMarketStat(String startTime, String endTime, Integer flag);


    /**
     * 按应用查看
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param pageIndex
     * @param pageSize
     * @return
     */

    PaginatedList<MarketStatOutput> statByApp(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag);


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
    PaginatedList<MarketStatOutput> appGetMarketStatByChannel(String startTime, String endTime, Integer appId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    PaginatedList<MarketStatOutput> appStatsChannelBySaler(String startTime, String endTime, Integer appId, Integer cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    PaginatedList<MarketStatOutput> statByChannel(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    PaginatedList<MarketStatOutput> statChannelByApps(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

    /**
     * 渠道下按促销员查看
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    PaginatedList<MarketStatOutput> channlStatBySaler(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    PaginatedList<MarketStatOutput> salerStatsByApps(String startTime, String endTime, int cId, String saler, int pageIndex, int pageSize, Integer flag,Integer statsFlag);


    void insertOfflineAppStat(InstallStat installStat);

    List<Integer> getAppIdFromTopicApp();

    String getInstallLogExcelPath();

}
