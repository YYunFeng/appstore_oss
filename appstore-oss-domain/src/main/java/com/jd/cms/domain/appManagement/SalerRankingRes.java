package com.jd.cms.domain.appManagement;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-8
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */
public class SalerRankingRes {
    private String saler;
    private int phoneTimes;
    private int installTimes;
    // 是否排名
    private Boolean ranking;
    // 每台手机平均安装应用数
    private double averageInstallTimes;

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public int getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(int phoneTimes) {
        this.phoneTimes = phoneTimes;
    }

    public int getInstallTimes() {
        return installTimes;
    }

    public void setInstallTimes(int installTimes) {
        this.installTimes = installTimes;
    }

    public Boolean getRanking() {
        return ranking;
    }

    public void setRanking(Boolean ranking) {
        this.ranking = ranking;
    }

    public double getAverageInstallTimes() {
        return averageInstallTimes;
    }

    public void setAverageInstallTimes(double averageInstallTimes) {
        this.averageInstallTimes = averageInstallTimes;
    }
}
