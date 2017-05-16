package com.jd.cms.manager.clientmanager;

import com.jd.appstore.domain.Category;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午7:56
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryManager {
    List<Category> findCategory(String query);
    List<Category> findCategoryByParentId(Category category);
}
