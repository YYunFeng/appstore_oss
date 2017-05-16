package com.jd.cms.domain.systemmaintenance;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-27.
 */
public class IncomeParameter {
    private String salerNo;
    private String installTime;
    private String appid;
    private String phoneImei;
    private Integer cid;

    private String startTime;
    private String endTime;


    private Integer channelType;

    // 标示导出文件是总公司还是省办的
    private Integer excelFlag;
    private Integer chargeCompany;

    private List<String> appids;

    private List<String> topicAppids;

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getChargeCompany() {
        return chargeCompany;
    }

    public void setChargeCompany(Integer chargeCompany) {
        this.chargeCompany = chargeCompany;
    }

    public Integer getExcelFlag() {
        return excelFlag;
    }

    public void setExcelFlag(Integer excelFlag) {
        this.excelFlag = excelFlag;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }


    public List<String> getAppids() {
        return appids;
    }

    public void setAppids(List<String> appids) {
        this.appids = appids;
    }

    public List<String> getTopicAppids() {
        return topicAppids;
    }

    public void setTopicAppids(List<String> topicAppids) {
        this.topicAppids = topicAppids;
    }
}
