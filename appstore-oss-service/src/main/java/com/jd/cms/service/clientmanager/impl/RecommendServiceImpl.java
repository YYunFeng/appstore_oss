package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.cms.manager.clientmanager.RecommendManager;
import com.jd.cms.service.clientmanager.RecommendService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午6:52
 * To change this template use File | Settings | File Templates.
 */
public class RecommendServiceImpl implements RecommendService {
    private RecommendManager recommendResultManager;
    private RecommendManager recommendResultManagerCached;
    private String reMobileSoftId;
    private String reMobileGameId;
    private String reWebAppId;

    public String getReWebAppId() {
        return reWebAppId;
    }

    public void setReWebAppId(String reWebAppId) {
        this.reWebAppId = reWebAppId;
    }

    public void setReMobileSoftId(String reMobileSoftId) {
        this.reMobileSoftId = reMobileSoftId;
    }

    public void setReMobileGameId(String reMobileGameId) {
        this.reMobileGameId = reMobileGameId;
    }

    public void setRecommendResultManager(RecommendManager recommendResultManager) {
        this.recommendResultManager = recommendResultManager;
    }

    public void setRecommendResultManagerCached(RecommendManager recommendResultManagerCached) {
        this.recommendResultManagerCached = recommendResultManagerCached;
    }

    public Result findRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        Result result = new Result();
        result.addDefaultModel("recommends", recommendResultManagerCached.findRecommend(pageIndex, pageSize, clientType, moduleId, areaId));
        result.addDefaultModel("path", PicResolutionEnum.IMG_N0.getPrefix());
        result.addDefaultModel("PCCoverPath", PicResolutionEnum.COVER_N4.getPrefix()+"/");
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findPhoneRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId){
        Result result = new Result();
        result.addDefaultModel("recommends", recommendResultManagerCached.findPhoneRecommend(pageIndex, pageSize,clientType,moduleId, areaId));
        result.addDefaultModel("COVER_N0", PicResolutionEnum.COVER_NO.getPrefix()+"/");
        result.addDefaultModel("COVER_N11", PicResolutionEnum.COVER_N11.getPrefix()+"/");
        result.addDefaultModel("COVER_N2", PicResolutionEnum.COVER_N2.getPrefix()+"/");
        result.addDefaultModel("IMG_N0", PicResolutionEnum.IMG_N0.getPrefix());
        result.setSuccess(true);
        return  result;
    }

    public Result findPadRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId){
        Result result = new Result();
        result.addDefaultModel("recommends", recommendResultManagerCached.findPadRecommend(pageIndex, pageSize, clientType, moduleId, areaId));
        result.addDefaultModel("path", PicResolutionEnum.IMG_N0.getPrefix());
        result.addDefaultModel("COVER_N0_Path", PicResolutionEnum.COVER_NO.getPrefix()+"/");
        result.addDefaultModel("COVER_N11_Path", PicResolutionEnum.COVER_N11.getPrefix()+"/");
        
        result.setSuccess(true);
        return result;
    }

    public Result findRecommendById(RecommendManagerResult recommendManagerResult) {
        Result result = new Result();
        result.addDefaultModel("clientRecommend", recommendResultManager.findRecommendById(recommendManagerResult));
        result.addDefaultModel("path", PicResolutionEnum.IMG_N0.getPrefix());
        result.addDefaultModel("PCCoverPath", PicResolutionEnum.COVER_N4.getPrefix()+"/");
        result.setSuccess(true);

        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findCPRecommendById(RecommendManagerResult recommendManagerResult){
        Result result = new Result();
        result.addDefaultModel("recommendManagerResult", recommendResultManager.findCPRecommendById(recommendManagerResult));
        result.addDefaultModel("imgPath", PicResolutionEnum.IMG_N0.getPrefix());
        result.setSuccess(true);
        return result;
    }

    public Result createRecommend(RecommendManagerResult recommendManagerResult) {
        Result result = new Result();
        try {
            int recommendId = recommendResultManager.createRecommend(recommendManagerResult);
            result.addDefaultModel("recommendId", recommendId);
            result.addDefaultModel("recommend", recommendId);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setResultCode("system.error");
        }
        return result;

    }

    public Result addHomeAreaType(RecommendManagerResult recommendManagerResult) {
        Result result = new Result();
        try{
            int recommendId = recommendResultManager.addHomeAreaType(recommendManagerResult);
            result.setSuccess(true);
        }catch (Exception e){
            result.setResultCode("system.error");
        }
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getSeq(RecommendManagerResult recommendManagerResult){
        return recommendResultManager.getSeq(recommendManagerResult);
    }

    public int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.findHomeAreaTypeByAreaId(recommendManagerResult);
    }

    public int updateAddAreaType(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateAddAreaType(recommendManagerResult);
    }

    public int updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult){
        return recommendResultManager.updatePhoneRecommendSeq(recommendManagerResult);
    }

    public int updatePhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updatePhoneRecommendSeqWithOut(recommendManagerResult);
    }

    public int updateAddPhoneRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateAddPhoneRecommendSeq(recommendManagerResult);
    }

    public int updateDelAreaType(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateDelAreaType(recommendManagerResult);
    }

    public int deleteAreaType(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.deleteAreaType(recommendManagerResult);
    }

    public Result initParentId() {
        Result result=new Result();
        result.addDefaultModel("mobileSoftId",reMobileSoftId);
        result.addDefaultModel("mobileGameId", reMobileGameId);
        return result;
    }

    public Result initWebParentId(){
        Result result = new Result();
        result.addDefaultModel("webAppId",reWebAppId);
        return result;
    }

    public int deleteRecommend(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.deleteRecommend(recommendManagerResult);
    }

    public int updateRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateRecommendSeq(recommendManagerResult);
    }

    public int updateAddSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateAddSeq(recommendManagerResult);
    }

    public int updateCPAddSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateCPAddSeq(recommendManagerResult);
    }

    public int updateDelSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateDelSeq(recommendManagerResult);
    }

    public int updateCPDelSeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updateCPDelSeq(recommendManagerResult);
    }

    public int updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult){
        return recommendResultManager.updateRecommendPubedStatus(recommendManagerResult);
    }

    public void updateRecommend(RecommendManagerResult recommendManagerResult){
        recommendResultManager.updateRecommend(recommendManagerResult);
    }

    public int updatePhoneRecommendPubStatus(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.updatePhoneRecommendPubedStatus(recommendManagerResult);
    }

    public int updatePhoneRecommend(RecommendManagerResult recommendManagerResult){
        return recommendResultManager.updatePhoneRecommend(recommendManagerResult);
    }

    public void updateCPRecommend(RecommendManagerResult recommendManagerResult){
        recommendResultManager.updateCPRecommend(recommendManagerResult);
    }

    public int updateWebRecommend(RecommendManagerResult recommendManagerResult){
        return recommendResultManager.updateWebRecommend(recommendManagerResult);
    }

    public int findRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.findRecommendBySeq(recommendManagerResult);
    }

    public int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return recommendResultManager.findCPRecommendBySeq(recommendManagerResult);
    }

}
