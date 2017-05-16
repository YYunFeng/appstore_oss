package com.jd.cms.dao.usermanager.impl;

import com.jd.appstore.domain.Saler;
import com.jd.cms.dao.usermanager.SalerDetailsDao;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetailsDaoImpl extends BaseDao implements SalerDetailsDao {
    public List<SalerDetails> getSalerDetails(SalerDetailsParameter salerDetailsParameter) {
        return queryForList("SalerDetails.getSalerDetails", salerDetailsParameter);
    }

    public Integer getSalerDetailsCount(SalerDetailsParameter salerDetailsParameter) {
        return (Integer) queryForObject("SalerDetails.getSalerDetailsCount", salerDetailsParameter);
    }

    public void deleteSalerDetails(String salerNo) {
        delete("SalerDetails.deleteSalerDetails", salerNo);
    }

    public Saler getSalerDetailsById(String salerNo) {
        return (Saler) queryForObject("SalerDetails.getSalerDetailsById", salerNo);
    }

    public void updateSalerDetails(Saler saler) {
        update("SalerDetails.updateSalerDetails", saler);
    }

    public List<PadChannel> channelList() {
        return queryForList("SalerDetails.channelList");
    }

    public List<Saler> salerList(SalerDetailsParameter salerDetailsParameter) {
        return queryForList("SalerDetails.salerList", salerDetailsParameter);
    }

    public String parentName(String salerNo) {
        return (String) queryForObject("SalerDetails.parentName", salerNo);
    }
}
