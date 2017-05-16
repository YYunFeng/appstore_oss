package com.jd.cms.dao.category;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryQueryDao {

    /**
     * 获取类目名称
     * @param categoryId
     * @return
     */
    public String getCategoryName(int categoryId);
}
