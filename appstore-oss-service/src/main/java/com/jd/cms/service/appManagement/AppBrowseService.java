package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.ChangeCpInput;
import com.jd.cms.domain.appManagement.StatusJSON;
import com.jd.common.web.result.Result;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 应用浏览service
 */
public interface AppBrowseService {
    /**
     * 取得移动游戏,软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return Result
     */
    Result findAppBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 取得网页软件的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     * @return Result
     */
    Result findAppWebBrowsePage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 批量上下架操作
     *
     * @param appPageInput
     * @return int
     */
    int upAppOnline(AppPageInput appPageInput);

    /**
     * 单个上下架操作
     *
     * @param appPageInput
     * @return int
     */
    int upAppOnlineById(AppPageInput appPageInput);

    /**
     * 浏览-默认详情浏览
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    Result findAppDetailsFormal(AppPageInput appPageInput);

    /**
     * 浏览-通过CpName查找详情
     *
     * @param appPageInput
     * @return Result
     */
    Result findAppDetailsFormalByCp(AppPageInput appPageInput);

    /**
     * 编辑-默认详情浏览
     *
     * @param appPageInput
     * @return Result
     */
    Result findAppDetailsFormalEdit(AppPageInput appPageInput);

    /**
     * 编辑-通过CpName查找详情
     *
     * @param appPageInput
     * @return Result
     */
    Result findAppDetailsFormalEditByCp(AppPageInput appPageInput);

    /**
     * 详情上下架修改
     *
     * @param appPageInput
     * @return Result
     */
    Result upAppDetailsOnline(AppPageInput appPageInput);

    /**
     * 更改默认详情
     *
     * @param appPageInput
     * @return int
     */
    int upAppDefaultDetaild(AppPageInput appPageInput);

    /**
     * 保存应用和详情
     *
     * @param appPageInput
     * @return int
     */
    int saveAppAndDetailInformation(AppPageInput appPageInput);

    /**
     * 取得tonken
     *
     * @param url
     * @return String
     */
    String getToken(String url);

    StatusJSON chageCp(ChangeCpInput changeCpInput);
}
