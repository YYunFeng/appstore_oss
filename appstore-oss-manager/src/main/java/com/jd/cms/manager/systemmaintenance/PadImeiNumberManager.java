package com.jd.cms.manager.systemmaintenance;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-7
 * Time: 下午8:00
 * To change this template use File | Settings | File Templates.
 */
public interface PadImeiNumberManager {
    /**
     * 创建ImeiNumber
     *
     * @param padImeiNumber
     */
    void createPadImeiNumber(PadImeiNumber padImeiNumber);

    /**
     * 得到ImeiNumber
     *
     * @param imeiNmuber
     * @return
     */
    PadImeiNumber getPadImei(String imeiNmuber);

    /**
     * 删除PadImei
     *
     * @param id
     */
    void deletePadImei(Integer id);


    /**
     * 得到PadImei
     *
     * @return
     */
    PaginatedList<PadImeiNumber> getPadImeiList(int pageIndex, int pageSize);

    /**
     * 更新PadImei
     *
     * @param padImeiNumber
     */
    void updatePadImei(PadImeiNumber padImeiNumber);

    /**
     * PAD未更新的条数
     *
     * @return
     */
    Integer padNoUpdateCount();
}
