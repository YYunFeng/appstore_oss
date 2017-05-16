package com.jd.cms.dao.clientmanager.impl;


import com.jd.cms.dao.clientmanager.HotWordDao;
import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午7:20
 * To change this template use File | Settings | File Templates.
 */
public class HotWordDaoImpl extends BaseDao implements HotWordDao {
    public List<HotWord> findHotWord(Query query) {
        return queryForList("ClientManager.findHotWordResult", query);
    }

    public int getHotWordCount(Query query) {
        return (Integer)queryForObject("ClientManager.getHotWordCount", query);
    }

    public int findHotWordBySeq(HotWord hotWord) {
        return (Integer)queryForObject("ClientManager.findHotWordBySeq", hotWord);
    }

    public void createHotWord(HotWord hotWord) {
        insert("ClientManager.createHotWord", hotWord);
    }

    public void updateAddHotWordSeq(HotWord hotWord) {
        update("ClientManager.updateAddHotWordSeq", hotWord);
    }

    public void updateDelHotWordSeq(HotWord hotWord) {
        update("ClientManager.updateDelHotWordSeq", hotWord);
    }

    public void deleteHotWord(HotWord hotWord){
        delete("ClientManager.deleteHotWord", hotWord);
    }

    public void updateHotWordSeq(HotWord hotWord){
        update("ClientManager.updateHotWordSeq", hotWord);
    }

    public void updateHotWordPublished(HotWord hotWord){
        update("ClientManager.updateHotWordPublished", hotWord);
    }

    public HotWord findHotWordById(HotWord hotWord){
        return (HotWord)queryForObject("ClientManager.findHotWordById", hotWord);
    }

    public void updateHotWord(HotWord hotWord){
        update("ClientManager.updateHotWord", hotWord);
    }
}
