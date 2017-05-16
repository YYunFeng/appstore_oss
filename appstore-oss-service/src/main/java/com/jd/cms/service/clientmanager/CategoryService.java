package com.jd.cms.service.clientmanager;

import com.jd.appstore.domain.Category;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午8:03
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryService {
    Result findCategory(String query);
    Result findCategoryByParentId(Category category);
}
