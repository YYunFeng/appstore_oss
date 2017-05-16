package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.PadImeiNumber;
import com.jd.cms.dao.systemmaintenance.PadImeiNumberDao;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.systemmaintenance.PadImeiNumberManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-7
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public class PadImeiNumberManagerImpl extends BaseManager implements PadImeiNumberManager {
    private PadImeiNumberDao padImeiNumberDao;

    public void createPadImeiNumber(PadImeiNumber padImeiNumber) {
        try {
            int id = (int) sequenceUtil.get(SequenceConstants.PADIMEINUMBER);
            padImeiNumber.setId(id);
            padImeiNumberDao.createPadImeiNumber(padImeiNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PadImeiNumber getPadImei(String imeiNmuber) {
        return padImeiNumberDao.getPadImei(imeiNmuber);
    }

    public void deletePadImei(Integer id) {
        padImeiNumberDao.deletePadImei(id);
    }

    public PaginatedList<PadImeiNumber> getPadImeiList(int pageIndex, int pageSize) {
        PaginatedList<PadImeiNumber> padImeiNumberList = new PaginatedArrayList<PadImeiNumber>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            int totalItem = padImeiNumberDao.padImeiCount();
            if (totalItem != 0) {
                padImeiNumberList.setTotalItem(totalItem);
                baseQuery.setStartRow((pageIndex - 1) * pageSize);
                baseQuery.setEndRow(pageSize);
                List<PadImeiNumber> padImeiNumbers = padImeiNumberDao.getPadImeiList(baseQuery);
                for (PadImeiNumber padImeiNumber : padImeiNumbers) {
                    if (padImeiNumber.getUpdateTime() != null) {
                        Calendar c = Calendar.getInstance();
                        Date now = new Date();
                        c.setTime(now);
                        int day = c.get(Calendar.DATE);
                        Calendar.getInstance();
                        c.set(Calendar.DATE, day - 3);
                        Date ago3Day = c.getTime();
                        if (padImeiNumber.getUpdateTime().before(ago3Day)) { // 上一次更新時間大于七天，表示一周未更新
                            padImeiNumber.setUpdateStatus(false);
                        } else {
                            padImeiNumber.setUpdateStatus(true);
                        }
                    } else {
                        padImeiNumber.setUpdateStatus(false);
                    }
                }
                padImeiNumberList.addAll(padImeiNumbers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return padImeiNumberList;
    }

    public void updatePadImei(PadImeiNumber padImeiNumber) {
        padImeiNumberDao.updatePadImei(padImeiNumber);
    }

    public Integer padNoUpdateCount() {
        return padImeiNumberDao.padNoUpdateCount();
    }

    public void setPadImeiNumberDao(PadImeiNumberDao padImeiNumberDao) {
        this.padImeiNumberDao = padImeiNumberDao;
    }
}
