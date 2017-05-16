package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.domain.clientmanager.HotWord;
import com.jd.cms.manager.clientmanager.HotWordManager;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-20
 * Time: 下午7:32
 * To change this template use File | Settings | File Templates.
 */
public class HotWordManagerCachedImpl implements HotWordManager {
    private CacheUtils cacheUtils;
    private HotWordManager hotWordManager;

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public HotWordManager getHotWordManager() {
        return hotWordManager;
    }

    public void setHotWordManager(HotWordManager hotWordManager) {
        this.hotWordManager = hotWordManager;
    }

    public PaginatedList<HotWord> findHotWord(int pageIndex, int pageSize, int published) {
        PaginatedList<HotWord> hotWords;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }

        hotWords = hotWordManager.findHotWord(pageIndex, pageSize, published);
        if (0 == hotWords.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            hotWords = findHotWord(pageIndex, pageSize, published);

        } else {
            cacheUtils.set(CategoryConstants.CMS_HOTWORD_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }

        return hotWords;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findHotWordBySeq(HotWord hotWord) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addHotWord(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateAddHotWordSeq(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateDelHotWordSeq(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteHotWord(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateHotWordSeq(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateHotWordPublished(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public HotWord findHotWordById(HotWord hotWord) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateHotWord(HotWord hotWord) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
