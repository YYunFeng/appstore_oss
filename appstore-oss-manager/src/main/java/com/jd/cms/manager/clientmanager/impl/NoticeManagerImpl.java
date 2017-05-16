package com.jd.cms.manager.clientmanager.impl;

import com.ibatis.sqlmap.engine.transaction.Transaction;
import com.jd.appstore.domain.WebsiteNotice;
import com.jd.cms.dao.clientmanager.NoticeDao;
import com.jd.cms.manager.clientmanager.NoticeManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.lang.annotation.Retention;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:51
 * To change this template use File | Settings | File Templates.
 */
public class NoticeManagerImpl extends BaseManager implements NoticeManager{
    private NoticeDao noticeDao;

    public void setNoticeDao(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    public PaginatedList<WebsiteNotice> findNotice(int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        if(0 == pageIndex){
            pageIndex = 1;
        }
        int totalItem = noticeDao.getNoticeCount();
        PaginatedList<WebsiteNotice> notices = new PaginatedArrayList<WebsiteNotice>(pageIndex, pageSize);
        notices.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        List<WebsiteNotice> notice = noticeDao.findNotice(baseQuery);
        notices.addAll(notice);
        return  notices;
    }

    public PaginatedList<WebsiteNotice> findNoticeByPub(int pageIndex, int pageSize, int pubedStatus) {
        BaseQuery baseQuery = new BaseQuery();
        if(0 == pageIndex){
            pageIndex = 1;
        }
        baseQuery.setId(pubedStatus);
        int totalItem = noticeDao.getNoticeCountByPub(baseQuery);
        PaginatedList<WebsiteNotice> notices = new PaginatedArrayList<WebsiteNotice>(pageIndex, pageSize);
        notices.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        List<WebsiteNotice> notice = noticeDao.findNoticeByPub(baseQuery);
        notices.addAll(notice);
        return notices;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<WebsiteNotice> findNoticeById(WebsiteNotice notice) {
        List<WebsiteNotice> notices = noticeDao.findNoticeById(notice);
        return notices;
    }

    public int updateNoticePubedStatus(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
                transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                        try {
                            noticeDao.updateNoticePubedStatus(notice);
                        }catch (Exception e){
                            transactionStatus.setRollbackOnly();
                            throw new RuntimeException("updateNoticPubedStatus error!", e);
                        }
                    }
                });
        return 1;
    }

    public int deleteNotice(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    noticeDao.deleteNotice(notice);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("delete notice error!", e);
                }
            }
        });

        return 1;
    }

    public int findNoticeBySeq(final WebsiteNotice notice) {
        int count = noticeDao.findNoticeBySeq(notice);

        return count;
    }

    public int updateAddNoticeSeq(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    noticeDao.updateAddNoticeSeq(notice);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAddNoticeSeq error!", e);
                }
            }
        });

        return 1;
    }

    public int updateDelNoticeSeq(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    noticeDao.updateDelNoticeSeq(notice);
                }catch (Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateDelNoticeSeq error!", e);
                }
            }
        });

        return 1;
    }

    public int updateNoticeSeq(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    noticeDao.updateNoticeSeq(notice);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateNoticeSeq error!", e);
                }
            }
        });

        return 1;
    }

    public void createNotice(final WebsiteNotice notice) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    int noticeId = (int) sequenceUtil.get(SequenceConstants.CMS_NOTICE_SEQUENCE);
                    notice.setId(noticeId);
                    noticeDao.createNotice(notice);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void updateNotice(final WebsiteNotice notice) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    noticeDao.updateNotice(notice);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateNotice error",e);
                }
            }
        });
    }
}
