package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.appManagement.*;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public interface SalesStatisticsManager {
    /**
     * 获取促销员排名
     *
     * @return
     */
    List<SalerRankingRes> getSalerRanking(SalerRankingParameter salerRankingParameter);


    /**
     * 手机安装应用详细信息
     *
     * @return
     */
    PaginatedList<PhoneIntallMess> getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter, int pageIndex, int pageSize);


    /**
     * 手机安装应用详细信息EXcel
     *
     * @return
     */
    List<PhoneIntallMess> getPhoneInstallMessExcel(PhoneIntallMessParameter phoneIntallMessParameter);

    /**
     * 按天查看应用安装情况
     *
     * @return
     */
    PaginatedList<DayIntallLog> byDayCheckInstall(int pageIndex, int pageSize);

    /**
     * 按天查看应用的安装情况
     * 导出EXcel
     *
     * @return
     */
    List<DayIntallLog> byDayCheckInstallExcel();

    String getInstallLogExcelPath();

    /**
     * 省份统计
     *
     * @param provinceStatisParameter
     * @return
     */
    List<ProvinceStatisRes> provinceStatis(ProvinceStatisParameter provinceStatisParameter);



    /**
     * 判断某渠道是否有记录
     *
     * @param instaisticnorm
     * @return
     */
    Integer getInstaisticNorm(InstaisticNorm instaisticnorm);

    /**
     * 创建渠道的统计标准
     * param instaisticNorm
     */
    void createInstaisticNorm(InstaisticNorm instaisticNorm);

    /**
     * 更新渠道的统计标准
     *
     * @param instaisticNorm
     */
    void updateInstaisticNorm(InstaisticNorm instaisticNorm);


    /**
     * 渠道LIST
     * @return
     */
    List<PadChannel> padChannelList();

}
