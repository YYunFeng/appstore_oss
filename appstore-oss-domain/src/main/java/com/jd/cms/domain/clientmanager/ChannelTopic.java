package com.jd.cms.domain.clientmanager;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-1-25
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class ChannelTopic {
    private Integer id;
    private Integer cId;
    private String cids;
    private Integer topicId;
    private Integer topicSeq;
    private Integer[] channelIdses;
    private Date created;
    private Date modified;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicSeq() {
        return topicSeq;
    }

    public void setTopicSeq(Integer topicSeq) {
        this.topicSeq = topicSeq;
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

    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
    }

    public Integer[] getChannelIdses() {
        return channelIdses;
    }

    public void setChannelIdses(Integer[] channelIdses) {
        this.channelIdses = channelIdses;
    }
}
