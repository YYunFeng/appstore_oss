package com.jd.cms.domain.appManagement;

import com.jd.common.util.base.BaseQuery;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class AppCountParameter extends BaseQuery {
    private String appid;
    private Integer accountId;
    private String startTime;
    private String endTime;
    private Integer flag;


    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
}
