package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.SuningDao;
import com.jd.cms.domain.clientmanager.Suning;
import com.jd.cms.manager.clientmanager.SuningManager;
import com.jd.common.manager.BaseManager;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class SuningManagerImpl extends BaseManager implements SuningManager {
    private SuningDao suningDao;

    public List<Suning> getSuning() {
        return suningDao.getSuning();
    }

    public void createSuning(Suning suning) {
        suningDao.createSuning(suning);
    }

    public void deleteSuning(Integer id) {
        suningDao.deleteSuning(id);
    }

    public Suning modifySuning(Integer id) {
        return suningDao.modifySuning(id);
    }

    public void updateSuning(Suning suning) {
        suningDao.updateSuning(suning);
    }

    public void setSuningDao(SuningDao suningDao) {
        this.suningDao = suningDao;
    }
}
