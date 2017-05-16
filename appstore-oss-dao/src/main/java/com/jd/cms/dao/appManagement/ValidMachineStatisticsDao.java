package com.jd.cms.dao.appManagement;


import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatistic;

import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public interface ValidMachineStatisticsDao {

    /**
     * 公司总收入统计
     *
     * @param incomeParameter
     * @return
     */
    IncomeStatistic totalIncome(IncomeParameter incomeParameter);

    /**
     * 公司总收入统计-按渠道查询
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatistic> incomeByChannel(IncomeParameter incomeParameter);

    /**
     * 公司总收入统计-按时间查询
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatistic> incomeByTime(IncomeParameter incomeParameter);

    /**
     * 公司总收入统计-按促销员查看
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatistic> incomeBySaler(IncomeParameter incomeParameter);

    /**
     * 获取渠道ID
     *
     * @param userId
     * @return
     */
    Integer channelId(Integer userId);

    /**
     * 得到所有的促销员收入信息
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatistic> getAllSaler(IncomeParameter incomeParameter);


}
