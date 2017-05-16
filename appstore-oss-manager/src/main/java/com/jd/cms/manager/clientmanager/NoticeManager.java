package com.jd.cms.manager.clientmanager;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:49
 * To change this template use File | Settings | File Templates.
 */
public interface NoticeManager {
    PaginatedList<WebsiteNotice> findNotice(int pageIndex, int pageSize);
    PaginatedList<WebsiteNotice> findNoticeByPub(int pageIndex, int pageSize, int pubedStatus);
    List<WebsiteNotice> findNoticeById(WebsiteNotice notice);
    int updateNoticePubedStatus(WebsiteNotice notice);
    int deleteNotice(WebsiteNotice notice);
    int findNoticeBySeq(WebsiteNotice notice);
    int updateAddNoticeSeq(WebsiteNotice notice);
    int updateDelNoticeSeq(WebsiteNotice notice);
    int updateNoticeSeq(WebsiteNotice notice);
    void createNotice(WebsiteNotice notice);
    void updateNotice(WebsiteNotice notice);
}
