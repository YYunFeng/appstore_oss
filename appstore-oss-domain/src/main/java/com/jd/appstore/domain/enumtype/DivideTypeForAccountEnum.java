package com.jd.appstore.domain.enumtype;

/**
 * ����ֳ�ģʽö��ö��
 * package:com.jd.music.admin.domain.music
 * User: yingkuohao
 * Date: 12-6-18
 * Time: ����6:35
 * CopyRight:360buy
 * Descrption: �ֳ�����ö��
 */
public enum DivideTypeForAccountEnum {

    DIVIDE(1, "�ֳ�ģʽ"),
    BUYOUT(2, "���ģʽ");

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
