package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.cms.domain.clientmanager.CompulsoryAppRes;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public interface CompulsoryDao {
    List<CompulsoryAppRes> getInstallApps();

    void createCompulsoryApp(CompulsoryApp compulsoryApp);


    void deleteCompulsoryApp(Integer id);
}
