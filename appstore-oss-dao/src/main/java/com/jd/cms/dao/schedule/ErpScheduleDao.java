package com.jd.cms.dao.schedule;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-29
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public interface ErpScheduleDao {
    /**
     * 查询ERP任务
     *
     * @param taskInfoQuery
     * @return
     */
    List<TaskInfoResult> findErpTaskInfo(TaskInfoQuery taskInfoQuery);

    /**
     * 更新任务状态和实际执行时间
     *
     * @param taskInfoQuery
     */
    void updateTaskStatus(TaskInfoQuery taskInfoQuery);

    /**
     * 查询应用日志表信息
     *
     * @param query
     * @return
     */
    AppLog findAppLog(Query query);

    /**
     * 更新审核通过应用基本信息
     *
     * @param apps
     */
    void updateApps(Apps apps);

    /**
     * 更新应用基本信息日志表ERP同步标识
     *
     * @param query
     */
    void updateAppsLog(Query query);

    /**
     * 已完成任务更新状态
     *
     * @param query
     */
    void updateTaskBySuccessStatus(Query query);

    /**
     * 更新任务状态,计划执行时间,次数
     *
     * @param taskInfoQuery
     */
    void updateTaskInfo(TaskInfoQuery taskInfoQuery);

    /**
     * 删除无效任务
     *
     * @param taskId
     */
    void removeInvalidTask(Query taskId);

    /**
     * 删除不存在的应用
     * @param appId
     */
    void removeInvalidApp(Query appId);


    /**
     * 查询应用详情日志表信息
     *
     * @param query
     * @return
     */
    AppDetailsLog findAppDetailsLog(Query query);

    /**
     * 查询应用详情表信息
     *
     * @param query
     * @return
     */
    AppDetails findAppDetails(Query query);

    /**
     * 查询应用详情表是否有该应用的信息
     *
     * @param query
     * @return
     */
    int getAppDetails(Query query);

    /**
     * 更新应用基本信息上下架状态
     *
     * @param query
     */
    void updateAppsOnlineStatus(Query query);

    /**
     * 更新应用基本日志信息上下架ERP同步标记
     *
     * @param query
     */
    void updateAppsLogOnlineSyncFlag(Query query);

    /**
     * 更新应用基本信息日志上下架ERP同步标记
     *
     * @param query
     */
    void updateAppPriceSyncFlag(Query query);

    /**
     * 修改应用资源副本状态
     *
     * @param query
     */
    void updateAppIsCopyStatus(Query query);

    /**
     * 查询资源副本
     *
     * @param query
     * @return
     */
    int findAppResourceCopy(Query query);

    /**
     * 删除老资源
     *
     * @param query
     */
    void deleteAppResource(Query query);

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param backendTask
     */
    void createBackendTask(BackendTask backendTask);

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param appDetails
     */
    void createAppDetails(AppDetails appDetails);

    /**
     * 更新应用详情信息
     *
     * @param appDetails
     */
    void updateAppDetails(AppDetails appDetails);

    /**
     * 更新应用详情日志审核结果信息
     *
     * @param query
     */
    void updateAppPriceCheckStatus(Query query);

    /**
     * 更新价格同步结果后台任务关联任务状态
     *
     * @param query
     */
    void updateTaskInfoByRelatedId(Query query);

    /**
     * 下架某应用的所有详情
     *
     * @param query
     */
    void updateAppDetailByDownStatus(Query query);


    /**
     * 从推荐列表中移除下架的应用(手机、pad)
     *
     * @param query
     */
    void resetOfflineAppFromRecommend(Query query);

    /**
     * 从推荐列表中移除下架的应用(不含手机、pad)
     *
     * @param query
     */
    void removeOfflineAppFromRecommend(Query query);

    /**
     * 从排行榜中移除下架的应用
     *
     * @param query
     */
    void removeOfflineAppFromRanking(Query query);


    /**
     * 上架某应用的所有详情
     *
     * @param query
     */
    void updateAppDetailByOnlineStatus(Query query);


    /**
     * 查询某应用的最新详情
     *
     * @param query
     * @return
     */
    AppDetailsLog findAppDetailsLogByAppId(Query query);

    /**
     * 根据应用基本信息日志ID查询上传主图任务数
     *
     * @param query
     * @return
     */
    int findUploadCoverTaskById(Query query);

    /**
     * 根据后台任务关联业务ID查询上传主图任务数
     *
     * @param query
     * @return
     */
    int findUploadCoverTaskByRelatedId(Query query);

    /**
     * 根据应用ID查询主图地址
     * @param query
     * @return
     */
    String getAppLogoUrl(Query query);

    /**
     * 更新应用详情日志表主图
     *
     * @param query
     */
    void updateAppDetailsLogCover(Query query);

    /**
     * 判断基本信息是否成功
     *
     * @param query
     * @return
     */
    AppLog baseSyncFlagIsSuccess(Query query);
}
