package com.jd.cms.web.action.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.service.cpQualityManagement.CpChargeQualificationService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: qin
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核action
 */
public class CpChargeQualificationAction extends BaseAction {
    /**
     * service注入
     */
    private CpChargeQualificationService cpChargeQualificationService;
    /**
     * 页面数据接收
     */
    private SelCpPageInPut selCpPageInPut;
    /**
     * message
     */
    private String message;
    /**
     * 页面id接收
     */
    private int id;

    /**
     * CP资质管理分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findCpChargePage() throws Exception {
        message = Integer.toString(hashCode());
        if (null == selCpPageInPut) {
            selCpPageInPut = new SelCpPageInPut();
        }
        Result results = cpChargeQualificationService.findCpChargePage(selCpPageInPut, page, PAGE_SIZE);
        toVm(results);
        return SUCCESS;
    }



    /**
     * 收费资质审核状态更新为不通过i
     *
     * @return String
     * @throws Exception
     */
    public String upCpFeeStatus() throws Exception {
        cpChargeQualificationService.upFeeStatus(selCpPageInPut);
        return null;
    }

    /**
     * CP资质管理审核查询
     *
     * @return String
     * @throws Exception
     */
    public String findCpChargeExpatiation() throws Exception {
        Result result = cpChargeQualificationService.findCpChargeById(id);
        toVm(result);
        return "CPCHARGEEXPATIATION";
    }

    /**
     * CP审核通过操作
     *
     * @return String
     * @throws Exception
     */
    public String upCpChargeFeeStatusByOne() throws Exception {
        cpChargeQualificationService.upCpCharge(selCpPageInPut);
        return null;
    }

    public CpChargeQualificationService getCpChargeQualificationService() {
        return cpChargeQualificationService;
    }

    public void setCpChargeQualificationService(CpChargeQualificationService cpChargeQualificationService) {
        this.cpChargeQualificationService = cpChargeQualificationService;
    }

    public SelCpPageInPut getSelCpPageInPut() {
        return selCpPageInPut;
    }

    public void setSelCpPageInPut(SelCpPageInPut selCpPageInPut) {
        this.selCpPageInPut = selCpPageInPut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
