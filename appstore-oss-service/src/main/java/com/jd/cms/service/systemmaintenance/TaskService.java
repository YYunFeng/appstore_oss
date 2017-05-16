package com.jd.cms.service.systemmaintenance;

import com.jd.common.web.result.Result;
import org.quartz.Scheduler;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
public interface TaskService {
    /**
     * 查询ERP后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @param appName
     * @param status
     * @return
     */
    Result findErpTaskList(int pageIndex, int pageSize, String appName, int status);

    /**
     * 查询周期性后台任务列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result findLoopTaskList(int pageIndex, int pageSize);

    /**
     * 重新同步ERP后台任务
     *
     * @param id
     */
    void resetErpTask(int id);

    /**
     * 按后台任务类型立即执行周期性后台任务
     *
     * @param taskTypeId
     */
    void immediatelyExec(String taskTypeId) throws IOException;

    /**
     * 停用周期性后台任务
     *
     * @param id
     * @param scheduler
     */
    void pauseTrigger(int id, Scheduler scheduler);

    /**
     * 启用周期性后台任务
     *
     * @param id
     * @param scheduler
     */
    void resumeTrigger(int id, Scheduler scheduler);
}
