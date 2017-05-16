package com.jd.cms.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-19
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class ClientIp {
    /**
    * 获得HTTP请求的IP地址
    */
    public static String getIp(HttpServletRequest request) {
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
    if (ip != null) {
        String[] ipArray = ip.split(",");
        if (ipArray != null && ipArray.length > 1) {
        ip = ipArray[0];
        }
    }
    return ip;
    }
}
