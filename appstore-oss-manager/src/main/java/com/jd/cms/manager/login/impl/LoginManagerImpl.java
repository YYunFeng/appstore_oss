package com.jd.cms.manager.login.impl;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.dao.login.LoginDao;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.cms.manager.login.LoginManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.base.BaseQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public class LoginManagerImpl extends BaseManager implements LoginManager {
    private final static Log log = LogFactory.getLog(LoginManagerImpl.class);
        /**
     * 用户登录Dao
     */
    private LoginDao loginDao;

    /**
     * 根据用户名、密码查询用户信息
     *
     * @param supportUsers
     * @return
     */
    public SupportUsers findSupportUsers(SupportUsers supportUsers) {
        SupportUsers supportUsersResult;
        try {
            //根据用户名、密码查询用户信息
            supportUsersResult = loginDao.findSupportUsers(supportUsers);
        } catch (Exception ex) {
            log.error("查询登录用户信息 error!", ex);
            throw new RuntimeException("findSupportUsers error!", ex);
        }
        return supportUsersResult;
    }

    /**
     * 根据用户名查询拥有权限
     *
     * @param account
     * @return
     */
    public List<SupportModule> findSupportUserModule(String account) {
        List<SupportModule> supportModuleList = new ArrayList<SupportModule>();
        try {
            //写入查询条件
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setValue(account);
            //根据用户名查询拥有权限
            supportModuleList = loginDao.findSupportUserModule(baseQuery);
        } catch (Exception ex) {
            log.error("查询登录用户可使用模块 error!", ex);
            throw new RuntimeException("findSupportUserModule error!", ex);
        }
        return supportModuleList;
    }

    /**
     * 根据用户名查询最后登录时间
     *
     * @param account
     * @return
     */
    public SupportUsers findOperationTime(String account) {
        SupportUsers supportUsersResult;
        try {
            //写入查询条件
            SupportUsers supportUsers = new SupportUsers();
            supportUsers.setAccount(account);
            //根据用户名查询最后登录时间
            supportUsersResult = loginDao.findOperationTime(supportUsers);
        } catch (Exception ex) {
            log.error("查询用户上次登录时间 error!", ex);
            throw new RuntimeException("findOperationTime error!", ex);
        }
        return supportUsersResult;
    }

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param account
     * @param moduleUrl
     * @return
     */
    public PowerQuery findSupportUserModule(String account, String moduleUrl) {
        PowerQuery powerResult;
        try {
            //写入查询条件
            PowerQuery powerQuery = new PowerQuery();
            powerQuery.setAccount(account);
            powerQuery.setModuleUrl(moduleUrl);
            //根据用户名、权限URL查询权限信息
            powerResult = loginDao.findSupportUserModule(powerQuery);
        } catch (Exception ex) {
            log.error("查询用户是否有此权限 error!", ex);
            throw new RuntimeException("findSupportUserModule error!", ex);
        }
        return powerResult;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
