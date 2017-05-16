package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.AndroidDriverDao;
import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 上午11:54
 * To change this template use File | Settings | File Templates.
 */
public class AndroidDriverDaoImpl extends BaseDao implements AndroidDriverDao{
    public List<AndroidDriver> findAndroidDriver(Query query) {
        return queryForList("SystemMaintenance.findAndroidDriver", query);
    }

    public int getAndroidDriverCount() {
        return (Integer)queryForObject("SystemMaintenance.getAndroidDriverCount");
    }

    public void deleteAndroidDriver(AndroidDriver androidDriver) {
        delete("SystemMaintenance.deleteAndroidDriver", androidDriver);
    }

    public void createAndroidDriver(AndroidDriver androidDriver) {
        insert("SystemMaintenance.createAndroidDriver", androidDriver);
    }

    public AndroidDriver findAndroidDriverById(AndroidDriver androidDriver) {
        return (AndroidDriver)queryForObject("SystemMaintenance.findAndroidDriverById", androidDriver);
    }

    public void updateAndroidDriver(AndroidDriver androidDriver){
        update("SystemMaintenance.updateAndroidDriver", androidDriver);
    }
}
