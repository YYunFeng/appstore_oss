package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.TaskDao;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.systemmaintenance.TaskManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class TaskManagerImpl extends BaseManager implements TaskManager {
    private final static Logger log = Logger.getLogger(TaskManagerImpl.class);
    /**
     * 后台任务管理Dao
     */
    private TaskDao taskDao;

    /**
     * 查询ERP后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @param appName
     * @param status
     * @return
     */
    public PaginatedList<TaskInfoResult> findErpTaskList(int pageIndex, int pageSize, String appName, int status) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<TaskInfoResult> tasks = new PaginatedArrayList<TaskInfoResult>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            //应用名称是否存在
            if (null != appName && !"".equals(appName)) {
                //设置应用名称
                baseQuery.setValue("%" + appName + "%");
            }
            baseQuery.setId(status);
            //查询ERP任务总数
            int totalItem = taskDao.getErpTasks(baseQuery);
            //设置ERP任务总数
            tasks.setTotalItem(totalItem);
            //设置页号
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            //设置记录数
            baseQuery.setEndRow(pageSize);
            //查询ERP任务列表
            List<TaskInfoResult> task = taskDao.findErpTaskList(baseQuery);
            //设置ERP任务列表
            tasks.addAll(task);
        } catch (Exception ex) {
            log.error("findErpTaskList 查询ERP后台任务列表方法 pageIndex="+pageIndex+" pageSize"+pageSize+" appName"+appName+" status"+status+" error!", ex);
            throw new RuntimeException("findErpTaskList 查询ERP后台任务列表方法 pageIndex="+pageIndex+" pageSize"+pageSize+" appName"+appName+" status"+status+" error!", ex);
        }
        return tasks;
    }

    /**
     * 查询周期性后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<TaskInfoResult> findLoopTaskList(int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<TaskInfoResult> tasks = new PaginatedArrayList<TaskInfoResult>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            //查询周期性任务总数
            int totalItem = taskDao.getLoopTasks(baseQuery);
            //设置周期性任务总数
            tasks.setTotalItem(totalItem);
            //设置页号
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            //设置记录数
            baseQuery.setEndRow(pageSize);
            //查询周期性任务列表
            List<TaskInfoResult> task = taskDao.findLoopTaskList(baseQuery);
            //设置周期性任务列表
            tasks.addAll(task);
        } catch (Exception ex) {
            log.error("findLoopTaskList 查询周期性后台任务列表方法 pageIndex="+pageIndex+" pageSize"+pageSize+" error!", ex);
            throw new RuntimeException("findLoopTaskList 查询周期性后台任务列表方法 pageIndex="+pageIndex+" pageSize"+pageSize+" error!", ex);
        }
        return tasks;
    }

    /**
     * 重新同步ERP后台任务
     *
     * @param id
     */
    public void resetErpTask(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    //设置任务ID
                    baseQuery.setId(id);
                    taskDao.resetErpTask(baseQuery);
                } catch (Exception ex) {
                    log.error("resetErpTask 重新同步ERP后台任务方法 id="+id+" error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("resetErpTask 重新同步ERP后台任务方法 id="+id+" error!", ex);
                }
            }
        });
    }

    /**
     * 根据任务ID修改任务状态为停用
     *
     * @param id
     * @param status
     * @return
     */
    public int updateLoopTaskStatus(final int id, final int status) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    //设置任务ID
                    baseQuery.setId(id);
                    //设置任务状态
                    baseQuery.setStartRow(status);
                    taskDao.updateLoopTaskStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateLoopTaskStatus 根据任务ID修改任务状态为停用方法 id="+id+" status"+status+" error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateLoopTaskStatus 根据任务ID修改任务状态为停用方法 id="+id+" status"+status+" error!", ex);
                }
            }
        });
        return 1;
    }

    /**
     * 根据任务ID查询任务信息
     *
     * @param id
     * @param status
     * @return
     */
    public TaskInfoResult findLoopTaskInfoById(int id, int status) {
        TaskInfoResult taskInfoResult;
        try {
            BaseQuery baseQuery = new BaseQuery();
            //设置任务ID
            baseQuery.setId(id);
            //设置任务状态
            baseQuery.setStartRow(status);
            taskInfoResult = taskDao.findLoopTaskInfoById(baseQuery);
        } catch (Exception ex) {
            log.error("updateLoopTaskStatus 根据任务ID查询任务信息方法 id="+id+" status"+status+" error!", ex);
            throw new RuntimeException("updateLoopTaskStatus 根据任务ID查询任务信息方法 id="+id+" status"+status+" error!", ex);
        }
        return taskInfoResult;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
