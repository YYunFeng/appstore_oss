package com.jd.cms.dao.cpQualityManagement;

import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午3:01
 * CP账号管理dao
 */
public interface CpQualityManagementDao {
    /**
     * 取得cp的总记录数
     *
     * @param selCpPageInPut
     * @return int
     */
    int getCpCount(SelCpPageInPut selCpPageInPut);

    /**
     * 取得cp信息集合
     *
     * @param selCpPageInPut
     * @return List
     */
    List<SelCpPageOutPut> findCpPage(SelCpPageInPut selCpPageInPut);

    /**
     * 更新cp的帐号状态
     *
     * @param selCpPageInPut
     * @return int
     */
    int upAccountStatus(SelCpPageInPut selCpPageInPut);

    /**
     * 根据ID取得单条cp信息
     *
     * @param id
     * @return SelCpPageOutPut
     */
    SelCpPageOutPut findCpExpatiation(int id);

    /**
     * 根据ID删除cp日志表信息
     *
     * @param accountid
     * @return int
     */
    int delLog(int accountid);

    /**
     * 根据ID删除cp注册信息表信息
     *
     * @param accountid
     * @return int
     */
    int delReginfo(int accountid);

    /**
     * 根据ID删除cp基本信息表信息
     *
     * @param accountid
     * @return int
     */
    int delBaseinfo(int accountid);

    /**
     * 取得cp的应用数
     *
     * @param accountid
     * @return Integer
     */
    Integer getAppCount(int accountid);

    /**
     * 取得渠道的信息
     *
     * @return
     */
    List<PadChannel> getChannelCp(PadChannel padChannel);

    /**
     * 取得渠道信息总条数
     *
     * @return
     */
    Integer getChannelCpCount();

    void createPadChannel(PadChannel padChannel);

    void deletePadChannel(int id);

    void updatePadChannel(PadChannel padChannel);

    PadChannel getPadChannelById(int id);

    Boolean  relevanceCp(int id);

    void createRelevanceCp(PadChannel padChannel);
    
    void updateRelevanceCp(PadChannel padChannel);
}
