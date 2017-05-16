package com.jd.cms.service.appManagement;

import com.jd.appstore.domain.InstallStat;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
public interface MarketStatisticsService {
    /**
     * 统计应用的总安装量
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @return
     */
    Result getMarketStat(String startTime, String endTime, Integer flag);

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

    Result statByApp(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    Result appGetMarketStatByChannel(String startTime, String endTime, Integer appId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

    /**
     * 应用每个渠道下按促销员查看
     *
     * @param flag
     * @param startTime
     * @param endTime
     * @param appId
     * @param cid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result appStatsChannelBySaler(String startTime, String endTime, Integer appId, Integer cid, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    Result statByChannel(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    Result statChannelByApps(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

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
    Result channlStatBySaler(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

    /**
     * 促销员按应用查看安装次数
     * @param startTime
     * @param endTime
     * @param cId
     * @param saler
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    Result salerStatsByApps(String startTime, String endTime, int cId, String saler, int pageIndex, int pageSize, Integer flag,Integer statsFlag);

    void insertOfflineAppStat();
}
