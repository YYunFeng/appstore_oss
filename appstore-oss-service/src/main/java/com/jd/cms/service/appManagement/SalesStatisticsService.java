package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.*;
import com.jd.common.web.result.Result;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public interface SalesStatisticsService {
    /**
     * 获取促销员排名
     *
     * @return
     */
    Result getSalerRanking(SalerRankingParameter salerRankingParameter);

    /**
     * 手机安装应用详细信息
     *
     * @return
     */
    Result getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter,int pageIndex,int pageSize );

    /**
     * 按每天查看应用安装情况
     *
     * @return
     */
    Result getDayInstallMess(int pageIndex,int pageSize);


    /**
     * 省份统计
     *
     * @param provinceStatisParameter
     * @return
     */
    Result provinceStatis(ProvinceStatisParameter provinceStatisParameter);



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


    Result padChannelList();
}
