package com.jd.cms.domain.appManagement;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-24
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
public class DayIntallLog {
    private String dateTime;
    private int phoneTimes;
    private int shopTimes;
    private int appsTimes;
    private String phoneAverageInstallTimes; // 平均每台手机安装的应用数
    private String shopAverageInstallTimes; // 平均每个店的安装应用数

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getPhoneTimes() {
        return phoneTimes;
    }

    public void setPhoneTimes(int phoneTimes) {
        this.phoneTimes = phoneTimes;
    }

    public int getShopTimes() {
        return shopTimes;
    }

    public void setShopTimes(int shopTimes) {
        this.shopTimes = shopTimes;
    }

    public int getAppsTimes() {
        return appsTimes;
    }

    public void setAppsTimes(int appsTimes) {
        this.appsTimes = appsTimes;
    }

    public String getPhoneAverageInstallTimes() {
        return phoneAverageInstallTimes;
    }

    public void setPhoneAverageInstallTimes(String phoneAverageInstallTimes) {
        this.phoneAverageInstallTimes = phoneAverageInstallTimes;
    }

    public String getShopAverageInstallTimes() {
        return shopAverageInstallTimes;
    }

    public void setShopAverageInstallTimes(String shopAverageInstallTimes) {
        this.shopAverageInstallTimes = shopAverageInstallTimes;
    }
}
