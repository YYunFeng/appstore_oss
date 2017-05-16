package com.jd.cms.domain.systemmaintenance;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-23
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class ApkMessJSON implements Serializable {
    /**
     * apk版本号
     */
    private String version;
    /**
     * apk包名
     */
    private String packageName;
    /**
     * apk适配最低版本
     */
    private String minSdkVersion;
    /**
     * apk包的大小
     */
    private String size;
    /**
     * apk名称
     */
    private String apkName;

    private String versionCode;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(String minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
}
