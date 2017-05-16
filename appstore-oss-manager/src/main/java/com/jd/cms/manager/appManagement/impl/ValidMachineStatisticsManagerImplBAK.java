package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.utils.IncomePrice;
import com.jd.cms.dao.appManagement.ValidMachineStatisticsDaoBAK;
import com.jd.cms.domain.appManagement.ValidMachineStatistic;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;
import com.jd.cms.manager.appManagement.ValidMachineStatisticsManagerBak1;
import com.jd.common.manager.BaseManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsManagerImplBAK extends BaseManager implements ValidMachineStatisticsManagerBak1 {
    private ValidMachineStatisticsDaoBAK validMachineStatisticsDao;

    public ValidMachineStatistic getTotalMachine(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        ValidMachineStatistic validMachineStatistic = new ValidMachineStatistic();
        try {
            Integer appCounts = 16;
            validMachineStatistic.setNiceCount(validMachineStatisticsDao.getNiceAppTotalCounts(validMachineStatisticsParameter));
            validMachineStatistic.setSaleCount(validMachineStatisticsDao.getSaleAppTotalCounts(validMachineStatisticsParameter));
            validMachineStatistic.setTotalAppCount(validMachineStatistic.getNiceCount() + validMachineStatistic.getSaleCount());
            //有效装机数
            Double phoneCounst = (double) validMachineStatistic.getTotalAppCount() / (appCounts / 2);
            BigDecimal a = new BigDecimal(phoneCounst);
            double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            validMachineStatistic.setVaildInstallPhoneCounts(f1);
            //精彩推荐应用收入
            Double nicePrice = validMachineStatistic.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
            BigDecimal b = new BigDecimal(nicePrice);
            double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            validMachineStatistic.setNicePrice(f2);
            //卖场专区应用收入
            Double salePrice = validMachineStatistic.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
            BigDecimal c = new BigDecimal(salePrice);
            double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            validMachineStatistic.setSalePirce(f3);

            BigDecimal b1 = new BigDecimal(Double.toString(f2));
            BigDecimal b2 = new BigDecimal(Double.toString(f3));
            // 应用总收入
            validMachineStatistic.setTotalPrice(b1.add(b2).doubleValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validMachineStatistic;
    }


    public List<ValidMachineStatistic> getChannelMachines(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        List<ValidMachineStatistic> validMachineStatisticList = validMachineStatisticsDao.getAppCountsByChannelNiceAndSale(validMachineStatisticsParameter);
        List<ValidMachineStatistic> validMachineStatisticsResList = new ArrayList<ValidMachineStatistic>();
        try {
            Integer appCounts = 16;
            ValidMachineStatistic validMachineStatisticsRes = null;
            Integer listSize = validMachineStatisticList.size();
            if (validMachineStatisticList != null && listSize != 0) {
                for (int i = 0; i < listSize; i++) {
                    if (validMachineStatisticsRes == null || validMachineStatisticsRes.getCid().intValue() != validMachineStatisticList.get(i).getCid().intValue()) {
                        if (validMachineStatisticsRes != null && validMachineStatisticsRes.getCid().intValue() != validMachineStatisticList.get(i).getCid().intValue()) {
                            //精彩推荐应用收入
                            Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                            BigDecimal b = new BigDecimal(nicePrice);
                            double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setNicePrice(f2);

                            //卖场专区应用收入
                            Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                            BigDecimal c = new BigDecimal(salePrice);
                            double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setSalePirce(f3);

                            // 应用总收入
                            BigDecimal b1 = new BigDecimal(Double.toString(f2));
                            BigDecimal b2 = new BigDecimal(Double.toString(f3));
                            validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                            //有效装机数
                            validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                            Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / (appCounts / 2);
                            BigDecimal a = new BigDecimal(phoneCounst);
                            double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                            // 放入List中
                            validMachineStatisticsResList.add(validMachineStatisticsRes);
                        }
                        validMachineStatisticsRes = new ValidMachineStatistic();
                        validMachineStatisticsRes.setCid(validMachineStatisticList.get(i).getCid());
                        validMachineStatisticsRes.setChannelName(validMachineStatisticList.get(i).getChannelName());
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    } else {
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    }
                    //     循环结束，将最后一个元素放入List
                    if (i == (listSize - 1)) {
                        //精彩推荐应用收入
                        Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                        BigDecimal b = new BigDecimal(nicePrice);
                        double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setNicePrice(f2);

                        //卖场专区应用收入
                        Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                        BigDecimal c = new BigDecimal(salePrice);
                        double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setSalePirce(f3);

                        // 应用总收入
                        BigDecimal b1 = new BigDecimal(Double.toString(f2));
                        BigDecimal b2 = new BigDecimal(Double.toString(f3));
                        validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                        //有效装机数
                        validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                        Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / (appCounts / 2);
                        BigDecimal a = new BigDecimal(phoneCounst);
                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                        // 放入List中
                        validMachineStatisticsResList.add(validMachineStatisticsRes);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validMachineStatisticsResList;
    }

    /**
     * 按促销员查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisBySaler(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        List<ValidMachineStatistic> validMachineStatisticList = validMachineStatisticsDao.statisBySalerNiceAndSale(validMachineStatisticsParameter);
        List<ValidMachineStatistic> validMachineStatisticsResList = new ArrayList<ValidMachineStatistic>();
        try {
            ValidMachineStatistic validMachineStatisticsRes = null;
            Integer listSize = validMachineStatisticList.size();
            for (int i = 0; i < listSize; i++) {
                if (validMachineStatisticList.get(i).getSalerNo() != null && !validMachineStatisticList.get(i).getSalerNo().equals("")) {
                    if (validMachineStatisticsRes == null || !validMachineStatisticsRes.getSalerNo().equals(validMachineStatisticList.get(i).getSalerNo())) {
                        if (validMachineStatisticsRes != null && !validMachineStatisticsRes.getSalerNo().equals(validMachineStatisticList.get(i).getCid())) {
                            //精彩推荐应用收入
                            Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                            BigDecimal b = new BigDecimal(nicePrice);
                            double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setNicePrice(f2);

                            //卖场专区应用收入
                            Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                            BigDecimal c = new BigDecimal(salePrice);
                            double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setSalePirce(f3);

                            // 应用总收入
                            BigDecimal b1 = new BigDecimal(Double.toString(f2));
                            BigDecimal b2 = new BigDecimal(Double.toString(f3));
                            validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                            //有效装机数
                            validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                            Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
                            BigDecimal a = new BigDecimal(phoneCounst);
                            double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                            // 放入List中
                            validMachineStatisticsResList.add(validMachineStatisticsRes);
                        }
                        validMachineStatisticsRes = new ValidMachineStatistic();
                        validMachineStatisticsRes.setSalerNo(validMachineStatisticList.get(i).getSalerNo());
                        validMachineStatisticsRes.setSalerName(validMachineStatisticList.get(i).getSalerName());
                        validMachineStatisticsRes.setShopName(validMachineStatisticList.get(i).getShopName());
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    } else {
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    }
                    //     循环结束，将最后一个元素放入List
                    if (i == (listSize - 1)) {
                        //精彩推荐应用收入
                        Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                        BigDecimal b = new BigDecimal(nicePrice);
                        double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setNicePrice(f2);

                        //卖场专区应用收入
                        Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                        BigDecimal c = new BigDecimal(salePrice);
                        double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setSalePirce(f3);

                        // 应用总收入
                        BigDecimal b1 = new BigDecimal(Double.toString(f2));
                        BigDecimal b2 = new BigDecimal(Double.toString(f3));
                        validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                        //有效装机数
                        validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                        Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
                        BigDecimal a = new BigDecimal(phoneCounst);
                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                        // 放入List中
                        validMachineStatisticsResList.add(validMachineStatisticsRes);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validMachineStatisticsResList;
    }

    /**
     * 按时间查看
     *
     * @param validMachineStatisticsParameter
     * @return
     */
    public List<ValidMachineStatistic> statisByTime(ValidMachineStatisticsParameter validMachineStatisticsParameter) {
        List<ValidMachineStatistic> validMachineStatisticList = validMachineStatisticsDao.statisByTimeNiceAndSale(validMachineStatisticsParameter);
        List<ValidMachineStatistic> validMachineStatisticsResList = new ArrayList<ValidMachineStatistic>();
        try {
            Integer appCounts = 16;
            ValidMachineStatistic validMachineStatisticsRes = null;
            Integer listSize = validMachineStatisticList.size();
            for (int i = 0; i < listSize; i++) {
                if (validMachineStatisticList.get(i).getTime() != null && !validMachineStatisticList.get(i).getTime().equals("")) {
                    if (validMachineStatisticsRes == null || !validMachineStatisticsRes.getTime().equals(validMachineStatisticList.get(i).getTime())) {
                        if (validMachineStatisticsRes != null && !validMachineStatisticsRes.getTime().equals(validMachineStatisticList.get(i).getTime())) {
                            //精彩推荐应用收入
                            Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                            BigDecimal b = new BigDecimal(nicePrice);
                            double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setNicePrice(f2);

                            //卖场专区应用收入
                            Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                            BigDecimal c = new BigDecimal(salePrice);
                            double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setSalePirce(f3);

                            // 应用总收入
                            BigDecimal b1 = new BigDecimal(Double.toString(f2));
                            BigDecimal b2 = new BigDecimal(Double.toString(f3));
                            validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                            //有效装机数
                            validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                            Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
                            BigDecimal a = new BigDecimal(phoneCounst);
                            double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                            // 放入List中
                            validMachineStatisticsResList.add(validMachineStatisticsRes);
                        }
                        validMachineStatisticsRes = new ValidMachineStatistic();
                        validMachineStatisticsRes.setTime(validMachineStatisticList.get(i).getTime());
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    } else {
                        if (validMachineStatisticList.get(i).getFlag() != null) {
                            //取精彩推荐信息
                            if (validMachineStatisticList.get(i).getFlag().intValue() == 0) {
                                validMachineStatisticsRes.setNiceCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                                //取卖场专区信息
                            } else if (validMachineStatisticList.get(i).getFlag().intValue() == 1) {
                                validMachineStatisticsRes.setSaleCount(validMachineStatisticList.get(i).getInstallAppsCounts());
                            }
                        }
                    }
                    //     循环结束，将最后一个元素放入List
                    if (i == (listSize - 1)) {
                        //精彩推荐应用收入
                        Double nicePrice = validMachineStatisticsRes.getNiceCount() * IncomePrice.JINGCTUIJIANYINGYONG_COMPANY;
                        BigDecimal b = new BigDecimal(nicePrice);
                        double f2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setNicePrice(f2);

                        //卖场专区应用收入
                        Double salePrice = validMachineStatisticsRes.getSaleCount() * IncomePrice.ZHUANGJIBIBEI_COMPANY;
                        BigDecimal c = new BigDecimal(salePrice);
                        double f3 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setSalePirce(f3);

                        // 应用总收入
                        BigDecimal b1 = new BigDecimal(Double.toString(f2));
                        BigDecimal b2 = new BigDecimal(Double.toString(f3));
                        validMachineStatisticsRes.setTotalPrice(b1.add(b2).doubleValue());

                        //有效装机数
                        validMachineStatisticsRes.setTotalAppCount(validMachineStatisticsRes.getNiceCount() + validMachineStatisticsRes.getSaleCount());
                        Double phoneCounst = (double) validMachineStatisticsRes.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
                        BigDecimal a = new BigDecimal(phoneCounst);
                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        validMachineStatisticsRes.setVaildInstallPhoneCounts(f1);

                        // 放入List中
                        validMachineStatisticsResList.add(validMachineStatisticsRes);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validMachineStatisticsResList;
    }

    public void setValidMachineStatisticsDao(ValidMachineStatisticsDaoBAK validMachineStatisticsDao) {
        this.validMachineStatisticsDao = validMachineStatisticsDao;
    }


}
