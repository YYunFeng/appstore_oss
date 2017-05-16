package com.jd.cms.domain.systemmaintenance;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-8
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangFullAppStatusJSON {
    private String code;
    private String mess;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
