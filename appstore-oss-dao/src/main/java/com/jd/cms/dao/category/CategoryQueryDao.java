package com.jd.cms.dao.category;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-9
 * Time: ����6:07
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryQueryDao {

    /**
     * ��ȡ��Ŀ����
     * @param categoryId
     * @return
     */
    public String getCategoryName(int categoryId);
}
