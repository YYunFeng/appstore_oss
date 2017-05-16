package com.jd.cms.service.terminalManagement;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 屏幕管理service
 */
public interface ScreenService {
    /**
     * 取得屏幕参数集合
     * @param pageIndex,pageSize
     * @return Result
     */
    Result findScreenPage(int pageIndex, int pageSize);
    /**
     * 创建屏幕信息
     * @param terminalInsertInput
     * @return Result
     */
    Result createScreen(TerminalInsertInput terminalInsertInput);
    /**
     * 更新屏幕上下架状态
     * @param terminalpageInput
     * @return Result
     */
    Result upScreenOnline(TerminalpageInput terminalpageInput);
    /**
     * 删除屏幕信息
     * @param terminalpageInput
     * @return Result
     */
    Result delScreen(TerminalpageInput terminalpageInput);
    /**
     * 根据ID查询单条屏幕信息
     * @param id
     * @return Result
     */
    Result findScreenById(int id);
    /**
     * 更新屏幕信息
     * @param terminalpageInput
     * @return Result
     */
    Result upScreen(TerminalpageInput terminalpageInput);
    /**
     * 检查屏幕版本名
     * @param name
     * @return String
     */
    String checkScreenName(String name);
}
