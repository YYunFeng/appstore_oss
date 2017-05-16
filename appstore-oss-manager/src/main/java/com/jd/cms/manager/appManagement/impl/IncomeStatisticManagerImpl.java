package com.jd.cms.manager.appManagement.impl;

import com.jd.cms.dao.appManagement.IncomeStatisticDao;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatisticNew;
import com.jd.cms.manager.appManagement.IncomeStatisticManager;
import com.jd.common.manager.BaseManager;

import java.util.List;

/**
 * YYF on 2015/5/19.
 */
public class IncomeStatisticManagerImpl extends BaseManager implements IncomeStatisticManager {
    private IncomeStatisticDao incomeStatisticDao;

    public List<IncomeStatisticNew> provinceIncomeStatistic(IncomeParameter incomeParameter) {
        return incomeStatisticDao.provinceIncomeStatistic(incomeParameter);
    }

    public List<IncomeStatisticNew> incomeStatisticChannelType(IncomeParameter incomeParameter) {
        return incomeStatisticDao.incomeStatisticChannelType(incomeParameter);
    }

    public List<IncomeStatisticNew> incomeSaler(IncomeParameter incomeParameter) {
        return incomeStatisticDao.incomeBySaler(incomeParameter);
    }

    public List<IncomeStatisticNew> getAllSaler(IncomeParameter incomeParameter) {
        return incomeStatisticDao.getAllSaler(incomeParameter);
    }

    public List<IncomeStatisticNew> incomeStatisticBySalerDetails(IncomeParameter incomeParameter) {
        return incomeStatisticDao.incomeStatisticBySalerDetails(incomeParameter);
    }


    public void setIncomeStatisticDao(IncomeStatisticDao incomeStatisticDao) {
        this.incomeStatisticDao = incomeStatisticDao;
    }
}
