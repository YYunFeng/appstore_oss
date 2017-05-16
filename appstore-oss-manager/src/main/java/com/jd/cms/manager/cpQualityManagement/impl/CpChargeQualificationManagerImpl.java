package com.jd.cms.manager.cpQualityManagement.impl;

import com.jd.cms.dao.cpQualityManagement.CpChargeQualificationDao;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.cms.manager.cpQualityManagement.CpChargeQualificationManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核ManagerImpl
 */
public class CpChargeQualificationManagerImpl extends BaseManager implements CpChargeQualificationManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(CpChargeQualificationManagerImpl.class);
    /**
     * DAO注入
     */
    private CpChargeQualificationDao cpChargeQualificationDao;
    /**
     * 取得cp收费资质信息集合
     * @param selCpPageInPut,pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<SelCpPageOutPut> findCpChargePage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        SelCpPageInPut newCpPageInPut = new SelCpPageInPut();
        /*进行模糊查询处理*/
        if(StringUtils.isNotBlank(selCpPageInPut.getAccount())) {
            newCpPageInPut.setAccount("%"+selCpPageInPut.getAccount()+"%");
        }
        if(StringUtils.isNotBlank(selCpPageInPut.getCpName())) {
            newCpPageInPut.setCpName("%"+selCpPageInPut.getCpName()+"%");
        }
        if(StringUtils.isNotBlank(selCpPageInPut.getContractNumber())) {
            newCpPageInPut.setContractNumber("%"+selCpPageInPut.getContractNumber()+"%");
        }
        newCpPageInPut.setCpProperty(selCpPageInPut.getCpProperty());
        newCpPageInPut.setFeeStatus(selCpPageInPut.getFeeStatus());
        /*首次页数置一*/
        if(pageIndex==0){
            pageIndex=1;
        }
        /*取得cp的总记录数*/
        int totalItem = cpChargeQualificationDao.getCpCount(newCpPageInPut);

        PaginatedList<SelCpPageOutPut> CpList = new PaginatedArrayList<SelCpPageOutPut>(pageIndex, pageSize);

        CpList.setTotalItem(totalItem);
        /*分页条件*/
        newCpPageInPut.setStartRow((pageIndex-1)*pageSize);
        newCpPageInPut.setEndRow(pageSize);
        /*取得cp信息集合*/
        List<SelCpPageOutPut> cpPageOutPutsList = cpChargeQualificationDao.findCpChargePage(newCpPageInPut);

        CpList.addAll(cpPageOutPutsList);
        return CpList;
    }
    /**
     * 收费资质审核状态更新
     * @param selCpPageInPut
     * @return int
     */
    public int upFeeStatus(final SelCpPageInPut selCpPageInPut) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    cpChargeQualificationDao.upFeeStatus(selCpPageInPut);
                }catch (Exception e){
                log.error("收费资质审核状态更新 selCpPageInPut="+selCpPageInPut+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upFeeStatus error!",e);
                }
            }
        });
        return 1;
    }
    /**
     * CP资质管理审核查询
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpChargeById(int id) {
        return cpChargeQualificationDao.findCpChargeById(id);
    }
    /**
     * CP审核通过操作
     * @param selCpPageInPut
     * @return int
     */
    public int upCpCharge(final SelCpPageInPut selCpPageInPut) {
        TransactionTemplate template=getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    cpChargeQualificationDao.upCpCharge(selCpPageInPut);
                }catch (Exception e){
                log.error("CP审核通过操作 selCpPageInPut="+selCpPageInPut+" error!",e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upCpCharge error!",e);
                }
            }
        });
        return 1;
    }

    public CpChargeQualificationDao getCpChargeQualificationDao() {
        return cpChargeQualificationDao;
    }

    public void setCpChargeQualificationDao(CpChargeQualificationDao cpChargeQualificationDao) {
        this.cpChargeQualificationDao = cpChargeQualificationDao;
    }
}
