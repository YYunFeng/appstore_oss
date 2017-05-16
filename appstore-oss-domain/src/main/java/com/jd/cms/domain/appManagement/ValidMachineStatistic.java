package com.jd.cms.domain.appManagement;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatistic {
    private Integer installAppsCounts;
    private Integer installPhoneCounts;
    private String salerNo;
    private String salerName;
    private String channelName;
    private Integer cid;
    private String shopName;
    private String time;
    // 0：代表精彩推荐，1：代表卖场专区
    private Integer flag;
    // 精彩推荐应用安装
    private Integer niceCount=0;
    // 卖场专区应用安装
    private Integer saleCount=0;
    // 精彩推荐收入金额
    private Double nicePrice;
    // 卖场专区收入金额
    private Double salePirce;
    // 总收入金额
    private Double totalPrice;
    // 总的应用安装数量
    private Integer totalAppCount;
    //  有效安装量
    private Double vaildInstallPhoneCounts;


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

    public Integer getNiceCount() {
        return niceCount;
    }

    public void setNiceCount(Integer niceCount) {
        this.niceCount = niceCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Double getNicePrice() {
        return nicePrice;
    }

    public void setNicePrice(Double nicePrice) {
        this.nicePrice = nicePrice;
    }

    public Double getSalePirce() {
        return salePirce;
    }

    public void setSalePirce(Double salePirce) {
        this.salePirce = salePirce;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Integer getInstallAppsCounts() {
        return installAppsCounts;
    }

    public void setInstallAppsCounts(Integer installAppsCounts) {
        this.installAppsCounts = installAppsCounts;
    }

    public Integer getInstallPhoneCounts() {
        return installPhoneCounts;
    }

    public void setInstallPhoneCounts(Integer installPhoneCounts) {
        this.installPhoneCounts = installPhoneCounts;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getVaildInstallPhoneCounts() {
        return vaildInstallPhoneCounts;
    }

    public void setVaildInstallPhoneCounts(Double vaildInstallPhoneCounts) {
        this.vaildInstallPhoneCounts = vaildInstallPhoneCounts;
    }


}