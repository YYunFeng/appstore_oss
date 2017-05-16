package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.CpDateImportDao;
import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.cms.manager.clientmanager.CpDateImportManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CpDateImportManagerImpl extends BaseManager implements CpDateImportManager {
    private CpDateImportDao cpDateImportDao;

    public PaginatedList<CpDateImport> getCpDateImport(int pageIndex, int pageSize) {
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        PaginatedList<CpDateImport> paginatedList = new PaginatedArrayList<CpDateImport>(pageIndex, pageSize);
        try {
            int total = cpDateImportDao.getCpDateImportCounts();
            if (total > 0) {
                paginatedList.setTotalItem(total);
                BaseQuery baseQuery = new BaseQuery();
                baseQuery.setStartRow((pageIndex - 1) * pageSize);
                baseQuery.setEndRow(pageSize);
                List<CpDateImport> cpDateImportList = cpDateImportDao.getCpDateImport(baseQuery);
                paginatedList.addAll(cpDateImportList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginatedList;
    }

    public Integer createCpDateImport(CpDateImport cpDateImport) {
        return  cpDateImportDao.createCpDateImport(cpDateImport);
    }

    public void deletCpDateImport(Integer id) {
        cpDateImportDao.deletCpDateImport(id);
    }

    public void updateCpDateImport(CpDateImport cpDateImport) {
        cpDateImportDao.updateCpDateImport(cpDateImport);
    }

    public void createCpPhoneimei(CpPhoneimei cpPhoneimei) {
        cpDateImportDao.createCpPhoneimei(cpPhoneimei);
    }

    public void setCpDateImportDao(CpDateImportDao cpDateImportDao) {
        this.cpDateImportDao = cpDateImportDao;
    }
}
