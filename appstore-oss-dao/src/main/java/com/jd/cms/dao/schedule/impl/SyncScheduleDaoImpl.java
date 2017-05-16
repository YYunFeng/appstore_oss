package com.jd.cms.dao.schedule.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.schedule.SyncScheduleDao;
import com.jd.cms.domain.systemmaintenance.*;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 * 周期同步任务
 */
public class SyncScheduleDaoImpl extends BaseDao implements SyncScheduleDao {
    /**
     * 查询周期性同步任务信息
     *
     * @param taskInfoQuery
     * @return
     */
    public TaskInfoResult findSyncTaskInfo(TaskInfoQuery taskInfoQuery) {
        return (TaskInfoResult) queryForObject("SyncSchedule.findTaskInfoResult", taskInfoQuery);
    }


    /**
     * 插入新类目到数据库
     *
     * @param category
     */
    public void createCategory(Category category) {
        insert("SyncSchedule.createCategory", category);
    }

    /**
     * 删除下柜类目
     */
    public void deleteCategory() {
        delete("SyncSchedule.deleteCategory");
    }

    /**
     * 更新类目，并返回成功、失败标识
     *
     * @param category
     * @return
     */
    public int updateCategory(Category category) {
        return update("SyncSchedule.updateCategory", category);
    }

    /**
     * 更新类目过期状态成未过期
     */
    public void updateAllCategory() {
        update("SyncSchedule.updateAllCategory");
    }

    /**
     * 按应用统计前一天的下载次数
     *
     * @return
     */
    public List<AppDownloadStat> findAppDownloadStat() {
        return queryForList("SyncSchedule.findAppDownloadStat");
    }

    /**
     * 创建应用下载统计结果
     *
     * @param appDownloadStat
     */
    public void createAppDownloadStat(AppDownloadStat appDownloadStat) {
        insert("SyncSchedule.createAppDownloadStat", appDownloadStat);
    }

    /**
     * 删除年月日一同样的下载统计记录
     *
     * @param appDownloadStat
     */
    public void deleteAppDownloadStat(AppDownloadStat appDownloadStat) {
        delete("SyncSchedule.deleteAppDownloadStat", appDownloadStat);
    }

    /**
     * 查询排行榜锁定记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingApp(RankingApp rankingApp) {
        return queryForList("SyncSchedule.findRankingApp", rankingApp);
    }

    /**
     * 查询最新上架记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppNewest(RankingApp rankingApp) {
        return queryForList("SyncSchedule.findRankingAppNewest", rankingApp);
    }

    /**
     * 更新排行榜
     *
     * @param rankingApp
     */
    public void createRankingApp(RankingApp rankingApp) {
        insert("SyncSchedule.createRankingApp", rankingApp);
    }

    /**
     * 查询热门收费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFee(RankingApp rankingApp) {
        return queryForList("SyncSchedule.findRankingAppFee", rankingApp);
    }

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFree(RankingApp rankingApp) {
        return queryForList("SyncSchedule.findRankingAppFree", rankingApp);
    }

    /**
     * 更新合同预警状态
     *
     * @param cpBaseInfo
     */
    public void updateCpBaseInfo(CpBaseInfo cpBaseInfo) {
        update("SyncSchedule.updateCpBaseInfo", cpBaseInfo);
    }

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    public List<RankingApp> findRankingAppFastest(RankingApp rankingApp) {
        return queryForList("SyncSchedule.findRankingAppFastest", rankingApp);
    }

    /**
     * 更新周期性任务起动时间
     *
     * @param taskInfoQuery
     */
    public void updateTaskFactTime(TaskInfoQuery taskInfoQuery) {
        update("SyncSchedule.updateTaskFactTime", taskInfoQuery);
    }

    /**
     * 删除未被锁定记录
     *
     * @param rankingApp
     */
    public void deleteRankingApp(RankingApp rankingApp) {
        delete("SyncSchedule.deleteRankingApp", rankingApp);
    }

    /**
     * 查询合同预警期内CP信息
     *
     * @return
     */
    public List<CpInfoResult> findCpInfoResult() {
        return queryForList("SyncSchedule.findCpInfoResult");
    }

    /**
     * 删除应用下载汇总表
     */
    public void deleteDownloadTotalstat() {
        delete("SyncSchedule.deleteDownloadTotalstat");
    }

    /**
     * 插入应用下载汇总表
     *
     * @param downloadTotalstat
     */
    public void createDownloadTotalstat(DownloadTotalstat downloadTotalstat) {
        insert("SyncSchedule.createDownloadTotalstat", downloadTotalstat);
    }

    /**
     * 统计应用下载汇总
     *
     * @return
     */
    public List<DownloadTotalstat> findDownloadTotalstat() {
        return queryForList("SyncSchedule.findDownloadTotalstat");
    }

    public List<InstallStat> getOfflineSaleLog(Integer id) {
        return queryForList("SyncSchedule.getOfflineSaleLog", id);
    }

    public List<InstallStat> getOnlineSaleLog(Integer id) {
        return queryForList("SyncSchedule.getOnlineSaleLog", id);
    }


    public void createOfflineInstallStats(InstallStat installStat) {
        insert("SyncSchedule.createOfflineInstallStat", installStat);
    }

    public void createOnlineInstallStats(InstallStat installStat) {
        insert("SyncSchedule.createOnlineInstallStat", installStat);
    }

    public void updateStatisticsStatusOffline(Integer id) {
        update("SyncSchedule.updateStatisticsStatusOffline", id);
    }

    public void updateStatisticsStatusOnline(Integer id) {
        update("SyncSchedule.updateStatisticsStatusOnline", id);
    }


    public Integer getOfflineLogMaxId() {
        return (Integer) queryForObject("SyncSchedule.getOfflineLogMaxId");
    }

    public Integer getOnlineLogMaxId() {
        return (Integer) queryForObject("SyncSchedule.getonlineLogMaxId");
    }

    public Integer getAppInstallLogMaxId() {
        return (Integer) queryForObject("SyncSchedule.getAppInstallLogMaxId");
    }

    public List<SalerInstallLog> salerInstallLog(Integer id) {
        return queryForList("SyncSchedule.salerInstallLog", id);
    }

    public void createAppStatistic(SalerInstallLog salerInstallLog) throws Exception {
        insert("SyncSchedule.createAppStatistic", salerInstallLog);
    }

    public void updateAppStatisticFlag(Integer id) {
        update("SyncSchedule.updateAppStatisticFlag", id);
    }

    public List<ArriveStatistic> salerArriveStatistic(IncomeParameter incomeParameter) {
        return null;
    }

    public Map arrAppPackage() {
        return queryForMap("SyncSchedule.arrAppPackage", null, "package", "appid");
    }

    public void createFanyueArriveApp(ArrAppObj arrAppObj) {
        insert("SyncSchedule.createFanyueArriveApp", arrAppObj);
    }

    public void createFanyueLog(FanyueLog fanyueLog) {
        insert("SyncSchedule.createFanyueLog", fanyueLog);
    }

    public List<String> modelApps(Integer chargeModel) {
        return queryForList("SyncSchedule.modelApps", chargeModel);
    }

    public List<String> priceApps() {
        return queryForList("SyncSchedule.priceApps");
    }

    public int totalActCounts(IncomeParameter incomeParameter) {
        return (Integer) queryForObject("SyncSchedule.totalActCounts", incomeParameter);
    }

    public int actInstallCounts(IncomeParameter incomeParameter) {
        return (Integer) queryForObject("SyncSchedule.actInstallCounts", incomeParameter);
    }

    public List<String> actAppids() {
        return queryForList("SyncSchedule.actAppids");
    }

    public List<IncomeStatisticNew> appsInstallList(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.appsInstallList", incomeParameter);
    }

    public List<IncomeRes> phoneImeis(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.phoneImeis", incomeParameter);
    }


    public List<IncomeStatistic> getIncomeStatistic(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.getIncomeStatistic", incomeParameter);
    }

    public List<IncomeRes> getSalePhoneImeiForRecommend(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.getSalePhoneImeiForRecommend", incomeParameter);
    }

    public List<IncomeRes> getSalePhoneImeiForNeed(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.getSalePhoneImeiForNeed", incomeParameter);
    }

    public List<AppPrice> getAppPrice(Integer chargeArea) {
        return queryForList("SyncSchedule.getAppPrice", chargeArea);
    }

    public Integer countForAct(IncomeRes incomeRes) {
        return (Integer) queryForObject("SyncSchedule.countForAct", incomeRes);
    }

    public Integer contForArr(IncomeRes incomeRes) {
        return (Integer) queryForObject("SyncSchedule.contForArr", incomeRes);
    }

    public Integer contForArrWithStar(IncomeRes incomeRes) {
        return (Integer) queryForObject("SyncSchedule.contForArrWithStar", incomeRes);
    }

    /**
     * 创建收入统计结果
     *
     * @param incomeStatisticList
     */
    public void createIncomeStatistic(List<IncomeStatistic> incomeStatisticList) {
        try {
            if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                for (IncomeStatistic incomeStatistic : incomeStatisticList) {
                    Integer count = (Integer) queryForObject("SyncSchedule.getIncomtStatistic", incomeStatistic);
                    if (count != null && count > 0) {
                        update("SyncSchedule.updateIncomeStatistic", incomeStatistic);
                    } else {
                        insert("SyncSchedule.createIncomeStatistic", incomeStatistic);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createIncomeStatisticNew(List<IncomeStatisticNew> incomeStatisticNewList) {
        try {
            if (incomeStatisticNewList != null && incomeStatisticNewList.size() > 0) {
                for (IncomeStatisticNew incomeStatistic : incomeStatisticNewList) {
                    Integer count = (Integer) queryForObject("SyncSchedule.getIncomeNew", incomeStatistic);
                    if (count != null && count > 0) {
                        update("SyncSchedule.updateIncomeNew", incomeStatistic);
                    } else {
                        insert("SyncSchedule.createIncomeStatisticNew", incomeStatistic);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getCompanyAppInstallCounts(IncomeParameter incomeParameter) {
        return (Integer) queryForObject("SyncSchedule.getCompanyAppInstallCounts", incomeParameter);
    }

    public List<String> getCompanyAppid(Integer chargeCompany) {
        return queryForList("SyncSchedule.getCompanyAppid", chargeCompany);
    }

    public List<String> getTopicAppid(Integer topicId) {
        return queryForList("SyncSchedule.getTopicAppid", topicId);
    }

    public List<IncomeRes> getSalePhoneImei(IncomeParameter incomeParameter) {
        return queryForList("SyncSchedule.getSalePhoneImei", incomeParameter);
    }

    public List<String> topicAppIds() {
        return queryForList("SyncSchedule.topicAppIds");
    }

    public Integer getPhoneInstallCounts(IncomeParameter incomeParameter) {
        return (Integer) queryForObject("SyncSchedule.getPhoneInstallCounts", incomeParameter);
    }


}
