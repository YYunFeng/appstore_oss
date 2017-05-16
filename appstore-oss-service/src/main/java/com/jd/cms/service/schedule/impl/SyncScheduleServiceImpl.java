package com.jd.cms.service.schedule.impl;


import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.job.*;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.cms.service.schedule.DailyReportService;
import com.jd.cms.service.schedule.SyncScheduleService;
import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import com.jd.cms.util.CategoryIdUtil;
import com.jd.digital.common.rpc.manager.category.CategoryManager;
import com.jd.digital.common.rpc.manager.email.EmailManager;
import com.jd.digital.common.rpc.manager.sms.SMSManager;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.JobDetailBean;

import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-20
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 * 周期同步任务
 */
public class SyncScheduleServiceImpl implements SyncScheduleService {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    /**
     * 周期性同步任务Manager
     */
    private SyncScheduleManager syncScheduleManager;
    /**
     * 类目同步接口
     */
    private CategoryManager categoryManager;
    /**
     * Email发送接口
     */
    private EmailManager emailManager;
    /**
     * 短信发送接口
     */
    private SMSManager smsManager;


    /**
     * 二级类目ID对象
     */
    private CategoryIdUtil categoryIdUtil;

    private ZhuoWangInfoImportService zhuoWangInfoImportService;

    private DailyReportService dailyReportService;

    public void syncTotalSchedule(Scheduler scheduler) {
        actDateSyncSchedule(scheduler);/*激活数据的获取*/
        contractExpirationWarningSchedule(scheduler);/*合同到期预警检测*/
        downloadStatisticalDailySchedule(scheduler);/*生成下载统计日报*/
        updateTopSchedule(scheduler);/*更新排行榜*/
        updateMarketingLog(scheduler);/*更新营销日志统计*/
        importNewAppSchedule(scheduler); /*同步卓望增量接口数据*/
        dayReport(scheduler); /*发送邮件*/
        createIncomeStatistic(scheduler);
    }



    public void dayReport(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_SEND_MAIL, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            jobDetail.getJobDataMap().put("dailyReportService", dailyReportService);
            //设置处理作业的类
            jobDetail.setJobClass(DayReportJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
//            sCronExpression = "0/3 * * * * ?";
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    public void updateMarketingLog(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_UPDATEMARKETINGLOG, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            //设置处理作业的类
            jobDetail.setJobClass(MarketingLogStatisticalDailyJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
            /*sCronExpression = "0/3 * * * * ?";*/
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    /**
     * 获取激活数据
     *
     * @param scheduler
     */
    public void actDateSyncSchedule(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_CATEGORY, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            //设置处理作业的类
            jobDetail.setJobClass(ActDateSyncJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    /**
     * 合同到期预警检测
     *
     * @param scheduler
     */
    public void contractExpirationWarningSchedule(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_EXPIRATION, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
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
    }

    /**
     * 生成下载统计日报
     *
     * @param scheduler
     */
    public void downloadStatisticalDailySchedule(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_DOWNLOAD, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
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
        }
    }


    /**
     * 更新排行榜
     *
     * @param scheduler
     */
    public void updateTopSchedule(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_TOP, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            jobDetail.getJobDataMap().put("categoryIdUtil", categoryIdUtil);
            //设置处理作业的类
            jobDetail.setJobClass(UpdateTopJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
//            sCronExpression = "0 10 16 * * ?";
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    /**
     * 更新卓望新增应用
     *
     * @param scheduler
     */
    public void importNewAppSchedule(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_ZHUOWANG_NEW_APP, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            jobDetail.getJobDataMap().put("zhuoWangInfoImportService", zhuoWangInfoImportService);
            //设置处理作业的类
            jobDetail.setJobClass(ZhuoWangNewAppJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
//           sCronExpression = "0/10 * * * * ?";
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    public void createIncomeStatistic() {
        syncScheduleManager.createIncomeStatistic();
    }

    public void salerStatistic() {
        syncScheduleManager.salerArrStatistic();
    }

    /**
     * 后台任务调度
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

    /**
     * 生成每月收入统计
     *
     * @param scheduler
     */
    public void createIncomeStatistic(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_INCOMESTATISTIC, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            //设置处理作业的类
            jobDetail.setJobClass(IncomeStatisticJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
    }

    public void salerInstallLog(Scheduler scheduler) {
        TaskInfoResult taskInfoResult = syncScheduleManager.findSyncTaskInfo(TaskTypeConstants.CMS_TASKTYPE_SALERINTALLLOG, TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        if (null != taskInfoResult) {
            //实例化JOB类
            JobDetail jobDetail = new JobDetailBean();
            //设置jobID
            jobDetail.setName(String.valueOf(taskInfoResult.getId()));
            //设置业务参数
            jobDetail.getJobDataMap().put("syncScheduleManager", syncScheduleManager);
            //设置处理作业的类
            jobDetail.setJobClass(SalerInstallLogJob.class);
            //设置周期同步时间
            String sCronExpression = taskInfoResult.getLoopPeriod();
            /*sCronExpression = "0/3 * * * * ?";*/
            getCronTrigger(jobDetail, scheduler, sCronExpression);
        }
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

    public void setCategoryIdUtil(CategoryIdUtil categoryIdUtil) {
        this.categoryIdUtil = categoryIdUtil;
    }

    public void setZhuoWangInfoImportService(ZhuoWangInfoImportService zhuoWangInfoImportService) {
        this.zhuoWangInfoImportService = zhuoWangInfoImportService;
    }


    public void setDailyReportService(DailyReportService dailyReportService) {
        this.dailyReportService = dailyReportService;
    }
}
