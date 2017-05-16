package com.jd.cms.domain.statistics;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-11-14
 * Time: 下午2:11
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsOutput {
    private String dateTime;
    private Integer downloadTimes;
    private Integer appId;
    private String appName;
    private Integer allStatisticsCount;
    private Integer never7DaysStatisticsCount;

    public Integer getAllStatisticsCount() {
        return allStatisticsCount;
    }

    public void setAllStatisticsCount(Integer allStatisticsCount) {
        this.allStatisticsCount = allStatisticsCount;
    }

    public Integer getNever7DaysStatisticsCount() {
        return never7DaysStatisticsCount;
    }

    public void setNever7DaysStatisticsCount(Integer never7DaysStatisticsCount) {
        this.never7DaysStatisticsCount = never7DaysStatisticsCount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
