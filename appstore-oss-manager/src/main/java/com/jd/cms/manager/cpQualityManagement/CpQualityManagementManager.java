package com.jd.cms.manager.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午3:01
 * CP账号管理manager
 */
public interface CpQualityManagementManager {
    /**
     * CP账号管理分页查询
     *
     * @param selCpPageInPut,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    PaginatedList<SelCpPageOutPut> findCpPage(SelCpPageInPut selCpPageInPut, int pageIndex, int pageSize);

    /**
     * CP帐号的启用停用
     *
     * @param selCpPageInPut
     * @return int
     */
    int upAccountStatus(SelCpPageInPut selCpPageInPut);

    /**
     * CP帐号管理查看详情
     *
     * @param id
     * @return SelCpPageOutPut
     */
    SelCpPageOutPut findCpExpatiation(int id);

    /**
     * CP帐号的删除
     *
     * @param selCpPageInPut
     * @return int
     */
    int delCp(SelCpPageInPut selCpPageInPut);

    PaginatedList<PadChannel> findChannelCp(PadChannel padChannel, int pageIndex, int pageSize);

    void createPadChannel(PadChannel padChannel);

    void deletePadChannel(int id);

    void updatePadChannel(PadChannel padChannel);

    PadChannel getPadChannelById(int id);

    Boolean relevanceCp(int id);

    void saveRelevanceCp(PadChannel padChannel);
} 
