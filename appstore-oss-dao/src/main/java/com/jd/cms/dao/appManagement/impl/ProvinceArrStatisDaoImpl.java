package com.jd.cms.dao.appManagement.impl;

import com.jd.cms.dao.appManagement.ProvinceArrStatisDao;
import com.jd.cms.domain.appManagement.ProvinceArrStatisObj;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YYF on 2014/7/1.
 */
public class ProvinceArrStatisDaoImpl extends BaseDao implements ProvinceArrStatisDao {


    public ProvinceArrStatisObj provinceArrStatis(ProvinceArrStatisParameter provinceArrStatisParameter) {
        return (ProvinceArrStatisObj) queryForObject("provinceArrStatis.provinceArrStatTotal", provinceArrStatisParameter);
    }

    public List<ProvinceArrStatisObj> provinceArrStatisByCid(ProvinceArrStatisParameter provinceArrStatisParameter) {
        return queryForList("provinceArrStatis.provinceArrStatisByCid", provinceArrStatisParameter);
    }

    public List<ProvinceArrStatisObj> provinceArrStatisBySaler(ProvinceArrStatisParameter provinceArrStatisParameter) {
        return queryForList("provinceArrStatis.provinceArrStatisBySaler", provinceArrStatisParameter);
    }
}
