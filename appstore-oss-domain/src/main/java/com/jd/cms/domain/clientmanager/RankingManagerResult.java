package com.jd.cms.domain.clientmanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
public class RankingManagerResult implements Serializable{
    /**
     * 应用排行榜表主键
     */
    private Integer id;
    /**
     * 排行榜类型
     */
    private Integer rankingStyle;
    /**
     * 排行榜分类
     */
    private Integer rankingType;
    /**
     * 应用编号
     */
    private Integer appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用图片
     */
    private String appUrl;
    /**
     * 上榜时间
     */
    private Date pubTime;
    /**
     * 排序序号
     */
    private Integer orderSeq;
    /**
     * 发布状态
     */
    private Integer pubedStatus;
    /**
     * 锁定位置
     */
    private Integer locked;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    private Integer appLogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRankingStyle() {
        return rankingStyle;
    }

    public void setRankingStyle(Integer rankingStyle) {
        this.rankingStyle = rankingStyle;
    }

    public Integer getRankingType() {
        return rankingType;
    }

    public void setRankingType(Integer rankingType) {
        this.rankingType = rankingType;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(Integer pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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

    public Integer getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(Integer appLogo) {
        this.appLogo = appLogo;
    }
}
