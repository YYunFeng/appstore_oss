package com.jd.cms.service.clientmanager.impl;

import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.cms.manager.clientmanager.RankingAppManager;
import com.jd.cms.service.clientmanager.RankingAppService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午7:29
 * To change this template use File | Settings | File Templates.
 */
public class RankingAppServiceImpl implements RankingAppService {
    private RankingAppManager rankingAppManagerCached;
    private RankingAppManager rankingAppManager;

    public RankingAppManager getRankingAppManager() {
        return rankingAppManager;
    }

    public void setRankingAppManager(RankingAppManager rankingAppManager) {
        this.rankingAppManager = rankingAppManager;
    }

    public void setRankingAppManagerCached(RankingAppManager rankingAppManagerCached) {
        this.rankingAppManagerCached = rankingAppManagerCached;
    }

    public Result findRankingApps(int pageIndex, int pageSize, int rankingStyle, int rankingType) {
        Result result = new Result();
        result.addDefaultModel("rankingApps", rankingAppManagerCached.findRankingApps(pageIndex, pageSize, rankingStyle, rankingType));
        result.addDefaultModel("rankingStyle", "" + rankingStyle);
        result.addDefaultModel("rankingType", "" + rankingType);
        result.setSuccess(true);
        return result;
    }

    public int updateRankingLocked(RankingManagerResult rankingManagerResult) {

        return rankingAppManager.updateRankingLocked(rankingManagerResult);
    }

    public int findRankingBySeq(RankingManagerResult rankingManagerResult) {
        return rankingAppManager.findRankingBySeq(rankingManagerResult);
    }

    public int updateRankingSeq(RankingManagerResult rankingManagerResult) {
        return rankingAppManager.updateRankingSeq(rankingManagerResult);
    }

    public int updateAddRankingSeq(RankingManagerResult rankingManagerResult) {
        return rankingAppManager.updateAddRankingSeq(rankingManagerResult);
    }

    public void updateRanking(RankingManagerResult rankingManagerResult) {
        rankingAppManager.updateRanking(rankingManagerResult);
    }
}
