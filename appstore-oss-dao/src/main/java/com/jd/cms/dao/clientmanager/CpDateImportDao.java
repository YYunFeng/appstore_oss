package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public interface CpDateImportDao {
    List<CpDateImport> getCpDateImport(BaseQuery baseQuery);

    Integer getCpDateImportCounts();

    Integer createCpDateImport(CpDateImport cpDateImport);

    void deletCpDateImport(Integer id);

    void updateCpDateImport(CpDateImport cpDateImport);

    void createCpPhoneimei(CpPhoneimei cpPhoneimei);

}
