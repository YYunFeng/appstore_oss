package com.jd.cms.job;

import com.jd.appstore.domain.AppDownloadStat;
import com.jd.cms.manager.schedule.SyncScheduleManager;
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
 * Time: 上午10:47
 * To change this template use File | Settings | File Templates.
 * 生成下载统计日报JOB
 */
public class DownloadStatisticalDailyJob extends QuartzJobBean implements StatefulJob {
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
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
        //按应用统计前一天的下载次数
        List<AppDownloadStat> appDownloadStatList = syncScheduleManager.findAppDownloadStat();
        if (null != appDownloadStatList) {
            //创建应用下载统计结果
            syncScheduleManager.createAppDownloadStat(appDownloadStatList);
            //创建应用下载汇总
            syncScheduleManager.createDownloadTotalstat();
            //根据同步任务ID更新实际执行时间
            syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
        }
    }
}
