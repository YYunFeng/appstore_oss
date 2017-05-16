package com.jd.cms.dao.clientmanager;

import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午6:43
 * To change this template use File | Settings | File Templates.
 */
public interface HotWordDao {
    /**
     * 查找热门搜索词列表
     * @param query
     * @return
     */
    List<HotWord> findHotWord(Query query);

    /**
     * 获取热门搜索词的数目
     * @param query
     * @return
     */
    int getHotWordCount(Query query);

    /**
     * 通过排序序号搜索此序号上的热门词是否存在
     * @param hotWord
     * @return
     */
    int findHotWordBySeq(HotWord hotWord);

    /**
     * 新增热门词
     * @param hotWord
     */
    void createHotWord(HotWord hotWord);

    /**
     * 添加新热门词时更新相应热门词的序号
     * @param hotWord
     */
    void updateAddHotWordSeq(HotWord hotWord);

    /**
     * 删除热门词时更新其他热门词的排序序号
     * @param hotWord
     */
    void updateDelHotWordSeq(HotWord hotWord);

    /**
     * 删除特定热门词
     * @param hotWord
     */
    void deleteHotWord(HotWord hotWord);

    /**
     * 更新热门词的排序
     * @param hotWord
     */
    void updateHotWordSeq(HotWord hotWord);

    /**
     * 修改热门词的上下线状态
     * @param hotWord
     */
    void updateHotWordPublished(HotWord hotWord);

    /**
     * 通过Id查找热门词信息
     * @param hotWord
     * @return
     */
    HotWord findHotWordById(HotWord hotWord);

    /**
     * 更新热门词信息
     * @param hotWord
     */
    void updateHotWord(HotWord hotWord);
}
