package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.CompulsoryDao;
import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.cms.domain.clientmanager.CompulsoryAppRes;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CompulsoryDaoImpl extends BaseDao implements CompulsoryDao {
    public List<CompulsoryAppRes> getInstallApps() {
        return queryForList("ClientManager.getInstallApps");
    }

    public void createCompulsoryApp(CompulsoryApp compulsoryApp) {
        insert("ClientManager.createCompulsoryApp", compulsoryApp);
    }

    public void deleteCompulsoryApp(Integer id) {
        delete("ClientManager.deleteCompulsoryApp", id);
    }
}
