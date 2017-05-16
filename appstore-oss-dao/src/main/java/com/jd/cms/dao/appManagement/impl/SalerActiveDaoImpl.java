package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.SalerActiveDao;
import com.jd.cms.domain.appManagement.ArrCountObj;
import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.cms.domain.clientmanager.SalerActiveParameter;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YYF on 14-5-9.
 */
public class SalerActiveDaoImpl extends BaseDao implements SalerActiveDao {
    public List<SalerActive> salerActive(SalerActiveParameter salerActiveParameter) {
        return queryForList("AppManagement.salerActives", salerActiveParameter);
    }

    public Integer salerCounts(SalerActiveParameter salerActiveParameter) {
        return (Integer) queryForObject("AppManagement.salerActivesCounts", salerActiveParameter);
    }

    public List<ArrCountObj> salerArrStat(SalerActiveParameter salerActiveParameter) {
        return queryForList("AppManagement.salerArrStat", salerActiveParameter);
    }


}
