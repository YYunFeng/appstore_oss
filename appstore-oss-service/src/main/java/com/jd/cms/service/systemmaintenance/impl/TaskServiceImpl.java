package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.AppDownloadStat;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.appstore.domain.RankingApp;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.job.ActDateSyncJob;
import com.jd.cms.job.ContractExpirationWarningJob;
import com.jd.cms.job.DownloadStatisticalDailyJob;
import com.jd.cms.job.UpdateTopJob;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.cms.manager.systemmaintenance.TaskManager;
import com.jd.cms.service.schedule.DailyReportService;
import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import com.jd.cms.service.systemmaintenance.TaskService;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.domain.bean.CommonResult;
import com.jd.digital.common.rpc.domain.bean.category.Category;
import com.jd.digital.common.rpc.manager.category.CategoryManager;
import com.jd.digital.common.rpc.manager.email.EmailManager;
import com.jd.digital.common.rpc.manager.sms.SMSManager;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.JobDetailBean;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public class TaskServiceImpl implements TaskService {
    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 任务管理Manager
     */
    private TaskManager taskManagerCached;
    /**
     * 同步任务Manager
     */
    private SyncScheduleManager syncScheduleManager;
    /**
     * 类目管理Manager
     */
    private CategoryManager categoryManager;
    /**
     * Email接口
     */
    private EmailManager emailManager;
    /**
     * 手机接口
     */
    private SMSManager smsManager;
    /**
     * 二级类目移动软件ID
     */
    private String mobileSoftId;
    /**
     * 二级类目移动游戏ID
     */
    private String mobileGameId;
    /**
     * 二级类目web应用ID
     */
    private String webAppId;
    /**
     * 截图服务器HOST
     */
    private String imgserver;
    /**
     * 主图服务器HOST
     */
    private String coverserver;

    private ZhuoWangInfoImportService zhuoWangInfoImportService;

    private DailyReportService dailyReportService;

    /**
     * 查询ERP后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @param appName
     * @param status
     * @return
     */
    public Result findErpTaskList(int pageIndex, int pageSize, String appName, int status) {
        Result result = new Result();
        result.addDefaultModel("erpTasks", taskManagerCached.findErpTaskList(pageIndex, pageSize, appName, status));
        //应用名称
        result.addDefaultModel("taskInfoQuery.appName", appName);
        //任务状态
        result.addDefaultModel("taskInfoQuery.status", status);
//        //主图尺寸
//        result.addDefaultModel("coverpicsize", PicResolutionEnum.COVER_N4.getPrefix() + "/");
//        //截图服务器HOST
//        result.addDefaultModel("imgserver", imgserver);
//        //主图服务器HOST
//        result.addDefaultModel("coverserver", coverserver);
        return result;
    }

    /**
     * 查询周期性后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result findLoopTaskList(int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("loopTasks", taskManagerCached.findLoopTaskList(pageIndex, pageSize));
        return result;
    }

    /**
     * 重新同步ERP后台任务
     *
     * @param id
     */
    public void resetErpTask(int id) {
        taskManagerCached.resetErpTask(id);
    }

    /**
     * 按后台任务类型立即执行周期性后台任务
     *
     * @param taskTypeId
     */
    public void immediatelyExec(String taskTypeId) throws IOException {
        if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_CATEGORY)) {/*同步商品类目*/
            /*List<Category> categoryList = new ArrayList<Category>();
            //得到一级类目对象
            Category category = categoryManager.getFirstCategory();
            if (null != category) {
                //根据上一级类目ID获取上柜的子类目列表
                categoryList = getSecondCategoryList(category.getId(), categoryManager);
                //将一级类目加入类目列表
                categoryList.add(category);
            }*/
            //同步类目
            syncScheduleManager.getActDate();
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_DOWNLOAD)) {/*生成下载统计日报*/
            //按应用统计前一天的下载次数
            List<AppDownloadStat> appDownloadStatList = syncScheduleManager.findAppDownloadStat();
            if (null != appDownloadStatList) {
                //创建应用下载统计结果
                syncScheduleManager.createAppDownloadStat(appDownloadStatList);
                //创建应用下载汇总
                syncScheduleManager.createDownloadTotalstat();
            }
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_TOP)) {/*更新排行榜*/
            //最新上架---精品
            initNewest(syncScheduleManager);
            //上升最快---专辑
            initFastest(syncScheduleManager);
          /*  //热门收费
            initFee(syncScheduleManager);
            //热门免费
            initFree(syncScheduleManager);*/
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_EXPIRATION)) {/*合到期预警检测*/
            //查询差一个月到期的cp
            List<CpInfoResult> cpInfoResultList = syncScheduleManager.findCpInfoResult();
            if (null != cpInfoResultList && cpInfoResultList.size() > 0) {
                CpBaseInfo cpBaseInfo;
                //循环给差一个到期的cp发送邮件和短信
                for (int i = 0; i < cpInfoResultList.size(); i++) {
                    cpBaseInfo = new CpBaseInfo();
                    //设置cp帐号
                    cpBaseInfo.setId(cpInfoResultList.get(i).getAccountId());
                    //获取手机绑定状态
                    Integer mobileBinded = cpInfoResultList.get(i).getMobileBinded();
                    //获取Email验证状态
                    Integer emailChecked = cpInfoResultList.get(i).getEmailChecked();
                    //获取是否发送预警邮件1
                    Integer mailSent1 = cpInfoResultList.get(i).getMailSent1();
                    if (null == mailSent1) {
                        mailSent1 = 0;
                    }
                    //获取是否发送预警邮件2
                    Integer mailSent2 = cpInfoResultList.get(i).getMailSent2();
                    if (null == mailSent2) {
                        mailSent2 = 0;
                    }
                    //获取是否发送短信预警
                    Integer smsSent2 = cpInfoResultList.get(i).getSmsSent2();
                    if (null == smsSent2) {
                        smsSent2 = 0;
                    }
                    if (null != mobileBinded && 1 == mobileBinded && 1 != smsSent2) {
                        //调用短信接口
                        CommonResult commonResult = smsManager.sendSMS(cpInfoResultList.get(i).getMobile(), "你中大奖了", "");/*CP绑定手机号*/

                        //短信发送是否成功
                        if (commonResult.isSuccess()) {
                            //设置短信已发送标识
                            cpBaseInfo.setSmsSent2(1);
                        } else {
                            //设置短信未发送标识
                            cpBaseInfo.setSmsSent2(0);
                        }
                    }
                    if (null != emailChecked && 1 == emailChecked && 1 != mailSent1) {
                        //调用Email接口
                        CommonResult commonResult = emailManager.sendEmail("<xml><email>" + cpInfoResultList.get(i).getEmail() + "</email><content>" + "发送CP绑定邮箱测试邮件" + "</content></xml>");/*CP绑定邮箱*/
                        if (commonResult.isSuccess()) {
                            //设置邮件1已发送标识
                            cpBaseInfo.setMailSent1(1);
                        } else {
                            //设置邮件1未发送标识
                            cpBaseInfo.setMailSent1(0);
                        }
                    }
                    if (1 != mailSent2) {
                        //调用Email接口
                        CommonResult commonResult = emailManager.sendEmail("<xml><email>abc@gmail.com</email><content>发送CMS管理邮箱测试邮件</content></xml>");/*CMS管理邮箱*/
                        if (commonResult.isSuccess()) {
                            //设置邮件1已发送标识
                            cpBaseInfo.setMailSent2(1);
                        } else {
                            //设置邮件1未发送标识
                            cpBaseInfo.setMailSent2(0);
                        }
                    }
                    //更新合同预警状态(短信)
                    syncScheduleManager.updateCpBaseInfo(cpBaseInfo);
                }
            }
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_UPDATEMARKETINGLOG)) {
            syncScheduleManager.createMarketLog();
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_ZHUOWANG_NEW_APP)) {
            zhuoWangInfoImportService.importNewApp();
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_SEND_MAIL)) { // 定时创建ZIP文件
            dailyReportService.CreateDailyReport();
        } else if (taskTypeId.equals(TaskTypeConstants.CMS_TASKTYPE_INCOMESTATISTIC)) {
            syncScheduleManager.salerArrStatistic();
          /*  syncScheduleManager.createIncomeStatistic();*/
        }
        //按任务类型ID查询同步任务信息
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(taskTypeId, -1);
        //根据同步任务ID更新实际执行时间
        syncScheduleManager.updateTaskFactTime(taskInfoResult.getId(), new Date());
    }

    /**
     * 停用周期性后台任务
     *
     * @param id
     * @param scheduler
     */
    public void pauseTrigger(int id, Scheduler scheduler) {
        try {
            //根据任务ID获取该任务触发器
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(String.valueOf(id), Scheduler.DEFAULT_GROUP);
            //该任务的触发器是否存在
            if (null != trigger) {
                //根据任务ID修改任务状态为停用
                int isSuccess = taskManagerCached.updateLoopTaskStatus(id, TaskTypeConstants.CMS_TASKSTATUS_STOP);
                if (isSuccess > 0) {
                    //停止触发器
                    scheduler.pauseTrigger(String.valueOf(id).trim(), Scheduler.DEFAULT_GROUP);
                }
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 启用周期性后台任务
     *
     * @param id
     * @param scheduler
     */
    public void resumeTrigger(int id, Scheduler scheduler) {
        try {
            //根据任务ID修改任务状态为启用
            int isSuccess = taskManagerCached.updateLoopTaskStatus(id, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
            //根据任务ID查询任务信息
            TaskInfoResult taskInfoResult = taskManagerCached.findLoopTaskInfoById(id, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
            //根据任务ID获取该任务触发器
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(String.valueOf(id), Scheduler.DEFAULT_GROUP);
            //该任务的触发器是否存在,不存在则新建后台任务
            if (null == trigger) {
                /*新建同步商品类目后台任务*/
                if (null != taskInfoResult && taskInfoResult.getTaskTypeId().toString().equals(TaskTypeConstants.CMS_TASKTYPE_CATEGORY)) {
                    //实例化JOB类
                    JobDetail jobDetail = new JobDetailBean();
                    //设置jobID
                    jobDetail.setName(String.valueOf(taskInfoResult.getId()));
                    //设置业务参数
                    jobDetail.getJobDataMap().put("categoryManager", categoryManager);
                    //设置业务参数
                    jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
                    //设置处理作业的类
                    jobDetail.setJobClass(ActDateSyncJob.class);
                    //设置周期同步时间
                    String sCronExpression = taskInfoResult.getLoopPeriod();
                    getCronTrigger(jobDetail, scheduler, sCronExpression);
                    /*新建生成下载统计日报后台任务*/
                } else if (null != taskInfoResult && taskInfoResult.getTaskTypeId().toString().equals(TaskTypeConstants.CMS_TASKTYPE_DOWNLOAD)) {/*生成下载统计日报*/
                    //实例化JOB类
                    JobDetail jobDetail = new JobDetailBean();
                    //设置jobID
                    jobDetail.setName(String.valueOf(taskInfoResult.getId()));
                    //设置业务参数
                    jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
                    //设置处理作业的类
                    jobDetail.setJobClass(DownloadStatisticalDailyJob.class);
                    //设置周期同步时间
                    String sCronExpression = taskInfoResult.getLoopPeriod();
                    getCronTrigger(jobDetail, scheduler, sCronExpression);
                    /*新建更新排行榜后台任务*/
                } else if (null != taskInfoResult && taskInfoResult.getTaskTypeId().toString().equals(TaskTypeConstants.CMS_TASKTYPE_TOP)) {/*更新排行榜*/
                    //实例化JOB类
                    JobDetail jobDetail = new JobDetailBean();
                    //设置jobID
                    jobDetail.setName(String.valueOf(taskInfoResult.getId()));
                    //设置业务参数
                    jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
                    //设置处理作业的类
                    jobDetail.setJobClass(UpdateTopJob.class);
                    //设置周期同步时间
                    String sCronExpression = taskInfoResult.getLoopPeriod();
                    getCronTrigger(jobDetail, scheduler, sCronExpression);
                    /*新建合到期预警检测后台任务*/
                } else if (null != taskInfoResult && taskInfoResult.getTaskTypeId().toString().equals(TaskTypeConstants.CMS_TASKTYPE_EXPIRATION)) {/*合到期预警检测*/
                    //实例化JOB类
                    JobDetail jobDetail = new JobDetailBean();
                    //设置jobID
                    jobDetail.setName(String.valueOf(taskInfoResult.getId()));
                    //设置业务参数
                    jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
                    //设置业务参数
                    jobDetail.getJobDataMap().put("emailManager", emailManager);
                    //设置业务参数
                    jobDetail.getJobDataMap().put("smsManager", smsManager);
                    //设置处理作业的类
                    jobDetail.setJobClass(ContractExpirationWarningJob.class);
                    //设置周期同步时间
                    String sCronExpression = taskInfoResult.getLoopPeriod();
                    getCronTrigger(jobDetail, scheduler, sCronExpression);
                }
            } else {
                if (isSuccess > 0) {
                    //存在则重启该后台任务
                    scheduler.resumeTrigger(String.valueOf(id).trim(), Scheduler.DEFAULT_GROUP);
                }
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据上一级类目ID获取上柜的子类目列表
     *
     * @param categoryId
     * @param categoryManager
     * @return
     */
    private List<Category> getSecondCategoryList(int categoryId, CategoryManager categoryManager) {
        List<Category> categoryList = new ArrayList<Category>();
        //根据上一级类目ID获取二级上柜的类目列表
        List<Category> childCategoryList = categoryManager.getChildCategoryList(categoryId, 1);
        //循环二级类目列表
        if (childCategoryList.size() > 0) {
            for (int i = 0; i < childCategoryList.size(); i++) {
                //根据上一级类目ID获取三级上柜的类目列表
                List<Category> categories = getThirdCategoryList(childCategoryList.get(i).getId(), categoryManager);
                if (categories.size() > 0) {
                    //循环三级类目列表
                    for (int j = 0; j < categories.size(); j++) {
                        //添加三级类目添加到类目列表
                        categoryList.add((Category) categories.get(j));
                    }
                }
                //添加二级类目添加到类目列表
                categoryList.add((Category) childCategoryList.get(i));
            }
        }
        return categoryList;
    }

    /**
     * 根据上一级类目ID获取三级上柜的类目列表
     *
     * @param categoryId
     * @param categoryManager
     * @return
     */
    private List<Category> getThirdCategoryList(int categoryId, CategoryManager categoryManager) {
        List<Category> categories = new ArrayList<Category>();
        //根据上一级类目ID获取三级上柜的类目列表
        categories = categoryManager.getChildCategoryList(categoryId, 1);
        return categories;
    }


    /**
     * 最新上架---精品
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

       /* rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_NEWEST);
        //查询移动游戏排行最新上架榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏最新上架已锁定记录
        findNewest(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);*/

       /* rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_NEWEST);
        //查询Web应用排行最新上架榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行最新上架已锁定记录
        findNewest(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);*/
    }

    /**
     * 查询可更新最新上架--精品 排行榜记录
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
        //查询下载最多排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动软件上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_SOFT, syncScheduleManager);

      /*  rankingApp = new RankingApp();
        //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_GAME);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FASTEST);
        //查询最快排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询移动游戏上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_GAME, syncScheduleManager);*/

        /* rankingApp = new RankingApp();
       //设置排行榜类型
        rankingApp.setRankingStyle(TaskTypeConstants.CMS_RANKING_WEB);
        //设置排行榜分类
        rankingApp.setRankingType(TaskTypeConstants.CMS_RANKING_FASTEST);
        //查询Web应用上升最快排行榜锁定记录
        rankingAppList = syncScheduleManager.findRankingApp(rankingApp);
        //查询Web应用排行上升最快已锁定记录
        findFastest(rankingAppList, TaskTypeConstants.CMS_RANKING_WEB, syncScheduleManager);*/
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
                if (i == 0) {
                    lockedOrder = String.valueOf(rankingAppList.get(i).getAppId());
                } else {
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
            style = Integer.parseInt(mobileSoftId);
        } else if (1 == rankingStyle) {
            style = Integer.parseInt(mobileGameId);
        } else if (rankingStyle == 2) {
            style = Integer.parseInt(webAppId);
        }
        return style;
    }

    /**
     * 创建触发器
     *
     * @param jobDetail
     * @param scheduler
     * @param cronExpression
     */
    public void getCronTrigger(JobDetail jobDetail, Scheduler scheduler, String cronExpression) {
        try {
            //添加Job
            scheduler.addJob(jobDetail, true);
            //设置触发器
            CronTrigger cronTrigger = new CronTrigger(jobDetail.getName(), Scheduler.DEFAULT_GROUP, jobDetail.getName(), Scheduler.DEFAULT_GROUP);
            //设置触发时间
            cronTrigger.setCronExpression(cronExpression);
            //将触发器加入调度器
            scheduler.scheduleJob(cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setTaskManagerCached(TaskManager taskManagerCached) {
        this.taskManagerCached = taskManagerCached;
    }

    public void setSyncScheduleManager(SyncScheduleManager syncScheduleManager) {
        this.syncScheduleManager = syncScheduleManager;
    }

    public void setCategoryManager(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    public void setEmailManager(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void setSmsManager(SMSManager smsManager) {
        this.smsManager = smsManager;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }

    public void setImgserver(String imgserver) {
        this.imgserver = imgserver;
    }

    public void setCoverserver(String coverserver) {
        this.coverserver = coverserver;
    }

    public void setZhuoWangInfoImportService(ZhuoWangInfoImportService zhuoWangInfoImportService) {
        this.zhuoWangInfoImportService = zhuoWangInfoImportService;
    }

    public void setDailyReportService(DailyReportService dailyReportService) {
        this.dailyReportService = dailyReportService;
    }
}
