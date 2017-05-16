package com.jd.cms.dao.terminalManagement.impl;

import com.jd.cms.dao.terminalManagement.OsDao;
import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理daoImpl
 */
public class OsDaoImpl extends BaseDao implements OsDao {
    /**
     * 取得平台信息总记录数
     * @return int
     */
    public int getOsCount() {
        return (Integer)queryForObject("Os.getOsCount");
    }
    /**
     * 取得平台信息集合
     * @param query
     * @return List
     */
    public List<TerminalpageOutput> findOsPage(Query query) {
        return queryForList("Os.findOsPage",query);
    }
    /**
     * 创建平台信息
     * @param terminalInsertInput
     */
    public void createOs(TerminalInsertInput terminalInsertInput) {
        insert("Os.createOs",terminalInsertInput);
    }
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return int
     */
    public int upOsOnline(TerminalpageInput terminalpageInput) {
        return update("Os.upOsOnline",terminalpageInput);
    }
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return int
     */
    public int delOs(TerminalpageInput terminalpageInput) {
        return delete("Os.delOs",terminalpageInput);
    }
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findOsById(int id) {
        return (TerminalpageOutput)queryForObject("Os.findOsById",id);
    }
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return int
     */
    public int upOs(TerminalpageInput terminalpageInput) {
        return update("Os.upOs",terminalpageInput);
    }
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    public String checkOsName(String name) {
        return (String)queryForObject("Os.checkOsName",name);
    }
    /**
     * 检查平台版本码
     * @param code
     * @return Integer
     */
    public Integer checkOsCode(int code) {
        return (Integer)queryForObject("Os.checkOsCode",code);
    }
}
