package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午7:10
 * To change this template use File | Settings | File Templates.
 * 应用基本信息表
 */
public class Apps implements Serializable {
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
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;
    /**
     * 主图地址
     */
    private String logoUrl;
    /**
     * 是否是卓望接口导入的应用
     *  1表示是卓望接口导入的应用
     */
    private Integer zhuoWangMark;


    private List<AppResource> appResourceList;

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

     public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<AppResource> getAppResourceList() {
        return appResourceList;
    }

    public void setAppResourceList(List<AppResource> appResourceList) {
        this.appResourceList = appResourceList;
    }

    public Integer getZhuoWangMark() {
        return zhuoWangMark;
    }

    public void setZhuoWangMark(Integer zhuoWangMark) {
        this.zhuoWangMark = zhuoWangMark;
    }
}
