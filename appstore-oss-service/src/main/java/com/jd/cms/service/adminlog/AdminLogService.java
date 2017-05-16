package com.jd.cms.service.adminlog;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-19
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public interface AdminLogService {
    void createAdminLog(HttpServletRequest request,int adminid,int operatioTtype,Date operationTime,String memo);
}
