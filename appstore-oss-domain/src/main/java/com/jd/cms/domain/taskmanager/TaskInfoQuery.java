package com.jd.cms.domain.taskmanager;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 * 后台任务查询条件
 */
public class TaskInfoQuery implements Serializable{
    /**
     *id
     */
    private int id;
    /**
     *任务类型id
     */
    private String taskTypeId;
    /**
     *状态
     */
    private int status;
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
    private int retryTimes;
    /**
     *修改时间
     */
    private Date modified;
    /**
     *是否周期重复
     */
    private int isLoop;
    /**
     *应用名称
     */
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getLoop() {
        return isLoop;
    }

    public void setLoop(int loop) {
        isLoop = loop;
    }
}
