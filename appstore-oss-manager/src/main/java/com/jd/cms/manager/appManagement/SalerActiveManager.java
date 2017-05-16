package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.common.util.PaginatedList;

/**
 * Created by YYF on 14-5-9.
 */

public interface SalerActiveManager {

    /**
     * 促销员活跃度
     *
     * @return
     */
    PaginatedList<SalerActive> salerActive(int pageIndex, int pageSize, String startTime, String endTime,Integer excelFlag,Integer cid);
}
