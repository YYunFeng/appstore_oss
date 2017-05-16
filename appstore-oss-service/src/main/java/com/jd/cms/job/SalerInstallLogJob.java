package com.jd.cms.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * YYF on 2015/4/16.
 */
public class SalerInstallLogJob extends QuartzJobBean implements StatefulJob {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
      /*  //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = context.getJobDetail();
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
        // 营销日志创建
        syncScheduleManager.createSalerLog();
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());*/
    }
}
