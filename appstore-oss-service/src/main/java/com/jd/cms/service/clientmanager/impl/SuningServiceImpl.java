package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.domain.clientmanager.Suning;
import com.jd.cms.manager.clientmanager.SuningManager;
import com.jd.cms.service.clientmanager.SuningService;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class SuningServiceImpl implements SuningService {
    private SuningManager suningManager;

    public Result getSuning() {
        Result result = new Result();
        try {
            result.addDefaultModel("suningList", suningManager.getSuning());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createSuning(Suning suning) {
        suningManager.createSuning(suning);
    }

    public void deleteSuning(Integer id) {
        suningManager.deleteSuning(id);
    }

    public Result modifySuning(Integer id) {
        Result result = new Result();
        try {
            result.addDefaultModel("suning", suningManager.modifySuning(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateSuning(Suning suning) {
        suningManager.updateSuning(suning);
    }

    public void setSuningManager(SuningManager suningManager) {
        this.suningManager = suningManager;
    }
}
