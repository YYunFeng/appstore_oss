package com.jd.cms.manager.schedule.impl;

import com.jd.appstore.domain.*;
import com.jd.appstore.domain.utils.IncomePrice;
import com.jd.cms.dao.clientmanager.CpDateImportDao;
import com.jd.cms.dao.schedule.SyncScheduleDao;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.cms.domain.systemmaintenance.*;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.clientmanager.CpDateImportManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.common.manager.BaseManager;
import com.jd.digital.common.util.cache.CacheUtils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 * 周期同步任务
 */
public class SyncScheduleManagerImpl extends BaseManager implements SyncScheduleManager {
    private final static Logger log = Logger.getLogger(SyncScheduleManagerImpl.class);
    private SyncScheduleDao syncScheduleDao;
    private CpDateImportDao cpDateImportDao;

    private String filePath;


    /**
     * 查询周期性同步任务信息
     *
     * @param taskTypeId
     * @param status
     * @return
     */
    public TaskInfoResult findSyncTaskInfo(String taskTypeId, int status) {
        TaskInfoResult taskInfoResult = new TaskInfoResult();
        TaskInfoQuery taskInfoQuery = new TaskInfoQuery();
        taskInfoQuery.setTaskTypeId(taskTypeId);
        taskInfoQuery.setStatus(status);
        try {
            taskInfoResult = syncScheduleDao.findSyncTaskInfo(taskInfoQuery);
        } catch (Exception ex) {
            log.error("findTaskInfo 查询同步任务方法 taskTypeId=" + taskTypeId + " status" + status + " error!", ex);
            throw new RuntimeException("findTaskInfo 查询同步任务方法 taskTypeId=" + taskTypeId + " status" + status + " error!", ex);
        }
        return taskInfoResult;
    }

    /**
     * 更新类目信息
     *
     * @param categoryList SDK类目实体
     * @return
     */
    public int createCategory(final List<com.jd.digital.common.rpc.domain.bean.category.Category> categoryList) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    if (categoryList.size() > 0) {
                        for (int i = 0; i < categoryList.size(); i++) {
                            //实例化
                            com.jd.appstore.domain.Category category = new com.jd.appstore.domain.Category();
                            category.setCategoryId(categoryList.get(i).getId());
                            category.setCategoryName(categoryList.get(i).getName());
                            category.setLevel(categoryList.get(i).getLev() + 1);
                            category.setParentId(categoryList.get(i).getFid());
                            category.setLeaf(categoryList.get(i).getLev());
                            category.setPubedStatus(categoryList.get(i).getStatus());
                            //更新类目，并返回成功、失败标识
                            int ischeduleDao = syncScheduleDao.updateCategory(category);
                            //判断更新是否成功
                            if (ischeduleDao != 1) {
                                //更新不成功，则代表数据库里没此类目信息，所以插入新类目到数据库
                                syncScheduleDao.createCategory(category);
                            }
                        }
                        //删除下柜类目
                        syncScheduleDao.deleteCategory();
                        //更新类目过期状态成未过期
                        syncScheduleDao.updateAllCategory();
                    }
                } catch (Exception ex) {
                    log.error("createCategory 同步类目方法 categoryList=" + categoryList + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createCategory 同步类目方法 categoryList=" + categoryList + " error!", ex);
                }
            }
        });
        return 1;
    }

    /**
     * 按应用统计前一天的下载次数
     *
     * @return
     */
    public List<AppDownloadStat> findAppDownloadStat() {
        List<AppDownloadStat> appDownloadStatList;
        try {
            appDownloadStatList = syncScheduleDao.findAppDownloadStat();
        } catch (Exception ex) {
            log.error("findAppDownloadStat 查询应用下载统计结果方法 error!", ex);
            throw new RuntimeException("findAppDownloadStat 查询应用下载统计结果方法 error!", ex);
        }
        return appDownloadStatList;
    }

    /**
     * 创建应用下载统计结果
     *
     * @param appDownloadStatList
     */
    public void createAppDownloadStat(final List<AppDownloadStat> appDownloadStatList) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    if (appDownloadStatList.size() > 0) {
                        AppDownloadStat appDownloadStat;
                        appDownloadStat = new AppDownloadStat();
                        appDownloadStat.setYear(appDownloadStatList.get(0).getYear());
                        appDownloadStat.setMonth(appDownloadStatList.get(0).getMonth());
                        appDownloadStat.setDay(appDownloadStatList.get(0).getDay());
                        //删除年月日一同样的下载统计记录
                        syncScheduleDao.deleteAppDownloadStat(appDownloadStat);
                        for (int i = 0; i < appDownloadStatList.size(); i++) {
                            appDownloadStat = new AppDownloadStat();
                            appDownloadStat = (AppDownloadStat) appDownloadStatList.get(i);
                            appDownloadStat.setId((int) sequenceUtil.get(SequenceConstants.APP_DOWNLOAD_STAT));
                            syncScheduleDao.createAppDownloadStat(appDownloadStat);
                        }
                    }
                } catch (Exception ex) {
                    log.error("createAppDownloadStat 增加应用下载统计结果方法 appDownloadStatList=" + appDownloadStatList + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createAppDownloadStat 增加应用下载统计结果方法 appDownloadStatList=" + appDownloadStatList + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询排行榜锁定记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingApp(RankingApp rankingApp) {
        List<RankingApp> rankingAppList;
        try {
            rankingAppList = syncScheduleDao.findRankingApp(rankingApp);
        } catch (Exception ex) {
            log.error("findRankingApp 查询排行榜锁定记录方法 rankingApp=" + rankingApp + " error!", ex);
            throw new RuntimeException("findRankingApp 查询排行榜锁定记录方法 rankingApp=" + rankingApp + " error!", ex);
        }
        return rankingAppList;
    }

    /**
     * 查询最新上架记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppNewest(RankingApp rankingApp) {
        List<RankingApp> rankingAppNewestList;
        try {
            rankingAppNewestList = syncScheduleDao.findRankingAppNewest(rankingApp);
        } catch (Exception ex) {
            log.error("findRankingAppNewest 查询最新上架记录方法 rankingApp=" + rankingApp + " error!", ex);
            throw new RuntimeException("findRankingAppNewest 查询最新上架记录方法 rankingApp=" + rankingApp + " error!", ex);
        }
        return rankingAppNewestList;
    }

    /**
     * 更新排行榜
     *
     * @param rankingAppNewestList
     * @param rankingAppList
     * @param rankingStyle
     * @param rankingType
     */
    public void updateRankingAppNewest(final List<RankingApp> rankingAppNewestList, final List<RankingApp> rankingAppList, final int rankingStyle, final int rankingType) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    RankingApp rankingApp;
                    rankingApp = new RankingApp();
                    rankingApp.setRankingStyle(rankingStyle);
                    rankingApp.setRankingType(rankingType);
                    //删除未被锁定记录
                    syncScheduleDao.deleteRankingApp(rankingApp);
                    int orderSeq = 1;/*序号*/
                    //循环设置序号
                    if (rankingAppNewestList.size() > 0) {
                        for (int i = 0; i < rankingAppNewestList.size(); ) {
                            int index = 0;
                            if (rankingAppList.size() > 0) {
                                for (int j = 0; j < rankingAppList.size(); j++) {
                                    if (rankingAppList.get(j).getOrderSeq() == orderSeq) {
                                        index++;
                                        break;
                                    }
                                }
                            }
                            if (index != 0) {
                                orderSeq++;
                            } else {
                                rankingApp = new RankingApp();
                                rankingApp.setId((int) sequenceUtil.get(SequenceConstants.CMS_RANKING_APP));
                                rankingApp.setRankingStyle(rankingStyle);
                                rankingApp.setRankingType(rankingType);
                                rankingApp.setAppId(rankingAppNewestList.get(i).getAppId());
                                rankingApp.setOrderSeq(orderSeq);
                                rankingApp.setPubedStatus(1);
                                rankingApp.setLocked(0);
                                syncScheduleDao.createRankingApp(rankingApp);
                                orderSeq++;
                                i++;
                            }
                        }
                    }
                } catch (Exception ex) {
                    log.error("updateRankingAppNewest 更新排行榜方法 rankingAppNewestList=" + rankingAppNewestList + " rankingAppList" + rankingAppList + " rankingStyle" + rankingStyle + " rankingType" + rankingType + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateRankingAppNewest 更新排行榜方法 rankingAppNewestList=" + rankingAppNewestList + " rankingAppList" + rankingAppList + " rankingStyle" + rankingStyle + " rankingType" + rankingType + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询热门收费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFee(RankingApp rankingApp) {
        List<RankingApp> rankingAppFeeList;
        try {
            rankingAppFeeList = syncScheduleDao.findRankingAppFee(rankingApp);
        } catch (Exception ex) {
            log.error("findRankingAppFee 查询热门收费记录方法 rankingApp=" + rankingApp + " error!", ex);
            throw new RuntimeException("findRankingAppFee 查询热门收费记录方法 rankingApp=" + rankingApp + " error!", ex);
        }
        return rankingAppFeeList;
    }

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFree(RankingApp rankingApp) {
        List<RankingApp> rankingAppFreeList;
        try {
            rankingAppFreeList = syncScheduleDao.findRankingAppFree(rankingApp);
        } catch (Exception ex) {
            log.error("findRankingAppFree 查询热门免费记录方法 rankingApp=" + rankingApp + " error!", ex);
            throw new RuntimeException("findRankingAppFree 查询热门免费记录方法 rankingApp=" + rankingApp + " error!", ex);
        }
        return rankingAppFreeList;
    }

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFastest(RankingApp rankingApp) {
        List<RankingApp> rankingAppFastestList;
        try {
            rankingAppFastestList = syncScheduleDao.findRankingAppFastest(rankingApp);
        } catch (Exception ex) {
            log.error("findRankingAppFree 查询热门免费记录方法 rankingApp=" + rankingApp + " error!", ex);
            throw new RuntimeException("findRankingAppFree 查询热门免费记录方法 rankingApp=" + rankingApp + " error!", ex);
        }
        return rankingAppFastestList;
    }

    /**
     * 更新周期性任务起动时间
     *
     * @param id
     * @param startTimeFact
     */
    public void updateTaskFactTime(final int id, final Date startTimeFact) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    TaskInfoQuery taskInfoQuery = new TaskInfoQuery();
                    taskInfoQuery.setId(id);
                    taskInfoQuery.setStartTimeFact(startTimeFact);
                    syncScheduleDao.updateTaskFactTime(taskInfoQuery);
                } catch (Exception ex) {
                    log.error("updateTaskFactTime 更新周期性任务起动时间方法 id=" + id + " startTimeFact" + startTimeFact + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTaskFactTime 更新周期性任务起动时间方法 id=" + id + " startTimeFact" + startTimeFact + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询合同预警期内CP信息
     *
     * @return
     */
    public List<CpInfoResult> findCpInfoResult() {
        List<CpInfoResult> cpReginfoList;
        try {
            cpReginfoList = syncScheduleDao.findCpInfoResult();
        } catch (Exception ex) {
            log.error("findCpReginfos 查询合同预警期内CP信息方法 error!", ex);
            throw new RuntimeException("findCpReginfos 查询合同预警期内CP信息方法 error!", ex);
        }
        return cpReginfoList;
    }

    /**
     * 更新合同预警状态
     *
     * @param cpBaseInfo
     */
    public void updateCpBaseInfo(final CpBaseInfo cpBaseInfo) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    syncScheduleDao.updateCpBaseInfo(cpBaseInfo);
                } catch (Exception ex) {
                    log.error("updateCpBaseInfo 更新合同预警状态方法 cpBaseInfo=" + cpBaseInfo + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateCpBaseInfo 更新合同预警状态方法 cpBaseInfo=" + cpBaseInfo + " error!", ex);
                }
            }
        });
    }

    /**
     * 创建应用下载汇总
     */
    public void createDownloadTotalstat() {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //统计应用下载汇总
                    List<DownloadTotalstat> downloadTotalstatList = syncScheduleDao.findDownloadTotalstat();
                    if (downloadTotalstatList.size() > 0) {
                        //删除应用下载汇总表
                        syncScheduleDao.deleteDownloadTotalstat();
                        for (int i = 0; i < downloadTotalstatList.size(); i++) {
                            DownloadTotalstat downloadTotalstat = new DownloadTotalstat();
                            downloadTotalstat.setId((int) sequenceUtil.get(SequenceConstants.CMS_DOWNLOADTOTALSTAT_SEQUENCE));
                            downloadTotalstat.setAppId(downloadTotalstatList.get(i).getAppId());
                            downloadTotalstat.setDownloadTimes(downloadTotalstatList.get(i).getDownloadTimes());
                            //插入应用下载汇总表
                            syncScheduleDao.createDownloadTotalstat(downloadTotalstat);
                        }
                    }
                } catch (Exception ex) {
                    log.error("createDownloadTotalstat 新增下载汇总信息方法 error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createDownloadTotalstat 新增下载汇总信息方法 error!", ex);
                }
            }
        });
    }


    /**
     * 创建营销日志
     */
    public void createMarketLog() {
        log.info("营销日志入库开始");
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    Integer offlineId = syncScheduleDao.getOfflineLogMaxId();
                    Integer onlineId = syncScheduleDao.getOnlineLogMaxId();
                    // 获得离线应用安装日志
                    List<InstallStat> offlineSaleLog = syncScheduleDao.getOfflineSaleLog(offlineId);
                    // 获得在线应用安装日志
                    List<InstallStat> onlineSaleLog = syncScheduleDao.getOnlineSaleLog(onlineId);
                    int offlineLogSize = offlineSaleLog.size();
                    int onlineLogSize = onlineSaleLog.size();

                    // 离线应用日志统计入最终结果表
                    if (offlineLogSize > 0) {
                        log.info("离线应用营销日志入库开始");
                        for (int i = 0; i < offlineLogSize; i++) {
                            Integer id = (int) sequenceUtil.get(SequenceConstants.CMS_OFFLINEINSTALLSTAT_SEQUENCE);
                            offlineSaleLog.get(i).setId(id);
                            syncScheduleDao.createOfflineInstallStats(offlineSaleLog.get(i));
                        }
                        // 更新离线应用中间表标示
                        syncScheduleDao.updateStatisticsStatusOffline(offlineId);
                        log.info("离线应用营销日志中间表标示更新完成");
                        log.info("离线应用营销日志入库结束");
                    }
                    // 在线应用日志统计入最终结果表
                    if (onlineLogSize > 0) {
                        log.info("在线应用营销日志入库开始");
                        for (int i = 0; i < onlineLogSize; i++) {
                            onlineSaleLog.get(i).setId((int) sequenceUtil.get(SequenceConstants.CMS_ONLINEINSTALLSTAT_SEQUENCE));
                            syncScheduleDao.createOnlineInstallStats(onlineSaleLog.get(i));
                        }
                        // 更新在线应用中间表标示
                        syncScheduleDao.updateStatisticsStatusOnline(onlineId);
                        log.info("在线应用营销日志中间表标示更新完成");
                        log.info("在线应用营销日志入库结束");
                    }
                    log.info("营销日志入库完成 离线日志入库条数：" + offlineLogSize + "，在线日志入库条数：" + onlineLogSize);
                } catch (Exception e) {
                    log.error("营销日志更新失败 失败信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void createIncomeStatistic() {
        log.info("--创建收入统计任务开始--");
        try {
            // 需要入库的List
            List<IncomeStatistic> incomeStatisticListRes = new ArrayList<IncomeStatistic>();

            Calendar c = Calendar.getInstance();
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            IncomeParameter income = new IncomeParameter();
            // 得到本月的那一天
            int today = c.get(c.DAY_OF_MONTH);
            // 判断是不是本月的第一天
            if (today == 1) {  //是
                c.setTime(new Date());
                c.add(Calendar.MONTH, -1);
                Date theDate = c.getTime();
                String st = datef.format(theDate);

                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, 1);
                c.add(Calendar.DATE, -1);
                String et = datef.format(c.getTime());
                income.setStartTime(st);
                income.setEndTime(et);

            } else {  // 否
                // 当前月的最后一天
                c.set(Calendar.DATE, 1);
                c.roll(Calendar.DATE, -1);
                Date endTime = c.getTime();
                String endTime1 = datef.format(endTime);

                //当前月的第一天
                c.set(GregorianCalendar.DAY_OF_MONTH, 1);
                Date beginTime = c.getTime();
                String beginTime1 = datef.format(beginTime);

                income.setStartTime(beginTime1);
                income.setEndTime(endTime1);
            }
            log.info("统计周期：" + income.getStartTime() + "-" + income.getEndTime());
            // 取出要统计的LIST--取出当月数据
            List<IncomeStatistic> incomeStatisticList = syncScheduleDao.getIncomeStatistic(income);
            // 总公司的应用价格和计费模式
            List<AppPrice> appPriceListCompany = syncScheduleDao.getAppPrice(0); // 0:总公司
            // 省办的应用价格和计费模式
            List<AppPrice> appPriceListProvince = syncScheduleDao.getAppPrice(1); // 1:省办

            // 精彩推荐 67，装机必备 106
            List<String> jingcaituijianAppId = syncScheduleDao.getTopicAppid(67);
            List<String> zhuangjibibeiAppId = syncScheduleDao.getTopicAppid(106);
            // 所有收费应用的APPID
            List<String> topicId = syncScheduleDao.topicAppIds();

            List<String> mineAppid = syncScheduleDao.getCompanyAppid(1); // 自有应用appid
            List<String> huashengAppid = syncScheduleDao.getCompanyAppid(0); // 华盛应用appid

            IncomeStatistic incomeStatistic = null;
            int listSize = incomeStatisticList.size();
            log.info("当月数据条数：" + listSize);
            if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                for (int i = 0; i < listSize; i++) {
                    // 按时间分出每个促销员的精彩推荐安装量和装机必备安装量
                    if (incomeStatisticList.get(i).getInstallTime() != null && !incomeStatisticList.get(i).getInstallTime().equals("") && incomeStatisticList.get(i).getSalerNo() != null && !incomeStatisticList.get(i).getSalerNo().equals("")) {
                        if (incomeStatistic == null || !incomeStatisticList.get(i).getInstallTime().equals(incomeStatistic.getInstallTime()) || !incomeStatisticList.get(i).getSalerNo().equals(incomeStatistic.getSalerNo())) {
                            //将数据放入输出List中去
                            if (incomeStatistic != null && !incomeStatisticList.get(i).getSalerNo().equals(incomeStatistic.getSalerNo())) {
                                // 拿促销员去查询安装精彩推荐的appid
                                if (incomeStatistic.getSalerNo() != null && incomeStatistic.getInstallTime() != null) {
                                    double huashengPrice = 0.0;
                                    double minePrice = 0.0;
                                    IncomeParameter incomeParameter = new IncomeParameter();
                                    incomeParameter.setSalerNo(incomeStatistic.getSalerNo());
                                    incomeParameter.setInstallTime(incomeStatistic.getInstallTime());
                                    incomeParameter.setStartTime(income.getStartTime());
                                    incomeParameter.setEndTime(income.getEndTime());
                                    //  计算有效装机数
//                                    incomeStatistic.setTotalAppCount(incomeStatistic.getRecommendAppCounts() + incomeStatistic.getNeedAppCounts());
//                                    Double phoneCounst = (double) incomeStatistic.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
//                                    BigDecimal a = new BigDecimal(phoneCounst);
//                                    double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                    incomeParameter.setAppids(topicId);
                                    // 装机数
                                    incomeStatistic.setVaildMachineCounts((double) syncScheduleDao.getPhoneInstallCounts(incomeParameter));
                                    // 安装的手机台数

                                    // 促销员某天的精彩推荐的安装appid 和 手机串号
                                    incomeParameter.setTopicAppids(jingcaituijianAppId);
                                    List<IncomeRes> incomeRecommendResList = getPhoneImei(syncScheduleDao.getSalePhoneImei(incomeParameter));
                                    int arrCounts = 0;
                                    if (incomeRecommendResList != null && incomeRecommendResList.size() > 0) {
                                        // 开始计算总公司的精彩推荐的价格
                                        if (appPriceListCompany != null && appPriceListCompany.size() > 0) {
                                            IncomeResCompanyObj incomeResCompanyObj = getPriceCompany(incomeRecommendResList, appPriceListCompany, 0, 0);
                                            huashengPrice = addition(huashengPrice, incomeResCompanyObj.getHuashengPrice());
                                            minePrice = addition(minePrice, incomeResCompanyObj.getMinePrice());
//                                            incomeStatistic.setRecommendAppIncomeForCompany(incomeResObj.getPrice());
                                        }
                                        // 开始计算精彩推荐省办的价格
                                        if (appPriceListProvince != null && appPriceListProvince.size() > 0) {
                                            IncomeResObj incomeResObj = getPriceAndArrcounts(incomeRecommendResList, appPriceListProvince, 1, 0);
                                            incomeStatistic.setRecommendAppIncomeForProvince(incomeResObj.getPrice());
                                            arrCounts = arrCounts + incomeResObj.getArrCount();
                                        }
                                    }
                                    // 促销员某天的装机必备的安装appid 和 手机串号
                                    incomeParameter.setTopicAppids(zhuangjibibeiAppId);
                                    List<IncomeRes> incomeResNeedList = getPhoneImei(syncScheduleDao.getSalePhoneImei(incomeParameter));
                                    if (incomeResNeedList != null && incomeResNeedList.size() > 0) {
                                        //  总公司装机必备的价格
                                        if (appPriceListCompany != null && appPriceListCompany.size() > 0) {
                                            IncomeResCompanyObj incomeResCompanyObj = getPriceCompany(incomeResNeedList, appPriceListCompany, 0, 1);
                                            huashengPrice = addition(huashengPrice, incomeResCompanyObj.getHuashengPrice());
                                            minePrice = addition(minePrice, incomeResCompanyObj.getMinePrice());
//                                            IncomeResObj incomeResObj = getPriceAndArrcounts(incomeResNeedList, appPriceListCompany, 0, 1);
//                                            incomeStatistic.setNeedAppIncomeForCompany(incomeResObj.getPrice());
                                        }
                                        //省办装机必备的价格
                                        if (appPriceListProvince != null && appPriceListProvince.size() > 0) {
                                            IncomeResObj incomeResObj = getPriceAndArrcounts(incomeResNeedList, appPriceListProvince, 1, 1);
                                            incomeStatistic.setNeedAppIncomeForProvince(incomeResObj.getPrice());
                                            arrCounts = arrCounts + incomeResObj.getArrCount();
                                        }
                                    }
                                    incomeStatistic.setArrCounts(arrCounts);
                                    incomeStatistic.setNeedAppIncomeForCompany(huashengPrice);
                                    incomeStatistic.setRecommendAppIncomeForCompany(minePrice);
                                    // 将数据放入要入库的List中
                                    incomeStatisticListRes.add(incomeStatistic);
                                }
                            }
                            incomeStatistic = new IncomeStatistic();
                            //安装时间
                            incomeStatistic.setInstallTime(incomeStatisticList.get(i).getInstallTime());
                            //渠道号
                            incomeStatistic.setCid(incomeStatisticList.get(i).getCid());
                            //促销员编号
                            incomeStatistic.setSalerNo(incomeStatisticList.get(i).getSalerNo());
                            // 促销员名字
                            incomeStatistic.setSalerName(incomeStatisticList.get(i).getSalerName());
                            // 标识 0：精彩推荐 1：装机必备
                            if (incomeStatisticList.get(i).getFlag() != null) {
                                //取精彩推荐信息
                                if (incomeStatisticList.get(i).getFlag().intValue() == 0) {
                                    incomeStatistic.setRecommendAppCounts(incomeStatisticList.get(i).getInstallAppsCounts());
                                } else if (incomeStatisticList.get(i).getFlag().intValue() == 1) {
                                    incomeStatistic.setNeedAppCounts(incomeStatisticList.get(i).getInstallAppsCounts());
                                }
                            }
                            // 计费所属公司： 0：华盛   1：自有
                            IncomeParameter incomeParameter = new IncomeParameter();
                            incomeParameter.setSalerNo(incomeStatistic.getSalerNo());
                            incomeParameter.setInstallTime(incomeStatistic.getInstallTime());
                            incomeParameter.setStartTime(income.getStartTime());
                            incomeParameter.setEndTime(income.getEndTime());
                            if (huashengAppid != null && huashengAppid.size() > 0) {
                                incomeParameter.setAppids(huashengAppid);
                                incomeStatistic.setHuashengAppCounts(syncScheduleDao.getCompanyAppInstallCounts(incomeParameter));
                            } else {
                                incomeStatistic.setHuashengAppCounts(0);
                            }
                            if (mineAppid != null && mineAppid.size() > 0) {
                                incomeParameter.setAppids(mineAppid);
                                incomeStatistic.setMineAppCounts(syncScheduleDao.getCompanyAppInstallCounts(incomeParameter));
                            } else {
                                incomeStatistic.setMineAppCounts(0);
                            }

                        } else {
                            // 标识 0：精彩推荐 1：装机必备
                            if (incomeStatisticList.get(i).getFlag() != null) {
                                //取精彩推荐信息
                                if (incomeStatisticList.get(i).getFlag().intValue() == 0) {
                                    incomeStatistic.setRecommendAppCounts(incomeStatisticList.get(i).getInstallAppsCounts());
                                } else if (incomeStatisticList.get(i).getFlag().intValue() == 1) {
                                    incomeStatistic.setNeedAppCounts(incomeStatisticList.get(i).getInstallAppsCounts());
                                }
                            }
                        }
                    }


                    if (i == (listSize - 1)) {
                        // 拿促销员去查询安装精彩推荐的appid
                        if (incomeStatistic.getSalerNo() != null && incomeStatistic.getInstallTime() != null) {
                            IncomeParameter incomeParameter = new IncomeParameter();
                            incomeParameter.setSalerNo(incomeStatistic.getSalerNo());
                            incomeParameter.setInstallTime(incomeStatistic.getInstallTime());
                            incomeParameter.setStartTime(income.getStartTime());
                            incomeParameter.setEndTime(income.getEndTime());
                           /* //  计算有效装机数
                            incomeStatistic.setTotalAppCount(incomeStatistic.getRecommendAppCounts() + incomeStatistic.getNeedAppCounts());
                            Double phoneCounst = (double) incomeStatistic.getTotalAppCount() / IncomePrice.VAILDMACHINECOUNTS;
                            BigDecimal a = new BigDecimal(phoneCounst);
                            double f1 = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            incomeStatistic.setVaildMachineCounts(f1);*/

                            incomeParameter.setAppids(topicId);
                            // 装机数
                            incomeStatistic.setVaildMachineCounts((double) syncScheduleDao.getPhoneInstallCounts(incomeParameter));

                            int arrCounts = 0;
                            // 促销员某天的精彩推荐的安装appid 和 手机串号
                            incomeParameter.setTopicAppids(jingcaituijianAppId);
                            List<IncomeRes> incomeRecommendResList = getPhoneImei(syncScheduleDao.getSalePhoneImei(incomeParameter));
                            double huashengPrice = 0.0;
                            double minePrice = 0.0;
                            if (incomeRecommendResList != null && incomeRecommendResList.size() > 0) {
                                // 开始计算总公司的精彩推荐的价格
                                if (appPriceListCompany != null && appPriceListCompany.size() > 0) {
                                    IncomeResCompanyObj incomeResCompanyObj = getPriceCompany(incomeRecommendResList, appPriceListCompany, 0, 0);
                                    huashengPrice = addition(huashengPrice, incomeResCompanyObj.getHuashengPrice());
                                    minePrice = addition(minePrice, incomeResCompanyObj.getMinePrice());
                                  /*  IncomeResObj incomeResObj = getPriceAndArrcounts(incomeRecommendResList, appPriceListCompany, 0, 0);
                                    incomeStatistic.setRecommendAppIncomeForCompany(incomeResObj.getPrice());*/
                                }
                                // 开始计算精彩推荐省办的价格
                                if (appPriceListProvince != null && appPriceListProvince.size() > 0) {
                                    IncomeResObj incomeResObj = getPriceAndArrcounts(incomeRecommendResList, appPriceListProvince, 1, 0);
                                    incomeStatistic.setRecommendAppIncomeForProvince(incomeResObj.getPrice());
                                    arrCounts = arrCounts + incomeResObj.getArrCount();
                                }
                            }
                            // 促销员某天的装机必备的安装appid 和 手机串号
                            incomeParameter.setTopicAppids(zhuangjibibeiAppId);
                            List<IncomeRes> incomeResNeedList = getPhoneImei(syncScheduleDao.getSalePhoneImei(incomeParameter));
                            if (incomeResNeedList != null && incomeResNeedList.size() > 0) {
                                //  总公司装机必备的价格
                                if (appPriceListCompany != null && appPriceListCompany.size() > 0) {
                                    IncomeResCompanyObj incomeResCompanyObj = getPriceCompany(incomeResNeedList, appPriceListCompany, 0, 1);
                                    huashengPrice = addition(huashengPrice, incomeResCompanyObj.getHuashengPrice());
                                    minePrice = addition(minePrice, incomeResCompanyObj.getMinePrice());
                                   /* IncomeResObj incomeResObj = getPriceAndArrcounts(incomeResNeedList, appPriceListCompany, 0, 1);
                                    incomeStatistic.setNeedAppIncomeForCompany(incomeResObj.getPrice());*/
                                }
                                //省办装机必备的价格
                                if (appPriceListProvince != null && appPriceListProvince.size() > 0) {
                                    IncomeResObj incomeResObj = getPriceAndArrcounts(incomeResNeedList, appPriceListProvince, 1, 1);
                                    incomeStatistic.setNeedAppIncomeForProvince(incomeResObj.getPrice());
                                    arrCounts = arrCounts + incomeResObj.getArrCount();
                                }
                            }
                            incomeStatistic.setArrCounts(arrCounts);
                            incomeStatistic.setRecommendAppIncomeForCompany(minePrice);
                            incomeStatistic.setNeedAppIncomeForCompany(huashengPrice);

                            // 将数据放入要入库的List中
                            incomeStatisticListRes.add(incomeStatistic);
                        }
                    }
                }
                log.info("开始入库。。。");
                // 如果数据库中有该条数据时，更新该条数据，若没有，往库中插了新的数据
                if (incomeStatisticListRes != null && incomeStatisticListRes.size() > 0) {
                    syncScheduleDao.createIncomeStatistic(incomeStatisticListRes);
                }
                log.info("入库结束");

            }

        } catch (Exception e) {
            log.error("系统异常,异常信息：" + e.getMessage());
        }
        log.info("--创建收入统计任务结束--");
    }

    /**
     * 促销员安装日志中间表统计
     */
    public void createSalerLog() {
        log.info("---促销员安装日志中间表统计入库开始---");
        try {
            Integer maxId = syncScheduleDao.getAppInstallLogMaxId();
            // 获得安装日志
            List<SalerInstallLog> salerInstallLogs = syncScheduleDao.salerInstallLog(maxId);
            // 应用日志统计入最终结果表
            log.info("--促销员安装日志入库开始，总条数:" + salerInstallLogs.size() + "条--");
            int i = 0;
            if (salerInstallLogs != null && salerInstallLogs.size() > 0) {
                for (SalerInstallLog salerInstallLog : salerInstallLogs) {
                    if (StringUtils.isNotBlank(salerInstallLog.getDeviceNo())) {
                        if (salerInstallLog.getDeviceNo().indexOf("d4:ee") > -1) {
                            salerInstallLog.setLogType(0);
                        } else {
                            salerInstallLog.setLogType(1);
                        }
                    }
                    try {
                        syncScheduleDao.createAppStatistic(salerInstallLog);
                        i = i + 1;
                    } catch (DataIntegrityViolationException ex) {
                        log.info("该数据已经存在！");
                    } catch (Exception e) {
                        log.info("异常信息：" + e.getMessage());
                    }
                }
                // 更新原始表标示
                syncScheduleDao.updateAppStatisticFlag(maxId);
            }
            log.info("--促销员安装日志入库完成,入库条数：" + i + "条--");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("---促销员安装日志中间表统计入库结束---");
    }

    public void salerArrStatistic() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        try {
            log.info("--开始调用帆悦接口获取到达数据--");
            StringBuffer fanyueUrl = new StringBuffer();
            fanyueUrl.append("http://221.179.191.228:8088/preset_chinaunicom/service/dyq.do?stat_date=");
            // 取当天的日期
            log.info("--帆悦到达日期：" + yesterday);
            fanyueUrl.append(yesterday);
            log.info(fanyueUrl);
            //创建连接
            URL url = new URL(fanyueUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.connect();
            //读取服务器响应响应
            InputStream in = connection.getInputStream();


            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String lines;
            StringBuffer sb = new StringBuffer("");
            Map map = syncScheduleDao.arrAppPackage();
            FanyueLog fanyueLog = new FanyueLog();
            int arrivePhoneCounts = 0;
            int arriveAppCounts = 0;

            // 创建文件
            File file = new File(filePath);
            String arrivePath = yesterday.trim() + "_fanyue" + System.currentTimeMillis() + ".txt";
            File arriveFile = null;
            if (!file.exists()) {
                file.mkdirs();
            }
            arriveFile = new File(filePath + "/" + arrivePath);
            if (!arriveFile.exists()) {
                arriveFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(arriveFile, false);
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                out.write((lines + "\n").getBytes("utf-8"));
                String[] strs = lines.split("\\|");
                ArrAppObj arrAppObj = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                SimpleDateFormat arriveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String[] packages = strs[2].split(",");
                if (StringUtils.isNotBlank(strs[0]) && StringUtils.isNotBlank(strs[1])) {
                    arrivePhoneCounts = arrivePhoneCounts + 1;
                    for (int j = 0; j < packages.length; j++) {
                        arrAppObj = new ArrAppObj();
                        arrAppObj.setPhoneImei(strs[0].trim());
                        arrAppObj.setCreated(arriveTime.format(sdf.parse(strs[1] + ":00")));
                        if (map.get(packages[j]) != null) {
                            arrAppObj.setAppid((Integer) map.get(packages[j]));
                            try {
                                syncScheduleDao.createFanyueArriveApp(arrAppObj);
                                arriveAppCounts = arriveAppCounts + 1;

                            } catch (Exception e) {
                                log.info("创建到达日志数据失败:" + e.getMessage());
                            }
                        }
                    }
                }
            }
            fanyueLog.setArrivePhoneCounts(arrivePhoneCounts);
            fanyueLog.setArriveAppCounts(arriveAppCounts);
            fanyueLog.setArriveFile(arrivePath);
            fanyueLog.setArriveTime(yesterday);
            syncScheduleDao.createFanyueLog(fanyueLog);
            reader.close();
            // 断开连接
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("--完成调用帆悦接口获取到达数据--");


        log.info("--开始统计到达数据--");
        //需要入库的List
        List<IncomeStatisticNew> list = new ArrayList<IncomeStatisticNew>();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
        IncomeParameter income = new IncomeParameter();

        // 得到本月的那一天
        int today = c.get(c.DAY_OF_MONTH);
        // 判断是不是本月的第一天
        if (today == 1) {  //是
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            Date theDate = c.getTime();
            String st = datef.format(theDate);

            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DATE, 1);
            c.add(Calendar.DATE, -1);
            String et = datef.format(c.getTime());
            income.setStartTime(st);
            income.setEndTime(et);
        } else {  // 否
            // 当前月的最后一天
            c.set(Calendar.DATE, 1);
            c.roll(Calendar.DATE, -1);

            //当前月的第一天
            c.set(GregorianCalendar.DAY_OF_MONTH, 1);
            Date beginTime = c.getTime();
            String beginTime1 = datef.format(beginTime);

            income.setStartTime(beginTime1);
            income.setEndTime(yesterday);
        }

        log.info("开始时间：" + income.getStartTime() + ",结束时间：" + income.getEndTime());

        // 到达应用appid
        List<String> arrAppList = syncScheduleDao.modelApps(2);
        // 激活应用appid
        List<String> actAppList = syncScheduleDao.modelApps(1);
        // 去掉去掉几个从接口取数据的应用列表
        List<String> actExtraAppList = syncScheduleDao.actAppids();
        /**
         * 计算激活率
         */
        //激活应用appids--这里的激活应用列表去掉几个从接口取数据的应用
        income.setAppids(actExtraAppList);
        //激活应用的安装量
        Integer actInstallCounts = syncScheduleDao.actInstallCounts(income);
        // 总的激活总数
        Integer totalActCounts = syncScheduleDao.totalActCounts(income);
        //激活率
        double actRate = (double) totalActCounts / actInstallCounts;

        List<String> appids = syncScheduleDao.priceApps();
        income.setAppids(appids);
        List<IncomeStatisticNew> incomeStatisticNewList = syncScheduleDao.appsInstallList(income);
        try {
            if (incomeStatisticNewList != null && incomeStatisticNewList.size() > 0) {
                IncomeStatisticNew incomeStatisticNew = null;
                for (int i = 0; i < incomeStatisticNewList.size(); i++) {
                    incomeStatisticNew = new IncomeStatisticNew();
                    incomeStatisticNew.setSalerNo(incomeStatisticNewList.get(i).getSalerNo());
                    incomeStatisticNew.setInstallTime(incomeStatisticNewList.get(i).getInstallTime());
                    incomeStatisticNew.setAppCounts(incomeStatisticNewList.get(i).getAppCounts());
                    incomeStatisticNew.setPhoneCounts(incomeStatisticNewList.get(i).getPhoneCounts());
                    // 开始计算到达数
                    income.setSalerNo(incomeStatisticNew.getSalerNo());
                    income.setInstallTime(incomeStatisticNew.getInstallTime());
                    //到达应用appid
                    income.setAppids(arrAppList);
                    // 到达应用的phoneimei
                    List<IncomeRes> incomeResList = getPhoneImei(syncScheduleDao.phoneImeis(income));
                    int arriveCounts = 0;
                    int actCounts = 0;
                    // 计算到达数
                    if (incomeResList != null && incomeResList.size() > 0) {
                        for (IncomeRes incomeRes : incomeResList) {
                            arriveCounts = arriveCounts + syncScheduleDao.contForArr(incomeRes);
                        }
                    }
                    //激活应用appid
                    income.setAppids(actAppList);
                    List<IncomeRes> actIncomeResList = getPhoneImei(syncScheduleDao.phoneImeis(income));
                    // 计算激活数
                    if (actIncomeResList != null && actIncomeResList.size() > 0) {
                        for (IncomeRes incomeRes : actIncomeResList) {
                            actCounts = actCounts + syncScheduleDao.countForAct(incomeRes);
                        }
                    }
                    // 计算当前激活应用的安装量--这里的激活应用列表去掉几个从接口取数据的应用
                    income.setSalerNo(incomeStatisticNew.getSalerNo());
                    income.setStartTime(incomeStatisticNew.getInstallTime());
                    income.setEndTime(incomeStatisticNew.getInstallTime());

                    Integer acts = syncScheduleDao.actInstallCounts(income);
                    // 四舍五入取整
                    int actCountsCompute = (int) Math.round(acts * actRate);
                    incomeStatisticNew.setActCountsCompute(actCountsCompute);
                    incomeStatisticNew.setArriveCounts(arriveCounts);
                    incomeStatisticNew.setActCounts(actCounts);
                    list.add(incomeStatisticNew);
                }
                if (list != null && list.size() > 0) {
                    syncScheduleDao.createIncomeStatisticNew(list);
                }
            } else {
                log.info(income.getStartTime() + "至" + income.getEndTime() + "无数据！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("--统计促销员到达数据结束--");
    }

    /**
     * 获取折800的激活数据
     */
    public void getActDate() {
        log.info("--开始调用折800激活数据--");
        try {
            log.info("--开始调用帆悦接口获取到达数据--");
            StringBuffer zhe = new StringBuffer();
            zhe.append("http://apiservice.tuan800.com/http-api/file/downloads?channel=ghnp0g&userName=unicom_hs&dateTime=");
            // 取当天的日期
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
            log.info("--折800激活数据时间：" + yesterday);
            zhe.append(yesterday);
            log.info(zhe);
            //创建连接
            URL url = new URL(zhe.toString());
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.connect();
            //读取服务器响应响应
            InputStream in = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String lines;
            StringBuffer sb = new StringBuffer("");

            int arrivePhoneCounts = 0;
            int arriveAppCounts = 0;

            // 创建文件
            File file = new File(filePath);
            String arrivePath = yesterday.trim() + "_zhe" + System.currentTimeMillis() + ".txt";
            File arriveFile = null;
            if (!file.exists()) {
                file.mkdirs();
            }
            arriveFile = new File(filePath + "/" + arrivePath);
            if (!arriveFile.exists()) {
                arriveFile.createNewFile();
            }

            FanyueLog fanyueLog = new FanyueLog();
            int length = 0;
            int scounts = 0;
            FileOutputStream out = new FileOutputStream(arriveFile, false);
            while ((lines = reader.readLine()) != null) {
                length = length + 1;
                lines = new String(lines.getBytes(), "utf-8");
                out.write((lines + "\n").getBytes("utf-8"));
                CpPhoneimei cpPhoneimei = null;
                String[] packages = lines.split("\\t");
                if (StringUtils.isNotBlank(packages[1])) {
                    arrivePhoneCounts = arrivePhoneCounts + 1;
                    cpPhoneimei = new CpPhoneimei();
                    cpPhoneimei.setAppid("50000777");
                    cpPhoneimei.setCpImportId(0);
                    cpPhoneimei.setPhoneImei(packages[1]);
                    cpPhoneimei.setActivationTime(new Date());
                    try {
                        cpDateImportDao.createCpPhoneimei(cpPhoneimei);
                        scounts = scounts + 1;
                    } catch (Exception e) {
                        log.info("创建激活数据失败:" + e.getMessage());
                    }
                }
            }

            fanyueLog.setArrivePhoneCounts(length);
            fanyueLog.setArriveAppCounts(scounts);
            fanyueLog.setArriveFile(arrivePath);
            fanyueLog.setArriveTime(yesterday);
            syncScheduleDao.createFanyueLog(fanyueLog);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("--完成调用折800接口数据--");
    }


    public void setSyncScheduleDao(SyncScheduleDao syncScheduleDao) {
        this.syncScheduleDao = syncScheduleDao;
    }


    public double addition(double a, double b) {
        BigDecimal b1 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return b1.add(b2).doubleValue();
    }

    /*
     * 计算价格
     *
     * @param incomeResList
     * @param appPriceList
     * @param flag
     * @return
     */
    public double getPrice(List<IncomeRes> incomeResList, List<AppPrice> appPriceList, Integer flag) {
        double price = 0.0;
        try {
            if (incomeResList != null && incomeResList.size() > 0) {
                if (appPriceList != null && appPriceList.size() > 0) {
                    for (IncomeRes incomeRes : incomeResList) {
                        for (AppPrice appPrice : appPriceList) {
                            if (incomeRes.getAppid() != null && incomeRes.getAppid().equals(appPrice.getAppid())) {
                                if (appPrice.getChargeModel() != null) { // 0：安装 1:激活 2:到达
                                    if (appPrice.getChargeModel().intValue() == 0) { // 安装
                                        Integer installCounts = incomeRes.getPhoneImei().split(",").length;
                                        if (flag == 1) { // 省办的追加到达的价格
                                            // 若有应用有到达量，每个追加0.3元
                                            Integer arrCount = syncScheduleDao.contForArr(incomeRes);
                                            if (arrCount != null && arrCount.intValue() > 0) {
//                                                price = addition(price, arrCount * IncomePrice.ADDPRICE_PROVINCES);
                                            }
                                        }
                                        price = addition(price, installCounts.intValue() * appPrice.getPrice());
                                        break;
                                    } else if (appPrice.getChargeModel().intValue() == 1) { // 激活
                                        Integer actCounts = syncScheduleDao.countForAct(incomeRes);
                                        price = addition(price, actCounts.intValue() * appPrice.getPrice());
                                        break;
                                    } else if (appPrice.getChargeModel().intValue() == 2) { // 到达
                                        Integer arrCounts = syncScheduleDao.contForArr(incomeRes);
                                        price = addition(price, arrCounts.intValue() * appPrice.getPrice());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.info("计算价格异常，异常信息：" + e.getMessage());
        }
        return price;
    }

    /**
     * 计算价格--按华盛应用和自有应用区分
     *
     * @param incomeResList
     * @param appPriceList
     * @param flag
     * @param topicFlag
     * @return
     */
    public IncomeResCompanyObj getPriceCompany(List<IncomeRes> incomeResList, List<AppPrice> appPriceList, Integer flag, Integer topicFlag) {
        IncomeResCompanyObj incomeResCompanyObj = new IncomeResCompanyObj();
        try {
            if (incomeResList != null && incomeResList.size() > 0) {
                if (appPriceList != null && appPriceList.size() > 0) {
                    for (IncomeRes incomeRes : incomeResList) {
                        for (AppPrice appPrice : appPriceList) {
                            if (incomeRes.getAppid() != null && incomeRes.getAppid().equals(appPrice.getAppid())) {
                                Integer arr = syncScheduleDao.contForArr(incomeRes);
                                double price = 0.0;
                                if (appPrice.getChargeModel() != null) { // 0：安装 1:激活 2:到达
                                    if (appPrice.getChargeCompany() != null) {
                                        if (appPrice.getChargeModel().intValue() == 0) { // 安装
                                            Integer installCounts = incomeRes.getPhoneImei().split(",").length;
                                            if (flag == 1) { // 省办的追加到达的价格
                                                // 若有应用有到达量，每个追加0.3元
                                                if (topicFlag.intValue() == 0) { // 精彩推荐应用
                                                    price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_JINGCAITUIJIAN);
                                                } else if (topicFlag.intValue() == 1) { // 装机必备
                                                    price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_ZHUANGJIBIBEI);
                                                }
                                            }
                                            price = addition(price, installCounts.intValue() * appPrice.getPrice());
                                        } else if (appPrice.getChargeModel().intValue() == 1) { // 激活
                                            Integer actCounts = syncScheduleDao.countForAct(incomeRes);
                                            price = addition(price, actCounts.intValue() * appPrice.getPrice());
                                        } else if (appPrice.getChargeModel().intValue() == 2) { // 到达
                                            price = addition(price, arr * appPrice.getPrice());
                                        }
                                        // 0 ：华盛应用计费
                                        if (appPrice.getChargeCompany().intValue() == 0) {
                                            incomeResCompanyObj.setHuashengPrice(addition(price, incomeResCompanyObj.getHuashengPrice()));
                                            // 1 :自有应用计费
                                        } else if (appPrice.getChargeCompany().intValue() == 1) {
                                            incomeResCompanyObj.setMinePrice(addition(price, incomeResCompanyObj.getMinePrice()));
                                        }

                                    } else {   // 如果没有设置公司，默认为华盛应用
                                        if (appPrice.getChargeModel().intValue() == 0) { // 安装
                                            Integer installCounts = incomeRes.getPhoneImei().split(",").length;
                                            if (flag == 1) { // 省办的追加到达的价格
                                                // 若有应用有到达量，每个追加0.3元
                                                if (topicFlag.intValue() == 0) { // 精彩推荐应用
                                                    price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_JINGCAITUIJIAN);
                                                } else if (topicFlag.intValue() == 1) { // 装机必备
                                                    price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_ZHUANGJIBIBEI);
                                                }
                                            }
                                            price = addition(price, installCounts.intValue() * appPrice.getPrice());
                                        } else if (appPrice.getChargeModel().intValue() == 1) { // 激活
                                            Integer actCounts = syncScheduleDao.countForAct(incomeRes);
                                            price = addition(price, actCounts.intValue() * appPrice.getPrice());
                                        } else if (appPrice.getChargeModel().intValue() == 2) { // 到达
                                            price = addition(price, arr * appPrice.getPrice());
                                        }
                                        incomeResCompanyObj.setHuashengPrice(addition(price, incomeResCompanyObj.getHuashengPrice()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.info("计算价格异常，异常信息：" + e.getMessage());
        }
        return incomeResCompanyObj;
    }


    public String spiltString(String str) {
        String[] strings = str.split(",");
        StringBuffer stringBuff = new StringBuffer();
        int length = strings.length;
        if (strings != null && length > 0) {
            for (int i = 0; i < length; i++) {
                stringBuff.append("\"");
                if (i != (length - 1)) {
                    stringBuff.append(strings[i] + "\",");
                } else {
                    stringBuff.append(strings[i] + "\"");
                }
            }
        }
        return stringBuff.toString();
    }

    /**
     * 按appid得出手机串号
     *
     * @param incomeResList
     * @return
     */
    public List<IncomeRes> getPhoneImei(List<IncomeRes> incomeResList) {
        List<IncomeRes> list = new ArrayList<IncomeRes>();
        try {
            int size = incomeResList.size();
            if (list != null && size > 0) {
                IncomeRes incomeRes = null;
                for (int i = 0; i < size; i++) {
                    if (incomeRes == null || !incomeResList.get(i).getAppid().equals(incomeRes.getAppid())) {
                        if (incomeRes != null && !incomeResList.get(i).getAppid().equals(incomeRes.getAppid())) {
                            list.add(incomeRes);
                        }
                        incomeRes = new IncomeRes();
                        incomeRes.setAppid(incomeResList.get(i).getAppid());
                        incomeRes.setPhoneImei("\"" + incomeResList.get(i).getPhoneImei() + "\"");
                    } else {
                        incomeRes.setPhoneImei(incomeRes.getPhoneImei() + ",\"" + incomeResList.get(i).getPhoneImei() + "\"");
                    }
                    if (i == (size - 1)) {
                        list.add(incomeRes);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public IncomeResObj getPriceAndArrcounts(List<IncomeRes> incomeResList, List<AppPrice> appPriceList, Integer flag, Integer topicFlag) {
        IncomeResObj incomeResObj = new IncomeResObj();
        double price = 0.0;
        Integer arrCounts = 0;
        try {
            if (incomeResList != null && incomeResList.size() > 0) {
                if (appPriceList != null && appPriceList.size() > 0) {
                    for (IncomeRes incomeRes : incomeResList) {
                        for (AppPrice appPrice : appPriceList) {
                            if (incomeRes.getAppid() != null && incomeRes.getAppid().equals(appPrice.getAppid())) {
                                Integer arr = syncScheduleDao.contForArr(incomeRes);
                                arrCounts = arrCounts + arr;
                                if (appPrice.getChargeModel() != null) { // 0：安装 1:激活 2:到达
                                    if (appPrice.getChargeModel().intValue() == 0) { // 安装
                                        Integer installCounts = incomeRes.getPhoneImei().split(",").length;
                                        if (flag == 1) { // 省办的追加到达的价格
                                            // 若有应用有到达量，每个追加0.3元
                                            if (topicFlag.intValue() == 0) { // 精彩推荐应用
                                                price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_JINGCAITUIJIAN);
                                            } else if (topicFlag.intValue() == 1) { // 装机必备
                                                price = addition(price, arr * IncomePrice.ADDPRICE_PROVINCES_ZHUANGJIBIBEI);
                                            }

                                        }
                                        price = addition(price, installCounts.intValue() * appPrice.getPrice());
                                        break;
                                    } else if (appPrice.getChargeModel().intValue() == 1) { // 激活
                                        Integer actCounts = syncScheduleDao.countForAct(incomeRes);
                                        price = addition(price, actCounts.intValue() * appPrice.getPrice());
                                        break;
                                    } else if (appPrice.getChargeModel().intValue() == 2) { // 到达
                                        price = addition(price, arr * appPrice.getPrice());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    incomeResObj.setPrice(price);
                    incomeResObj.setArrCount(arrCounts);
                }
            }
        } catch (Exception e) {
            log.info("计算价格异常，异常信息：" + e.getMessage());
        }
        return incomeResObj;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setCpDateImportDao(CpDateImportDao cpDateImportDao) {
        this.cpDateImportDao = cpDateImportDao;
    }
}
