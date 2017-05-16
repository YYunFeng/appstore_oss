package com.jd.cms.manager.systemmaintenance;

import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public interface TaskManager {
    /**
     * 查询ERP后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @param appName
     * @param status
     * @return
     */
    PaginatedList<TaskInfoResult> findErpTaskList(int pageIndex, int pageSize, String appName, int status);

    /**
     * 查询周期性后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PaginatedList<TaskInfoResult> findLoopTaskList(int pageIndex, int pageSize);

    /**
     * 重新同步ERP后台任务
     *
     * @param id
     */
    void resetErpTask(int id);

    /**
     * 根据任务ID修改任务状态为停用
     *
     * @param id
     * @param status
     * @return
     */
    int updateLoopTaskStatus(int id, int status);

    /**
     * 根据任务ID查询任务信息
     *
     * @param id
     * @param status
     * @return
     */
    TaskInfoResult findLoopTaskInfoById(int id, int status);
}
