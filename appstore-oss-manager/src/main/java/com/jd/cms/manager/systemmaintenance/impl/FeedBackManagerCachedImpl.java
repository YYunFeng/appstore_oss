package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.cms.domain.systemmaintenance.FeedBack;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.systemmaintenance.FeedBackManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:10
 * To change this template use File | Settings | File Templates.
 */
public class FeedBackManagerCachedImpl implements FeedBackManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * 日志
     */
    private final static Log log = LogFactory.getLog(FeedBackManagerCachedImpl.class);
    /**
     * Manager注入
     */
    private FeedBackManager feedBackManager;

    /**
     * 取得问题反馈信息集合
     *
     * @param pageIndex，pageSize
     * @return PaginatedList
     */
    public PaginatedList<FeedBack> findFeedBackList(int pageIndex, int pageSize) {
        PaginatedList<FeedBack> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_FEEDBACK_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        paginatedList = feedBackManager.findFeedBackList(pageIndex, pageSize);
        if (0 == paginatedList.size()) {
            if (1 < pageIndex) {
                pageIndex = pageIndex - 1;
                cacheUtils.set(CategoryConstants.CMS_FEEDBACK_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
                paginatedList = findFeedBackList(pageIndex, pageSize);
            }
        }
        cacheUtils.set(CategoryConstants.CMS_FEEDBACK_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        return paginatedList;
    }

    /**
     * 删除问题反馈
     *
     * @param id
     * @return int
     */
    public int delFeedBack(int id) {
        return feedBackManager.delFeedBack(id);
    }

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public FeedBackManager getFeedBackManager() {
        return feedBackManager;
    }

    public void setFeedBackManager(FeedBackManager feedBackManager) {
        this.feedBackManager = feedBackManager;
    }
}
