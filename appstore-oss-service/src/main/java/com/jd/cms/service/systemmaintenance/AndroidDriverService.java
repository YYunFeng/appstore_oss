package com.jd.cms.service.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AndroidDriver;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-5
 * Time: 下午12:15
 * To change this template use File | Settings | File Templates.
 */
public interface AndroidDriverService {
    Result findAndroidDriver(int pageIndex, int pageSize);
    void deleteAndroidDriver(AndroidDriver androidDriver);
    void createAndroidDriver(AndroidDriver androidDriver);
    Result findAndroidDriverById(AndroidDriver androidDriver);
    void updateAndroidDriver(AndroidDriver androidDriver);
}
