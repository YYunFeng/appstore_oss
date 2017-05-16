package com.jd.cms.manager.usermanager.impl;

import com.jd.appstore.domain.Saler;
import com.jd.cms.dao.usermanager.SalerDetailsDao;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.usermanager.SalerDetails;
import com.jd.cms.domain.usermanager.SalerDetailsParameter;
import com.jd.cms.manager.usermanager.SalerDetailsManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-19
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class SalerDetailsManagerImpl extends BaseManager implements SalerDetailsManager {
    private SalerDetailsDao salerDetailsDao;

    public PaginatedList<SalerDetails> getSalerDetails(SalerDetailsParameter salerDetailsParameter, int pageIndex, int pageSize) {
        PaginatedList<SalerDetails> paginatedList = new PaginatedArrayList<SalerDetails>(pageIndex, pageSize);
        try {
            if (0 == pageIndex) {
                pageIndex = 1;
            }
            int totalItem = salerDetailsDao.getSalerDetailsCount(salerDetailsParameter);
            if (totalItem > 0) {
                paginatedList.setTotalItem(totalItem);
                salerDetailsParameter.setStartRow((pageIndex - 1) * pageSize);
                salerDetailsParameter.setEndRow(pageSize);
                List<SalerDetails> salerDetailses = salerDetailsDao.getSalerDetails(salerDetailsParameter);
                paginatedList.addAll(salerDetailses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginatedList;
    }


    public void deleteSalerDetails(String salerNo) {
        try {
            salerDetailsDao.deleteSalerDetails(salerNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Saler getSalerDetailsById(String salerNo) {
        return salerDetailsDao.getSalerDetailsById(salerNo);
    }

    public void updateSalerDetails(Saler saler) {
        try {
            salerDetailsDao.updateSalerDetails(saler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PadChannel> channelList() {
        return salerDetailsDao.channelList();
    }

    public List<Saler> salerList(SalerDetailsParameter salerDetailsParameter) {
        return salerDetailsDao.salerList(salerDetailsParameter);
    }

    public void setSalerDetailsDao(SalerDetailsDao salerDetailsDao) {
        this.salerDetailsDao = salerDetailsDao;
    }
}
