package com.jd.cms.service.usermanager.impl;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.manager.usermanager.RoleManager;
import com.jd.cms.service.usermanager.RoleService;
import com.jd.common.web.result.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-15
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class RoleServiceImpl implements RoleService {
    /**
     * 角色管理Manager
     */
    private RoleManager roleManagerCached;

    /**
     * 查询角色列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result findRoles(int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("roles", roleManagerCached.findRoles(pageIndex, pageSize));
        return result;
    }

    /**
     * 初始化角色添加页
     *
     * @return
     */
    public Result findModules() {
        Result result = new Result();
        result.addDefaultModel("modules", roleManagerCached.findModules());
        return result;
    }

    /**
     * 查询角色是否存在
     *
     * @param supportRole
     * @return
     */
    public SupportRole checkedRole(SupportRole supportRole) {
        return roleManagerCached.checkedRole(supportRole);
    }

    /**
     * 添加角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int createRole(SupportRole supportRole, String moduleList) {
        return roleManagerCached.createRole(supportRole, moduleList);
    }

    /**
     * 初始化修改角色页
     *
     * @param supportRole
     * @return
     */
    public Result modifiedRole(SupportRole supportRole) {
        Result result = new Result();
        result.addDefaultModel("supportRole", supportRole);
        //查询所有模块
        result.addDefaultModel("modules", roleManagerCached.findModules());
        //查询用户所属模块
        result.addDefaultModel("roleModules", roleManagerCached.findRoleModules(supportRole));
        return result;
    }

    /**
     * 修改角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int doModifiedRole(SupportRole supportRole, String moduleList) {
        return roleManagerCached.doModifiedRole(supportRole, moduleList);
    }

    /**
     * 删除角色
     *
     * @param supportRole
     * @return
     */
    public int deleteRole(SupportRole supportRole) {
        return roleManagerCached.deleteRole(supportRole);
    }

    public void setRoleManagerCached(RoleManager roleManagerCached) {
        this.roleManagerCached = roleManagerCached;
    }
}
