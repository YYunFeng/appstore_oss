package com.jd.cms.domain.cpQualityManagement;

import com.jd.common.util.base.BaseQuery;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-1-23
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
public class PadChannel extends BaseQuery {
    // 渠道名称
    private String cname;
    // 渠道说明
    private String intro;
    // 渠道的创建时间
    private Date created;
    // 关联的CP id
    private String cpId;
    // 关联的CP名称
    private String cpName;
    // 关联的CP-渠道关联ID
    private String ccId;
    // 网关地址前缀
    private String gw;

    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getGw() {
        return gw;
    }

    public void setGw(String gw) {
        this.gw = gw;
    }
}
