package com.jd.cms.job;

import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.schedule.ErpScheduleManager;
import com.jd.cms.service.schedule.ErpScheduleService;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-28
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 * ERP总调度JOB
 */
public class ErpTotalScheduleJob extends QuartzJobBean implements StatefulJob {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取Scheduler对像
        Scheduler scheduler = (Scheduler) jobDetail.getJobDataMap().get("scheduler");
        //从JobDetail获取ErpScheduleService对像
        ErpScheduleService erpScheduleService = (ErpScheduleService) jobDetail.getJobDataMap().get("erpScheduleService");
        //从JobDetail获取ErpScheduleManager对像
        ErpScheduleManager erpScheduleManager = (ErpScheduleManager) jobDetail.getJobDataMap().get("erpScheduleManager");
        //查询ERP任务
        List<TaskInfoResult> taskInfoResultList = erpScheduleManager.findErpTaskInfo(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
        TaskInfoResult taskInfoResult;
        //循环将任务状态更新为已启动
        if (taskInfoResultList.size() > 0) {
            for (int i = 0; i < taskInfoResultList.size(); i++) {
                TaskInfoQuery taskInfoQuery = new TaskInfoQuery();
                //设置任务ID
                taskInfoQuery.setId(taskInfoResultList.get(i).getId());
                //设置任务状态
                taskInfoQuery.setStatus(TaskTypeConstants.CMS_TASKSTATUS_HASSTARTED);
                //更新任务状态
                erpScheduleManager.updateTaskStatus(taskInfoQuery);
            }
            //循环执行ERP任务
            for (int i = 0; i < taskInfoResultList.size(); i++) {/**/
                //同步应用基本信息
                if (TaskTypeConstants.CMS_TASKTYPE_BASEINFO.equals(String.valueOf(taskInfoResultList.get(i).getTaskTypeId()))) {
                    taskInfoResult = new TaskInfoResult();
                    taskInfoResult = (TaskInfoResult) taskInfoResultList.get(i);
                    //执行同步应用基本信息任务
                    erpScheduleService.appStoreBasicInfoSyncScheduler(taskInfoResult);
                    //上传主图
                } else if (TaskTypeConstants.CMS_TASKTYPE_UPLOADCOVER.equals(String.valueOf(taskInfoResultList.get(i).getTaskTypeId()))) {
                    taskInfoResult = new TaskInfoResult();
                    taskInfoResult = (TaskInfoResult) taskInfoResultList.get(i);
                    //执行上传主图任务
                    erpScheduleService.uploadCoverSyncScheduler(taskInfoResult);
                    //同步应用价格
                } else if (TaskTypeConstants.CMS_TASKTYPE_PRICE.equals(String.valueOf(taskInfoResultList.get(i).getTaskTypeId()))) {
                    taskInfoResult = new TaskInfoResult();
                    taskInfoResult = (TaskInfoResult) taskInfoResultList.get(i);
                    //执行同步应用价格任务
                    erpScheduleService.updatePriceSyncScheduler(taskInfoResult, TaskTypeConstants.CMS_TASKTYPE_UPLOADCOVER);
                    //同步上下架状态
                } else if (TaskTypeConstants.CMS_TASKTYPE_UPSTATUS.equals(String.valueOf(taskInfoResultList.get(i).getTaskTypeId()))) {
                    taskInfoResult = new TaskInfoResult();
                    taskInfoResult = (TaskInfoResult) taskInfoResultList.get(i);
                    //执行上传主图同步上下架状态任务
                    erpScheduleService.appStoreUpStatusSyncScheduler(taskInfoResult, TaskTypeConstants.CMS_TASKTYPE_UPLOADCOVER);
                }
            }
        }
    }
}
