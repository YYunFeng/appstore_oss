package com.jd.cms.manager.systemmaintenance;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */
public interface BulkUploadManager {
    List<CpBaseInfo> findCPBaseInfoList();

    PaginatedList<CpBaseInfo> findCPList(int pageIndex, int pageSize, String cpName);

    List<Category> findCategoryList(int categoryId);

    List<Category> findWebCategoryList(int categoryId);

    int importToDataSource(Content content);

    int importWebToDataSource(Content content);

    void createApps(Apps apps);

    void insertAppLog(AppLog appLog);

    void insertAppDetailsLog(AppDetailsLog appDetailsLog);

    void insertAppResource(AppResource appResource);

    int insertImportAppLog(ImportAppLog importAppLog);

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
