package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.TaskDao;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-7
 * Time: 下午12:30
 * To change this template use File | Settings | File Templates.
 */
public class TaskDaoImpl extends BaseDao implements TaskDao {
    /**
     * 查询ERP任务列表
     *
     * @param query
     * @return
     */
    public List<TaskInfoResult> findErpTaskList(Query query) {
        return queryForList("SystemMaintenance.findErpTaskList", query);
    }

    /**
     * 查询ERP任务总数
     *
     * @param query
     * @return
     */
    public int getErpTasks(Query query) {
        return (Integer) queryForObject("SystemMaintenance.getErpTasks", query);
    }

    /**
     * 查询周期性任务列表
     *
     * @param query
     * @return
     */
    public List<TaskInfoResult> findLoopTaskList(Query query) {
        return queryForList("SystemMaintenance.findLoopTaskList", query);
    }

    /**
     * 查询周期性任务总数
     *
     * @param query
     * @return
     */
    public int getLoopTasks(Query query) {
        return (Integer) queryForObject("SystemMaintenance.getLoopTasks", query);
    }

    /**
     * 重新同步ERP后台任务
     *
     * @param query
     */
    public void resetErpTask(Query query) {
        update("SystemMaintenance.resetErpTask", query);
    }

    /**
     * 根据任务ID修改任务状态为停用
     *
     * @param query
     */
    public void updateLoopTaskStatus(Query query) {
        update("SystemMaintenance.updateLoopTaskStatus", query);
    }

    /**
     * 根据任务ID查询任务信息
     *
     * @param query
     * @return
     */
    public TaskInfoResult findLoopTaskInfoById(Query query) {
        return (TaskInfoResult) queryForObject("SystemMaintenance.findLoopTaskInfoById", query);
    }
}
