package com.jd.cms.service.cpQualityManagement.impl;

import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.cms.manager.cpQualityManagement.CpChargeQualificationManager;
import com.jd.cms.service.cpQualityManagement.CpChargeQualificationService;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.domain.bean.vendor.VendorDO;
import com.jd.digital.common.rpc.domain.enumtype.vendor.PurchaseTypeEnum;
import com.jd.digital.common.rpc.manager.vendor.VendorManager;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核serviceImpl
 */
public class CpChargeQualificationServiceImpl implements CpChargeQualificationService {
    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(CpChargeQualificationServiceImpl.class);
    /**
     * vendorManager接口注入
     */
    private VendorManager vendorManager;
    /**
     * managerCached注入
     */
    private CpChargeQualificationManager cpChargeQualificationManagerCached;

    /**
     * 取得cp收费资质信息集合
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return Result
     */
    public Result findCpChargePage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("SelCpPageOutPuts", cpChargeQualificationManagerCached.findCpChargePage(selCpPageInPut, pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得cp收费资质信息集合 selCpPageInPut=" + selCpPageInPut + " pageIndex=" + pageIndex + " pageSize=" + pageSize + " error!", e);
        }
        return result;
    }

    /**
     * 收费资质审核状态更新
     *
     * @param selCpPageInPut
     * @return Result
     */
    public Result upFeeStatus(SelCpPageInPut selCpPageInPut) {
        Result result = new Result();
        try {
            int isSuccess = cpChargeQualificationManagerCached.upFeeStatus(selCpPageInPut);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "收费资质审核状态更新成功");
            } else {
                result.addDefaultModel("info", "收费资质审核状态更新失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("收费资质审核状态更新 selCpPageInPut=" + selCpPageInPut + " error!", e);
        }
        return result;
    }

    /**
     * CP资质管理审核查询
     *
     * @param id
     * @return Result
     */
    public Result findCpChargeById(int id) {
        Result result = new Result();
        try {
            /*根据Id查询单条CP审核信息*/
            SelCpPageOutPut selCpPageOutPut = cpChargeQualificationManagerCached.findCpChargeById(id);
            result.addDefaultModel("SelCpPageOutPut", selCpPageOutPut);
            /*获取供应商简码*/
            List<VendorDO> Vendors = vendorManager.getVendorList(String.valueOf(selCpPageOutPut.getCertificateType()+1),selCpPageOutPut.getCertificateNo(), PurchaseTypeEnum.APPSTORE);
//            List<VendorDO> Vendors = vendorManager.getVendorList("1", "123456789", PurchaseTypeEnum.APPSTORE);
            result.addDefaultModel("Vendors", Vendors);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CP资质管理审核查询 id=" + id + " error!", e);
        }
        return result;
    }

    /**
     * CP审核通过操作
     *
     * @param selCpPageInPut
     * @return Result
     */
    public Result upCpCharge(SelCpPageInPut selCpPageInPut) {
        Result result = new Result();
        try {
            int isSuccess = cpChargeQualificationManagerCached.upCpCharge(selCpPageInPut);
            if (0 != isSuccess) {
                result.addDefaultModel("info", "CP审核通过操作成功");
            } else {
                result.addDefaultModel("info", "CP审核通过操作失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("CP审核通过操作 selCpPageInPut=" + selCpPageInPut + " error!", e);
        }
        return result;
    }

    public VendorManager getVendorManager() {
        return vendorManager;
    }

    public void setVendorManager(VendorManager vendorManager) {
        this.vendorManager = vendorManager;
    }

    public CpChargeQualificationManager getCpChargeQualificationManagerCached() {
        return cpChargeQualificationManagerCached;
    }

    public void setCpChargeQualificationManagerCached(CpChargeQualificationManager cpChargeQualificationManagerCached) {
        this.cpChargeQualificationManagerCached = cpChargeQualificationManagerCached;
    }
}
