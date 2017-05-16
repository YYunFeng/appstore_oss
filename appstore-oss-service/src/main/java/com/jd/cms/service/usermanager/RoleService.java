package com.jd.cms.service.usermanager;

import com.jd.appstore.domain.SupportRole;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-15
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public interface RoleService {
    /**
     * 查询角色列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result findRoles(int pageIndex, int pageSize);

    /**
     * 初始化角色添加页
     *
     * @return
     */
    Result findModules();

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
     * 初始化修改角色页
     *
     * @param supportRole
     * @return
     */
    Result modifiedRole(SupportRole supportRole);

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
