package com.jd.cms.manager.cpQualityManagement.impl;

import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.cpQualityManagement.CpChargeQualificationManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核ManagerCachedImpl
 */
public class CpChargeQualificationManagerCachedImpl implements CpChargeQualificationManager {
    /**
     * 加载CacheUtils
     */
    private CacheUtils cacheUtils;
    /**
     * Manager注入
     */
    private CpChargeQualificationManager cpChargeQualificationManager;

    /**
     * 取得cp收费资质信息集合
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    public PaginatedList<SelCpPageOutPut> findCpChargePage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize) {
        PaginatedList<SelCpPageOutPut> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_CPCHARGE_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询cp收费资质信息集合
        paginatedList = cpChargeQualificationManager.findCpChargePage(selCpPageInPut, pageIndex, pageSize);
        //列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CPCHARGE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findCpChargePage(selCpPageInPut, pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_CPCHARGE_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回cp收费资质信息集合
        return paginatedList;
    }

    /**
     * 收费资质审核状态更新
     *
     * @param selCpPageInPut
     * @return int
     */
    public int upFeeStatus(SelCpPageInPut selCpPageInPut) {
        return cpChargeQualificationManager.upFeeStatus(selCpPageInPut);
    }

    /**
     * CP资质管理审核查询
     *
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpChargeById(int id) {
        return cpChargeQualificationManager.findCpChargeById(id);
    }

    /**
     * CP审核通过操作
     *
     * @param selCpPageInPut
     * @return int
     */
    public int upCpCharge(SelCpPageInPut selCpPageInPut) {
        return cpChargeQualificationManager.upCpCharge(selCpPageInPut);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public CpChargeQualificationManager getCpChargeQualificationManager() {
        return cpChargeQualificationManager;
    }

    public void setCpChargeQualificationManager(CpChargeQualificationManager cpChargeQualificationManager) {
        this.cpChargeQualificationManager = cpChargeQualificationManager;
    }
}
