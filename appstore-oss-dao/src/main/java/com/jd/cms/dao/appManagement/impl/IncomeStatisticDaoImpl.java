package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.IncomeStatisticDao;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatisticNew;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * YYF on 2015/5/19.
 */
public class IncomeStatisticDaoImpl extends BaseDao implements IncomeStatisticDao {
    public List<IncomeStatisticNew> provinceIncomeStatistic(IncomeParameter incomeParameter) {
        return queryForList("IncomeStatistic.provinceIncomeStatistic", incomeParameter);
    }

    public List<IncomeStatisticNew> incomeStatisticChannelType(IncomeParameter incomeParameter) {
        return queryForList("IncomeStatistic.incomeStatisticChannelType", incomeParameter);
    }

    public List<IncomeStatisticNew> incomeBySaler(IncomeParameter incomeParameter) {
        return queryForList("IncomeStatistic.incomeBySaler", incomeParameter);
    }

    public List<IncomeStatisticNew> incomeStatisticBySalerDetails(IncomeParameter incomeParameter) {
        return queryForList("IncomeStatistic.incomeStatisticSalerDetails", incomeParameter);
    }

    public List<IncomeStatisticNew> getAllSaler(IncomeParameter incomeParameter) {
        return queryForList("IncomeStatistic.getAllSaler", incomeParameter);
    }
}
