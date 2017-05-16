package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 * 终端屏幕类型表
 */
public class AndriodAppSrceenType implements Serializable{
    /**
     * 屏幕尺寸ID
     */
    private int screenSizeId;
    /**
     * 屏幕尺寸名称
     */
    private String screenSizeName;
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
