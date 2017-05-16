package com.jd.cms.dao.clientmanager.impl;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.cms.dao.clientmanager.NoticeDao;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public class NoticeDaoImpl extends BaseDao implements NoticeDao{
    public List<WebsiteNotice> findNotice(Query query) {
        return queryForList("ClientManager.findNoticeResult",query);
    }

    public List<WebsiteNotice> findNoticeByPub(Query query){
        return queryForList("ClientManager.findNoticeResultByPub",query);
    }

    public List<WebsiteNotice> findNoticeById(WebsiteNotice notice) {
        return queryForList("ClientManager.findNoticeById", notice);
    }

    public int getNoticeCount() {
        return (Integer)queryForObject("ClientManager.getNoticeCount");
    }

    public int getNoticeCountByPub(Query query){
        return (Integer)queryForObject("ClientManager.getNoticeCountByPub",query);
    }

    public void updateNoticePubedStatus(WebsiteNotice notice) {
        update("ClientManager.updateNoticePubedStatu",notice);
    }

    public int findNoticeBySeq(WebsiteNotice notice) {
        return (Integer)queryForObject("ClientManager.findNoticeBySeq",notice);
    }

    public void deleteNotice(WebsiteNotice notice) {
        delete("ClientManager.deleteNotice", notice);
    }

    public void updateNoticeSeq(WebsiteNotice notice) {
        update("ClientManager.updateNoticeSeq",notice);
    }

    public void updateAddNoticeSeq(WebsiteNotice notice) {
        update("ClientManager.updateAddNoticeSeq",notice);
    }

    public void updateDelNoticeSeq(WebsiteNotice notice) {
        update("ClientManager.updateDelNoticeSeq",notice);
    }

    public void createNotice(WebsiteNotice notice){
        update("ClientManager.createNotice", notice);
    }

    public void updateNotice(WebsiteNotice notice) {
        update("ClientManager.updateNotice", notice);
    }

}
