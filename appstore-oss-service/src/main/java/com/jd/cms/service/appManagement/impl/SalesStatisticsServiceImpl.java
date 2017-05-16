package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.InstaisticNorm;
import com.jd.cms.domain.appManagement.PhoneIntallMessParameter;
import com.jd.cms.domain.appManagement.ProvinceStatisParameter;
import com.jd.cms.domain.appManagement.SalerRankingParameter;
import com.jd.cms.manager.appManagement.SalesStatisticsManager;
import com.jd.cms.service.appManagement.SalesStatisticsService;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public class SalesStatisticsServiceImpl implements SalesStatisticsService {
    private SalesStatisticsManager salesStatisticsManager;
    private PhoneIntallMessParameter phoneIntallMessParameter;

    public Result getSalerRanking(SalerRankingParameter salerRankingParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("salerRanking", salesStatisticsManager.getSalerRanking(salerRankingParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result getPhoneInstallMess(PhoneIntallMessParameter phoneIntallMessParameter, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("phoneInstallMessList", salesStatisticsManager.getPhoneInstallMess(phoneIntallMessParameter, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result getDayInstallMess(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("installMessList", salesStatisticsManager.byDayCheckInstall(pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result provinceStatis(ProvinceStatisParameter provinceStatisParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("provinceRes", salesStatisticsManager.provinceStatis(provinceStatisParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public Result padChannelList() {
        Result result = new Result();
        try {
            result.addDefaultModel("padChannelList", salesStatisticsManager.padChannelList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer getInstaisticNorm(InstaisticNorm instaisticnorm) {
        return salesStatisticsManager.getInstaisticNorm(instaisticnorm);
    }

    public void createInstaisticNorm(InstaisticNorm instaisticNorm) {
        salesStatisticsManager.createInstaisticNorm(instaisticNorm);
    }

    public void updateInstaisticNorm(InstaisticNorm instaisticNorm) {
        salesStatisticsManager.updateInstaisticNorm(instaisticNorm);
    }

    public void setSalesStatisticsManager(SalesStatisticsManager salesStatisticsManager) {
        this.salesStatisticsManager = salesStatisticsManager;
    }

    public PhoneIntallMessParameter getPhoneIntallMessParameter() {
        return phoneIntallMessParameter;
    }

    public void setPhoneIntallMessParameter(PhoneIntallMessParameter phoneIntallMessParameter) {
        this.phoneIntallMessParameter = phoneIntallMessParameter;
    }
}
