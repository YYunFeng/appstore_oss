package com.jd.cms.domain.taskmanager;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-9
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 * cp信息返回类
 */
public class CpInfoResult implements Serializable {
    /**
     * CP帐号ID
     */
    private int accountId;
    /**
     *是否发送预警邮件1
     */
    private Integer mailSent1;
    /**
     *是否发送预警邮件2
     */
    private Integer mailSent2;
    /**
     * 是否发送短信预警
     */
    private Integer smsSent2;
    /**
     *Email
     */
    private String email;
    /**
     *Email验证状态
     */
    private Integer emailChecked;
    /**
     * 手机
     */
    private String mobile;
    /**
     *手机绑定状态
     */
    private Integer mobileBinded;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Integer getMailSent1() {
        return mailSent1;
    }

    public void setMailSent1(Integer mailSent1) {
        this.mailSent1 = mailSent1;
    }

    public Integer getMailSent2() {
        return mailSent2;
    }

    public void setMailSent2(Integer mailSent2) {
        this.mailSent2 = mailSent2;
    }

    public Integer getSmsSent2() {
        return smsSent2;
    }

    public void setSmsSent2(Integer smsSent2) {
        this.smsSent2 = smsSent2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailChecked() {
        return emailChecked;
    }

    public void setEmailChecked(Integer emailChecked) {
        this.emailChecked = emailChecked;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getMobileBinded() {
        return mobileBinded;
    }

    public void setMobileBinded(Integer mobileBinded) {
        this.mobileBinded = mobileBinded;
    }
}
