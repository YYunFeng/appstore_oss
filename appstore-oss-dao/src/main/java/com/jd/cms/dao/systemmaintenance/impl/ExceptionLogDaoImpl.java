package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.ExceptionLogDao;
import com.jd.cms.domain.systemmaintenance.ExceptionLog;
import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLogDaoImpl extends BaseDao implements ExceptionLogDao {
    public List<ExceptionLog> getExceptionLog(ExceptionLogInput exceptionInput) {
        return queryForList("exceptionLog.getExceptionLog", exceptionInput);
    }

    public Integer getExceptionLogCounts(ExceptionLogInput exceptionInput) {
        return (Integer) queryForObject("exceptionLog.getExceptionLogCounts",exceptionInput);
    }
}
