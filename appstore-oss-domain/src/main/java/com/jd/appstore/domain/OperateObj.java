package com.jd.appstore.domain;

/**
 * 操作日志
 */
public class OperateObj {
    private Integer id;


    // 应用名称
    private String appName;
    private Integer appid;
    /**
     * 操作标示
     * 1：应用的上线 0：应用的下线 2：应用的新加,3：应用的移除
     */
    private Integer operateCode;
    // 操作时间
    private String operateTime;
    // 日志创建时间
    private String created;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getOperateCode() {
        return operateCode;
    }

    public void setOperateCode(Integer operateCode) {
        this.operateCode = operateCode;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
