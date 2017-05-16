package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.CompulsoryDao;
import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.cms.domain.clientmanager.CompulsoryAppRes;
import com.jd.cms.manager.clientmanager.CompulsoryManager;
import com.jd.common.manager.BaseManager;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CompulsoryManagerImpl extends BaseManager implements CompulsoryManager {
    private CompulsoryDao compulsoryDao;

    public List<CompulsoryAppRes> getInstallApps() {
        return compulsoryDao.getInstallApps();
    }

    public void createCompulsoryApp(CompulsoryApp compulsoryApp) {
        compulsoryDao.createCompulsoryApp(compulsoryApp);
    }

    public void deleteCompulsoryApp(Integer id) {
        compulsoryDao.deleteCompulsoryApp(id);
    }


    public void setCompulsoryDao(CompulsoryDao compulsoryDao) {
        this.compulsoryDao = compulsoryDao;
    }
}
