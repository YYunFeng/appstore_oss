package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.enumtype.DateConversionObj;
import com.jd.appstore.domain.utils.DateConversion;
import com.jd.cms.dao.appManagement.SalesStatisticsDao;
import com.jd.cms.domain.appManagement.*;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.manager.appManagement.SalesStatisticsManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.schedule.impl.SyncScheduleManagerImpl;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class SalesStatisticsManagerImpl extends BaseManager implements SalesStatisticsManager {
    private SalesStatisticsDao salesStatisticsDao;
    private String installLogExcelPath;
    private final static Logger log = Logger.getLogger(SalesStatisticsManagerImpl.class);
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;

    public List<SalerRankingRes> getSalerRanking(SalerRankingParameter salerRankingParameter) {
        List<SalerRankingRes> salerRankingResList = null;
        List<SalerRankingRes> salerRankingResTemp = new ArrayList<SalerRankingRes>();
        SalerRankingRes salerRankingRes = null;
        try {
            salerRankingResList = salesStatisticsDao.getSalerRanking(salerRankingParameter);
            if (salerRankingResList != null && salerRankingResList.size() != 0) {
                for (int i = 0; i < salerRankingResList.size(); i++) {
                    salerRankingResList.get(i).setAverageInstallTimes(salerRankingResList.get(i).getInstallTimes() / salerRankingResList.get(i).getPhoneTimes());
                    if (salerRankingResList.get(i).getAverageInstallTimes() < salerRankingParameter.getAverageInstallTimes()) {  // 平均每台手机安装台数,不记录排名
                        salerRankingRes = new SalerRankingRes();
                        salerRankingRes.setRanking(false);
                        salerRankingRes.setAverageInstallTimes(salerRankingResList.get(i).getAverageInstallTimes());
                        salerRankingRes.setInstallTimes(salerRankingResList.get(i).getInstallTimes());
                        salerRankingRes.setPhoneTimes(salerRankingResList.get(i).getPhoneTimes());
                        salerRankingRes.setSaler(salerRankingResList.get(i).getSaler());
                        salerRankingResTemp.add(salerRankingRes);
                        salerRankingResList.remove(i);
                        i = i - 1;
                    } else {
                        salerRankingResList.get(i).setRanking(true);
                    }
                }
                salerRankingResList.addAll(salerRankingResTemp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salerRankingResList;
    }

    /**
     * 获取phone安装信息
     *
     * @return
     */
    public PaginatedList<PhoneIntallMess> getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter, int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<PhoneIntallMess> phoneIntallMessPaginatedList = new PaginatedArrayList<PhoneIntallMess>(pageIndex, pageSize);
        try {
            if (StringUtils.isNotBlank(phoneIntallMessParameter.getAppName())) {
                List<Integer> appids = salesStatisticsDao.searchAppName(phoneIntallMessParameter.getAppName());
                phoneIntallMessParameter.setAppids(appids);
            }
            int total = salesStatisticsDao.getPhoneImeiInstallMessCounts(phoneIntallMessParameter);
            if (total > 0) {
                phoneIntallMessPaginatedList.setTotalItem(total);
                phoneIntallMessParameter.setStartRow((pageIndex - 1) * pageSize);
                phoneIntallMessParameter.setEndRow(pageSize);
                Map appName = salesStatisticsDao.appName();
                Map channelName = salesStatisticsDao.channelName();
                List<PhoneIntallMess> list = salesStatisticsDao.getPhoneInstallMess(phoneIntallMessParameter);
                for (PhoneIntallMess phoneIntallMess : list) {
                    phoneIntallMess.setAppName((String) appName.get(phoneIntallMess.getAppid()));
                    phoneIntallMess.setCname((String) channelName.get(phoneIntallMess.getCid()));
                }
                phoneIntallMessPaginatedList.addAll(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phoneIntallMessPaginatedList;
    }

    public List<PhoneIntallMess> getPhoneInstallMessExcel(PhoneIntallMessParameter phoneIntallMessParameter) {
        List<PhoneIntallMess> list = salesStatisticsDao.getPhoneInstallMess(phoneIntallMessParameter);
        if (StringUtils.isNotBlank(phoneIntallMessParameter.getAppName())) {
            List<Integer> appids = salesStatisticsDao.searchAppName(phoneIntallMessParameter.getAppName());
            phoneIntallMessParameter.setAppids(appids);
        }
        Map appName = salesStatisticsDao.appName();
        Map channelName = salesStatisticsDao.channelName();
        for (PhoneIntallMess phoneIntallMess : list) {
            phoneIntallMess.setAppName((String) appName.get(phoneIntallMess.getAppid()));
            phoneIntallMess.setCname((String) channelName.get(phoneIntallMess.getCid()));
        }
        return list;
    }

    public PaginatedList<DayIntallLog> byDayCheckInstall(int pageIndex, int pageSize) {
        PaginatedList<DayIntallLog> padImeiNumberPaginatedArrayList = new PaginatedArrayList<DayIntallLog>(pageIndex, pageSize);
        try {
            int totalItem = salesStatisticsDao.installMessCount();
            if (totalItem != 0) {
                BaseQuery baseQuery = new BaseQuery();
                if (pageIndex == 0) {
                    pageIndex = 1;
                }
                padImeiNumberPaginatedArrayList.setTotalItem(totalItem);
                baseQuery.setStartRow((pageIndex - 1) * pageSize);
                baseQuery.setEndRow(pageSize);
                List<DayIntallLog> dayIntallLogList = salesStatisticsDao.byDayCheckInstall(baseQuery);
                if (dayIntallLogList != null && dayIntallLogList.size() != 0) {
                    DecimalFormat df = new DecimalFormat(".#");
                    for (DayIntallLog dayIntallLog : dayIntallLogList) {
                        dayIntallLog.setPhoneAverageInstallTimes(df.format((double) dayIntallLog.getAppsTimes() / (double) dayIntallLog.getPhoneTimes()));
                        dayIntallLog.setShopAverageInstallTimes(df.format((double) dayIntallLog.getPhoneTimes() / (double) dayIntallLog.getShopTimes()));
                    }
                }
                padImeiNumberPaginatedArrayList.addAll(dayIntallLogList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return padImeiNumberPaginatedArrayList;
    }

    public List<DayIntallLog> byDayCheckInstallExcel() {
        List<DayIntallLog> dayIntallLogList = null;
        try {
            dayIntallLogList = salesStatisticsDao.byDayCheckInstallExcel();
            if (dayIntallLogList != null && dayIntallLogList.size() != 0) {
                DecimalFormat df = new DecimalFormat(".#");
                for (DayIntallLog dayIntallLog : dayIntallLogList) {
                    dayIntallLog.setPhoneAverageInstallTimes(df.format((double) dayIntallLog.getAppsTimes() / (double) dayIntallLog.getPhoneTimes()));
                    dayIntallLog.setShopAverageInstallTimes(df.format((double) dayIntallLog.getPhoneTimes() / (double) dayIntallLog.getShopTimes()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayIntallLogList;
    }

    public void setSalesStatisticsDao(SalesStatisticsDao salesStatisticsDao) {
        this.salesStatisticsDao = salesStatisticsDao;
    }

    public String getInstallLogExcelPath() {
        return installLogExcelPath;
    }

    public List<ProvinceStatisRes> provinceStatis(ProvinceStatisParameter provinceStatisParameter) {
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        List<ProvinceStatisRes> provinceStatisReses = (List<ProvinceStatisRes>) cacheUtils.get("INSTALLBYCHANNEL_" + ip);

        try {
            if (provinceStatisParameter != null) {

                DateConversionObj dateConversionObjStartTime = DateConversion.dataConversion(provinceStatisParameter.getStartTime());
                provinceStatisParameter.setStartYear(dateConversionObjStartTime.getYear());
                provinceStatisParameter.setStartMonth(dateConversionObjStartTime.getMonth());
                provinceStatisParameter.setStartDay(dateConversionObjStartTime.getDay());

                DateConversionObj dateConversionObjEndTime = DateConversion.dataConversion(provinceStatisParameter.getEndTime());
                provinceStatisParameter.setEndYear(dateConversionObjEndTime.getYear());
                provinceStatisParameter.setEndMonth(dateConversionObjEndTime.getMonth());
                provinceStatisParameter.setEndDay(dateConversionObjEndTime.getDay());

                provinceStatisParameter.setFlagTime(provinceStatisParameter.getEndTime());
                // 取得结束日期的当月最后一天，用于数据库区分从来个分区取数据
                provinceStatisParameter.setEndTime(DateConversion.lastDay(provinceStatisParameter.getEndTime()));


                // 将每个渠道下的安装情况放入Mencaheded
                boolean flag = updateDate(provinceStatisParameter);  // false 不需要更新
                if (provinceStatisReses != null && !flag) {
                    provinceStatisReses = (List<ProvinceStatisRes>) cacheUtils.get("INSTALLBYCHANNEL_" + ip);
                } else {
                    provinceStatisReses = salesStatisticsDao.installByChannel(provinceStatisParameter);
                    log.info("从数据库中取数据");
                    if (provinceStatisReses != null) {
                        cacheUtils.set("INSTALLBYCHANNEL_" + ip, CategoryConstants.CMS_EXPIRE_TIME, provinceStatisReses);
                    }
                }

                // 将促销的安装天数放入Mencaheded
                List<ProvinceStatisRes> intallSalerList = (List<ProvinceStatisRes>) cacheUtils.get("INSTALLSALERLIST_" + ip);
                if (intallSalerList == null || flag) {
                    intallSalerList = salesStatisticsDao.intallSalerTime(provinceStatisParameter);
                    log.info("从数据库中取数据");
                    if (intallSalerList != null) {
                        cacheUtils.set("INSTALLSALERLIST_" + ip, CategoryConstants.CMS_EXPIRE_TIME, intallSalerList);
                    }
                }


                List<ProvinceStatisRes> incomeList = salesStatisticsDao.getIncome(provinceStatisParameter);
                String time = null;
                if (StringUtils.isNotBlank(provinceStatisParameter.getStartTime())) {
                    time = provinceStatisParameter.getStartTime().substring(0, provinceStatisParameter.getStartTime().lastIndexOf("-"));
                }
                List<InstaisticNorm> instaisticNormList = salesStatisticsDao.getInstaisticNormList(time);
                if (StringUtils.isNotBlank(provinceStatisParameter.getStartTime()) && StringUtils.isNotBlank(provinceStatisParameter.getEndTime())) {
                    int days = daysBetween(provinceStatisParameter.getStartTime(), provinceStatisParameter.getEndTime()) + 1;
                    for (ProvinceStatisRes provinceStatisRes : provinceStatisReses) {
                        if (intallSalerList != null) {
                            for (ProvinceStatisRes intallSaler : intallSalerList) {
                                if (provinceStatisRes.getCid().equals(intallSaler.getCid())) {
                                    provinceStatisRes.setIntallSalerTimes(intallSaler.getIntallSalerTimes());
                                    if (days == 1) { //       人均安装量
                                        double perInstallTimes = (double) provinceStatisRes.getPhoneTimes() / intallSaler.getIntallSalerTimes();
                                        BigDecimal a = new BigDecimal(perInstallTimes);
                                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        provinceStatisRes.setPerInstallTimes(f1);
                                        provinceStatisRes.setFlag(0); //按日统计
                                    } else {
                                        double intallSalerTimes = (double) intallSaler.getIntallSalerTimes() / days;
                                        BigDecimal a = new BigDecimal(intallSalerTimes);
                                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        provinceStatisRes.setIntallSalerTimes(f1);
                                        provinceStatisRes.setFlag(1); //按月统计
                                    }
                                }
                            }
                        }
                        if (incomeList != null) {
                            for (ProvinceStatisRes incomeRes : incomeList) {
                                if (provinceStatisRes.getCid().equals(incomeRes.getCid())) {
                                    BigDecimal b1 = new BigDecimal(Double.toString(incomeRes.getRecIncome()));
                                    BigDecimal b2 = new BigDecimal(Double.toString(incomeRes.getNeedIncome()));
                                    DecimalFormat df = new DecimalFormat(".##");
                                    double d = b1.add(b2).doubleValue();
                                    String st = df.format(d);
                                    provinceStatisRes.setIncome(Double.valueOf(st));
                                }
                            }
                        }
                        if (instaisticNormList != null && instaisticNormList.size() > 0) {
                            for (InstaisticNorm instaisticNorm : instaisticNormList) {
                                if (provinceStatisRes.getCid().equals(instaisticNorm.getCid())) {
                                    NumberFormat nt = NumberFormat.getPercentInstance();
                                    nt.setMinimumFractionDigits(2);
                                    //  完成率
                                    if (instaisticNorm.getIncomeTarget() != null) {
                                        provinceStatisRes.setIncomeTarget(instaisticNorm.getIncomeTarget());
                                        double completionRate = (double) provinceStatisRes.getIncome() / instaisticNorm.getIncomeTarget();
                                        provinceStatisRes.setCompletionRate(nt.format(completionRate));
                                    }
                                    // 人均日安装台数
                                    if (instaisticNorm.getDeployPeople() != null && days > 0) {
                                        provinceStatisRes.setDeployPeople(instaisticNorm.getDeployPeople());
                                        double perPhones = (double) provinceStatisRes.getPhoneTimes() / instaisticNorm.getDeployPeople();
                                        double everyPerPhones = perPhones / days;
                                        BigDecimal a = new BigDecimal(everyPerPhones);
                                        double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        provinceStatisRes.setEveryPerPhones(f1);
                                    }

                                    // 台数达成率
                                    if (provinceStatisRes.getIntallSalerTimes() != null && instaisticNorm.getEveryPerphonesTarget() != null) {
                                        provinceStatisRes.setEveryPerPhonesTarget(instaisticNorm.getEveryPerphonesTarget());
                                        double phoneCompletionRate = (double) provinceStatisRes.getEveryPerPhones() / instaisticNorm.getEveryPerphonesTarget();
                                        provinceStatisRes.setPhoneCompletionRate(nt.format(phoneCompletionRate));
                                    }

                                    // 日均活跃人数比例
                                    if (instaisticNorm.getDeployPeople() != null) {
                                        double activeRatio = (double) provinceStatisRes.getIntallSalerTimes() / instaisticNorm.getDeployPeople();
                                        provinceStatisRes.setActiveRatio(nt.format(activeRatio));
                                    }

                                }
                            }
                        }
                        /*if (arrTimesList != null) {
                            for (ProvinceStatisRes arrTimesRes : arrTimesList) {
                                if (provinceStatisRes.getCid().equals(arrTimesRes.getCid())) {
                                    if (provinceStatisRes.getFlag().intValue() == 1) { // 计算到达率
                                        double arrRate = (double) arrTimesRes.getArrTimes() / provinceStatisRes.getIntallTimes();
                                        NumberFormat nt = NumberFormat.getPercentInstance();
                                        nt.setMinimumFractionDigits(2);
                                        //最后格式化并输出
                                        provinceStatisRes.setArrRate(nt.format(arrRate));
                                    }
                                }
                            }
                        }*/
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceStatisReses;
    }

    public Integer getInstaisticNorm(InstaisticNorm instaisticNorm) {
        return salesStatisticsDao.getInstaisticNorm(instaisticNorm);
    }

    public void createInstaisticNorm(InstaisticNorm instaisticNorm) {
        salesStatisticsDao.createInstaisticNorm(instaisticNorm);
    }

    public void updateInstaisticNorm(InstaisticNorm instaisticNorm) {
        salesStatisticsDao.updateInstaisticNorm(instaisticNorm);
    }


    public List<PadChannel> padChannelList() {
        List<PadChannel> list = new ArrayList<PadChannel>();
        Set<Map.Entry<Integer, String>> set = salesStatisticsDao.channelName().entrySet();
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        //将map对象里面的属性循环遍历出来
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            //得到value值，装到list里面，也可以entry.getKey()。
            //如果2个都需要装。可以弄成一个对象来装
            PadChannel padChannel = new PadChannel();
            if (entry.getKey().intValue() != 138) {
                padChannel.setId(entry.getKey());
                padChannel.setCname(entry.getValue());
                list.add(padChannel);
            }

        }
        return list;
    }

    public void setInstallLogExcelPath(String installLogExcelPath) {
        this.installLogExcelPath = installLogExcelPath;
    }

    /**
     * 计算两个日期之间相差的天数
     * 字符串的日期格式的计算
     */
    public int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    // 该方法用于判断是否需要重新从数据库取数据
    public boolean updateDate(ProvinceStatisParameter provinceStatisParameter) {
        boolean flag = true;
        if (StringUtils.isNotBlank(DateConversion.starTime) && StringUtils.isNotBlank(DateConversion.endTime)) {
            if (DateConversion.starTime.equals(provinceStatisParameter.getStartTime()) && DateConversion.endTime.equals(provinceStatisParameter.getFlagTime())) {
                flag = false;  // false 不需要更新
            } else {
                DateConversion.starTime = provinceStatisParameter.getStartTime();
                DateConversion.endTime = provinceStatisParameter.getFlagTime();
            }
        } else {
            DateConversion.starTime = provinceStatisParameter.getStartTime();
            DateConversion.endTime = provinceStatisParameter.getFlagTime();
        }
        return flag;
    }
}
