package com.jd.cms.domain.appManagement;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class SalerRankingParameter {
    //  统计开始日期
    private String startTime;
    //  统计结束日期
    private String endTime;

    private Integer averageInstallTimes;


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

    public Integer getAverageInstallTimes() {
        return averageInstallTimes;
    }

    public void setAverageInstallTimes(Integer averageInstallTimes) {
        this.averageInstallTimes = averageInstallTimes;
    }
}
