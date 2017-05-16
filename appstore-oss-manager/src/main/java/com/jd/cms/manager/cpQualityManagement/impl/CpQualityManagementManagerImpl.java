package com.jd.cms.manager.cpQualityManagement.impl;

import com.jd.cms.dao.cpQualityManagement.CpQualityManagementDao;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.cpQualityManagement.CpQualityManagementManager;
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
 * Time: 下午3:01
 * CP账号管理ManagerCachedImpl
 */
public class CpQualityManagementManagerImpl extends BaseManager implements CpQualityManagementManager {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(CpQualityManagementManagerImpl.class);
    /**
     * DAO注入
     */
    private CpQualityManagementDao cpQualityManagementDao;
    /**
     * 标记,用于外部使用
     */
    int mark;

    /**
     * CP账号管理分页查询
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    public PaginatedList<SelCpPageOutPut> findCpPage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        /*new一个新的条件对象*/
        SelCpPageInPut newCpPageInPut = new SelCpPageInPut();
        /*进行模糊查询处理*/
        if (StringUtils.isNotBlank(selCpPageInPut.getAccount())) {
            newCpPageInPut.setAccount("%" + selCpPageInPut.getAccount() + "%");
        }
        if (StringUtils.isNotBlank(selCpPageInPut.getCpName())) {
            newCpPageInPut.setCpName("%" + selCpPageInPut.getCpName() + "%");
        }
        if (StringUtils.isNotBlank(selCpPageInPut.getContacter())) {
            newCpPageInPut.setContacter("%" + selCpPageInPut.getContacter() + "%");
        }
        if (StringUtils.isNotBlank(selCpPageInPut.getMobile())) {
            newCpPageInPut.setMobile("%" + selCpPageInPut.getMobile() + "%");
        }
        newCpPageInPut.setCpProperty(selCpPageInPut.getCpProperty());
        newCpPageInPut.setAccountStatus(selCpPageInPut.getAccountStatus());
        /*首次页数置一*/
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        /*取得cp的总记录数*/
        int totalItem = cpQualityManagementDao.getCpCount(newCpPageInPut);

        PaginatedList<SelCpPageOutPut> CpList = new PaginatedArrayList<SelCpPageOutPut>(pageIndex, pageSize);

        CpList.setTotalItem(totalItem);
        /*分页条件*/
        newCpPageInPut.setStartRow((pageIndex - 1) * pageSize);
        newCpPageInPut.setEndRow(pageSize);
        /*取得cp信息集合*/
        List<SelCpPageOutPut> cpPageOutPutsList = cpQualityManagementDao.findCpPage(newCpPageInPut);

        CpList.addAll(cpPageOutPutsList);
        return CpList;
    }

    /**
     * CP帐号的启用停用
     *
     * @param selCpPageInPut
     * @return int
     */
    public int upAccountStatus(final SelCpPageInPut selCpPageInPut) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    cpQualityManagementDao.upAccountStatus(selCpPageInPut);
                } catch (Exception e) {
                    log.error("CP帐号的启用停用 selCpPageInPut=" + selCpPageInPut + " error!", e);
                    status.setRollbackOnly();
                    throw new RuntimeException("upAccountStatus error!", e);
                }
            }
        });
        return 1;
    }

    /**
     * CP帐号管理查看详情
     *
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpExpatiation(int id) {
        return cpQualityManagementDao.findCpExpatiation(id);
    }

    /**
     * CP帐号的删除
     *
     * @param selCpPageInPut
     * @return int
     */
    public int delCp(final SelCpPageInPut selCpPageInPut) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    /*接收Id集合*/
                    String idList = selCpPageInPut.getIdList();
                    /*将String转换成集合*/
                    String[] cp = idList.split(",");
                    /*初始标记，默认都可以开启*/
                    mark = 0;
                    /*循环Id进行操作*/
                    for (int i = 0; i < cp.length; i++) {
                        /*取得cp对应的app数量*/
                        Integer num = cpQualityManagementDao.getAppCount(Integer.parseInt(cp[i]));
                        /*如果此cp存在应用*/
                        if (0 < num) {
                            /*标记第一种提示信息*/
                            if (1 == cp.length) {
                                mark = 1;
                                /*标记第二种提示信息*/
                            } else {
                                mark = 2;
                            }
                        } else {
                            /*根据ID删除CP操作日志表*/
                            /* cpQualityManagementDao.delLog(selCpPageInPut);*/
                            /*根据ID删除cp注册信息表信息*/
                            cpQualityManagementDao.delReginfo(Integer.parseInt(cp[i]));
                            /*根据ID删除cp基本信息表信息*/
                            cpQualityManagementDao.delBaseinfo(Integer.parseInt(cp[i]));
                        }
                    }
                } catch (Exception e) {
                    log.error("CP帐号的删除 selCpPageInPut" + selCpPageInPut + " error!", e);
                    status.setRollbackOnly();
                    throw new RuntimeException("delCp error!", e);
                }
            }
        });
        /*返回标记用于页面提示信息*/
        return mark;
    }

    public PaginatedList<PadChannel> findChannelCp(PadChannel padChannel, int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<PadChannel> padChannels = new PaginatedArrayList<PadChannel>(pageIndex, pageSize);
        try {
            int totalItem = cpQualityManagementDao.getChannelCpCount();
            padChannels.setTotalItem(totalItem);
            padChannel.setStartRow((pageIndex - 1) * pageSize);
            padChannel.setEndRow(pageSize);
            List<PadChannel> pads = cpQualityManagementDao.getChannelCp(padChannel);
            padChannels.addAll(pads);
        } catch (Exception ex) {
            log.error("分页查询全部APK error!", ex);
            throw new RuntimeException("findChannelCp error!", ex);
        }
        return padChannels;
    }

    public void createPadChannel(final PadChannel padChannel) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int id = (int) sequenceUtil.get(SequenceConstants.PADCHANNEL_SEQUENCE);
                    padChannel.setId(id);
                    cpQualityManagementDao.createPadChannel(padChannel);
                } catch (Exception e) {
                    log.info("添加渠道 error", e);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("添加渠道  error!", e);
                }
            }
        });
    }

    public void deletePadChannel(int id) {
        try {
            cpQualityManagementDao.deletePadChannel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePadChannel(PadChannel padChannel) {
        try {
            cpQualityManagementDao.updatePadChannel(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PadChannel getPadChannelById(int id) {
        return cpQualityManagementDao.getPadChannelById(id);
    }

    public Boolean relevanceCp(int id) {
        return cpQualityManagementDao.relevanceCp(id);
    }

    public void saveRelevanceCp(PadChannel padChannel) {
        if (padChannel.getFlag() != null && padChannel.getFlag().intValue() == 1) {  // 已经关联
            cpQualityManagementDao.updateRelevanceCp(padChannel);
        } else if (padChannel.getFlag() != null && padChannel.getFlag().intValue() == 0) { // 未关联
            cpQualityManagementDao.createRelevanceCp(padChannel);
        }
    }

    public CpQualityManagementDao getCpQualityManagementDao() {
        return cpQualityManagementDao;
    }

    public void setCpQualityManagementDao(CpQualityManagementDao cpQualityManagementDao) {
        this.cpQualityManagementDao = cpQualityManagementDao;
    }
}
