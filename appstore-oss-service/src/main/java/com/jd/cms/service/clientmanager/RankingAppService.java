package com.jd.cms.service.clientmanager;

import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午7:27
 * To change this template use File | Settings | File Templates.
 */
public interface RankingAppService {
    Result findRankingApps(int pageIndex, int pageSize, int rankingStyle, int rankingType);

    int updateRankingLocked(RankingManagerResult rankingManagerResult);

    int findRankingBySeq(RankingManagerResult rankingManagerResult);

    int updateRankingSeq(RankingManagerResult rankingManagerResult);

    int updateAddRankingSeq(RankingManagerResult rankingManagerResult);

    void updateRanking(RankingManagerResult rankingManagerResult);
}
