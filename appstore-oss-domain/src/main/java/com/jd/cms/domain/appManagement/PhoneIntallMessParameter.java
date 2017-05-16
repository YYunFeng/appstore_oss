package com.jd.cms.domain.appManagement;

import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-17.
 */
public class PhoneIntallMessParameter extends BaseQuery {
    private String province;
    private String phoneImei;
    private String phoneModelName;
    private String saleName;
    private String appName;
    private String startTime;
    private String endTime;
    private Integer cid;
    private List<Integer> appids;

    private Integer flag;

    public List<Integer> getAppids() {
        return appids;
    }

    public void setAppids(List<Integer> appids) {
        this.appids = appids;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public String getPhoneModelName() {
        return phoneModelName;
    }

    public void setPhoneModelName(String phoneModelName) {
        this.phoneModelName = phoneModelName;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
