package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineStatistic;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;

import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public interface ValidMachineStatisticsManagerBak1 {
    /**
     * 省办公司统计
     * @param validMachineStatisticsParameter
     * @return
     */
    ValidMachineStatistic getTotalMachine(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    List<ValidMachineStatistic> getChannelMachines(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    List<ValidMachineStatistic> statisBySaler(ValidMachineStatisticsParameter validMachineStatisticsParameter);

    List<ValidMachineStatistic> statisByTime(ValidMachineStatisticsParameter validMachineStatisticsParameter);
}
