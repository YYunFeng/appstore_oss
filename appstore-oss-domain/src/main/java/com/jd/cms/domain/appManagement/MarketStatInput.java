package com.jd.cms.domain.appManagement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午4:29
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatInput {
    //  商品编号
    private Integer appId;
    //  统计开始日期
    private String startTime;
    //  统计结束日期
    private String endTime;
    //   渠道编号

    private Integer cid;
    //促销员编号
    private String saler;
    // 标示是离线还是在线 0:离线 1：在线
    private Integer flag;
    // 标示查询方法
    private Integer methodFlag;

    // 统计标示,如果是导出excel,0代表分页
    private Integer statsFlag;
    private Integer limit;
    private Integer offset;

    private String parentId;

    private Integer userCid;

    private Integer channelType;


    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getUserCid() {
        return userCid;
    }

    public void setUserCid(Integer userCid) {
        this.userCid = userCid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    private List<String> salerList;


    public List<String> getSalerList() {
        return salerList;
    }

    public void setSalerList(List<String> salerList) {
        this.salerList = salerList;
    }

    private String partisionsEndTime;

    public String getPartisionsEndTime() {
        return partisionsEndTime;
    }

    public void setPartisionsEndTime(String partisionsEndTime) {
        this.partisionsEndTime = partisionsEndTime;
    }

    public Integer getStatsFlag() {
        return statsFlag;
    }

    public void setStatsFlag(Integer statsFlag) {
        this.statsFlag = statsFlag;
    }

    public Integer getMethodFlag() {
        return methodFlag;
    }

    public void setMethodFlag(Integer methodFlag) {
        this.methodFlag = methodFlag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }


    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
