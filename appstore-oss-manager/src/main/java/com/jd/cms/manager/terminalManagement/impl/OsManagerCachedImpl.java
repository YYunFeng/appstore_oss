package com.jd.cms.manager.terminalManagement.impl;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.terminalManagement.OsManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;


/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理managerCachesImpl
 */
public class OsManagerCachedImpl implements OsManager{
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private OsManager osManager;
    /**
     * 取得平台信息集合
     * @param pageIndex,pageSize
     * @return PaginatedList
     */
    public PaginatedList<TerminalpageOutput> findOsPage(int pageIndex, int pageSize) {
        PaginatedList<TerminalpageOutput> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
                //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
                if (0 == pageIndex) {
                    //在memcache中取出页号
                    Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_OS_PAGER_CACHED+"_"+ip);
                    //页号是否存在
                    if (null != pager) {
                        //设置页号
                        pageIndex = pager;
                    }
                }
                //查询平台信息集合
                paginatedList = osManager.findOsPage(pageIndex, pageSize);
                //列表是否存在和是否为第一页
                if (0 == paginatedList.size() && 1 < pageIndex) {
                      //页号大于1，则当前页减1
                      pageIndex = pageIndex - 1;
                      //将页号写入memcached
                      cacheUtils.set(CategoryConstants.CMS_OS_PAGER_CACHED+"_"+ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
                      //递归调用本方法
                      paginatedList=findOsPage(pageIndex, pageSize);
                } else {
                      //将页号写入memcached
                      cacheUtils.set(CategoryConstants.CMS_OS_PAGER_CACHED+"_"+ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
                }
                //返回平台信息集合
                return paginatedList;
    }
    /**
     * 创建平台信息
     * @param terminalInsertInput
     * @return int
     */
    public int createOs(TerminalInsertInput terminalInsertInput) {
        return osManager.createOs(terminalInsertInput);
    }
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return int
     */
    public int upOsOnline(TerminalpageInput terminalpageInput) {
        return osManager.upOsOnline(terminalpageInput);
    }
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return int
     */
    public int delOs(TerminalpageInput terminalpageInput) {
        return osManager.delOs(terminalpageInput);
    }
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findOsById(int id) {
        return osManager.findOsById(id);
    }
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return int
     */
    public int upOs(TerminalpageInput terminalpageInput) {
        return osManager.upOs(terminalpageInput);
    }
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    public String checkOsName(String name) {
        return osManager.checkOsName(name);
    }
    /**
     * 检查平台版本码
     * @param code
     * @return Integer
     */
    public Integer checkOsCode(int code) {
        return osManager.checkOsCode(code);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public OsManager getOsManager() {
        return osManager;
    }

    public void setOsManager(OsManager osManager) {
        this.osManager = osManager;
    }
}
