package com.jd.cms.manager.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public interface AndroidDriverManager {
    PaginatedList<AndroidDriver> findAndroidDriver(int pageIndex, int pageSize);
    void deleteAndroidDriver(AndroidDriver androidDriver);
    void createAndroidDriver(AndroidDriver androidDriver);
    AndroidDriver findAndroidDriverById(AndroidDriver androidDriver);
    void updateAndroidDriver(AndroidDriver androidDriver);
}
