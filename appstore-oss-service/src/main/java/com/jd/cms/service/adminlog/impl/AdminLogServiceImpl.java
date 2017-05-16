package com.jd.cms.service.adminlog.impl;

import com.jd.cms.manager.adminlog.AdminLogManager;
import com.jd.cms.service.adminlog.AdminLogService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-19
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class AdminLogServiceImpl implements AdminLogService {
    private AdminLogManager adminLogManager;

    /**
     * @param request
     * @param adminid
     * @param operatioTtype
     * @param operationTime
     * @param memo
     */
    public void createAdminLog(HttpServletRequest request, int adminid, int operatioTtype, Date operationTime, String memo) {
        String remoteIp = getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");
        adminLogManager.createAdminLog(adminid, operatioTtype, operationTime, memo, remoteIp, userAgent);
    }

    /**
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * @param remoteIp
     * @return
     */
    public String getComma(String remoteIp) {
        String[] result = remoteIp.split(",");
        if (result.length > 1) {
            return remoteIp;
        } else {
            return remoteIp;
        }
    }

    public void setAdminLogManager(AdminLogManager adminLogManager) {
        this.adminLogManager = adminLogManager;
    }
}
