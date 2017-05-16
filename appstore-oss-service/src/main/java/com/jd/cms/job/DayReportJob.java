package com.jd.cms.job;


import com.jd.cms.service.schedule.DailyReportService;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * 每日生成报表任务
 * User: YUNFENG
 * Date: 13-9-22
 * Time: 下午12:17
 * To change this template use File | Settings | File Templates.
 */
public class DayReportJob extends QuartzJobBean implements StatefulJob {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("生成每日报表任务开始执行。。");
        try {
            JobDetail jobDetail = context.getJobDetail();
            DailyReportService dailyReportService = (DailyReportService) jobDetail.getJobDataMap().get("dailyReportService");
            dailyReportService.CreateDailyReport();
            logger.info("生成每日报表任务执行结束。。");
        } catch (Exception e) {
            logger.error("系统异常，异常信息：" + e.getMessage());
        }
    }

}
