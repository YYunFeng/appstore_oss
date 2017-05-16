package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.ClientRecommend;
import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午4:27
 * To change this template use File | Settings | File Templates.
 */
public interface RecommendDao {
    /**
     * 查找推荐列表
     * @param queryRecommend
     * @return
     */
    List<RecommendManagerResult> findRecommend(QueryRecommend queryRecommend);

//    List<RecommendManagerResult> findPhoneRecommendForCount(QueryRecommend queryRecommend);

    int getRecommendCount(QueryRecommend queryRecommend);

    /**
     * 查找手机客户端推荐内容列表
      * @param queryRecommend
     * @return
     */
    List<RecommendManagerResult> findPhoneRecommend(QueryRecommend queryRecommend);

    /**
     * 查找Pad客户端推荐列表
     * @param queryRecommend
     * @return
     */
    List<RecommendManagerResult> findPadRecommend(QueryRecommend queryRecommend);

    int getPhoneRecommendCount(QueryRecommend queryRecommend);

    int getPadRecommendCount(QueryRecommend queryRecommend);

    int getSeq(RecommendManagerResult recommendManagerResult);


    /*
     *添加一条Banner记录
     */
    void createRecommend(RecommendManagerResult recommendManagerResult);

    /*
     *删除一条Banner记录
     */
    void deleteRecommend(RecommendManagerResult recommendManagerResult);

    /*
     * 更新某条记录的排序
     */
    void updateRecommendSeq(RecommendManagerResult recommendManagerResult);

    /*
     *添加时更新排序属性
     */
    void updateAddSeq(RecommendManagerResult recommendManagerResult);

    /**
     * 添加CP推荐时更新排序
     * @param recommendManagerResult
     */
    void updateCPAddSeq(RecommendManagerResult recommendManagerResult);

    /*
     *删除时更新排序属性
     */
    void updateDelSeq(RecommendManagerResult recommendManagerResult);

    void updateCPDelSeq(RecommendManagerResult recommendManagerResult);

    void updateRecommendPubedStatus(RecommendManagerResult recommendManagerResult);

    void updateRecommendADPubedStatus(RecommendManagerResult recommendManagerResult);

    void updateRecommend(RecommendManagerResult recommendManagerResult);

    void updatePhoneRecommend(RecommendManagerResult recommendManagerResult);

    void updateCPRecommend(RecommendManagerResult recommendManagerResult);

    void updateWebRecommend(RecommendManagerResult recommendManagerResult);

    void updatePhoneRecommendPubedStatus(RecommendManagerResult recommendManagerResult);

    /*
     *查询此排序上是否有数据
     */
    int findRecommendBySeq(RecommendManagerResult recommendManagerResult);

    int findCPRecommendBySeq(RecommendManagerResult recommendManagerResult);

    /*
     * 通过Id查询推荐是否存在
     */
    ClientRecommend findRecommendById(RecommendManagerResult recommendManagerResult);

    RecommendManagerResult findCPRecommendById(RecommendManagerResult recommendManagerResult);
    /*
     * 添加版型
     */
    void addHomeAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 添加版型时更新其他位置的版型Id
     */
    int updateAddAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 更新移动客户端的排序
     */
    void updatePhoneRecommendSeq(RecommendManagerResult recommendManagerResult);

    void updatedPhoneRecommendSeqWithOut(RecommendManagerResult recommendManagerResult);

    /*
     * 删除版型时更新其他位置的版型Id
     */
    void updateDelAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 删除版型
     */
    void deleteAreaType(RecommendManagerResult recommendManagerResult);

    /*
     * 通过版型Id查询版型是否存在
     */
    int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult);
}
