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
 * 商品类目同步JOB
 */
public class ActDateSyncJob extends QuartzJobBean implements StatefulJob {
    private final static Log log = LogFactory.getLog(ActDateSyncJob.class);

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
        //更新类目信息
        syncScheduleManager.getActDate();
        //更新类目后台任务执行时间
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }
}
