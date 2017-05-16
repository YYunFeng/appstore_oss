package com.jd.cms.dao.appManagement.impl;

import com.jd.appstore.domain.InstallStat;
import com.jd.cms.dao.appManagement.MarketStatisticsDao;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.MarketStatOutput;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatisticsDaoImpl extends BaseDao implements MarketStatisticsDao {
    /**
     * 按应用统计安装次数 按日期
     *
     * @return
     */
    public MarketStatOutput getMarketStat(MarketStatInput marketStatInput) {
        return (MarketStatOutput) queryForObject("MarketStat.getMarketStat", marketStatInput);
    }

    /**
     * 按应用查看
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> statByApp(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.statByApp", marketStatInput);
    }

    /**
     * 按应用查看  统计总数  用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer statByAppCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.getStatByAppCount", marketStatInput);
    }

    /**
     * 某个应用按渠道统计安装次数
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> appGetMarketStatByChannel(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.appGetMarketStatByChannel", marketStatInput);
    }

    /**
     * 某个应用按渠道统计安装次数 统计数量  用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer appGetMarketStatByChannelCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.appGetMarketStatByChannelCount", marketStatInput);
    }

    /**
     * 应用每个渠道下按促销员查看-
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> appStatsChannelBySaler(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.appStatsChannelBySaler", marketStatInput);
    }

    /**
     * 应用每个渠道下按促销员查看 统计条数
     *
     * @param marketStatInput
     * @return
     */
    public Integer appStatsChannelBySalerCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.appStatsChannelBySalerCount", marketStatInput);
    }

    /**
     * 按渠道查看
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> statByChannel(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.statByChannel", marketStatInput);
    }

    /**
     * 按渠道查看 统计条数 用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer statByChannelCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.statByChannelCount", marketStatInput);
    }

    /**
     * 渠道下按应用查看
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> statChannelByApps(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.statChannelByApps", marketStatInput);
    }

    /**
     * 渠道下按应用查看 统计条数 用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer statChannelByAppsCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.statChannelByAppsCount", marketStatInput);
    }

    /**
     * 渠道下按促销员查看安装次数
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> channlStatBySaler(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.channlStatBySaler", marketStatInput);
    }

    /**
     * 渠道下按促销员查看安装次数 统计条数用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer channlStatBySalerCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.channlStatBySalerCount", marketStatInput);
    }

    /**
     * 促销员按应用查看安装次数
     *
     * @param marketStatInput
     * @return
     */
    public List<MarketStatOutput> salerStatsByApps(MarketStatInput marketStatInput) {
        return queryForList("MarketStat.salerStatsByApps", marketStatInput);
    }

    /**
     * 促销员按应用查看安装次数 统计条数用于分页
     *
     * @param marketStatInput
     * @return
     */
    public Integer salerStatsByAppsCount(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("MarketStat.salerStatsByAppsCount", marketStatInput);
    }

    public void insertOfflineAppStat(InstallStat installStat) {
        insert("MarketStat.insertOfflineAppStat",installStat);
    }

    public List<Integer> getAppIdFromTopicApp() {
        return queryForList("MarketStat.getAppIdFromTopicApp");
    }
}
