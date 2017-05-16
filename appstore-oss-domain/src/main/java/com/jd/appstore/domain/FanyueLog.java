package com.jd.appstore.domain;

import java.util.Date;

/**
 * 调用帆悦到达数据接口日志
 * YYF on 2015/5/18.
 */
public class FanyueLog {
    private Integer id;
    //到达的手机台数
    private Integer arrivePhoneCounts;
    //到达的应用个数
    private Integer arriveAppCounts;
    //到达的时间
    private String arriveTime;
    // 文件保存路径
    private String arriveFile;
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArrivePhoneCounts() {
        return arrivePhoneCounts;
    }

    public void setArrivePhoneCounts(Integer arrivePhoneCounts) {
        this.arrivePhoneCounts = arrivePhoneCounts;
    }

    public Integer getArriveAppCounts() {
        return arriveAppCounts;
    }

    public void setArriveAppCounts(Integer arriveAppCounts) {
        this.arriveAppCounts = arriveAppCounts;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveFile() {
        return arriveFile;
    }

    public void setArriveFile(String arriveFile) {
        this.arriveFile = arriveFile;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
