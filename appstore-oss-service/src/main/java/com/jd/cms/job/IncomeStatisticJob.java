package com.jd.cms.job;

import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.digital.common.rpc.domain.bean.category.Category;
import com.jd.digital.common.rpc.manager.category.CategoryManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 * 收入统计JOB
 */
public class IncomeStatisticJob extends QuartzJobBean implements StatefulJob {
    private final static Log log = LogFactory.getLog(IncomeStatisticJob.class);

    /**
     * execute方法，默执行的方法
     *
     * @param jobExecutionContext
     * @throws org.quartz.JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("每日收入统计更新任务开始");
        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
     /*   syncScheduleManager.createIncomeStatistic();*/
        syncScheduleManager.salerArrStatistic();
        log.info("每日收入统计更新任务结束");
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }

}
