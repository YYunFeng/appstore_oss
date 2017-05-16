package com.jd.cms.dao.appManagement;

import com.jd.appstore.domain.InstallStat;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.MarketStatOutput;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public interface MarketStatisticsDao {
    /**
     * 统计应用的总安装量  按日期
     *
     * @return
     */
    MarketStatOutput getMarketStat(MarketStatInput marketStatInput);

    /**
     * 按应用查看
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> statByApp(MarketStatInput marketStatInput);

    /**
     * 按应用查看  统计总数  用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer statByAppCount(MarketStatInput marketStatInput);

    /**
     * 某个应用按渠道统计安装次数
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> appGetMarketStatByChannel(MarketStatInput marketStatInput);

    /**
     * 某个应用按渠道统计安装次数 统计数量  用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer appGetMarketStatByChannelCount(MarketStatInput marketStatInput);

    /**
     * 应用每个渠道下按促销员查看
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> appStatsChannelBySaler(MarketStatInput marketStatInput);

    /**
     * 应用每个渠道下按促销员查看 统计条数 用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer appStatsChannelBySalerCount(MarketStatInput marketStatInput);

    /**
     * 按渠道查看
     *
     * @return
     */
    List<MarketStatOutput> statByChannel(MarketStatInput marketStatInput);

    /**
     * 按渠道查看 统计条数 用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer statByChannelCount(MarketStatInput marketStatInput);

    /**
     * 渠道下按应用查看
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> statChannelByApps(MarketStatInput marketStatInput);

    /**
     * 渠道下按应用查看 统计条数 用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer statChannelByAppsCount(MarketStatInput marketStatInput);

    /**
     * 渠道下按促销员查看安装次数
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> channlStatBySaler(MarketStatInput marketStatInput);



    /**
     * 渠道下按促销员查看安装次数 统计条数用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer channlStatBySalerCount(MarketStatInput marketStatInput);

    /**
     * 促销员按应用查看安装次数
     *
     * @param marketStatInput
     * @return
     */
    List<MarketStatOutput> salerStatsByApps(MarketStatInput marketStatInput);

    /**
     * 促销员按应用查看安装次数  统计条数用于分页
     *
     * @param marketStatInput
     * @return
     */
    Integer salerStatsByAppsCount(MarketStatInput marketStatInput);



    /**
     * 模拟营销日志
     * @param installStat
     */
    void insertOfflineAppStat(InstallStat installStat);

    /**
     * 从专题中取得appId  用于模拟营销安装日志
     * @return
     */
    List<Integer> getAppIdFromTopicApp();

}
