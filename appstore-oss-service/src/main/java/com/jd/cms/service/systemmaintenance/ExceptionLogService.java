package com.jd.cms.service.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.common.web.result.Result;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionLogService {
    Result getExceptionLog(ExceptionLogInput exceptionInput, int pageIndex, int pageSize);
}
