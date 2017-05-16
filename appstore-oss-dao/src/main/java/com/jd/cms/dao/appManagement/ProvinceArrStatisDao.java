package com.jd.cms.dao.appManagement;


import com.jd.cms.domain.appManagement.ProvinceArrStatisObj;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;

import java.util.List;

/**
 * Created by YYF on 2014/7/1.
 */
public interface ProvinceArrStatisDao {

    ProvinceArrStatisObj provinceArrStatis(ProvinceArrStatisParameter provinceArrStatisParameter);


    List<ProvinceArrStatisObj> provinceArrStatisByCid(ProvinceArrStatisParameter provinceArrStatisParameter);


    List<ProvinceArrStatisObj> provinceArrStatisBySaler(ProvinceArrStatisParameter provinceArrStatisParameter);

}
