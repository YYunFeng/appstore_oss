package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 * 应用排行榜表
 */
public class RankingApp implements Serializable{
    /**
     * 应用排行榜表主键
     */
    private int id;
    /**
     * 排行榜类型
     */
    private int rankingStyle;
    /**
     * 排行榜分类
     */
    private int rankingType;
    /**
     * 应用编号
     */
    private int appId;
    /**
     * 上榜时间
     */
    private Date pubTime;
    /**
     * 排序序号
     */
    private int orderSeq;
    /**
     * 发布状态
     */
    private int pubedStatus;
    /**
     * 锁定位置
     */
    private int locked;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;
    /**
     * 已锁定排行记录
     */
    private String lockedOrder;

    public String getLockedOrder() {
        return lockedOrder;
    }

    public void setLockedOrder(String lockedOrder) {
        this.lockedOrder = lockedOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRankingStyle() {
        return rankingStyle;
    }

    public void setRankingStyle(int rankingStyle) {
        this.rankingStyle = rankingStyle;
    }

    public int getRankingType() {
        return rankingType;
    }

    public void setRankingType(int rankingType) {
        this.rankingType = rankingType;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
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

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
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
}
