package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.AppCountsDao;
import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-17.
 */
public class AppCountsDaoImpl extends BaseDao implements AppCountsDao {


    public List<AppCountResult> getInstallAppsByCp(AppCountParameter appCountParameter) {
        return queryForList("AppCounts.getInstallAppsByCp", appCountParameter);
    }

    public List<AppCountResult> getCountAppsByCp(AppCountParameter appCountParameter) {
        return queryForList("AppCounts.getCountAppsByCp", appCountParameter);
    }

    public Integer getCountAppsByCpCounts(AppCountParameter appCountParameter) {
        return (Integer) queryForObject("AppCounts.getCountAppsByCpCounts", appCountParameter);
    }

    public List<AppCountResult> getInstallAppByApp(AppCountParameter appCountParameter) {
        return queryForList("AppCounts.getInstallAppByApp", appCountParameter);
    }

    public List<AppCountResult> getCountAppsByApp(AppCountParameter appCountParameter) {
        return queryForList("AppCounts.getCountAppsByApp", appCountParameter);
    }

    public Integer getCountAppByAppCounts(AppCountParameter appCountParameter) {
        return (Integer) queryForObject("AppCounts.getCountAppByAppCounts", appCountParameter);
    }


    public List<AppCountResult> appsCountPhoneImei(AppCountParameter appCountParameter) {
        return queryForList("AppCounts.appsCountPhoneImei", appCountParameter);
    }

    public Integer appsCountPhoneImeiCounts(AppCountParameter appCountParameter) {
        return (Integer) queryForObject("AppCounts.appsCountPhoneImeiCounts", appCountParameter);
    }
}
