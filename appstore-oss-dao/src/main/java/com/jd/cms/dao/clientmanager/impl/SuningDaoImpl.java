package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.SuningDao;
import com.jd.cms.domain.clientmanager.Suning;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class SuningDaoImpl extends BaseDao implements SuningDao {


    public List<Suning> getSuning() {
        return queryForList("ClientManager.getSuning");
    }

    public void createSuning(Suning suning) {
        insert("ClientManager.createSuning", suning);
    }

    public void deleteSuning(Integer id) {
        delete("ClientManager.deleteSuning", id);
    }

    public Suning modifySuning(Integer id) {
        return (Suning) queryForObject("ClientManager.modifySuning", id);
    }

    public void updateSuning(Suning suning) {
        update("ClientManager.updateSuning", suning);
    }


}
