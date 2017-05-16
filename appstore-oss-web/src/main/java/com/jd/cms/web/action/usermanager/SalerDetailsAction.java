package com.jd.cms.web.action.usermanager;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.usermanager.SalerDetailsJSON;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.cms.service.usermanager.SalerDetailsService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetailsAction extends BaseAction {
    private SalerDetailsService salerDetailsService;
    private SalerDetailsParameter salerDetailsParameter;
    private String salerNo;
    private Saler saler;

    /**
     * 获取促销员信息列表
     *
     * @return
     */
    public String salerDetailsManager() {
        if (salerDetailsParameter == null) {
            salerDetailsParameter = new SalerDetailsParameter();
        }
        Result result = salerDetailsService.getSalerDetails(salerDetailsParameter, page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 删除促销员信息
     *
     * @throws JSONException
     * @throws IOException
     */
    public void deleteSalerDetails() throws JSONException, IOException {
        SalerDetailsJSON salerDetailsJSON = new SalerDetailsJSON();
        try {
            if (salerNo != null) {
                salerDetailsService.deleteSalerDetails(salerNo);
                salerDetailsJSON.setStatus(1);
                salerDetailsJSON.setMess("删除成功");
            } else {
                salerDetailsJSON.setStatus(0);
                salerDetailsJSON.setMess("删除失败,id未空");
            }
        } catch (Exception e) {
            salerDetailsJSON.setStatus(0);
            salerDetailsJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(salerDetailsJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 修改促销员信息
     *
     * @return
     */
    public String modifySalerDetails() {
        try {
            Result result = salerDetailsService.getSalerDetailsById(salerNo);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 获取督导和店长的列表
     */
    public String salerList() {
        Result result = salerDetailsService.salerList(salerDetailsParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 修改入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void updateSalerDetails() throws JSONException, IOException {
        SalerDetailsJSON salerDetailsJSON = new SalerDetailsJSON();
        try {
            if (saler != null) {
                salerDetailsService.updateSalerDetails(saler);
                salerDetailsJSON.setStatus(1);
                salerDetailsJSON.setMess("更新成功");
            } else {
                salerDetailsJSON.setStatus(0);
                salerDetailsJSON.setMess("salerDetails未空");
            }
        } catch (Exception e) {
            salerDetailsJSON.setStatus(0);
            salerDetailsJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(salerDetailsJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public void setSalerDetailsService(SalerDetailsService salerDetailsService) {
        this.salerDetailsService = salerDetailsService;
    }


    public SalerDetailsParameter getSalerDetailsParameter() {
        return salerDetailsParameter;
    }

    public void setSalerDetailsParameter(SalerDetailsParameter salerDetailsParameter) {
        this.salerDetailsParameter = salerDetailsParameter;
    }

    public String getSalerNo() {
        return salerNo;
    }

    public void setSalerNo(String salerNo) {
        this.salerNo = salerNo;
    }


    public Saler getSaler() {
        return saler;
    }

    public void setSaler(Saler saler) {
        this.saler = saler;
    }
}
