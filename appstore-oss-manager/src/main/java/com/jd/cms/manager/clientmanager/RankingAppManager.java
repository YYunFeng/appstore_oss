package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午7:13
 * To change this template use File | Settings | File Templates.
 */
public interface RankingAppManager {
    PaginatedList<RankingManagerResult> findRankingApps(int pageIndex, int pageSize, int rankingStyle, int rankingType);

    int updateRankingLocked(RankingManagerResult rankingManagerResult);

    int findRankingBySeq(RankingManagerResult rankingManagerResult);

    int updateRankingSeq(RankingManagerResult rankingManagerResult);

    int updateAddRankingSeq(RankingManagerResult rankingManagerResult);

    void updateRanking(RankingManagerResult rankingManagerResult);
}
