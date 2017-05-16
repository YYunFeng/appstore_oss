package com.jd.cms.service.systemmaintenance;

import com.jd.appstore.domain.*;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午6:04
 * To change this template use File | Settings | File Templates.
 */
public interface BulkUploadService {
    Result findCPBaseInfoList();

    Result findCpList(int pageIndex, int pageSize, String cpName);

    int importToDataSource(Content content);

    int importWebToDataSource(Content content);

    void createApps(Apps apps);

    void insertAppLog(AppLog appLog);

    void insertAppDetailsLog(AppDetailsLog appDetailsLog);

    void insertAppResource(AppResource appResource);

    int findAppsByPkg(String pkg);

    String getUploadExcelPath();

    String getUploadReAPKPath();

    String getUploadCoverPicPath();

    String getUploadImgPicPath();

    int createImportLog(ImportAppLog importAppLog);

    void processImport(ImportAppLog importAppLog);

    void completeImport(ImportAppLog importAppLog);

    void deleteImportLog(ImportAppLog importAppLog);

    void uploadExcelLog(ImportAppLog importAppLog);

    int findSuperRoleId(String account);

    Result loadUpload(String account);

    void updateImport(int id);
}
