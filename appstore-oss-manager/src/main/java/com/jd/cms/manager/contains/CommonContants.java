package com.jd.cms.manager.contains;

/**
 * Created by IntelliJ IDEA.
 * User: cuiyi
 * Date: 12-8-20
 * Time: ����7:39
 * To change this template use File | Settings | File Templates.
 */
public class CommonContants {
    public static final String STRING_COMMA = ",";
    public static final String STRING_SEMICOLON = ";";
    public static final String STRING_COMMA_ZH = "��";  //���Ķ���


    //�ʼ�ʹ��ģ��
    public static final String EMAIL_TEMPLATE_TYPE = "1055";


    // �ƶ�Ӧ��sku��ʼ���
    public static final int APPSTORE_APK_SKU_START_NUM = 50000000;
    // �ƶ�Ӧ��sku�������
    public static final int APPSTORE_APK_SKU_END_NUM = 55999999;
    // WEBӦ��sku��ʼ
    public static final int APPSTORE_WEB_SKU_START_NUM = 56000000;
    // WEBӦ��sku����
    public static final int APPSTORE_WEB_SKU_END_NUM = 58999999;
    // ����sku��ʼ
    public static final int APPSTORE_NETGAME_SKU_START_NUM = 59000000;
    // ����sku��ʼ
    public static final int APPSTORE_NETGAME_SKU_END_NUM = 59999999;

    // ��עӦ���̵�sku��Χ���˴�
    public static final String FOLLOW_APPSTORE_SKU_SCOPE_FILTER = "L" + APPSTORE_APK_SKU_START_NUM + "M" + APPSTORE_NETGAME_SKU_END_NUM;
   //  ����ҳ��

    public static final String CMS_PADCHANNEL_PAGER_CACHED = "CMS_PADCHANNEL_PAGER_CACHED";
     public static final int CMS_EXPIRE_TIME = 1800;
}