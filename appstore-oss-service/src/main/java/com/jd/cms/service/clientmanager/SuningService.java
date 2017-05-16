package com.jd.cms.service.clientmanager;

import com.jd.cms.domain.clientmanager.Suning;
import com.jd.common.web.result.Result;


/**
 * Created by YUNFENG on 14-2-11.
 */
public interface SuningService {
    Result getSuning();

    void createSuning(Suning suning);

    void deleteSuning(Integer id);

    Result modifySuning(Integer id);

    void updateSuning(Suning suning);

}
