package com.jd.cms.service.cpQualityManagement.impl;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.manager.cpQualityManagement.CpQualityManagementManager;
import com.jd.cms.service.cpQualityManagement.CpQualityManagementService;
import com.jd.common.web.result.Result;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * CP账号管理serviceImpl
 */
public class CpQualityManagementServiceImpl implements CpQualityManagementService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(CpQualityManagementServiceImpl.class);
    /**
     * managerCached注入
     */
    private CpQualityManagementManager cpQualityManagementManagerCached;

    /**
     * CP账号管理分页查询
     */
    public Result findCpPage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("SelCpPageOutPuts", cpQualityManagementManagerCached.findCpPage(selCpPageInPut, pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CP账号管理分页查询 selCpPageInPut=" + selCpPageInPut + " pageIndex=" + pageIndex + " pageSize=" + pageSize + " error!", e);
        }
        return result;
    }

    /**
     * CP帐号的启用停用
     */
    public Result upAccountStatus(SelCpPageInPut selCpPageInPut) {
        Result result = new Result();
        try {
            int isSuccess = cpQualityManagementManagerCached.upAccountStatus(selCpPageInPut);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "CP帐号的启用停用成功");
            } else {
                result.addDefaultModel("info", "CP帐号的启用停用失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CP帐号的启用停用 selCpPageInPut=" + selCpPageInPut + " error!", e);
        }
        return result;
    }

    /**
     * CP帐号管理查看详情
     */
    public Result findCpExpatiation(int id) {
        Result result = new Result();
        try {
            result.addDefaultModel("SelCpPageOutPut", cpQualityManagementManagerCached.findCpExpatiation(id));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CP帐号管理查看详情 id=" + id + " error!", e);
        }
        return result;
    }

    /**
     * CP帐号的删除
     */
    public int delCp(SelCpPageInPut selCpPageInPut) {
        int isSuccess = -1;
        try {
            isSuccess = cpQualityManagementManagerCached.delCp(selCpPageInPut);
        } catch (Exception e) {
            log.error("CP帐号的删除 selCpPageInPut=" + selCpPageInPut + " error!", e);
        }
        return isSuccess;
    }

    public Result getChannelCp(PadChannel padChannel, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("padChannels", cpQualityManagementManagerCached.findChannelCp(padChannel, pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createPadChannel(PadChannel padChannel) {
        try {
            cpQualityManagementManagerCached.createPadChannel(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePadChannel(int id) {
        try {
            cpQualityManagementManagerCached.deletePadChannel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePadChannel(PadChannel padChannel) {
        try {
            cpQualityManagementManagerCached.updatePadChannel(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Result getPadChannelById(int id) {
        Result result = new Result();
        try {
            result.addDefaultModel("padChannel", cpQualityManagementManagerCached.getPadChannelById(id));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result relevanceCp(int id) {
        Result result = new Result();
        PadChannel padChannel = new PadChannel();
        try {
            padChannel.setId(id);
            if (cpQualityManagementManagerCached.relevanceCp(id)) {
                padChannel.setFlag(1); // 已经关联
            } else {
                padChannel.setFlag(0); // 未关联
            }
            result.addDefaultModel("padChannel", padChannel);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result saveRelevanceCp(PadChannel padChannel) {
        Result result = new Result();
        try {
            cpQualityManagementManagerCached.saveRelevanceCp(padChannel);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

    public CpQualityManagementManager getCpQualityManagementManagerCached() {
        return cpQualityManagementManagerCached;
    }

    public void setCpQualityManagementManagerCached(CpQualityManagementManager cpQualityManagementManagerCached) {
        this.cpQualityManagementManagerCached = cpQualityManagementManagerCached;
    }
}
