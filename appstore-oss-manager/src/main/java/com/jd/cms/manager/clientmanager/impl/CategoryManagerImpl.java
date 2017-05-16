package com.jd.cms.manager.clientmanager.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.dao.clientmanager.CategoryDao;
import com.jd.cms.manager.clientmanager.CategoryManager;
import com.jd.common.manager.BaseManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午7:57
 * To change this template use File | Settings | File Templates.
 */
public class CategoryManagerImpl extends BaseManager implements CategoryManager{
    private CategoryDao categoryDao;
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findCategory(String query) {
        List<Category> category = categoryDao.findCategory(query);
        return category;
    }

    public List<Category> findCategoryByParentId(Category cate) {
        List<Category> category = categoryDao.findCategoryByParentId(cate);
        return category;
    }
}
