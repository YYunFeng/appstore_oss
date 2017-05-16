package com.jd.cms.manager.appManagement;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.Category;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.SalerRankingRes;
import com.jd.common.util.PaginatedList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用manager
 */
public interface AppManagementManager {


    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput,pageIndex,pageSize
     *
     * @return PaginatedList
     */
    PaginatedList<AppPageOutput> findDetailsPage(AppPageInput appPageInput, int pageIndex, int pageSize);

    /**
     * 取得详情对应应用的基本信息审核状态(详情Id)
     *
     * @param did
     * @return int
     */
    int findAppStatus(int did);

    /**
     * 查找单个详情
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findAppDetails(AppPageInput appPageInput);

    /**
     * 审核不通过
     *
     * @param appPageInput
     * @return int
     */
    int updateStatusOff(AppPageInput appPageInput);

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    List<Category> findCategory(int parentId);

    /**
     * 审核通过
     *
     * @param appPageInput
     * @return int
     */
    int updateStatusOn(AppPageInput appPageInput);

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findPicture(AppPageInput appPageInput);

    /**
     * 查找cp默认分成比例
     *
     * @param appPageInput
     * @return AppPageOutput
     */
    AppPageOutput findDefaultPercent(AppPageInput appPageInput);

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    AndroidAppOsversion findOsVersion(int osVersionId);

    /**
     * 获取所有/部分应用基本信息以及主图
     *
     * @param appPageInput
     * @return List
     */
    List<Apps> getAppBaseInfo(AppPageInput appPageInput);


}
