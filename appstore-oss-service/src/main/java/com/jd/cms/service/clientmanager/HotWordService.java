package com.jd.cms.service.clientmanager;


import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午8:02
 * To change this template use File | Settings | File Templates.
 */
public interface HotWordService {
    Result findHotWord(int pageIndex, int pageSize, int published);
    int findHotWordBySeq(HotWord hotWord);
    void addHotWord(HotWord hotWord);
    void updateAddHotWordSeq(HotWord hotWord);
    void updateDelHotWordSeq(HotWord hotWord);
    void deleteHotWord(HotWord hotWord);
    void updateHotWordSeq(HotWord hotWord);
    void updateHotWordPublished(HotWord hotWord);
    Result findHotWordById(HotWord hotWord);
    void updateHotWord(HotWord hotWord);
}
