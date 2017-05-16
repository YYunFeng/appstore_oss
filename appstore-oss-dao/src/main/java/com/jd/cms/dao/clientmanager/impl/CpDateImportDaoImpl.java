package com.jd.cms.dao.clientmanager.impl;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jd.cms.dao.clientmanager.CpDateImportDao;
import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.base.BaseQuery;
import org.springframework.orm.ibatis.SqlMapClientCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class CpDateImportDaoImpl extends BaseDao implements CpDateImportDao {
    public List<CpDateImport> getCpDateImport(BaseQuery baseQuery) {
        return queryForList("ClientManager.getCpDateImport", baseQuery);
    }

    public Integer getCpDateImportCounts() {
        return (Integer) queryForObject("ClientManager.getCpDateImportCounts");
    }

    public Integer createCpDateImport(CpDateImport cpDateImport) {
        return (Integer) insert("ClientManager.createCpDateImport", cpDateImport);
    }

    public void deletCpDateImport(Integer id) {
        delete("ClientManager.deletCpDateImport", id);
        // 删除导入的手机串号
        delete("ClientManager.deteleCpPhoneImei", id);
    }

    public void updateCpDateImport(CpDateImport cpDateImport) {
        update("ClientManager.updateCpDateImport", cpDateImport);
    }

    public void createCpPhoneimei(CpPhoneimei cpPhoneimei) {
        insert("ClientManager.createCpPhoneimei", cpPhoneimei);
    }
}
