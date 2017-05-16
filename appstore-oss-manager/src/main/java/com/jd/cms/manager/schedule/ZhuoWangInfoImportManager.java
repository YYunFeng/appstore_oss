package com.jd.cms.manager.schedule;

import com.jd.appstore.domain.ZhuoWangAppMessage;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-4
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
public interface ZhuoWangInfoImportManager {
    /**
     * 卓望数据入库
     * @param zhuoWangAppMessageList
     * @param accountId
     */
    void createZhuoWangApp(List<ZhuoWangAppMessage> zhuoWangAppMessageList, Integer accountId);

    /**
     * 删除卓望数据
     */
    void deleteZhuoWangApp();
}
