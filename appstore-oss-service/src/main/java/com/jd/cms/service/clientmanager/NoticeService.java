package com.jd.cms.service.clientmanager;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:57
 * To change this template use File | Settings | File Templates.
 */
public interface NoticeService {
    Result findNotice(int pageIndex, int pageSize);
    Result findNoticeByPub(int pageIndex, int pageSize, int pubedStatus);
    int updateNoticePubedStatus(WebsiteNotice notice);
    int deleteNotice(WebsiteNotice notice);
    int findNoticeBySeq(WebsiteNotice notice);
    int updateAddNoticeSeq(WebsiteNotice notice);
    int updateDelNoticeSeq(WebsiteNotice notice);
    int updateNoticeSeq(WebsiteNotice notice);
    void updateNotice(WebsiteNotice notice);
    void createNotice(WebsiteNotice notice);
    Result findNoticeById(WebsiteNotice notice);
}
