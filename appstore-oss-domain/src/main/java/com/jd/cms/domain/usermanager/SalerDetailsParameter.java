package com.jd.cms.domain.usermanager;

import com.jd.common.util.base.BaseQuery;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetailsParameter extends BaseQuery {
    private Integer cid;
    private Integer salerType;
    private Integer channelType;
    private String salerNo;

    private String onlyCode;
    private String userName;


    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSalerType() {
        return salerType;
    }

    public void setSalerType(Integer salerType) {
        this.salerType = salerType;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
