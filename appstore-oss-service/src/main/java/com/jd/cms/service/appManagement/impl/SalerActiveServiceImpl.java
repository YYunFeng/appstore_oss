package com.jd.cms.service.appManagement.impl;

import com.jd.cms.manager.appManagement.SalerActiveManager;
import com.jd.cms.service.appManagement.SalerActiveService;
import com.jd.common.web.result.Result;

/**
 * Created by YYF on 14-5-9.
 */
public class SalerActiveServiceImpl implements SalerActiveService {
    private SalerActiveManager salerActiveManager;

    public Result salerActive(int pageIndex, int pageSize, String startTime, String endTime, Integer cid) {
        Result result = new Result();
        try {
            result.addDefaultModel("salerActiveList", salerActiveManager.salerActive(pageIndex, pageSize, startTime, endTime, 0, cid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public void setSalerActiveManager(SalerActiveManager salerActiveManager) {
        this.salerActiveManager = salerActiveManager;
    }
}
