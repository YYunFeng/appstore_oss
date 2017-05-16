package com.jd.cms.domain.clientmanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-31
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class TopicAppResult implements Serializable {
    private int id;
    private int topicId;
    private int appId;
    private String appName;
    private String appLogo;
    private int pubedStatus;
    private Integer activation;
    private Date pubTime;
    private int orderSeq;
    private Date created;
    private Date modified;
    private Integer appLogoIs;

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
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

    public Integer getAppLogoIs() {
        return appLogoIs;
    }

    public void setAppLogoIs(Integer appLogoIs) {
        this.appLogoIs = appLogoIs;
    }
}
