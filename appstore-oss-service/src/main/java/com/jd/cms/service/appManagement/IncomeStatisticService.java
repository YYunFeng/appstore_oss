package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.common.web.result.Result;

/**
 * YYF on 2015/5/19.
 */
public interface IncomeStatisticService {

    Result provinceIncomeStatistic(IncomeParameter incomeParameter);

    Result incomeStatisticChannelType(IncomeParameter incomeParameter);

    Result incomeSaler(IncomeParameter incomeParameter);

    Result incomeStatisticBySalerDetails(IncomeParameter incomeParameter);

    ValidMachineJSON exportExcel(IncomeParameter incomeParameter, Integer flag);
}
