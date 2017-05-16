package com.jd.cms.domain.appManagement;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsParameter {
    private String startTime;
    private String endTime;
    private Integer cid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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
