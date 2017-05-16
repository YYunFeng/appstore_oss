package com.jd.cms.web.action.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceJSON;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;
import com.jd.cms.service.systemmaintenance.AppPriceService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class AppPriceAction extends BaseAction {
    private AppPriceService appPriceService;
    private AppPrice appPrice;
    private Integer id;
    private AppPriceParameter appPriceParameter;

    public String appPrice() {
        try {
            Result result = appPriceService.appPriceList(appPriceParameter);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String createAppPrice() {
        return SUCCESS;
    }

    public void saveAppPrice() throws JSONException, IOException {
        AppPriceJSON appPriceJSON = new AppPriceJSON();
        try {
            if (appPrice != null) {
                appPriceService.createAppPrice(appPrice);
                appPriceJSON.setStatus(1);
                appPriceJSON.setMess("成功");
            }
        } catch (Exception e) {
            appPriceJSON.setStatus(0);
            appPriceJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(appPriceJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public String modifyAppPrice() {
        Result result = appPriceService.modifyAppPrice(id);
        toVm(result);
        return SUCCESS;
    }

    public void updateAppPrice() throws JSONException, IOException {
        AppPriceJSON appPriceJSON = new AppPriceJSON();
        try {
            if (appPrice != null) {
                appPriceService.updateAppPrice(appPrice);
                appPriceJSON.setStatus(1);
                appPriceJSON.setMess("成功");
            }
        } catch (Exception e) {
            appPriceJSON.setStatus(0);
            appPriceJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(appPriceJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void deleteAppPrice() throws JSONException, IOException {
        AppPriceJSON appPriceJSON = new AppPriceJSON();
        try {
            if (id != null) {
                appPriceService.deleteAppPrice(id);
                appPriceJSON.setStatus(1);
                appPriceJSON.setMess("成功");
            }
        } catch (Exception e) {
            appPriceJSON.setStatus(0);
            appPriceJSON.setMess("系统异常");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(appPriceJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public AppPrice getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(AppPrice appPrice) {
        this.appPrice = appPrice;
    }

    public void setAppPriceService(AppPriceService appPriceService) {
        this.appPriceService = appPriceService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppPriceParameter getAppPriceParameter() {
        return appPriceParameter;
    }

    public void setAppPriceParameter(AppPriceParameter appPriceParameter) {
        this.appPriceParameter = appPriceParameter;
    }
}
