package com.jd.cms.manager.usermanager;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.domain.usermanager.RoleManagerResult;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-15
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public interface RoleManager {
    /**
     * 查询角色列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PaginatedList<RoleManagerResult> findRoles(int pageIndex, int pageSize);

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
     * 添加角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    int createRole(SupportRole supportRole, String moduleList);

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
     * @param moduleList
     * @return
     */
    int doModifiedRole(SupportRole supportRole, String moduleList);

    /**
     * 删除角色
     *
     * @param supportRole
     * @return
     */
    int deleteRole(SupportRole supportRole);
}
