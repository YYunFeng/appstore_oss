package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.manager.clientmanager.CpDateImportManager;
import com.jd.cms.service.clientmanager.CpDateImportService;
import com.jd.common.web.result.Result;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CpDateImportServiceImpl implements CpDateImportService {
    private CpDateImportManager cpDateImportManager;

    public Result getCpDateImport(int pageIndex,int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("cpDateImport", cpDateImportManager.getCpDateImport(pageIndex,pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer createCpDateImport(CpDateImport cpDateImport) {
        return  cpDateImportManager.createCpDateImport(cpDateImport);
    }

    public void deletCpDateImport(Integer id) {
        cpDateImportManager.deletCpDateImport(id);
    }


    public void setCpDateImportManager(CpDateImportManager cpDateImportManager) {
        this.cpDateImportManager = cpDateImportManager;
    }
}
