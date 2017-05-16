package com.jd.cms.domain.taskmanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-26
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 * 后台任务返回信息
 */
public class TaskInfoResult implements Serializable {
    /**
     *id
     */
    private int id;
    /**
     *任务类型id
     */
    private Integer taskTypeId;
    /**
     *任务类型名称
     */
    private String taskTypeName;
    /**
     * 关联业务id
     */
    private Integer relatedId;
    /**
     *状态
     */
    private Integer status;
    /**
     *发起人
     */
    private String adminId;
    /**
     * ip
     */
    private String ip;
    /**
     *计划启动时间
     */
    private Date startTimePlan;
    /**
     *实际启动时间
     */
    private Date startTimeFact;
    /**
     *系统备注
     */
    private String comment;
    /**
     *重试剩余次数
     */
    private Integer retryTimes;
    /**
     *是否需要自动重试
     */
    private Integer autoRetry;
    /**
     *是否周期重复
     */
    private Integer isLoop;
    /**
     *周期（分钟）
     */
    private String loopPeriod;
    /**
     *创建时间
     */
    private Date created;
    /**
     *修改时间
     */
    private Date modified;
     /**
     *应用ID
     */
    private Integer appId;
    /**
     *应用名称
     */
    private String appName;
//    /**
//     *应用图标
//     */
//    private String logoUrl;
//    /**
//     * 是否应用主图
//     */
//    private Integer appLogo;

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

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public Integer getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Integer relatedId) {
        this.relatedId = relatedId;
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

    public Integer getLoop() {
        return isLoop;
    }

    public void setLoop(Integer loop) {
        isLoop = loop;
    }

    public String getLoopPeriod() {
        return loopPeriod;
    }

    public void setLoopPeriod(String loopPeriod) {
        this.loopPeriod = loopPeriod;
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

//    public String getLogoUrl() {
//        return logoUrl;
//    }
//
//    public void setLogoUrl(String logoUrl) {
//        this.logoUrl = logoUrl;
//    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

//    public Integer getAppLogo() {
//        return appLogo;
//    }
//
//    public void setAppLogo(Integer appLogo) {
//        this.appLogo = appLogo;
//    }
}
