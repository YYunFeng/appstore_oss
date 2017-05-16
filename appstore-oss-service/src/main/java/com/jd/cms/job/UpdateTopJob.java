package com.jd.cms.job;

import com.jd.appstore.domain.RankingApp;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.cms.util.CategoryIdUtil;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 * 更新排行榜JOB
 */
public class UpdateTopJob extends QuartzJobBean implements StatefulJob {

    CategoryIdUtil categoryIdUtil;

    /**
     * execute方法，默执行的方法
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取CategoryManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
        this.categoryIdUtil = (CategoryIdUtil)jobDetail.getJobDataMap().get("categoryIdUtil");
        //最新上架
        initNewest(syncScheduleManager);
        //上升最快
        initFastest(syncScheduleManager);
        //热门收费
        initFee(syncScheduleManager);
        //热门免费
        initFree(syncScheduleManager);
        //根据合到期预警检测同步任务ID更新实际执行时间
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }

    /**
     * 最新上架
     *
     * @param syncScheduleManager
     */
    public void initNewest(SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp;
        List<RankingApp> rankingAppList;

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_SOFT);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_NEWEST);
        //查询移动软件最新上架排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动软件最新上架已锁定记录
        findNewest(rankingAppList, TaskTypeConstants.CMS_RANKING_SOFT, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_NEWEST);
        //查询移动游戏排行最新上架榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏最新上架已锁定记录
        findNewest(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_NEWEST);
        //查询Web应用排行最新上架榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行最新上架已锁定记录
        findNewest(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);
    }

    /**
     * 查询可更新最新上架排行榜记录
     *
     * @param rankingAppList
     * @param rankingStyle
     * @param syncScheduleManager
     */
    public void findNewest(List<RankingApp> rankingAppList, int rankingStyle, SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(transform(rankingStyle));
        //设置已锁定排行记录
        rankingApp.setLockedOrder(strUtil(rankingAppList));
        //查询最新上架记录
        List<RankingApp> rankingAppNewestList = syncScheduleManager.findRankingAppNewest(rankingApp);
        //更新最新上架记录
        updateRanking(rankingAppNewestList, rankingAppList, rankingStyle, TaskTypeConstants.CMS_RANKING_NEWEST, syncScheduleManager);
    }

    /**
     * 热门收费
     *
     * @param syncScheduleManager
     */
    public void initFee(SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp;
        List<RankingApp> rankingAppList;

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_SOFT);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FEE);
        //查询移动软件热门收费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动软件热门收费已锁定记录
        findFee(rankingAppList, TaskTypeConstants.CMS_RANKING_SOFT, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FEE);
        //查询移动游戏热门收费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏热门收费已锁定记录
        findFee(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FEE);
        //查询Web应用热门收费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行热门收费已锁定记录
        findFee(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);
    }

    /**
     * 查询可更新热门收费排行榜记录
     *
     * @param rankingAppList
     * @param rankingStyle
     * @param syncScheduleManager
     */
    public void findFee(List<RankingApp> rankingAppList, int rankingStyle, SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(transform(rankingStyle));
        //设置已锁定排行记录
        rankingApp.setLockedOrder(strUtil(rankingAppList));
        //查询热门收费记录
        List<RankingApp> rankingAppFeeList = syncScheduleManager.findRankingAppFee(rankingApp);
        //更新热门收费记录
        updateRanking(rankingAppFeeList, rankingAppList, rankingStyle, TaskTypeConstants.CMS_RANKING_FEE, syncScheduleManager);
    }

    /**
     * 热门免费
     *
     * @param syncScheduleManager
     */
    public void initFree(SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp;
        List<RankingApp> rankingAppList;

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_SOFT);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FREE);
        //查询移动软件热门免费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动软件热门免费已锁定记录
        findFree(rankingAppList, TaskTypeConstants.CMS_RANKING_SOFT, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FREE);
        //查询移动游戏热门免费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏热门免费已锁定记录
        findFree(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FREE);
        //查询Web应用热门免费排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行热门免费已锁定记录
        findFree(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);
    }

    /**
     * 查询可更新热门免费排行榜记录
     *
     * @param rankingAppList
     * @param rankingStyle
     * @param syncScheduleManager
     */
    public void findFree(List<RankingApp> rankingAppList, int rankingStyle, SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(transform(rankingStyle));
        //设置已锁定排行记录
        rankingApp.setLockedOrder(strUtil(rankingAppList));
        //查询热门免费记录
        List<RankingApp> rankingAppFreeList = syncScheduleManager.findRankingAppFree(rankingApp);
        //更新热门免费记录
        updateRanking(rankingAppFreeList, rankingAppList, rankingStyle, TaskTypeConstants.CMS_RANKING_FREE, syncScheduleManager);
    }

    /**
     * 上升最快
     *
     * @param syncScheduleManager
     */
    public void initFastest(SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp;
        List<RankingApp> rankingAppList;

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_SOFT);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FASTEST);
        //查询移动软件上升最快排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动软件上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_SOFT, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FASTEST);
        //查询移动游戏上升最快排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);

        rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FASTEST);
        //查询Web应用上升最快排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);
    }

    /**
     * 查询可更新上升最快排行榜记录
     *
     * @param rankingAppList
     * @param rankingStyle
     * @param syncScheduleManager
     */
    public void findFastest(List<RankingApp> rankingAppList, int rankingStyle, SyncScheduleManager syncScheduleManager) {
        RankingApp rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(transform(rankingStyle));
        //设置已锁定排行记录
        rankingApp.setLockedOrder(strUtil(rankingAppList));
        //查询上升最快记录
        List<RankingApp> rankingAppFreeList = syncScheduleManager.findRankingAppFastest(rankingApp);
        //更新上升最快记录
        updateRanking(rankingAppFreeList, rankingAppList, rankingStyle, TaskTypeConstants.CMS_RANKING_FASTEST, syncScheduleManager);
    }

    /**
     * 更新排行榜记录
     *
     * @param rankingAppNewestList
     * @param rankingAppList
     * @param rankingStyle
     * @param rankingType
     * @param syncScheduleManager
     */
    public void updateRanking(List<RankingApp> rankingAppNewestList, List<RankingApp> rankingAppList, int rankingStyle, int rankingType, SyncScheduleManager syncScheduleManager) {
            syncScheduleManager.updateRankingAppNewest(rankingAppNewestList, rankingAppList, rankingStyle, rankingType);
    }

    /**
     * 将应用ID以逗号分割拼成字符串
     *
     * @param rankingAppList
     * @return
     */
    public String strUtil(List<RankingApp> rankingAppList) {
        String lockedOrder = null;
        if (rankingAppList.size() > 0) {
            for (int i = 0; i < rankingAppList.size(); i++) {
                if(i ==0){
                   lockedOrder = String.valueOf(rankingAppList.get(i).getAppId());
                } else{
                   lockedOrder += String.valueOf(rankingAppList.get(i).getAppId());
                }

                if (i != rankingAppList.size() - 1) {
                    lockedOrder += ",";
                }
            }
        }
        return lockedOrder;
    }

    /**
     * 转换二级类目ID
     *
     * @param rankingStyle
     * @return
     */
    public int transform(int rankingStyle) {
        int style = 0;
        if (0 == rankingStyle) {
            style = Integer.parseInt(categoryIdUtil.getMobileSoftId());
        } else if (1 == rankingStyle) {
            style = Integer.parseInt(categoryIdUtil.getMobileGameId());
        } else if (rankingStyle == 2) {
            style = Integer.parseInt(categoryIdUtil.getWebAppId());
        }
        return style;
    }


}
