package com.jd.cms.domain.systemmaintenance;


/**
 * 按华盛应用和自有应用区分开
 */
public class IncomeResCompanyObj {

    private double huashengPrice;
    private double minePrice;


    public double getHuashengPrice() {
        return huashengPrice;
    }

    public void setHuashengPrice(double huashengPrice) {
        this.huashengPrice = huashengPrice;
    }

    public double getMinePrice() {
        return minePrice;
    }

    public void setMinePrice(double minePrice) {
        this.minePrice = minePrice;
    }
}
