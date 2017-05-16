package com.jd.appstore.domain.enumtype;

/**
 * 结算分成模式枚举枚举
 * package:com.jd.music.admin.domain.music
 * User: yingkuohao
 * Date: 12-6-18
 * Time: 上午6:35
 * CopyRight:360buy
 * Descrption: 分成类型枚举
 */
public enum DivideTypeForAccountEnum {

    DIVIDE(1, "分成模式"),
    BUYOUT(2, "买断模式");

    private DivideTypeForAccountEnum(int code, String fileName) {
        this.code = code;
        this.fileName = fileName;
    }

    private int code;
    private String fileName;

    public int getCode() {
        return code;
    }

    public String getFileName() {
        return fileName;
    }

    public static DivideTypeForAccountEnum valueOfFieldName(String fieldName) {
        for (DivideTypeForAccountEnum divideenum : DivideTypeForAccountEnum.values()) {
            if (divideenum.getFileName().equals(fieldName)) {
                return divideenum;
            }
        }
        return null;
    }

}
