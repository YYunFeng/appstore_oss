package com.jd.cms.dao.terminalManagement;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.domain.terminalManagement.TerminalpageOutput;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 屏幕管理dao
 */
public interface ScreenDao {
    /**
     * 取得屏幕参数总记录数
     * @return int
     */
    int getScreenCount();
    /**
     * 取得屏幕参数集合
     * @param query
     * @return List
     */
    List<TerminalpageOutput> findScreenPage(Query query);
    /**
     * 创建屏幕信息
     * @param terminalInsertInput
     */
    void createScreen(TerminalInsertInput terminalInsertInput);
    /**
     * 更新屏幕上下架状态
     * @param terminalpageInput
     * @return int
     */
    int upScreenOnline(TerminalpageInput terminalpageInput);
    /**
     * 删除屏幕信息
     * @param terminalpageInput
     * @return int
     */
    int delScreen(TerminalpageInput terminalpageInput);
    /**
     * 根据ID查询单条屏幕信息
     * @param id
     * @return TerminalpageOutput
     */
    TerminalpageOutput findScreenById(int id);
    /**
     * 更新屏幕信息
     * @param terminalpageInput
     * @return int
     */
    int upScreen(TerminalpageInput terminalpageInput);
    /**
     * 检查屏幕版本名
     * @param name
     * @return String
     */
    String checkScreenName(String name);
}
