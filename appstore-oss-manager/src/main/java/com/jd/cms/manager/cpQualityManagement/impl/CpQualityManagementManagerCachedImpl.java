package com.jd.cms.manager.cpQualityManagement.impl;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.contains.CommonContants;
import com.jd.cms.manager.cpQualityManagement.CpQualityManagementManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午3:01
 * CP账号管理ManagerCaahedImpl
 */
public class CpQualityManagementManagerCachedImpl implements CpQualityManagementManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private CpQualityManagementManager cpQualityManagementManager;

    /**
     * CP账号管理分页查询
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    public PaginatedList<SelCpPageOutPut> findCpPage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        PaginatedList<SelCpPageOutPut> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_CPQUALITY_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询CP账号管理分页查询
        paginatedList = cpQualityManagementManager.findCpPage(selCpPageInPut, pageIndex, pageSize);
        //列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CPQUALITY_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findCpPage(selCpPageInPut, pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CPQUALITY_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回CP账号管理分页查询
        return paginatedList;
    }

    /**
     * CP帐号的启用停用
     *
     * @param selCpPageInPut
     * @return int
     */
    public int upAccountStatus(SelCpPageInPut selCpPageInPut) {
        return cpQualityManagementManager.upAccountStatus(selCpPageInPut);
    }

    /**
     * CP帐号管理查看详情
     *
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpExpatiation(int id) {
        return cpQualityManagementManager.findCpExpatiation(id);
    }

    /**
     * CP帐号的删除
     *
     * @param selCpPageInPut
     * @return int
     */
    public int delCp(SelCpPageInPut selCpPageInPut) {
        return cpQualityManagementManager.delCp(selCpPageInPut);
    }

    public PaginatedList<PadChannel> findChannelCp(PadChannel padChannel, int pageIndex, int pageSize) {
        PaginatedList<PadChannel> padChannelPaginatedList;
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CommonContants.CMS_PADCHANNEL_PAGER_CACHED);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        padChannelPaginatedList = cpQualityManagementManager.findChannelCp(padChannel, pageIndex, pageSize);
        if (0 == padChannelPaginatedList.size()) {
            if (1 < pageIndex) {
                pageIndex = pageIndex - 1;
                cacheUtils.set(CommonContants.CMS_PADCHANNEL_PAGER_CACHED, CommonContants.CMS_EXPIRE_TIME, pageIndex);
                padChannelPaginatedList = findChannelCp(padChannel, pageIndex, pageSize);
            }
        }
        cacheUtils.set(CommonContants.CMS_PADCHANNEL_PAGER_CACHED, CommonContants.CMS_EXPIRE_TIME, pageIndex);
        return padChannelPaginatedList;
    }

    public void createPadChannel(PadChannel padChannel) {
        cpQualityManagementManager.createPadChannel(padChannel);
    }

    public void deletePadChannel(int id) {
        cpQualityManagementManager.deletePadChannel(id);
    }

    public void updatePadChannel(PadChannel padChannel) {
        cpQualityManagementManager.updatePadChannel(padChannel);
    }

    public PadChannel getPadChannelById(int id) {
        return cpQualityManagementManager.getPadChannelById(id);
    }

    public Boolean relevanceCp(int id) {
        return cpQualityManagementManager.relevanceCp(id);
    }

    public void saveRelevanceCp(PadChannel padChannel) {
        cpQualityManagementManager.saveRelevanceCp(padChannel);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public CpQualityManagementManager getCpQualityManagementManager() {
        return cpQualityManagementManager;
    }

    public void setCpQualityManagementManager(CpQualityManagementManager cpQualityManagementManager) {
        this.cpQualityManagementManager = cpQualityManagementManager;
    }
}
