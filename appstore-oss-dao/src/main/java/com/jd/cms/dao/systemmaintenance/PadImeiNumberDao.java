package com.jd.cms.dao.systemmaintenance;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-7
 * Time: 下午7:45
 * To change this template use File | Settings | File Templates.
 */
public interface PadImeiNumberDao {
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
     * 得到padImei总记录数
     *
     * @return
     */
    Integer padImeiCount();

    /**
     * 得到PadImei
     *
     * @return
     */
    List<PadImeiNumber> getPadImeiList(BaseQuery baseQuery);

    /**
     * 更新PadImei
     *
     * @param padImeiNumber
     */
    void updatePadImei(PadImeiNumber padImeiNumber);

    /**
     * PAD未更新的台数
     *
     * @return
     */
    Integer padNoUpdateCount();
}
