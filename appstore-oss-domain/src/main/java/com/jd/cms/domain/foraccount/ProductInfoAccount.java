package com.jd.cms.domain.foraccount;

/**
 * Package:com.jd.cms.domain.foraccount
 * User: yangkun
 * Date: 11-10-20
 * Time: ����3:33
 * CopyRight:360buy
 * Descrption:   ��ѯΪ��̨�ṩ�Ķ���
 */
public class ProductInfoAccount {
    private Integer id;     //��Ʒ����
    private String productName;     //��Ʒ����
    private String venderCode;     //��Ӧ�̱���
    private String venderName;     //��Ӧ������
    private Integer firstCatid;     //��Ʒ1������id
    private String firstCatName;     //��Ʒ1����������
    private Integer sndCatid;     //��Ʒ2������id
    private String secondCatName;     //��Ʒ2����������

    private String authBeginTime;     //��Ȩ��ʼ����
    private String authEndTime;     //��Ȩ��������
    private int divideType;     //�ֳ�����

    private int buyoutPrice;     //��ϼ۸�

    private String isInvolve;     //�Ƿ���빩Ӧ��Ԥ�������
    private String divide;     //�ֳɱ���  ��3:7
    private int prepayments;     //Ԥ����

    private Integer percent;// �ֳɱ���int
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
