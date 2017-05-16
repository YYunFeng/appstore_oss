package com.jd.cms.dao.adminlog;

import com.jd.appstore.domain.AdminLog;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-19
 * Time: 下午7:05
 * To change this template use File | Settings | File Templates.
 */
public interface AdminLogDao {
    void createAdminLog(AdminLog adminLog);
}
