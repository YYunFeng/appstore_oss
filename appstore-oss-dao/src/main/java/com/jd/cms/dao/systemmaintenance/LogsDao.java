package com.jd.cms.dao.systemmaintenance;

import com.jd.appstore.domain.OperateObj;

/**
 * Created by YYF on 2014/10/8.
 */
public interface LogsDao {


    /**
     * 获取应用的操作日志
     *
     * @param appid
     * @return
     */
    Integer getAppidLog(Integer appid);

    /**
     * 创建应用操作日志
     *
     * @param operateObj
     */
    void createOperateLog(OperateObj operateObj);

    /**
     * 更新应用操作日志
     *
     * @param operateObj
     */
    void updateOperateLog(OperateObj operateObj);

}
