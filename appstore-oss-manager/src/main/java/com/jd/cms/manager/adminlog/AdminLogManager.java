package com.jd.cms.manager.adminlog;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-19
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public interface AdminLogManager {
    void createAdminLog(int adminid,int operatioTtype,Date operationTime,String memo,String remoteIp,String userAgent);
}
