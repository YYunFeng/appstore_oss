package com.jd.cms.domain.clientmanager;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-8
 * Time: 下午7:43
 * To change this template use File | Settings | File Templates.
 */
public class ClientRecommend implements Serializable{
    private Integer id;
    private Integer linkType;
    private String url;
    private Integer linkedAppId;
    private String linkedUrl;
    private String intro;
    private String name;
    private String pname;
    private Integer seq;
    private Integer pubedStatus;
    private Integer isDefaultImg;
    private Integer isAppLogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLinkedAppId() {
        return linkedAppId;
    }

    public void setLinkedAppId(Integer linkedAppId) {
        this.linkedAppId = linkedAppId;
    }

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(Integer pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

     public Integer getIsDefaultImg() {
        return isDefaultImg;
    }

    public void setIsDefaultImg(Integer defaultImg) {
        isDefaultImg = defaultImg;
    }

    public Integer getIsAppLogo() {
        return isAppLogo;
    }

    public void setIsAppLogo(Integer appLogo) {
        isAppLogo = appLogo;
    }
}
