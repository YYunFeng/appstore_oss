package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.cms.dao.systemmaintenance.FeedBackDao;
import com.jd.cms.domain.systemmaintenance.FeedBack;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */
public class FeedBackDaoImpl extends BaseDao implements FeedBackDao{
    /**
     * 取得问题反馈总记录数
     * @param baseQuery
     * @return int
     */
    public int getFeedBackCount(BaseQuery baseQuery) {
        return (Integer)queryForObject("SystemMaintenance.getFeedBackCount",baseQuery);
    }
    /**
     * 取得问题反馈信息集合
     * @param baseQuery
     * @return List
     */
    public List<FeedBack> findFeedBackList(BaseQuery baseQuery) {
        return queryForList("SystemMaintenance.findFeedBackList",baseQuery);
    }
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    public int delFeedBack(int id) {
        return delete("SystemMaintenance.delFeedBack",id);
    }
}
