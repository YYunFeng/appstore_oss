package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.systemmaintenance.BulkUploadDao;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public class BulkUploadDaoImpl extends BaseDao implements BulkUploadDao{
    public List<CpBaseInfo> findCPBaseInfoList() {
        return queryForList("SystemMaintenance.findCPBaseInfoList");
    }

    public List<CpBaseInfo> findCPList(Query query){
        return queryForList("SystemMaintenance.findCPList",query);
    }

    public int getCPCount(Query query){
        return (Integer)queryForObject("SystemMaintenance.getCPCount", query);
    }

    public List<Category> findCategoryList(int categoryId) {
        return queryForList("SystemMaintenance.findCategoryList",categoryId);
    }

    public List<Category> findWebCategoryList(int categoryId){
        return queryForList("SystemMaintenance.findCategoryList", categoryId);
    }

    public void createApps(Apps apps) {
        insert("Apps.createApps", apps);
    }

    public void insertAppLog(AppLog appLog) {
        insert("Apps.insertAppLog", appLog);
    }

    public void insertAppDetailsLog(AppDetailsLog appDetailsLog) {
        insert("Apps.insertAppDetailsLog", appDetailsLog);
    }

    public void insertAppResource(AppResource appResource) {
        insert("Apps.insertAppResource", appResource);
    }

    public void insertImportAppLog(ImportAppLog importAppLog) {
        insert("Apps.insertImportAppLog", importAppLog);
    }

    public int findAppsByPkg(String pkg) {
        return (Integer)queryForObject("Apps.findAppsByPkg", pkg);
    }

    public int findOsVersionId(int id){
        return (Integer)queryForObject("Apps.findOsVersionId", id);
    }

    public void processImport(ImportAppLog importAppLog) {
        update("Apps.processImport", importAppLog);
    }

    public void completeImport(ImportAppLog importAppLog) {
        update("Apps.completeImport", importAppLog);
    }

    public void deleteImportLog(ImportAppLog importAppLog){
        delete("Apps.deleteImportLog", importAppLog);
    }

    public void uploadExcelLog(ImportAppLog importAppLog){
        update("Apps.uploadExcelLog", importAppLog);
    }

    public int findSuperRoleId(String account){
        return (Integer)queryForObject("Apps.findSuperRoleId",account);
    }

    public ImportAppLog loadUpload(String account) {
        return (ImportAppLog)queryForObject("Apps.loadUpload",account);
    }

    public void updateImport(int id){
       update("Apps.updateImport",id);
    }
}
