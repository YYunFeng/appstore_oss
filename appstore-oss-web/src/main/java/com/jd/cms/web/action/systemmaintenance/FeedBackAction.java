package com.jd.cms.web.action.systemmaintenance;

import com.jd.cms.service.systemmaintenance.FeedBackService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:02
 * To change this template use File | Settings | File Templates.
 */
public class FeedBackAction extends BaseAction{
    /**
     * message
     */
    private String message;
    /**
     * service注入
     */
    private FeedBackService feedBackService;
    /**
     * 接收id
     */
    private int id;
    /**
     * 取得问题反馈信息集合
     * @return PaginatedList
     * @throws Exception
     */
    public String findfeedBackList() throws Exception{
        message = Integer.toString(hashCode());
        Result results = feedBackService.findFeedBackList(page,PAGE_SIZE);
        toVm(results);
        return "FEEDBACK";
    }
    /**
     * 删除问题反馈
     * @return int
     * @throws Exception
     */
    public String delFeedBack(){
        feedBackService.delFeedBack(id);
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FeedBackService getFeedBackService() {
        return feedBackService;
    }

    public void setFeedBackService(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}