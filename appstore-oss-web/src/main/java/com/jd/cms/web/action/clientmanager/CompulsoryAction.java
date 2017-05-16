package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.cms.domain.clientmanager.CompulsoryAppJSON;
import com.jd.cms.service.clientmanager.CompulsoryService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * 强制安装
 */
public class CompulsoryAction extends BaseAction {
    private CompulsoryService compulsoryService;
    private String appid;
    private Integer id;

    /**
     * 强制安装
     *
     * @return
     */
    public String compulsoryInstallation() {
        try {
            Result result =  compulsoryService.getInstallApps();
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public String addInstallApp() {
        return SUCCESS;
    }

    public void saveIntallApp() throws JSONException, IOException {
        CompulsoryAppJSON compulsoryAppJSON = new CompulsoryAppJSON();
        try {
            if (appid != null) {
                CompulsoryApp compulsoryApp = new CompulsoryApp();
                compulsoryApp.setAppid(appid);
                compulsoryService.createCompulsoryApp(compulsoryApp);
                compulsoryAppJSON.setCode(1);
                compulsoryAppJSON.setMess("添加成功");
            }
        } catch (Exception e) {
            compulsoryAppJSON.setCode(0);
            compulsoryAppJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(compulsoryAppJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public void deleteCompulsoryApp() throws JSONException, IOException {
        CompulsoryAppJSON compulsoryAppJSON = new CompulsoryAppJSON();
        try {
            if (id != null) {
                compulsoryService.deleteCompulsoryApp(id);
                compulsoryAppJSON.setCode(1);
                compulsoryAppJSON.setMess("删除成功");
            }
        } catch (Exception e) {
            compulsoryAppJSON.setCode(0);
            compulsoryAppJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(compulsoryAppJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompulsoryService(CompulsoryService compulsoryService) {
        this.compulsoryService = compulsoryService;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
