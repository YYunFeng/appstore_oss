package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.NewStatisticDao;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.NewStatisticObj;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * YYF on 2015/4/16.
 */
public class NewStatisticDaoImpl extends BaseDao implements NewStatisticDao {
    public NewStatisticObj appInstallTotal(MarketStatInput marketStatInput) {
        return (NewStatisticObj) queryForObject("AppInstallStatistic.appIntallTotal", marketStatInput);
    }

    public List<NewStatisticObj> totalByApp(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.totalByApp", marketStatInput);
    }

    public Integer totalByAppCounts(MarketStatInput marketStatInput) {
        return (Integer) queryForObject("AppInstallStatistic.totalByAppCounts", marketStatInput);
    }

    public List<NewStatisticObj> totalByChannel(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.totalByChannel", marketStatInput);
    }

    public List<NewStatisticObj> channelType(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.channelType", marketStatInput);
    }

    public List<String> salerList(Integer cid) {
        return queryForList("AppInstallStatistic.salerList", cid);
    }

    public List<NewStatisticObj> channelBySaler(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.channelBySaler", marketStatInput);
    }

    public List<NewStatisticObj> channelBySalerDetails(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.channelBySalerDetails", marketStatInput);
    }

    public List<NewStatisticObj> appBySalerNo(MarketStatInput marketStatInput) {
        return queryForList("AppInstallStatistic.appBySalerNo", marketStatInput);
    }
}
