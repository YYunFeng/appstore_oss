package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.RecommendDao;
import com.jd.cms.domain.clientmanager.ClientRecommend;
import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class RecommendDaoImpl extends BaseDao implements RecommendDao{


    public List<RecommendManagerResult> findRecommend(QueryRecommend queryRecommend) {
        return queryForList("ClientManager.findRecommendResult", queryRecommend);
    }

   /* public List<RecommendManagerResult> findPhoneRecommendForCount(QueryRecommend queryRecommend) {
        return queryForList("ClientManager.findPhoneRecommendForCount", queryRecommend);
    }*/

    public int getRecommendCount(QueryRecommend queryRecommend) {
        return (Integer)queryForObject("ClientManager.getRecommendCount", queryRecommend);
    }

    public List<RecommendManagerResult> findPhoneRecommend(QueryRecommend queryRecommend){
        return queryForList("ClientManager.findPhoneRecommendResult", queryRecommend);
    }

    public List<RecommendManagerResult> findPadRecommend(QueryRecommend queryRecommend) {
        return queryForList("ClientManager.findPadRecommendResult", queryRecommend);
    }

    public int getPhoneRecommendCount(QueryRecommend queryRecommend){
        return (Integer)queryForObject("ClientManager.getPhoneRecommendCount", queryRecommend);
    }

    public int getPadRecommendCount(QueryRecommend queryRecommend) {
        return (Integer)queryForObject("ClientManager.getPadRecommendCount", queryRecommend);
    }

    public int getSeq(RecommendManagerResult recommendManagerResult){
        String i = (String)queryForObject("ClientManager.getSeq", recommendManagerResult);
        int result;
        if(i==null){
            result = 0;
        }else{
            result = Integer.parseInt(i);
        }
        return result;
    }

    public void createRecommend(RecommendManagerResult recommendManagerResult) {
        insert("ClientManager.createRecommend", recommendManagerResult);
    }

    public void updateRecommendSeq(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateRecommendSeq", recommendManagerResult);
    }

    public void deleteRecommend(RecommendManagerResult recommendManagerResult) {
        delete("ClientManager.deleteRecommend", recommendManagerResult);
    }

    public void updateAddSeq(RecommendManagerResult recommendManagerResult) {
        update("ClientManager.updateAddSeq", recommendManagerResult);
    }

    public void updateCPAddSeq(RecommendManagerResult recommendManagerResult) {
        update("ClientManager.updateCPAddSeq", recommendManagerResult);
    }

    public void updateDelSeq(RecommendManagerResult recommendManagerResult) {
        update("ClientManager.updateDelSeq", recommendManagerResult);
    }

    public void updateCPDelSeq(RecommendManagerResult recommendManagerResult) {
        update("ClientManager.updateCPDelSeq", recommendManagerResult);
    }

    public void updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateRecommendPubedStatus", recommendManagerResult);
    }

    public void updateRecommendADPubedStatus(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateRecommendADPubedStatus", recommendManagerResult);
    }

    public void updateRecommend(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateRecommend", recommendManagerResult);
    }

    public void updatePhoneRecommend(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updatePhoneRecommend", recommendManagerResult);
    }

    public void updateCPRecommend(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateCPRecommend", recommendManagerResult);
    }

    public void updateWebRecommend(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateWebRecommend", recommendManagerResult);
    }

    public void updatePhoneRecommendPubedStatus(RecommendManagerResult recommendManagerResult) {
        update("ClientManager.updatePhoneRecommendPubedStatus", recommendManagerResult);
    }

    public int findRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return (Integer)queryForObject("ClientManager.findRecommendBySeq",recommendManagerResult);
    }

    public int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return (Integer)queryForObject("ClientManager.findCPRecommendBySeq", recommendManagerResult);
    }

    public ClientRecommend findRecommendById(RecommendManagerResult recommendManagerResult) {
        return (ClientRecommend)queryForObject("ClientManager.findRecommendById",recommendManagerResult);
    }

    public RecommendManagerResult findCPRecommendById(RecommendManagerResult recommendManagerResult){
        return (RecommendManagerResult)queryForObject("ClientManager.findCPRecommendById", recommendManagerResult);
    }

    public void addHomeAreaType(RecommendManagerResult recommendManagerResult) {
        //insert("ClientManager.addHomeAreaType", recommendManagerResult);
    }

    public int updateAddAreaType(RecommendManagerResult recommendManagerResult) {
        return (Integer)update("ClientManager.updateAddAreaType",recommendManagerResult);
    }

    public void updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updatedPhoneRecommendSeq", recommendManagerResult);
    }

    public void updatedPhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updatedPhoneRecommendSeqWithOut", recommendManagerResult);
    }

    public void updateDelAreaType(RecommendManagerResult recommendManagerResult){
        update("ClientManager.updateDelAreaType", recommendManagerResult);
    }

    public void deleteAreaType(RecommendManagerResult recommendManagerResult){
        delete("ClientManager.deleteAreaType", recommendManagerResult);
    }

    public int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult) {
        return (Integer)queryForObject("ClientManager.findHomeAreaTypeByAreaId",recommendManagerResult);
    }


}
