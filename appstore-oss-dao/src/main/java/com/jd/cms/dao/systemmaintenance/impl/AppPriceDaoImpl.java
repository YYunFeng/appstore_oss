package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.AppPriceDao;
import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class AppPriceDaoImpl extends BaseDao implements AppPriceDao {
    public List<AppPrice> appPriceList(AppPriceParameter appPriceParameter) {
        return queryForList("SystemMaintenance.appPriceList", appPriceParameter);
    }

    public void createAppPrice(AppPrice appPrice) {
        insert("SystemMaintenance.createAppPrice", appPrice);
    }

    public AppPrice modifyAppPrice(Integer id) {
        return (AppPrice) queryForObject("SystemMaintenance.modifyAppPrice", id);
    }

    public void deleteAppPrice(Integer id) {
        delete("SystemMaintenance.deleteAppPrice", id);
    }

    public void updateAppPrice(AppPrice appPrice) {
        update("SystemMaintenance.updateAppPrice", appPrice);
    }
}
