package com.jd.cms.domain.usermanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午8:19
 * 返回用户账号结果集信息
 */
public class AccountManagerResult implements Serializable {
    /**
     * 运营支撑系统用户表主键
     */
    private int id;
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色ID
     */
    private int roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 账户状态
     */
    private int accountStatus;
    /**
     *记录创建时间
     */
    private Date created;
      /**
     * 记录修改时间
     */
    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
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
