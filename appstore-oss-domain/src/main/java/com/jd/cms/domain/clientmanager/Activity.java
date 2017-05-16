package com.jd.cms.domain.clientmanager;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 上午11:54
 * To change this template use File | Settings | File Templates.
 */
public class Activity {
    private Integer Id;
    private String activityName;
    private String smallPic;
    private String largePic;
    private String fileUrl; // 附件路径
    private Integer seq;
    private Boolean pubedStatus;
    private Integer seqParameter;
    private Date created;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getSeqParameter() {
        return seqParameter;
    }

    public void setSeqParameter(Integer seqParameter) {
        this.seqParameter = seqParameter;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getLargePic() {
        return largePic;
    }

    public void setLargePic(String largePic) {
        this.largePic = largePic;
    }

    public Boolean getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(Boolean pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
