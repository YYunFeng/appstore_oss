package com.jd.cms.dao.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.ExceptionLog;
import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;

import java.util.List;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionLogDao {
    List<ExceptionLog> getExceptionLog(ExceptionLogInput exceptionInput);

    Integer getExceptionLogCounts(ExceptionLogInput exceptionInput);
}
