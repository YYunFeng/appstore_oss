package com.jd.cms.dao.appManagement;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.NewStatisticObj;

import java.util.List;

/**
 * 新版统计
 * YYF on 2015/4/16.
 */
public interface NewStatisticDao {

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
    List<NewStatisticObj> totalByApp(MarketStatInput marketStatInput);

    /**
     * 查看有多少应用数
     *
     * @param marketStatInput
     * @return
     */
    Integer totalByAppCounts(MarketStatInput marketStatInput);


    /**
     * 安装总量按渠道查看
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> totalByChannel(MarketStatInput marketStatInput);


    /**
     * 安装按照渠道类型查看
     *
     * @param marketStatInput
     * @return
     */
    List<NewStatisticObj> channelType(MarketStatInput marketStatInput);


    /**
     * 店长和督导列表
     *
     * @return
     */
    List<String> salerList(Integer cid);

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
}
