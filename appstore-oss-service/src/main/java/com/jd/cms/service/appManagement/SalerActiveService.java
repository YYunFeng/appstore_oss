package com.jd.cms.service.appManagement;

import com.jd.common.web.result.Result;

/**
 * Created by YYF on 14-5-9.
 */
public interface SalerActiveService {

    Result salerActive(int pageIndex, int pageSize, String startTime, String endTime,Integer cid);

}
