package com.jd.appstore.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-1-31
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class InstallStat {
    private Integer Id;
    private Integer appId;
    private Integer cid;
    private String saler;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer installTimes;
    private String phoneImei;
    private String salerName;
    private String shopName;
    private Date created;
    private Date modified;

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getInstallTimes() {
        return installTimes;
    }

    public void setInstallTimes(Integer installTimes) {
        this.installTimes = installTimes;
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
