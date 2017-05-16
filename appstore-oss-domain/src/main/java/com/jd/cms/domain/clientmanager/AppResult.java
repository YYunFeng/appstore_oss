package com.jd.cms.domain.clientmanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-28
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public class AppResult implements Serializable{
    /**
     * 应用编号
     */
    private int appId;
    /**
     *应用名称
     */
    private String appName;
    /**
     *package名
     */
    private String pkg;
    /**
     *应用类型
     */
    private int appType;
    /**
     * 所属三级类目1
     */
    private Integer categoryId1;
    /**
     * 所属三级类目2
     */
    private Integer categoryId2;
    /**
     * 默认详情ID
     */
    private Integer defaultDetailId;
    /**
     * 应用上下架状态
     */
    private Integer online;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    /*
     * 应用资源图片
     */
    private String logo;

    private Date pubTime;

    private Integer appLogo;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Integer getDefaultDetailId() {
        return defaultDetailId;
    }

    public void setDefaultDetailId(Integer defaultDetailId) {
        this.defaultDetailId = defaultDetailId;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(Integer appLogo) {
        this.appLogo = appLogo;
    }
}

