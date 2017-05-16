package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.FeedBackDao;
import com.jd.cms.domain.systemmaintenance.FeedBack;
import com.jd.cms.manager.systemmaintenance.FeedBackManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class FeedBackManagerImpl extends BaseManager implements FeedBackManager{
        /**
     * 日志
     */
    private final static Log log = LogFactory.getLog(FeedBackManagerImpl.class);
    
    private FeedBackDao feedBackDao;

    public FeedBackDao getFeedBackDao() {
        return feedBackDao;
    }

    public void setFeedBackDao(FeedBackDao feedBackDao) {
        this.feedBackDao = feedBackDao;
    }
    /**
     * 取得问题反馈信息集合
     * @param pageIndex，pageSize
     * @return PaginatedList
     */
    public PaginatedList<FeedBack> findFeedBackList(int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        BaseQuery baseQuery = new BaseQuery();
        /*首次页数置一*/
        if(pageIndex==0){
            pageIndex=1;
        }
        /*取得屏幕的总记录数*/
        int totalItem = feedBackDao.getFeedBackCount(baseQuery);
        PaginatedList<FeedBack> FeedBackList = new PaginatedArrayList<FeedBack>(pageIndex, pageSize);
        FeedBackList.setTotalItem(totalItem);
        /*分页条件*/
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        /*取得屏幕信息集合*/
        List<FeedBack> osPageOutPutsList = feedBackDao.findFeedBackList(baseQuery);
        FeedBackList.addAll(osPageOutPutsList);
        return FeedBackList;
    }
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    public int delFeedBack(final int id) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    feedBackDao.delFeedBack(id);
                }catch (Exception e){
                    log.error("删除问题反馈 error!");
                    status.setRollbackOnly();
                    throw new RuntimeException("delOs error!",e);
                }
            }
        });
        return 1;
    }

}
