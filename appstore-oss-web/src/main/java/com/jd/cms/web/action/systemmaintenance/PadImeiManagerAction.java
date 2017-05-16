package com.jd.cms.web.action.systemmaintenance;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.cms.domain.systemmaintenance.PadImeiJSON;
import com.jd.cms.service.systemmaintenance.PadImeiNumberService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-8
 * Time: 下午2:13
 * To change this template use File | Settings | File Templates.
 */
public class PadImeiManagerAction extends BaseAction {
    private PadImeiNumberService padImeiNumberService;
    private PadImeiNumber padImeiNumber;
    private Integer id;
    private String imeiNumber;

    /**
     * padImei
     *
     * @return
     */
    public String padImeiList() {
        Result result = padImeiNumberService.getPadImeiList(page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 添加PadImei号
     *
     * @return
     */
    public String addPadImei() {
        return SUCCESS;
    }

    /**
     * 入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void savePadImei() throws JSONException, IOException {
        PadImeiJSON padImeiJSON = new PadImeiJSON();
        try {
            if (padImeiNumber != null) {
                PadImeiNumber padImeiTemp = padImeiNumberService.getPadImei(padImeiNumber.getImeiNumber());
                if (padImeiTemp == null) {
                    padImeiNumberService.createPadImeiNumber(padImeiNumber);
                    padImeiJSON.setStatus(1);
                    padImeiJSON.setMess("添加成功");
                    padImeiJSON.setCode("0");
                } else {
                    padImeiJSON.setCode("-1");
                    padImeiJSON.setStatus(0);
                    padImeiJSON.setMess("该IMEI已经存在");
                }
            }
        } catch (Exception e) {
            padImeiJSON.setCode("-1");
            padImeiJSON.setStatus(0);
            padImeiJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(padImeiJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 删除padImei
     */
    public void deletePadImei() throws JSONException, IOException {
        PadImeiJSON padImeiJSON = new PadImeiJSON();
        try {
            if (id != null) {
                padImeiNumberService.deletePadImei(id);
                padImeiJSON.setStatus(1);
                padImeiJSON.setMess("删除成功");
                padImeiJSON.setCode("0");
            }
        } catch (Exception e) {
            padImeiJSON.setCode("-1");
            padImeiJSON.setStatus(0);
            padImeiJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(padImeiJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 验证IMEI号是否存在
     *
     * @throws JSONException
     * @throws IOException
     */
    public void checkPadImei() throws JSONException, IOException {
        PadImeiJSON padImeiJSON = new PadImeiJSON();
        try {
            if (imeiNumber != null) {
                PadImeiNumber padImeiNumberTmp = padImeiNumberService.getPadImei(imeiNumber);
                if (padImeiNumberTmp != null) {
                    padImeiJSON.setStatus(0);
                    padImeiJSON.setMess("该IMEI号已经存在");
                    padImeiJSON.setCode("-1");
                } else {
                    padImeiJSON.setStatus(1);
                    padImeiJSON.setMess("该IMEI可以添加");
                    padImeiJSON.setCode("0");
                }
            }
        } catch (Exception e) {
            padImeiJSON.setCode("-1");
            padImeiJSON.setStatus(0);
            padImeiJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(padImeiJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public String modifyPadImei() {
        Result result = new Result();
        try {
            result.addDefaultModel("padImeiNumber", padImeiNumberService.getPadImei(imeiNumber));
            toVm(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void saveModifyPadImei() throws JSONException, IOException {
        PadImeiJSON padImeiJSON = new PadImeiJSON();
        try {
            if (padImeiNumber != null) {
                PadImeiNumber padImeiTemp = padImeiNumberService.getPadImei(padImeiNumber.getImeiNumber());
                if (padImeiTemp == null) {
                    padImeiNumberService.updatePadImei(padImeiNumber);
                    padImeiJSON.setStatus(1);
                    padImeiJSON.setMess("更新成功");
                    padImeiJSON.setCode("0");
                } else {
                    padImeiJSON.setCode("-1");
                    padImeiJSON.setStatus(0);
                    padImeiJSON.setMess("该IMEI已经存在");
                }
            }
        } catch (Exception e) {
            padImeiJSON.setCode("-1");
            padImeiJSON.setStatus(0);
            padImeiJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(padImeiJSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public void setPadImeiNumberService(PadImeiNumberService padImeiNumberService) {
        this.padImeiNumberService = padImeiNumberService;
    }

    public PadImeiNumber getPadImeiNumber() {
        return padImeiNumber;
    }

    public void setPadImeiNumber(PadImeiNumber padImeiNumber) {
        this.padImeiNumber = padImeiNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }
}
