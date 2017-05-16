package com.jd.cms.domain.clientmanager;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-9
 * Time: 下午2:08
 * To change this template use File | Settings | File Templates.
 */
public class ActivityChannel {
    private Integer Id;
    private Integer cId;
    private Integer activityId;
    private String cids;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
    }
}
