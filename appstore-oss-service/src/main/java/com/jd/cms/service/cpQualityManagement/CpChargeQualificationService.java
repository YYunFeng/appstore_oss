package com.jd.cms.service.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 上午10:07
 * CP资质审核service
 */
public interface CpChargeQualificationService {
    /**
     * 取得cp收费资质信息集合
     * @param selCpPageInPut,pageIndex,pageSize
     * @return Result
     */
    Result findCpChargePage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize);
    /**
     * 收费资质审核状态更新
     * @param selCpPageInPut
     * @return Result
     */
    Result upFeeStatus(SelCpPageInPut selCpPageInPut);
    /**
     * CP资质管理审核查询
     * @param id
     * @return Result
     */
    Result findCpChargeById(int id);
    /**
     * CP审核通过操作
     * @param selCpPageInPut
     * @return Result
     */
    Result upCpCharge(SelCpPageInPut selCpPageInPut);
}
