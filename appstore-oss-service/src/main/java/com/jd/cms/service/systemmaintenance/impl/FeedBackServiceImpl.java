package com.jd.cms.service.systemmaintenance.impl;

import com.jd.cms.manager.systemmaintenance.FeedBackManager;
import com.jd.cms.service.systemmaintenance.FeedBackService;
import com.jd.common.web.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: zhounan
 * Date: 12-9-3
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
public class FeedBackServiceImpl implements FeedBackService{
    /**
     * 日志
     */
    private final static Log log = LogFactory.getLog(FeedBackServiceImpl.class);
    /**
     * managerCached注入
     */
    private FeedBackManager feedBackManagerCached;
    /**
     * 取得问题反馈信息集合
     * @param pageIndex，pageSize
     * @return PaginatedList
     */
    public Result findFeedBackList(int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("FeedBacks", feedBackManagerCached.findFeedBackList(pageIndex, pageSize));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("取得平台信息集合 error!", e);
        }
        return result;
    }
    /**
     * 删除问题反馈
     * @param id
     * @return int
     */
    public Result delFeedBack(int id) {
        Result result = new Result();
        try{
          int  isSuccess=feedBackManagerCached.delFeedBack(id);
          if(0!=isSuccess){
            result.addDefaultModel("info", "删除平台信息成功");
          }else{
            result.addDefaultModel("info", "删除平台信息失败");
          }
            result.setSuccess(true);
        }catch(Exception e){
            log.error("删除平台信息 error!",e);
        }
        return result;
    }

    public FeedBackManager getFeedBackManagerCached() {
        return feedBackManagerCached;
    }

    public void setFeedBackManagerCached(FeedBackManager feedBackManagerCached) {
        this.feedBackManagerCached = feedBackManagerCached;
    }
}
