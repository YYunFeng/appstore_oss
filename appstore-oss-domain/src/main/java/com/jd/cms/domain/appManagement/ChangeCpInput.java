package com.jd.cms.domain.appManagement;

/**
 * Created by YYF on 14-5-29.
 */
public class ChangeCpInput {
    private Integer currCpId;
    private Integer newCpId;
    private Integer appid;

    public Integer getCurrCpId() {
        return currCpId;
    }

    public void setCurrCpId(Integer currCpId) {
        this.currCpId = currCpId;
    }

    public Integer getNewCpId() {
        return newCpId;
    }

    public void setNewCpId(Integer newCpId) {
        this.newCpId = newCpId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }
}
