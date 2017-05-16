package com.jd.cms.domain.usermanager;

import java.util.Date;

/**
 * Created by YUNFENG on 14-2-26.
 */
public class ChannelUser {
    private Integer id;
    private Integer cid;
    private Integer userId;
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
