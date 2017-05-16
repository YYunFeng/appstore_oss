package com.jd.cms.domain.appManagement;

import java.io.Serializable;

/**
 * Created by YUNFENG on 14-3-14.
 */
public class ProvinceStatisRes implements Serializable {
    //      省份
    private String province;
    //      安装量
    private Integer intallTimes;
    //      日均活跃人数
    private Double intallSalerTimes;
    //      收入
    private Double income = 0.0;
    //      到达率
    private String arrRate = "0%";
    //      人均安装量
    private Double perInstallTimes;
    //      安装台数
    private Integer phoneTimes;
    //      渠道ID
    private Integer cid;
    //      到达数
    private Integer arrTimes;
    //      完成率
    private String completionRate = "0%";
    //      收入目标
    private Integer incomeTarget;
    //      部署人数
    private Integer deployPeople;
    //      日均活跃人数比例
    private String activeRatio = "0%";
    //      人均日安装台数
    private Double everyPerPhones = 0.0;
    //      人均日安装台数目标
    private Double everyPerPhonesTarget;

    //      台数到达率
    private String phoneCompletionRate = "0%";


    private Double recIncome;
    private Double needIncome;
    private Integer flag;


    public Integer getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(Integer phoneTimes) {
        this.phoneTimes = phoneTimes;
    }

    public Double getRecIncome() {
        return recIncome;
    }

    public void setRecIncome(Double recIncome) {
        this.recIncome = recIncome;
    }

    public Double getNeedIncome() {
        return needIncome;
    }

    public void setNeedIncome(Double needIncome) {
        this.needIncome = needIncome;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getIntallTimes() {
        return intallTimes;
    }

    public void setIntallTimes(Integer intallTimes) {
        this.intallTimes = intallTimes;
    }


    public Integer getArrTimes() {
        return arrTimes;
    }

    public void setArrTimes(Integer arrTimes) {
        this.arrTimes = arrTimes;
    }

    public Double getIntallSalerTimes() {
        return intallSalerTimes;
    }

    public void setIntallSalerTimes(Double intallSalerTimes) {
        this.intallSalerTimes = intallSalerTimes;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getArrRate() {
        return arrRate;
    }

    public void setArrRate(String arrRate) {
        this.arrRate = arrRate;
    }

    public Double getPerInstallTimes() {
        return perInstallTimes;
    }

    public void setPerInstallTimes(Double perInstallTimes) {
        this.perInstallTimes = perInstallTimes;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }


    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }

    public Integer getIncomeTarget() {
        return incomeTarget;
    }

    public void setIncomeTarget(Integer incomeTarget) {
        this.incomeTarget = incomeTarget;
    }

    public Integer getDeployPeople() {
        return deployPeople;
    }

    public void setDeployPeople(Integer deployPeople) {
        this.deployPeople = deployPeople;
    }

    public String getActiveRatio() {
        return activeRatio;
    }

    public void setActiveRatio(String activeRatio) {
        this.activeRatio = activeRatio;
    }

    public Double getEveryPerPhones() {
        return everyPerPhones;
    }

    public void setEveryPerPhones(Double everyPerPhones) {
        this.everyPerPhones = everyPerPhones;
    }

    public Double getEveryPerPhonesTarget() {
        return everyPerPhonesTarget;
    }

    public void setEveryPerPhonesTarget(Double everyPerPhonesTarget) {
        this.everyPerPhonesTarget = everyPerPhonesTarget;
    }

    public String getPhoneCompletionRate() {
        return phoneCompletionRate;
    }

    public void setPhoneCompletionRate(String phoneCompletionRate) {
        this.phoneCompletionRate = phoneCompletionRate;
    }
}
