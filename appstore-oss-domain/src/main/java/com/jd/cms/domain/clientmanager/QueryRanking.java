package com.jd.cms.domain.clientmanager;

import com.jd.common.util.base.BaseQuery;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class QueryRanking extends BaseQuery{
    private Integer rankingType;
    private Integer rankingStyle;

    public Integer getRankingStyle() {
        return rankingStyle;
    }

    public void setRankingStyle(Integer rankingStyle) {
        this.rankingStyle = rankingStyle;
    }

    public Integer getRankingType() {

        return rankingType;
    }

    public void setRankingType(Integer rankingType) {
        this.rankingType = rankingType;
    }
}
