package com.jd.cms.manager.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-25.
 */
public interface AppPriceManager {

    List<AppPrice> appPriceList(AppPriceParameter appPriceParameter);

    void createAppPrice(AppPrice  appPrice);

    AppPrice modifyAppPrice(Integer id);

    void deleteAppPrice(Integer id);

    void updateAppPrice(AppPrice appPrice);

}
