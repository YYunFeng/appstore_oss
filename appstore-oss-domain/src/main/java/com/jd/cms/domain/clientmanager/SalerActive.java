package com.jd.cms.domain.clientmanager;

/**
 * Created by YYF on 14-5-9.
 */
public class SalerActive {
    private Integer activeDays;
    private Integer phoneTimes;
    private String saler;
    private String salerName;
    private String channelName;
    private String activeDayPercentage;
    private Integer installCounts; // 安装的应用数
    private Integer arrCounts;  // 应用到达数
    private String arrPercentage;// 应用到达率


    public String getArrPercentage() {
        return arrPercentage;
    }

    public void setArrPercentage(String arrPercentage) {
        this.arrPercentage = arrPercentage;
    }

    public Integer getInstallCounts() {
        return installCounts;
    }

    public void setInstallCounts(Integer installCounts) {
        this.installCounts = installCounts;
    }

    public Integer getArrCounts() {
        return arrCounts;
    }

    public void setArrCounts(Integer arrCounts) {
        this.arrCounts = arrCounts;
    }

    public String getActiveDayPercentage() {
        return activeDayPercentage;
    }

    public void setActiveDayPercentage(String activeDayPercentage) {
        this.activeDayPercentage = activeDayPercentage;
    }

    public Integer getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(Integer activeDays) {
        this.activeDays = activeDays;
    }

    public Integer getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(Integer phoneTimes) {
        this.phoneTimes = phoneTimes;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
