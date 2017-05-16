package com.jd.cms.web.action.appManagement;

import com.jd.cms.common.util.ClientIp;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.service.appManagement.AppManagementService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用action
 */
public class AppManagementAction extends BaseAction {

    /**
     * service注入
     */
    private AppManagementService appManagementService;
    /**
     * 页面数据接收
     */
    private AppPageInput appPageInput;
    /**
     * message
     */
    private String message;
    /**
     * 页面id接收
     */
    private int id;


    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;

    private ValidMachineStatisticsService validMachineStatisticsService;

    /**
     * 用户登录Service
     */
    private LoginService loginService;

    /**
     * 应用管理加载项
     *
     * @return String
     * @throws Exception
     */
    public String init() {
        Result result = appManagementService.init();
        toVm(result);

        Integer userId = Integer.valueOf(cookieUtils.getCookieValue(request, loginService.getCookieId()));
        Integer cid = validMachineStatisticsService.channelId(userId);
        if (cid != null) {
            Result res = new Result();
            res.addDefaultModel("cid", cid);
            toVm(res);
        }
        return "INIT";
    }

    /**
     * 重新同步所有应用的基本信息
     *
     * @return String
     * @throws Exception
     */
    public String syncAllAppBaseInfo() throws Exception {
        Result results = appManagementService.syncAllAppBaseInfo(appPageInput);
        toVm(results);
        return "SYNCRESULT";
    }

    /**
     * 审核应用-移动应用分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findMobileDetailsPage() throws Exception {
        message = Integer.toString(hashCode());
        if (null == appPageInput) {
            appPageInput = new AppPageInput();
        }
        /*存入应用类型0,1,2*/
        appPageInput.setType("0,1,2");
        /*存入资源类型为1，用于查找apk*/
        appPageInput.setResTypeList("1");
        Result results = appManagementService.findDetailsPage(appPageInput, page, PAGE_SIZE);
        toVm(results);
        return "MOBILEPAGE";
    }

    /**
     * 审核应用-应用网页分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findWebDetailsPage() throws Exception {
        message = Integer.toString(hashCode());
        if (null == appPageInput) {
            appPageInput = new AppPageInput();
        }
        /*appType为-1代表查询全部*/
        if (-1 == appPageInput.getAppType()) {
            /*存入应用类型3,4*/
            appPageInput.setType("3,4");
        } else if (3 == appPageInput.getAppType()) {
            /*存入应用类型3*/
            appPageInput.setType("3");
        } else if (4 == appPageInput.getAppType()) {
            /*存入应用类型4*/
            appPageInput.setType("4");
        }
        /*存入资源类型为1，用于查找web应用包*/
        appPageInput.setResTypeList("2,3");
        Result results = appManagementService.findDetailsPage(appPageInput, page, PAGE_SIZE);
        toVm(results);
        return "WEBPAGE";
    }

    /**
     * 审核应用-移动应用审核单条查询
     *
     * @return String
     * @throws Exception
     */
    public String findAppMobileDetails() throws Exception {
        Result result = appManagementService.findAppDetails(appPageInput);
        toVm(result);
        return "MOBILECHECKEXPATIATION";
    }

    /**
     * 审核应用-网页应用审核单条查询
     *
     * @return String
     * @throws Exception
     */
    public String findAppWebDetails() throws Exception {
        Result result = appManagementService.findAppDetails(appPageInput);
        toVm(result);
        return "WEBCHECKEXPATIATION";
    }

    /**
     * 审核应用-移动审核不通过操作
     *
     * @return String
     * @throws Exception
     */
    public String updateStatusMobileOff() throws Exception {
        appManagementService.updateStatusOff(appPageInput);
        return null;
    }

    /**
     * 审核应用-网页审核不通过操作
     *
     * @return String
     * @throws Exception
     */
    public String updateStatusWebOff() throws Exception {
        appManagementService.updateStatusOff(appPageInput);
        return null;
    }

    /**
     * 审核应用-移动审核通过操作
     *
     * @return String
     * @throws Exception
     */
    public String updateStatusMobileOn() throws Exception {
        if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        appManagementService.updateStatusOn(appPageInput);
        return null;
    }

    /**
     * 审核应用-网页审核通过操作
     *
     * @return String
     * @throws Exception
     */
    public String updateStatusWebOn() throws Exception {
        if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        appManagementService.updateStatusOn(appPageInput);
        return null;
    }

    /**
     * 审核应用-通过2级类目查3级类目
     *
     * @return String
     * @throws Exception
     */
    public String findCategory() throws Exception {
        Result result = appManagementService.findCategory(appPageInput.getCategoryidl2());
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 下载取的token
     *
     * @return String
     * @throws Exception
     */
    public String getToken() throws Exception {
        String str = appManagementService.getToken(appPageInput.getResUrl());
        String json = JSONUtil.serialize(str);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }


    public AppManagementService getAppManagementService() {
        return appManagementService;
    }

    public void setAppManagementService(AppManagementService appManagementService) {
        this.appManagementService = appManagementService;
    }

    public AppPageInput getAppPageInput() {
        return appPageInput;
    }

    public void setAppPageInput(AppPageInput appPageInput) {
        this.appPageInput = appPageInput;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
