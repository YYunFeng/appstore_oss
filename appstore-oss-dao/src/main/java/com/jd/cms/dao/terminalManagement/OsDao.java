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
 * 平台管理dao
 */
public interface OsDao {
    /**
     * 取得平台信息总记录数
     * @return int
     */
    int getOsCount();
    /**
     * 取得平台信息集合
     * @param query
     * @return List
     */
    List<TerminalpageOutput> findOsPage(Query query);
    /**
     * 创建平台信息
     * @param terminalInsertInput
     */
    void createOs(TerminalInsertInput terminalInsertInput);
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return int
     */
    int upOsOnline(TerminalpageInput terminalpageInput);
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return int
     */
    int delOs(TerminalpageInput terminalpageInput);
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return TerminalpageOutput
     */
    TerminalpageOutput findOsById(int id);
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return int
     */
    int upOs(TerminalpageInput terminalpageInput);
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    String checkOsName(String name);
    /**
     * 检查平台版本码
     * @param code
     * @return Integer
     */
    Integer checkOsCode(int code);

}
