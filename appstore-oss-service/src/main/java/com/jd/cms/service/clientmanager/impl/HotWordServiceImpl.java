package com.jd.cms.service.clientmanager.impl;

import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.cms.manager.clientmanager.HotWordManager;
import com.jd.cms.service.clientmanager.HotWordService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午8:03
 * To change this template use File | Settings | File Templates.
 */
public class HotWordServiceImpl implements HotWordService{
    private HotWordManager hotWordManagerCached;
    private HotWordManager hotWordManager;

    public HotWordManager getHotWordManager() {
        return hotWordManager;
    }

    public void setHotWordManager(HotWordManager hotWordManager) {
        this.hotWordManager = hotWordManager;
    }

    public HotWordManager getHotWordManagerCached() {
        return hotWordManagerCached;
    }

    public void setHotWordManagerCached(HotWordManager hotWordManagerCached) {
        this.hotWordManagerCached = hotWordManagerCached;
    }

    public Result findHotWord(int pageIndex, int pageSize, int published) {
        Result result = new Result();
        result.addDefaultModel("hotWords", hotWordManagerCached.findHotWord(pageIndex, pageSize, published));
        result.setSuccess(true);

        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findHotWordById(HotWord hotWord){
        Result result = new Result();
        result.addDefaultModel("hotWordResult", hotWordManager.findHotWordById(hotWord));
        result.setSuccess(true);
        return result;
    }

    public void updateHotWord(HotWord hotWord) {
        hotWordManager.updateHotWord(hotWord);
    }

    public int findHotWordBySeq(HotWord hotWord) {
        return hotWordManager.findHotWordBySeq(hotWord);
    }

    public void addHotWord(HotWord hotWord) {
        hotWordManager.addHotWord(hotWord);
    }

    public void updateAddHotWordSeq(HotWord hotWord) {
        hotWordManager.updateAddHotWordSeq(hotWord);
    }

    public void updateDelHotWordSeq(HotWord hotWord) {
        hotWordManager.updateDelHotWordSeq(hotWord);
    }

    public void deleteHotWord(HotWord hotWord){
        hotWordManager.deleteHotWord(hotWord);
    }

    public void updateHotWordSeq(HotWord hotWord){
        hotWordManager.updateHotWordSeq(hotWord);
    }

    public void updateHotWordPublished(HotWord hotWord){
        hotWordManager.updateHotWordPublished(hotWord);
    }
}
