package com.jd.cms.manager.clientmanager.impl;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.cms.manager.clientmanager.NoticeManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午10:46
 * To change this template use File | Settings | File Templates.
 */
public class NoticeManagerCachedImpl implements NoticeManager {
    private CacheUtils cacheUtils;
    private NoticeManager noticeManager;

    public NoticeManager getNoticeManager() {
        return noticeManager;
    }

    public void setNoticeManager(NoticeManager noticeManager) {
        this.noticeManager = noticeManager;
    }

    public CacheUtils getCacheUtils() {

        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public PaginatedList<WebsiteNotice> findNotice(int pageIndex, int pageSize) {
        PaginatedList<WebsiteNotice> notices;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_NOTICEMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        notices = noticeManager.findNotice(pageIndex, pageSize);
        if (0 == notices.size() && 1 < pageIndex) {
            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_NOTICEMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            notices = findNotice(pageIndex, pageSize);
        } else {
            cacheUtils.set(CategoryConstants.CMS_NOTICEMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return notices;
    }

    public PaginatedList<WebsiteNotice> findNoticeByPub(int pageIndex, int pageSize, int pubedStatus) {
        PaginatedList<WebsiteNotice> notices;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_NOTICEMANAGER_PUB_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        notices = noticeManager.findNoticeByPub(pageIndex, pageSize, pubedStatus);
        if (0 == notices.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_NOTICEMANAGER_PUB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            notices = findNoticeByPub(pageIndex, pageSize, pubedStatus);

        } else {
            cacheUtils.set(CategoryConstants.CMS_NOTICEMANAGER_PUB_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return notices;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<WebsiteNotice> findNoticeById(WebsiteNotice notice) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateNoticePubedStatus(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteNotice(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findNoticeBySeq(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddNoticeSeq(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelNoticeSeq(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateNoticeSeq(WebsiteNotice notice) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createNotice(WebsiteNotice notice) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateNotice(WebsiteNotice notice) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
