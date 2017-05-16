package com.jd.cms.dao.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
public interface AndroidDriverDao {
    List<AndroidDriver> findAndroidDriver(Query query);
    int getAndroidDriverCount();
    void deleteAndroidDriver(AndroidDriver androidDriver);
    void createAndroidDriver(AndroidDriver androidDriver);
    AndroidDriver findAndroidDriverById(AndroidDriver androidDriver);
    void updateAndroidDriver(AndroidDriver androidDriver);
}
