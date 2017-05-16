package com.jd.cms.domain.cpQualityManagement;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午2:29
 * 返回CP资质管理结果集信息
 */
public class SelCpPageOutPut implements Serializable{
    /**
     * 主键id
     */
    private int id;
    /**
     * CP名称
     */
    private String cpName;
    /**
     * CP性质
     */
    private Integer cpProperty;
    /**
     * 供应商简码
     */
    private String supplierNo;
    /**
     * 联系人姓名
     */
    private String contacter;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 账户开通状态
     */
    private Integer accountStatus;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * CP登录账号
     */
    private String account;
    /**
     * CP英文名
     */
    private String ename;
    /**
     * 网址
     */
    private String webadd;
    /**
     * 固定电话
     */
    private String phone;
    /**
     * 传真
     */
    private String fax;
    /**
     * Email
     */
    private String email;
    /**
     * 其它联系方式
     */
    private String otherContact;
    /**
     * 证件类型
     */
    private Integer certificateType;
    /**
     * 证件号码
     */
    private String certificateNo;
    /**
     * 证件图片
     */
    private String certificatePhoto;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 合同号
     */
    private String contractNumber;
    /**
     * 默认CP分成比例
     */
    private Integer defaultPercent;
    /**
     * 收费资质状态
     */
    private Integer feeStatus;

    /**
     * 合同生效日期
     */
    private Date validPeriodBegin;
    /**
     * 合同截止日期
     */
    private Date validPeriodEnd;
    /**
     * 收费资质审核备注
     */
    private String comment;
    /**
     * 默认计费模式
     */
    private Integer defaultFeeMode;
    /**
     * 通讯地址
     */
    private String address;
    /**
     * CP简介
     */
    private String intro;
    /**
     * 手机绑定状态
     */
    private Integer mobileBinded;
    /**
     * Email验证状态
     */
    private Integer emailChecked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public Integer getCpProperty() {
        return cpProperty;
    }

    public void setCpProperty(Integer cpProperty) {
        this.cpProperty = cpProperty;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getWebadd() {
        return webadd;
    }

    public void setWebadd(String webadd) {
        this.webadd = webadd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCertificatePhoto() {
        return certificatePhoto;
    }

    public void setCertificatePhoto(String certificatePhoto) {
        this.certificatePhoto = certificatePhoto;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getDefaultPercent() {
        return defaultPercent;
    }

    public void setDefaultPercent(Integer defaultPercent) {
        this.defaultPercent = defaultPercent;
    }

    public Integer getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Integer feeStatus) {
        this.feeStatus = feeStatus;
    }

    public Date getValidPeriodBegin() {
        return validPeriodBegin;
    }

    public void setValidPeriodBegin(Date validPeriodBegin) {
        this.validPeriodBegin = validPeriodBegin;
    }

    public Date getValidPeriodEnd() {
        return validPeriodEnd;
    }

    public void setValidPeriodEnd(Date validPeriodEnd) {
        this.validPeriodEnd = validPeriodEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDefaultFeeMode() {
        return defaultFeeMode;
    }

    public void setDefaultFeeMode(Integer defaultFeeMode) {
        this.defaultFeeMode = defaultFeeMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getMobileBinded() {
        return mobileBinded;
    }

    public void setMobileBinded(Integer mobileBinded) {
        this.mobileBinded = mobileBinded;
    }

    public Integer getEmailChecked() {
        return emailChecked;
    }

    public void setEmailChecked(Integer emailChecked) {
        this.emailChecked = emailChecked;
    }
}
