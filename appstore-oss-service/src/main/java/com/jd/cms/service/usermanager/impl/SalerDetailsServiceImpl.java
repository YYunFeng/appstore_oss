package com.jd.cms.service.usermanager.impl;

import com.jd.appstore.domain.Saler;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.cms.manager.usermanager.SalerDetailsManager;
import com.jd.cms.service.usermanager.SalerDetailsService;
import com.jd.common.web.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午11:24
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetailsServiceImpl implements SalerDetailsService {
    private SalerDetailsManager salerDetailsManager;

    public Result getSalerDetails(SalerDetailsParameter salerDetailsParameter, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("salerDetailsList", salerDetailsManager.getSalerDetails(salerDetailsParameter, pageIndex, pageSize));
            result.addDefaultModel("channelList", salerDetailsManager.channelList());
            result.addDefaultModel("salerDetailsParameter", salerDetailsParameter);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void deleteSalerDetails(String salerNo) {
        try {
            salerDetailsManager.deleteSalerDetails(salerNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Result getSalerDetailsById(String salerNo) {
        Result result = new Result();
        try {
            Saler saler = salerDetailsManager.getSalerDetailsById(salerNo);
            if (saler != null) {
                result.addDefaultModel("salerDetails", saler);
                SalerDetailsParameter salerDetailsParameter = new SalerDetailsParameter();
                salerDetailsParameter.setCid(saler.getCid());
                if (saler.getChannelType() != null) {
                    salerDetailsParameter.setChannelType(saler.getChannelType());
                    if (saler.getChannelType().intValue() == 0) {
                        salerDetailsParameter.setSalerType(0);
                    } else if (saler.getChannelType().intValue() == 1) {
                        salerDetailsParameter.setSalerType(1);
                    }
                }
                result.addDefaultModel("salerList", salerDetailsManager.salerList(salerDetailsParameter));
                result.addDefaultModel("channelList", salerDetailsManager.channelList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result salerList(SalerDetailsParameter salerDetailsParameter) {
        Result result = new Result();
        try {
            if (salerDetailsParameter.getChannelType() != null) {
                if (salerDetailsParameter.getChannelType().intValue() == 0) {
                    salerDetailsParameter.setSalerType(0);
                } else if (salerDetailsParameter.getChannelType().intValue() == 1) {
                    salerDetailsParameter.setSalerType(1);
                }
            }
            result.addDefaultModel("salerList", salerDetailsManager.salerList(salerDetailsParameter));
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateSalerDetails(Saler saler) {
        if (saler != null) {
            if (saler.getSalerType() != null) {
                if (saler.getSalerType().intValue() == 0 || saler.getSalerType().intValue() == 1) {
                    saler.setParentId(saler.getSalerNo());
                }
            }
        }
        salerDetailsManager.updateSalerDetails(saler);
    }


    public void setSalerDetailsManager(SalerDetailsManager salerDetailsManager) {
        this.salerDetailsManager = salerDetailsManager;
    }
}
