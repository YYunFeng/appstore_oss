package com.jd.cms.service.appManagement;

import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用service
 */
public interface AppManagementService {
    /**
     * 初始化
     *
     * @return Result
     */
    public Result init();


    /**
     * 重新同步所有/部分应用基本信息的结果
     *
     * @param appPageInput
     * @return Result
     */
    Result syncAllAppBaseInfo(AppPageInput appPageInput);

    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     *
     * @return Result
     */
    Result findDetailsPage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 查找单个详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    Result findAppDetails(AppPageInput appPageInput);

    /**
     * 审核不通过
     *
     * @param appPageInput
     * @return int
     */
    Result updateStatusOff(AppPageInput appPageInput);

    /**
     * 审核通过
     *
     * @param appPageInput
     * @return int
     */
    Result updateStatusOn(AppPageInput appPageInput);

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    Result findCategory(int parentId);

    /**
     * 取得tonken
     *
     * @param url
     * @return String
     */
    String getToken(String url);


}
