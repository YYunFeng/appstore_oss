package com.jd.cms.manager.cpQualityManagement;



import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核manager
 */
public interface CpChargeQualificationManager {
    /**
     * 取得cp收费资质信息集合
     * @param selCpPageInPut,pageIndex,pageSize
     * @return PaginatedList
     */
    PaginatedList<SelCpPageOutPut> findCpChargePage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize);
    /**
     * 收费资质审核状态更新
     * @param selCpPageInPut
     * @return int
     */
    int upFeeStatus(SelCpPageInPut selCpPageInPut);
    /**
     * CP资质管理审核查询
     * @param id
     * @return SelCpPageOutPut
     */
    SelCpPageOutPut findCpChargeById(int id);
    /**
     * CP审核通过操作
     * @param selCpPageInPut
     * @return int
     */
    int upCpCharge(SelCpPageInPut selCpPageInPut);
}
