package com.jd.cms.manager.schedule.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.schedule.ErpScheduleDao;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.schedule.ErpScheduleManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.base.BaseQuery;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-28
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
public class ErpScheduleManagerImpl extends BaseManager implements ErpScheduleManager {
    private final static Logger log = Logger.getLogger(SyncScheduleManagerImpl.class);
    private ErpScheduleDao erpScheduleDao;

    /**
     * 查询ERP任务
     *
     * @param status
     * @return
     */
    public List<TaskInfoResult> findErpTaskInfo(int status) {
        List<TaskInfoResult> taskInfoResultList = new ArrayList<TaskInfoResult>();
        TaskInfoQuery taskInfoQuery = new TaskInfoQuery();
        taskInfoQuery.setStatus(status);
        try {
            taskInfoResultList = erpScheduleDao.findErpTaskInfo(taskInfoQuery);
        } catch (Exception ex) {
            log.error("findErpTaskInfo 查询ERP任务方法 status=" + status + " error!", ex);
            throw new RuntimeException("findErpTaskInfo 查询ERP任务方法 status=" + status + " error!", ex);
        }
        return taskInfoResultList;
    }

    /**
     * 更新任务状态和实际执行时间
     *
     * @param taskInfoQuery
     */
    public void updateTaskStatus(final TaskInfoQuery taskInfoQuery) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.updateTaskStatus(taskInfoQuery);
                } catch (Exception ex) {
                    log.error("updateTaskStatus 更新任务状态和实际执行时间方法 taskInfoQuery=" + taskInfoQuery + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTaskStatus 更新任务状态和实际执行时间方法 taskInfoQuery=" + taskInfoQuery + " error!", ex);
                }
            }
        });
    }

    /**
     * 已完成任务更新状态
     *
     * @param id
     */
    public void updateTaskBySuccessStatus(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(id);
                    erpScheduleDao.updateTaskBySuccessStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateTaskBySuccessStatus 已完成任务更新状态方法 id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTaskBySuccessStatus 已完成任务更新状态方法 id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新任务状态,计划执行时间,次数
     *
     * @param taskInfoQuery
     */
    public void updateTaskInfo(final TaskInfoQuery taskInfoQuery) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.updateTaskInfo(taskInfoQuery);
                } catch (Exception ex) {
                    log.error("updateTaskInfo 更新任务状态,计划执行时间,次数方法 taskInfoQuery=" + taskInfoQuery + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTaskInfo 更新任务状态,计划执行时间,次数方法 taskInfoQuery=" + taskInfoQuery + " error!", ex);
                }
            }
        });
    }

    /**
     * 删除无效的任务
     *
     * @param taskId
     */
    public void removeInvalidTask(final int taskId){
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                BaseQuery baseQuery = new BaseQuery();
                baseQuery.setId(taskId);
                try {
                    erpScheduleDao.removeInvalidTask( baseQuery );
                } catch (Exception ex) {
                    log.error("removeInvalidTask 删除无效的任务  taskId=" + taskId + " error!", ex);
                    transactionStatus.setRollbackOnly();

                }
            }
        });
    }


    /**
     * 删除不存在的应用
     * @param appId
     */
    public void removeInvalidApp(final int appId){
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                BaseQuery baseQuery = new BaseQuery();
                baseQuery.setId(appId);
                try {
                    erpScheduleDao.removeInvalidApp( baseQuery );
                } catch (Exception ex) {
                    log.error("removeInvalidapp 删除不存在的应用  appid=" + appId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    /**
     * 查询应用日志表信息
     *
     * @param id
     * @return
     */
    public AppLog findAppLog(int id) {
        AppLog appLog;
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setId(id);
        try {
            appLog = erpScheduleDao.findAppLog(baseQuery);
        } catch (Exception ex) {
            log.error("findAppLog 查询应用日志表信息方法 id=" + id + " error!", ex);
            throw new RuntimeException("findAppLog 查询应用日志表信息方法 id=" + id + " error!", ex);
        }
        return appLog;
    }

    /**
     * 更新审核通过应用基本信息
     *
     * @param apps
     */
    public void updateApps(final Apps apps) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.updateApps(apps);
                } catch (Exception ex) {
                    log.error("createApps 更新审核通过应用基本信息方法 apps=" + apps + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createApps 更新审核通过应用基本信息方法 apps=" + apps + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新应用基本信息日志表ERP同步标识
     *
     * @param id
     */
    public void updateAppsLog(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(id);
                    erpScheduleDao.updateAppsLog(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppsLog 更新应用基本信息日志表ERP同步标识方法 id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppsLog 更新应用基本信息日志表ERP同步标识方法 id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询应用详情日志表信息
     *
     * @param id
     * @return
     */
    public AppDetailsLog findAppDetailsLog(int id) {
        AppDetailsLog appDetailsLog;
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setId(id);
        try {
            appDetailsLog = erpScheduleDao.findAppDetailsLog(baseQuery);
        } catch (Exception ex) {
            log.error("AppDetailsLog 查询应用详情日志表信息方法 id=" + id + " error!", ex);
            throw new RuntimeException("AppDetailsLog 查询应用详情日志表信息方法 id=" + id + " error!", ex);
        }
        return appDetailsLog;
    }

    /**
     * 查询应用详情表信息
     *
     * @param appId
     * @param accountId
     * @return
     */
    public AppDetails findAppDetails(int appId, int accountId) {
        AppDetails appDetails;
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setId(appId);
        baseQuery.setStartRow(accountId);
        try {
            appDetails = erpScheduleDao.findAppDetails(baseQuery);
        } catch (Exception ex) {
            log.error("findAppDetails 查询应用详情表信息方法 appId=" + appId + " accountId" + accountId + " error!", ex);
            throw new RuntimeException("findAppDetails 查询应用详情表信息方法 appId=" + appId + " accountId" + accountId + " error!", ex);
        }
        return appDetails;
    }

    /**
     * 查询应用详情表是否有该应用的信息
     *
     * @param appId
     * @return
     */
    public int getAppDetails(int appId) {
        int index;
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setId(appId);
        try {
            index = erpScheduleDao.getAppDetails(baseQuery);
        } catch (Exception ex) {
            log.error("getAppDetails 查询应用详情表是否有该应用的信息方法 appId=" + appId + " error!", ex);
            throw new RuntimeException("getAppDetails 查询应用详情表是否有该应用的信息方法 appId=" + appId + " error!", ex);
        }
        return index;
    }

    /**
     * 更新应用基本信息上下架状态
     *
     * @param appId
     * @param onlineStatus
     * @param defaultDetailId
     */
    public void updateAppsOnlineStatus(final int appId, final int onlineStatus, final int defaultDetailId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(appId);
                    baseQuery.setStartRow(onlineStatus);
                    baseQuery.setEndRow(defaultDetailId);
                    erpScheduleDao.updateAppsOnlineStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateOnlineStatus 更新应用基本信息上下架状态方法 appId=" + appId + " onlineStatus" + onlineStatus + " defaultDetailId" + defaultDetailId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateOnlineStatus 更新应用基本信息上下架状态方法 appId=" + appId + " onlineStatus" + onlineStatus + " defaultDetailId" + defaultDetailId + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新应用基本日志信息上下架ERP同步标记
     *
     * @param id
     */
    public void updateAppsLogOnlineSyncFlag(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(id);
                    erpScheduleDao.updateAppsLogOnlineSyncFlag(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppsLogOnlineSyncFlag 更新应用基本日志信息上下架ERP同步标记方法 id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppsLogOnlineSyncFlag 更新应用基本日志信息上下架ERP同步标记方法 id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新应用基本信息日志上下架ERP同步标记
     *
     * @param id
     */
    public void updateAppPriceSyncFlag(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(id);
                    erpScheduleDao.updateAppPriceSyncFlag(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppsLogOnlineSyncFlag 更新应用基本信息日志上下架ERP同步标记方法 id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppsLogOnlineSyncFlag 更新应用基本信息日志上下架ERP同步标记方法 id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 修改应用资源副本状态
     */
    public void updateAppIsCopyStatus(final int appId, final int accountId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setStartRow(appId);
                    baseQuery.setEndRow(accountId);
                    erpScheduleDao.updateAppIsCopyStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppIsCopyStatus 修改应用资源副本状态方法 appId=" + appId + " accountId" + accountId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppIsCopyStatus 修改应用资源副本状态方法 appId=" + appId + " accountId" + accountId + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询资源副本
     *
     * @return
     */
    public int findAppResourceCopy(final int appId, final int accountId) {
        int appResource = 0;
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setStartRow(appId);
            baseQuery.setEndRow(accountId);
            appResource = erpScheduleDao.findAppResourceCopy(baseQuery);
        } catch (Exception ex) {
            log.error("findAppResourceCopy 查询资源副本方法 appId=" + appId + " accountId" + accountId + " error!", ex);
            throw new RuntimeException("findAppResourceCopy 查询资源副本方法 appId=" + appId + " accountId" + accountId + " error!", ex);
        }
        return appResource;
    }

    /**
     * 删除老资源
     *
     * @param appId
     * @param accountId
     * @return
     */
    public void deleteAppResource(final int appId, final int accountId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setStartRow(appId);
                    baseQuery.setEndRow(accountId);
                    erpScheduleDao.deleteAppResource(baseQuery);
                } catch (Exception ex) {
                    log.error("deleteAppResource 删除老资源方法 appId=" + appId + " accountId" + accountId + "  error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("deleteAppResource 删除老资源方法 appId=" + appId + " accountId" + accountId + "  error!", ex);
                }
            }
        });
    }

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param backendTask
     */
    public void createBackendTask(final BackendTask backendTask) {
        backendTask.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.createBackendTask(backendTask);
                } catch (Exception ex) {
                    log.error("createBackendTask 增加同步ERP价格后查询审核结果任务方法 backendTask=" + backendTask + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createBackendTask error!", ex);
                }
            }
        });
    }

    /**
     * 增加同步ERP价格后查询审核结果任务
     *
     * @param appDetails
     * @return
     */
    public int createAppDetails(final AppDetails appDetails) {
        appDetails.setId((int) sequenceUtil.get(SequenceConstants.APP_DETAILS));
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.createAppDetails(appDetails);
                } catch (Exception ex) {
                    log.error("createBackendTask 增加同步ERP价格后查询审核结果任务方法 appDetails=" + appDetails + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createBackendTask 增加同步ERP价格后查询审核结果任务方法 appDetails=" + appDetails + " error!", ex);
                }
            }
        });
        return appDetails.getId();
    }

    /**
     * 更新应用详情信息
     *
     * @param appDetails
     */
    public void updateAppDetails(final AppDetails appDetails) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    erpScheduleDao.updateAppDetails(appDetails);
                } catch (Exception ex) {
                    log.error("updateAppDetails 更新应用详情信息方法 appDetails=" + appDetails + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppDetails 更新应用详情信息方法 appDetails=" + appDetails + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新应用详情日志审核结果信息
     *
     * @param id
     */
    public void updateAppPriceCheckStatus(final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(id);
                    erpScheduleDao.updateAppPriceCheckStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppPriceCheckStatus 更新应用详情日志审核结果信息方法 id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppPriceCheckStatus 更新应用详情日志审核结果信息方法 id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 更新价格同步结果后台任务关联任务状态
     *
     * @param relatedId
     */
    public void updateTaskInfoByRelatedId(final int relatedId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(relatedId);
                    erpScheduleDao.updateTaskInfoByRelatedId(baseQuery);
                } catch (Exception ex) {
                    log.error("updateTaskInfoByRelatedId 更新价格同步结果后台任务关联任务状态方法 relatedId=" + relatedId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTaskInfoByRelatedId 更新价格同步结果后台任务关联任务状态方法 relatedId=" + relatedId + " error!", ex);
                }
            }
        });
    }

    /**
     * 下架某应用的所有详情
     *
     * @param appId
     */
    public void updateAppDetailByDownStatus(final int appId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(appId);
                    erpScheduleDao.updateAppDetailByDownStatus(baseQuery);
                    /*从推荐列表和排行榜中移除下架的应用*/
                    erpScheduleDao.resetOfflineAppFromRecommend(baseQuery);
                    erpScheduleDao.removeOfflineAppFromRecommend(baseQuery);
                    erpScheduleDao.removeOfflineAppFromRanking(baseQuery);

                } catch (Exception ex) {
                    log.error("updateAppDetailByDownStatus 下架某应用的所有详情方法 appId=" + appId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppDetailByDownStatus 下架某应用的所有详情方法 appId=" + appId + " error!", ex);
                }
            }
        });
    }

    /**
     * 上架某应用的所有详情
     *
     * @param appId
     */
    public void updateAppDetailByOnlineStatus(final int appId) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setId(appId);
                    erpScheduleDao.updateAppDetailByOnlineStatus(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppDetailByOnlineStatus 上架某应用的所有详情方法 appId=" + appId + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppDetailByOnlineStatus 上架某应用的所有详情方法 appId=" + appId + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询某应用的最新详情
     *
     * @param appId
     */
    public AppDetailsLog findAppDetailsLogByAppId(final int appId) {
        AppDetailsLog appDetailsLog;
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setId(appId);
        try {
            appDetailsLog = erpScheduleDao.findAppDetailsLogByAppId(baseQuery);
        } catch (Exception ex) {
            log.error("findAppDetailsLogByAppId 查询某应用的最新详情方法 appId=" + appId + " error!", ex);
            throw new RuntimeException("findAppDetailsLogByAppId 查询某应用的最新详情方法 appId=" + appId + " error!", ex);
        }
        return appDetailsLog;
    }

    /**
     * 根据应用基本信息日志ID查询上传主图任务数
     *
     * @param id
     * @return
     */
    public int findUploadCoverTaskById(int id, String status) {
        int taskNum = 0;
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setId(id);
            baseQuery.setValue(status);
            taskNum = erpScheduleDao.findUploadCoverTaskById(baseQuery);
        } catch (Exception ex) {
            log.error("findUploadCoverTaskById 根据应用基本信息日志ID查询上传主图任务数方法 id=" + id + " status" + status + " error!", ex);
            throw new RuntimeException("findUploadCoverTaskById 根据应用基本信息日志ID查询上传主图任务数方法 id=" + id + " status" + status + " error!", ex);
        }
        return taskNum;
    }

    /**
     * 根据后台任务关联业务ID查询上传主图任务数
     *
     * @param relatedId
     * @param status
     * @return
     */
    public int findUploadCoverTaskByRelatedId(int relatedId, String status) {
        int taskNum = 0;
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setId(relatedId);
            baseQuery.setValue(status);
            taskNum = erpScheduleDao.findUploadCoverTaskByRelatedId(baseQuery);
        } catch (Exception ex) {
            log.error("findUploadCoverTaskByRelatedId 根据后台任务关联业务ID查询上传主图任务数方法 relatedId=" + relatedId + " status" + status + " error!", ex);
            throw new RuntimeException("findUploadCoverTaskByRelatedId 根据后台任务关联业务ID查询上传主图任务数方法 relatedId=" + relatedId + " status" + status + " error!", ex);
        }
        return taskNum;
    }

    /**
     * 根据应用ID查询主图地址
     * @param appid
     * @return
     */
    public String getAppLogoUrl(Integer appid){
        String  logoUrl = null;
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setId(appid);
            logoUrl = erpScheduleDao.getAppLogoUrl(baseQuery);
        } catch (Exception ex) {
            log.error("getAppLogoUrl 根据应用ID查询主图地址 appid=" + appid , ex);
            throw new RuntimeException("getAppLogoUrl 根据应用ID查询主图地址 appid=" + appid, ex);
        }
        return logoUrl;
    }
    /**
     * 更新应用详情日志表主图
     *
     * @param imgUrl
     */
    public void updateAppDetailsLogCover(final String imgUrl, final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    baseQuery.setValue(imgUrl);
                    baseQuery.setId(id);
                    erpScheduleDao.updateAppDetailsLogCover(baseQuery);
                } catch (Exception ex) {
                    log.error("updateAppDetailsLogCover 更新应用详情日志表主图方法 imgUrl=" + imgUrl + " id" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAppDetailsLogCover 更新应用详情日志表主图方法 imgUrl=" + imgUrl + " id" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 判断基本信息是否成功
     *
     * @param appId
     * @return
     */
    public AppLog baseSyncFlagIsSuccess(int appId) {
        AppLog appLog;
        try {
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setId(appId);
            appLog = erpScheduleDao.baseSyncFlagIsSuccess(baseQuery);
        } catch (Exception ex) {
            log.error("baseSyncFlagIsSuccess 更新应用详情日志表主图方法 appId=" + appId + " error!", ex);
            throw new RuntimeException("baseSyncFlagIsSuccess 更新应用详情日志表主图方法 appId=" + appId + " error!", ex);
        }
        return appLog;
    }

    public void setErpScheduleDao(ErpScheduleDao erpScheduleDao) {
        this.erpScheduleDao = erpScheduleDao;
    }
}
