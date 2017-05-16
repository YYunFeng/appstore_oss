package com.jd.cms.manager.clientmanager;

import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午7:24
 * To change this template use File | Settings | File Templates.
 */
public interface HotWordManager {
    PaginatedList<HotWord> findHotWord(int pageIndex, int pageSize, int published);
    int findHotWordBySeq(HotWord hotWord);
    void addHotWord(HotWord hotWord);
    void updateAddHotWordSeq(HotWord hotWord);
    void updateDelHotWordSeq(HotWord hotWord);
    void deleteHotWord(HotWord hotWord);
    void updateHotWordSeq(HotWord hotWord);
    void updateHotWordPublished(HotWord hotWord);
    HotWord findHotWordById(HotWord hotWord);
    void updateHotWord(HotWord hotWord);
}
