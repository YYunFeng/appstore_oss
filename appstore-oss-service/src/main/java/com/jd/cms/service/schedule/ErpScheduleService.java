package com.jd.cms.service.schedule;

import com.jd.cms.domain.taskmanager.TaskInfoResult;

/**
 * User: Administrator
 * Date: 12-7-28
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public interface ErpScheduleService {
    /**
     * 同步应用基本信息
     * @param taskInfoResult
     */
    void appStoreBasicInfoSyncScheduler(TaskInfoResult taskInfoResult);
    /**
     * 上传主图
     * @param taskInfoResult
     */
    void uploadCoverSyncScheduler(TaskInfoResult taskInfoResult);

    /**
     * 同步应用价格
     * @param taskInfoResult
     * @param status
     */
    void updatePriceSyncScheduler(TaskInfoResult taskInfoResult,String status);

    /**
     * 同步上下架状态
     * @param taskInfoResult
     * @param status
     */
    void appStoreUpStatusSyncScheduler(TaskInfoResult taskInfoResult,String status);

}
