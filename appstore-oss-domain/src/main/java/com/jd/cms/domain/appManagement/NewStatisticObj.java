package com.jd.cms.domain.appManagement;

/**
 * YYF on 2015/4/16.
 */
public class NewStatisticObj {
    // 安装的应用个数
    private Integer appCounts;
    // 安装的手机台数
    private Integer phoneCounts;
    // 应用名称
    private String appName;
    // 渠道名称
    private String cname;
    // 促销员编号
    private String salerNo;
    // 促销员名称
    private String salerName;
    // 促销员类型
    private Integer salerType;
    // 门店名称
    private String shopName;
    // 渠道ID
    private Integer cid;
    // 应用图标
    private String logoUrl;

    private Integer channelType;

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getPhoneCounts() {
        return phoneCounts;
    }

    public void setPhoneCounts(Integer phoneCounts) {
        this.phoneCounts = phoneCounts;
    }

    public Integer getAppCounts() {
        return appCounts;
    }

    public void setAppCounts(Integer appCounts) {
        this.appCounts = appCounts;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getSalerType() {
        return salerType;
    }

    public void setSalerType(Integer salerType) {
        this.salerType = salerType;
    }
}
