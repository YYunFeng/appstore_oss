package com.jd.cms.manager.systemmaintenance;

import com.jd.cms.domain.systemmaintenance.FeedBack;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public interface FeedBackManager {
    /**
     * 取得问题反馈信息集合
     * @param pageIndex，pageSize
     * @return PaginatedList
     */
    PaginatedList<FeedBack> findFeedBackList(int pageIndex, int pageSize);
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    int delFeedBack(int id);
}
