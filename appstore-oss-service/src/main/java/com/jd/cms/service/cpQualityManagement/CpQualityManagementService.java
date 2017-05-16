package com.jd.cms.service.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * CP账号管理service
 */
public interface CpQualityManagementService {
    /**
     * CP账号管理分页查询
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return Result
     */
    Result findCpPage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize);

    /**
     * CP帐号的启用停用
     *
     * @param selCpPageInPut
     * @return Result
     */
    Result upAccountStatus(SelCpPageInPut selCpPageInPut);

    /**
     * CP帐号管理查看详情
     *
     * @param id
     * @return Result
     */
    Result findCpExpatiation(int id);

    /**
     * CP帐号的删除
     *
     * @param selCpPageInPut
     * @return int
     */
    int delCp(SelCpPageInPut selCpPageInPut);

    Result getChannelCp(PadChannel padChannel, int pageIndex, int pageSize);

    void createPadChannel(PadChannel padChannel);

    void deletePadChannel(int id);

    void updatePadChannel(PadChannel padChannel);

    Result getPadChannelById(int id);

    Result relevanceCp(int id);

    Result saveRelevanceCp(PadChannel padChannel);
}
