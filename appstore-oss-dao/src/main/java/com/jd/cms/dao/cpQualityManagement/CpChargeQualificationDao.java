package com.jd.cms.dao.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核dao
 */
public interface CpChargeQualificationDao {
    /**
     * 取得cp的总记录数
     * @param selCpPageInPut
     * @return int
     */
    int getCpCount(SelCpPageInPut selCpPageInPut);
    /**
     * 取得cp收费资质信息集合
     * @param selCpPageInPut
     * @return List
     */
    List<SelCpPageOutPut> findCpChargePage(SelCpPageInPut selCpPageInPut);
    /**
     * 收费资质不通过
     * @param selCpPageInPut
     * @return int
     */
    int upFeeStatus(SelCpPageInPut selCpPageInPut);
    /**
     * 根据Id查询单条CP审核信息
     * @param id
     * @return SelCpPageOutPut
     */
    SelCpPageOutPut findCpChargeById(int id);
    /**
     * CP收费审核通过更新
     * @param selCpPageInPut
     * @return int
     */
    int upCpCharge(SelCpPageInPut selCpPageInPut);
}
