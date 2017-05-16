package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.ExceptionLogDao;
import com.jd.cms.domain.systemmaintenance.ExceptionLog;
import com.jd.cms.domain.systemmaintenance.ExceptionLogInput;
import com.jd.cms.manager.systemmaintenance.ExceptionLogManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * User: YUNFENG
 * Date: 13-11-20
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionLogManagerImpl extends BaseManager implements ExceptionLogManager {
    private ExceptionLogDao exceptionLogDao;

    public PaginatedList<ExceptionLog> getExceptionLog(ExceptionLogInput exceptionInput,int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<ExceptionLog> exceptionLogPaginatedList = new PaginatedArrayList<ExceptionLog>(pageIndex, pageSize);
        try {
            int totalItem = exceptionLogDao.getExceptionLogCounts(exceptionInput);
            if (totalItem != 0) {
                exceptionLogPaginatedList.setTotalItem(totalItem);
                exceptionInput.setStartRow((pageIndex - 1) * pageSize);
                exceptionInput.setEndRow(pageSize);
                List<ExceptionLog> logList = exceptionLogDao.getExceptionLog(exceptionInput);
                exceptionLogPaginatedList.addAll(logList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptionLogPaginatedList;
    }


    public void setExceptionLogDao(ExceptionLogDao exceptionLogDao) {
        this.exceptionLogDao = exceptionLogDao;
    }
}
