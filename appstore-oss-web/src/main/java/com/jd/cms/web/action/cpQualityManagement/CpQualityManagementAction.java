package com.jd.cms.web.action.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.service.cpQualityManagement.CpQualityManagementService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * CP账号管理action
 */
public class CpQualityManagementAction extends BaseAction {
    /**
     * service注入
     */
    private CpQualityManagementService cpQualityManagementService;
    /**
     * 页面数据接收
     */
    private SelCpPageInPut selCpPageInPut;
    /**
     * message
     */
    private String message;

    private PadChannel padChannel;


    /**
     * 页面id接收
     */
    private int id;

    /**
     * CP账号管理分页查询
     *
     * @return String
     * @throws Exception
     */
    public String findCpPage() throws Exception {
        message = Integer.toString(hashCode());
        if (null == selCpPageInPut) {
            selCpPageInPut = new SelCpPageInPut();
        }
        Result results = cpQualityManagementService.findCpPage(selCpPageInPut, page, PAGE_SIZE);
        toVm(results);
        return SUCCESS;
    }

    /**
     * 渠道维护
     *
     * @return
     */
    public String findPadChannel() {
        if (null == padChannel) {
            padChannel = new PadChannel();
        }
        Result results = cpQualityManagementService.getChannelCp(padChannel, page, PAGE_SIZE);
        toVm(results);
        return "PADCHANNELLIST";
    }

    public String addPadChannel() {
        return SUCCESS;
    }

    public String savePadChannel() {
        try {
            cpQualityManagementService.createPadChannel(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findPadChannel();
    }

    public String deletePadChannel() {
        try {
            cpQualityManagementService.deletePadChannel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findPadChannel();
    }

    public String updatePadChannel() {
        try {
            cpQualityManagementService.updatePadChannel(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findPadChannel();
    }

    public String modifyChannel() {
        try {
            Result result = cpQualityManagementService.getPadChannelById(id);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * CP帐号的启用停用
     *
     * @return String
     * @throws Exception
     */
    public String upAccountStatus() throws Exception {
        cpQualityManagementService.upAccountStatus(selCpPageInPut);
        return null;
    }

    /**
     * CP帐号管理查看详情
     *
     * @return String
     * @throws Exception
     */
    public String findCpExpatiation() throws Exception {
        Result result = cpQualityManagementService.findCpExpatiation(id);
        toVm(result);
        return "CPEXPATIATION";
    }

    public String relevanceCp() {
        Result result = cpQualityManagementService.relevanceCp(id);
        toVm(result);
        return SUCCESS;
    }

    public String createRelevanceCp() {
        try {
            cpQualityManagementService.saveRelevanceCp(padChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findPadChannel();
    }

    /**
     * CP帐号的删除
     *
     * @return String
     * @throws Exception
     */
    public String delCp() throws Exception {
        int mark = cpQualityManagementService.delCp(selCpPageInPut);
        String json = JSONUtil.serialize(mark);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }

    /**
     * CP资质管理加载项
     *
     * @return String
     */
    public String init() {
        return "INIT";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CpQualityManagementService getCpQualityManagementService() {
        return cpQualityManagementService;
    }

    public void setCpQualityManagementService(CpQualityManagementService cpQualityManagementService) {
        this.cpQualityManagementService = cpQualityManagementService;
    }

    public PadChannel getPadChannel() {
        return padChannel;
    }

    public void setPadChannel(PadChannel padChannel) {
        this.padChannel = padChannel;
    }
}
