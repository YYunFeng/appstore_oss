package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 * 推广内容表
 */
public class Recommend implements Serializable{
    /**
     * id
     */
    private int id;
    /**
     * 客户端类型
     */
    private int clientType;
    /**
     * 所属模块
     */
    private int moduleId;
    /**
     * 所属区块
     */
    private int areaId;
    /**
     * 显示顺序
     */
    private int seq;
    /**
     * 图片url
     */
    private String url;
    /**
     * 链接类型
     */
    private int linkType;
    /**
     * 链接目标id
     */
    private int linkedAppId;
    /**
     * 链接完整url
     */
    private String linkedUrl;
    /**
     * 发布状态
     */
    private int pubedStatus;
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

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public int getLinkedAppId() {
        return linkedAppId;
    }

    public void setLinkedAppId(int linkedAppId) {
        this.linkedAppId = linkedAppId;
    }

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
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
