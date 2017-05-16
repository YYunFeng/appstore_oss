package com.jd.cms.dao.usermanager;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public interface SalerDetailsDao {
    /**
     * 获取促销员列表
     *
     * @param salerDetailsParameter
     * @return
     */
    List<SalerDetails> getSalerDetails(SalerDetailsParameter salerDetailsParameter);

    /**
     * 获取促销员总数
     *
     * @param salerDetailsParameter
     * @return
     */
    Integer getSalerDetailsCount(SalerDetailsParameter salerDetailsParameter);


    /**
     * 刪除促銷員信息
     *
     * @param
     */
    void deleteSalerDetails(String salerNo);

    /**
     * 按Id得到促销员信息
     *
     * @param salerNo
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
