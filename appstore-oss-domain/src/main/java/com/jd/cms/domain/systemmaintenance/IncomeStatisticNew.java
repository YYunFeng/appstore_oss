package com.jd.cms.domain.systemmaintenance;

/**
 * YYF on 2015/5/19.
 */
public class IncomeStatisticNew {
    private String salerNo;
    private String salerName;
    private String shopName;
    private Integer salerType;
    private Integer appCounts;
    private Integer phoneCounts;
    private Integer arriveCounts;
    private Integer actCountsCompute;
    private Integer actCounts;
    private String installTime;

    private Integer channelType;


    private String cname;
    private Integer cid;


    public Integer getActCountsCompute() {
        return actCountsCompute;
    }

    public void setActCountsCompute(Integer actCountsCompute) {
        this.actCountsCompute = actCountsCompute;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getSalerType() {
        return salerType;
    }

    public void setSalerType(Integer salerType) {
        this.salerType = salerType;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getPhoneCounts() {
        return phoneCounts;
    }

    public void setPhoneCounts(Integer phoneCounts) {
        this.phoneCounts = phoneCounts;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Integer getArriveCounts() {
        return arriveCounts + getActCounts() + getActCountsCompute();
    }

    public void setArriveCounts(Integer arriveCounts) {
        this.arriveCounts = arriveCounts;
    }

    public Integer getActCounts() {
        return actCounts;
    }

    public void setActCounts(Integer actCounts) {
        this.actCounts = actCounts;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }
}
