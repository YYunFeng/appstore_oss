package com.jd.cms.domain.appManagement;

/**
 * Created by YUNFENG on 14-3-31.
 */
public class InstaisticNorm {
    private Integer id;

    private Integer cid;
    //      收入目标
    private Integer incomeTarget;
    //     部署人数
    private Integer deployPeople;
    //    人均日安装台数目标
    private Double everyPerphonesTarget;
    //  统计时间
    private String time;

    // 渠道名称
    private String cname;


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getIncomeTarget() {
        return incomeTarget;
    }

    public void setIncomeTarget(Integer incomeTarget) {
        this.incomeTarget = incomeTarget;
    }

    public Integer getDeployPeople() {
        return deployPeople;
    }

    public void setDeployPeople(Integer deployPeople) {
        this.deployPeople = deployPeople;
    }

    public Double getEveryPerphonesTarget() {
        return everyPerphonesTarget;
    }

    public void setEveryPerphonesTarget(Double everyPerphonesTarget) {
        this.everyPerphonesTarget = everyPerphonesTarget;
    }
}
