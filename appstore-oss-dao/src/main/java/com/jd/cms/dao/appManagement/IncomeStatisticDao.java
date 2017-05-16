package com.jd.cms.dao.appManagement;

import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatisticNew;

import java.util.List;

/**
 * YYF on 2015/5/19.
 */
public interface IncomeStatisticDao {

    /**
     * 查看各个省份的结算统计
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatisticNew> provinceIncomeStatistic(IncomeParameter incomeParameter);


    /**
     * 按渠道类型查看
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatisticNew> incomeStatisticChannelType(IncomeParameter incomeParameter);


    /**
     * 按店长或者督导查看
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatisticNew> incomeBySaler(IncomeParameter incomeParameter);


    /**
     * 按店员查看
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeStatisticNew> incomeStatisticBySalerDetails(IncomeParameter incomeParameter);


    List<IncomeStatisticNew> getAllSaler(IncomeParameter incomeParameter);

}
