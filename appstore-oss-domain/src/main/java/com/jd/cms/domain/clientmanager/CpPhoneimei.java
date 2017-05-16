package com.jd.cms.domain.clientmanager;

import java.util.Date;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class CpPhoneimei {
    private String phoneImei;
    private String appid;
    private Integer cpImportId;
    private Date activationTime;
    private Date created;

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Integer getCpImportId() {
        return cpImportId;
    }

    public void setCpImportId(Integer cpImportId) {
        this.cpImportId = cpImportId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
