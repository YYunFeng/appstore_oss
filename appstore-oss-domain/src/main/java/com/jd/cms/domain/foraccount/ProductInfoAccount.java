package com.jd.cms.domain.foraccount;

/**
 * Package:com.jd.cms.domain.foraccount
 * User: yangkun
 * Date: 11-10-20
 * Time: 下午3:33
 * CopyRight:360buy
 * Descrption:   查询为后台提供的对象
 */
public class ProductInfoAccount {
    private Integer id;     //商品编码
    private String productName;     //商品名称
    private String venderCode;     //供应商编码
    private String venderName;     //供应商名称
    private Integer firstCatid;     //商品1级分类id
    private String firstCatName;     //商品1级分类名称
    private Integer sndCatid;     //商品2级分类id
    private String secondCatName;     //商品2级分类名称

    private String authBeginTime;     //授权开始日期
    private String authEndTime;     //授权结束日期
    private int divideType;     //分成类型

    private int buyoutPrice;     //买断价格

    private String isInvolve;     //是否参与供应商预付款结算
    private String divide;     //分成比例  如3:7
    private int prepayments;     //预付款

    private Integer percent;// 分成比例int
    public ProductInfoAccount() {
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getVenderCode() {
        return venderCode;
    }

    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public Integer getFirstCatid() {
        return firstCatid;
    }

    public void setFirstCatid(Integer firstCatid) {
        this.firstCatid = firstCatid;
    }

    public String getFirstCatName() {
        return firstCatName;
    }

    public void setFirstCatName(String firstCatName) {
        this.firstCatName = firstCatName;
    }



    public String getSecondCatName() {
        return secondCatName;
    }

    public void setSecondCatName(String secondCatName) {
        this.secondCatName = secondCatName;
    }


    public String getAuthBeginTime() {
        return authBeginTime;
    }

    public void setAuthBeginTime(String authBeginTime) {
        this.authBeginTime = authBeginTime;
    }

    public String getAuthEndTime() {
        return authEndTime;
    }

    public void setAuthEndTime(String authEndTime) {
        this.authEndTime = authEndTime;
    }

    public String getIsInvolve() {
        return isInvolve;
    }

    public void setIsInvolve(String isInvolve) {
        this.isInvolve = isInvolve;
    }

    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    public void setBuyoutPrice(int buyoutPrice) {
        this.buyoutPrice = buyoutPrice;
    }

    public int getDivideType() {
        return divideType;
    }

    public void setDivideType(int divideType) {
        this.divideType = divideType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getSndCatid() {
        return sndCatid;
    }

    public void setSndCatid(Integer sndCatid) {
        this.sndCatid = sndCatid;
    }

    public int getPrepayments() {
        return prepayments;
    }

    public void setPrepayments(int prepayments) {
        this.prepayments = prepayments;
    }


    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
