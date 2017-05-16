package com.jd.cms.domain.usermanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-15
 * Time: 下午3:14
 * To change this template use File | Settings | File Templates.
 * 返回角色及角色下模块信息
 */
public class RoleManagerResult implements Serializable{
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}
