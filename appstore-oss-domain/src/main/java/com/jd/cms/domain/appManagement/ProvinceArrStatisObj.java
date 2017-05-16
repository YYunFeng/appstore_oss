package com.jd.cms.domain.appManagement;

/**
 * Created by YYF on 2014/7/1.
 */
public class ProvinceArrStatisObj {
    private Integer recCounts;
    private Integer needCounts;
    private String channelName;
    private Integer installCounts;
    private Integer arrCounts = 0;
    private String arrPercentage;


    private Integer cid;
    private String salerName;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public Integer getRecCounts() {
        return recCounts;
    }

    public void setRecCounts(Integer recCounts) {
        this.recCounts = recCounts;
    }

    public Integer getNeedCounts() {
        return needCounts;
    }

    public void setNeedCounts(Integer needCounts) {
        this.needCounts = needCounts;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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

    public String getArrPercentage() {
        return arrPercentage;
    }

    public void setArrPercentage(String arrPercentage) {
        this.arrPercentage = arrPercentage;
    }
}
