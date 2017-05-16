package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.service.clientmanager.UploadService;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-7
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public class UploadServiceImpl implements UploadService {
    private String uploadReImagePath;
    private String uploadReAPKPath;
    private String androidDriverPath;
    private String uploadActivityPath;
    private String uploadTopicImagePath;
    private String androidCilentPath;
    private String suningPackAge;
    private String cpDateFile;

    public void setAndroidCilentPath(String androidCilentPath) {
        this.androidCilentPath = androidCilentPath;
    }

    public void setUploadTopicImagePath(String uploadTopicImagePath) {
        this.uploadTopicImagePath = uploadTopicImagePath;
    }

    public void setUploadReImagePath(String uploadReImagePath) {
        this.uploadReImagePath = uploadReImagePath;
    }

    public void setUploadReAPKPath(String uploadReAPKPath) {
        this.uploadReAPKPath = uploadReAPKPath;
    }

    public void setAndroidDriverPath(String androidDriverPath) {
        this.androidDriverPath = androidDriverPath;
    }

    public void setUploadActivityPath(String uploadActivityPath) {
        this.uploadActivityPath = uploadActivityPath;
    }

    public String getPicPath() {
        return uploadReImagePath;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getApkPath() {
        return uploadReAPKPath;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getTopPath() {
        return uploadTopicImagePath;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getActivity() {
        return uploadActivityPath;
    }

    public String getAndroidDriverPath() {
        return androidDriverPath;
    }

    public String getAndroidCilentPath() {
        return androidCilentPath;
    }

    public String getSuningPackAge() {
        return suningPackAge;
    }

    public void setSuningPackAge(String suningPackAge) {
        this.suningPackAge = suningPackAge;
    }

    public String getCpDateFile() {
        return cpDateFile;
    }

    public void setCpDateFile(String cpDateFile) {
        this.cpDateFile = cpDateFile;
    }
}
