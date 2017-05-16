package com.jd.cms.dao.schedule;

import com.jd.appstore.domain.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-4
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public interface ZhuoWangInfoImportDao {
    /**
     * 批量导入卓望数据
     *
     * @param appsList
     * @param appLogList
     * @param appDetailsLogList
     */
    void batchInsertApps(List<Apps> appsList, List<AppLog> appLogList, List<AppDetailsLog> appDetailsLogList,List<AppDetails> appDetailsList);

    /**
     *  删除卓望数据
     */
    void deleteZhuoWangApps();

    void deleteZhuoWangAppsByAppId(Integer appId);

    Integer getAppId(String pkg);
}
