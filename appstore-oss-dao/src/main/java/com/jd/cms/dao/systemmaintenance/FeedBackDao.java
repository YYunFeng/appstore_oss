package com.jd.cms.dao.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.FeedBack;
import com.jd.common.util.base.BaseQuery;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */
public interface FeedBackDao {
    /**
     * 取得问题反馈总记录数
     * @param baseQuery
     * @return int
     */
    int getFeedBackCount(BaseQuery baseQuery);
    /**
     * 取得问题反馈信息集合
     * @param baseQuery
     * @return List
     */
    List<FeedBack> findFeedBackList(BaseQuery baseQuery);
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    int delFeedBack(int id);
}
