package com.jd.cms.service.systemmaintenance.impl;

import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;
import com.jd.cms.manager.systemmaintenance.AppPriceManager;
import com.jd.cms.service.systemmaintenance.AppPriceService;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class AppPriceServiceImpl implements AppPriceService {
    private AppPriceManager appPriceManager;

    public Result appPriceList(AppPriceParameter appPriceParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("appPriceList", appPriceManager.appPriceList(appPriceParameter));
            result.addDefaultModel("appPriceParameter", appPriceParameter);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    public void createAppPrice(AppPrice appPrice) {
        appPriceManager.createAppPrice(appPrice);
    }

    public Result modifyAppPrice(Integer id) {
        Result result = new Result();
        try {
            result.addDefaultModel("appPrice", appPriceManager.modifyAppPrice(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteAppPrice(Integer id) {
        appPriceManager.deleteAppPrice(id);
    }

    public void updateAppPrice(AppPrice appPrice) {
        appPriceManager.updateAppPrice(appPrice);
    }

    public void setAppPriceManager(AppPriceManager appPriceManager) {
        this.appPriceManager = appPriceManager;
    }
}
