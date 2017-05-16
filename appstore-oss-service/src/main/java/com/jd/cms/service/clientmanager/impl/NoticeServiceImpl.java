package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.cms.manager.clientmanager.NoticeManager;
import com.jd.cms.service.clientmanager.NoticeService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:58
 * To change this template use File | Settings | File Templates.
 */
public class NoticeServiceImpl implements NoticeService{
    private NoticeManager noticeManagerCached;
    private NoticeManager noticeManager;

    public NoticeManager getNoticeManagerCached() {
        return noticeManagerCached;
    }

    public void setNoticeManagerCached(NoticeManager noticeManagerCached) {
        this.noticeManagerCached = noticeManagerCached;
    }

    public NoticeManager getNoticeManager() {
        return noticeManager;
    }

    public void setNoticeManager(NoticeManager noticeManager) {
        this.noticeManager = noticeManager;
    }

    public Result findNotice(int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("notices", noticeManagerCached.findNotice(pageIndex, pageSize));
        result.setSuccess(true);
        return result;
    }

    public Result findNoticeByPub(int pageIndex, int pageSize, int pubedStatus) {
        Result result = new Result();
        result.addDefaultModel("notices", noticeManagerCached.findNoticeByPub(pageIndex, pageSize, pubedStatus));
        result.setSuccess(true);
        return result;
    }

    public Result findNoticeById(WebsiteNotice notice){
        Result result = new Result();
        result.addDefaultModel("notices", noticeManager.findNoticeById(notice));
        result.setSuccess(true);
        return result;
    }

    public void createNotice(WebsiteNotice notice){
        noticeManager.createNotice(notice);
    }

    public int updateNoticePubedStatus(WebsiteNotice notice) {
        return noticeManager.updateNoticePubedStatus(notice);
    }

    public int deleteNotice(WebsiteNotice notice) {
        return noticeManager.deleteNotice(notice);
    }

    public int findNoticeBySeq(WebsiteNotice notice) {
        return noticeManager.findNoticeBySeq(notice);
    }

    public int updateAddNoticeSeq(WebsiteNotice notice) {
        return noticeManager.updateAddNoticeSeq(notice);
    }

    public int updateDelNoticeSeq(WebsiteNotice notice) {
        return noticeManager.updateDelNoticeSeq(notice);
    }

    public int updateNoticeSeq(WebsiteNotice notice) {
        return noticeManager.updateNoticeSeq(notice);
    }

    public void updateNotice(WebsiteNotice notice){
        noticeManager.updateNotice(notice);
    }
}
