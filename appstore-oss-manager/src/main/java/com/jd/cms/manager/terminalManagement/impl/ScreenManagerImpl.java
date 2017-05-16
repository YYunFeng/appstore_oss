package com.jd.cms.manager.terminalManagement.impl;


import com.jd.cms.dao.terminalManagement.ScreenDao;
import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.terminalManagement.ScreenManager;
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
 * 屏幕管理managerImpl
 */
public class ScreenManagerImpl extends BaseManager implements ScreenManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(ScreenManagerImpl.class);
    /**
     * DAO注入
     */
    private ScreenDao screenDao;
    /**
     * 取得屏幕参数集合
     * @param pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<TerminalpageOutput> findScreenPage(int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        BaseQuery baseQuery = new BaseQuery();
        /*首次页数置一*/
        if(pageIndex==0){
            pageIndex=1;
        }
        /*取得屏幕的总记录数*/
        int totalItem = screenDao.getScreenCount();
        PaginatedList<TerminalpageOutput> OsList = new PaginatedArrayList<TerminalpageOutput>(pageIndex, pageSize);
        OsList.setTotalItem(totalItem);
        /*分页条件*/
        baseQuery.setStartRow((pageIndex-1)*pageSize);
        baseQuery.setEndRow(pageSize);
        /*取得屏幕信息集合*/
        List<TerminalpageOutput> osPageOutPutsList = screenDao.findScreenPage(baseQuery);
        OsList.addAll(osPageOutPutsList);
        return OsList;
    }
    /**
     * 创建屏幕信息
     * @param terminalInsertInput
     * @return int
     */
    public int createScreen(final TerminalInsertInput terminalInsertInput) {
        /*生成ID字段*/
        terminalInsertInput.setScreenSizeId((int) sequenceUtil.get(SequenceConstants.ANDROID_SCREEN_SEQUENCE));
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    screenDao.createScreen(terminalInsertInput);
                } catch (Exception e) {
                    log.error("创建屏幕信息 terminalInsertInput="+terminalInsertInput+" error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 更新屏幕上下架状态
     * @param terminalpageInput
     * @return int
     */
    public int upScreenOnline(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    screenDao.upScreenOnline(terminalpageInput);
                }catch (Exception e){
                    log.error("更新屏幕上下架状态 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upScreenOnline error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 删除屏幕信息
     * @param terminalpageInput
     * @return int
     */
    public int delScreen(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    screenDao.delScreen(terminalpageInput);
                }catch (Exception e){
                    log.error("删除屏幕信息 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("delScreens error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * 根据ID查询单条屏幕信息
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findScreenById(int id) {
        return screenDao.findScreenById(id);
    }
    /**
     * 更新屏幕信息
     * @param terminalpageInput
     * @return int
     */
    public int upScreen(final TerminalpageInput terminalpageInput) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    screenDao.upScreen(terminalpageInput);
                }catch (Exception e){
                    log.error("更新屏幕信息 terminalpageInput="+terminalpageInput+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upScreenerror !",e);
                }
            }
        });
        return 1;
    }
    /**
     * 检查屏幕版本名
     * @param name
     * @return String
     */
    public String checkScreenName(String name) {
        return screenDao.checkScreenName(name);
    }

    public ScreenDao getScreenDao() {
        return screenDao;
    }

    public void setScreenDao(ScreenDao screenDao) {
        this.screenDao = screenDao;
    }
}
