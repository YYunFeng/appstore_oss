package com.jd.cms.manager.terminalManagement.impl;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.terminalManagement.ScreenManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 屏幕管理managerCachedImpl
 */
public class ScreenManagerCachedImpl implements ScreenManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private ScreenManager screenManager;

    /**
     * 取得屏幕参数集合
     *
     * @param pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<TerminalpageOutput> findScreenPage(int pageIndex, int pageSize) {
        PaginatedList<TerminalpageOutput> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_SCREEN_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询屏幕参数集合
        paginatedList = screenManager.findScreenPage(pageIndex, pageSize);
        //列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_SCREEN_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findScreenPage(pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_SCREEN_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回屏幕参数集合
        return paginatedList;
    }

    /**
     * 创建屏幕信息
     *
     * @param terminalInsertInput
     * @return int
     */
    public int createScreen(TerminalInsertInput terminalInsertInput) {
        return screenManager.createScreen(terminalInsertInput);
    }

    /**
     * 更新屏幕上下架状态
     *
     * @param terminalpageInput
     * @return int
     */
    public int upScreenOnline(TerminalpageInput terminalpageInput) {
        return screenManager.upScreenOnline(terminalpageInput);
    }

    /**
     * 删除屏幕信息
     *
     * @param terminalpageInput
     * @return int
     */
    public int delScreen(TerminalpageInput terminalpageInput) {
        return screenManager.delScreen(terminalpageInput);
    }

    /**
     * 根据ID查询单条屏幕信息
     *
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findScreenById(int id) {
        return screenManager.findScreenById(id);
    }

    /**
     * 更新屏幕信息
     *
     * @param terminalpageInput
     * @return int
     */
    public int upScreen(TerminalpageInput terminalpageInput) {
        return screenManager.upScreen(terminalpageInput);
    }

    /**
     * 检查屏幕版本名
     *
     * @param name
     * @return String
     */
    public String checkScreenName(String name) {
        return screenManager.checkScreenName(name);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }
}
