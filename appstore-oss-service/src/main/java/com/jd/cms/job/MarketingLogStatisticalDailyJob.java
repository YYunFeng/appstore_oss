package com.jd.cms.job;

import com.jd.cms.manager.schedule.SyncScheduleManager;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * User: YYF
 * Date: 13-1-31
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class MarketingLogStatisticalDailyJob extends QuartzJobBean implements StatefulJob {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
       /* // 营销日志创建
        syncScheduleManager.createMarketLog();*/
        // 新版营销日志统计
        syncScheduleManager.createSalerLog();
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }
}
