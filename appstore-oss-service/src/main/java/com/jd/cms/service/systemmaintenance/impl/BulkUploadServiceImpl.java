package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.cms.manager.systemmaintenance.BulkUploadManager;
import com.jd.cms.service.systemmaintenance.BulkUploadService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class BulkUploadServiceImpl implements BulkUploadService{
    private BulkUploadManager bulkUploadManager;
    private String uploadExcelPath;
    private String uploadReAPKPath;
    private String uploadCoverPicPath;
    private String uploadImgPicPath;

    public String getUploadImgPicPath() {
        return uploadImgPicPath;
    }

    public void setUploadImgPicPath(String uploadImgPicPath) {
        this.uploadImgPicPath = uploadImgPicPath;
    }

    public void setUploadCoverPicPath(String uploadCoverPicPath) {
        this.uploadCoverPicPath = uploadCoverPicPath;
    }

    public void setUploadReAPKPath(String uploadReAPKPath) {
        this.uploadReAPKPath = uploadReAPKPath;
    }

    public void setUploadExcelPath(String uploadExcelPath) {
        this.uploadExcelPath = uploadExcelPath;
    }

    public BulkUploadManager getBulkUploadManager() {
        return bulkUploadManager;
    }

    public void setBulkUploadManager(BulkUploadManager bulkUploadManager) {
        this.bulkUploadManager = bulkUploadManager;
    }

    public Result findCPBaseInfoList() {
        Result result = new Result();
        result.addDefaultModel("cpBaseList", bulkUploadManager.findCPBaseInfoList());
        result.setSuccess(true);
        return result;
    }

    public Result findCpList(int pageIndex, int pageSize, String cpName) {
        Result result = new Result();
        result.addDefaultModel("cpBaseInfos", bulkUploadManager.findCPList(pageIndex,pageSize,cpName));
        result.setSuccess(true);
        return result;
    }

    public Result loadUpload(String account) {
        Result result = new Result();
        result.addDefaultModel("importLog", bulkUploadManager.loadUpload(account));
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateImport(int id){
        bulkUploadManager.updateImport(id);
    }

    public int importToDataSource(Content content){
        return bulkUploadManager.importToDataSource(content);
    }

    public int importWebToDataSource(Content content){
        return bulkUploadManager.importWebToDataSource(content);
    }

    public void createApps(Apps apps) {
        bulkUploadManager.createApps(apps);
    }

    public void insertAppLog(AppLog appLog) {
        bulkUploadManager.insertAppLog(appLog);
    }

    public void insertAppDetailsLog(AppDetailsLog appDetailsLog) {
        bulkUploadManager.insertAppDetailsLog(appDetailsLog);
    }

    public void insertAppResource(AppResource appResource) {
        bulkUploadManager.insertAppResource(appResource);
    }

    public int findAppsByPkg(String pkg){
        return bulkUploadManager.findAppsByPkg(pkg);
    }

    public String getUploadExcelPath() {
        return uploadExcelPath;
    }

    public String getUploadReAPKPath() {
        return uploadReAPKPath;
    }

    public String getUploadCoverPicPath() {
        return uploadCoverPicPath;
    }

    public int createImportLog(ImportAppLog importAppLog) {
        int id = bulkUploadManager.insertImportAppLog(importAppLog);
        return id;
    }

    public void processImport(ImportAppLog importAppLog) {
        bulkUploadManager.processImport(importAppLog);
    }

    public void completeImport(ImportAppLog importAppLog) {
        bulkUploadManager.completeImport(importAppLog);
    }

    public void deleteImportLog(ImportAppLog importAppLog){
        bulkUploadManager.deleteImportLog(importAppLog);
    }

    public void uploadExcelLog(ImportAppLog importAppLog){
        bulkUploadManager.uploadExcelLog(importAppLog);
    }

    public int findSuperRoleId(String account){
        return bulkUploadManager.findSuperRoleId(account);
    }

}