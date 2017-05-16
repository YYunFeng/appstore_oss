package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.SalesStatisticsDao;
import com.jd.cms.domain.appManagement.*;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.base.BaseQuery;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
public class SalesStatisticsDaoImpl extends BaseDao implements SalesStatisticsDao {
    /**
     * 获取促销员排名
     *
     * @return
     */
    public List<SalerRankingRes> getSalerRanking(SalerRankingParameter salerRankingParameter) {
        return queryForList("SalesStatistics.getSalerRanking", salerRankingParameter);
    }


    public List<PhoneIntallMess> getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter) {
        return queryForList("SalesStatistics.getPhoneImeiInstallMess", phoneIntallMessParameter);
    }

    public Integer getPhoneImeiInstallMessCounts(PhoneIntallMessParameter phoneIntallMessParameter) {
        return (Integer) queryForObject("SalesStatistics.getPhoneImeiInstallMessCounts", phoneIntallMessParameter);
    }


    public List<DayIntallLog> byDayCheckInstall(BaseQuery baseQuery) {
        return queryForList("SalesStatistics.byDayCheckInstall", baseQuery);
    }

    public List<DayIntallLog> byDayCheckInstallExcel() {
        return queryForList("SalesStatistics.byDayCheckInstallExcel");
    }

    public Integer installMessCount() {
        return (Integer) queryForObject("SalesStatistics.installMessCount");
    }

    public List<ProvinceStatisRes> installByChannel(ProvinceStatisParameter provinceStatisParameter) {
        return queryForList("SalesStatistics.installByChannel", provinceStatisParameter);
    }

    public List<ProvinceStatisRes> intallSalerTime(ProvinceStatisParameter provinceStatisParameter) {
        return queryForList("SalesStatistics.intallSalerTime", provinceStatisParameter);
    }

    public List<ProvinceStatisRes> getIncome(ProvinceStatisParameter provinceStatisParameter) {
        return queryForList("SalesStatistics.getIncome", provinceStatisParameter);
    }

    public List<ProvinceStatisRes> getArrTimes(ProvinceStatisParameter provinceStatisParameter) {
        return queryForList("SalesStatistics.getArrTimes", provinceStatisParameter);
    }

    public Integer getInstaisticNorm(InstaisticNorm instaisticNorm) {
        return (Integer) queryForObject("SalesStatistics.getInstaisticNorm", instaisticNorm);
    }

    public void createInstaisticNorm(InstaisticNorm instaisticNorm) {
        insert("SalesStatistics.createInstaisticNorm", instaisticNorm);
    }

    public void updateInstaisticNorm(InstaisticNorm instaisticNorm) {
        update("SalesStatistics.updateInstaisticNorm", instaisticNorm);
    }

    public List<InstaisticNorm> getInstaisticNormList(String time) {
        return queryForList("SalesStatistics.getInstaisticNormList", time);
    }

    public List<InstaisticNorm> getPadName() {
        return queryForList("SalesStatistics.getPadName");
    }

    public Map channelName() {
        return queryForMap("SalesStatistics.channelName", null, "cId", "cname");
    }

    public Map appName() {
        return queryForMap("SalesStatistics.appName", null, "appid", "appName");
    }

    public List<Integer> searchAppName(String appName) {
        return queryForList("SalesStatistics.searchAppName", appName);
    }
}
