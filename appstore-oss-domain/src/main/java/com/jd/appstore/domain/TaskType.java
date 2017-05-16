package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public class TaskType implements Serializable{
    /**
     * 任务类型id
     */
    private int taskTypeId;
    /**
     * 任务类型名称
     */
    private String taskTypeName;
    /**
     * 是否周期重复
     */
    private int isLoop;
    /**
     * 周期（分钟）
     */
    private int loopPeriod;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public int getLoop() {
        return isLoop;
    }

    public void setLoop(int loop) {
        isLoop = loop;
    }

    public int getLoopPeriod() {
        return loopPeriod;
    }

    public void setLoopPeriod(int loopPeriod) {
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
}
