package com.jd.cms.service.systemmaintenance;

import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public interface FeedBackService {
    /**
     * 取得问题反馈信息集合
     * @param pageIndex，pageSize
     * @return PaginatedList
     */
    Result findFeedBackList(int pageIndex, int pageSize);
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    Result delFeedBack(int id);
}
