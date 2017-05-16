package com.jd.cms.domain.appManagement;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatOutput {
    private Integer appId;
    private String appName;
    private String padName;
    private Integer cId;
    private String saler;
    private String logoUrl;
    private Integer zhuoWangMark;
    private Integer InstallTimes;
    private String dateTime;
    private String statisticName;
    private String salerName;
    private Integer phoneTimes;
    private String shopName;
    private String phoneNumber;
    private String level;
    private Integer activeDays;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(Integer activeDays) {
        this.activeDays = activeDays;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public Integer getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(Integer phoneTimes) {
        this.phoneTimes = phoneTimes;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getStatisticName() {
        return statisticName;
    }

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
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

    public String getPadName() {
        return padName;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public Integer getInstallTimes() {
        return InstallTimes;
    }

    public void setInstallTimes(Integer installTimes) {
        InstallTimes = installTimes;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getZhuoWangMark() {
        return zhuoWangMark;
    }

    public void setZhuoWangMark(Integer zhuoWangMark) {
        this.zhuoWangMark = zhuoWangMark;
    }
}
