package com.jd.appstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 12-7-4
 * Time: 下午6:42
 * CP基本信息表
 */
public class CpBaseInfo implements Serializable {
    /**
     * CP基本信息表主键
     */
    private int id;
    /**
     * CP登录帐号
     */
    private String accout;
     /**
     * 登录密码
     */
    private String password;
     /**
     * CP名称
     */
    private String cp_name;
     /**
     * 供应商简码
     */
    private String supper_no;
     /**
     * 注册时间
     */
    private Date reg_time;
     /**
     * CP性质
     */
    private int cp_property;
     /**
     *CP类型
     */
    private int cp_type;
     /**
     * 收费资质状态
     */
    private int fee_status;
     /**
     * 帐户开开通状态
     */
    private int account_status;
     /**
     *  注册信息更改状态
     */
    private int update_status;
     /**
     * 信息变更审核备注
     */
    private String update_commer;
    /**
     * 合同号
     */
    private String contract_number;
     /**
     * 合同生效时间
     */
    private Date valid_period_begin;
     /**
     * 合同失效时间
     */
    private Date valid_period_end;
     /**
     * 默认计费模式
     */
    private int default_fee_model;
     /**
     * 默认CP分成比例
     */
    private int default_percent;
     /**
     * 收费资质审核备注
     */
    private String comment;
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
     * 记录创建时间
     */
    private Date created;
     /**
     *记录修改时间
     */
    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCp_name() {
        return cp_name;
    }

    public void setCp_name(String cp_name) {
        this.cp_name = cp_name;
    }

    public String getSupper_no() {
        return supper_no;
    }

    public void setSupper_no(String supper_no) {
        this.supper_no = supper_no;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public int getCp_property() {
        return cp_property;
    }

    public void setCp_property(int cp_property) {
        this.cp_property = cp_property;
    }

    public int getCp_type() {
        return cp_type;
    }

    public void setCp_type(int cp_type) {
        this.cp_type = cp_type;
    }

    public int getFee_status() {
        return fee_status;
    }

    public void setFee_status(int fee_status) {
        this.fee_status = fee_status;
    }

    public int getAccount_status() {
        return account_status;
    }

    public void setAccount_status(int account_status) {
        this.account_status = account_status;
    }

    public int getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(int update_status) {
        this.update_status = update_status;
    }

    public String getUpdate_commer() {
        return update_commer;
    }

    public void setUpdate_commer(String update_commer) {
        this.update_commer = update_commer;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public Date getValid_period_begin() {
        return valid_period_begin;
    }

    public void setValid_period_begin(Date valid_period_begin) {
        this.valid_period_begin = valid_period_begin;
    }

    public Date getValid_period_end() {
        return valid_period_end;
    }

    public void setValid_period_end(Date valid_period_end) {
        this.valid_period_end = valid_period_end;
    }

    public int getDefault_fee_model() {
        return default_fee_model;
    }

    public void setDefault_fee_model(int default_fee_model) {
        this.default_fee_model = default_fee_model;
    }

    public int getDefault_percent() {
        return default_percent;
    }

    public void setDefault_percent(int default_percent) {
        this.default_percent = default_percent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
