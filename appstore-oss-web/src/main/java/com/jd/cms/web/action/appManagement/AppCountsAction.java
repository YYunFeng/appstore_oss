package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.service.appManagement.AppCountsService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by YUNFENG on 14-2-17.
 */
public class AppCountsAction extends BaseAction {
    private AppCountParameter appCountParameter;
    private AppCountsService appCountsService;
    private Integer metohFlag;

    public String appCount() {
        return SUCCESS;
    }

    public String getCountAppsByCp() {
        try {
            Result result = appCountsService.getCountAppsByCp(appCountParameter, page, PAGE_SIZE);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getCountAppsByApp() {
        try {
            Result result = appCountsService.getCountAppByApp(appCountParameter, page, PAGE_SIZE);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


    public void exportExcel() throws IOException, JSONException {
        ExportExcelJSON exportExcelJSON = appCountsService.getCountAppExcel(appCountParameter, metohFlag);
        String json = JSONUtil.serialize(exportExcelJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public Integer getMetohFlag() {
        return metohFlag;
    }

    public void setMetohFlag(Integer metohFlag) {
        this.metohFlag = metohFlag;
    }

    public AppCountParameter getAppCountParameter() {
        return appCountParameter;
    }

    public void setAppCountParameter(AppCountParameter appCountParameter) {
        this.appCountParameter = appCountParameter;
    }

    public void setAppCountsService(AppCountsService appCountsService) {
        this.appCountsService = appCountsService;
    }
}
