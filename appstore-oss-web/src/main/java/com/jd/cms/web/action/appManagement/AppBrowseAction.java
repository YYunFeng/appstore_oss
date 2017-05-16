package com.jd.cms.web.action.appManagement;

import com.jd.cms.common.util.ClientIp;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.domain.appManagement.StatusJSON;
import com.jd.cms.service.appManagement.AppBrowseService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览action
 */
public class AppBrowseAction extends BaseAction {
    /**
     * message
     */
    private String message;
    /**
     * 页面id集合接收
     */
    private String idList;
    /**
     * 页面数据接收
     */
    private AppPageInput appPageInput;
    /**
     * service注入
     */
    private AppBrowseService appBrowseService;

    private ChangeCpInput changeCpInput;

    /**
     * 应用浏览-移动游戏，软件-分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findMobileBrowsePage() throws Exception {
        message = Integer.toString(hashCode());
        Result results = appBrowseService.findAppBrowsePage(appPageInput, page, PAGE_SIZE);
        toVm(results);
        return "MOBILEPAGE";
    }

    /**
     * 应用浏览-网页应用
     * 分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findWebBrowsePage() throws Exception {
        message = Integer.toString(hashCode());
        Result results = appBrowseService.findAppWebBrowsePage(appPageInput, page, PAGE_SIZE);
        toVm(results);
        return "WEBPAGE";
    }

    /**
     * 应用浏览-批量更新移动上下架状态
     *
     * @return String
     * @throws Exception
     */
    public String upMobileOnline() throws Exception {
        /*取得管理员名称*/
        appPageInput.setAdminId(WebHelper.getPin());
        /*取得请求人IP地址*/
        appPageInput.setIp(ClientIp.getIp(request));
        /*将ID集合存入appPageInput*/
        appPageInput.setIdList(idList);
        int mark = appBrowseService.upAppOnline(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 应用浏览-批量更新网页上下架状态
     *
     * @return String
     * @throws Exception
     */
    public String upWebOnline() throws Exception {
        /*取得管理员名称*/
        appPageInput.setAdminId(WebHelper.getPin());
        /*取得请求人IP地址*/
        appPageInput.setIp(ClientIp.getIp(request));
        /*将ID集合存入appPageInput*/
        appPageInput.setIdList(idList);
        int mark = appBrowseService.upAppOnline(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 应用浏览-更新移动上下架状态
     *
     * @return String
     * @throws Exception
     */
    public String upMobileOnlineById() throws Exception {
        if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        int mark = appBrowseService.upAppOnlineById(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 应用浏览-更新网页上下架状态
     *
     * @return String
     * @throws Exception
     */
    public String upWebOnlineById() throws Exception {
        if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        int mark = appBrowseService.upAppOnlineById(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 应用浏览-移动游戏，移动软件-详情查询
     *
     * @return String
     * @throws Exception
     */
    public String findMobileExpatiation() throws Exception {
        Result result = null;
        if (0 == appPageInput.getAccountid()) {
            /*存入资源类型为1，用于查找apk*/
            appPageInput.setResTypeList("1");
            /*默认详情*/
            result = appBrowseService.findAppDetailsFormal(appPageInput);
        } else {
            /*存入资源类型为1，用于查找apk*/
            appPageInput.setResType(1);
            /*通过CpName查找详情*/
            result = appBrowseService.findAppDetailsFormalByCp(appPageInput);
        }
        toVm(result);
        return "MOBILEEXPATIATION";
    }

    /**
     * 应用浏览-WEB应用的默认应用详情查询
     *
     * @return String
     * @throws Exception
     */
    public String findWebExpatiation() throws Exception {
        /*存入资源类型为2,3，用于查找web链接*/
        appPageInput.setResTypeList("2,3");
        Result result = appBrowseService.findAppDetailsFormal(appPageInput);
        toVm(result);
        return "WEBEXPATIATION";
    }

    /**
     * 应用浏览-移动游戏，软件-应用编辑查询详情
     *
     * @return String
     * @throws Exception
     */
    public String findMobileExpatiationEdit() throws Exception {
        Result result = null;
        /*审核通过的资源*/
        if (null == appPageInput.getCpName()) {
            /*默认详情*/
            result = appBrowseService.findAppDetailsFormalEdit(appPageInput);
        } else {
            /*通过CpName查找详情*/
            result = appBrowseService.findAppDetailsFormalEditByCp(appPageInput);
        }
        toVm(result);
        return "MOBILEEDIT";
    }


    public void changeCp() throws JSONException, IOException {
        StatusJSON exportExcelJSON = appBrowseService.chageCp(changeCpInput);
        String json = JSONUtil.serialize(exportExcelJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 应用浏览-应用软件-应用编辑查询详情
     *
     * @return String
     * @throws Exception
     */
    public String findWebExpatiationEdit() throws Exception {
        Result result = appBrowseService.findAppDetailsFormalEdit(appPageInput);
        toVm(result);
        return "WEBEDIT";
    }

    /**
     * 更新默认详情
     *
     * @return String
     * @throws Exception
     */
    public String upAppDefaultDetaild() throws Exception {
        int mark = appBrowseService.upAppDefaultDetaild(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 应用浏览-详情上下架状态修改操作
     *
     * @return String
     * @throws Exception
     */
    public String upAppDetailsOnline() throws Exception {
        appBrowseService.upAppDetailsOnline(appPageInput);
        return null;
    }

    /**
     * 编辑移动应用保存
     *
     * @return String
     * @throws Exception
     */
    public String saveMobileAppAndDetailInformation() throws Exception {
             if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        int mark = appBrowseService.saveAppAndDetailInformation(appPageInput);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * 编辑网页应用保存
     *
     * @return String
     * @throws Exception
     */
    public String saveWebAppAndDetailInformation() throws Exception {
        if (null != appPageInput) {
            /*取得管理员名称*/
            appPageInput.setAdminId(WebHelper.getPin());
            /*取得请求人IP地址*/
            appPageInput.setIp(ClientIp.getIp(request));
        }
        int mark = appBrowseService.saveAppAndDetailInformation(appPageInput);
        String json = JSONUtil.serialize(mark);
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
        String str = appBrowseService.getToken(appPageInput.getResUrl());
        String json = JSONUtil.serialize(str);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    public AppPageInput getAppPageInput() {
        return appPageInput;
    }

    public void setAppPageInput(AppPageInput appPageInput) {
        this.appPageInput = appPageInput;
    }

    public AppBrowseService getAppBrowseService() {
        return appBrowseService;
    }

    public void setAppBrowseService(AppBrowseService appBrowseService) {
        this.appBrowseService = appBrowseService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public ChangeCpInput getChangeCpInput() {
        return changeCpInput;
    }

    public void setChangeCpInput(ChangeCpInput changeCpInput) {
        this.changeCpInput = changeCpInput;
    }
}
