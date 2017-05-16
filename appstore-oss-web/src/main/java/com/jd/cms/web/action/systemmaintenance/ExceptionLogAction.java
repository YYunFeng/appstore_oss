package com.jd.cms.web.action.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.cms.service.systemmaintenance.ExceptionLogService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLogAction extends BaseAction {
    private ExceptionLogService exceptionLogService;
    private ExceptionLogInput exceptionLogInput;

    public String exceptionLogContent() {
        try {
            if (exceptionLogInput == null) {
                exceptionLogInput = new ExceptionLogInput();
            }
            Result result = exceptionLogService.getExceptionLog(exceptionLogInput, page, PAGE_SIZE);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void setExceptionLogService(ExceptionLogService exceptionLogService) {
        this.exceptionLogService = exceptionLogService;
    }

    public ExceptionLogInput getExceptionLogInput() {
        return exceptionLogInput;
    }

    public void setExceptionLogInput(ExceptionLogInput exceptionLogInput) {
        this.exceptionLogInput = exceptionLogInput;
    }
}
