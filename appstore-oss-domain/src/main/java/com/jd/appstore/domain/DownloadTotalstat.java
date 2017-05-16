package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-23
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 * 应用下载汇总表
 */
public class DownloadTotalstat implements Serializable {
    /**
     *主键
     */
    private Integer id;
    /**
     *应用编号
     */
    private Integer appId;
    /**
     *总下载次数
     */
    private Integer downloadTimes;
    /**
     *记录创建时间
     */
    private Date created;
    /**
     *记录修改时间
     */
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
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
