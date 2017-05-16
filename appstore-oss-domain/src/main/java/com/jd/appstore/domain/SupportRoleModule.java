package com.jd.appstore.domain;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-16
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 * 角色模块关联表
 */
public class SupportRoleModule implements Serializable {
    /**
     *ID
     */
    private int id;
    /**
     *角色ID
     */
    private int roleId;
    /**
     *授权的模块ID
     */
    private int moduleId;
    /**
     *记录创建时间
     */
    private int created;
    /**
     *记录修改时间
     */
    private int modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getModified() {
        return modified;
    }

    public void setModified(int modified) {
        this.modified = modified;
    }
}
