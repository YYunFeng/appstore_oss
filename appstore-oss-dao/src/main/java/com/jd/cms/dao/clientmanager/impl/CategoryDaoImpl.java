package com.jd.cms.dao.clientmanager.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.dao.clientmanager.CategoryDao;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午7:50
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao{

    public List<Category> findCategory(String query) {
        return queryForList("ClientManager.findCategoryResult",query);
    }

    public List<Category> findCategoryByParentId(Category cate) {
        return queryForList("ClientManager.findCategoryByParentId", cate);
    }
}
