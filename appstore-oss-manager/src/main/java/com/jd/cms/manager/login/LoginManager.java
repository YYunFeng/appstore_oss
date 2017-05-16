package com.jd.cms.manager.login;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.PowerQuery;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public interface LoginManager {
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
    List<SupportModule> findSupportUserModule(String account);

    /**
     * 根据用户名查询最后登录时间
     *
     * @param account
     * @return
     */
    SupportUsers findOperationTime(String account);

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param account
     * @param moduleUrl
     * @return
     */
    PowerQuery findSupportUserModule(String account, String moduleUrl);
}
