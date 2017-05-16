package com.jd.cms.service.appManagement.impl;

import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.manager.appManagement.AppManagementManager;
import com.jd.cms.service.appManagement.AppManagementService;
import com.jd.common.util.StringEscapeUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.domain.bean.CommonResult;
import com.jd.digital.common.rpc.domain.bean.sync.appstore.AppStoreSyncBasicInfoDO;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;
import com.jd.digital.common.rpc.manager.sync.basicinfo.appstore.AppStoreBasicInfoSyncManager;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用serviceImpl
 */
public class AppManagementServiceImpl implements AppManagementService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(AppManagementServiceImpl.class);
    /**
     * managerCached注入
     */
    private AppManagementManager appManagementManagerCached;
    /**
     * jss云存储接口
     */
    private JssAppManager jssAppManager;
    /**
     * 手机软件id
     */
    private String mobileSoftId;
    /**
     * 手机游戏id
     */
    private String mobileGameId;
    /**
     * WEB应用id
     */
    private String webAppId;


    /**
     * 应用商店基本信息同步erp
     */
    private AppStoreBasicInfoSyncManager appStoreBasicInfoSyncManager;

    /**
     * 初始化
     *
     * @return Result
     */
    public Result init() {
        Result result = new Result();
        result.addDefaultModel("mobileSoftId", mobileSoftId);
        result.addDefaultModel("mobileGameId", mobileGameId);
        result.addDefaultModel("webAppId", webAppId);
        return result;
    }

    /**
     * 重新同步所有/部分应用基本信息
     *
     * @param appPageInput
     * @return Result
     */
    public Result syncAllAppBaseInfo(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            /*取得重新同步所有/部分应用基本信息*/
            List<Apps> appBaseInfos = appManagementManagerCached.getAppBaseInfo(appPageInput);
            List<String> syncresults = null;
            if (appBaseInfos != null) {
                int count = appBaseInfos.size();
                if (count > 0) {
                    syncresults = new ArrayList<String>();
                    for (int i = 0; i < count; i++) {
                        //实例化应用商店同步基本信息对像
                        AppStoreSyncBasicInfoDO appStoreSyncBasicInfoDO = new AppStoreSyncBasicInfoDO();
                        //设置应用ID
                        appStoreSyncBasicInfoDO.setId(appBaseInfos.get(i).getAppId());
                        //设置应用名称
                        appStoreSyncBasicInfoDO.setName(appBaseInfos.get(i).getAppName());
                        //设置三级类目1
                        appStoreSyncBasicInfoDO.setThirdCategory1(appBaseInfos.get(i).getCategoryId1());
                        //设置操作人名称
                        appStoreSyncBasicInfoDO.setOpName("admin");
                        //设置IP
                        appStoreSyncBasicInfoDO.setIp("127.0.0.1");
                        //设置主图地址
                        appStoreSyncBasicInfoDO.setImagePath(appBaseInfos.get(i).getLogoUrl());

                        //判断三级类目2是否存在
                        if (null != appBaseInfos.get(i).getCategoryId2()) {
                            //设置三级类目2
                            appStoreSyncBasicInfoDO.setThirdCategory2(appBaseInfos.get(i).getCategoryId2());
                        }
                        /*调用应用基本信息同步接口*/
                        log.info("同步基本信息。appStoreSyncBasicInfoDO=" + appStoreSyncBasicInfoDO);
                        CommonResult commonResult = appStoreBasicInfoSyncManager.syncBasicInfo(appStoreSyncBasicInfoDO);
                        String ret = appBaseInfos.get(i).getAppId() + "(" + appBaseInfos.get(i).getAppName() + ")";
                        /*基本信息同步是否成功*/
                        if (commonResult.isSuccess()) {
                            ret = "同步成功：" + ret;
                        } else {
                            ret = "同步失败。" + ret;
                        }
                        syncresults.add(ret);
                    }
                }


            }


            result.addDefaultModel("Apps", syncresults);

            result.setSuccess(true);
        } catch (Exception e) {
            log.error("重新同步所有/部分应用基本信息 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     *
     * @return Result
     */
    public Result findDetailsPage(AppPageInput appPageInput, int pageIndex, int pageSize) {

        Result result = new Result();
        try {
            /*取得审核应用的信息集合*/
            result.addDefaultModel("AppPageOutputs", appManagementManagerCached.findDetailsPage(appPageInput, pageIndex, pageSize));
            /*主图图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
            /*截图图片路径*/
            result.addDefaultModel("IMG_N4", PicResolutionEnum.IMG_N4.getPrefix());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得审核应用的信息集合 appPageInput=" + appPageInput + " pageIndex=" + pageIndex + " pageSize=" + pageSize + " error!", e);
        }
        return result;
    }

    /**
     * 查找单个详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public Result findAppDetails(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("mobileSoftId", mobileSoftId);
            result.addDefaultModel("mobileGameId", mobileGameId);
            result.addDefaultModel("webAppId", webAppId);
            /*CP应用对应的截图集合*/
            result.addDefaultModel("Pictures", appManagementManagerCached.findPicture(appPageInput));
            /*默认合同信息*/
            result.addDefaultModel("defaultContract", appManagementManagerCached.findDefaultPercent(appPageInput));
            /*查找单个详情*/
            AppPageOutput appPageOutput = appManagementManagerCached.findAppDetails(appPageInput);
            /*主图图片路径*/
            result.addDefaultModel("COVER_N4", PicResolutionEnum.COVER_N4.getPrefix());
            /*截图图片路径*/
            result.addDefaultModel("IMG_N1", PicResolutionEnum.IMG_N1.getPrefix());
            result.addDefaultModel("IMG_N4", PicResolutionEnum.IMG_N4.getPrefix());
            /*处理软件包大小*/
            if (null != appPageOutput.getPkgSize()) {
                /*得到应用大小的字节数*/
                int pkgSize = appPageOutput.getPkgSize();
                /*如果小于1MB显示为KB*/
                if (pkgSize / 1024 < 1024) {
                    appPageOutput.setPkgSizeB(pkgSize / 1024 + "KB");
                } else {
                    /*格式化结果，保留2位小数*/
                    String Fstr = String.format("%.2f", pkgSize / 1024.00 / 1024.00);
                    /*存入pkgsize*/
                    appPageOutput.setPkgSizeB(Fstr + "MB");
                }
            }
            /*保存详情*/
            result.addDefaultModel("AppPageOutput", appPageOutput);
            /*通过2级类目查找3级类目*/
            result.addDefaultModel("Category3", appManagementManagerCached.findCategory(appPageOutput.getCategoryidl2()));
            /*应用类型为android的要查找对应的平台名*/
            if (appPageOutput.getAppType() == 0 || appPageOutput.getAppType() == 1 || appPageOutput.getAppType() == 2) {
                /*查找对应的平台名*/
                result.addDefaultModel("AndroidAppOsversion", appManagementManagerCached.findOsVersion(appPageOutput.getOsVersionId()));
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("查找单个详情 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 审核不通过
     *
     * @param appPageInput
     * @return int
     */
    public Result updateStatusOff(AppPageInput appPageInput) {
        Result result = new Result();
        try {
            int isSuccess = appManagementManagerCached.updateStatusOff(appPageInput);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "审核不通过成功");
            } else {
                result.addDefaultModel("info", "审核不通过失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("审核不通过异常 appPageInput=" + appPageInput + " error!", e);
            result.addDefaultModel("info", "审核不通过异常");
        }
        return result;
    }

    /**
     * 审核通过
     *
     * @param appPageInput
     * @return int
     */
    public Result updateStatusOn(AppPageInput appPageInput) {
        Result result = new Result();
        try {

            String intro = appPageInput.getAppIntroduce();
            if (intro != null) {
                intro = intro.replaceAll("<br>", "\n");
                intro = StringEscapeUtils.escapeHtml(intro);
            }
            appPageInput.setAppIntroduce(intro);

            int isSuccess = appManagementManagerCached.updateStatusOn(appPageInput);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "审核通过成功");
            } else {
                result.addDefaultModel("info", "审核通过失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("审核通过时异常 appPageInput=" + appPageInput + " error!", e);
        }
        return result;
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public Result findCategory(int parentId) {
        Result result = new Result();
        try {
            result.addDefaultModel("categorys", appManagementManagerCached.findCategory(parentId));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("通过2级类目查找3级类目 parentId=" + parentId + " error!", e);
        }
        return result;
    }

    /**
     * 取得tonken
     *
     * @param url
     * @return String
     */
    public String getToken(String url) {
        String newResUrl = null;
        try {
            /*取得token*/
            String str = jssAppManager.getToken();
            /*下载地址+token*/
            newResUrl = url + "?token=" + str;
        } catch (Exception e) {
            log.error("取得tonken url=" + url + " error!", e);
        }
        return newResUrl;
    }



    public JssAppManager getJssAppManager() {
        return jssAppManager;
    }

    public void setJssAppManager(JssAppManager jssAppManager) {
        this.jssAppManager = jssAppManager;
    }

    public AppManagementManager getAppManagementManagerCached() {
        return appManagementManagerCached;
    }

    public void setAppManagementManagerCached(AppManagementManager appManagementManagerCached) {
        this.appManagementManagerCached = appManagementManagerCached;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }

    public AppStoreBasicInfoSyncManager getAppStoreBasicInfoSyncManager() {
        return appStoreBasicInfoSyncManager;
    }

    public void setAppStoreBasicInfoSyncManager(AppStoreBasicInfoSyncManager appStoreBasicInfoSyncManager) {
        this.appStoreBasicInfoSyncManager = appStoreBasicInfoSyncManager;
    }

}
