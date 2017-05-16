package com.jd.cms.manager.contains;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-26
 * Time: 下午6:52
 * To change this template use File | Settings | File Templates.
 */
public class TaskTypeConstants {
    /*任务状态*/
    public static final int CMS_TASKSTATUS_WAITEXECUTE = 0;
    public static final int CMS_TASKSTATUS_HASSTARTED = 1;
    public static final int CMS_TASKSTATUS_FAILS = 3;
    public static final int CMS_TASKSTATUS_STOP = 4;
    /*APPSTORE价格同步原因*/
    public static final String CMS_UPDATE_PRICE = "修改价格";
    /*排行榜类型*/
    public static final int CMS_RANKING_SOFT = 0;/*移动软件排行*/
    public static final int CMS_RANKING_GAME = 1;/*移动游戏排行*/
    public static final int CMS_RANKING_WEB = 2;/*Web应用排行*/
    /*排行榜分类*/
    public static final int CMS_RANKING_NEWEST = 0;/*最新上架*/
    public static final int CMS_RANKING_FASTEST = 1;/*上升最快*/
    public static final int CMS_RANKING_FEE = 2;/*热门收费*/
    public static final int CMS_RANKING_FREE = 3;/*热门免费*/
    /*任务类型-同步应用基本信息*/
    public static final String CMS_TASKTYPE_BASEINFO = "1";
    /*任务类型-同步应用价格*/
    public static final String CMS_TASKTYPE_PRICE = "2";
    /*任务类型-同步上下架状态*/
    public static final String CMS_TASKTYPE_UPSTATUS = "3";
    /*任务类型-同步商品类目*/
    public static final String CMS_TASKTYPE_CATEGORY = "4";
    /*任务类型-生成下载统计日报*/
    public static final String CMS_TASKTYPE_DOWNLOAD = "5";
    /*任务类型-更新排行榜*/
    public static final String CMS_TASKTYPE_TOP = "6";


    /*任务类型-合到期预警检测*/
    public static final String CMS_TASKTYPE_EXPIRATION = "7";
    /*任务类型-上传主图*/
    public static final String CMS_TASKTYPE_UPLOADCOVER = "8";
    /**
     * 任务类型-更新营销统计*
     */
    public static final String CMS_TASKTYPE_UPDATEMARKETINGLOG = "9";


    /**
     * 任务类型-同步卓望增量接口数据*
     */
    public static final String CMS_ZHUOWANG_NEW_APP = "10";
    public static final String CMS_SEND_MAIL = "11";

    /*任务类型-更新每月收入统计*/
    public static final String CMS_TASKTYPE_INCOMESTATISTIC = "12";
    /**
     * 任务类型-促销员安装日志-新版营销统计*
     */
    public static final String CMS_TASKTYPE_SALERINTALLLOG = "13";
    /*重试剩余次数*/
    public static final int CMS_TASK_RETRYTIMES = 10;
    /*是否需要自动重试*/
    public static final int CMS_TASK_AUTORETRY = 1;
}