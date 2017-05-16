package com.jd.cms.service.login.impl;

import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.cms.manager.login.LoginManager;
import com.jd.cms.service.login.LoginService;
import com.jd.common.util.DateFormatUtils;
import com.jd.common.web.result.Result;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl implements LoginService {
    /**
     * 用户登录Manager
     */
    private LoginManager loginManager;
    /**
     * 设置用户名到COOKIE时KEY
     */
    private String userName;
    /**
     * 设置用户ID到COOKIE时KEY
     */
    private String userId;
    /**
     * 设置记住登录状态时的用户名到COOKIE时KEY
     */
    private String rememberName;
    /**
     * 设置记住登录状态时的用户密码到COOKIE时KEY
     */
    private String rememberPwd;

    /**
     * 根据用户名、密码查询用户信息
     *
     * @param supportUsers
     * @return
     */
    public SupportUsers findSupportUsers(SupportUsers supportUsers) {
        return loginManager.findSupportUsers(supportUsers);
    }

    /**
     * 根据用户名查询拥有权限
     *
     * @param account
     * @return
     */
    public Result findSupportUserModule(String account) {
        Result result = new Result();
        result.addDefaultModel("modules", loginManager.findSupportUserModule(account));
        //根据用户名查询最后登录时间
        SupportUsers supportUsers = loginManager.findOperationTime(account);
        //如果第一次登录，则写入现在时间
        if (null == supportUsers) {
            supportUsers = new SupportUsers();
            supportUsers.setAccount(account);
            supportUsers.setCreated(new Date());
        }
        result.addDefaultModel("userinfo", supportUsers);
        return result;
    }

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param account
     * @param moduleUrl
     * @return
     */
    public PowerQuery findSupportUserModule(String account, String moduleUrl) {
        return loginManager.findSupportUserModule(account, moduleUrl);
    }

    /**
     * 获取设置用户名到COOKIE时KEY
     *
     * @return
     */
    public String getCookieName() {
        return userName;
    }

    /**
     * 获取设置用户ID到COOKIE时KEY
     *
     * @return
     */
    public String getCookieId() {
        return userId;
    }

    /**
     * 获取设置记住登录状态时的用户名到COOKIE时KEY
     *
     * @return
     */
    public String getCookieRememberName() {
        return rememberName;
    }

    /**
     * 获取设置记住登录状态时的用户密码到COOKIE时KEY
     *
     * @return
     */
    public String getCookieRememberPwd() {
        return rememberPwd;
    }

    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRememberName(String rememberName) {
        this.rememberName = rememberName;
    }

    public void setRememberPwd(String rememberPwd) {
        this.rememberPwd = rememberPwd;
    }
}
