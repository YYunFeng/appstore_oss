package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午7:57
 * To change this template use File | Settings | File Templates.
 * 后台任务表
 */
public class BackendTask implements Serializable{
    /**
     * 后台任务表主键
     */
    private int id;
    /**
     * modified
     */
    private Integer taskTypeId;
    /**
     * 关联业务id
     */
    private Integer relatedId;
    /**
     * 关联业务类型
     */
    private Integer relatedType;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 发起人
     */
    private String adminId;
    /**
     * 发起人ip地址
     */
    private String ip;
    /**
     * 计划启动时间
     */
    private Date startTimePlan;
    /**
     * 实际启动时间
     */
    private Date startTimeFact;
    /**
     * 系统备注
     */
    private String comment;
    /**
     * 重试剩余次数
     */
    private Integer retryTimes;
    /**
     * 是否需要自动重试
     */
    private Integer autoRetry;
    /**
     * 创建时间
     */
    private Date created;

    /**
     * 修改时间
     */
    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Integer getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
    }

    public Integer getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(Integer relatedType) {
        this.relatedType = relatedType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getStartTimePlan() {
        return startTimePlan;
    }

    public void setStartTimePlan(Date startTimePlan) {
        this.startTimePlan = startTimePlan;
    }

    public Date getStartTimeFact() {
        return startTimeFact;
    }

    public void setStartTimeFact(Date startTimeFact) {
        this.startTimeFact = startTimeFact;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Integer getAutoRetry() {
        return autoRetry;
    }

    public void setAutoRetry(Integer autoRetry) {
        this.autoRetry = autoRetry;
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
