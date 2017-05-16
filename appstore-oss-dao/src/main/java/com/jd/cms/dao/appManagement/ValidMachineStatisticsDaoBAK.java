package com.jd.cms.dao.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineStatistic;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;

import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public interface ValidMachineStatisticsDaoBAK {
    /**
     * 公司总有效装机数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    Integer getTotalMachine(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    /**
     * 精彩推荐应用总安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    Integer getNiceAppTotalCounts(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    /**
     * 卖场专区应用总安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    Integer getSaleAppTotalCounts(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    /**
     * 按渠道查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> getChannelMachines(ValidMachineStatisticsParameter validMachineStatisticsParameter);


    /**
     * 按渠道查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> getAppCountsByChannelNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter);


    /**
     * 按促销员查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> statisBySaler(ValidMachineStatisticsParameter validMachineStatisticsParameter);


    /**
     * 按促销员查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> statisBySalerNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    /**
     * 按时间查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> statisByTime(ValidMachineStatisticsParameter validMachineStatisticsParameter);


    /**
     * 按时间查看精彩推荐应用安装数和卖场专区应用安装数
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    List<ValidMachineStatistic> statisByTimeNiceAndSale(ValidMachineStatisticsParameter validMachineStatisticsParameter);




    /**
     * 专题下应用的总数
     *
     * @return
     */
    Integer appsCounst();
}
