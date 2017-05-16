package com.jd.cms.dao.category.impl;

import com.jd.cms.dao.category.CategoryQueryDao;
import com.jd.cms.dao.clientmanager.CategoryDao;
import com.jd.common.dao.BaseDao;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: обнГ6:08
 * To change this template use File | Settings | File Templates.
 */
public class CategoryQueryDaoImpl extends BaseDao implements CategoryQueryDao{

    public String getCategoryName(int categoryId) {
        return (String) queryForObject("CategoryQuery.getCategoryName", categoryId);
    }
}
