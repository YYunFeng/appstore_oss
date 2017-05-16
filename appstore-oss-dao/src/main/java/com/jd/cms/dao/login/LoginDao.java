package com.jd.cms.dao.login;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 */
public interface LoginDao {
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
     * @param query
     * @return
     */
    List<SupportModule> findSupportUserModule(Query query);

    /**
     * 根据用户名、权限URL查询权限信息
     *
     * @param powerQuery
     * @return
     */
    PowerQuery findSupportUserModule(PowerQuery powerQuery);

    /**
     * 根据用户名查询最后登录时间
     *
     * @param supportUsers
     * @return
     */
    SupportUsers findOperationTime(SupportUsers supportUsers);
}
