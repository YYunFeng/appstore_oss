package com.jd.cms.dao.appManagement;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览dao
 */
public interface AppBrowseDao {
    /**
     * 取得移动游戏,软件信息的总记录数
     *
     * @param appPageInput
     * @return int
     */
    int getAppBrowseCount(AppPageInput appPageInput);

    /**
     * 取得网页软件的信息总记录数
     *
     * @param appPageInput
     * @return int
     */
    int getAppWebBrowseCount(AppPageInput appPageInput);

    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findAppBrowsePage(AppPageInput appPageInput);

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findAppWebBrowsePage(AppPageInput appPageInput);

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormal(AppPageInput appPageInput);

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalByCp(AppPageInput appPageInput);

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalEdit(AppPageInput appPageInput);

    /**
     * 编辑
     * 通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetailsFormalEditByCp(AppPageInput appPageInput);

    /**
     * 取得一对多详情的CpName集合
     *
     * @param appid
     * @return List
     */
    List<AppPageOutput> getCpNameCount(int appid);

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
     * 创建应用基本信息后台任务
     *
     * @param backendTask
     */
    void createAppBaseErp(BackendTask backendTask);

    /**
     * 创建应用上下架后台任务
     *
     * @param backendTask
     */
    void createAppOnlineErp(BackendTask backendTask);

    /**
     * 创建应用日志
     *
     * @param appPageInput
     */
    void createAppLog(AppPageInput appPageInput);

    /**
     * 通过ID查找对应的应用
     *
     * @param appid
     * @return AppPageInput
     */
    AppPageInput findAppByAppid(int appid);

    /**
     * 修改最新标记为0
     *
     * @param appid
     * @return int
     */
    int upAppNewstFlag(int appid);


    /**
     * 取得应用当前在线状态
     *
     * @param appid
     * @return Integer
     */
    Integer getCurrentStatus(int appid);


    /**
     * 应用日志读erp信息
     *
     * @param appid
     * @return AppPageOutput
     */
    AppPageOutput findAppSynchronismStatus(int appid);

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
     * 保存详情
     *
     * @param appPageInput
     * @return int
     */
    int saveDetailInformation(AppPageInput appPageInput);

    /**
     * 更新应用类型
     *
     * @param appPageInput
     * @return int
     */
    int upAppType(AppPageInput appPageInput);


    List<CpBaseInfo> getCpList();


    void updateAppDetails(ChangeCpInput changeCpInput);

    void updateAppDetailsLog(ChangeCpInput changeCpInput);

    void updateAppResource(ChangeCpInput changeCpInput);
}
