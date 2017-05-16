package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午11:04
 * To change this template use File | Settings | File Templates.
 * 特色开发商表
 */
public class FeaturedDeveloper implements Serializable {
    /**
     * 开发商ID
     */
    private int developerId;
    /**
     * 开发商类型
     */
    private int developerType;
    /**
     * 开发商名称
     */
    private String developerName;
    /**
     * 开发商logo URL
     */
    private String logoUrl;
    /**
     * 发布状态
     */
    private int pubedStatus;
    /**
     * 开发商介绍
     */
    private String intro;
    /**
     * 排序序号
     */
    private int orderSeq;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(int developerType) {
        this.developerType = developerType;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
