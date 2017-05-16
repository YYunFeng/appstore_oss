package com.jd.cms.job;

import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-8
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangNewAppJob extends QuartzJobBean implements StatefulJob {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
        ZhuoWangInfoImportService zhuoWangInfoImportService = (ZhuoWangInfoImportService) jobDetail.getJobDataMap().get("zhuoWangInfoImportService");
        zhuoWangInfoImportService.importNewApp();
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }
}
