package com.jd.cms.dao.appManagement;

import com.jd.cms.domain.appManagement.*;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.common.util.base.BaseQuery;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public interface SalesStatisticsDao {
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
    List<PhoneIntallMess> getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter);

    Integer getPhoneImeiInstallMessCounts(PhoneIntallMessParameter phoneIntallMessParameter);

    /**
     * 按天查看应用的安装情况
     *
     * @return
     */
    List<DayIntallLog> byDayCheckInstall(BaseQuery baseQuery);

    /**
     * 按天查看应用的安装情况
     * 导出EXcel
     *
     * @return
     */
    List<DayIntallLog> byDayCheckInstallExcel();


    Integer installMessCount();

    /**
     * 按渠道查看安装的手机台数
     *
     * @param provinceStatisParameter
     * @return
     */
    List<ProvinceStatisRes> installByChannel(ProvinceStatisParameter provinceStatisParameter);

    /**
     * 安装的促销员个数
     *
     * @param provinceStatisParameter
     * @return
     */
    List<ProvinceStatisRes> intallSalerTime(ProvinceStatisParameter provinceStatisParameter);

    /**
     * 收入统计
     *
     * @param provinceStatisParameter
     * @return
     */
    List<ProvinceStatisRes> getIncome(ProvinceStatisParameter provinceStatisParameter);

    /**
     * 安装的应用到达数量
     *
     * @param provinceStatisParameter
     * @return
     */
    List<ProvinceStatisRes> getArrTimes(ProvinceStatisParameter provinceStatisParameter);

    /**
     * 判断某渠道是否有记录
     *
     * @param instaisticNorm
     * @return
     */
    Integer getInstaisticNorm(InstaisticNorm instaisticNorm);

    /**
     * 创建渠道的统计标准
     * param instaisticNorm
     */
    void createInstaisticNorm(InstaisticNorm instaisticNorm);

    /**
     * 更新渠道的统计标准
     *aa
     * @param instaisticNorm
     */
    void updateInstaisticNorm(InstaisticNorm instaisticNorm);

    /**
     * 获取渠道的统计标准r
     *
     * @return
     */
    List<InstaisticNorm> getInstaisticNormList(String time);

    /**
     * 取得当前的渠道的名称和ID
     *
     * @return
     */
    List<InstaisticNorm> getPadName();

    Map channelName();


    Map appName();


    List<Integer> searchAppName(String appName);




}