package com.jd.cms.dao.cpQualityManagement.impl;

import com.jd.cms.dao.cpQualityManagement.CpChargeQualificationDao;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核daoImpl
 */
public class CpChargeQualificationDaoImpl extends BaseDao implements CpChargeQualificationDao {
    /**
     * 取得cp的总记录数
     * @param selCpPageInPut
     * @return int
     */
    public int getCpCount(SelCpPageInPut selCpPageInPut) {
        return (Integer)queryForObject("CpChargeQualification.getCpCount",selCpPageInPut);
    }
    /**
     * 取得cp收费资质信息集合
     * @param selCpPageInPut
     * @return List
     */
    public List<SelCpPageOutPut> findCpChargePage(SelCpPageInPut selCpPageInPut) {
        return queryForList("CpChargeQualification.findCpChargePage",selCpPageInPut);
    }
    /**
     * 收费资质不通过
     * @param selCpPageInPut
     * @return int
     */
    public int upFeeStatus(SelCpPageInPut selCpPageInPut) {
        return update("CpChargeQualification.upFeeStatus",selCpPageInPut);
    }
    /**
     * 根据Id查询单条CP审核信息
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpChargeById(int id) {
        return (SelCpPageOutPut)queryForObject("CpChargeQualification.findCpChargeById",id);
    }
    /**
     * CP收费审核通过更新
     * @param selCpPageInPut
     * @return int
     */
    public int upCpCharge(SelCpPageInPut selCpPageInPut) {
        return update("CpChargeQualification.upCpCharge",selCpPageInPut);
    }
}
