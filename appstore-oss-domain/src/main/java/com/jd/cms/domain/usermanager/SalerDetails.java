package com.jd.cms.domain.usermanager;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-18
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetails {
    private Integer id;
    // 省份
    private String province;
    // 城市
    private String city;
    // 城市级别
    private String cityLevel;
    // 唯一码
    private String onlyCode;
    // 姓名
    private String userName;
    // 级别
    private String level;
    // 促销员类别
    private String salerCategory;
    // 入职时间
    private Date entryTime;
    // 负责门店
    private String shopName;
    // 门店编号
    private String shopNumber;
    // 门店目标等级
    private String phoneNumber;
    // 创建时间
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
    }

    public String getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSalerCategory() {
        return salerCategory;
    }

    public void setSalerCategory(String salerCategory) {
        this.salerCategory = salerCategory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
