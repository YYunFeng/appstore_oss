package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.cms.manager.clientmanager.RankingAppManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-25
 * Time: 上午10:30
 * To change this template use File | Settings | File Templates.
 */
public class RankingAppManagerCachedImpl implements RankingAppManager {
    private CacheUtils cacheUtils;
    private RankingAppManager rankingAppManager;

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public RankingAppManager getRankingAppManager() {
        return rankingAppManager;
    }

    public void setRankingAppManager(RankingAppManager rankingAppManager) {
        this.rankingAppManager = rankingAppManager;
    }

    public PaginatedList<RankingManagerResult> findRankingApps(int pageIndex, int pageSize, int rankingStyle, int rankingType) {
        PaginatedList<RankingManagerResult> rankingApps;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_RANKINGAPPMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        rankingApps = rankingAppManager.findRankingApps(pageIndex, pageSize, rankingStyle, rankingType);
        if (0 == rankingApps.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_RANKINGAPPMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            rankingApps = findRankingApps(pageIndex, pageSize, rankingStyle, rankingType);

        } else {
            cacheUtils.set(CategoryConstants.CMS_RANKINGAPPMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }

        return rankingApps;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRankingLocked(RankingManagerResult rankingManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findRankingBySeq(RankingManagerResult rankingManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRankingSeq(RankingManagerResult rankingManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddRankingSeq(RankingManagerResult rankingManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateRanking(RankingManagerResult rankingManagerResult) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
