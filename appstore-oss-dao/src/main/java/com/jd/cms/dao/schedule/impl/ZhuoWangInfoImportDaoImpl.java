package com.jd.cms.dao.schedule.impl;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jd.appstore.domain.AppDetails;
import com.jd.appstore.domain.AppDetailsLog;
import com.jd.appstore.domain.AppLog;
import com.jd.appstore.domain.Apps;
import com.jd.cms.dao.schedule.ZhuoWangInfoImportDao;
import com.jd.common.dao.BaseDao;
import org.springframework.orm.ibatis.SqlMapClientCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-4
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangInfoImportDaoImpl extends BaseDao implements ZhuoWangInfoImportDao {
    public void batchInsertApps(final List<Apps> appsList, final List<AppLog> appLogList, final List<AppDetailsLog> appDetailsLogList, final List<AppDetails> appDetailsList) {
        execute(new SqlMapClientCallback() {
            public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                try {
                    executor.startBatch();
                    //  向tb_apps 表中插入数据,同时向资源表中插入应用信息
                    for (int i = 0; i < appsList.size(); i++) {
                        executor.insert("Apps.createAppsFromZhuoWang", appsList.get(i));
                        logger.error("id:"+appsList.get(i).getAppPackage()+"app_name:"+appsList.get(i).getAppName());
                        for (int j = 0; j < appsList.get(i).getAppResourceList().size(); j++) {
                            executor.insert("Apps.insertAppResourceFromZhuoWang", appsList.get(i).getAppResourceList().get(j));
                        }
                    }
                    // 向tb_app_log表中插入数据
                    for (int i = 0; i < appLogList.size(); i++) {
                        executor.insert("Apps.insertAppLogFromZhuoWang", appLogList.get(i));
                    }
                    //  向tb_app_detaillog表中插入数据
                    for (int i = 0; i < appDetailsLogList.size(); i++) {
                        executor.insert("Apps.insertAppDetailsLogFromZhuoWang", appDetailsLogList.get(i));
                    }
                    // 向tb_appdetails表中插入数据
                    for (int i = 0; i < appDetailsList.size(); i++) {
                        executor.insert("Apps.createAppDetailFromZhuoWang", appDetailsList.get(i));
                    }
                    executor.executeBatch();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    /**
     * 删除所有关于卓望的数据
     */
    public void deleteZhuoWangApps() {
        delete("Apps.deleteApps");
        delete("Apps.deleteAppsDetail");
        delete("Apps.deleteAppResource");
    }

    public void deleteZhuoWangAppsByAppId(Integer appId) {
        delete("Apps.deleteAppsByAppId", appId);
        delete("Apps.deleteAppsDetailByAppId", appId);
        delete("Apps.deleteAppResourceByAppId", appId);
    }

    public Integer getAppId(String pkg) {
        return (Integer) queryForObject("Apps.getAppId", pkg);
    }

}
