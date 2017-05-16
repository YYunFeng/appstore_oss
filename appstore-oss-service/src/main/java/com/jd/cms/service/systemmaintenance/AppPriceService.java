package com.jd.cms.service.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.AppPrice;
import com.jd.cms.domain.systemmaintenance.AppPriceParameter;
import com.jd.common.web.result.Result;


/**
 * Created by YUNFENG on 14-2-25.
 */
public interface AppPriceService {

    Result appPriceList(AppPriceParameter appPriceParameter);

    void createAppPrice(AppPrice appPrice);

    Result modifyAppPrice(Integer id);

    void deleteAppPrice(Integer id);

    void updateAppPrice(AppPrice appPrice);
}
