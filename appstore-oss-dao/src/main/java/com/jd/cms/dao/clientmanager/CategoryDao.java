package com.jd.cms.dao.clientmanager;

import com.jd.appstore.domain.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDao {
    /**
     * 按条件查询类目
     * @param query
     * @return
     */
    List<Category> findCategory(String query);

    /**
     * 根据父类目Id查找三级类目
     * @param cate
     * @return
     */
    List<Category> findCategoryByParentId(Category cate);
}
