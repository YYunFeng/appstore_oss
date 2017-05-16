package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 * 移动应用OS适配表
 */
public class AppOsAdapter implements Serializable{
    /**
     * 移动应用OS适配表主键
     */
    private int id;
    /**
     * 应用编号
     */
    private int appId;
    /**
     * 适配的OS版本ID
     */
    private int osVersionId;
    /**
     * 记录创建时间
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

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getOsVersionId() {
        return osVersionId;
    }

    public void setOsVersionId(int osVersionId) {
        this.osVersionId = osVersionId;
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
