package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.common.web.result.Result;


/**
 * Created by YUNFENG on 14-1-7.
 */
public interface ValidMachineStatisticsService {

    Result totalIncome(IncomeParameter incomeParameter);

    Result incomeByChannel(IncomeParameter incomeParameter);

    Result incomeByTime(IncomeParameter incomeParameter);

    Result incomeBySaler(IncomeParameter incomeParameter);

    Integer channelId(Integer userId);

    ValidMachineJSON validMachineExcel(IncomeParameter incomeParameter, Integer flag);

}
