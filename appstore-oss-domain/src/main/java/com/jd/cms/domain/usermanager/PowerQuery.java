package com.jd.cms.domain.usermanager;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-19
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 * 查询用户权限条件
 */
public class PowerQuery implements Serializable{
    /**
     * 用户名
     */
    private String account;
    /**
     * 模块URL
     */
    private String moduleUrl;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }
}
