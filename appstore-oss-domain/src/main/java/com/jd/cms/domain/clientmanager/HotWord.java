package com.jd.cms.domain.clientmanager;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午6:27
 * To change this template use File | Settings | File Templates.
 */
public class HotWord {

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
    private Integer orderSeq;
    /**
     * 是否发布
     */
    private Integer published;
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

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
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
