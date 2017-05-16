package com.jd.cms.manager.systemmaintenance;

import com.jd.appstore.domain.Category;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-6
 * Time: 下午12:10
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryMaintenanceManager {
    /**
     * 按二级类目查询三级类目列表
     *
     * @return
     * @throws Exception
     */
    PaginatedList<Category> findCategoryByParentId(int pageIndex, int pageSize, int parentId);

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param picUrl
     * @param id
     * @return
     */
    void updateCategoryPicUrl(String picUrl, int id);

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    void doUpdateCategoryIntro(Category category);

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    Category fintCategoryIntro(int categoryId);


    void ceateCategory(Category category);

    void deleteCategory(int categoryId);
}
