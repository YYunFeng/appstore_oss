package com.jd.cms.dao.systemmaintenance;

import com.jd.appstore.domain.Category;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-6
 * Time: 下午12:28
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryMaintenanceDao {
    /**
     * 查询类目列表
     *
     * @param query
     * @return
     */
    List<Category> findCategoryByParentId(Query query);

    /**
     * 查询总记录数
     *
     * @param query
     * @return
     */
    int getCategoryByParentId(Query query);

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param query
     */
    void updateCategoryPicUrl(Query query);

    /**
     * 修改类目描述
     *
     * @param 
     */
    void doUpdateCategoryIntro(Category category);

    /**
     * 初始化修改类目描述页
     *
     * @param query
     * @return
     */
    Category fintCategoryIntro(Query query);

    /**
     * 添加类目
     * @param category
     */
    void createCategory(Category category);

    /**
     * 删除类目
     * @param categoryId
     */
    void deleteCategory(int categoryId);
}
