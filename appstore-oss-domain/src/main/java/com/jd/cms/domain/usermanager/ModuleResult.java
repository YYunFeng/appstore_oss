package com.jd.cms.domain.usermanager;

import com.jd.appstore.domain.SupportModule;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-9-3
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 * 模块返回类
 */
public class ModuleResult implements Serializable {
    /**
    * 模块ID
    */
    private int moduleId;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 父ID
     */
    private int parentId;
    /**
     * 级别
     */
    private int level;
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
    /**
     *子级模块列表
     */
    private List<ModuleResult> chileModules;

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public List<ModuleResult> getChileModules() {
        return chileModules;
    }

    public void setChileModules(List<ModuleResult> chileModules) {
        this.chileModules = chileModules;
    }
}
