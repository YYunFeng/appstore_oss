package com.jd.cms.manager.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.ExceptionLog;
import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.common.util.PaginatedList;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionLogManager {
    PaginatedList<ExceptionLog> getExceptionLog(ExceptionLogInput exceptionInput, int pageIndex, int pageSize);
}
