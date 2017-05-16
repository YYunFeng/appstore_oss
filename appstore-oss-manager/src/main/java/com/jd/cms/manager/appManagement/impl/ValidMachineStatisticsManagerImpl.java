package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.utils.IncomePrice;
import com.jd.cms.dao.appManagement.ValidMachineStatisticsDao;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatistic;
import com.jd.cms.manager.appManagement.ValidMachineStatisticsManager;
import com.jd.common.manager.BaseManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsManagerImpl extends BaseManager implements ValidMachineStatisticsManager {
    private ValidMachineStatisticsDao validMachineStatisticsDao;

    /**
     * 公司总收入统计
     *
     * @param incomeParameter
     * @return
     */
    public IncomeStatistic totalIncome(IncomeParameter incomeParameter) {
        IncomeStatistic incomeStatistic = validMachineStatisticsDao.totalIncome(incomeParameter);
        try {
            if (incomeStatistic.getVaildMachineCounts() != null) {


                int b = (int)Math.round(incomeStatistic.getVaildMachineCounts() * 100); //小数点后两位前移，并四舍五入
                incomeStatistic.setVaildMachineCounts((double)b / 100.00);


                DecimalFormat df = new DecimalFormat(".##");
                String s1 = df.format(incomeStatistic.getRecommendAppIncomeForCompany());
                incomeStatistic.setRecommendAppIncomeForCompany(Double.valueOf(s1));

                String s3 = df.format(incomeStatistic.getNeedAppIncomeForCompany());
                incomeStatistic.setNeedAppIncomeForCompany(Double.valueOf(s3));

                incomeStatistic.setTotalAppCount(incomeStatistic.getHuashengAppCounts() + incomeStatistic.getMineAppCounts());
                incomeStatistic.setTotalIncome(addition(incomeStatistic.getRecommendAppIncomeForCompany(), incomeStatistic.getNeedAppIncomeForCompany()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomeStatistic;
    }

    /**
     * 公司总收入统计--按渠道查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeByChannel(IncomeParameter incomeParameter) {
        List<IncomeStatistic> incomeStatisticList = validMachineStatisticsDao.incomeByChannel(incomeParameter);
        return formatList(incomeStatisticList);
    }

    /**
     * 公司总收入统计--按时间查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeByTime(IncomeParameter incomeParameter) {
        List<IncomeStatistic> incomeStatisticList = validMachineStatisticsDao.incomeByTime(incomeParameter);
        return formatList(incomeStatisticList);
    }

    /**
     * 公司总收入统计--按促销员查看
     *
     * @param incomeParameter
     * @return
     */
    public List<IncomeStatistic> incomeBySaler(IncomeParameter incomeParameter) {
        List<IncomeStatistic> incomeStatisticList = validMachineStatisticsDao.incomeBySaler(incomeParameter);
        return formatList(incomeStatisticList);
    }

    public Integer channelId(Integer userId) {
        return validMachineStatisticsDao.channelId(userId);
    }

    public List<IncomeStatistic> getAllSaler(IncomeParameter incomeParameter) {
        List<IncomeStatistic> incomeStatisticList = validMachineStatisticsDao.getAllSaler(incomeParameter);
        return formatList(incomeStatisticList);
    }

    public List<IncomeStatistic> formatList(List<IncomeStatistic> incomeStatisticList) {
        try {
            if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                for (IncomeStatistic incomeStatistic : incomeStatisticList) {
                  /*  double b = (double) (incomeStatistic.getRecommendAppCounts() + incomeStatistic.getNeedAppCounts()) / IncomePrice.VAILDMACHINECOUNTS;
                    BigDecimal a = new BigDecimal(b);
                    double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();*/

                    int b = (int)Math.round(incomeStatistic.getVaildMachineCounts() * 100); //小数点后两位前移，并四舍五入
                    incomeStatistic.setVaildMachineCounts((double)b / 100.00);
                    incomeStatistic.setTotalAppCount(incomeStatistic.getRecommendAppCounts() + incomeStatistic.getNeedAppCounts());


                    DecimalFormat df = new DecimalFormat(".##");
                    String s1 = df.format(incomeStatistic.getRecommendAppIncomeForCompany());
                    incomeStatistic.setRecommendAppIncomeForCompany(Double.valueOf(s1));

                    String s2 = df.format(incomeStatistic.getRecommendAppIncomeForProvince());
                    incomeStatistic.setRecommendAppIncomeForProvince(Double.valueOf(s2));

                    String s3 = df.format(incomeStatistic.getNeedAppIncomeForCompany());
                    incomeStatistic.setNeedAppIncomeForCompany(Double.valueOf(s3));

                    String s4 = df.format(incomeStatistic.getNeedAppIncomeForProvince());
                    incomeStatistic.setNeedAppIncomeForProvince(Double.valueOf(s4));

                    incomeStatistic.setTotalIncome(addition(incomeStatistic.getRecommendAppIncomeForCompany(), incomeStatistic.getNeedAppIncomeForCompany()));
                    incomeStatistic.setTotalIncomeProvince(addition(incomeStatistic.getRecommendAppIncomeForProvince(), incomeStatistic.getNeedAppIncomeForProvince()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomeStatisticList;
    }

    public void setValidMachineStatisticsDao(ValidMachineStatisticsDao validMachineStatisticsDao) {
        this.validMachineStatisticsDao = validMachineStatisticsDao;
    }


    public double addition(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        DecimalFormat df = new DecimalFormat(".##");
        double d = b1.add(b2).doubleValue();
        String st = df.format(d);
        return Double.valueOf(st);
    }


}
