package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.common.web.result.Result;

/**
 * YYF on 2015/4/16.
 */
public interface NewStatisticService {

    Result appIntallTotal(MarketStatInput marketStatInput);

    Result totalByApp(MarketStatInput marketStatInput, int pageIndex, int pageSize);

    Result totalByChannel(MarketStatInput marketStatInput);

    Result channelBySaler(MarketStatInput marketStatInput);

    Result channelType(MarketStatInput marketStatInput);

    Result channelBySalerDetails(MarketStatInput marketStatInput);

    Result appBySalerNo(MarketStatInput marketStatInput);

}
