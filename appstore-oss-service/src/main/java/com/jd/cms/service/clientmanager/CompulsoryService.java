package com.jd.cms.service.clientmanager;

import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-11.
 */
public interface CompulsoryService {
    Result getInstallApps();

    void createCompulsoryApp(CompulsoryApp compulsoryApp);


    void deleteCompulsoryApp(Integer id);
}
