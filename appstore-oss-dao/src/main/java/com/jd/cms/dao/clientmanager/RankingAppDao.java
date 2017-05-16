package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.QueryRanking;
import com.jd.cms.domain.clientmanager.RankingManagerResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午6:57
 * To change this template use File | Settings | File Templates.
 */
public interface RankingAppDao {
    /**
     * 查询排行榜
     * @param queryRanking
     * @return
     */
    List<RankingManagerResult> findRankingApp(QueryRanking queryRanking);

    /**
     * 查询排行榜中符合条件的记录个数
     * @param queryRanking
     * @return
     */
    int getRankingAppCount(QueryRanking queryRanking);

    /*
     * 更新排行榜的锁定情况
     */
    void updateRankingLocked(RankingManagerResult rankingManagerResult);

    /*
     * 查找特定排序的排行榜是否有数据
     */
    int findRankingBySeq(RankingManagerResult rankingManagerResult);

    /*
     * 更新排行榜的排序
     */
    void updateRankingSeq(RankingManagerResult rankingManagerResult);

    /*
     *修改数据时更新其他位置的排序
     */
    void updateAddRankingSeq(RankingManagerResult rankingManagerResult);

    /*
     * 更新排行榜
     */
    void updateRanking(RankingManagerResult rankingManagerResult);
}
