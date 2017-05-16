package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.CpBaseInfo;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.cms.manager.appManagement.AppBrowseManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览managerCachedImpl
 */
public class AppBrowseManagerCachedImpl implements AppBrowseManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private AppBrowseManager appBrowseManager;

    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findAppBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        PaginatedList<AppPageOutput> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //是否为第一页
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_APPMOBILE_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //取得移动游戏,软件的信息集合
        paginatedList = appBrowseManager.findAppBrowsePage(appPageInput, pageIndex, pageSize);
        //取得移动游戏,软件的信息集合是否存在
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APPMOBILE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findAppBrowsePage(appPageInput, pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APPMOBILE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回移动游戏,软件的信息集合
        return paginatedList;
    }

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findAppWebBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        PaginatedList<AppPageOutput> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //是否为第一页
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_APPWEB_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询网页软件的信息集合
        paginatedList = appBrowseManager.findAppWebBrowsePage(appPageInput, pageIndex, pageSize);
        //用户信息列表是否存在
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APPWEB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findAppWebBrowsePage(appPageInput, pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APPWEB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回网页软件的信息集合
        return paginatedList;
    }

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormal(AppPageInput appPageInput) {
        return appBrowseManager.findAppDetailsFormal(appPageInput);
    }

    /**
     * 取得一对多详情的CpName集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> getCpNameCount(AppPageInput appPageInput) {
        return appBrowseManager.getCpNameCount(appPageInput);
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return appBrowseManager.findPicture(appPageInput);
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return appBrowseManager.findCategory(parentId);
    }

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDetailsOnline(AppPageInput appPageInput) {
        return appBrowseManager.upAppDetailsOnline(appPageInput);
    }

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalByCp(AppPageInput appPageInput) {
        return appBrowseManager.findAppDetailsFormalByCp(appPageInput);
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return appBrowseManager.findOsVersion(osVersionId);
    }

    /**
     * 查找下载次数
     *
     * @param appid
     * @return Integer
     */
    public Integer findAppDownloadCount(int appid) {
        return appBrowseManager.findAppDownloadCount(appid);
    }

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    public int upAppDefaultDetaild(AppPageInput appPageInput) {
        return appBrowseManager.upAppDefaultDetaild(appPageInput);
    }

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEdit(AppPageInput appPageInput) {
        return appBrowseManager.findAppDetailsFormalEdit(appPageInput);
    }

    /**
     * 编辑-通过CpName查找详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetailsFormalEditByCp(AppPageInput appPageInput) {
        return appBrowseManager.findAppDetailsFormalEditByCp(appPageInput);
    }

    /**
     * 保存应用和详情
     *
     * @param appPageInput
     * @return int
     */
    public int saveAppAndDetailInformation(AppPageInput appPageInput) {
        return appBrowseManager.saveAppAndDetailInformation(appPageInput);
    }

    /**
     * 批量上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnline(AppPageInput appPageInput) {
        return appBrowseManager.upAppOnline(appPageInput);
    }

    /**
     * 单个上下架操作
     *
     * @param appPageInput
     * @return int
     */
    public int upAppOnlineById(AppPageInput appPageInput) {
        return appBrowseManager.upAppOnlineById(appPageInput);
    }

    public List<CpBaseInfo> getCpList() {
        return appBrowseManager.getCpList();
    }

    public void chageCp(ChangeCpInput changeCpInput) {
        appBrowseManager.chageCp(changeCpInput);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public AppBrowseManager getAppBrowseManager() {
        return appBrowseManager;
    }

    public void setAppBrowseManager(AppBrowseManager appBrowseManager) {
        this.appBrowseManager = appBrowseManager;
    }
}
