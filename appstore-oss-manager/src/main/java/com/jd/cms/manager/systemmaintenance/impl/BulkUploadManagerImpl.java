package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.appManagement.AppManagementDao;
import com.jd.cms.dao.systemmaintenance.BulkUploadDao;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.cms.manager.contains.CommonContants;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.systemmaintenance.BulkUploadManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午6:01
 * To change this template use File | Settings | File Templates.
 */
public class BulkUploadManagerImpl extends BaseManager implements BulkUploadManager {
    private BulkUploadDao bulkUploadDao;
    private AppManagementDao appManagementDao;

    public AppManagementDao getAppManagementDao() {
        return appManagementDao;
    }

    public void setAppManagementDao(AppManagementDao appManagementDao) {
        this.appManagementDao = appManagementDao;
    }

    public BulkUploadDao getBulkUploadDao() {
        return bulkUploadDao;
    }

    public void setBulkUploadDao(BulkUploadDao bulkUploadDao) {
        this.bulkUploadDao = bulkUploadDao;
    }

    public List<CpBaseInfo> findCPBaseInfoList() {
        List<CpBaseInfo> cpBaseList = bulkUploadDao.findCPBaseInfoList();

        return cpBaseList;
    }

    public PaginatedList<CpBaseInfo> findCPList(int pageIndex, int pageSize, String cpName) {
        BaseQuery baseQuery = new BaseQuery();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        baseQuery.setValue(cpName);
        int totalItem = bulkUploadDao.getCPCount(baseQuery);
        PaginatedList<CpBaseInfo> cpBaseInfos = new PaginatedArrayList<CpBaseInfo>(pageIndex, pageSize);
        cpBaseInfos.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex - 1) * pageSize);
        baseQuery.setEndRow(pageSize);
        List<CpBaseInfo> cpBaseInfo = bulkUploadDao.findCPList(baseQuery);
        cpBaseInfos.addAll(cpBaseInfo);
        return cpBaseInfos;
    }


    public List<Category> findCategoryList(int categoryId) {
        List<Category> categoryList = null;
        try {
            categoryList = bulkUploadDao.findCategoryList(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Category> findWebCategoryList(int categoryId){
        List<Category> webCategoryList = null;
        try{
            webCategoryList = bulkUploadDao.findWebCategoryList(categoryId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return webCategoryList;
    }

    public int importWebToDataSource(final Content content){
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        Object result = transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try{
                    int appId = (int) sequenceUtil.get(SequenceConstants.APPS) + CommonContants.APPSTORE_APK_SKU_START_NUM;
                    content.setAppId(appId);
                    Apps apps = new Apps();
                    apps.setAppId(content.getAppId());
                    apps.setAppName(content.getAppName());
                    apps.setAppType(content.getAppType());
                    apps.setCategoryIdl2(content.getCategoryIdl2());
                    apps.setCategoryId1(content.getCategoryId1());
                    if (content.getCategoryId2() == 0) {
                        apps.setCategoryId2(null);
                    } else {
                        apps.setCategoryId2(content.getCategoryId2());
                    }
                    apps.setOnline(0);
                    bulkUploadDao.createApps(apps);
                    int appLogId = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                    AppLog appLog = new AppLog();
                    appLog.setId(appLogId);
                    appLog.setAppId(content.getAppId());
                    appLog.setAppName(content.getAppName());
                    appLog.setAppType(content.getAppType());
                    appLog.setCategoryIdl2(content.getCategoryIdl2());
                    appLog.setCategoryId1(content.getCategoryId1());
                    if (content.getCategoryId2() == 0) {
                        appLog.setCategoryId2(null);
                    } else {
                        appLog.setCategoryId2(content.getCategoryId2());
                    }
                    bulkUploadDao.insertAppLog(appLog);
                    AppDetailsLog appDetailsLog = new AppDetailsLog();
                    int appDetailsLogId = (int) sequenceUtil.get(SequenceConstants.APP_DETAIL_LOG);
                    appDetailsLog.setId(appDetailsLogId);
                    appDetailsLog.setAppId(content.getAppId());
                    appDetailsLog.setAccountId(content.getAccountId());
                    appDetailsLog.setLogoUrl(content.getNewLogoUrl());
                    appDetailsLog.setAppTag(content.getAppTag());
                    appDetailsLog.setAppIntroduce(content.getAppIntroduce());
                    bulkUploadDao.insertAppDetailsLog(appDetailsLog);
                    for (int i = 0; i < content.getAppResources().size(); i++) {
                        AppResource appResource = content.getAppResources().get(i);
                        int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                        appResource.setAppId(content.getAppId());
                        appResource.setResId(resId);
                        bulkUploadDao.insertAppResource(appResource);
                    }

                    BackendTask backendTaskBase = new BackendTask();
                    backendTaskBase.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskBase.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_BASEINFO));
                    backendTaskBase.setRelatedId(appLogId);
                    backendTaskBase.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskBase.setAdminId(content.getAdminId());
                    backendTaskBase.setIp(content.getIp());
                    backendTaskBase.setComment("同步商品基本信息");
                    backendTaskBase.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskBase.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppBaseErp(backendTaskBase);
                    /*创建应用上下架后台任务*/
                    BackendTask backendTaskOnline = new BackendTask();
                    backendTaskOnline.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskOnline.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPSTATUS));
                    backendTaskOnline.setRelatedId(appLogId);
                    backendTaskOnline.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskOnline.setAdminId(content.getAdminId());
                    backendTaskOnline.setIp(content.getIp());
                    Date onlineDate = addDate();
                    backendTaskOnline.setStartTimePlan(onlineDate);
                    backendTaskOnline.setStartTimeFact(onlineDate);
                    backendTaskOnline.setComment("同步应用上下架状态");
                    backendTaskOnline.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskOnline.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppOnlineErp(backendTaskOnline);

                    BackendTask backendTaskUploadCover = new BackendTask();
                    backendTaskUploadCover.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskUploadCover.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPLOADCOVER));
                    backendTaskUploadCover.setRelatedId(appDetailsLogId);
                    backendTaskUploadCover.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskUploadCover.setAdminId(content.getAdminId());
                    backendTaskUploadCover.setIp(content.getIp());
                    backendTaskUploadCover.setStartTimePlan(onlineDate);
                    backendTaskUploadCover.setStartTimeFact(onlineDate);
                    backendTaskUploadCover.setComment("上传主图");
                    backendTaskUploadCover.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskUploadCover.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppOnlineErp(backendTaskUploadCover);
                    /*创建详情金钱审核后台任务*/
                    BackendTask backendTaskPrice = new BackendTask();
                    /*自动生成id*/
                    backendTaskPrice.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    /*任务类型-同步应用价格*/
                    backendTaskPrice.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_PRICE));
                    /*关联业务id*/
                    backendTaskPrice.setRelatedId(appDetailsLogId);
                    /*任务状态待执行*/
                    backendTaskPrice.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    /*发起人*/
                    backendTaskPrice.setAdminId(content.getAdminId());
                    /*ip*/
                    backendTaskPrice.setIp(content.getIp());
                    /*系统备注*/
                    backendTaskPrice.setComment("同步价格");
                    /*启动时间推迟一分钟*/
                    Date priceDate = addDate();
                    /*计划启动时间*/
                    backendTaskPrice.setStartTimePlan(priceDate);
                    /*实际启动时间*/
                    backendTaskPrice.setStartTimeFact(priceDate);
                    /*重试剩余次数10*/
                    backendTaskPrice.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    /*是否需要自动重试-需要*/
                    backendTaskPrice.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    /*创建详情金钱审核后台任务*/
                    appManagementDao.createPriceErp(backendTaskPrice);
                    return 1;
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                    return -1;
                }
            }
        });
        return Integer.parseInt(result.toString());
    }

    public int importToDataSource(final Content content) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        Object result = transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    int appId = (int) sequenceUtil.get(SequenceConstants.APPS) + CommonContants.APPSTORE_APK_SKU_START_NUM;
                    content.setAppId(appId);
                    Apps apps = new Apps();
                    apps.setZhuoWangMark(0);
                    apps.setAppId(content.getAppId());
                    apps.setAppName(content.getAppName());
                    apps.setAppPackage(content.getAppPackage());
                    apps.setAppType(content.getAppType());
                    apps.setCategoryIdl2(content.getCategoryIdl2());
                    apps.setCategoryId1(content.getCategoryId1());
                    if (content.getCategoryId2() == 0) {
                        apps.setCategoryId2(null);
                    } else {
                        apps.setCategoryId2(content.getCategoryId2());
                    }
                    apps.setOnline(0);
                    bulkUploadDao.createApps(apps);
                    int appLogId = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                    AppLog appLog = new AppLog();
                    appLog.setId(appLogId);
                    appLog.setAppId(content.getAppId());
                    appLog.setAppName(content.getAppName());
                    appLog.setAppPackage(content.getAppPackage());
                    appLog.setAppType(content.getAppType());
                    appLog.setCategoryIdl2(content.getCategoryIdl2());
                    appLog.setCategoryId1(content.getCategoryId1());
                    if (content.getCategoryId2() == 0) {
                        appLog.setCategoryId2(null);
                    } else {
                        appLog.setCategoryId2(content.getCategoryId2());
                    }
                    bulkUploadDao.insertAppLog(appLog);
                    AppDetailsLog appDetailsLog = new AppDetailsLog();
                    int appDetailsLogId = (int) sequenceUtil.get(SequenceConstants.APP_DETAIL_LOG);
                    appDetailsLog.setId(appDetailsLogId);
                    appDetailsLog.setAppId(content.getAppId());
                    appDetailsLog.setAccountId(content.getAccountId());
                    appDetailsLog.setLogoUrl(content.getNewLogoUrl());
                    appDetailsLog.setAppVersion(content.getAppVersion());
                    appDetailsLog.setOsVersionId(bulkUploadDao.findOsVersionId(content.getOsVersionId()));
                    appDetailsLog.setAppVersioCode(content.getAppVersionCode());
                    appDetailsLog.setPkgSize(content.getPkgSize());
                    appDetailsLog.setAppTag(content.getAppTag());
                    appDetailsLog.setAppIntroduce(content.getAppIntroduce());
                    appDetailsLog.setZhuoWangMark(content.getZhuoWangMark());
                    appDetailsLog.setApkCode(content.getApkCode());
                    bulkUploadDao.insertAppDetailsLog(appDetailsLog);

                    for (int i = 0; i < content.getAppResources().size(); i++) {
                        AppResource appResource = content.getAppResources().get(i);
                        int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                        appResource.setAppId(content.getAppId());
                        appResource.setResId(resId);
                        appResource.setZhuoWangMark(0);
                        bulkUploadDao.insertAppResource(appResource);
                    }

                    BackendTask backendTaskBase = new BackendTask();
                    backendTaskBase.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskBase.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_BASEINFO));
                    backendTaskBase.setRelatedId(appLogId);
                    backendTaskBase.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskBase.setAdminId(content.getAdminId());
                    backendTaskBase.setIp(content.getIp());
                    backendTaskBase.setComment("同步商品基本信息");
                    backendTaskBase.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskBase.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppBaseErp(backendTaskBase);
                    /*创建应用上下架后台任务*/
                    BackendTask backendTaskOnline = new BackendTask();
                    backendTaskOnline.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskOnline.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPSTATUS));
                    backendTaskOnline.setRelatedId(appLogId);
                    backendTaskOnline.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskOnline.setAdminId(content.getAdminId());
                    backendTaskOnline.setIp(content.getIp());
                    Date onlineDate = addDate();
                    backendTaskOnline.setStartTimePlan(onlineDate);
                    backendTaskOnline.setStartTimeFact(onlineDate);
                    backendTaskOnline.setComment("同步应用上下架状态");
                    backendTaskOnline.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskOnline.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppOnlineErp(backendTaskOnline);

                /*    BackendTask backendTaskUploadCover = new BackendTask();
                    backendTaskUploadCover.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    backendTaskUploadCover.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPLOADCOVER));
                    backendTaskUploadCover.setRelatedId(appDetailsLogId);
                    backendTaskUploadCover.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    backendTaskUploadCover.setAdminId(content.getAdminId());
                    backendTaskUploadCover.setIp(content.getIp());
                    backendTaskUploadCover.setStartTimePlan(onlineDate);
                    backendTaskUploadCover.setStartTimeFact(onlineDate);
                    backendTaskUploadCover.setComment("上传主图");
                    backendTaskUploadCover.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    backendTaskUploadCover.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    appManagementDao.createAppOnlineErp(backendTaskUploadCover);*/
                    /*创建详情金钱审核后台任务*/
                    BackendTask backendTaskPrice = new BackendTask();
                    /*自动生成id*/
                    backendTaskPrice.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                    /*任务类型-同步应用价格*/
                    backendTaskPrice.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_PRICE));
                    /*关联业务id*/
                    backendTaskPrice.setRelatedId(appDetailsLogId);
                    /*任务状态待执行*/
                    backendTaskPrice.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                    /*发起人*/
                    backendTaskPrice.setAdminId(content.getAdminId());
                    /*ip*/
                    backendTaskPrice.setIp(content.getIp());
                    /*系统备注*/
                    backendTaskPrice.setComment("同步价格");
                    /*启动时间推迟一分钟*/
                    Date priceDate = addDate();
                    /*计划启动时间*/
                    backendTaskPrice.setStartTimePlan(priceDate);
                    /*实际启动时间*/
                    backendTaskPrice.setStartTimeFact(priceDate);
                    /*重试剩余次数10*/
                    backendTaskPrice.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                    /*是否需要自动重试-需要*/
                    backendTaskPrice.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                    /*创建详情金钱审核后台任务*/
                    appManagementDao.createPriceErp(backendTaskPrice);

                    return 1;
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                    return -1;
                }

            }
        });
        return Integer.parseInt(result.toString());
    }

    /**
     * 延迟一分钟
     */
    public Date addDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 1);
        date = calendar.getTime();
        return date;
    }

    public void createApps(Apps apps) {
        bulkUploadDao.createApps(apps);
    }

    public void insertAppLog(AppLog appLog) {
        bulkUploadDao.insertAppLog(appLog);
    }

    public void insertAppDetailsLog(AppDetailsLog appDetailsLog) {
        bulkUploadDao.insertAppDetailsLog(appDetailsLog);
    }

    public void insertAppResource(AppResource appResource) {
        bulkUploadDao.insertAppResource(appResource);
    }

    public int insertImportAppLog(final ImportAppLog importAppLog) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int importAppLogId = (int) sequenceUtil.get(SequenceConstants.CMS_IMPORTAPPLOG_SEQUENCE);
                    importAppLog.setId(importAppLogId);
                    bulkUploadDao.insertImportAppLog(importAppLog);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        return importAppLog.getId();
    }

    public int findAppsByPkg(String pkg) {
        int count = bulkUploadDao.findAppsByPkg(pkg);
        return count;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findOsVersionId(int id) {
        int versionId = bulkUploadDao.findOsVersionId(id);
        return versionId;
    }

    public void processImport(final ImportAppLog importAppLog) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    bulkUploadDao.processImport(importAppLog);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("processImport error!", e);
                }
            }
        });
    }

    public void completeImport(final ImportAppLog importAppLog) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    bulkUploadDao.completeImport(importAppLog);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("completeImport error!", e);
                }
            }
        });
    }

    public void deleteImportLog(ImportAppLog importAppLog) {
        bulkUploadDao.deleteImportLog(importAppLog);
    }

    public void uploadExcelLog(final ImportAppLog importAppLog){
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    bulkUploadDao.uploadExcelLog(importAppLog);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("uploadExcelLog error!", e);
                }
            }
        });
    }

    public int findSuperRoleId(String account) {
        return bulkUploadDao.findSuperRoleId(account);
    }

    public ImportAppLog loadUpload(String account) {
        ImportAppLog importLog = bulkUploadDao.loadUpload(account);
        return importLog;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateImport(int id){
        bulkUploadDao.updateImport(id);
    }

}

