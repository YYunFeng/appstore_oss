package com.jd.cms.domain.appManagement;

/**
 * Created by YYF on 14-5-9.
 */
public class ProvinceArrStatisParameter {
    private String startTime;
    private String endTime;
    private Integer cid;

    // 统计标示,如果是导出excel,0代表分页
    private Integer statsFlag;
    private Integer limit;
    private Integer offset;


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

    public Integer getStatsFlag() {
        return statsFlag;
    }

    public void setStatsFlag(Integer statsFlag) {
        this.statsFlag = statsFlag;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
