package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.domain.clientmanager.ClientRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.cms.manager.clientmanager.RecommendManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.log4j.Category;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-20
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class RecommendManagerCachedImpl implements RecommendManager {
    private CacheUtils cacheUtils;
    private RecommendManager recommendResultManager;

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public RecommendManager getRecommendResultManager() {
        return recommendResultManager;
    }

    public void setRecommendResultManager(RecommendManager recommendResultManager) {
        this.recommendResultManager = recommendResultManager;
    }

    public PaginatedList<RecommendManagerResult> findRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        PaginatedList<RecommendManagerResult> recommends;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_RECOMMENDMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        recommends = recommendResultManager.findRecommend(pageIndex, pageSize, clientType, moduleId, areaId);
        if (0 == recommends.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            recommends = findRecommend(pageIndex, pageSize, clientType, moduleId, areaId);

        } else {
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return recommends;
    }

    public PaginatedList<RecommendManagerResult> findPhoneRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        PaginatedList<RecommendManagerResult> recommends;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_RECOMMENDMANAGER_PHONE_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        recommends = recommendResultManager.findPhoneRecommend(pageIndex, pageSize, clientType, moduleId, areaId);
        if (0 == recommends.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PHONE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            recommends = findPhoneRecommend(pageIndex, pageSize, clientType, moduleId, areaId);

        } else {
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PHONE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return recommends;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaginatedList<RecommendManagerResult> findPadRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        PaginatedList<RecommendManagerResult> recommends;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_RECOMMENDMANAGER_PAD_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        recommends = recommendResultManager.findPadRecommend(pageIndex, pageSize, clientType, moduleId, areaId);
        if (0 == recommends.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PAD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            recommends = findPadRecommend(pageIndex, pageSize, clientType, moduleId, areaId);

        } else {
            cacheUtils.set(CategoryConstants.CMS_RECOMMENDMANAGER_PAD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return recommends;
    }


    public int getSeq(RecommendManagerResult queryRecommend) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int createRecommend(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int addHomeAreaType(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddAreaType(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updatePhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddPhoneRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelPhoneRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelAreaType(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteAreaType(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteRecommend(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRecommendSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateCPAddSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateCPDelSeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateRecommend(RecommendManagerResult recommendManagerResult) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updatePhoneRecommend(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateCPRecommend(RecommendManagerResult recommendManagerResult) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateWebRecommend(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updatePhoneRecommendPubedStatus(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ClientRecommend findRecommendById(RecommendManagerResult recommendManagerResult) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RecommendManagerResult findCPRecommendById(RecommendManagerResult recommendManagerResult) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RecommendManagerResult findRecommendById(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
