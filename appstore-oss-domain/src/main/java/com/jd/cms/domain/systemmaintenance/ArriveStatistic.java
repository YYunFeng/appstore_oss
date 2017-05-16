package com.jd.cms.domain.systemmaintenance;

import java.util.Date;

/**
 * YYF on 2015/4/28.
 */
public class ArriveStatistic {
    private Integer id;
    private String salerNo;
    private Integer appCounts;
    private Integer phoneCounts;
    private Integer arrCounts;
    private Date installTime;
    private Date created;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public Integer getAppCounts() {
        return appCounts;
    }

    public void setAppCounts(Integer appCounts) {
        this.appCounts = appCounts;
    }

    public Integer getPhoneCounts() {
        return phoneCounts;
    }

    public void setPhoneCounts(Integer phoneCounts) {
        this.phoneCounts = phoneCounts;
    }

    public Integer getArrCounts() {
        return arrCounts;
    }

    public void setArrCounts(Integer arrCounts) {
        this.arrCounts = arrCounts;
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
}
