package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.cms.service.clientmanager.HotWordService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午6:31
 * To change this template use File | Settings | File Templates.
 */
public class HotWordAction extends BaseAction{
    private HotWordService hotWordService;
    private int published;
    private HotWord hotWord;

    public HotWord getHotWord() {
        return hotWord;
    }

    public void setHotWord(HotWord hotWord) {
        this.hotWord = hotWord;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public HotWordService getHotWordService() {
        return hotWordService;
    }

    public void setHotWordService(HotWordService hotWordService) {
        this.hotWordService = hotWordService;
    }

    public String getHotWords(){
        Result result = hotWordService.findHotWord(page, PAGE_SIZE, published);
        toVm(result);
        return "hotWordList";
    }

    public String addHotWords(){
        return "addHotWord";
    }

    public void doAddHotWord() throws Exception {
        int isExist = hotWordService.findHotWordBySeq(hotWord);
        if(0!=isExist){
            hotWordService.updateAddHotWordSeq(hotWord);
            hotWordService.addHotWord(hotWord);
        }else{
            hotWordService.addHotWord(hotWord);
        }
    }

    public void deleteHotWord() throws Exception {
        hotWordService.updateDelHotWordSeq(hotWord);
        hotWordService.deleteHotWord(hotWord);
    }

    public void updateHotWordSeq() throws Exception {
        int isExist = hotWordService.findHotWordBySeq(hotWord);
        if(0!=isExist){
            hotWordService.updateAddHotWordSeq(hotWord);
            hotWordService.updateHotWordSeq(hotWord);
        }else{
            hotWordService.updateHotWordSeq(hotWord);
        }
    }

    public void updateHotWordPublished() throws Exception{
        hotWordService.updateHotWordPublished(hotWord);
    }

    public String editHotWord() throws Exception{
        Result result = hotWordService.findHotWordById(hotWord);
        toVm(result);
        return "editHotWord";
    }

    public void updateHotWord() throws Exception{
       hotWordService.updateHotWord(hotWord);
    }
}
