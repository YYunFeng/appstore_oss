package com.jd.cms.dao.cpQualityManagement.impl;

import com.jd.cms.dao.cpQualityManagement.CpQualityManagementDao;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.cpQualityManagement.SelCpPageInPut;
import com.jd.cms.domain.cpQualityManagement.SelCpPageOutPut;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-10
 * Time: 下午3:01
 * CP账号管理daoImpl
 */
public class CpQualityManagementDaoImpl extends BaseDao implements CpQualityManagementDao {
    /**
     * 取得cp的总记录数
     *
     * @param selCpPageInPut
     * @return int
     */
    public int getCpCount(SelCpPageInPut selCpPageInPut) {
        return (Integer) queryForObject("CpQualityManagement.getCpCount", selCpPageInPut);
    }

    /**
     * 取得cp信息集合
     *
     * @param selCpPageInPut
     * @return List
     */
    public List<SelCpPageOutPut> findCpPage(SelCpPageInPut selCpPageInPut) {
        return queryForList("CpQualityManagement.findCpPage", selCpPageInPut);
    }

    /**
     * 更新cp的帐号状态
     *
     * @param selCpPageInPut
     * @return int
     */
    public int upAccountStatus(SelCpPageInPut selCpPageInPut) {
        return update("CpQualityManagement.upAccountStatus", selCpPageInPut);
    }

    /**
     * 根据ID取得单条cp信息
     *
     * @param id
     * @return SelCpPageOutPut
     */
    public SelCpPageOutPut findCpExpatiation(int id) {
        return (SelCpPageOutPut) queryForObject("CpQualityManagement.selCpExpatiation", id);
    }

    /**
     * 根据ID删除cp日志表信息
     *
     * @param accountid
     * @return int
     */
    public int delLog(int accountid) {
        return delete("CpQualityManagement.delLog", accountid);
    }

    /**
     * 根据ID删除cp注册信息表信息
     *
     * @param accountid
     * @return int
     */
    public int delReginfo(int accountid) {
        return delete("CpQualityManagement.delReginfo", accountid);
    }

    /**
     * 根据ID删除cp基本信息表信息
     *
     * @param accountid
     * @return int
     */
    public int delBaseinfo(int accountid) {
        return delete("CpQualityManagement.delBaseinfo", accountid);
    }

    /**
     * 取得cp的应用数
     *
     * @param accountid
     * @return Integer
     */
    public Integer getAppCount(int accountid) {
        return (Integer) queryForObject("CpQualityManagement.getAppCount", accountid);
    }

    public List<PadChannel> getChannelCp(PadChannel padChannel) {
        return queryForList("CpQualityManagement.getChannelCp", padChannel);
    }

    public Integer getChannelCpCount() {
        return (Integer) queryForObject("CpQualityManagement.getChannelCpCount");
    }

    public void createPadChannel(PadChannel padChannel) {
        insert("CpQualityManagement.createPadChannel", padChannel);
    }


    public void deletePadChannel(int id) {
        // 删除渠道
        delete("CpQualityManagement.deletePadChannel", id);
        // 删除渠道关联表信息
        delete("CpQualityManagement.deleteChannelCp", id);
    }

    public void updatePadChannel(PadChannel padChannel) {
        update("CpQualityManagement.updatePadChannel", padChannel);
    }

    public PadChannel getPadChannelById(int id) {
        return (PadChannel) queryForObject("CpQualityManagement.getPadChannelById", id);
    }

    public Boolean relevanceCp(int id) {
        return (Integer) queryForObject("CpQualityManagement.relevanceCp", id) > 0;
    }

    public void createRelevanceCp(PadChannel padChannel) {
        insert("CpQualityManagement.createRelevanceCp",padChannel);
    }

    public void updateRelevanceCp(PadChannel padChannel) {
        update("CpQualityManagement.updateRelevanceCp",padChannel);
    }


}
