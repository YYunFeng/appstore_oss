package com.jd.cms.manager.appManagement;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览manager
 */
public interface AppBrowseManager {
    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    PaginatedList<AppPageOutput> findAppBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    PaginatedList<AppPageOutput> findAppWebBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormal(AppPageInput appPageInput);

    /**
     * 取得一对多详情的CpName集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> getCpNameCount(AppPageInput appPageInput);

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findPicture(AppPageInput appPageInput);

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    List<Category> findCategory(int parentId);

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return int
     */
    int upAppDetailsOnline(AppPageInput appPageInput);

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalByCp(AppPageInput appPageInput);

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    AndroidAppOsversion findOsVersion(int osVersionId);

    /**
     * 查找下载次数
     *
     * @param appid
     * @return Integer
     */
    Integer findAppDownloadCount(int appid);

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    int upAppDefaultDetaild(AppPageInput appPageInput);

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalEdit(AppPageInput appPageInput);

    /**
     * 编辑-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalEditByCp(AppPageInput appPageInput);

    /**
     * 保存应用和详情
     *
     * @param appPageInput
     * @return int
     */
    int saveAppAndDetailInformation(AppPageInput appPageInput);

    /**
     * 批量上下架操作
     *
     * @param appPageInput
     * @return int
     */
    int upAppOnline(AppPageInput appPageInput);

    /**
     * 单个上下架操作
     *
     * @param appPageInput
     * @return int
     */
    int upAppOnlineById(AppPageInput appPageInput);


    List<CpBaseInfo> getCpList();

    void chageCp(ChangeCpInput changeCpInput);
}

