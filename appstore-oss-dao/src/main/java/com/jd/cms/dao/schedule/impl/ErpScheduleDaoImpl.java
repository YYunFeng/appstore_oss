package com.jd.cms.dao.schedule.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.schedule.ErpScheduleDao;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-29
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class ErpScheduleDaoImpl extends BaseDao implements ErpScheduleDao {
    /**
     * 查询ERP任务
     *
     * @param taskInfoQuery
     * @return
     */
    public List<TaskInfoResult> findErpTaskInfo(TaskInfoQuery taskInfoQuery) {
        return queryForList("ErpSchedule.findTaskInfoResult", taskInfoQuery);
    }

    /**
     * 更新任务状态和实际执行时间
     *
     * @param taskInfoQuery
     */
    public void updateTaskStatus(TaskInfoQuery taskInfoQuery) {
        update("ErpSchedule.updateTaskStatus", taskInfoQuery);
    }

    /**
     * 查询应用日志表信息
     *
     * @param query
     * @return
     */
    public AppLog findAppLog(Query query) {
        return (AppLog) queryForObject("ErpSchedule.findAppLog", query);
    }

    /**
     * 更新审核通过应用基本信息
     *
     * @param apps
     */
    public void updateApps(Apps apps) {
        update("ErpSchedule.updateApps", apps);
    }

    /**
     * 更新应用基本信息日志表ERP同步标识
     *
     * @param query
     */
    public void updateAppsLog(Query query) {
        update("ErpSchedule.updateAppLog", query);
    }

    /**
     * 已完成任务更新状态
     *
     * @param query
     */
    public void updateTaskBySuccessStatus(Query query) {
        delete("ErpSchedule.updateTaskBySuccessStatus", query);
    }

    /**
     * 更新任务状态,计划执行时间,次数
     *
     * @param taskInfoQuery
     */
    public void updateTaskInfo(TaskInfoQuery taskInfoQuery) {
        update("ErpSchedule.updateTaskInfo", taskInfoQuery);
    }

    /**
     * 删除无效任务
     *
     * @param taskId
     */
    public void removeInvalidTask(Query taskId){
        update("ErpSchedule.removeInvalidTask", taskId);
    }

    /**
     * 删除不存在的应用
     * @param appId
     */
    public void removeInvalidApp(Query appId){
        update("ErpSchedule.removeInvalidApp_1", appId);
        update("ErpSchedule.removeInvalidApp_2", appId);
        update("ErpSchedule.removeInvalidApp_3", appId);
        update("ErpSchedule.removeInvalidApp_4", appId);
    }

    /**
     * 查询应用详情日志表信息
     *
     * @param query
     * @return
     */
    public AppDetailsLog findAppDetailsLog(Query query) {
        return (AppDetailsLog) queryForObject("ErpSchedule.findAppDetailsLog", query);
    }

    /**
     * 查询应用详情表信息
     *
     * @param query
     * @return
     */
    public AppDetails findAppDetails(Query query) {
        return (AppDetails) queryForObject("ErpSchedule.findAppDetails", query);
    }

    /**
     * 查询应用详情表是否有该应用的信息
     *
     * @param query
     * @return
     */
    public int getAppDetails(Query query) {
        return (Integer) queryForObject("ErpSchedule.getAppDetails", query);
    }

    /**
     * 更新应用基本信息上下架状态
     *
     * @param query
     */
    public void updateAppsOnlineStatus(Query query) {
        update("ErpSchedule.updateAppsOnlineStatus", query);
    }

    /**
     * 更新应用基本日志信息上下架ERP同步标记
     *
     * @param query
     */
    public void updateAppsLogOnlineSyncFlag(Query query) {
        update("ErpSchedule.updateAppsLogOnlineSyncFlag", query);
    }

    /**
     * 更新应用基本信息日志上下架ERP同步标记
     *
     * @param query
     */
    public void updateAppPriceSyncFlag(Query query) {
        update("ErpSchedule.updateAppPriceSyncFlag", query);
    }

    /**
     * 修改应用资源副本状态
     *
     * @param query
     */
    public void updateAppIsCopyStatus(Query query) {
        update("ErpSchedule.updateAppIsCopyStatus", query);
    }

    /**
     * 查询资源副本
     *
     * @param query
     * @return
     */
    public int findAppResourceCopy(Query query) {
        return (Integer) queryForObject("ErpSchedule.findAppResourceCopy", query);
    }

    /**
     * 删除老资源
     *
     * @param query
     */
    public void deleteAppResource(Query query) {
        delete("ErpSchedule.deleteAppResource", query);
    }

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param backendTask
     */
    public void createBackendTask(BackendTask backendTask) {
        insert("ErpSchedule.createBackendTask", backendTask);
    }

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param appDetails
     */
    public void createAppDetails(AppDetails appDetails) {
        insert("ErpSchedule.createAppDetails", appDetails);
    }

    /**
     * 更新应用详情信息
     *
     * @param appDetails
     */
    public void updateAppDetails(AppDetails appDetails) {
        update("ErpSchedule.updateAppDetails", appDetails);
    }

    /**
     * 更新应用详情日志审核结果信息
     *
     * @param query
     */
    public void updateAppPriceCheckStatus(Query query) {
        update("ErpSchedule.updateAppPriceCheckStatus", query);
    }

    /**
     * 更新价格同步结果后台任务关联任务状态
     *
     * @param query
     */
    public void updateTaskInfoByRelatedId(Query query) {
        update("ErpSchedule.updateTaskInfoByRelatedId", query);
    }

    /**
     * 下架某应用的所有详情
     *
     * @param query
     */
    public void updateAppDetailByDownStatus(Query query) {
        update("ErpSchedule.updateAppDetailByDownStatus", query);
    }

    /**
     * 从推荐列表中移除下架的应用(手机、pad)
     *
     * @param query
     */
    public void resetOfflineAppFromRecommend(Query query) {
        update("ErpSchedule.resetOfflineAppFromRecommend", query);
    }

    /**
     * 从推荐列表中移除下架的应用
     *
     * @param query
     */
    public void removeOfflineAppFromRecommend(Query query) {
        update("ErpSchedule.removeOfflineAppFromRecommend", query);
    }

     /**
     * 从排行榜中移除下架的应用
     *
     * @param query
     */
    public void removeOfflineAppFromRanking(Query query) {
        update("ErpSchedule.removeOfflineAppFromRanking", query);
    }

    /**
     * 上架某应用的所有详情
     *
     * @param query
     */
    public void updateAppDetailByOnlineStatus(Query query) {
        update("ErpSchedule.updateAppDetailByOnlineStatus", query);
    }

    /**
     * 查询某应用的最新详情
     *
     * @param query
     * @return
     */
    public AppDetailsLog findAppDetailsLogByAppId(Query query) {
        return (AppDetailsLog) queryForObject("ErpSchedule.findAppDetailsLogByAppId", query);
    }

    /**
     * 根据应用基本信息日志ID查询上传主图任务数
     *
     * @param query
     * @return
     */
    public int findUploadCoverTaskById(Query query) {
        Integer result =(Integer) queryForObject("ErpSchedule.findUploadCoverTaskById", query);
        return result==null?0:result;
    }

    /**
     * 根据后台任务关联业务ID查询上传主图任务数
     *
     * @param query
     * @return
     */
    public int findUploadCoverTaskByRelatedId(Query query) {
        Integer result = (Integer) queryForObject("ErpSchedule.findUploadCoverTaskByRelatedId", query);
        return result == null? 0 :result;
    }

    /**
     * 根据应用ID查询主图地址
     * @param query
     * @return
     */
    public String getAppLogoUrl(Query query){
        String result = (String) queryForObject("ErpSchedule.getAppLogoUrl", query);
        return result;
    }

    /**
     * 更新应用详情日志表主图
     *
     * @param query
     */
    public void updateAppDetailsLogCover(Query query) {
        update("ErpSchedule.updateAppDetailsLogCover", query);
    }

    /**
     * 判断基本信息是否成功
     *
     * @param query
     * @return
     */
    public AppLog baseSyncFlagIsSuccess(Query query) {
        return (AppLog) queryForObject("ErpSchedule.baseSyncFlagIsSuccess", query);
    }

}
