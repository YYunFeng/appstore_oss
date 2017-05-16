package com.jd.cms.manager.appManagement.impl;

import com.jd.cms.dao.appManagement.ProvinceArrStatisDao;
import com.jd.cms.domain.appManagement.ProvinceArrStatisObj;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;
import com.jd.cms.manager.appManagement.ProvinceArrStatisManager;
import com.jd.common.manager.BaseManager;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by YYF on 2014/7/1.
 */
public class ProvinceArrStatisManagerImpl extends BaseManager implements ProvinceArrStatisManager {
    private ProvinceArrStatisDao provinceArrStatisDao;

    public ProvinceArrStatisObj provinceArrStatis(ProvinceArrStatisParameter provinceArrStatisParameter) {
        ProvinceArrStatisObj provinceArrStatisObj = new ProvinceArrStatisObj();
        try {
            provinceArrStatisObj = provinceArrStatisDao.provinceArrStatis(provinceArrStatisParameter);
            NumberFormat nt = NumberFormat.getPercentInstance();
            nt.setMinimumFractionDigits(2);
            if (provinceArrStatisObj.getRecCounts() != null && provinceArrStatisObj.getNeedCounts() != null) {
                provinceArrStatisObj.setInstallCounts(provinceArrStatisObj.getRecCounts() + provinceArrStatisObj.getNeedCounts());
            }
            if (provinceArrStatisObj.getInstallCounts() != null) {
                if (provinceArrStatisObj.getArrCounts() != null) {
                    double arrPer = (double) provinceArrStatisObj.getArrCounts() / provinceArrStatisObj.getInstallCounts();
                    provinceArrStatisObj.setArrPercentage(nt.format(arrPer));
                } else {
                    provinceArrStatisObj.setArrCounts(0);
                    provinceArrStatisObj.setArrPercentage("0.0%");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceArrStatisObj;
    }

    public List<ProvinceArrStatisObj> provinceArrStatisByCid(ProvinceArrStatisParameter provinceArrStatisParameter) {
        List<ProvinceArrStatisObj> list = provinceArrStatisDao.provinceArrStatisByCid(provinceArrStatisParameter);
        try {
            if (list != null && list.size() > 0) {
                NumberFormat nt = NumberFormat.getPercentInstance();
                nt.setMinimumFractionDigits(2);
                for (ProvinceArrStatisObj provinceArrStatisObj : list) {
                    if (provinceArrStatisObj.getRecCounts() != null && provinceArrStatisObj.getNeedCounts() != null) {
                        provinceArrStatisObj.setInstallCounts(provinceArrStatisObj.getRecCounts() + provinceArrStatisObj.getNeedCounts());
                    }
                    if (provinceArrStatisObj.getInstallCounts() != null) {
                        if (provinceArrStatisObj.getArrCounts() != null) {
                            double arrPer = (double) provinceArrStatisObj.getArrCounts() / provinceArrStatisObj.getInstallCounts();
                            provinceArrStatisObj.setArrPercentage(nt.format(arrPer));
                        } else {
                            provinceArrStatisObj.setArrCounts(0);
                            provinceArrStatisObj.setArrPercentage("0.0%");
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProvinceArrStatisObj> provinceArrStatisBySaler(ProvinceArrStatisParameter provinceArrStatisParameter) {
        List<ProvinceArrStatisObj> list = provinceArrStatisDao.provinceArrStatisBySaler(provinceArrStatisParameter);
        try {
            if (list != null && list.size() > 0) {
                NumberFormat nt = NumberFormat.getPercentInstance();
                nt.setMinimumFractionDigits(2);
                for (ProvinceArrStatisObj provinceArrStatisObj : list) {
                    if (provinceArrStatisObj.getRecCounts() != null && provinceArrStatisObj.getNeedCounts() != null) {
                        provinceArrStatisObj.setInstallCounts(provinceArrStatisObj.getRecCounts() + provinceArrStatisObj.getNeedCounts());
                    }
                    if (provinceArrStatisObj.getInstallCounts() != null) {
                        if (provinceArrStatisObj.getArrCounts() != null) {
                            double arrPer = (double) provinceArrStatisObj.getArrCounts() / provinceArrStatisObj.getInstallCounts();
                            provinceArrStatisObj.setArrPercentage(nt.format(arrPer));
                        } else {
                            provinceArrStatisObj.setArrCounts(0);
                            provinceArrStatisObj.setArrPercentage("0.0%");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public void setProvinceArrStatisDao(ProvinceArrStatisDao provinceArrStatisDao) {
        this.provinceArrStatisDao = provinceArrStatisDao;
    }
}
