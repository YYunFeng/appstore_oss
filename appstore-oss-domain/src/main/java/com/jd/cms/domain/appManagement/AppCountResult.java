package com.jd.cms.domain.appManagement;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class AppCountResult {
    private Integer cpId;
    private String account;
    private String appid;
    private String appName;
    private Integer installCounts = 0;
    private Integer countApps = 0;
    private String phoneImei;


    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getInstallCounts() {
        return installCounts;
    }

    public void setInstallCounts(Integer installCounts) {
        this.installCounts = installCounts;
    }

    public Integer getCountApps() {
        return countApps;
    }

    public void setCountApps(Integer countApps) {
        this.countApps = countApps;
    }
}
