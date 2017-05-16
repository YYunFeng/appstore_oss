package com.jd.cms.domain.cpQualityManagement;

import com.jd.common.util.base.BaseQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午11:28
 * CP资质管理条件集信息
 */
public class SelCpPageInPut extends BaseQuery implements Serializable{
    /**
     * 主键id
     */
    private int id;
    /**
     * 更新用主键id
     */
    private int upId;
    /**
     * CP登录账号
     */
    private String account;
    /**
     * 主键id集合
     */
    private String idList;
    /**
     * CP名称
     */
    private String cpName;
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
     * CP性质
     */
    private int cpProperty;
    /**
     * 账户开通状态
     * -1代表全部 用于SQL查询
     */
    private int accountStatus = -1;
    /**
     * 更新用账户开通状态
     */
    private int upAccountStatus;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 收费资质状态
     */
    private int feeStatus;
    /**
     * 更新用收费资质状态
     */
    private int upFeeStatus;
    /**
     * 合同号
     */
    private String contractNumber;
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
    private int defaultFeeMode;
    /**
     * 默认CP分成比例
     */
    private int defaultPercent;
    /**
     * 更新用合同号
     */
    private String upContractNumber;
    /**
     * 更新用CP登录账号
     */
    private String upAccount;
    /**
     * 更新用CP名称
     */
    private String upCpName;
    /**
     * 更新用供应商简码
     */
    private String upSupplierNo;

     /**
     * 更新用供应商名称
     */
    private String upSupplierName;
    /**
     * 更新用默认计费模式
     */
    private int upDefaultFeeMode;
    /**
     * 更新用默认CP分成比例
     */
    private int upDefaultPercent;
    /**
     * 更新用合同生效日期
     */
    private Date upValidPeriodBegin;
    /**
     * 更新用合同截止日期
     */
    private Date upValidPeriodEnd;
    /**
     * 证件号码
     */
    private String certificateNo;
    /**
     * 证件类型
     */
    private int certificateType;

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public int getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(int certificateType) {
        this.certificateType = certificateType;
    }

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public String getUpContractNumber() {
        return upContractNumber;
    }

    public void setUpContractNumber(String upContractNumber) {
        this.upContractNumber = upContractNumber;
    }

    public String getUpAccount() {
        return upAccount;
    }

    public void setUpAccount(String upAccount) {
        this.upAccount = upAccount;
    }

    public String getUpCpName() {
        return upCpName;
    }

    public void setUpCpName(String upCpName) {
        this.upCpName = upCpName;
    }

    public String getUpSupplierNo() {
        return upSupplierNo;
    }

    public void setUpSupplierNo(String upSupplierNo) {
        this.upSupplierNo = upSupplierNo;
    }

     public String getUpSupplierName() {
        return upSupplierName;
    }

    public void setUpSupplierName(String upSupplierName) {
        this.upSupplierName = upSupplierName;
    }

    public int getUpDefaultFeeMode() {
        return upDefaultFeeMode;
    }

    public void setUpDefaultFeeMode(int upDefaultFeeMode) {
        this.upDefaultFeeMode = upDefaultFeeMode;
    }

    public int getUpDefaultPercent() {
        return upDefaultPercent;
    }

    public void setUpDefaultPercent(int upDefaultPercent) {
        this.upDefaultPercent = upDefaultPercent;
    }

    public Date getUpValidPeriodBegin() {
        return upValidPeriodBegin;
    }

    public void setUpValidPeriodBegin(Date upValidPeriodBegin) {
        this.upValidPeriodBegin = upValidPeriodBegin;
    }

    public Date getUpValidPeriodEnd() {
        return upValidPeriodEnd;
    }

    public void setUpValidPeriodEnd(Date upValidPeriodEnd) {
        this.upValidPeriodEnd = upValidPeriodEnd;
    }

    public int getDefaultPercent() {
        return defaultPercent;
    }

    public void setDefaultPercent(int defaultPercent) {
        this.defaultPercent = defaultPercent;
    }

    public Date getValidPeriodBegin() {
        return validPeriodBegin;
    }

    public void setValidPeriodBegin(Date validPeriodBegin) {
        this.validPeriodBegin = validPeriodBegin;
    }

    public int getDefaultFeeMode() {
        return defaultFeeMode;
    }

    public void setDefaultFeeMode(int defaultFeeMode) {
        this.defaultFeeMode = defaultFeeMode;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getUpFeeStatus() {
        return upFeeStatus;
    }

    public void setUpFeeStatus(int upFeeStatus) {
        this.upFeeStatus = upFeeStatus;
    }

    public int getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(int feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getCpName() {

        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
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

    public int getCpProperty() {
        return cpProperty;
    }

    public void setCpProperty(int cpProperty) {
        this.cpProperty = cpProperty;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getUpAccountStatus() {
        return upAccountStatus;
    }

    public void setUpAccountStatus(int upAccountStatus) {
        this.upAccountStatus = upAccountStatus;
    }
}
