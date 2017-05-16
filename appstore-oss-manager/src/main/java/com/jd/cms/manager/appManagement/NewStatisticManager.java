package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.NewStatisticObj;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * YYF on 2015/4/16.
 */
public interface NewStatisticManager {

    /**
     * 应用安装总数
     *
     * @param marketStatInput
     * @return
     */
    NewStatisticObj appInstallTotal(MarketStatInput marketStatInput);

    /**
     * 安装总量按应用查看
     *
     * @param marketStatInput
     * @return
     */
    PaginatedList<NewStatisticObj> totalByApp(MarketStatInput marketStatInput,int pageIndex, int pageSize);

    /**
     * 安装总量按渠道查看
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> totalByChannel(MarketStatInput marketStatInput);


    /**
     * 查看渠道下店长和督导的安装量
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> channelBySaler(MarketStatInput marketStatInput);


    /**
     * 查看督导或者店长下所有促销员的安装量
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> channelBySalerDetails(MarketStatInput marketStatInput);

    /**
     * 查看促销员的安装的应用
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> appBySalerNo(MarketStatInput marketStatInput);

    /**
     * 按渠道类型查看
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> channelType(MarketStatInput marketStatInput);
}
