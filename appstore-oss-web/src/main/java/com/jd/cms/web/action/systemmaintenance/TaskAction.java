package com.jd.cms.web.action.systemmaintenance;

import com.jd.cms.common.servlet.SchedulerServlet;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import com.jd.cms.service.systemmaintenance.TaskService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.quartz.Scheduler;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午9:36
 * To change this template use File | Settings | File Templates.
 */
public class TaskAction extends BaseAction {
    /**
     * 后台任务查询条件
     */
    private TaskInfoQuery taskInfoQuery;
    /**
     * 后台任务管理Service
     */
    private TaskService taskService;

    private ZhuoWangInfoImportService zhuoWangInfoImportService;

    /**
     * 查询ERP后台任务列表
     *
     * @return
     * @throws Exception
     */
    public String erpList() {
        //应用名称
        String appName = "";
        //任务状态
        int status = 3;
        if (null != taskInfoQuery) {
            appName = taskInfoQuery.getAppName();
            status = taskInfoQuery.getStatus();
        }
        Result result = taskService.findErpTaskList(page, PAGE_SIZE, appName, status);
        toVm(result);
        return "erp";
    }

    /**
     * 查询周期性后台任务列表
     *
     * @return
     * @throws Exception
     */
    public String loopList() throws Exception {
        Result result = taskService.findLoopTaskList(page, PAGE_SIZE);
        toVm(result);
        return "loop";
    }

    /**
     * 重新同步ERP后台任务
     *
     * @return
     * @throws Exception
     */
    public String resetErpTask() throws Exception {
        int id = 0;
        if (null != taskInfoQuery) {
            id = taskInfoQuery.getId();
        }
        taskService.resetErpTask(id);
        return erpList();
    }

    /**
     * 按后台任务类型立即执行周期性后台任务
     *
     * @return
     * @throws Exception
     */
    public String immediatelyExec() throws Exception {
        if (null != taskInfoQuery) {
            //任务类型ID
            String taskTypeId = taskInfoQuery.getTaskTypeId().trim();
            taskService.immediatelyExec(taskTypeId);
        }
        return loopList();
    }

    /**
     * 启用周期性后台任务
     *
     * @return
     * @throws Exception
     */
    public String enable() throws Exception {
        Scheduler scheduler = SchedulerServlet.getInstanceScheduler();
        if (null != taskInfoQuery) {
            //任务ID
            int id = taskInfoQuery.getId();
            taskService.resumeTrigger(id, scheduler);
        }
        return loopList();
    }

    /**
     * 停用周期性后台任务
     *
     * @return
     * @throws Exception
     */
    public String disable() throws Exception {
        Scheduler scheduler = SchedulerServlet.getInstanceScheduler();
        if (null != taskInfoQuery) {
            //任务ID
            int id = taskInfoQuery.getId();
            taskService.pauseTrigger(id, scheduler);
        }
        return loopList();
    }


    public TaskInfoQuery getTaskInfoQuery() {
        return taskInfoQuery;
    }

    public void setTaskInfoQuery(TaskInfoQuery taskInfoQuery) {
        this.taskInfoQuery = taskInfoQuery;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ZhuoWangInfoImportService getZhuoWangInfoImportService() {
        return zhuoWangInfoImportService;
    }

    public void setZhuoWangInfoImportService(ZhuoWangInfoImportService zhuoWangInfoImportService) {
        this.zhuoWangInfoImportService = zhuoWangInfoImportService;
    }
}
