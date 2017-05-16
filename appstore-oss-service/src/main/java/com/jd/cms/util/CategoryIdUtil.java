package com.jd.cms.util;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-10-22
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */
public class CategoryIdUtil {

    /**
     * 二级类目移动软件
     */
    private String mobileSoftId;
    /**
     * 二级类目移动游戏
     */
    private String mobileGameId;
    /**
     * 二级类目web应用
     */
    private String webAppId;

    public String getMobileSoftId() {
        return mobileSoftId;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public String getMobileGameId() {
        return mobileGameId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public String getWebAppId() {
        return webAppId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }
}
