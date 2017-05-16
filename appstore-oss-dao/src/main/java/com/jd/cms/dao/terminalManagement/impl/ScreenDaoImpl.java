package com.jd.cms.dao.terminalManagement.impl;

import com.jd.cms.dao.terminalManagement.ScreenDao;
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
 * 屏幕管理daoImpl
 */
public class ScreenDaoImpl extends BaseDao implements ScreenDao {
    /**
     * 取得屏幕参数总记录数
     * @return int
     */
    public int getScreenCount() {
        return (Integer)queryForObject("Screen.getScreenCount");
    }
    /**
     * 取得屏幕参数集合
     * @param query
     * @return List
     */
    public List<TerminalpageOutput> findScreenPage(Query query) {
        return queryForList("Screen.findScreenPage",query);
    }
    /**
     * 创建屏幕信息
     * @param terminalInsertInput
     */
    public void createScreen(TerminalInsertInput terminalInsertInput) {
        insert("Screen.createScreen",terminalInsertInput);
    }
    /**
     * 更新屏幕上下架状态
     * @param terminalpageInput
     * @return int
     */
    public int upScreenOnline(TerminalpageInput terminalpageInput) {
        return update("Screen.upScreenOnline",terminalpageInput);
    }
    /**
     * 删除屏幕信息
     * @param terminalpageInput
     * @return int
     */
    public int delScreen(TerminalpageInput terminalpageInput) {
        return delete("Screen.delScreen",terminalpageInput);
    }
    /**
     * 根据ID查询单条屏幕信息
     * @param id
     * @return TerminalpageOutput
     */
    public TerminalpageOutput findScreenById(int id) {
        return (TerminalpageOutput)queryForObject("Screen.findScreenById",id);
    }
    /**
     * 更新屏幕信息
     * @param terminalpageInput
     * @return int
     */
    public int upScreen(TerminalpageInput terminalpageInput) {
        return update("Screen.upScreen",terminalpageInput);
    }
    /**
     * 检查屏幕版本名
     * @param name
     * @return String
     */
    public String checkScreenName(String name) {
        return (String)queryForObject("Screen.checkScreenName",name);
    }
}
