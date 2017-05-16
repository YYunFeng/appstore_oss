package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.ValidMachineStatisticsDao;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatistic;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsDaoImpl extends BaseDao implements ValidMachineStatisticsDao {

    /**
     * 总收入统计
     *
     * @param incomeParameter
     * @return
     */
    public IncomeStatistic totalIncome(IncomeParameter incomeParameter) {
        return (IncomeStatistic) queryForObject("ValidMachineStatistics.totalIncome", incomeParameter);
    }

    /**
     * 收入统计-按渠道查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeByChannel(IncomeParameter incomeParameter) {
        return queryForList("ValidMachineStatistics.incomeByChannel", incomeParameter);
    }

    /**
     * 收入统计-按渠道查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeByTime(IncomeParameter incomeParameter) {
        return queryForList("ValidMachineStatistics.incomeByTime", incomeParameter);
    }

    /**
     * 收入统计-按渠道查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeBySaler(IncomeParameter incomeParameter) {
        return queryForList("ValidMachineStatistics.incomeBySaler", incomeParameter);
    }

    /**
     * 取得渠道ID
     *
     * @param userId
     * @return
     */
    public Integer channelId(Integer userId) {
        return (Integer) queryForObject("ValidMachineStatistics.channelId", userId);
    }

    /**
     * 得到所有的促销员收入信息
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> getAllSaler(IncomeParameter incomeParameter) {
        return queryForList("ValidMachineStatistics.getAllSaler", incomeParameter);
    }

}
