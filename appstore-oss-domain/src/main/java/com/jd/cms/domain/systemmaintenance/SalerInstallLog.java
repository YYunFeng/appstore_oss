package com.jd.cms.domain.systemmaintenance;

import java.util.Date;

/**
 * YYF on 2015/4/15.
 */
public class SalerInstallLog {

    private Integer id;
    private String deviceNo;
    private String salerNo;
    private String phoneImei;

    private Integer appid;
    private Date installTime;
    private Integer logType;// 0：wifi设备 1：pad设备
    private Date created;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }
}
