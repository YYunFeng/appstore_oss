package com.jd.cms.manager.appManagement;

import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.common.util.PaginatedList;

import java.util.List;


/**
 * Created by YUNFENG on 14-2-17.
 */
public interface AppCountsManager {
    PaginatedList<AppCountResult> getCountAppsByCp(AppCountParameter appCountParameter, int pageIndex, int pageSize);

    PaginatedList<AppCountResult> getCountAppByApp(AppCountParameter countAppParameter, int pageIndex, int pageSize);

    PaginatedList<AppCountResult> getCountAppByPhoneImei(AppCountParameter countAppParameter, int pageIndex, int pageSize);


    List<AppCountResult> getCountAppsByCpExcel(AppCountParameter appCountParameter);

    List<AppCountResult> getCountAppByAppExcel(AppCountParameter appCountParameter);

    List<AppCountResult> getCountAppByPhoneImeiExcel(AppCountParameter appCountParameter);

}
