package com.jd.appstore.domain.utils;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-1-10
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
public class FilePathUtils {
    // 安卓文件存放路径
    private String androidApkPath;
    // swf 文件存放路径
    private String webSwfPath;
    // 主图文件存放路径
    private String coverPicPath;
    // 截图文件存放路径
    private String imgPicPath;
   // 推荐图片存放路径
    private String recImagePath;

    public String getRecImagePath() {
        return recImagePath;
    }

    public void setRecImagePath(String recImagePath) {
        this.recImagePath = recImagePath;
    }

    public String getAndroidApkPath() {
        return androidApkPath;
    }

    public void setAndroidApkPath(String androidApkPath) {
        this.androidApkPath = androidApkPath;
    }

    public String getWebSwfPath() {
        return webSwfPath;
    }

    public void setWebSwfPath(String webSwfPath) {
        this.webSwfPath = webSwfPath;
    }

    public String getCoverPicPath() {
        return coverPicPath;
    }

    public void setCoverPicPath(String coverPicPath) {
        this.coverPicPath = coverPicPath;
    }

    public String getImgPicPath() {
        return imgPicPath;
    }

    public void setImgPicPath(String imgPicPath) {
        this.imgPicPath = imgPicPath;
    }
}
