package com.jd.cms.manager.appManagement.impl;

import com.jd.cms.dao.appManagement.SalerActiveDao;
import com.jd.cms.domain.appManagement.ArrCountObj;
import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.cms.domain.clientmanager.SalerActiveParameter;
import com.jd.cms.manager.appManagement.SalerActiveManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by YYF on 14-5-9.
 */
public class SalerActiveManagerImpl extends BaseManager implements SalerActiveManager {
    private SalerActiveDao salerActiveDao;

    public PaginatedList<SalerActive> salerActive(int pageIndex, int pageSize, String startTime, String endTime, Integer excelFlag, Integer cid) {
        PaginatedList<SalerActive> paginatedList = new PaginatedArrayList<SalerActive>(pageIndex, pageSize);
        try {
            if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
                if (pageIndex == 0) {
                    pageIndex = 1;
                }
                SalerActiveParameter salerActiveParameter = new SalerActiveParameter();
                salerActiveParameter.setStartTime(startTime);
                salerActiveParameter.setEndTime(endTime);
                if (cid != null && cid.intValue() != 138) {
                    salerActiveParameter.setCid(cid);
                }
                int totalCounts = salerActiveDao.salerCounts(salerActiveParameter);
                if (totalCounts > 0) {
                    paginatedList.setTotalItem(totalCounts);
                    salerActiveParameter.setOffset((pageIndex - 1) * pageSize);
                    salerActiveParameter.setLimit(pageSize);
                    // excelFlag ：0 代表导出EXCEL文件，不分页
                    salerActiveParameter.setStatsFlag(excelFlag);
                    List<SalerActive> list = salerActiveDao.salerActive(salerActiveParameter);
                    if (list != null && list.size() > 0) {
                        int days = daysBetween(startTime, endTime);
                        NumberFormat nt = NumberFormat.getPercentInstance();
                        nt.setMinimumFractionDigits(2);
                        for (SalerActive salerActive : list) {
                            double activeDayPercentage = (double) salerActive.getActiveDays() / (days + 1);
                            salerActive.setActiveDayPercentage(nt.format(activeDayPercentage));
                        }
                        paginatedList.addAll(list);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paginatedList;
    }


    public void setSalerActiveDao(SalerActiveDao salerActiveDao) {
        this.salerActiveDao = salerActiveDao;
    }

    /**
     * 计算两个日期之间相差的天数
     * 字符串的日期格式的计算
     */
    public int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

}
