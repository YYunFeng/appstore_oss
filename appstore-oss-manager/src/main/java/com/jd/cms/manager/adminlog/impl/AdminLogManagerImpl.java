package com.jd.cms.manager.adminlog.impl;

import com.jd.appstore.domain.AdminLog;
import com.jd.cms.dao.adminlog.AdminLogDao;
import com.jd.cms.manager.adminlog.AdminLogManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-19
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
public class AdminLogManagerImpl extends BaseManager implements AdminLogManager {
    private final static Log log = LogFactory.getLog(AdminLogManagerImpl.class);
    private AdminLogDao adminLogDao;

    public void createAdminLog(final int adminid, final int operatioTtype, final Date operationTime, final String memo, final String remoteIp, final String userAgent) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    AdminLog adminLog = new AdminLog();
                    int id = (int) sequenceUtil.get(SequenceConstants.CMS_ADMINLOG_SEQUENCE);
                    adminLog.setId(id);
                    adminLog.setAdminId(adminid);
                    adminLog.setOperationType(operatioTtype);
                    adminLog.setOperationTime(operationTime);
                    adminLog.setIp(remoteIp);
                    adminLog.setUa(userAgent);
                    adminLog.setMemo(memo);
                    adminLogDao.createAdminLog(adminLog);
                } catch (Exception ex) {
                    log.error("增加操作日志 error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("createAdminLog error!", ex);
                }
            }
        });
    }

    public void setAdminLogDao(AdminLogDao adminLogDao) {
        this.adminLogDao = adminLogDao;
    }
}
