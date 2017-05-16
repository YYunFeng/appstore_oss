package com.jd.cms.domain.clientmanager;

import com.jd.common.util.base.BaseQuery;

/**
 * Created by IntelliJ IDEA.
 * User: cuiyi
 * Date: 12-9-10
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class QueryAppForCategory extends BaseQuery{
    private String name;
    private String categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
