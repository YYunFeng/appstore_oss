package com.jd.cms.service.systemmaintenance;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.common.util.PaginatedList;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-8
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public interface PadImeiNumberService {
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
    Result getPadImeiList(int pageIndex, int pageSize);

    /**
     * 更新PadImei
     * @param padImeiNumber
     */
    void updatePadImei(PadImeiNumber padImeiNumber);
}
