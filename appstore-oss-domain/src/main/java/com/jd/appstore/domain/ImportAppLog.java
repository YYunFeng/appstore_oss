package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-15
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class ImportAppLog implements Serializable {
    /**
     * Id
     */
    private int id;
    /**
     * 运营支撑用户Id
     */
    private Integer adminId;
    /**
     * 导入CPId
     */
    private Integer cpAccount;
    /**
     * 导入应用类型
     */
    private Integer appType;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 已处理条数
     */
    private Integer processed;
    /**
     * 成功数
     */
    private Integer succeed;
    /**
     * 失败数
     */
    private Integer failed;
    /**
     * 生成的Url报告地址
     */
    private String excelUrl;
    /**
     * 处理结果
     */
    private Integer status;
    /**
     * 结果是否已下载
     */
    private Integer downloaded;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCpAccount() {
        return cpAccount;
    }

    public void setCpAccount(Integer cpAccount) {
        this.cpAccount = cpAccount;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    public Integer getSucceed() {
        return succeed;
    }

    public void setSucceed(Integer succeed) {
        this.succeed = succeed;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public String getExcelUrl() {
        return excelUrl;
    }

    public void setExcelUrl(String excelUrl) {
        this.excelUrl = excelUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Integer downloaded) {
        this.downloaded = downloaded;
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
