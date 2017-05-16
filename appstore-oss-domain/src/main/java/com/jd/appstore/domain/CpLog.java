package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午7:05
 * To change this template use File | Settings | File Templates.
 * CP操作日志表
 */
public class CpLog implements Serializable{
    /**
     * CP操作日志表
     */
    private int id;
    /**
     * CP帐号Id
     */
    private int accountId;
    /**
     * 操作类型
     */
    private int operationType;
    /**
     * 操作时间
     */
    private Date operationTime;
    /**
     * IP
     */
    private String ip;
    /**
     * user agent
     */
    private String ua;
    /**
     * 系统备注
     */
    private String comment;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
