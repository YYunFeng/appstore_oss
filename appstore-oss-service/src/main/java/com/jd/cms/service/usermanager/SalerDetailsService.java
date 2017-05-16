package com.jd.cms.service.usermanager;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public interface SalerDetailsService {

    Result getSalerDetails(SalerDetailsParameter salerDetailsParameter, int pageIndex, int pageSize);


    void deleteSalerDetails(String salerNo);

    Result getSalerDetailsById(String salerNo);


    Result salerList(SalerDetailsParameter salerDetailsParameter);

    void updateSalerDetails(Saler saler);
}
