package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpDateImportJSON;
import com.jd.cms.domain.clientmanager.SuningJSON;
import com.jd.cms.job.ImportCpDate;
import com.jd.cms.service.clientmanager.CpDateImportService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CpDateImportAction extends BaseAction {
    private CpDateImportService cpDateImportService;
    private CpDateImport cpDateImport;
    private ImportCpDate importCpDate;
    private Integer id;

    /**
     * CP激活数据导入
     */
    public String cpDateImport() {
        Result result = cpDateImportService.getCpDateImport(page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    public String addCpDateImport() {
        return SUCCESS;
    }

    public void saveCpDateImport() throws JSONException, IOException {
        CpDateImportJSON cpDateImportJSON = new CpDateImportJSON();
        try {
            if (cpDateImport.getFileUrl() != null) {
                Integer id = cpDateImportService.createCpDateImport(cpDateImport);
                importCpDate.setAppid(cpDateImport.getAppid());
                importCpDate.setId(id);
                importCpDate.setFileName(cpDateImport.getFileUrl());
                Thread thread = new Thread(importCpDate);
                thread.start();
                cpDateImportJSON.setCode(1);
                cpDateImportJSON.setMess("成功");
            }
        } catch (Exception e) {
            cpDateImportJSON.setCode(0);
            cpDateImportJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(cpDateImportJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public void deleteCpDateImport() throws JSONException, IOException {
        CpDateImportJSON cpDateImportJSON = new CpDateImportJSON();
        try {
            if (id != null) {
                cpDateImportService.deletCpDateImport(id);
                cpDateImportJSON.setCode(1);
                cpDateImportJSON.setMess("删除成功");
            }
        } catch (Exception e) {
            cpDateImportJSON.setCode(0);
            cpDateImportJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(cpDateImportJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public void setCpDateImportService(CpDateImportService cpDateImportService) {
        this.cpDateImportService = cpDateImportService;
    }

    public CpDateImport getCpDateImport() {
        return cpDateImport;
    }

    public void setCpDateImport(CpDateImport cpDateImport) {
        this.cpDateImport = cpDateImport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImportCpDate(ImportCpDate importCpDate) {
        this.importCpDate = importCpDate;
    }
}
