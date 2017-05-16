package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 * 专题内容表
 */
public class TopicApp implements Serializable {
    /**
     * 专题内容表主键
     */
    private int id;
    /**
     * 专题ID
     */
    private int topicId;
    /**
     * 应用编号
     */
    private int appId;
    /**
     * 应用发布状态
     */
    private int pubedStatus;
    /**
     * 发布时间
     */
    private Date pubTime;
    /**
     * 排序序号
     */
    private int orderSeq;

    /**
     * 是否激活
     */
    private Integer activation;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

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

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }
}
