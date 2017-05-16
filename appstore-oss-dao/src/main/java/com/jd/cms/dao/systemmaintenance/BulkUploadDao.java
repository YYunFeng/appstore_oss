package com.jd.cms.dao.systemmaintenance;

import com.jd.appstore.domain.*;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午5:44
 * To change this template use File | Settings | File Templates.
 */
public interface BulkUploadDao {
    List<CpBaseInfo> findCPBaseInfoList();
    List<CpBaseInfo> findCPList(Query query);
    List<Category> findCategoryList(int categoryId);
    List<Category> findWebCategoryList(int categoryId);
    int getCPCount(Query query);
    void createApps(Apps apps);
    void insertAppLog(AppLog appLog);
    void insertAppDetailsLog(AppDetailsLog appDetailsLog);
    void insertAppResource(AppResource appResource);

    void insertImportAppLog(ImportAppLog importAppLog);

    int findAppsByPkg(String pkg);
    int findOsVersionId(int id);

    void processImport(ImportAppLog importAppLog);
    void completeImport(ImportAppLog importAppLog);
    void deleteImportLog(ImportAppLog importAppLog);
    void uploadExcelLog(ImportAppLog importAppLog);
    int findSuperRoleId(String account);
    ImportAppLog loadUpload(String account);
    void updateImport(int id);
}
