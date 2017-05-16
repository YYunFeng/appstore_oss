package com.jd.cms.dao.appManagement.impl;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.cms.dao.appManagement.AppBrowseDao;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.common.dao.BaseDao;
import org.springframework.orm.ibatis.SqlMapClientCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览daoImpl
 */
public class AppBrowseDaoImpl extends BaseDao implements AppBrowseDao {
    /**
     * 取得移动游戏,软件信息的总记录数
     *
     * @param appPageInput
     * @return int
     */
    public int getAppBrowseCount(AppPageInput appPageInput) {
        return (Integer) queryForObject("appBrowse.getAppBrowseCount", appPageInput);
    }

    /**
     * 取得网页软件的信息总记录数
     *
     * @param appPageInput
     * @return int
     */
    public int getAppWebBrowseCount(AppPageInput appPageInput) {
        return (Integer) queryForObject("appBrowse.getAppWebBrowseCount", appPageInput);
    }

    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findAppBrowsePage(AppPageInput appPageInput) {

        return queryForList("appBrowse.findAppBrowsePage", appPageInput);
    }

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findAppWebBrowsePage(AppPageInput appPageInput) {
        return queryForList("appBrowse.findAppWebBrowsePage", appPageInput);
    }

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormal(AppPageInput appPageInput) {
        return (AppPageOutput) queryForObject("appBrowse.findAppDetailsFormal", appPageInput);
    }

    /**
     * 取得一对多详情的CpName集合
     *
     * @param appid
     * @return List
     */
    public List<AppPageOutput> getCpNameCount(int appid) {
        return queryForList("appBrowse.getCpNameCount", appid);
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return queryForList("appBrowse.findPicture", appPageInput);
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return queryForList("appBrowse.findCategory", parentId);
    }

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDetailsOnline(AppPageInput appPageInput) {
        return update("appBrowse.upAppDetailsOnline", appPageInput);
    }

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalByCp(AppPageInput appPageInput) {
        return (AppPageOutput) queryForObject("appBrowse.findAppDetailsFormalByCp", appPageInput);
    }

    /**
     * 创建应用上下架后台任务
     *
     * @param backendTask
     */
    public void createAppOnlineErp(BackendTask backendTask) {
        insert("appBrowse.createAppOnlineErp", backendTask);
    }

    /**
     * 创建应用日志
     *
     * @param appPageInput
     */
    public void createAppLog(AppPageInput appPageInput) {
        insert("appBrowse.createAppLog", appPageInput);
    }

    /**
     * 通过ID查找对应的应用
     *
     * @param appid
     * @return AppPageInput
     */
    public AppPageInput findAppByAppid(int appid) {
        return (AppPageInput) queryForObject("appBrowse.findAppByAppid", appid);
    }

    /**
     * 修改最新标记为0
     *
     * @param appid
     * @return int
     */
    public int upAppNewstFlag(int appid) {
        return update("appBrowse.upAppNewstFlag", appid);
    }

    /**
     * 取得应用当前在线状态
     *
     * @param appid
     * @return Integer
     */
    public Integer getCurrentStatus(int appid) {
        return (Integer) queryForObject("appBrowse.getCurrentStatus", appid);
    }

    /**
     * 应用日志读erp信息
     *
     * @param appid
     * @return AppPageOutput
     */
    public AppPageOutput findAppSynchronismStatus(int appid) {
        return (AppPageOutput) queryForObject("appBrowse.findAppSynchronismStatus", appid);
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return (AndroidAppOsversion) queryForObject("appBrowse.findOsVersion", osVersionId);
    }

    /**
     * 查找下载次数
     *
     * @param appid
     * @return Integer
     */
    public Integer findAppDownloadCount(int appid) {
        return (Integer) queryForObject("appBrowse.findAppDownloadCount", appid);
    }

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDefaultDetaild(AppPageInput appPageInput) {
        return update("appBrowse.upAppDefaultDetaild", appPageInput);
    }

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEdit(AppPageInput appPageInput) {
        return (AppPageOutput) queryForObject("appBrowse.findAppDetailsFormalEdit", appPageInput);
    }

    /**
     * 编辑
     * 通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEditByCp(AppPageInput appPageInput) {
        return (AppPageOutput) queryForObject("appBrowse.findAppDetailsFormalEditByCp", appPageInput);
    }

    /**
     * 创建应用基本信息后台任务
     *
     * @param backendTask
     */
    public void createAppBaseErp(BackendTask backendTask) {
        insert("appBrowse.createAppBaseErp", backendTask);
    }

    /**
     * 保存详情
     *
     * @param appPageInput
     * @return int
     */
    public int saveDetailInformation(AppPageInput appPageInput) {
        return update("appBrowse.saveDetailInformation", appPageInput);
    }

    /**
     * 更新应用类型
     *
     * @param appPageInput
     * @return int
     */
    public int upAppType(AppPageInput appPageInput) {
        return update("appBrowse.upAppType", appPageInput);
    }

    public List<CpBaseInfo> getCpList() {
        return queryForList("appBrowse.getCpList");
    }

    public void updateAppDetails(ChangeCpInput changeCpInput) {
        update("appBrowse.updateAppDetails", changeCpInput);
    }

    public void updateAppDetailsLog(ChangeCpInput changeCpInput) {
        update("appBrowse.updateAppDetailsLog", changeCpInput);
    }

    public void updateAppResource(ChangeCpInput changeCpInput) {
        update("appBrowse.updateAppResource", changeCpInput);
    }

    public void changeCp(ChangeCpInput changeCpInput) {

    }
}
