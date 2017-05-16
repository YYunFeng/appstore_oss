package com.jd.appstore.domain;

import java.util.Date;

/**
 * YYF on 2015/4/1.
 * <p/>
 * 促销员
 */
public class Saler {

    private String salerNo;
    private Integer cid;
    private String cname;
    private String salerName;
    private Integer channelType;
    private Integer salerType;
    private String parentId;
    private String shopName;
    // 上级促销员姓名
    private String parentName;
    private Date created;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }


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

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getSalerType() {
        return salerType;
    }

    public void setSalerType(Integer salerType) {
        this.salerType = salerType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
