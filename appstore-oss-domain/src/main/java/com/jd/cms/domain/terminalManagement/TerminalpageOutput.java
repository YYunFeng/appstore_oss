package com.jd.cms.domain.terminalManagement;

import com.jd.common.util.base.BaseQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午2:29
 * 返回终端信息管理结果集信息
 */
public class TerminalpageOutput extends BaseQuery implements Serializable{
    /**
     * OS版本ID
     */
    private int osVersionId;
    /**
     * 屏幕尺寸ID
     */
    private int screenSizeId;
    /**
     * OS版本名
     */
    private String osVersionName;
    /**
     * 屏幕尺寸名称
     */
    private String screenSizeName;
    /**
     * OS版本码
     */
    private int osVersionCode;
    /**
     * 备注
     */
    private String intro;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;
    /**
     * 上下状态架
     */
    private int online;

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getOsVersionId() {
        return osVersionId;
    }

    public void setOsVersionId(int osVersionId) {
        this.osVersionId = osVersionId;
    }

    public String getOsVersionName() {
        return osVersionName;
    }

    public void setOsVersionName(String osVersionName) {
        this.osVersionName = osVersionName;
    }

    public int getScreenSizeId() {
        return screenSizeId;
    }

    public void setScreenSizeId(int screenSizeId) {
        this.screenSizeId = screenSizeId;
    }

    public String getScreenSizeName() {
        return screenSizeName;
    }

    public void setScreenSizeName(String screenSizeName) {
        this.screenSizeName = screenSizeName;
    }

    public int getOsVersionCode() {
        return osVersionCode;
    }

    public void setOsVersionCode(int osVersionCode) {
        this.osVersionCode = osVersionCode;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
