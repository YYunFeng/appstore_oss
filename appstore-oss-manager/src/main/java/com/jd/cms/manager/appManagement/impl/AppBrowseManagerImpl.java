package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.cms.dao.appManagement.AppBrowseDao;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.cms.manager.appManagement.AppBrowseManager;
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
 * 应用浏览managerImpl
 */
public class AppBrowseManagerImpl extends BaseManager implements AppBrowseManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(AppBrowseManagerImpl.class);
    /**
     * 注入dao
     */
    private AppBrowseDao appBrowseDao;
    /**
     * 标记,用于外部使用
     */
    int mark;

    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findAppBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        AppPageInput newAppPageInPut = new AppPageInput();
        /*进行模糊查询处理*/
        if (StringUtils.isNotBlank(appPageInput.getCpName())) {
            /*CP用户名*/
            newAppPageInPut.setCpName("%" + appPageInput.getCpName() + "%");
        }
        if (StringUtils.isNotBlank(appPageInput.getAppName())) {
            /*应用名称*/
            newAppPageInPut.setAppName("%" + appPageInput.getAppName() + "%");
        }
        if (StringUtils.isNotBlank(appPageInput.getPackageName())) {
            /*应用包名*/
            newAppPageInPut.setPackageName("%" + appPageInput.getPackageName() + "%");
        }
        /*价格*/
        newAppPageInPut.setPrice(appPageInput.getPrice());
        /*newAppPageInPut.setUpdateStatus(appPageInput.getUpdateStatus());*/
        /*二级类目*/
        newAppPageInPut.setCategoryidl2(appPageInput.getCategoryidl2());
        /*Category3用于筛选三级类目，-1代表全部*/
        newAppPageInPut.setCategory3(appPageInput.getCategory3());
        /*NullPrice用于筛选价格，0代表全部*/
        newAppPageInPut.setNullPrice(appPageInput.getNullPrice());
        /*首次页数置一*/
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        /*取得应用浏览的总记录数*/
        int totalItem = appBrowseDao.getAppBrowseCount(newAppPageInPut);
        /*分页用List*/
        PaginatedList<AppPageOutput> appList = new PaginatedArrayList<AppPageOutput>(pageIndex, pageSize);
        /*总条数*/
        appList.setTotalItem(totalItem);
        /*分页条件*/
        newAppPageInPut.setStartRow((pageIndex - 1) * pageSize);
        newAppPageInPut.setEndRow(pageSize);
        /*取得移动游戏,软件的信息集合*/
        List<AppPageOutput> appPageOutPutsList = appBrowseDao.findAppBrowsePage(newAppPageInPut);
        /*存入List*/
        appList.addAll(appPageOutPutsList);
        return appList;
    }

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findAppWebBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        AppPageInput newAppPageInPut = new AppPageInput();
        /*进行模糊查询处理*/
        if (StringUtils.isNotBlank(appPageInput.getCpName())) {
            /*CP用户名*/
            newAppPageInPut.setCpName("%" + appPageInput.getCpName() + "%");
        }
        if (StringUtils.isNotBlank(appPageInput.getAppName())) {
            /*应用名称*/
            newAppPageInPut.setAppName("%" + appPageInput.getAppName() + "%");
        }
        /*newAppPageInPut.setUpdateStatus(appPageInput.getUpdateStatus());*/
        /*二级类目*/
        newAppPageInPut.setCategoryidl2(appPageInput.getCategoryidl2());
        /*Category3用于筛选三级类目，-1代表全部*/
        newAppPageInPut.setCategory3(appPageInput.getCategory3());
        /*应用类型*/
        newAppPageInPut.setAppType(appPageInput.getAppType());
        /*首次页数置一*/
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        /*取得应用浏览的总记录数*/
        int totalItem = appBrowseDao.getAppWebBrowseCount(newAppPageInPut);
        /*分页用List*/
        PaginatedList<AppPageOutput> appList = new PaginatedArrayList<AppPageOutput>(pageIndex, pageSize);
        /*总条数*/
        appList.setTotalItem(totalItem);
        /*分页条件*/
        newAppPageInPut.setStartRow((pageIndex - 1) * pageSize);
        newAppPageInPut.setEndRow(pageSize);
        /*取得网页软件的信息集合*/
        List<AppPageOutput> appPageOutPutsList = appBrowseDao.findAppWebBrowsePage(newAppPageInPut);
        /*保存List*/
        appList.addAll(appPageOutPutsList);
        return appList;
    }

    /**
     * 批量上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnline(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*接收Id集合*/
                    String idList = appPageInput.getIdList();
                    /*将String转换成集合*/
                    String[] aid = idList.split(",");
                    /*初始标记，默认都可以开启*/
                    mark = 0;
                    /*循环Id进行操作*/
                    for (int i = 0; i < aid.length; i++) {
                        boolean needed = false;
                        Integer currentOnline = appBrowseDao.getCurrentStatus(Integer.parseInt(aid[i]));
                        if (1 == appPageInput.getOnline() && currentOnline != 1) {
                            needed = true;
                        } else if (2 == appPageInput.getOnline() && currentOnline == 1) {
                            needed = true;
                        }
                        if (needed) {
                            /*应用日志读erp信息*/
                            AppPageOutput AppOnline = appBrowseDao.findAppSynchronismStatus(Integer.parseInt(aid[i]));
                            /*getBaseSyncFlag为1，说明基本信息正在同步过程中*/
                            if (1 == AppOnline.getBaseSyncFlag()) {
                                /*已经开启基本信息审核，不能再操作*/
                                mark = 1;
                                /*getOnlineSyncFlag，正在同步上下架*/
                            } else if (1 == AppOnline.getOnlineSyncFlag()) {
                                /*已经开启上下架，不能再操作*/
                                mark = 1;
                            } else {
                                /*通过ID查找对应的应用*/
                                AppPageInput app = appBrowseDao.findAppByAppid(Integer.parseInt(aid[i]));
                                /*生成id字段*/
                                int id = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                                app.setId(id);
                                /*审核通过*/
                                app.setBaseCheckStatus(3);
                                /*不需要同步基本信息*/
                                app.setBaseSyncFlag(0);
                                /*需要同步上下架*/
                                app.setOnlineSyncFlag(1);
                                if (1 == appPageInput.getOnline()) {
                                    /*需要做上架*/
                                    app.setOnlineOptType(1);
                                } else if (2 == appPageInput.getOnline()) {
                                    /*需要做下架*/
                                    app.setOnlineOptType(0);
                                }
                                /*最新标记*/
                                app.setNewstFlag(1);
                                /*更新他们老应用为不是最新*/
                                appBrowseDao.upAppNewstFlag(Integer.parseInt(aid[i]));
                                /*创建app日志*/
                                appBrowseDao.createAppLog(app);
                                /*创建应用上下架后台任务*/
                                BackendTask backendTaskOnline = new BackendTask();
                                backendTaskOnline.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                                backendTaskOnline.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPSTATUS));
                                backendTaskOnline.setRelatedId(id);
                                backendTaskOnline.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                                backendTaskOnline.setAdminId(appPageInput.getAdminId());
                                backendTaskOnline.setIp(appPageInput.getIp());
                                backendTaskOnline.setStartTimePlan(addDate());
                                backendTaskOnline.setStartTimeFact(addDate());
                                backendTaskOnline.setComment("同步应用上下架状态");
                                backendTaskOnline.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                                backendTaskOnline.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                                appBrowseDao.createAppOnlineErp(backendTaskOnline);
                            }
                        } else {
                            mark = 3;
                        }

                    }//for
                } catch (Exception e) {
                    log.error("批量上下架操作 appPageInput" + appPageInput + " error!", e);
                    status.setRollbackOnly();
                }
            }
        });
        /*返回标记用于页面提示信息*/
        return mark;
    }

    /**
     * 单个上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnlineById(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*初始标记，默认都可以开启*/
                    mark = 0;
                    boolean needed = false;
                    Integer currentOnline = appBrowseDao.getCurrentStatus(appPageInput.getAppid());
                    if (1 == appPageInput.getOnline() && currentOnline != 1) {
                        needed = true;
                    } else if (2 == appPageInput.getOnline() && currentOnline == 1) {
                        needed = true;
                    }
                    if (needed) {
                        /*应用日志读erp信息*/
                        AppPageOutput AppOnline = appBrowseDao.findAppSynchronismStatus(appPageInput.getAppid());
                        /*getBaseSyncFlag为1，正在同步基本信息*/
                        if (1 == AppOnline.getBaseSyncFlag()) {
                            /*已经开启基本信息审核，不能再操作*/
                            mark = 1;
                            /*getOnlineSyncFlag，正在同步上下架*/
                        } else if (1 == AppOnline.getOnlineSyncFlag()) {
                            /*已经开启上下架，不能再操作*/
                            mark = 2;
                        } else {
                            /*可以开启erp*/
                            mark = 0;
                            /*通过ID查找对应的应用*/
                            AppPageInput app = appBrowseDao.findAppByAppid(appPageInput.getAppid());
                            /*生成id字段*/
                            int id = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                            app.setId(id);
                            /*审核通过*/
                            app.setBaseCheckStatus(3);
                            /*不需要同步基本信息*/
                            app.setBaseSyncFlag(0);
                            /*需要同步上下架*/
                            app.setOnlineSyncFlag(1);
                            if (1 == appPageInput.getOnline()) {
                                /*需要做上架*/
                                app.setOnlineOptType(1);
                            } else if (2 == appPageInput.getOnline()) {
                                /*需要做下架*/
                                app.setOnlineOptType(0);
                            }
                            /*最新标记*/
                            app.setNewstFlag(1);
                            /*更新他们老应用为不是最新*/
                            appBrowseDao.upAppNewstFlag(appPageInput.getAppid());
                            /*创建app日志*/
                            appBrowseDao.createAppLog(app);
                            /*创建应用上下架后台任务*/
                            BackendTask backendTaskOnline = new BackendTask();
                            backendTaskOnline.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                            backendTaskOnline.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_UPSTATUS));
                            backendTaskOnline.setRelatedId(id);
                            backendTaskOnline.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                            backendTaskOnline.setAdminId(appPageInput.getAdminId());
                            backendTaskOnline.setIp(appPageInput.getIp());
                            backendTaskOnline.setStartTimePlan(addDate());
                            backendTaskOnline.setStartTimeFact(addDate());
                            backendTaskOnline.setComment("同步应用上下架状态");
                            backendTaskOnline.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                            backendTaskOnline.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                            appBrowseDao.createAppOnlineErp(backendTaskOnline);
                        }
                    } else {
                        mark = 3;
                    }

                } catch (Exception e) {
                    log.error("单个上下架操作 appPageInput=" + appPageInput + "error!", e);
                    status.setRollbackOnly();
                }
            }
        });
        /*返回标记用于页面提示信息*/
        return mark;
    }

    public List<CpBaseInfo> getCpList() {
        return appBrowseDao.getCpList();
    }

    public void chageCp(final ChangeCpInput changeCpInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    appBrowseDao.updateAppDetails(changeCpInput);
                    appBrowseDao.updateAppDetailsLog(changeCpInput);
                    appBrowseDao.updateAppResource(changeCpInput);
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });
    }

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormal(AppPageInput appPageInput) {
        return appBrowseDao.findAppDetailsFormal(appPageInput);
    }

    /**
     * 取得一对多详情的CpName集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> getCpNameCount(AppPageInput appPageInput) {
        return appBrowseDao.getCpNameCount(appPageInput.getAppid());
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return appBrowseDao.findPicture(appPageInput);
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return appBrowseDao.findCategory(parentId);
    }

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDetailsOnline(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    appBrowseDao.upAppDetailsOnline(appPageInput);
                } catch (Exception e) {
                    log.error("详情上下架修改 appPageInput=" + appPageInput + " error!");
                    status.setRollbackOnly();
                    throw new RuntimeException("upAppDetailsOnline error!", e);
                }
            }
        });
        return 1;
    }

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalByCp(AppPageInput appPageInput) {
        return appBrowseDao.findAppDetailsFormalByCp(appPageInput);
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return appBrowseDao.findOsVersion(osVersionId);
    }

    /**
     * 查找下载次数
     *
     * @param appid
     * @return Integer
     */
    public Integer findAppDownloadCount(int appid) {
        return appBrowseDao.findAppDownloadCount(appid);
    }

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDefaultDetaild(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    appBrowseDao.upAppDefaultDetaild(appPageInput);
                } catch (Exception e) {
                    log.error("更改默认详情 appPageInput" + appPageInput + "error!", e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upAppDefaultDetaild error!", e);
                }
            }
        });
        return 1;
    }

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEdit(AppPageInput appPageInput) {
        return appBrowseDao.findAppDetailsFormalEdit(appPageInput);
    }

    /**
     * 编辑-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEditByCp(AppPageInput appPageInput) {
        return appBrowseDao.findAppDetailsFormalEditByCp(appPageInput);
    }

    /**
     * 保存应用和详情
     *
     * @param appPageInput
     * @return int
     */
    public int saveAppAndDetailInformation(final AppPageInput appPageInput) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*应用日志读erp信息*/
                    AppPageOutput AppOnline = appBrowseDao.findAppSynchronismStatus(appPageInput.getAppid());
                    /*getBaseSyncFlag为1，正在同步基本信息*/
                    if (1 == AppOnline.getBaseSyncFlag()) {
                        /*已经开启基本信息审核，不能再操作*/
                        mark = 1;
                        /*getOnlineSyncFlag，正在同步上下架*/
                    } else if (1 == AppOnline.getOnlineSyncFlag()) {
                        /*已经开启上下架，不能再操作*/
                        mark = 2;
                    } else {
                        /*可以保存*/
                        mark = 0;
                        /*如果基本信息为待审核，页面给的值不是数据库里的*/
                        if (2 == appPageInput.getBaseCheckStatus()) {
                            /*通过ID查找对应的应用*/
                            AppPageInput app = appBrowseDao.findAppByAppid(appPageInput.getAppid());
                            /*自动生成id*/
                            int id = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                            /*id*/
                            app.setId(id);
                            /*应用名称*/
                            app.setAppName(appPageInput.getAppName());

                            /*应用类型*/
                            app.setAppType(appPageInput.getAppType());
                            /*二级类目*/
                            app.setCategoryidl2(appPageInput.getCategoryidl2());
                            /*三级类目1*/
                            app.setCategoryid1(appPageInput.getCategoryid1());
                            /*三级类目2*/
                            app.setCategoryid2(appPageInput.getCategoryid2());
                            /*审核通过*/
                            app.setBaseCheckStatus(3);
                            /*基本信息同步ERP标记为需要*/
                            app.setBaseSyncFlag(1);
                            /*上下架同步ERP标记为不需要*/
                            app.setOnlineSyncFlag(0);
                            /*上下架操作类型为不操作*/
                            app.setOnlineOptType(2);
                            /*最新标记*/
                            app.setNewstFlag(1);
                            /*把原有日志表修改最新标记字段置为0*/
                            appBrowseDao.upAppNewstFlag(appPageInput.getAppid());
                            /*创建新的应用日志信息*/
                            appBrowseDao.createAppLog(app);
                            /*创建应用基本信息审核后台任务*/
                            BackendTask backendTaskBase = new BackendTask();
                            backendTaskBase.setId((int) sequenceUtil.get(SequenceConstants.CMS_BACKEND_TASK_SEQUENCE));
                            backendTaskBase.setTaskTypeId(Integer.parseInt(TaskTypeConstants.CMS_TASKTYPE_BASEINFO));
                            backendTaskBase.setRelatedId(id);
                            backendTaskBase.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);
                            backendTaskBase.setAdminId(appPageInput.getAdminId());
                            backendTaskBase.setIp(appPageInput.getIp());
                            backendTaskBase.setComment("同步商品基本信息");
                            backendTaskBase.setRetryTimes(TaskTypeConstants.CMS_TASK_RETRYTIMES);
                            backendTaskBase.setAutoRetry(TaskTypeConstants.CMS_TASK_AUTORETRY);
                            appBrowseDao.createAppBaseErp(backendTaskBase);
                        }
                    }
                    /*更新应用类型*/
                    appBrowseDao.upAppType(appPageInput);
                    /*保存详情*/
                    appBrowseDao.saveDetailInformation(appPageInput);
                } catch (Exception e) {
                    log.error("保存应用和详情 appPageInput" + appPageInput + " error!");
                    status.setRollbackOnly();
                }
            }
        });
        /*返回标记用于页面提示信息*/
        return mark;
    }

    /**
     * 创建系统时间
     */
    public Date addDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 0);
        date = calendar.getTime();
        return date;
    }

    public AppBrowseDao getAppBrowseDao() {
        return appBrowseDao;
    }

    public void setAppBrowseDao(AppBrowseDao appBrowseDao) {
        this.appBrowseDao = appBrowseDao;
    }
}
