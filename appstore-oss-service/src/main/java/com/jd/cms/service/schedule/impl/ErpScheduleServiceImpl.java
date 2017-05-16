package com.jd.cms.service.schedule.impl;

import com.jd.appstore.domain.AppDetails;
import com.jd.appstore.domain.AppDetailsLog;
import com.jd.appstore.domain.AppLog;
import com.jd.appstore.domain.Apps;
import com.jd.cms.domain.taskmanager.TaskInfoQuery;
import com.jd.cms.domain.taskmanager.TaskInfoResult;
import com.jd.cms.manager.contains.TaskTypeConstants;
import com.jd.cms.manager.schedule.ErpScheduleManager;
import com.jd.cms.service.schedule.ErpScheduleService;
import com.jd.digital.common.rpc.domain.bean.img.CoverBean;
import com.jd.digital.common.rpc.domain.bean.img.CoverResult;
import com.jd.digital.common.rpc.domain.bean.sync.appstore.AppStoreSyncBasicInfoDO;
import com.jd.digital.common.rpc.manager.img.ImageManager;
import com.jd.digital.common.rpc.manager.sync.basicinfo.appstore.AppStoreBasicInfoSyncManager;
import com.jd.digital.common.rpc.manager.sync.price.UpdatePriceSyncManager;
import com.jd.digital.common.rpc.manager.sync.upStatus.appstore.AppStoreUpStatusSyncManager;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Random;


/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-28
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public class ErpScheduleServiceImpl implements ErpScheduleService {
    private static final Logger log = Logger.getLogger(ErpScheduleServiceImpl.class);
    /**
     * 随机数
     */
    private final Random RANDOM = new Random();
    /**
     * 应用商店基本信息同步erp
     */
    private AppStoreBasicInfoSyncManager appStoreBasicInfoSyncManager;
    /**
     * 上下架状态同步
     */
    private AppStoreUpStatusSyncManager appStoreUpStatusSyncManager;
    /**
     * 修改价格
     */
    private UpdatePriceSyncManager updatePriceSyncManager;
    /**
     * ERP同步任务Manager
     */
    private ErpScheduleManager erpScheduleManager;
    /**
     * 图片上传接口
     */
    private ImageManager imageManager;
    /**
     * 截图服务器HOST
     */
    private String imageserver;
    /**
     * 上传图片本地路径
     */
    private String uploadImagePath;

    /**
     * 同步应用基本信息
     *
     * @param taskInfoResult
     */
    public void appStoreBasicInfoSyncScheduler(TaskInfoResult taskInfoResult) {
        Date startTimeFact = new Date();
        try {
            if (null != taskInfoResult) {
                /*根据任务关联ID查询应用基本信息日志表*/
                AppLog appLog = erpScheduleManager.findAppLog(taskInfoResult.getRelatedId());
                log.info("oss同步erp基本信息。appLog=" + appLog);
                /*判断应用基本信息日志中是否存在记录,同步基本信息是否开起,审核状态是否审核中*/
                if (null != appLog && 1 == appLog.getBaseSyncFlag() && 3 == appLog.getBaseCheckStatus()) {
                    //实例化应用商店同步基本信息对像
                    AppStoreSyncBasicInfoDO appStoreSyncBasicInfoDO = new AppStoreSyncBasicInfoDO();
                    //设置应用ID
                    appStoreSyncBasicInfoDO.setId(appLog.getAppId());
                    //设置应用名称
                    appStoreSyncBasicInfoDO.setName(appLog.getAppName());
                    //设置三级类目1
                    appStoreSyncBasicInfoDO.setThirdCategory1(appLog.getCategoryId1());
                    //设置操作人名称
                    appStoreSyncBasicInfoDO.setOpName(taskInfoResult.getAdminId());
                    //设置IP
                    appStoreSyncBasicInfoDO.setIp(taskInfoResult.getIp());

                    //判断三级类目2是否存在
                    if (null != appLog.getCategoryId2()) {
                        //设置三级类目2
                        appStoreSyncBasicInfoDO.setThirdCategory2(appLog.getCategoryId2());
                    }
                    //实例化应用基本信息对像
                    Apps apps = new Apps();
                    //设置应用ID
                    apps.setAppId(appLog.getAppId());
                    //设置应用名称
                    apps.setAppName(appLog.getAppName());
                    //设置package名
                    apps.setAppPackage(appLog.getAppPackage());
                    //设置应用类型
                    apps.setAppType(appLog.getAppType());
                    //设置三级类目1
                    apps.setCategoryId1(appLog.getCategoryId1());
                    //判断三级类目2是否存在
                    if (null != appLog.getCategoryId2()) {
                        //设置三级类目2
                        apps.setCategoryId2(appLog.getCategoryId2());
                    }
                    //设置二级类目
                    apps.setCategoryIdl2(appLog.getCategoryIdl2());
                    /*更新应用基本信息表记录*/
                    erpScheduleManager.updateApps(apps);
                    /*更新后台任务状态为执行成功*/
                    erpScheduleManager.updateTaskBySuccessStatus(taskInfoResult.getId());
                    /*关闭应用基本信息日志表中基本信息同步*/
                    erpScheduleManager.updateAppsLog(taskInfoResult.getRelatedId());
                } else {
                    log.info("基本信息同步错误 该应用不存在同步任务， task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId());
                    erpScheduleManager.removeInvalidTask(taskInfoResult.getId());
                    //taskError(taskInfoResult, startTimeFact, "基本信息同步错误 该应用不存在同步任务", taskInfoResult.getRetryTimes() - 1);
                }
            }
        } catch (java.lang.Exception e) {
            String ems = "基本信息同步失败,发生异常";
            if (null != taskInfoResult) {
                ems += " task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId();
            }
            log.error(ems, e);
            taskError(taskInfoResult, startTimeFact, "基本信息同步失败,发生异常", taskInfoResult.getRetryTimes() - 1);
        }
    }

    /**
     * 上传主图
     *
     * @param taskInfoResult
     */
    public void uploadCoverSyncScheduler(TaskInfoResult taskInfoResult) {
        Date startTimeFact = new Date();
        String localUrl = "";
        try {
            if (null != taskInfoResult) {
                /*根据上传主图任务关联ID 在应用详情日志表中取得主图Url*/
                AppDetailsLog appDetailsLog = erpScheduleManager.findAppDetailsLog(taskInfoResult.getRelatedId());
                /*判断应用基本信息日志中是否存在记录,主图是否为空,主图是否为NULL*/
                if (null != appDetailsLog && null != appDetailsLog.getLogoUrl() && "" != appDetailsLog.getLogoUrl()) {
                    //设置截图服务器上图片完整路径
                    String logoUrl = "http://" + imageserver + "/" + appDetailsLog.getLogoUrl();
                    /*从图片服务器下载图片到本地 并取得本地Url*/
                    String target = uploadImagePath + "/";
                    //从图片服务器下载图片到本地
                    localUrl = writeFile(logoUrl, target);

                    /*要根据本地Url将图片上传至主图服务器,并取得主图服务器Url*/
                    CoverBean coverBean = new CoverBean();
                    //设置上传图片文件
                    coverBean.setDestFilePath(new File(localUrl));
                    //设置商品sku
                    coverBean.setWareId(appDetailsLog.getAppId());
                    //设置用户名
                    coverBean.setUserName(appDetailsLog.getAccount());
                    //上传主图
                    CoverResult coverResult = imageManager.uploadCover(coverBean);
                    //上传是否成功
                    if (coverResult.isSuccess()) {
                        /*更新应用详情日志表中主图Url*/
                        erpScheduleManager.updateAppDetailsLogCover(coverResult.getImgUrl(), taskInfoResult.getRelatedId());
                        /*更新后台任务状态为执行成功*/
                        erpScheduleManager.updateTaskBySuccessStatus(taskInfoResult.getId());
                    } else {
                        log.error("主图同步失败：" + coverResult.getMessage() + " task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId());
                        taskError(taskInfoResult, startTimeFact, coverResult.getMessage(), taskInfoResult.getRetryTimes() - 1);
                    }
                } else {
                    log.info("没有找到主图LogoUrl或LogoUrl没有值， task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId());
                    erpScheduleManager.removeInvalidTask(taskInfoResult.getId());
//                    taskError(taskInfoResult, startTimeFact, "没有找到主图LogoUrl或LogoUrl没有值", taskInfoResult.getRetryTimes() - 1);
                }
            }
        } catch (java.lang.Exception e) {
            String ems = "主图同步失败,发生异常";
            if (null != taskInfoResult) {
                ems += " task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId();
            }
            log.error(ems, e);
            taskError(taskInfoResult, startTimeFact, "主图同步失败,发生异常", taskInfoResult.getRetryTimes() - 1);
        } finally {
            //删除本地图片
            deleteDirectory(localUrl);
        }
    }

    /**
     * 同步上下架状态
     *
     * @param taskInfoResult
     */
    public void appStoreUpStatusSyncScheduler(TaskInfoResult taskInfoResult, String status) {
        Date startTimeFact = new Date();
        try {
            if (null != taskInfoResult) {
                /*根据任务关联ID查询应用基本信息日志表*/
                AppLog appLog = erpScheduleManager.findAppLog(taskInfoResult.getRelatedId());
                /*判断应用基本信息日志中是否存在记录,同步上下架是否开起,审核状态是否通过*/
                if (null != appLog && 1 == appLog.getOnlineSyncFlag() && 3 == appLog.getBaseCheckStatus()) {
                    //获取本次要操作的上下架状态
                    int onlineStatus = appLog.getOnlineOptType();
                    if (onlineStatus == 1) {
                        //将状态设置为上架
                        onlineStatus = 1;
                        /*上架该应用的所有详情*/
                        erpScheduleManager.updateAppDetailByOnlineStatus(appLog.getAppId());
                    } else if (onlineStatus == 0) {
                        //将状态设置为下架
                        onlineStatus = 2;
                        /*下架该应用的所有详情*/
                        erpScheduleManager.updateAppDetailByDownStatus(appLog.getAppId());
                    }
                    /*更新应用基本信息表上下架状态*/
                    erpScheduleManager.updateAppsOnlineStatus(appLog.getAppId(), onlineStatus, 0);
                    /*更新后台任务状态为执行成功*/
                    erpScheduleManager.updateTaskBySuccessStatus(taskInfoResult.getId());
                    /*关闭应用基本信息日志表上下架同步*/
                    erpScheduleManager.updateAppsLogOnlineSyncFlag(taskInfoResult.getRelatedId());
                } else {
                    log.info("上下架同步错误 该应用不存在同步任务,task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId());
                    erpScheduleManager.removeInvalidTask(taskInfoResult.getId());
//                        taskError(taskInfoResult, startTimeFact, "上下架同步错误 该应用不存在同步任务", taskInfoResult.getRetryTimes() - 1);
                }
            }
        } catch (java.lang.Exception e) {
            String ems = "上下架同步失败,发生异常";
            if (null != taskInfoResult) {
                ems += " task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId();
            }
            log.error(ems, e);
            taskError(taskInfoResult, startTimeFact, "上下架同步失败,发生异常", taskInfoResult.getRetryTimes() - 1);
        }
    }

    /**
     * 同步应用价格
     *
     * @param taskInfoResult
     */
    public void updatePriceSyncScheduler(TaskInfoResult taskInfoResult, String status) {
        Date startTimeFact = new Date();
        try {
            if (null != taskInfoResult) {
                /*根据任务关联ID查询应用基本信息日志表*/
                AppDetailsLog appDetailsLog = erpScheduleManager.findAppDetailsLog(taskInfoResult.getRelatedId());
                /*判断应用基本信息日志中是否存在记录,同步价格是否开起*/
                if (null != appDetailsLog && 1 == appDetailsLog.getPriceSyncFlag()) {

                    /*根据应用ID、cp账号查询该应用是否已存在详情信息*/
                    AppDetails appDetail = erpScheduleManager.findAppDetails(appDetailsLog.getAppId(), appDetailsLog.getAccountId());

                    //详情ID
                    int id = 0;
                    //实例化应用详情信息对像,并设置对像中的值
                    AppDetails appDetails = new AppDetails();
                    appDetails.setAppId(appDetailsLog.getAppId());
                    appDetails.setAccountId(appDetailsLog.getAccountId());
                    appDetails.setFeeMode(appDetailsLog.getFeeMode());
                    appDetails.setPrice(appDetailsLog.getPrice());
                    appDetails.setPercent(appDetailsLog.getPercent());
                    appDetails.setPeriod1Begin(appDetailsLog.getPeriod1Begin());
                    appDetails.setPeriod1End(appDetailsLog.getPeriod1End());
                    appDetails.setPercent2(appDetailsLog.getPercent2());
                    appDetails.setPeriod2Begin(appDetailsLog.getPeriod2Begin());
                    appDetails.setPeriod2End(appDetailsLog.getPeriod2End());
                    appDetails.setPercent3(appDetailsLog.getPercent3());
                    appDetails.setPeriod3Begin(appDetailsLog.getPeriod3Begin());
                    appDetails.setPeriod3End(appDetailsLog.getPeriod3End());
                    appDetails.setPrepay(appDetailsLog.getPrepay());
                    appDetails.setBuyout(appDetailsLog.getBuyout());
                    appDetails.setBuyoutBegin(appDetailsLog.getBuyoutBegin());
                    appDetails.setBuyoutEnd(appDetailsLog.getBuyoutEnd());
                    appDetails.setAppVersion(appDetailsLog.getAppVersion());
                    appDetails.setAppVersioCode(appDetailsLog.getAppVersioCode());
                    appDetails.setLogoUrl(appDetailsLog.getLogoUrl());
                    appDetails.setAppLogo(appDetailsLog.getAppLogo());
                    appDetails.setOsVersionId(appDetailsLog.getOsVersionId());
                    appDetails.setPkgSize(appDetailsLog.getPkgSize());
                    appDetails.setOnline(1);
                    appDetails.setUpdateStatus(0);
                    appDetails.setPubTime(appDetailsLog.getPubTime());
                    appDetails.setAdText(appDetailsLog.getAdText());
                    appDetails.setAppTag(appDetailsLog.getAppTag());
                    appDetails.setNewFeatures(appDetailsLog.getNewFeatures());
                    appDetails.setAppIntroduce(appDetailsLog.getAppIntroduce());
                    appDetails.setAppLogo(appDetailsLog.getAppLogo());
                    appDetails.setZhuoWangMark(appDetailsLog.getZhuoWangMark());
                    appDetails.setApkCode(appDetailsLog.getApkCode());
                    //修改价格同步标识,为成功
                    erpScheduleManager.updateAppPriceSyncFlag(appDetailsLog.getId());
                    //该应用详情是否存在
                    if (null != appDetail) {
                        /*存在,则更新应用详情信息*/
                        erpScheduleManager.updateAppDetails(appDetails);
                    } else {
                        /*不存在,则创建应用详情信息,并返回创建的详情ID*/
                        id = erpScheduleManager.createAppDetails(appDetails);
                    }
                    /*更新应用基本信息表上架状态*/
                    erpScheduleManager.updateAppsOnlineStatus(appDetails.getAppId(), 1, id);
                    /*更新后台任务状态为成功*/
                    erpScheduleManager.updateTaskBySuccessStatus(taskInfoResult.getId());
                    /*查询资源副本*/
                    int appResource = erpScheduleManager.findAppResourceCopy(appDetailsLog.getAppId(), appDetailsLog.getAccountId());
                    /*资源副本是否存在*/
                    if (0 == appResource) {
                        /*修改应用资源副本状态*/
                        erpScheduleManager.updateAppIsCopyStatus(appDetailsLog.getAppId(), appDetailsLog.getAccountId());
                    } else {
                        /*删除老资源*/
                        erpScheduleManager.deleteAppResource(appDetailsLog.getAppId(), appDetailsLog.getAccountId());
                        /*修改应用资源副本状态*/
                        erpScheduleManager.updateAppIsCopyStatus(appDetailsLog.getAppId(), appDetailsLog.getAccountId());
                    }
                } else {
                    /*更新应用基本信息表下架状态*/
                    erpScheduleManager.updateAppsOnlineStatus(appDetailsLog.getAppId(), 2, 0);
                    log.info("价格同步任务错误 该应用不存在同步任务或未开起同步标记, task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId());
                    erpScheduleManager.removeInvalidTask(taskInfoResult.getId());
//                        taskError(taskInfoResult, startTimeFact, "价格同步任务错误 该应用不存在同步任务或未开起同步标记", taskInfoResult.getRetryTimes() - 1);
                }
            }
        } catch (java.lang.Exception e) {
            String ems = "价格同步失败,发生异常";
            if (null != taskInfoResult) {
                ems += " task id:" + taskInfoResult.getId() + "  related_id:" + taskInfoResult.getRelatedId();
            }
            log.error(ems, e);
            taskError(taskInfoResult, startTimeFact, "同步失败,发生异常", taskInfoResult.getRetryTimes() - 1);
        }
    }

    /**
     * 修改后台任务状态，剩余次数，时间
     *
     * @param taskInfoResult
     * @param startTimeFact
     * @param message
     * @param retryTimes
     */
    public void taskError(TaskInfoResult taskInfoResult, Date startTimeFact, String message, int retryTimes) {
        TaskInfoQuery taskInfoQuery = new TaskInfoQuery();
        if (1 == taskInfoResult.getAutoRetry()) {/*判断是否自动重试*/
            taskInfoQuery.setId(taskInfoResult.getId());
            taskInfoQuery.setStartTimeFact(startTimeFact);
            taskInfoQuery.setStartTimePlan(DateUtils.addMinutes(startTimeFact, 2));
            taskInfoQuery.setComment(message);
            taskInfoQuery.setRetryTimes(retryTimes);
            //判断是否需要自动重试
            if (taskInfoQuery.getRetryTimes() > 0) {
                //需要
                taskInfoQuery.setStatus(TaskTypeConstants.CMS_TASKSTATUS_WAITEXECUTE);/*设置为待执行状态*/
            } else {
                //不需要
                taskInfoQuery.setStatus(TaskTypeConstants.CMS_TASKSTATUS_FAILS);/*设置为执行失败状态*/
            }
        } else {
            taskInfoQuery.setId(taskInfoResult.getId());
            taskInfoQuery.setStartTimeFact(startTimeFact);
            taskInfoQuery.setStartTimePlan(DateUtils.addMinutes(startTimeFact, 2));
            taskInfoQuery.setComment(message);
            taskInfoQuery.setRetryTimes(retryTimes);
            taskInfoQuery.setStatus(TaskTypeConstants.CMS_TASKSTATUS_STOP);/*设置为已停用状态*/
        }
        erpScheduleManager.updateTaskInfo(taskInfoQuery);/*更新后台任务*/
    }

    /**
     * 从服务器中下载文件到本地
     *
     * @param imgUrl 文件存放在服务器的地址
     * @return
     */
    public String writeFile(String imgUrl, String target) {
        String code = generateGUID();
        String fileName = code + imgUrl.substring(imgUrl.lastIndexOf("."));
        String localUrl = target + fileName;
        URL url = null;
        try {
            url = new URL(imgUrl);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e1) {
            log.error("图片不存在或无法下载", e1);
        }
        OutputStream os = null;
        File f = new File(target);
        if (!f.exists()) {
            f.mkdirs();
        }
        try {
            os = new FileOutputStream(target + fileName);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];

            while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return localUrl;
    }

    /**
     * 删除目录（文件夹）以及目录下的文件
     *
     * @param sPath 被删除目录的文件路径
     */
    public void deleteDirectory(String sPath) {
        File file = new File(sPath);
        /*FileUtils.deleteQuietly(file);*/
        file.delete();
    }

    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Integer amount) throws Exception {
        if (!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }

        int flag = 0;
        String amString = amount.toString();
        if (amString.charAt(0) == '-') {
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuffer result = new StringBuffer();
        if (amString.length() == 1) {
            result.append("0.0").append(amString);
        } else if (amString.length() == 2) {
            result.append("0.").append(amString);
        } else {
            String intString = amString.substring(0, amString.length() - 2);
            for (int i = 1; i <= intString.length(); i++) {
                if ((i - 1) % 3 == 0 && i != 1) {
                    result.append(",");
                }
                result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
            }
            result.reverse().append(".").append(amString.substring(amString.length() - 2));
        }
        if (flag == 1) {
            return "-" + result.toString();
        } else {
            return result.toString();
        }
    }

    public String generateGUID() {
        return new BigInteger(165, RANDOM).toString(36).toUpperCase();
    }

    public UpdatePriceSyncManager getUpdatePriceSyncManager() {
        return updatePriceSyncManager;
    }

    public void setUpdatePriceSyncManager(UpdatePriceSyncManager updatePriceSyncManager) {
        this.updatePriceSyncManager = updatePriceSyncManager;
    }

    public AppStoreUpStatusSyncManager getAppStoreUpStatusSyncManager() {
        return appStoreUpStatusSyncManager;
    }

    public void setAppStoreUpStatusSyncManager(AppStoreUpStatusSyncManager appStoreUpStatusSyncManager) {
        this.appStoreUpStatusSyncManager = appStoreUpStatusSyncManager;
    }

    public AppStoreBasicInfoSyncManager getAppStoreBasicInfoSyncManager() {
        return appStoreBasicInfoSyncManager;
    }

    public void setAppStoreBasicInfoSyncManager(AppStoreBasicInfoSyncManager appStoreBasicInfoSyncManager) {
        this.appStoreBasicInfoSyncManager = appStoreBasicInfoSyncManager;
    }

    public ErpScheduleManager getErpScheduleManager() {
        return erpScheduleManager;
    }

    public void setErpScheduleManager(ErpScheduleManager erpScheduleManager) {
        this.erpScheduleManager = erpScheduleManager;
    }

    public void setImageManager(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    public void setImageserver(String imageserver) {
        this.imageserver = imageserver;
    }

    public void setUploadImagePath(String uploadImagePath) {
        this.uploadImagePath = uploadImagePath;
    }
}
