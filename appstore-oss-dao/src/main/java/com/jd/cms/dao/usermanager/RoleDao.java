package com.jd.cms.dao.usermanager;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.domain.usermanager.RoleManagerResult;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-15
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public interface RoleDao {
    /**
     * 查询角色列表
     *
     * @param query
     * @return
     */
    List<RoleManagerResult> findAccounts(Query query);

    /**
     * 查询总记录数
     *
     * @return
     */
    int getRolesCount();

    /**
     * 查询所有模块
     *
     * @return
     */
    List<SupportModule> findModules();

    /**
     * 查询角色是否存在
     *
     * @param supportRole
     * @return
     */
    SupportRole checkedRole(SupportRole supportRole);

    /**
     * 创建角色
     *
     * @param supportRole
     */
    void createRole(SupportRole supportRole);

    /**
     * 插入角色所属模块
     *
     * @param supportRoleModule
     */
    void createRoleModule(SupportRoleModule supportRoleModule);

    /**
     * 查询用户所属模块
     *
     * @param supportRole
     * @return
     */
    List<SupportRoleModule> findRoleModules(SupportRole supportRole);

    /**
     * 修改角色
     *
     * @param supportRole
     */
    void modifiedRole(SupportRole supportRole);

    /**
     * 删除已有权限
     *
     * @param supportRole
     */
    void deleteRoleModule(SupportRole supportRole);

    /**
     * 删除角色
     *
     * @param supportRole
     */
    void deleteRole(SupportRole supportRole);

    /**
     * 修改用户角色
     *
     * @param supportRole
     */
    void modifiedUserRole(SupportRole supportRole);
}
