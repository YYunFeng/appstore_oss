package com.jd.cms.dao.login.impl;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.dao.login.LoginDao;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 */
public class LoginDaoImpl extends BaseDao implements LoginDao {
    /**
     * 根据用户名、密码查询用户信息
     *
     * @param supportUsers
     * @return
     */
    public SupportUsers findSupportUsers(SupportUsers supportUsers) {
        return (SupportUsers) queryForObject("Login.findSupportUsers", supportUsers);
    }

    /**
     * 根据用户名查询拥有权限
     *
     * @param query
     * @return
     */
    public List<SupportModule> findSupportUserModule(Query query) {
        return queryForList("Login.findSupportUserModule", query);
    }

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param powerQuery
     * @return
     */
    public PowerQuery findSupportUserModule(PowerQuery powerQuery) {
        return (PowerQuery) queryForObject("Login.findSupportUserPower", powerQuery);
    }

    /**
     * 根据用户名查询最后登录时间
     *
     * @param supportUsers
     * @return
     */
    public SupportUsers findOperationTime(SupportUsers supportUsers) {
        return (SupportUsers) queryForObject("Login.findOperationTime", supportUsers);
    }
}
