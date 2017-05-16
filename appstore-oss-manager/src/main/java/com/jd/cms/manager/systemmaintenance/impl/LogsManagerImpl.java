package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.OperateObj;
import com.jd.cms.dao.systemmaintenance.LogsDao;
import com.jd.cms.manager.systemmaintenance.LogsManager;
import com.jd.common.manager.BaseManager;

/**
 * Created by YYF on 2014/10/8.
 */
public class LogsManagerImpl extends BaseManager implements LogsManager {
    private LogsDao logsDao;

    public void createOperateLog(Integer appid, Integer opeateCode) {
        try {
            if (appid != null && opeateCode != null) {
                Integer id = logsDao.getAppidLog(appid);
                OperateObj operateObj = new OperateObj();
                operateObj.setAppid(appid);
                operateObj.setOperateCode(opeateCode);
                if (id != null) {
                    operateObj.setId(id);
                    logsDao.updateOperateLog(operateObj);
                } else {
                    logsDao.createOperateLog(operateObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLogsDao(LogsDao logsDao) {
        this.logsDao = logsDao;
    }
}
