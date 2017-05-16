package com.jd.cms.manager.usermanager;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public interface SalerDetailsManager {
    /**
     * 获取促销员列表
     *
     * @param salerDetailsParameter
     * @return
     */
    PaginatedList<SalerDetails> getSalerDetails(SalerDetailsParameter salerDetailsParameter, int pageIndex, int pageSize);


    /**
     * 刪除促销员信息
     *
     * @param id
     */
    void deleteSalerDetails(String salerNo);

    /**
     * 按Id得到促销员信息
     *
     * @param
     * @return
     */
    Saler getSalerDetailsById(String salerNo);


    /**
     * 更新促销员信息
     *
     * @param saler
     */
    void updateSalerDetails(Saler saler);

    /**
     * 渠道列表
     *
     * @return
     */
    List<PadChannel> channelList();


    List<Saler> salerList(SalerDetailsParameter salerDetailsParameter);
}
