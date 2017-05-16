package com.jd.appstore.domain;

/**
 * YYF on 2015/5/18.
 */
public class ArrAppObj {
    private String phoneImei;
    private String created;
    private Integer appid;

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }
}
