package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User: YYF
 * Date: 2012-7-05
 * Time: 15:06:33
 * @table tb_order
 * 订单表
 */
public class Order implements Serializable {
    /**
     * 订单编号
     */
    private int orderId;
    /**
     * 用户pin
     */
    private String pin;
    /**
     * 总金额
     */
    private int totalNumber;
    /**
     * 下单时间
     */
    private Date oederTime;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * 记录修改时间
     */
    private Date modified;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Date getOederTime() {
        return oederTime;
    }

    public void setOederTime(Date oederTime) {
        this.oederTime = oederTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
