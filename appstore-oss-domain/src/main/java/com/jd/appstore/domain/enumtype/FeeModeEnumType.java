package com.jd.appstore.domain.enumtype;

/**
 * 供应商分成模式枚举
 * User: Administrator
 * Date: 12-10-9
 * Time: 下午7:13
 * To change this template use File | Settings | File Templates.
 */
public enum FeeModeEnumType {

    FREE(0, "免费"),
    DIVIDE_NO_PREPAY(1, "分成，无预付模式"),
    DIVIDE_PREPAY(2, "分成，有预付款模式"),
    BUYOUT(3, "买断模式");

    private int code;
    private String desc;

    private  FeeModeEnumType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
