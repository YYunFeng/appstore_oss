package com.jd.cms.service.clientmanager;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.common.web.result.Result;


/**
 * Created by YUNFENG on 14-2-11.
 */
public interface CpDateImportService {
    Result getCpDateImport(int pageIndex,int pageSize);

     Integer createCpDateImport(CpDateImport cpDateImport);

    void deletCpDateImport(Integer id);



}
