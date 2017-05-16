package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.manager.clientmanager.CategoryManager;
import com.jd.cms.service.clientmanager.CategoryService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 */
public class CategoryServiceImpl implements CategoryService{
    private CategoryManager categoryResultManager;

    public void setCategoryResultManager(CategoryManager categoryResultManager) {
        this.categoryResultManager = categoryResultManager;
    }

    public Result findCategory(String query) {
        Result result = new Result();
        result.addDefaultModel("categorys", categoryResultManager.findCategory(query));
        result.setSuccess(true);
        return result;
    }

    public Result findCategoryByParentId(Category category) {
        Result result = new Result();
        result.addDefaultModel("categorys", categoryResultManager.findCategoryByParentId(category));
        result.setSuccess(true);
        return result;
    }
}
