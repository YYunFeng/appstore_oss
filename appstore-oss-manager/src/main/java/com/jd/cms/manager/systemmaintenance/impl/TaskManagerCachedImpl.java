package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.systemmaintenance.TaskManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-7
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public class TaskManagerCachedImpl implements TaskManager {
    private final static Log log = LogFactory.getLog(TaskManagerCachedImpl.class);
    /**
     * 后台任务管理Manager
     */
    private TaskManager taskManager;
    /**
     * memcache工具类
     */
    private CacheUtils cacheUtils;

    /**
     * 记录ERP任务列表页号
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<TaskInfoResult> findErpTaskList(int pageIndex, int pageSize, String appName, int status) {
        PaginatedList<TaskInfoResult> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_ERPTASK_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询ERP任务信息列表
        paginatedList = taskManager.findErpTaskList(pageIndex, pageSize, appName, status);
        //ERP任务信息列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ERPTASK_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findErpTaskList(pageIndex, pageSize, appName, status);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ERPTASK_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回ERP任务信息列表
        return paginatedList;
    }

    /**
     * 记录周期性任务列表页号
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<TaskInfoResult> findLoopTaskList(int pageIndex, int pageSize) {
        PaginatedList<TaskInfoResult> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //是否为第一页
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_LOOPTASK_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询周期性任务信息列表
        paginatedList = taskManager.findLoopTaskList(pageIndex, pageSize);
        //周期性任务信息列表是否存在
        if (0 == paginatedList.size()) {
            //判断是否为第一页
            if (1 < pageIndex) {
                //页号大于1，则当前页减1
                pageIndex = pageIndex - 1;
                //将页号写入memcached
                cacheUtils.set(CategoryConstants.CMS_LOOPTASK_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
                //递归调用本方法
                paginatedList = findLoopTaskList(pageIndex, pageSize);
            }
        }
        //将页号写入memcached
        cacheUtils.set(CategoryConstants.CMS_LOOPTASK_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        //返回周期性任务信息列表
        return paginatedList;
    }

    /**
     * 重新同步ERP后台任务
     *
     * @param id
     */
    public void resetErpTask(int id) {
        taskManager.resetErpTask(id);
    }

    /**
     * 根据任务ID修改任务状态为停用
     *
     * @param id
     * @param status
     * @return
     */
    public int updateLoopTaskStatus(int id, int status) {
        return taskManager.updateLoopTaskStatus(id, status);
    }

    /**
     * 根据任务ID查询任务信息
     *
     * @param id
     * @param status
     * @return
     */
    public TaskInfoResult findLoopTaskInfoById(int id, int status) {
        return taskManager.findLoopTaskInfoById(id, status);
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }
}
