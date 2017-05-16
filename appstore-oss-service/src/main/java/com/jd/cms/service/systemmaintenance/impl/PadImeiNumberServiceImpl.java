package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.cms.manager.systemmaintenance.PadImeiNumberManager;
import com.jd.cms.service.systemmaintenance.PadImeiNumberService;
import com.jd.common.util.PaginatedList;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-8
 * Time: 下午2:08
 * To change this template use File | Settings | File Templates.
 */
public class PadImeiNumberServiceImpl implements PadImeiNumberService {
    private PadImeiNumberManager padImeiNumberManager;

    public void createPadImeiNumber(PadImeiNumber padImeiNumber) {
        padImeiNumberManager.createPadImeiNumber(padImeiNumber);
    }

    public PadImeiNumber getPadImei(String imeiNmuber) {
        return padImeiNumberManager.getPadImei(imeiNmuber);
    }

    public void deletePadImei(Integer id) {
        padImeiNumberManager.deletePadImei(id);
    }

    public Result getPadImeiList(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("padNoUpdateCount", padImeiNumberManager.padNoUpdateCount());
            result.addDefaultModel("padImeiList", padImeiNumberManager.getPadImeiList(pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    public void updatePadImei(PadImeiNumber padImeiNumber) {
        padImeiNumberManager.updatePadImei(padImeiNumber);
    }

    public void setPadImeiNumberManager(PadImeiNumberManager padImeiNumberManager) {
        this.padImeiNumberManager = padImeiNumberManager;
    }
}
