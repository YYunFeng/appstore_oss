package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.cms.dao.appManagement.AppManagementDao;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.SalerRankingRes;
import com.jd.cms.manager.appManagement.AppManagementManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用managerImpl
 */
public class AppManagementManagerImpl extends BaseManager implements AppManagementManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(AppManagementManagerImpl.class);
    /**
     * Dao注入
     */
    private AppManagementDao appManagementDao;

    /**
     * 获取所有/部分应用基本信息以及主图
     *
     * @param appPageInput
     * @return List
     */
    public List<Apps> getAppBaseInfo(AppPageInput appPageInput) {
        List<Apps> results;
        results = appManagementDao.getAppBaseInfo(appPageInput);
        return results;
    }



    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findDetailsPage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        AppPageInput newAppPageInPut = new AppPageInput();
        /*进行模糊查询处理*/
        /*CP用户名*/
        if (StringUtils.isNotBlank(appPageInput.getCpName())) {
            newAppPageInPut.setCpName("%" + appPageInput.getCpName() + "%");
        }
        /*应用名称*/
        if (StringUtils.isNotBlank(appPageInput.getAppName())) {
            newAppPageInPut.setAppName("%" + appPageInput.getAppName() + "%");
        }
        /*应用包名*/
        if (StringUtils.isNotBlank(appPageInput.getPackageName())) {
            newAppPageInPut.setPackageName("%" + appPageInput.getPackageName() + "%");
        }
        /*价格条件*/
        newAppPageInPut.setPrice(appPageInput.getPrice());
        /*详情审核状态条件*/
        newAppPageInPut.setUpdateStatus(appPageInput.getUpdateStatus());
        /*应用类型条件*/
        newAppPageInPut.setType(appPageInput.getType());
        /*筛选收费和免费的条件*/
        newAppPageInPut.setNullPrice(appPageInput.getNullPrice());
        /*资源类型条件*/
        newAppPageInPut.setResTypeList(appPageInput.getResTypeList());
        /*首次页数置一*/
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        /*取得审核应用的总记录数*/
        int totalItem = appManagementDao.getDetailsCount(newAppPageInPut);
        PaginatedList<AppPageOutput> appList = new PaginatedArrayList<AppPageOutput>(pageIndex, pageSize);
        appList.setTotalItem(totalItem);
        /*分页条件*/
        newAppPageInPut.setStartRow((pageIndex - 1) * pageSize);
        newAppPageInPut.setEndRow(pageSize);
        /*取得审核应用的信息集合*/
        List<AppPageOutput> appPageOutPutsList = appManagementDao.findDetailsPage(newAppPageInPut);
        appList.addAll(appPageOutPutsList);
        return appList;
    }

    /**
     * 取得详情对应应用的基本信息审核状态(详情Id)
     *
     * @param did
     * @return int
     */
    public int findAppStatus(int did) {
        return appManagementDao.findAppStatus(did);
    }

    /**
     * 查找单个详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetails(AppPageInput appPageInput) {
        /*根据Id查找单个详情*/
        AppPageOutput appPageOutput = appManagementDao.findAppDetails(appPageInput.getDid());
        /*查看正式表是否有记录*/
        Integer price = appManagementDao.findPrice(appPageInput);
        /*price为null说明是新发详情*/
        if (null == price) {
            /*查询应用审核状态*/
            int appNature = appManagementDao.findAppNature(appPageInput.getAppid());
            /*待审核和审核不通过*/
            if (2 == appNature || 4 == appNature) {
                /*是新发应用*/
                appPageOutput.setNature(1);
                /*审核通过*/
            } else {
                /*是新发详情*/
                appPageOutput.setNature(2);
            }
            /*price不为null说明不是新发详情*/
        } else {
            /*是更新详情*/
            appPageOutput.setNature(3);
        }
        return appPageOutput;
    }

    /**
     * 审核不通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateStatusOff(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*如果应用基本信息日志是待审核状态（即：不是单独审核详情）*/
                    if (2 == appPageInput.getBaseCheckStatus()) {
                        /*应用置为不通过*/
                        appManagementDao.updateAppStatusOff(appPageInput);
                    }
                    /*详情置为不通过*/
                    appManagementDao.updateDetailStatusOff(appPageInput);
                } catch (Exception e) {
                    log.error("审核不通过异常 appPageInput" + appPageInput + " error!", e);
                    status.setRollbackOnly();
                    throw new RuntimeException("updateStatusOff error!", e);
                }
            }
        });
        return 1;
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return appManagementDao.findCategory(parentId);
    }

    /**
     * 审核通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateStatusOn(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*如果应用基本信息日志是待审核状态和不通过状态*/
                    if (2 == appPageInput.getBaseCheckStatus() || 4 == appPageInput.getBaseCheckStatus()) {
                        /*更新基本信息日志，置为通过，开启基本信息，上下架erp*/
                        appManagementDao.updateAppStatusOn(appPageInput);

                        /*创建应用基本信息后台任务*/
                        BackendTask backendTaskBase = new BackendTask();
                        /*生成id字段*/
                        backendTaskBase.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                        /*任务类型-同步应用基本信息*/
                        backendTaskBase.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_BASEINFO));
                        /*关联业务id*/
                        backendTaskBase.setRelatedId(appPageInput.getAid());
                        /*任务状态待执行*/
                        backendTaskBase.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                        /*发起人*/
                        backendTaskBase.setAdminId(appPageInput.getAdminId());
                        /*IP*/
                        backendTaskBase.setIp(appPageInput.getIp());
                        /*系统备注*/
                        backendTaskBase.setComment("同步商品基本信息");
                        /*重试剩余次数10*/
                        backendTaskBase.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                        /*是否需要自动重试-需要*/
                        backendTaskBase.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                        /*创建应用基本信息后台任务*/
                        appManagementDao.createAppBaseErp(backendTaskBase);


                        /*创建应用上下架后台任务*/
                        BackendTask backendTaskOnline = new BackendTask();
                        /*生成id字段*/
                        backendTaskOnline.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                        /*任务类型-同步上下架状态*/
                        backendTaskOnline.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPSTATUS));
                        /*关联业务id*/
                        backendTaskOnline.setRelatedId(appPageInput.getAid());
                        /*任务状态待执行*/
                        backendTaskOnline.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                        /*发起人*/
                        backendTaskOnline.setAdminId(appPageInput.getAdminId());
                        /*IP*/
                        backendTaskOnline.setIp(appPageInput.getIp());
                        /*启动时间推迟一分钟*/
                        Date onlineDate = addDate();
                        /*计划启动时间*/
                        backendTaskOnline.setStartTimePlan(onlineDate);
                        /*实际启动时间*/
                        backendTaskOnline.setStartTimeFact(onlineDate);
                        /*系统备注*/
                        backendTaskOnline.setComment("同步应用上下架状态");
                        /*重试剩余次数10*/
                        backendTaskOnline.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                        /*是否需要自动重试-需要*/
                        backendTaskOnline.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                        /*创建应用上下架后台任务*/
                        appManagementDao.createAppOnlineErp(backendTaskOnline);
                    }


                    /*查看详情正式表是否有记录*/
                    Integer detailLogCount = appManagementDao.findDetailLogCount(appPageInput.getAppid());

                    Integer price = appManagementDao.findPrice(appPageInput);
                    int p = -1;
                    /*price有记录说明不是新发*/
                    if (null != price) {
                        /*将基本表的price给到p*/
                        p = price;
                    }
                    /*新发免费*/
                    if (detailLogCount <= 1 && 0 == appPageInput.getPrice()) {
                        /*在详情日志表中查询已经有此应用的详情数*/
                        Integer detailsCount = appManagementDao.findDetailsCount(appPageInput.getAppid());
                        /*如果有详情就不是此应用的第一个详情*/
                        if (0 != detailsCount) {
                            /*审核通过*/
                            appPageInput.setUpdateStatus(0);
                            /*不开启价格同步erp*/
                            appPageInput.setPriceSyncFlag(0);
                            /*置为审核通过，更新字段,不开启价格同步erp*/
                            appManagementDao.updateDetailOnFree1(appPageInput);
                            /*将资源更新为正式资源 added by Zheng*/
                            appManagementDao.updateAppResourceIsCopy(appPageInput);

                            /*查询详情日志信息*/
                            AppPageInput copyAppDetail = appManagementDao.copyAppDetailLog(appPageInput.getDid());
                            /*生成id字段*/
                            int id = (int) sequenceUtil.get(SequenceConstants.APP_DETAILS);
                            copyAppDetail.setId(id);

                            //  加上卓望标示
                            copyAppDetail.setZhuoWangMark(0);
                            /*创建详情基本表信息*/
                            appManagementDao.createAppDetail(copyAppDetail);
                            /*存入id*/
                            appPageInput.setId(id);
                            /*日志表新数据置为有效*/
                            appManagementDao.updateDetailOnFisrtFreeValid(appPageInput);

                            /*如果没有详情就是此应用的第一个详情*/
                        } else { //该应用第一个详情
                            /*审核中*/
                            appPageInput.setUpdateStatus(3);
                            /*开启价格同步erp*/
                            appPageInput.setPriceSyncFlag(1);
                            /*置为审核通过同步中，更新字段，开启价格同步erp*/
                            appManagementDao.updateDetailOnFree1(appPageInput);

                            /*创建价格同步后台任务*/
                            BackendTask backendTaskPrice = new BackendTask();
                            /*自动生成id*/
                            backendTaskPrice.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                            /*任务类型-同步应用价格*/
                            backendTaskPrice.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_PRICE));
                            /*关联业务id*/
                            backendTaskPrice.setRelatedId(appPageInput.getDid());
                            /*任务状态待执行*/
                            backendTaskPrice.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                            /*发起人*/
                            backendTaskPrice.setAdminId(appPageInput.getAdminId());
                            /*ip*/
                            backendTaskPrice.setIp(appPageInput.getIp());
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
                            /*创建价格同步后台任务*/
                            appManagementDao.createPriceErp(backendTaskPrice);
                        }

                    } else if (detailLogCount <= 1 && 0 != appPageInput.getPrice()) {     /*新发收费*/
                        /*置为审核通过同步中，开启价格同步erp，更新字段*/
                        appManagementDao.updateDetailOnPrice(appPageInput);

                        /*创建价格同步后台任务*/
                        BackendTask backendTaskPrice = new BackendTask();
                        backendTaskPrice.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                        backendTaskPrice.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_PRICE));
                        backendTaskPrice.setRelatedId(appPageInput.getDid());
                        backendTaskPrice.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                        backendTaskPrice.setAdminId(appPageInput.getAdminId());
                        backendTaskPrice.setIp(appPageInput.getIp());
                        backendTaskPrice.setComment("同步价格");
                        Date priceDate = addDate();
                        backendTaskPrice.setStartTimePlan(priceDate);
                        backendTaskPrice.setStartTimeFact(priceDate);
                        backendTaskPrice.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                        backendTaskPrice.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                        appManagementDao.createPriceErp(backendTaskPrice);

                    } else if (detailLogCount > 1 && appPageInput.getPrice() != p) { /*不是新发,并且价格有变化，要开启价格erp的更新*/
                        /*更新应用类型*/
                        appManagementDao.upAppType(appPageInput);

                        /*置为审核通过同步中，开启价格同步erp，更新字段*/
                        appManagementDao.updateDetailOnPrice(appPageInput);

                        if (null != price) //详情表已经有本人发的详情
                        {
                            Integer copyCount = appManagementDao.findResourceCopyCount(appPageInput);
                            if (copyCount > 0) {
                                /*删除旧资源*/
                                appManagementDao.delAppResourceOld(appPageInput);
                            }
                        }

                        /*将资源更新为正式资源*/
                        appManagementDao.updateAppResourceIsCopy(appPageInput);
                        /*创建价格同步后台任务*/
                        BackendTask backendTaskPrice = new BackendTask();
                        backendTaskPrice.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                        backendTaskPrice.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_PRICE));
                        backendTaskPrice.setRelatedId(appPageInput.getDid());
                        backendTaskPrice.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                        backendTaskPrice.setAdminId(appPageInput.getAdminId());
                        backendTaskPrice.setIp(appPageInput.getIp());
                        backendTaskPrice.setComment("同步价格");
                        Date priceDate = addDate();
                        backendTaskPrice.setStartTimePlan(priceDate);
                        backendTaskPrice.setStartTimeFact(priceDate);
                        backendTaskPrice.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                        backendTaskPrice.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                        appManagementDao.createPriceErp(backendTaskPrice);

                    } else if (detailLogCount > 1 && appPageInput.getPrice() == p && 0 != appPageInput.getPrice()) {     /*不是新发,并且价格无变化，收费，不用开启价格erp*/
                        /*更新应用类型*/
                        appManagementDao.upAppType(appPageInput);
                        /*日志表，置为审核通过，上架，更新字段*/
                        appManagementDao.updateDetailOnTimesPrice1(appPageInput);

                        /*基本表，置为审核通过，上架，更新字段*/
                        appManagementDao.updateDetailOnTimesPrice2(appPageInput);
                        if (null != price) //详情表已经有本人发的详情
                        {
                            Integer copyCount = appManagementDao.findResourceCopyCount(appPageInput);
                            if (copyCount > 0) {
                                /*删除旧资源*/
                                appManagementDao.delAppResourceOld(appPageInput);
                            }
                        }
                        /*将资源更新为正式资源*/
                        appManagementDao.updateAppResourceIsCopy(appPageInput);

                        /*将日志表老数据更新为无效*/
                        appManagementDao.updateDetailOnFisrtFreeValid2(appPageInput);
                        /*日志表新数据置为有效*/
                        appManagementDao.updateDetailOnFisrtFreeValid(appPageInput);

                    } else if (detailLogCount > 1 && appPageInput.getPrice() == p && 0 == appPageInput.getPrice()) {   /*不是新发,并且价格无变化，免费，不用开启价格erp*/
                        /*更新应用类型*/
                        appManagementDao.upAppType(appPageInput);
                        /*日志表，置为审核通过，上架，更新字段*/
                        appManagementDao.updateDetailOnFree3(appPageInput);
                        /*基本表，置为审核通过，上架，更新字段*/
                        appManagementDao.updateDetailOnFree2(appPageInput);

                        if (null != price) //详情表已经有本人发的详情
                        {
                            Integer copyCount = appManagementDao.findResourceCopyCount(appPageInput);
                            if (copyCount > 0) {
                                /*删除旧资源*/
                                appManagementDao.delAppResourceOld(appPageInput);
                            }
                        }
                        /*将资源更新为正式资源*/
                        appManagementDao.updateAppResourceIsCopy(appPageInput);
                        /*将日志表老数据更新为无效*/
                        appManagementDao.updateDetailOnFisrtFreeValid2(appPageInput);
                        /*日志表新数据置为有效*/
                        appManagementDao.updateDetailOnFisrtFreeValid(appPageInput);
                    }
                } catch (Exception e) {
                    log.error("审核通过时异常 appPageInput" + appPageInput + " error!", e);
                    status.setRollbackOnly();
                }
            }
        });
        return 1;
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return appManagementDao.findPicture(appPageInput);
    }

    /**
     * 查找cp默认分成比例
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findDefaultPercent(AppPageInput appPageInput) {
        return appManagementDao.findDefaultPercent(appPageInput.getAccountid());
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return appManagementDao.findOsVersion(osVersionId);
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

    public AppManagementDao getAppManagementDao() {
        return appManagementDao;
    }

    public void setAppManagementDao(AppManagementDao appManagementDao) {
        this.appManagementDao = appManagementDao;
    }
}
