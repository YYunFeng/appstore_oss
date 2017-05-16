package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public interface CpDateImportManager {
    PaginatedList<CpDateImport> getCpDateImport(int pageIndez, int pageSiz);

    Integer createCpDateImport(CpDateImport cpDateImport);

    void deletCpDateImport(Integer id);

    void updateCpDateImport(CpDateImport cpDateImport);

    void createCpPhoneimei(CpPhoneimei cpPhoneimei);
}
