package com.jd.cms.dao.usermanager.impl;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.dao.usermanager.RoleDao;
import com.jd.cms.domain.usermanager.RoleManagerResult;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-15
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class RoleDaoImpl extends BaseDao implements RoleDao {
    /**
     * 查询角色列表
     *
     * @param query
     * @return
     */
    public List<RoleManagerResult> findAccounts(Query query) {
        return queryForList("UserManager.findRoleManagerResult", query);
    }

    /**
     * 查询总记录数
     *
     * @return
     */
    public int getRolesCount() {
        return (Integer) queryForObject("UserManager.getRolesCount");
    }

    /**
     * 查询所有模块
     *
     * @return
     */
    public List<SupportModule> findModules() {
        return queryForList("UserManager.findSupportModules");
    }

    /**
     * 查询角色是否存在
     *
     * @param supportRole
     * @return
     */
    public SupportRole checkedRole(SupportRole supportRole) {
        return (SupportRole) queryForObject("UserManager.checkedRole", supportRole);
    }

    /**
     * 创建角色
     *
     * @param supportRole
     */
    public void createRole(SupportRole supportRole) {
        insert("UserManager.createSupportRole", supportRole);
    }

    /**
     * 插入角色所属模块
     *
     * @param supportRoleModule
     */
    public void createRoleModule(SupportRoleModule supportRoleModule) {
        insert("UserManager.createSupportRoleModule", supportRoleModule);
    }

    /**
     * 查询用户所属模块
     *
     * @param supportRole
     * @return
     */
    public List<SupportRoleModule> findRoleModules(SupportRole supportRole) {
        return queryForList("UserManager.findSupportRoleModule", supportRole);
    }

    /**
     * 修改角色
     *
     * @param supportRole
     */
    public void modifiedRole(SupportRole supportRole) {
        update("UserManager.modifiedSupportRole", supportRole);
    }

    /**
     * 删除已有权限
     *
     * @param supportRole
     */
    public void deleteRoleModule(SupportRole supportRole) {
        delete("UserManager.deleteSupportRoleModule", supportRole);
    }

    /**
     * 删除角色
     *
     * @param supportRole
     */
    public void deleteRole(SupportRole supportRole) {
        delete("UserManager.deleteSupportRole", supportRole);
    }

    /**
     * 修改用户角色
     *
     * @param supportRole
     */
    public void modifiedUserRole(SupportRole supportRole) {
        update("UserManager.modifiedUsersRole", supportRole);
    }

}
