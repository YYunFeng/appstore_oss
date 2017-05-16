package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.cms.service.clientmanager.RankingAppService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午5:34
 * To change this template use File | Settings | File Templates.
 */
public class RankingAction extends BaseAction{
    private RankingAppService rankingAppService;
    private RankingManagerResult rankingManagerResult;

    public RankingManagerResult getRankingManagerResult() {
        return rankingManagerResult;
    }

    public void setRankingManagerResult(RankingManagerResult rankingManagerResult) {
        this.rankingManagerResult = rankingManagerResult;
    }

    private int rankingType;
    private int rankingStyle;
    private int pageSize = 20;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRankingStyle() {
        return rankingStyle;
    }

    public void setRankingStyle(int rankingStyle) {
        this.rankingStyle = rankingStyle;
    }

    public int getRankingType() {
        return rankingType;
    }

    public void setRankingType(int rankingType) {
        this.rankingType = rankingType;
    }

    public void setRankingAppService(RankingAppService rankingAppService) {
        this.rankingAppService = rankingAppService;
    }

    public String getRankingList() throws Exception{
        Result rankingApps = rankingAppService.findRankingApps(page, pageSize, rankingStyle, rankingType);
        toVm(rankingApps);
        return "rankingAppsList";
    }

    public String updateRankingLocked() throws Exception{
        int isSuccess = rankingAppService.updateRankingLocked(rankingManagerResult);

        return  null;
    }

    public void updateRankingSeq() throws Exception{
        int isExist = findRankingBySeq();
        if(0!=isExist){
            rankingAppService.updateAddRankingSeq(rankingManagerResult);
            rankingAppService.updateRankingSeq(rankingManagerResult);
        }else{
            rankingAppService.updateRankingSeq(rankingManagerResult);
        }
    }

    public void updateRanking() throws Exception{
        rankingAppService.updateRanking(rankingManagerResult);
    }

    public int findRankingBySeq() throws Exception{
        int count = rankingAppService.findRankingBySeq(rankingManagerResult);
        return count;
    }

    public String editRanking() throws Exception{
        return "editRanking";
    }

}
