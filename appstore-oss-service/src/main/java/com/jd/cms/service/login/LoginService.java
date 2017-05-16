package com.jd.cms.service.login;

import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.common.web.result.Result;

import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public interface LoginService {
    /**
     * 根据用户名、密码查询用户信息
     *
     * @param supportUsers
     * @return
     */
    SupportUsers findSupportUsers(SupportUsers supportUsers);

    /**
     * 根据用户名查询拥有权限
     *
     * @param account
     * @return
     */
    Result findSupportUserModule(String account);

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param account
     * @param moduleUrl
     * @return
     */
    PowerQuery findSupportUserModule(String account, String moduleUrl);

    /**
     * 获取设置用户名到COOKIE时KEY
     *
     * @return
     */
    String getCookieName();

    /**
     * 获取设置用户ID到COOKIE时KEY
     *
     * @return
     */
    String getCookieId();

    /**
     * 获取设置记住登录状态时的用户名到COOKIE时KEY
     *
     * @return
     */
    String getCookieRememberName();

    /**
     * 获取设置记住登录状态时的用户密码到COOKIE时KEY
     *
     * @return
     */
    String getCookieRememberPwd();

}
