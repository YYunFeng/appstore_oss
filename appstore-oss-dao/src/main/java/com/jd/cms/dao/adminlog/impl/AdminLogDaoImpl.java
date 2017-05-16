package com.jd.cms.dao.adminlog.impl;

import com.jd.appstore.domain.AdminLog;
import com.jd.cms.dao.adminlog.AdminLogDao;
import com.jd.common.dao.BaseDao;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-19
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public class AdminLogDaoImpl extends BaseDao implements AdminLogDao{
    public void createAdminLog(AdminLog adminLog) {
        insert("Login.createAdminLog",adminLog);
    }
}
