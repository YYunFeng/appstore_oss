package com.jd.cms.domain.systemmaintenance;

import java.util.Date;

/**
 * User: YUNFENG
 * Date: 13-11-19
 * Time: 下午7:15
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLog {
    private Integer id;
    private String padImei;
    private String saler;
    private String exceptionMess;
    private Integer exceptionType;
    private Date created;

    public Integer getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPadImei() {
        return padImei;
    }

    public void setPadImei(String padImei) {
        this.padImei = padImei;
    }

    public String getExceptionMess() {
        return exceptionMess;
    }

    public void setExceptionMess(String exceptionMess) {
        this.exceptionMess = exceptionMess;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }
}
