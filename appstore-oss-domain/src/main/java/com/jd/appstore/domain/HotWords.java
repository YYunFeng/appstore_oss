package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-5
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 * 热门搜索词表
 */
public class HotWords implements Serializable{
    /**
     * 热门搜索词表主键
     */
    private int id;
    /**
     * 搜索词
     */
    private String word;
    /**
     * 排序序号
     */
    private int orderSeq;
    /**
     * 是否发布
     */
    private int published;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
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
