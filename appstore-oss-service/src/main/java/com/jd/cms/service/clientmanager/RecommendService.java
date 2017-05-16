package com.jd.cms.service.clientmanager;

import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
public interface RecommendService {
    Result findRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);

    Result findPhoneRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);

    Result findPadRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);

    Result createRecommend(RecommendManagerResult recommendManagerResult);

    int getSeq(RecommendManagerResult queryRecommend);

    int deleteRecommend(RecommendManagerResult recommendManagerResult);

    int updateRecommendSeq(RecommendManagerResult recommendManagerResult);

    int updateAddSeq(RecommendManagerResult recommendManagerResult);

    int updateCPAddSeq(RecommendManagerResult recommendManagerResult);

    int updateDelSeq(RecommendManagerResult recommendManagerResult);

    int updateCPDelSeq(RecommendManagerResult recommendManagerResult);

    int updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult);

    void updateRecommend(RecommendManagerResult recommendManagerResult);

    int updatePhoneRecommendPubStatus(RecommendManagerResult recommendManagerResult);

    int updatePhoneRecommend(RecommendManagerResult recommendManagerResult);

    void updateCPRecommend(RecommendManagerResult recommendManagerResult);

    int updateWebRecommend(RecommendManagerResult recommendManagerResult);

    int findRecommendBySeq(RecommendManagerResult recommendManagerResult);

    int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult);

    Result findRecommendById(RecommendManagerResult recommendManagerResult);

    Result findCPRecommendById(RecommendManagerResult recommendManagerResult);

    int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult);

    int updateAddAreaType(RecommendManagerResult recommendManagerResult);

    int updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    int updatePhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult);

    int updateAddPhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    int updateDelAreaType(RecommendManagerResult recommendManagerResult);

    int deleteAreaType(RecommendManagerResult recommendManagerResult);

    //Result addHomeAreaType(RecommendManagerResult recommendManagerResult);

    Result initParentId();
    
    Result initWebParentId();
}
