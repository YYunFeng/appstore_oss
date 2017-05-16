package com.jd.cms.manager.appManagement.impl;

import com.jd.cms.dao.appManagement.NewStatisticDao;
import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.domain.appManagement.NewStatisticObj;
import com.jd.cms.manager.appManagement.NewStatisticManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * YYF on 2015/4/17.
 */
public class NewStatisticManagerImpl extends BaseManager implements NewStatisticManager {
    private NewStatisticDao newStatisticDao;

    public NewStatisticObj appInstallTotal(MarketStatInput marketStatInput) {
        NewStatisticObj newStatisticObj = newStatisticDao.appInstallTotal(marketStatInput);
        return newStatisticObj;
    }

    public PaginatedList<NewStatisticObj> totalByApp(MarketStatInput marketStatInput, int pageIndex, int pageSize) {
        PaginatedList<NewStatisticObj> totalByApp = new PaginatedArrayList<NewStatisticObj>(pageIndex, pageSize);
        // 分页
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        Integer totalItem = newStatisticDao.totalByAppCounts(marketStatInput);
        totalByApp.setTotalItem(totalItem.intValue());
        marketStatInput.setOffset((pageIndex - 1) * pageSize);
        marketStatInput.setLimit(pageSize);
        List<NewStatisticObj> statInputList = newStatisticDao.totalByApp(marketStatInput);
        totalByApp.addAll(statInputList);
        return totalByApp;
    }

    public List<NewStatisticObj> totalByChannel(MarketStatInput marketStatInput) {
        return newStatisticDao.totalByChannel(marketStatInput);
    }

    public List<NewStatisticObj> channelBySaler(MarketStatInput marketStatInput) {
        return newStatisticDao.channelBySaler(marketStatInput);
    }

    public List<NewStatisticObj> channelBySalerDetails(MarketStatInput marketStatInput) {
        return newStatisticDao.channelBySalerDetails(marketStatInput);
    }

    public List<NewStatisticObj> appBySalerNo(MarketStatInput marketStatInput) {
        return newStatisticDao.appBySalerNo(marketStatInput);
    }

    public List<NewStatisticObj> channelType(MarketStatInput marketStatInput) {
        return newStatisticDao.channelType(marketStatInput);
    }


    public void setNewStatisticDao(NewStatisticDao newStatisticDao) {
        this.newStatisticDao = newStatisticDao;
    }
}
