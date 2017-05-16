package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-17.
 */
public interface AppCountsService {
    Result getCountAppsByCp(AppCountParameter appCountParameter, int pageIndex, int pageSize);

    Result getCountAppByApp(AppCountParameter appCountParameter, int pageIndex, int pageSize);

    Result getCountAppByPhoneImei(AppCountParameter appCountParameter, int pageIndex, int pageSize);

    ExportExcelJSON getCountAppExcel(AppCountParameter appCountParameter,Integer metohFlag);


}
