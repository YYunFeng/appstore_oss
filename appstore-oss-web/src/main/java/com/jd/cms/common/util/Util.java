package com.jd.cms.common.util;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    public static String sub(String str){
        String destSrc = str;
        if(str.length()>200){
            destSrc = str.substring(0,200)+"...";
        }
        return destSrc;
    }
}
