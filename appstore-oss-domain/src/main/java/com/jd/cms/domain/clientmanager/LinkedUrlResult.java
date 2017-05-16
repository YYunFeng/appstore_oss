package com.jd.cms.domain.clientmanager;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-3
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public class LinkedUrlResult implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 链接完整url
     */
    private String url;

    /**

     * 版位
     */
    private Integer homeAreaPos;

    private Integer linkType;

    private Integer linkedAppId;
    /**
     * 是否是默认图片
     */
    private Integer isDefaultImg;
    /**
     * 是否是单品应用且为默认图片
     */
    private Integer isAppLogo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHomeAreaPos() {
        return homeAreaPos;
    }

    public void setHomeAreaPos(Integer homeAreaPos) {
        this.homeAreaPos = homeAreaPos;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public Integer getLinkedAppId() {
        return linkedAppId;
    }

    public void setLinkedAppId(Integer linkedAppId) {
        this.linkedAppId = linkedAppId;
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
