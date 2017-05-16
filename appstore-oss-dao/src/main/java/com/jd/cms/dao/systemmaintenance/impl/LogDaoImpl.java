package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.appstore.domain.OperateObj;
import com.jd.cms.dao.systemmaintenance.LogsDao;
import com.jd.common.dao.BaseDao;

/**
 * Created by YYF on 2014/10/8.
 */
public class LogDaoImpl extends BaseDao implements LogsDao {
    public Integer getAppidLog(Integer appid) {
        return (Integer) queryForObject("Logs.getAppidLog",appid);
    }

    public void createOperateLog(OperateObj operateObj) {
        insert("Logs.createOperateLog", operateObj);
    }

    public void updateOperateLog(OperateObj operateObj) {
        update("Logs.updateOperateLog", operateObj);
    }
}
