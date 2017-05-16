package com.jd.cms.dao.systemmaintenance;

import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 下午12:30
 * To change this template use File | Settings | File Templates.
 */
public interface TaskDao {
    /**
     * 查询ERP任务列表
     *
     * @param query
     * @return
     */
    List<TaskInfoResult> findErpTaskList(Query query);

    /**
     * 查询ERP任务总数
     *
     * @param query
     * @return
     */
    int getErpTasks(Query query);

    /**
     * 查询周期性任务列表
     *
     * @param query
     * @return
     */
    List<TaskInfoResult> findLoopTaskList(Query query);

    /**
     * 查询周期性任务总数
     *
     * @param query
     * @return
     */
    int getLoopTasks(Query query);

    /**
     * 重新同步ERP后台任务
     *
     * @param query
     */
    void resetErpTask(Query query);

    /**
     * 根据任务ID修改任务状态为停用
     *
     * @param query
     */
    void updateLoopTaskStatus(Query query);

    /**
     * 根据任务ID查询任务信息
     *
     * @param query
     * @return
     */
    TaskInfoResult findLoopTaskInfoById(Query query);
}
