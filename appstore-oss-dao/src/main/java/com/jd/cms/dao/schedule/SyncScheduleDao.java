package com.jd.cms.dao.schedule;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.systemmaintenance.*;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public interface SyncScheduleDao {
    /**
     * 查询周期性同步任务信息
     *
     * @param taskInfoQuery
     * @return
     */
    TaskInfoResult findSyncTaskInfo(TaskInfoQuery taskInfoQuery);

    /**
     * 插入新类目到数据库
     *
     * @param category
     */
    void createCategory(Category category);

    /**
     * 删除下柜类目
     */
    void deleteCategory();

    /**
     * 更新类目，并返回成功、失败标识
     *
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 更新类目过期状态成未过期
     */
    void updateAllCategory();

    /**
     * 按应用统计前一天的下载次数
     *
     * @return
     */
    List<AppDownloadStat> findAppDownloadStat();

    /**
     * 创建应用下载统计结果
     *
     * @param appDownloadStat
     */
    void createAppDownloadStat(AppDownloadStat appDownloadStat);

    /**
     * 删除年月日一同样的下载统计记录
     *
     * @param appDownloadStat
     */
    void deleteAppDownloadStat(AppDownloadStat appDownloadStat);

    /**
     * 查询排行榜锁定记录
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingApp(RankingApp rankingApp);

    /**
     * 查询最新上架记录
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingAppNewest(RankingApp rankingApp);

    /**
     * 更新排行榜
     *
     * @param rankingApp
     */
    void createRankingApp(RankingApp rankingApp);

    /**
     * 查询热门收费记录
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingAppFee(RankingApp rankingApp);

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingAppFree(RankingApp rankingApp);

    /**
     * 更新合同预警状态
     *
     * @param cpBaseInfo
     */
    void updateCpBaseInfo(CpBaseInfo cpBaseInfo);

    /**
     * 查询热门免费记录
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingAppFastest(RankingApp rankingApp);

    /**
     * 更新周期性任务起动时间
     *
     * @param taskInfoQuery
     */
    void updateTaskFactTime(TaskInfoQuery taskInfoQuery);

    /**
     * 删除未被锁定记录
     *
     * @param rankingApp
     */
    void deleteRankingApp(RankingApp rankingApp);

    /**
     * 查询合同预警期内CP信息
     *
     * @return
     */
    List<CpInfoResult> findCpInfoResult();

    /**
     * 删除应用下载汇总表
     */
    void deleteDownloadTotalstat();

    /**
     * 插入应用下载汇总表
     *
     * @param downloadTotalstat
     */
    void createDownloadTotalstat(DownloadTotalstat downloadTotalstat);

    /**
     * 统计应用下载汇总
     *
     * @return
     */
    List<DownloadTotalstat> findDownloadTotalstat();

    /**
     * 得到离线应用安装日志
     *
     * @return
     */
    List<InstallStat> getOfflineSaleLog(Integer id);

    /**
     * 得到在线应用安装日志
     *
     * @return
     */
    List<InstallStat> getOnlineSaleLog(Integer id);

    /**
     * 创建离线应用安装日志
     *
     * @param installStat
     */
    void createOfflineInstallStats(InstallStat installStat);

    /**
     * 创建在线应用安装日志
     *
     * @param installStat
     */
    void createOnlineInstallStats(InstallStat installStat);

    /**
     * 更新离线应用统计标示
     */
    void updateStatisticsStatusOffline(Integer id);

    /**
     * 更新在线应用统计标示
     */
    void updateStatisticsStatusOnline(Integer id);


    Integer getOfflineLogMaxId();

    Integer getOnlineLogMaxId();


    /**
     * 取出需要统计的一个月数据
     *
     * @return
     */
    List<IncomeStatistic> getIncomeStatistic(IncomeParameter incomeParameter);

    /**
     * 按促销员和日期查看精彩推荐应用的appid和手机串号
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeRes> getSalePhoneImeiForRecommend(IncomeParameter incomeParameter);


    /**
     * 按促销员和日期查看装机必备应用的appid和手机串号
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeRes> getSalePhoneImeiForNeed(IncomeParameter incomeParameter);

    /**
     * 按区域得到APP价格和计费模式
     *
     * @param chargeArea
     * @return
     */
    List<AppPrice> getAppPrice(Integer chargeArea);

    /**
     * 精彩应用下的某应用的激活数量
     *
     * @return
     */
    Integer countForAct(IncomeRes incomeRes);

    /**
     * 精彩推荐下的某应用到达数量
     *
     * @return
     */
    Integer contForArr(IncomeRes incomeRes);


    /**
     * 由于HTC手机通过ADB取的imei号带*号
     * 所以按后面的几位来取到达的量
     *
     * @param incomeRes
     * @return
     */
    Integer contForArrWithStar(IncomeRes incomeRes);


    /**
     * 创建收入统计结果
     *
     * @param incomeStatisticList
     */
    void createIncomeStatistic(List<IncomeStatistic> incomeStatisticList);


    /**
     * 创建收入统计结果-新版
     */
    void createIncomeStatisticNew(List<IncomeStatisticNew> incomeStatisticNewList);

    /**
     * 获取华盛应用和自有应用的安装量
     *
     * @param incomeParameter
     * @return
     */
    Integer getCompanyAppInstallCounts(IncomeParameter incomeParameter);

    /**
     * 获得自有应用和华盛应用的appid
     *
     * @param chargeCompany
     * @return
     */
    List<String> getCompanyAppid(Integer chargeCompany);

    /**
     * 按应用ID获取专题下的应用
     *
     * @param topicId
     * @return
     */
    List<String> getTopicAppid(Integer topicId);


    /**
     * 按专题应用和促销员和日期查看的appid和手机串号
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeRes> getSalePhoneImei(IncomeParameter incomeParameter);


    /**
     * 获取收费专题的APPID
     *
     * @return
     */
    List<String> topicAppIds();


    /**
     * 计算某天促销员安装的台数
     *
     * @param incomeParameter
     * @return
     */
    Integer getPhoneInstallCounts(IncomeParameter incomeParameter);


    /**
     * 获取促销员安装日志日志最大ID
     *
     * @return
     */
    Integer getAppInstallLogMaxId();

    /**
     * 需要入库的
     *
     * @param id
     * @return
     */
    List<SalerInstallLog> salerInstallLog(Integer id);


    /**
     * 入库中间表
     *
     * @param salerInstallLog
     */
    void createAppStatistic(SalerInstallLog salerInstallLog) throws Exception;

    /**
     * 更新原始日志表状态
     *
     * @param id
     */
    void updateAppStatisticFlag(Integer id);


    List<ArriveStatistic> salerArriveStatistic(IncomeParameter incomeParameter);

    /**
     * 到达应用的包名和appid
     *
     * @return
     */
    Map arrAppPackage();

    /**
     * 创建帆悦应用到达数据
     *
     * @param arrAppObj
     */
    void createFanyueArriveApp(ArrAppObj arrAppObj);

    /**
     * 创建帆悦到达应用调用日志
     *
     * @param fanyueLog
     */
    void createFanyueLog(FanyueLog fanyueLog);

    /**
     * 应用计费类型   1：激活  2：到达
     *
     * @return
     */
    List<String> modelApps(Integer chargerMode);

    /**
     * 计费应用
     *
     * @return
     */
    List<String> priceApps();

    /**
     * 总的激活数
     *
     * @return
     */
    int totalActCounts(IncomeParameter incomeParameter);

    /**
     * 激活应用安装数
     *
     * @param incomeParameter
     * @return
     */
    int actInstallCounts(IncomeParameter incomeParameter);

    /**
     * 激活应用appid
     */
    List<String> actAppids();


    List<IncomeStatisticNew> appsInstallList(IncomeParameter incomeParameter);


    /**
     * 查看促销员某天的安装的appid和手机串号
     *
     * @param incomeParameter
     * @return
     */
    List<IncomeRes> phoneImeis(IncomeParameter incomeParameter);


}
