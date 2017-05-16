package com.jd.cms.domain.systemmaintenance;

import java.util.Date;

/**
 * 公司应用价格设置
 */
public class AppPrice {
    private Integer id;
    private Integer chargeModel; // 计费模式：0：安装 1：激活 2：到达
    private String appid;
    private String appName;
    private Double price;
    private Integer chargeArea;  // 计费地区： 0 ：总公司 1：省办
    private String logoUrl;
    private Integer chargeCompany; // 计费所属公司： 0：华盛   1：自有

    private Date created;


    public Integer getChargeCompany() {
        return chargeCompany;
    }

    public void setChargeCompany(Integer chargeCompany) {
        this.chargeCompany = chargeCompany;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getChargeArea() {
        return chargeArea;
    }

    public void setChargeArea(Integer chargeArea) {
        this.chargeArea = chargeArea;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargeModel() {
        return chargeModel;
    }

    public void setChargeModel(Integer chargeModel) {
        this.chargeModel = chargeModel;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
