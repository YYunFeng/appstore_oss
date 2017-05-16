package com.jd.cms.domain.appManagement;

import com.jd.common.util.base.BaseQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午11:28
 * 应用管理条件集信息
 */
public class AppPageInput extends BaseQuery implements Serializable {
    /**
     * Sql的免费条件
     */
    private int nullPrice;
    /**
     * 应用类型
     */
    private String type;
    /**
     * CP名称
     */
    private String cpName;

    /**
     * 版本号
     */
    private String versionName;
    /**
     * 主图相对URL
     */
    private String logoUrl;
    /**
     * 详情审核状态
     */
    private Integer updateStatus = -1;
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
    private int aid;
    /**
     * 应用详情id
     */
    private int did;
    /**
     * 应用编号
     */
    private int appid;
    /**
     * 售价
     */
    private int price;
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
     * 三级类目sql排除条件
     */
    private Integer category3 = -1;
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
     * 审核备注
     */
    private String comment;
    /**
     * 基本信息审核状态
     */
    private Integer baseCheckStatus;
    /**
     * 基本信息同步ERP标记
     */
    private Integer priceSyncFlag;
    /**
     * CP账号id
     */
    private int accountid;
    /**
     * 上下架状态
     */
    private int online;
    /**
     * 页面接受id集合
     */
    private String idList;
    /**
     * 应用类型
     * -1代表全部
     */
    private int appType = -1;
    /**
     * 管理员id
     */
    private String adminId;
    /**
     * 默认详情ID
     */
    private int defaultDetailId;
    /**
     * 基本信息同步ERP标记
     */
    private int baseSyncFlag;
    /**
     * 上下架同步ERP标记
     */
    private int onlineSyncFlag;
    /**
     * 上下架操作类型
     */
    private int onlineOptType;
    /**
     * 最新标记
     */
    private int newstFlag;
    /**
     * 资源类型
     */
    private int resType;
    /**
     * 请求Ip地址
     */
    private String Ip;
    /**
     * 多个资源类型
     */
    private String resTypeList;
    /**
     * 是否为资源副本
     */
    private int isCopy;
    /**
     * 父类目ID
     */
    private int parentId;
    /**
     * 是否应用主图
     */
    private Integer appLogo;


    /**
     * 卓望标示 ，1代表为卓望
     */
    private Integer zhuoWangMark;

    private String apkCode;


    // 新的CPID
    private Integer newCpId;


    public String getApkCode() {
        return apkCode;
    }

    public void setApkCode(String apkCode) {
        this.apkCode = apkCode;
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

    public int getCopy() {
        return isCopy;
    }

    public void setCopy(int copy) {
        isCopy = copy;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getIsCopy() {
        return isCopy;
    }

    public void setIsCopy(int isCopy) {
        this.isCopy = isCopy;
    }

    public String getResTypeList() {
        return resTypeList;
    }

    public void setResTypeList(String resTypeList) {
        this.resTypeList = resTypeList;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    public int getNewstFlag() {
        return newstFlag;
    }

    public void setNewstFlag(int newstFlag) {
        this.newstFlag = newstFlag;
    }

    public int getOnlineOptType() {
        return onlineOptType;
    }

    public void setOnlineOptType(int onlineOptType) {
        this.onlineOptType = onlineOptType;
    }

    public int getOnlineSyncFlag() {
        return onlineSyncFlag;
    }

    public void setOnlineSyncFlag(int onlineSyncFlag) {
        this.onlineSyncFlag = onlineSyncFlag;
    }

    public int getBaseSyncFlag() {
        return baseSyncFlag;
    }

    public void setBaseSyncFlag(int baseSyncFlag) {
        this.baseSyncFlag = baseSyncFlag;
    }

    private int valid;

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Integer getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Integer appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
*/

    public int getDefaultDetailId() {
        return defaultDetailId;
    }

    public void setDefaultDetailId(int defaultDetailId) {
        this.defaultDetailId = defaultDetailId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public Integer getCategory3() {
        return category3;
    }

    public void setCategory3(Integer category3) {
        this.category3 = category3;
    }

    public int getNullPrice() {
        return nullPrice;
    }

    public void setNullPrice(int nullPrice) {
        this.nullPrice = nullPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getBaseCheckStatus() {
        return baseCheckStatus;
    }

    public void setBaseCheckStatus(Integer baseCheckStatus) {
        this.baseCheckStatus = baseCheckStatus;
    }

    public Integer getPriceSyncFlag() {
        return priceSyncFlag;
    }

    public void setPriceSyncFlag(Integer priceSyncFlag) {
        this.priceSyncFlag = priceSyncFlag;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }


    public Integer getNewCpId() {
        return newCpId;
    }

    public void setNewCpId(Integer newCpId) {
        this.newCpId = newCpId;
    }
}
