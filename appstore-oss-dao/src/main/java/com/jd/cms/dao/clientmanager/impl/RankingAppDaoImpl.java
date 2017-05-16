package com.jd.cms.dao.clientmanager.impl;

import com.jd.cms.dao.clientmanager.RankingAppDao;
import com.jd.cms.domain.clientmanager.QueryRanking;
import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午7:10
 * To change this template use File | Settings | File Templates.
 */
public class RankingAppDaoImpl extends BaseDao implements RankingAppDao{
    public List<RankingManagerResult> findRankingApp(QueryRanking queryRanking) {
        return queryForList("ClientManager.findRankingApp", queryRanking);
    }

    public int getRankingAppCount(QueryRanking queryRanking) {
        return (Integer)queryForObject("ClientManager.getRankingCount",queryRanking);
    }

    public void updateRankingLocked(RankingManagerResult rankingManagerResult) {
        update("ClientManager.updateRankingLocked", rankingManagerResult);
    }

    public int findRankingBySeq(RankingManagerResult rankingManagerResult) {
        return (Integer)queryForObject("ClientManager.findRankingBySeq", rankingManagerResult);
    }

    public void updateRankingSeq(RankingManagerResult rankingManagerResult) {
        update("ClientManager.updateRankingSeq", rankingManagerResult);
    }

    public void updateAddRankingSeq(RankingManagerResult rankingManagerResult) {
        update("ClientManager.updateAddRankingSeq",rankingManagerResult);
    }

    public void updateRanking(RankingManagerResult rankingManagerResult) {
        update("ClientManager.updateRanking", rankingManagerResult);
    }
}
