package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.domain.clientmanager.CompulsoryApp;
import com.jd.cms.manager.clientmanager.CompulsoryManager;
import com.jd.cms.service.clientmanager.CompulsoryService;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CompulsoryServiceImpl implements CompulsoryService {
    private CompulsoryManager compulsoryManager;

    public Result getInstallApps() {
        Result result = new Result();
        try {
            result.addDefaultModel("installApps", compulsoryManager.getInstallApps());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public void createCompulsoryApp(CompulsoryApp compulsoryApp) {
        compulsoryManager.createCompulsoryApp(compulsoryApp);
    }

    public void deleteCompulsoryApp(Integer id) {
        compulsoryManager.deleteCompulsoryApp(id);
    }


    public void setCompulsoryManager(CompulsoryManager compulsoryManager) {
        this.compulsoryManager = compulsoryManager;
    }
}
