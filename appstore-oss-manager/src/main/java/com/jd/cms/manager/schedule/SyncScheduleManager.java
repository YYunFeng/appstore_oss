package com.jd.cms.manager.schedule;

import com.jd.appstore.domain.AppDownloadStat;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.appstore.domain.InstallStat;
import com.jd.appstore.domain.RankingApp;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.digital.common.rpc.domain.bean.category.Category;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 下午12:43
 * To change this template use File | Settings | File Templates.
 */
public interface SyncScheduleManager {
    /**
     * 查询周期性同步任务信息
     *
     * @param taskTypeId
     * @param status
     * @return
     */
    TaskInfoResult findSyncTaskInfo(String taskTypeId, int status);

    /**
     * 更新类目信息
     *
     * @param categoryList
     * @return
     */
    int createCategory(List<Category> categoryList);

    /**
     * 按应用统计前一天的下载次数
     *
     * @return
     */
    List<AppDownloadStat> findAppDownloadStat();

    /**
     * 创建应用下载统计结果
     *
     * @param appDownloadStatList
     */
    void createAppDownloadStat(List<AppDownloadStat> appDownloadStatList);

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
     * 更新排行榜记录
     *
     * @param rankingAppNewestList
     * @param rankingAppList
     * @param rankingStyle
     * @param rankingType
     */
    void updateRankingAppNewest(final List<RankingApp> rankingAppNewestList, final List<RankingApp> rankingAppList, final int rankingStyle, final int rankingType);

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
     * 查询上升最快记录--下载最多
     *
     * @param rankingApp
     * @return
     */
    List<RankingApp> findRankingAppFastest(RankingApp rankingApp);

    /**
     * 根据合到期预警检测同步任务ID更新实际执行时间
     *
     * @param id
     * @param startTimeFact
     */
    void updateTaskFactTime(int id, Date startTimeFact);

    /**
     * 查询差一个月到期的cp
     *
     * @return
     */
    List<CpInfoResult> findCpInfoResult();

    /**
     * 更新合同预警状态
     *
     * @param cpBaseInfo
     */
    void updateCpBaseInfo(CpBaseInfo cpBaseInfo);

    /**
     * 创建应用下载汇总
     */
    void createDownloadTotalstat();

    /**
     * 创建营销日志
     */
    void createMarketLog();


    /**
     * 收入统计定时任务
     */
    void createIncomeStatistic();


    /**
     * 促销员安装日志中间表统计--新版本
     */
    void createSalerLog();


    /**
     * 获取促销员到达数据
     */
    void salerArrStatistic();


    /**
     * 获取激活数据
     */
    void getActDate();
}
