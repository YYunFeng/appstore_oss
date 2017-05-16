package com.jd.cms.service.systemmaintenance.impl;

import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.cms.manager.systemmaintenance.ExceptionLogManager;
import com.jd.cms.service.systemmaintenance.ExceptionLogService;
import com.jd.common.web.result.Result;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLogServiceImpl implements ExceptionLogService {
    private ExceptionLogManager exceptionLogManager;

    public Result getExceptionLog(ExceptionLogInput exceptionInput, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("exceptionLogList", exceptionLogManager.getExceptionLog(exceptionInput, pageIndex, pageSize));
            result.addDefaultModel("exceptionInput", exceptionInput);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setExceptionLogManager(ExceptionLogManager exceptionLogManager) {
        this.exceptionLogManager = exceptionLogManager;
    }
}
