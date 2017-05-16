package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午7:17
 * To change this template use File | Settings | File Templates.
 * 应用基本信息日志表
 */
public class AppLog implements Serializable {
    /**
     * 应用基本信息日志表主键
     */
    private Integer id;
    /**
     * 应用编号
     */
    private Integer appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * package名
     */
    private String appPackage;
    /**
     * 应用类型
     */
    private Integer appType;
    /**
     * 所属二级类目
     */
    private Integer categoryIdl2;
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
     * 基本信息审核状态
     */
    private Integer baseCheckStatus;
    /**
     * 基本信息同步ERP标记
     */
    private Integer baseSyncFlag;
    /**
     * 上下架同步ERP标记
     */
    private Integer onlineSyncFlag;
    /**
     * 上下架操作类型
     */
    private Integer onlineOptType;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getCategoryIdl2() {
        return categoryIdl2;
    }

    public void setCategoryIdl2(Integer categoryIdl2) {
        this.categoryIdl2 = categoryIdl2;
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

    public Integer getBaseCheckStatus() {
        return baseCheckStatus;
    }

    public void setBaseCheckStatus(Integer baseCheckStatus) {
        this.baseCheckStatus = baseCheckStatus;
    }

    public Integer getBaseSyncFlag() {
        return baseSyncFlag;
    }

    public void setBaseSyncFlag(Integer baseSyncFlag) {
        this.baseSyncFlag = baseSyncFlag;
    }

    public Integer getOnlineSyncFlag() {
        return onlineSyncFlag;
    }

    public void setOnlineSyncFlag(Integer onlineSyncFlag) {
        this.onlineSyncFlag = onlineSyncFlag;
    }

    public Integer getOnlineOptType() {
        return onlineOptType;
    }

    public void setOnlineOptType(Integer onlineOptType) {
        this.onlineOptType = onlineOptType;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AppLog");
        sb.append("{id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", appName='").append(appName).append('\'');
        sb.append(", appPackage='").append(appPackage).append('\'');
        sb.append(", appType=").append(appType);
        sb.append(", categoryIdl2=").append(categoryIdl2);
        sb.append(", categoryId1=").append(categoryId1);
        sb.append(", categoryId2=").append(categoryId2);
        sb.append(", defaultDetailId=").append(defaultDetailId);
        sb.append(", baseCheckStatus=").append(baseCheckStatus);
        sb.append(", baseSyncFlag=").append(baseSyncFlag);
        sb.append(", onlineSyncFlag=").append(onlineSyncFlag);
        sb.append(", onlineOptType=").append(onlineOptType);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append('}');
        return sb.toString();
    }
}
