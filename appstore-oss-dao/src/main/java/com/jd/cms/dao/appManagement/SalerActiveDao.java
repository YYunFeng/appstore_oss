package com.jd.cms.dao.appManagement;

import com.jd.cms.domain.appManagement.ArrCountObj;
import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.cms.domain.clientmanager.SalerActiveParameter;

import java.util.List;

/**
 * Created by YYF on 14-5-9.
 */
public interface SalerActiveDao {
    /**
     * 促销员活跃度
     *
     * @param salerActiveParameter
     * @return
     */
    List<SalerActive> salerActive(SalerActiveParameter salerActiveParameter);


    Integer salerCounts(SalerActiveParameter salerActiveParameter);


    List<ArrCountObj> salerArrStat(SalerActiveParameter salerActiveParameter);

}
