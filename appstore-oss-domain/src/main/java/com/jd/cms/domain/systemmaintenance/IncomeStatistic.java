package com.jd.cms.domain.systemmaintenance;

import java.util.Date;

/**
 * Created by YUNFENG on 14-2-26.
 */
public class IncomeStatistic {

    private Integer id;
    // 数据库查询出来的结果集
    private Integer installAppsCounts;


    // 有效装机数量
    private Double vaildMachineCounts;
    // 精彩推荐应用安装数
    private Integer recommendAppCounts = 0;
    // 装机必备应用安装数
    private Integer needAppCounts = 0;
    // 公司精彩推荐应用收入
    private Double recommendAppIncomeForCompany = 0.0;
    // 省办精彩推荐应用收入
    private Double recommendAppIncomeForProvince = 0.0;
    // 公司装机必备应用收入
    private Double needAppIncomeForCompany = 0.0;
    // 省办装机必备应用收入
    private Double needAppIncomeForProvince = 0.0;
    // 总应用安装数量
    private Integer totalAppCount = 0;
    //总收入--公司
    private Double totalIncome;

    private Double totalIncomeProvince;


    private Integer huashengAppCounts;
    private Integer mineAppCounts;

    private String installTime;
    private String salerNo;
    private String salerName;
    private Integer cid;
    //  渠道名称
    private String cname;


    private Integer arrCounts;


    private Date created;

    // 安装的手机台数
    private Integer phoneInstallCounts;

    // 标识 0：精彩推荐 1：装机必备
    private Integer flag;


    public Double getTotalIncomeProvince() {
        return totalIncomeProvince;
    }

    public void setTotalIncomeProvince(Double totalIncomeProvince) {
        this.totalIncomeProvince = totalIncomeProvince;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getTotalAppCount() {
        return totalAppCount;
    }

    public void setTotalAppCount(Integer totalAppCount) {
        this.totalAppCount = totalAppCount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecommendAppCounts() {
        return recommendAppCounts;
    }

    public void setRecommendAppCounts(Integer recommendAppCounts) {
        this.recommendAppCounts = recommendAppCounts;
    }

    public Integer getNeedAppCounts() {
        return needAppCounts;
    }

    public void setNeedAppCounts(Integer needAppCounts) {
        this.needAppCounts = needAppCounts;
    }

    public Double getRecommendAppIncomeForCompany() {
        return recommendAppIncomeForCompany;
    }

    public void setRecommendAppIncomeForCompany(Double recommendAppIncomeForCompany) {
        this.recommendAppIncomeForCompany = recommendAppIncomeForCompany;
    }

    public Double getRecommendAppIncomeForProvince() {
        return recommendAppIncomeForProvince;
    }

    public void setRecommendAppIncomeForProvince(Double recommendAppIncomeForProvince) {
        this.recommendAppIncomeForProvince = recommendAppIncomeForProvince;
    }

    public Double getNeedAppIncomeForCompany() {
        return needAppIncomeForCompany;
    }

    public void setNeedAppIncomeForCompany(Double needAppIncomeForCompany) {
        this.needAppIncomeForCompany = needAppIncomeForCompany;
    }

    public Double getNeedAppIncomeForProvince() {
        return needAppIncomeForProvince;
    }

    public void setNeedAppIncomeForProvince(Double needAppIncomeForProvince) {
        this.needAppIncomeForProvince = needAppIncomeForProvince;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getVaildMachineCounts() {
        return vaildMachineCounts;
    }

    public void setVaildMachineCounts(Double vaildMachineCounts) {
        this.vaildMachineCounts = vaildMachineCounts;
    }

    public Integer getInstallAppsCounts() {
        return installAppsCounts;
    }

    public void setInstallAppsCounts(Integer installAppsCounts) {
        this.installAppsCounts = installAppsCounts;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getArrCounts() {
        return arrCounts;
    }

    public void setArrCounts(Integer arrCounts) {
        this.arrCounts = arrCounts;
    }

    public Integer getHuashengAppCounts() {
        return huashengAppCounts;
    }

    public void setHuashengAppCounts(Integer huashengAppCounts) {
        this.huashengAppCounts = huashengAppCounts;
    }

    public Integer getMineAppCounts() {
        return mineAppCounts;
    }

    public void setMineAppCounts(Integer mineAppCounts) {
        this.mineAppCounts = mineAppCounts;
    }

    public Integer getPhoneInstallCounts() {
        return phoneInstallCounts;
    }

    public void setPhoneInstallCounts(Integer phoneInstallCounts) {
        this.phoneInstallCounts = phoneInstallCounts;
    }
}
