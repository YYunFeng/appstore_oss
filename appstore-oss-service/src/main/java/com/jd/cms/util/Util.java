package com.jd.cms.util;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-15
 * Time: 下午5:54
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }


    public static void main(String args[]) {
        int a = 199;
        int b = 23;
        int c = 62;
        double m =((double)b/a);

        int t = (int)Math.round(c*m);



        System.out.println(a+","+b+","+m);
        System.out.println(t);
    }
}

