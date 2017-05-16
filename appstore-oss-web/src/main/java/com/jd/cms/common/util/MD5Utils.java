package com.jd.cms.common.util;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-9-7
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public class MD5Utils {

    static Logger logger = Logger.getLogger(MD5Utils.class);

    /**
     * MD5 加密
     */
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException caught! Algorithm=MD5");
            //System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException");
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }

        return md5StrBuff.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMD5Str("abc"));
    }
}
