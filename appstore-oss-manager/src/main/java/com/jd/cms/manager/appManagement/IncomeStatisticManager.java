package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatisticNew;

import java.util.List;

/**
 * YYF on 2015/5/19.
 */
public interface IncomeStatisticManager {

    List<IncomeStatisticNew> provinceIncomeStatistic(IncomeParameter incomeParameter);

    List<IncomeStatisticNew> incomeStatisticChannelType(IncomeParameter incomeParameter);

    List<IncomeStatisticNew> incomeSaler(IncomeParameter incomeParameter);

    List<IncomeStatisticNew> getAllSaler(IncomeParameter incomeParameter);

    List<IncomeStatisticNew> incomeStatisticBySalerDetails(IncomeParameter incomeParameter);
}
