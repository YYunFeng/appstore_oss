package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.Suning;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public interface SuningManager {

    List<Suning> getSuning();

    void createSuning(Suning suning);

    void deleteSuning(Integer id);


    Suning modifySuning(Integer id);

    void updateSuning(Suning suning);
}
