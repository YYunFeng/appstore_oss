package com.jd.cms.domain.clientmanager;

import java.util.Date;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CompulsoryApp {
    private Integer id;
    private String appid;
    private String channelId;
    private Date created;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
