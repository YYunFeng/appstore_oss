package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.AppPriceDao;
import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;
import com.jd.cms.manager.systemmaintenance.AppPriceManager;
import com.jd.common.manager.BaseManager;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class AppPriceManagerImpl extends BaseManager implements AppPriceManager {
    private AppPriceDao appPriceDao;

    public List<AppPrice> appPriceList(AppPriceParameter appPriceParameter) {
        return appPriceDao.appPriceList(appPriceParameter);
    }

    public void createAppPrice(AppPrice appPriceCompany) {
        appPriceDao.createAppPrice(appPriceCompany);
    }

    public AppPrice modifyAppPrice(Integer id) {
        return appPriceDao.modifyAppPrice(id);
    }

    public void deleteAppPrice(Integer id) {
        appPriceDao.deleteAppPrice(id);
    }

    public void updateAppPrice(AppPrice appPrice) {
        appPriceDao.updateAppPrice(appPrice);
    }

    public void setAppPriceDao(AppPriceDao appPriceDao) {
        this.appPriceDao = appPriceDao;
    }
}
