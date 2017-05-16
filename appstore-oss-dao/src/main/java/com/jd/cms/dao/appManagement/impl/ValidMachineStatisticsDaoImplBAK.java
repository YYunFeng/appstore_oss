package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.ValidMachineStatisticsDaoBAK;
import com.jd.cms.domain.appManagement.ValidMachineStatistic;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsDaoImplBAK extends BaseDao implements ValidMachineStatisticsDaoBAK {
    /**
     * 公司总有效装机数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public Integer getTotalMachine(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return (Integer) queryForObject("ValidMachineStatistics.getTotalMachine", validMachineStatisticsParameter);
    }

    /**
     * 精彩推荐应用总安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public Integer getNiceAppTotalCounts(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return (Integer) queryForObject("ValidMachineStatistics.getNiceAppTotalCounts", validMachineStatisticsParameter);
    }

    /**
     * 卖场专区应用总安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public Integer getSaleAppTotalCounts(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return (Integer) queryForObject("ValidMachineStatistics.getSaleAppTotalCounts", validMachineStatisticsParameter);
    }

    /**
     * 按渠道查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> getChannelMachines(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.getChannelMachines", validMachineStatisticsParameter);
    }

    /**
     * 按渠道查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> getAppCountsByChannelNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.getAppCountsByChannelNiceAndSale", validMachineStatisticsParameter);
    }


    /**
     * 按促销员查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisBySaler(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.statisBySaler", validMachineStatisticsParameter);
    }

    /**
     * 按促销员查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisBySalerNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.statisBySalerNiceAndSale", validMachineStatisticsParameter);
    }

    /**
     * 按时间查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisByTime(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.statisByTime", validMachineStatisticsParameter);
    }

    /**
     * 按时间查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisByTimeNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        return queryForList("ValidMachineStatistics.statisByTimeNiceAndSale", validMachineStatisticsParameter);
    }


    public Integer appsCounst() {
        return (Integer) queryForObject("ValidMachineStatistics.getAppsCounst");
    }
}
