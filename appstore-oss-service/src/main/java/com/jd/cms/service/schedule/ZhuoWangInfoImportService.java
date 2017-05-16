package com.jd.cms.service.schedule;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-2-28
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public interface ZhuoWangInfoImportService {

    void importFullApp();

    void importNewApp();

    void importFullApp(String filePath, Integer accountId);

    void importNewApp(String filePath, Integer accountId);

    void importCategory();

    void importTop();

}
