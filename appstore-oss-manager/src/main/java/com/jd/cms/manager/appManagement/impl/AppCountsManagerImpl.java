package com.jd.cms.manager.appManagement.impl;

import com.jd.cms.dao.appManagement.AppCountsDao;
import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.cms.manager.appManagement.AppCountsManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-17.
 */
public class AppCountsManagerImpl extends BaseManager implements AppCountsManager {
    private AppCountsDao appCountsDao;

    public PaginatedList<AppCountResult> getCountAppsByCp(AppCountParameter appCountParameter, int pageIndex, int pageSize) {
        if (appCountParameter != null) {
            appCountParameter.setFlag(0);
            if (0 == pageIndex) pageIndex = 1;
        }
        PaginatedList<AppCountResult> countAppResults = new PaginatedArrayList<AppCountResult>(pageIndex, pageSize);
        try {
            int total = appCountsDao.getCountAppsByCpCounts(appCountParameter);
            if (total > 0) {
                countAppResults.setTotalItem(total);
                appCountParameter.setStartRow((pageIndex - 1) * pageSize);
                appCountParameter.setEndRow(pageSize);
                List<AppCountResult> installAppResultList = appCountsDao.getInstallAppsByCp(appCountParameter);
                List<AppCountResult> countAppResultList = appCountsDao.getCountAppsByCp(appCountParameter);
                for (AppCountResult appCountResult : installAppResultList) {
                    for (AppCountResult appCountResult1 : countAppResultList) {
                        if (appCountResult.getCpId().intValue() == appCountResult1.getCpId().intValue()) {
                            appCountResult.setCountApps(appCountResult1.getCountApps());
                        }
                    }
                }
                countAppResults.addAll(installAppResultList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countAppResults;
    }

    public PaginatedList<AppCountResult> getCountAppByApp(AppCountParameter countAppParameter, int pageIndex, int pageSize) {
        if (countAppParameter != null) {
            countAppParameter.setFlag(0);
            if (0 == pageIndex) pageIndex = 1;
        }
        PaginatedList<AppCountResult> countAppResults = new PaginatedArrayList<AppCountResult>(pageIndex, pageSize);
        try {
            int totalItem = appCountsDao.getCountAppByAppCounts(countAppParameter);
            if (totalItem > 0) {
                countAppResults.setTotalItem(totalItem);
                countAppParameter.setStartRow((pageIndex - 1) * pageSize);
                countAppParameter.setEndRow(pageSize);
                List<AppCountResult> installAppRes = appCountsDao.getInstallAppByApp(countAppParameter);
                List<AppCountResult> countAppResultList = appCountsDao.getCountAppsByApp(countAppParameter);
                for (AppCountResult appCountResult : installAppRes) {
                    for (AppCountResult appCountResult1 : countAppResultList) {
                        if (appCountResult.getAppid() != null && appCountResult.getAppid().equals(appCountResult1.getAppid())) {
                            appCountResult.setCountApps(appCountResult1.getCountApps());
                        }
                    }
                }
                countAppResults.addAll(installAppRes);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countAppResults;
    }

    public PaginatedList<AppCountResult> getCountAppByPhoneImei(AppCountParameter countAppParameter, int pageIndex, int pageSize) {
        if (countAppParameter != null) {
            countAppParameter.setFlag(0);
            if (0 == pageIndex) pageIndex = 1;
        }
        PaginatedList<AppCountResult> countAppResults = new PaginatedArrayList<AppCountResult>(pageIndex, pageSize);
        try {
            int totalItem = appCountsDao.appsCountPhoneImeiCounts(countAppParameter);
            if (totalItem > 0) {
                countAppResults.setTotalItem(totalItem);
                countAppParameter.setStartRow((pageIndex - 1) * pageSize);
                countAppParameter.setEndRow(pageSize);
                List<AppCountResult> countAppResultList = appCountsDao.appsCountPhoneImei(countAppParameter);
                countAppResults.addAll(countAppResultList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countAppResults;
    }

    public List<AppCountResult> getCountAppsByCpExcel(AppCountParameter appCountParameter) {
        if (appCountParameter != null) {
            appCountParameter.setFlag(1);
        }
        return appCountsDao.getCountAppsByCp(appCountParameter);
    }

    public List<AppCountResult> getCountAppByAppExcel(AppCountParameter appCountParameter) {
        if (appCountParameter != null) {
            appCountParameter.setFlag(1);
        }
        return appCountsDao.getCountAppsByApp(appCountParameter);
    }

    public List<AppCountResult> getCountAppByPhoneImeiExcel(AppCountParameter appCountParameter) {
        if (appCountParameter != null) {
            appCountParameter.setFlag(1);
        }
        return appCountsDao.appsCountPhoneImei(appCountParameter);
    }

    public void setAppCountsDao(AppCountsDao appCountsDao) {
        this.appCountsDao = appCountsDao;
    }
}
