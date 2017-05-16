package com.jd.cms.domain.systemmaintenance;

import com.jd.common.util.base.BaseQuery;

/**
 * User: YUNFENG
 * Date: 13-11-21
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLogInput extends BaseQuery {
    private String padImei;
    private String saler;
    private Integer exceptionType;

    public Integer getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getPadImei() {
        return padImei;
    }

    public void setPadImei(String padImei) {
        this.padImei = padImei;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }
}
