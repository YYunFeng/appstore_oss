package com.jd.cms.service.terminalManagement;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理service
 */
public interface OsService {
    /**
     * 取得平台信息集合
     * @param pageIndex,pageSize
     * @return Result
     */
    Result findOsPage(int pageIndex, int pageSize);
    /**
     * 创建平台信息
     * @param terminalInsertInput
     * @return Result
     */
    Result createOs(TerminalInsertInput terminalInsertInput);
    /**
     * 更新平台上下架状态
     * @param terminalpageInput
     * @return Result
     */
    Result upOsOnline(TerminalpageInput terminalpageInput);
    /**
     * 删除平台信息
     * @param terminalpageInput
     * @return Result
     */
    Result delOs(TerminalpageInput terminalpageInput);
    /**
     * 根据ID查询单条平台信息
     * @param id
     * @return Result
     */
    Result findOsById(int id);
    /**
     * 更新平台信息
     * @param terminalpageInput
     * @return Result
     */
    Result upOs(TerminalpageInput terminalpageInput);
    /**
     * 检查平台版本名
     * @param name
     * @return String
     */
    String checkOsName(String name);
    /**
     * 检查平台版本码
     * @param code
     * @return String
     */
    String checkOsCode(int code);
}
