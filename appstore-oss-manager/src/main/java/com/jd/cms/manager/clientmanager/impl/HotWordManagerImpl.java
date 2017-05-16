package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.HotWordDao;
import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.cms.manager.clientmanager.HotWordManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午7:27
 * To change this template use File | Settings | File Templates.
 */
public class HotWordManagerImpl extends BaseManager implements HotWordManager{
    private final static Logger log = Logger.getLogger(HotWordManagerImpl.class);
    private HotWordDao hotWordDao;

    public HotWordDao getHotWordDao() {
        return hotWordDao;
    }

    public void setHotWordDao(HotWordDao hotWordDao) {
        this.hotWordDao = hotWordDao;
    }

    public PaginatedList<HotWord> findHotWord(int pageIndex, int pageSize, int published) {
        BaseQuery baseQuery = new BaseQuery();
        if(0 == pageIndex){
            pageIndex = 1;
        }
        baseQuery.setId(published);
        int totalItem = hotWordDao.getHotWordCount(baseQuery);
        PaginatedList<HotWord> hotWords = new PaginatedArrayList<HotWord>(pageIndex, pageSize);
        hotWords.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        List<HotWord> hotWord = hotWordDao.findHotWord(baseQuery);
        hotWords.addAll(hotWord);

        return hotWords;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findHotWordBySeq(final HotWord hotWord) {
        int count = hotWordDao.findHotWordBySeq(hotWord);
        return count;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addHotWord(final HotWord hotWord) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    int hotWordId = (int)sequenceUtil.get(SequenceConstants.CMS_HOTWORD_SEQUENCE);
                    hotWord.setId(hotWordId);
                    hotWordDao.createHotWord(hotWord);
                }catch(Exception e){
                    log.info("添加热门词异常");
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void updateAddHotWordSeq(final HotWord hotWord) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    hotWordDao.updateAddHotWordSeq(hotWord);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAddhotWordSeq",e);
                }
            }
        });
    }

    public void updateDelHotWordSeq(final HotWord hotWord) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    hotWordDao.updateDelHotWordSeq(hotWord);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateDelHotWordSeq",e);
                }
            }
        });
    }

    public void deleteHotWord(final HotWord hotWord) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    hotWordDao.deleteHotWord(hotWord);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("deleteHotWord error", e);
                }
            }
        });
    }

    public void updateHotWordSeq(final HotWord hotWord) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    hotWordDao.updateHotWordSeq(hotWord);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateHotWordSeq error", e);
                }
            }
        });
    }

    public void updateHotWordPublished(final HotWord hotWord){
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    hotWordDao.updateHotWordPublished(hotWord);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateHotWordPublished error", e);
                }
            }
        });
    }

    public HotWord findHotWordById(HotWord hotWord) {
        HotWord hotWordResult = hotWordDao.findHotWordById(hotWord);
        return hotWordResult;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateHotWord(HotWord hotWord) {
        hotWordDao.updateHotWord(hotWord);
    }
}
