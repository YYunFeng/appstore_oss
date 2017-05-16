package com.jd.cms.domain.systemmaintenance;

import com.jd.appstore.domain.AppResource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class Content implements Serializable {
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
     * 应用上下架状态
     */
    private Integer online;
    /**
     * 基本信息审核状态
     */
    private Integer baseCheckStatus;
    /**
     * 基本信息同步ERP状态
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
     * CP帐号Id
     */
    private Integer accountId;
    /**
     * 主图相对Url
     */
    private String logoUrl;
    /**
     * 上传后的主图的名称
     */
    private String newLogoUrl;
    /**
     * 应用包版本号
     */
    private String appVersion;
    /**
     * 应用包版本码
     */
    private Integer appVersionCode;
    /**
     * 适配的最低固件
     */
    private Integer osVersionId;
    /**
     * 安装包尺寸
     */
    private Integer pkgSize;
    /**
     * 发布时间
     */
    private Date pubTime;
    /**
     * 应用路径
     */
    private String appLink;
    /**
     * 应用介绍
     */
    private String appIntroduce;
    /**
     * 关键词
     */
    private String appTag;
    /**
     * 安装包名
     */
    private String apkName;
    /**
     * 导入状态 0:未导入  -1：导入失败   1：导入成功
     */
    private Integer status;
    /**
     * 导入结果信息
     */
    private String message;
    /**
     * 管理员Id
     */
    private String adminId;
    /**
     * 请求人Ip
     */
    private String ip;
    /**
     * 此应用的所有资源，包括截图，apk包
     */
    private List<AppResource> appResources;

    /**
     * WEB应用的宽
     */
    private String width;

    /**
     * WEB应用的高
     */
    private String height;

    private String apkCode;

    private Integer zhuoWangMark;

    public Integer getZhuoWangMark() {
        return zhuoWangMark;
    }

    public void setZhuoWangMark(Integer zhuoWangMark) {
        this.zhuoWangMark = zhuoWangMark;
    }

    public String getApkCode() {
        return apkCode;
    }

    public void setApkCode(String apkCode) {
        this.apkCode = apkCode;
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

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Integer getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Integer appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public Integer getOsVersionId() {
        return osVersionId;
    }

    public void setOsVersionId(Integer osVersionId) {
        this.osVersionId = osVersionId;
    }

    public Integer getPkgSize() {
        return pkgSize;
    }

    public void setPkgSize(Integer pkgSize) {
        this.pkgSize = pkgSize;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public String getAppTag() {
        return appTag;
    }

    public void setAppTag(String appTag) {
        this.appTag = appTag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getAppIntroduce() {
        return appIntroduce;
    }

    public void setAppIntroduce(String appIntroduce) {
        this.appIntroduce = appIntroduce;
    }

    public List<AppResource> getAppResources() {
        return appResources;
    }

    public void setAppResources(List<AppResource> appResources) {
        this.appResources = appResources;
    }

    public String getNewLogoUrl() {
        return newLogoUrl;
    }

    public void setNewLogoUrl(String newLogoUrl) {
        this.newLogoUrl = newLogoUrl;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
