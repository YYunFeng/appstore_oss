package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;
import com.jd.common.web.result.Result;

/**
 * Created by YYF on 2014/7/1.
 */
public interface ProvinceArrStatisService {

    Result provinceArrStatis(ProvinceArrStatisParameter provinceArrStatisParameter);

    Result provinceArrStatisByCid(ProvinceArrStatisParameter provinceArrStatisParameter);

    Result provinceArrStatisBySaler(ProvinceArrStatisParameter provinceArrStatisParameter);


    ExportExcelJSON getCountAppExcel(ProvinceArrStatisParameter provinceArrStatisParameter,Integer metohFlag);
}
