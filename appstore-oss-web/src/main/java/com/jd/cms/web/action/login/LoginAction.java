package com.jd.cms.web.action.login;

import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.common.util.MD5Utils;
import com.jd.cms.service.adminlog.AdminLogService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.cms.service.schedule.SyncScheduleService;
import com.jd.cms.service.usermanager.AccountService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.domain.web.JdAppLoginContext;
import com.jd.digital.common.util.tool.WebHelper;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.json.JSONUtil;

import java.util.Date;


/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends BaseAction {
    /**
     * 用户登录Service
     */
    private LoginService loginService;
    /**
     * 运营支撑系统用户表
     */
    private SupportUsers supportUsers;
    /**
     * 是否记住了登录状态标识
     */
    private boolean chkRememberUsername;
    /**
     * 用户操作日志Service
     */
    private AdminLogService adminLogService;
    /**
     * Cookie工具类
     */
    private CookieUtils cookieUtils;

    /**
     * 用户管理
     */
    private AccountService accountService;


    private ValidMachineStatisticsService validMachineStatisticsService;

    /**
     * 登录页面初始化
     *
     * @return
     */
    public String welcome() {
        Result result = new Result();
        //是否记住了登录状态
        if (null != cookieUtils.getCookieValue(request, loginService.getCookieRememberName()) && null != cookieUtils.getCookieValue(request, loginService.getCookieRememberPwd())) {
            result.addDefaultModel("ossAccount", cookieUtils.getCookieValue(request, loginService.getCookieRememberName()));
            result.addDefaultModel("password", cookieUtils.getCookieValue(request, loginService.getCookieRememberPwd()));
        } else {
            result.addDefaultModel("ossAccount", "");
            result.addDefaultModel("password", "");
        }
        toVm(result);
        return "success";
    }

    /**
     * 用户登录
     *
     * @return
     */
    public void login() throws Exception {
        //登录状态标识
        String msg = "error";
        if (null != supportUsers) {
            String userPwd = supportUsers.getPassword().trim();
            supportUsers.setAccount(supportUsers.getAccount().trim());
            //密码MD5加密
            supportUsers.setPassword(MD5Utils.getMD5Str(userPwd));
            //根据用户名、密码查询用户信息
            SupportUsers supportUsersResult = loginService.findSupportUsers(supportUsers);
            //登录是否成功
            if (null == supportUsersResult) {
                //登录失败
                msg = "error";
            } else {
                //登录成功
                msg = "success";
                JdAppLoginContext context = JdAppLoginContext.getLoginContext();
                if (context == null) {
                    context = new JdAppLoginContext();
                }
                //设置PIN的值
                context.setPin(supportUsersResult.getAccount());
                JdAppLoginContext.setLoginContext(context);
                //将用户名 用户ID保存到cookie
                cookieUtils.setCookie(response, loginService.getCookieName(), context.toCookieValue());
                cookieUtils.setCookie(response, loginService.getCookieId(), String.valueOf(supportUsersResult.getId()));
                //是否记住了登录状态
                if (chkRememberUsername) {
                    //设置记住登录状态时用户名、密码到COOKIE
                    cookieUtils.setCookie(response, loginService.getCookieRememberName(), supportUsersResult.getAccount());
                    cookieUtils.setCookie(response, loginService.getCookieRememberPwd(), userPwd);
                } else {
                    //删除设置在COOKIE中记住登录状态时用户名、密码
                    cookieUtils.deleteCookie(response, loginService.getCookieRememberName());
                    cookieUtils.deleteCookie(response, loginService.getCookieRememberPwd());
                }

                Integer userId = supportUsersResult.getId();
                Integer cid = validMachineStatisticsService.channelId(userId);
                if (cid != null && cid.intValue() != 138) {
                    msg = "income";
                }
            }
        }
        //将登录状态写放JSON
        String json = JSONUtil.serialize(msg);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 初始化欢迎页
     *
     * @return
     * @throws Exception
     */
    public String init() throws Exception {

        //查询用户拥有权限的模块
        Result result = loginService.findSupportUserModule(WebHelper.getPin());
        toVm(result);
        try {
            //记录登录操作日志
            adminLogService.createAdminLog(request, Integer.parseInt(cookieUtils.getCookieValue(request, loginService.getCookieId())), 0, new Date(), "用户登录");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "init";
    }

    /**
     * 取得登录用户名
     *
     * @throws Exception
     */
    public void getAccount() throws Exception {
        //从cookie中取出用户名
        String account = WebHelper.getPin();
        //将用户名写入JSON
        String json = JSONUtil.serialize(account);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 登出
     *
     * @return
     * @throws Exception
     */
    public String exit() throws Exception {
        //记录登出操作日志
        adminLogService.createAdminLog(request, Integer.parseInt(cookieUtils.getCookieValue(request, loginService.getCookieId())), 1, new Date(), "用户登出");
        //删除cookie中用户名
        cookieUtils.deleteCookie(response, loginService.getCookieName());
        //删除cookie中用户ID
        cookieUtils.deleteCookie(response, loginService.getCookieId());
        //返回登录页面
        return Action.LOGIN;
    }

    public SupportUsers getSupportUsers() {
        return supportUsers;
    }

    public void setSupportUsers(SupportUsers supportUsers) {
        this.supportUsers = supportUsers;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean isChkRememberUsername() {
        return chkRememberUsername;
    }

    public void setChkRememberUsername(boolean chkRememberUsername) {
        this.chkRememberUsername = chkRememberUsername;
    }

    public void setAdminLogService(AdminLogService adminLogService) {
        this.adminLogService = adminLogService;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }


    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setValidMachineStatisticsService(ValidMachineStatisticsService validMachineStatisticsService) {
        this.validMachineStatisticsService = validMachineStatisticsService;
    }



}
