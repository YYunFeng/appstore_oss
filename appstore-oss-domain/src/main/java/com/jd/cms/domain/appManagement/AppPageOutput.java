package com.jd.cms.domain.appManagement;

import com.jd.common.util.base.BaseQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午2:29
 * 返回应用管理结果集信息
 */
public class AppPageOutput extends BaseQuery implements Serializable {
    /**
     * CP名称
     */
    private String cpName;
    /**
     * 主图相对URL
     */
    private String logoUrl;
    /**
     * 详情审核状态
     */
    private Integer updateStatus;
    /**
     * 记录创建时间
     */
    private Date created;
    /**
     * package名
     */
    private String packageName;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 资源URL
     */
    private String resUrl;
    /**
     * 应用日志id
     */
    private Integer aid;
    /**
     * 应用详情id
     */
    private Integer did;


    /**
     * 默认应用详情id
     */
    private Integer defaultDetailId;


    /**
     * 应用编号
     */
    private Integer appid;
    /**
     * 售价
     */
    private Integer price;
    /**
     * 计费模式
     */
    private Integer feeMode;
    /**
     * CP分成比例1
     */
    private Integer percent;
    /**
     * 分成期限1开始
     */
    private Date period1Begin;
    /**
     * 分成期限1结束
     */
    private Date period1End;
    /**
     * CP分成比例2
     */
    private Integer percent2;
    /**
     * 分成期限2开始
     */
    private Date period2Begin;
    /**
     * 分成期限2结束
     */
    private Date period2End;
    /**
     * CP分成比例3
     */
    private Integer percent3;
    /**
     * 分成期限3开始
     */
    private Date period3Begin;
    /**
     * 分成期限3结束
     */
    private Date period3End;
    /**
     * 所属二级类目
     */
    private Integer categoryidl2;
    /**
     * 所属三级类目1
     */
    private Integer categoryid1;
    /**
     * 所属三级类目2
     */
    private Integer categoryid2;
    /**
     * 预付金额
     */
    private Integer prepay;
    /**
     * 买断金额
     */
    private Integer buyout;
    /**
     * 买断期限开始
     */
    private Date buyoutBegin;
    /**
     * 买断期限结束
     */
    private Date buyoutEnd;
    /**
     * 应用包版本号
     */
    private String appVersion;
    /**
     * 适配的最低固件
     */
    private Integer osVersionId;

    /**
     * 应用包版本码
     */
    private Integer appVersionCode;

    /**
     * 安装包尺寸
     */
    private Integer pkgSize;
    /**
     * 发布时间
     */
    private Date pubTime;
    /**
     * 广告语
     */
    private String adText;
    /**
     * 标签
     */
    private String appTag;
    /**
     * 新增功能介绍
     */
    private String newFeatures;
    /**
     * 应用介绍
     */
    private String appIntroduce;
    /**
     * 基本信息审核状态
     */
    private Integer baseCheckStatus;
    /**
     * 应用类型
     */
    private Integer appType;
    /**
     * 上下架状态
     */
    private int online;
    /**
     * 性质
     */
    private int nature;
    /**
     * 接收的应用上下架
     */
    private int aOnline;
    /**
     * 接收的详情上下架
     */
    private int dOnline;
    /**
     * 默认CP分成比例
     */
    private Integer defaultPercent;
    /**
     * 收费资质审核备注
     */
    private Date validPeriodBegin;
    /**
     * 合同截止日期
     */
    private Date validPeriodEnd;
    /**
     * 上下架同步ERP标记
     */
    private int onlineSyncFlag;
    /**
     * 上下架操作类型
     */
    private int onlineOptType;
    /**
     * 基本信息同步ERP标记
     */
    private int baseSyncFlag;
    /**
     * CP账号id
     */
    private int accountid;
    /**
     * 资源类型
     */
    private int resType;
    /**
     * 审核备注
     */
    private String comment;
    /**
     * 请求Ip地址
     */
    private String Ip;
    /**
     * 处理完的软件包大小
     */
    private String pkgSizeB;
    /**
     * 账户开通状态
     */
    private String accountStatus;
    /**
     * 是否应用主图
     */
    private Integer appLogo;

    /**
     *  卓望标示
     */
     private Integer zhuoWangMark;


    private String apkcode;

    public String getApkcode() {
        return apkcode;
    }

    public void setApkcode(String apkcode) {
        this.apkcode = apkcode;
    }

    public Integer getZhuoWangMark() {
        return zhuoWangMark;
    }

    public void setZhuoWangMark(Integer zhuoWangMark) {
        this.zhuoWangMark = zhuoWangMark;
    }

    public Integer getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(Integer appLogo) {
        this.appLogo = appLogo;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getPkgSizeB() {
        return pkgSizeB;
    }

    public void setPkgSizeB(String pkgSizeB) {
        this.pkgSizeB = pkgSizeB;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getBaseSyncFlag() {
        return baseSyncFlag;
    }

    public void setBaseSyncFlag(int baseSyncFlag) {
        this.baseSyncFlag = baseSyncFlag;
    }

    public int getOnlineSyncFlag() {
        return onlineSyncFlag;
    }

    public void setOnlineSyncFlag(int onlineSyncFlag) {
        this.onlineSyncFlag = onlineSyncFlag;
    }

    public int getOnlineOptType() {
        return onlineOptType;
    }

    public void setOnlineOptType(int onlineOptType) {
        this.onlineOptType = onlineOptType;
    }

    public Integer getDefaultPercent() {
        return defaultPercent;
    }

    public void setDefaultPercent(Integer defaultPercent) {
        this.defaultPercent = defaultPercent;
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

    public int getaOnline() {
        return aOnline;
    }

    public void setaOnline(int aOnline) {
        this.aOnline = aOnline;
    }

    public int getdOnline() {
        return dOnline;
    }

    public void setdOnline(int dOnline) {
        this.dOnline = dOnline;
    }

    public int getNature(){
        return nature;
    }
    public void setNature(int nature){
        this.nature = nature;
    }
    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getDefaultDetailId() {
        return defaultDetailId;
    }

    public void setDefaultDetailId(Integer defaultDetailId) {
        this.defaultDetailId = defaultDetailId;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(Integer feeMode) {
        this.feeMode = feeMode;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Date getPeriod1Begin() {
        return period1Begin;
    }

    public void setPeriod1Begin(Date period1Begin) {
        this.period1Begin = period1Begin;
    }

    public Date getPeriod1End() {
        return period1End;
    }

    public void setPeriod1End(Date period1End) {
        this.period1End = period1End;
    }

    public Integer getPercent2() {
        return percent2;
    }

    public void setPercent2(Integer percent2) {
        this.percent2 = percent2;
    }

    public Date getPeriod2Begin() {
        return period2Begin;
    }

    public void setPeriod2Begin(Date period2Begin) {
        this.period2Begin = period2Begin;
    }

    public Date getPeriod2End() {
        return period2End;
    }

    public void setPeriod2End(Date period2End) {
        this.period2End = period2End;
    }

    public Integer getPercent3() {
        return percent3;
    }

    public void setPercent3(Integer percent3) {
        this.percent3 = percent3;
    }

    public Date getPeriod3Begin() {
        return period3Begin;
    }

    public void setPeriod3Begin(Date period3Begin) {
        this.period3Begin = period3Begin;
    }

    public Date getPeriod3End() {
        return period3End;
    }

    public void setPeriod3End(Date period3End) {
        this.period3End = period3End;
    }

    public Integer getCategoryidl2() {
        return categoryidl2;
    }

    public void setCategoryidl2(Integer categoryidl2) {
        this.categoryidl2 = categoryidl2;
    }

    public Integer getCategoryid1() {
        return categoryid1;
    }

    public void setCategoryid1(Integer categoryid1) {
        this.categoryid1 = categoryid1;
    }

    public Integer getCategoryid2() {
        return categoryid2;
    }

    public void setCategoryid2(Integer categoryid2) {
        this.categoryid2 = categoryid2;
    }

    public Integer getPrepay() {
        return prepay;
    }

    public void setPrepay(Integer prepay) {
        this.prepay = prepay;
    }

    public Integer getBuyout() {
        return buyout;
    }

    public void setBuyout(Integer buyout) {
        this.buyout = buyout;
    }

    public Date getBuyoutBegin() {
        return buyoutBegin;
    }

    public void setBuyoutBegin(Date buyoutBegin) {
        this.buyoutBegin = buyoutBegin;
    }

    public Date getBuyoutEnd() {
        return buyoutEnd;
    }

    public void setBuyoutEnd(Date buyoutEnd) {
        this.buyoutEnd = buyoutEnd;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Integer getOsVersionId() {
        return osVersionId;
    }

    public void setOsVersionId(Integer osVersionId) {
        this.osVersionId = osVersionId;
    }

     public Integer getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Integer appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public Integer getPkgSize() {
        return pkgSize;
    }

    public void setPkgSize(Integer pkgSize) {
        this.pkgSize = pkgSize;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText;
    }

    public String getAppTag() {
        return appTag;
    }

    public void setAppTag(String appTag) {
        this.appTag = appTag;
    }

    public String getNewFeatures() {
        return newFeatures;
    }

    public void setNewFeatures(String newFeatures) {
        this.newFeatures = newFeatures;
    }

    public String getAppIntroduce() {
        return appIntroduce;
    }

    public void setAppIntroduce(String appIntroduce) {
        this.appIntroduce = appIntroduce;
    }

    public Integer getBaseCheckStatus() {
        return baseCheckStatus;
    }

    public void setBaseCheckStatus(Integer baseCheckStatus) {
        this.baseCheckStatus = baseCheckStatus;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}
