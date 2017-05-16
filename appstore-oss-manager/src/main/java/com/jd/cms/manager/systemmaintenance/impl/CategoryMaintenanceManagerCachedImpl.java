package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.systemmaintenance.CategoryMaintenanceManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-6
 * Time: 下午12:13
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMaintenanceManagerCachedImpl implements CategoryMaintenanceManager {
    private final static Log log = LogFactory.getLog(CategoryMaintenanceManagerCachedImpl.class);
    /**
     * 类目管理Manager
     */
    private CategoryMaintenanceManager categoryMaintenanceManager;
    /**
     * memcache工具类
     */
    private CacheUtils cacheUtils;

    /**
     * 记录页号
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<Category> findCategoryByParentId(int pageIndex, int pageSize, int parentId) {
        PaginatedList<Category> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_CATEGORYMAINTENANCE_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询类目信息列表
        paginatedList = categoryMaintenanceManager.findCategoryByParentId(pageIndex, pageSize, parentId);
        //类目信息列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CATEGORYMAINTENANCE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findCategoryByParentId(pageIndex, pageSize, parentId);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CATEGORYMAINTENANCE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回类目信息列表
        return paginatedList;
    }

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param picUrl
     * @param id
     * @return
     */
    public void updateCategoryPicUrl(String picUrl, int id) {
        categoryMaintenanceManager.updateCategoryPicUrl(picUrl, id);
    }

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    public void doUpdateCategoryIntro(Category category) {
        categoryMaintenanceManager.doUpdateCategoryIntro(category);
    }

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    public Category fintCategoryIntro(int categoryId) {
        return categoryMaintenanceManager.fintCategoryIntro(categoryId);
    }

    public void ceateCategory(Category category) {
         categoryMaintenanceManager.ceateCategory(category);
    }

    public void deleteCategory(int categoryId) {
         categoryMaintenanceManager.deleteCategory(categoryId);
    }

    public void setCategoryMaintenanceManager(CategoryMaintenanceManager categoryMaintenanceManager) {
        this.categoryMaintenanceManager = categoryMaintenanceManager;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }
}
