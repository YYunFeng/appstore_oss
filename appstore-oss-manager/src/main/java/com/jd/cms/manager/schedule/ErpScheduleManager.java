package com.jd.cms.manager.schedule;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-28
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public interface ErpScheduleManager {
    /**
     * 查询ERP任务
     * @param status
     * @return
     */
    List<TaskInfoResult> findErpTaskInfo(int status);
    /**
     * 更新任务状态和实际执行时间
     * @param taskInfoQuery
     */
    void updateTaskStatus(TaskInfoQuery taskInfoQuery);
    /**
     * 查询应用日志表信息
     * @param id
     * @return
     */
    AppLog findAppLog(int id);
    /**
     * 更新审核通过应用基本信息
     * @param apps
     */
    void updateApps(Apps apps);
    /**
     * 更新应用基本信息日志表ERP同步标识
     * @param id
     */
    void updateAppsLog(int id);
    /**
     * 删除已完成任务
     * @param id
     */
    void updateTaskBySuccessStatus(int id);
    /**
     * 更新任务状态,计划执行时间,次数
     * @param taskInfoQuery
     */
    void updateTaskInfo(TaskInfoQuery taskInfoQuery);

    /**
     * 删除无效的任务
     * @param taskId
     */
    void removeInvalidTask(int taskId);

    /**
     * 删除不存在的应用
     * @param appId
     */
    void removeInvalidApp(int appId);

    /**
     * 查询应用详情日志表信息
     * @param id
     * @return
     */
    AppDetailsLog findAppDetailsLog(int id);
    /**
     * 查询应用详情表信息
     * @param appId
     * @param accountId
     * @return
     */
    AppDetails findAppDetails(int appId, int accountId);
    /**
     * 查询应用详情表是否有该应用的信息
     * @param appId
     * @return
     */
    int getAppDetails(int appId);
    /**
     * 更新应用基本信息上下架状态
     * @param appId
     * @param onlineStatus
     * @param defaultDetailId
     */
    void updateAppsOnlineStatus(int appId, int onlineStatus, int defaultDetailId);
    /**
     * 更新应用基本日志信息上下架ERP同步标记
     * @param id
     */
    void updateAppsLogOnlineSyncFlag(int id);
    /**
     * 更新应用基本日志信息上下架ERP同步标记
     * @param id
     */
    void updateAppPriceSyncFlag(int id);
    /**
     * 修改应用资源副本状态
     */
    void updateAppIsCopyStatus(int appId,int accountId);
    /**
     * 查询资源副本
     */
    int findAppResourceCopy(int appId,int accountId);
    /**
     * 删除老资源
     */
    void deleteAppResource(int appId,int accountId);
    /**
     * 增加同步ERP价格后查询审核结果任务
     * @param backendTask
     */
    void createBackendTask(BackendTask backendTask);
    /**
     * 增加同步ERP价格后查询审核结果任务
     * @param appDetails
     * @return
     */
    int createAppDetails(AppDetails appDetails);
    /**
     * 更新应用详情信息
     * @param appDetails
     */
    void updateAppDetails(AppDetails appDetails);
    /**
     * 更新应用详情日志审核结果信息
     * @param id
     */
    void updateAppPriceCheckStatus(int id);
    /**
     * 更新价格同步结果后台任务关联任务状态
     * @param relatedId
     */
    void updateTaskInfoByRelatedId(int relatedId);
    /**
     * 下架某应用的所有详情
     * @param appId
     */
    void updateAppDetailByDownStatus(int appId);

    /**
     * 上架某应用的所有详情
     * @param appId
     */
    void updateAppDetailByOnlineStatus(int appId);

    /**
     * 查询某应用的最新详情
     * @param appId
     */
     AppDetailsLog findAppDetailsLogByAppId(int appId);

    /**
     * 根据应用基本信息日志ID查询上传主图任务数
     * @param id
     * @param status
     * @return
     */
    int findUploadCoverTaskById(int id,String status);

    /**
     * 根据后台任务关联业务ID查询上传主图任务数
     * @param relatedId
     * @param status
     * @return
     */
    int findUploadCoverTaskByRelatedId(int relatedId,String status);

    /**
     * 根据应用ID查询主图地址
     * @param appid
     * @return
     */
    String getAppLogoUrl(Integer appid);

    /**
     * 更新应用详情日志表主图
     * @param imgUrl
     */
    void updateAppDetailsLogCover(String imgUrl,int id);

    /**
     * 判断基本信息是否成功
     * @param appId
     * @return
     */
    AppLog baseSyncFlagIsSuccess(int appId);
}
