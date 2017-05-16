package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.cms.dao.systemmaintenance.PadImeiNumberDao;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-7
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
public class PadImeiNumberDaoImpl extends BaseDao implements PadImeiNumberDao {
    public void createPadImeiNumber(PadImeiNumber padImeiNumber) {
        insert("SystemMaintenance.createPadImeiNumber", padImeiNumber);
    }

    public PadImeiNumber getPadImei(String imeiNmuber) {
        return (PadImeiNumber) queryForObject("SystemMaintenance.getPadImeiNumber", imeiNmuber);
    }

    public void deletePadImei(Integer id) {
        delete("SystemMaintenance.deletePadImeiNumber", id);
    }

    public Integer padImeiCount() {
        return (Integer) queryForObject("SystemMaintenance.padImeiCount");
    }


    public List<PadImeiNumber> getPadImeiList(BaseQuery baseQuery) {
        return queryForList("SystemMaintenance.getPadImeiList", baseQuery);
    }

    public void updatePadImei(PadImeiNumber padImeiNumber) {
        update("SystemMaintenance.updatePadImei", padImeiNumber);
    }

    public Integer padNoUpdateCount() {
        return (Integer) queryForObject("SystemMaintenance.getPadNoUpdateCount");
    }
}
