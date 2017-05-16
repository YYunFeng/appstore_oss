package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 * 运营支撑系统角色表
 */
public class SupportRole implements Serializable{
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 授权的模块ID
     */
    private int moduleId;
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

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
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
