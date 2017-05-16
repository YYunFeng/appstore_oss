package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.dao.systemmaintenance.CategoryMaintenanceDao;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-6
 * Time: 下午12:28
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMaintenanceDaoImpl extends BaseDao implements CategoryMaintenanceDao {
    /**
     * 查询类目列表
     *
     * @param query
     * @return
     */
    public List<Category> findCategoryByParentId(Query query) {
        return queryForList("SystemMaintenance.findCategoryByParentId", query);
    }

    /**
     * 查询总记录数
     *
     * @param query
     * @return
     */
    public int getCategoryByParentId(Query query) {
        return (Integer) queryForObject("SystemMaintenance.getCategoryByParentId", query);
    }

    /**
     * 修改类目图片路径
     *
     * @param query
     */
    public void updateCategoryPicUrl(Query query) {
        update("SystemMaintenance.updateCategoryPicUrl", query);
    }

    /**
     * 修改类目描述
     *
     * @param category
     */
    public void doUpdateCategoryIntro(Category category) {
        update("SystemMaintenance.doUpdateCategoryIntro", category);
    }

    /**
     * 初始化修改类目描述页
     *
     * @param query
     * @return
     */
    public Category fintCategoryIntro(Query query) {
        return (Category) queryForObject("SystemMaintenance.fintCategoryIntro", query);
    }

    /**
     * 添加类目
     * @param category
     */
    public void createCategory(Category category) {
        insert("SystemMaintenance.createCategory", category);
    }

    /**
     * 删除类目
     * @param categoryId
     */

    public void deleteCategory(int categoryId) {
        delete("SystemMaintenance.deleteCategory", categoryId);
    }

}
