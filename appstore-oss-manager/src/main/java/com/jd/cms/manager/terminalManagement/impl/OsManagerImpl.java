package com.jd.cms.manager.terminalManagement.impl;

import com.jd.cms.dao.terminalManagement.OsDao;
import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.terminalManagement.OsManager;
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
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理managerImpl
 */
public class OsManagerImpl extends BaseManager implements OsManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(OsManagerImpl.class);
    /**
     * DAO注入
     */
    private OsDao osDao;
    /**
     * 取得平台信息集合
     * @param pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<TerminalpageOutput> findOsPage(int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        BaseQuery baseQuery = new BaseQuery();
        /*首次页数置一*/
        if(pageIndex==0){
            pageIndex=1;
        }
        /*取得屏幕的总记录数*/
        int totalItem = osDao.getOsCount();
        PaginatedList<TerminalpageOutput> OsList = new PaginatedArrayList<TerminalpageOutput>(pageIndex, pageSize);
        OsList.setTotalItem(totalItem);
        /*分页条件*/
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        /*取得屏幕信息集合*/
        List<TerminalpageOutput> osPageOutPutsList = osDao.findOsPage(baseQuery);
        OsList.addAll(osPageOutPutsList);
        return OsList;
    }
    /**
     * 创建平台信息
     * @param terminalInsertInput
     * @return int
     */
    public int createOs(final TerminalInsertInput terminalInsertInput) {
        terminalInsertInput.setOsVersionId((int) sequenceUtil.get(SequenceConstants.ANDROID_OS_SEQUENCE));
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    osDao.createOs(terminalInsertInput);
                } catch (Exception e) {
                    log.error("创建平台信息 terminalInsertInput="+terminalInsertInput+" error!",e);
                    status.setRollbackOnly();
                }
            }
        });
        return 1;
    }
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return int
     */
    public int upOsOnline(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    osDao.upOsOnline(terminalpageInput);
                }catch (Exception e){
                    log.error("更新平台上下架状态 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upOsOnline error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return int
     */
    public int delOs(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    osDao.delOs(terminalpageInput);
                }catch (Exception e){
                    log.error("删除平台信息 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("delOs error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findOsById(int id) {
        return osDao.findOsById(id);
    }
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return int
     */
    public int upOs(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    osDao.upOs(terminalpageInput);
                }catch (Exception e){
                    log.error("更新平台信息 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upOs error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    public String checkOsName(String name) {
        return osDao.checkOsName(name);
    }
    /**
     * 检查平台版本码
     * @param code
     * @return Integer
     */
    public Integer checkOsCode(int code) {
        return osDao.checkOsCode(code);
    }

    public OsDao getOsDao() {
        return osDao;
    }

    public void setOsDao(OsDao osDao) {
        this.osDao = osDao;
    }
}
