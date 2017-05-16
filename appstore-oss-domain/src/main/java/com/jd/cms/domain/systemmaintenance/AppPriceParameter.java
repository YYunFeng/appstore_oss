package com.jd.cms.domain.systemmaintenance;

/**
 * Created by YUNFENG on 14-4-3.
 */
public class AppPriceParameter {
    private Integer chargeArea;
    private Integer chargeModel;
    private String appName;
    private Integer topicId;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getChargeArea() {
        return chargeArea;
    }

    public void setChargeArea(Integer chargeArea) {
        this.chargeArea = chargeArea;
    }

    public Integer getChargeModel() {
        return chargeModel;
    }

    public void setChargeModel(Integer chargeModel) {
        this.chargeModel = chargeModel;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
