package com.jd.appstore.domain.enumtype;

/**
 * ��Ӧ�̷ֳ�ģʽö��
 * User: Administrator
 * Date: 12-10-9
 * Time: ����7:13
 * To change this template use File | Settings | File Templates.
 */
public enum FeeModeEnumType {

    FREE(0, "���"),
    DIVIDE_NO_PREPAY(1, "�ֳɣ���Ԥ��ģʽ"),
    DIVIDE_PREPAY(2, "�ֳɣ���Ԥ����ģʽ"),
    BUYOUT(3, "���ģʽ");

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
