package com.jd.cms.domain.clientmanager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class RecommendManagerResult implements Serializable{
    /**
     * id
     */
    private Integer id;
    /**
     * 客户端类型
     */
    private Integer clientType;
    /**
     * 所属模块
     */
    private Integer moduleId;
    /**
     * 所属区块
     */
    private Integer areaId;
    /**
     * 显示顺序
     */
    private Integer seq;
    /**
     * 图片url
     */
    private String url;
    /**
     * 链接类型
     */
    private Integer linkType;
    /**
     * 链接目标id
     */
    private Integer linkedAppId;


    /**
     * id>seq?
     */
    private String greater;

    /**
     * 链接完整url
     */
    private String linkedUrl;
    /**
     * 链接完整urlList
     */
    private List<LinkedUrlResult> linkedUrlList;
    /**
     * 发布状态
     */
    private Integer pubedStatus;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    /**
     * 版型
     */
    private Integer homeAreaType;

      /**

     * 版位
     */
    private Integer homeAreaPos;

    /**
     * 描述
     */
    private String intro;

    /*
     * 版型序号
     */

    private Integer homeAreaId;
    /**
     * 图片来源 1：默认  0：上传
     */
    private Integer defaultImg;
    /**
     * 是否是单品应用的默认图片 1：单品应用且是默认图片 0：其他
      */
    private Integer appLogo;

    public Integer getHomeAreaId() {
        return homeAreaId;
    }

    public void setHomeAreaId(Integer homeAreaId) {
        this.homeAreaId = homeAreaId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getGreater() {
        return greater;
    }

    public void setGreater(String greater) {
        this.greater = greater;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    public Integer getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(Integer pubedStatus) {
        this.pubedStatus = pubedStatus;
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

    public Integer getHomeAreaType() {
        return homeAreaType;
    }

    public void setHomeAreaType(Integer homeAreaType) {
        this.homeAreaType = homeAreaType;
    }

    public Integer getHomeAreaPos() {
        return homeAreaPos;
    }

    public void setHomeAreaPos(Integer homeAreaPos) {
        this.homeAreaPos = homeAreaPos;
    }

    public List<LinkedUrlResult> getLinkedUrlList() {
        return linkedUrlList;
    }

    public void setLinkedUrlList(List<LinkedUrlResult> linkedUrlList) {
        this.linkedUrlList = linkedUrlList;
    }

       public Integer getDefaultImg() {
           return defaultImg;
       }

       public void setDefaultImg(Integer defaultImg) {
           this.defaultImg = defaultImg;
       }

       public Integer getAppLogo() {
           return appLogo;
       }

       public void setAppLogo(Integer appLogo) {
           this.appLogo = appLogo;
       }
   }
