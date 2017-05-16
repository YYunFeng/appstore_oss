package com.jd.cms.manager.appManagement.impl;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.Category;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.SalerRankingRes;
import com.jd.cms.manager.appManagement.AppManagementManager;
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
 * 审核应用managerCachedImpl
 */
public class AppManagementManagerCachedImpl implements AppManagementManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private AppManagementManager appManagementManager;

    /**
     * 重新同步所有/部分应用基本信息
     *
     * @param appPageInput
     * @return List
     */
    public List<Apps> getAppBaseInfo(AppPageInput appPageInput) {
        List<Apps> results;
        results = appManagementManager.getAppBaseInfo(appPageInput);
        return results;
    }



    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    public PaginatedList<AppPageOutput> findDetailsPage(AppPageInput appPageInput, int pageIndex, int pageSize) {
        PaginatedList<AppPageOutput> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //是否为第一页
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_APP_PAGER_CACHED + "_" + ip);
//            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_APP_PAGER_CACHED );
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询审核应用的信息集合
        paginatedList = appManagementManager.findDetailsPage(appPageInput, pageIndex, pageSize);
        //用户信息列表是否存在
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APP_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
//            cacheUtils.set(CategoryConstants.CMS_APP_PAGER_CACHED, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findDetailsPage(appPageInput, pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_APP_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回审核应用的信息集合
        return paginatedList;
    }

    /**
     * 取得详情对应应用的基本信息审核状态(详情Id)
     *
     * @param did
     * @return int
     */
    public int findAppStatus(int did) {
        return appManagementManager.findAppStatus(did);
    }

    /**
     * 查找单个详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetails(AppPageInput appPageInput) {
        return appManagementManager.findAppDetails(appPageInput);
    }

    /**
     * 审核不通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateStatusOff(AppPageInput appPageInput) {
        return appManagementManager.updateStatusOff(appPageInput);
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return appManagementManager.findCategory(parentId);
    }

    /**
     * 审核通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateStatusOn(AppPageInput appPageInput) {
        return appManagementManager.updateStatusOn(appPageInput);
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return appManagementManager.findPicture(appPageInput);
    }

    /**
     * 查找cp默认分成比例
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    public AppPageOutput findDefaultPercent(AppPageInput appPageInput) {
        return appManagementManager.findDefaultPercent(appPageInput);
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return appManagementManager.findOsVersion(osVersionId);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public AppManagementManager getAppManagementManager() {
        return appManagementManager;
    }

    public void setAppManagementManager(AppManagementManager appManagementManager) {
        this.appManagementManager = appManagementManager;
    }
}
