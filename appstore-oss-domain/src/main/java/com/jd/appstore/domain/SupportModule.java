package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 * 运营支撑系统功能模块表
 */
public class SupportModule implements Serializable{
    /**
     * 模块ID
     */
    private int moduleId;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 功能说明
     */
    private String moduleIntro;
    /**
     * 模块状态
     */
    private int moduleStatus;
    /**
     * 模块URL
     */
    private String moduleUrl;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleIntro() {
        return moduleIntro;
    }

    public void setModuleIntro(String moduleIntro) {
        this.moduleIntro = moduleIntro;
    }

    public int getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(int moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
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
