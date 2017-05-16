package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.ClientRecommend;
import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午5:50
 * To change this template use File | Settings | File Templates.
 */
public interface RecommendManager {
    PaginatedList<RecommendManagerResult> findRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);

    PaginatedList<RecommendManagerResult> findPhoneRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);

    PaginatedList<RecommendManagerResult> findPadRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId);
    
    int getSeq(RecommendManagerResult recommendManagerResult);

    /*
     *创建一条推荐记录
     */
    int createRecommend(RecommendManagerResult recommendManagerResult);

    /*
     * 增加版型
     */
    int addHomeAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 根据版型Id查找此Id是否存在版型
     */
    int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult);

    /*
     * 更新版型Id
     */
    int updateAddAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 更新客户端推荐的排序
     */
    int updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    int updatePhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult);

    int updateAddPhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    int updateDelPhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    /*
     * 删除版型时更新
     */
    int updateDelAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 删除版型
     */
    int deleteAreaType(RecommendManagerResult recommendManagerResult);

    /*
     *删除一条推荐记录
     */
    int deleteRecommend(RecommendManagerResult recommendManagerResult);

    /*
     * 更新推荐的排序
     */
    int updateRecommendSeq(RecommendManagerResult recommendManagerResult);

    /*
     *添加推荐时更新已有推荐的排序状态
     */
    int updateAddSeq(RecommendManagerResult recommendManagerResult);

    int updateCPAddSeq(RecommendManagerResult recommendManagerResult);

    /*
     *删除推荐时更新已有推荐的排序状态
     */
    int updateDelSeq(RecommendManagerResult recommendManagerResult);

    int updateCPDelSeq(RecommendManagerResult recommendManagerResult);

    /*
     * 更新推荐的上下线状态
     */
    int updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult);

    void updateRecommend(RecommendManagerResult recommendManagerResult);

    /*
     * 更新手机客户端的推荐
     */
    int updatePhoneRecommend(RecommendManagerResult recommendManagerResult);

    void updateCPRecommend(RecommendManagerResult recommendManagerResult);

    int updateWebRecommend(RecommendManagerResult recommendManagerResult);

    /*
     * 更新手机客户端首页推荐内容的上下线状态
     */
    int updatePhoneRecommendPubedStatus(RecommendManagerResult recommendManagerResult);

    /*
     *查询此排序的推荐是否存在
     */
    int findRecommendBySeq(RecommendManagerResult recommendManagerResult);

    int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult);

    ClientRecommend findRecommendById(RecommendManagerResult recommendManagerResult);

    RecommendManagerResult findCPRecommendById(RecommendManagerResult recommendManagerResult);
}
