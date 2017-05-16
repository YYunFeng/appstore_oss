package com.jd.cms.domain.systemmaintenance;

import com.jd.common.util.base.BaseQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: cuiyi
 * Date: 12-9-3
 * Time: 下午10:27
 * To change this template use File | Settings | File Templates.
 */
public class FeedBack extends BaseQuery implements Serializable{
    /**
     * id
     */
    private int id;
    /**
     * 反馈类型
     */
    private String ftype;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 反馈人
     */
    private String fuser;
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

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFuser() {
        return fuser;
    }

    public void setFuser(String fuser) {
        this.fuser = fuser;
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
