package com.jd.cms.web.action.clientmanager;

import com.jd.appstore.domain.WebsiteNotice;
import com.jd.cms.service.clientmanager.NoticeService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

import java.security.PublicKey;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 下午8:13
 * To change this template use File | Settings | File Templates.
 */
public class NoticeAction extends BaseAction{
    private NoticeService noticeService;
    private int pageSize = 5;
    private WebsiteNotice websiteNotice;
    private int pubedStatus;

    public int getPubedStatus() {
        return pubedStatus;
    }

    public void setPubedStatus(int pubedStatus) {
        this.pubedStatus = pubedStatus;
    }

    public WebsiteNotice getWebsiteNotice() {
        return websiteNotice;
    }

    public void setWebsiteNotice(WebsiteNotice websiteNotice) {
        this.websiteNotice = websiteNotice;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public String getNoticeList() throws Exception{
        Result notices = noticeService.findNotice(page, pageSize);
        toVm(notices);
        return "noticeList";
    }

    public String getNoticeListByPub() throws Exception{
        Result notices = noticeService.findNoticeByPub(page, pageSize, pubedStatus);
        toVm(notices);
        return "noticeList";
    }

    public int updateNoticePubedStatus() throws Exception{
        int success = noticeService.updateNoticePubedStatus(websiteNotice);
        return 1;
    }

    public void updateNotice() throws Exception {
        noticeService.updateNotice(websiteNotice);
    }

    public void updateNoticeSeq() throws Exception{
        int isExist = findNoticeBySeq();
        if(0!=isExist){
            noticeService.updateAddNoticeSeq(websiteNotice);
            noticeService.updateNoticeSeq(websiteNotice);
        }else{
           noticeService.updateNoticeSeq(websiteNotice);
        }
    }

    public String deleteNotice() throws Exception {
        updateDelNoticeSeq();
        int isSuccess = noticeService.deleteNotice(websiteNotice);
        if(0!=isSuccess){
            return getNoticeListByPub();
        }
        return null;
    }

    public void updateAddNoticeSeq() throws Exception {
        noticeService.updateAddNoticeSeq(websiteNotice);
    }

    public void updateDelNoticeSeq() throws Exception{
        noticeService.updateDelNoticeSeq(websiteNotice);
    }

    public int findNoticeBySeq() throws Exception{
        int count = noticeService.findNoticeBySeq(websiteNotice);
        return count;
    }

    public String addNotice() throws Exception{
        return "addNotice";
    }

    public void doAddNotice() throws Exception{
        int isExist = findNoticeBySeq();
        if(0!=isExist){
            updateAddNoticeSeq();
            noticeService.createNotice(websiteNotice);
        }else{
            noticeService.createNotice(websiteNotice);
        }
    }

    public void findNoticeById() throws Exception{
        Result result = null;
        try{
        result = noticeService.findNoticeById(websiteNotice);
        }catch(Exception e){
            e.printStackTrace();
        }
        toVm(result);
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }
}
