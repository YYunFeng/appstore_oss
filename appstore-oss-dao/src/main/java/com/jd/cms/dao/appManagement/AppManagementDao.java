package com.jd.cms.dao.appManagement;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.SalerRankingRes;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用dao
 */
public interface AppManagementDao {
    /**
     * 取得审核应用的总记录数
     *
     * @param appPageInput
     * @return int
     */
    int getDetailsCount(AppPageInput appPageInput);

    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findDetailsPage(AppPageInput appPageInput);

    /**
     * 取得详情对应应用的基本信息审核状态(详情Id)
     *
     * @param did
     * @return int
     */
    int findAppStatus(int did);

    /**
     * 取得详情对应应用的基本信息审核状态(应用Id)
     *
     * @param appid
     * @return int
     */
    int findAppNature(int appid);

    /**
     * 查找单个详情
     *
     * @param did
     * @return AppPageOutput
     */
    AppPageOutput findAppDetails(int did);

    /**
     * 应用审核不通过
     *
     * @param appPageInput
     * @return int
     */
    int updateAppStatusOff(AppPageInput appPageInput);

    /**
     * 详情审核不通过
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailStatusOff(AppPageInput appPageInput);

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    List<Category> findCategory(int parentId);

    /**
     * 审核通过-更新应用日志表
     *
     * @param appPageInput
     * @return int
     */
    int updateAppStatusOn(AppPageInput appPageInput);

    /**
     * 审核通过-收费详情的更新操作
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnPrice(AppPageInput appPageInput);

    /**
     * 审核通过,价格不变-更新详情日志表
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnTimesPrice1(AppPageInput appPageInput);

    /**
     * 审核通过,价格不变-更新详情基本表
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnTimesPrice2(AppPageInput appPageInput);

    /**
     * 查找cp默认分成比例
     *
     * @param accountid
     * @return AppPageOutput
     */
    AppPageOutput findDefaultPercent(int accountid);

    /**
     * 对比价格是否有变动
     *
     * @param appPageInput
     * @return Integer
     */
    Integer findPrice(AppPageInput appPageInput);

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    List<AppPageOutput> findPicture(AppPageInput appPageInput);

    /**
     * 创建应用基本信息后台任务
     *
     * @param backendTask
     */
    void createAppBaseErp(BackendTask backendTask);

    /**
     * 创建应用上下架后台任务
     *
     * @param backendTask
     */
    void createAppOnlineErp(BackendTask backendTask);

    /**
     * 创建详情金钱审核后台任务
     *
     * @param backendTask
     */
    void createPriceErp(BackendTask backendTask);

    /**
     * 不走金钱Erp详情的更新(日志表)
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnFree1(AppPageInput appPageInput);

    /**
     * 不走金钱Erp详情的更新(基本表)
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnFree2(AppPageInput appPageInput);

    /**
     * 不是首次发表详情的更新(日志表)
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnFree3(AppPageInput appPageInput);

    /**
     * 将日志表更新为有效
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnFisrtFreeValid(AppPageInput appPageInput);

    /**
     * 将日志表老数据更新为无效
     *
     * @param appPageInput
     * @return int
     */
    int updateDetailOnFisrtFreeValid2(AppPageInput appPageInput);

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    AndroidAppOsversion findOsVersion(int osVersionId);

    /**
     * 将资源更新为资源副本
     *
     * @param appPageInput
     * @return int
     */
    int updateAppResourceIsCopy(AppPageInput appPageInput);

    /**
     * 删除旧资源
     *
     * @param appPageInput
     * @return int
     */
    int delAppResourceOld(AppPageInput appPageInput);

    /**
     * 查询是否存在副本资源
     *
     * @param appPageInput
     * @return Integer
     */
    Integer findResourceCopyCount(AppPageInput appPageInput);


    /**
     * 查询详情是否存在
     *
     * @param appid
     * @return Integer
     */
    Integer findDetailsCount(int appid);

    /**
     * 查询详情日志是否存在
     *
     * @param appid
     * @return Integer
     */
    Integer findDetailLogCount(int appid);

    /**
     * 查询应用详情日志表
     *
     * @param did
     * @return AppPageInput
     */
    AppPageInput copyAppDetailLog(int did);

    /**
     * 创建应用详情
     *
     * @param appPageInput
     */
    void createAppDetail(AppPageInput appPageInput);

    /**
     * 更新应用类型
     *
     * @param appPageInput
     * @return int
     */
    int upAppType(AppPageInput appPageInput);

    /**
     * 获取所有/部分应用基本信息以及主图
     *
     * @param appPageInput
     * @return List
     */
    List<Apps> getAppBaseInfo(AppPageInput appPageInput);


}
