package com.jd.cms.dao.appManagement.impl;

import com.jd.appstore.domain.AndroidAppOsversion;
import com.jd.appstore.domain.Apps;
import com.jd.appstore.domain.BackendTask;
import com.jd.appstore.domain.Category;
import com.jd.cms.dao.appManagement.AppManagementDao;
import com.jd.cms.domain.appManagement.AppPageInput;
import com.jd.cms.domain.appManagement.AppPageOutput;
import com.jd.cms.domain.appManagement.SalerRankingRes;
import com.jd.common.dao.BaseDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 审核应用daoImpl
 */
public class AppManagementDaoImpl extends BaseDao implements AppManagementDao {
    /**
     * 取得审核应用的总记录数
     *
     * @param appPageInput
     * @return int
     */
    public int getDetailsCount(AppPageInput appPageInput) {
        return (Integer) queryForObject("AppManagement.getDetailsCount", appPageInput);
    }

    /**
     * 取得审核应用的信息集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findDetailsPage(AppPageInput appPageInput) {
        return queryForList("AppManagement.findDetailsPage", appPageInput);
    }

    /**
     * 取得详情对应应用的基本信息审核状态(详情Id)
     *
     * @param did
     * @return int
     */
    public int findAppStatus(int did) {
        return (Integer) queryForObject("AppManagement.findAppStatus", did);
    }

    /**
     * 取得详情对应应用的基本信息审核状态(应用Id)
     *
     * @param appid
     * @return int
     */
    public int findAppNature(int appid) {
        return (Integer) queryForObject("AppManagement.findAppNature", appid);
    }

    /**
     * 查找单个详情
     *
     * @param did
     * @return AppPageOutput
     */
    public AppPageOutput findAppDetails(int did) {
        return (AppPageOutput) queryForObject("AppManagement.findAppDetails", did);
    }

    /**
     * 应用审核不通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateAppStatusOff(AppPageInput appPageInput) {
        return update("AppManagement.updateAppStatusOff", appPageInput);
    }

    /**
     * 详情审核不通过
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailStatusOff(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailStatusOff", appPageInput);
    }

    /**
     * 通过2级类目查找3级类目
     *
     * @param parentId
     * @return List
     */
    public List<Category> findCategory(int parentId) {
        return queryForList("AppManagement.findCategory", parentId);
    }

    /**
     * 审核通过-更新应用日志表
     *
     * @param appPageInput
     * @return int
     */
    public int updateAppStatusOn(AppPageInput appPageInput) {
        return update("AppManagement.updateAppStatusOn", appPageInput);
    }

    /**
     * 审核通过-收费详情的更新操作
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnPrice(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnPrice", appPageInput);
    }

    /**
     * 审核通过,价格不变-更新详情日志表
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnTimesPrice1(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnTimesPrice1", appPageInput);
    }

    /**
     * 审核通过,价格不变-更新详情基本表
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnTimesPrice2(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnTimesPrice2", appPageInput);
    }

    /**
     * 查找cp默认分成比例
     *
     * @param accountid
     * @return AppPageOutput
     */
    public AppPageOutput findDefaultPercent(int accountid) {
        return (AppPageOutput) queryForObject("AppManagement.findDefaultPercent", accountid);
    }

    /**
     * 对比价格是否有变动
     *
     * @param appPageInput
     * @return Integer
     */
    public Integer findPrice(AppPageInput appPageInput) {
        return (Integer) queryForObject("AppManagement.findPrice", appPageInput);
    }

    /**
     * CP应用对应的截图集合
     *
     * @param appPageInput
     * @return List
     */
    public List<AppPageOutput> findPicture(AppPageInput appPageInput) {
        return queryForList("AppManagement.findPicture", appPageInput);
    }

    /**
     * 创建应用基本信息后台任务
     *
     * @param backendTask
     */
    public void createAppBaseErp(BackendTask backendTask) {
        insert("AppManagement.createAppBaseErp", backendTask);
    }

    /**
     * 创建应用上下架后台任务
     *
     * @param backendTask
     */
    public void createAppOnlineErp(BackendTask backendTask) {
        insert("AppManagement.createAppOnlineErp", backendTask);
    }

    /**
     * 创建详情金钱审核后台任务
     *
     * @param backendTask
     */
    public void createPriceErp(BackendTask backendTask) {
        insert("AppManagement.createPriceErp", backendTask);
    }

    /**
     * 不走金钱Erp详情的更新(日志表)
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnFree1(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnFree1", appPageInput);
    }

    /**
     * 不走金钱Erp详情的更新(基本表)
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnFree2(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnFree2", appPageInput);
    }

    /**
     * 不是首次发表详情的更新(日志表)
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnFree3(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnFree3", appPageInput);
    }

    /**
     * 将日志表更新为有效
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnFisrtFreeValid(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnFisrtFreeValid", appPageInput);
    }

    /**
     * 将日志表老数据更新为无效
     *
     * @param appPageInput
     * @return int
     */
    public int updateDetailOnFisrtFreeValid2(AppPageInput appPageInput) {
        return update("AppManagement.updateDetailOnFisrtFreeValid2", appPageInput);
    }

    /**
     * 查找对应的平台名
     *
     * @param osVersionId
     * @return AndroidAppOsversion
     */
    public AndroidAppOsversion findOsVersion(int osVersionId) {
        return (AndroidAppOsversion) queryForObject("AppManagement.findOsVersion", osVersionId);
    }

    /**
     * 将资源更新为资源副本
     *
     * @param appPageInput
     * @return int
     */
    public int updateAppResourceIsCopy(AppPageInput appPageInput) {
        return update("AppManagement.updateAppResourceIsCopy", appPageInput);
    }

    /**
     * 删除旧资源
     *
     * @param appPageInput
     * @return int
     */
    public int delAppResourceOld(AppPageInput appPageInput) {
        return delete("AppManagement.delAppResourceOld", appPageInput);
    }

    /**
     * 查询是否存在副本资源
     *
     * @param appPageInput
     * @return Integer
     */
    public Integer findResourceCopyCount(AppPageInput appPageInput) {
        return (Integer) queryForObject("AppManagement.findResourceCopyCount", appPageInput);
    }


    /**
     * 查询详情是否存在
     *
     * @param appid
     * @return Integer
     */
    public Integer findDetailsCount(int appid) {
        return (Integer) queryForObject("AppManagement.findDetailsCount", appid);
    }

    /**
     * 查询详情日志是否存在
     *
     * @param appid
     * @return Integer
     */
    public Integer findDetailLogCount(int appid) {
        return (Integer) queryForObject("AppManagement.findDetailLogCount", appid);
    }


    /**
     * 查询应用详情日志表
     *
     * @param did
     * @return AppPageInput
     */
    public AppPageInput copyAppDetailLog(int did) {
        AppPageInput x = (AppPageInput) queryForObject("AppManagement.copyAppDetailLog", did);
        return x;
    }

    /**
     * 创建应用详情
     *
     * @param appPageInput
     */
    public void createAppDetail(AppPageInput appPageInput) {
        insert("AppManagement.createAppDetail", appPageInput);
    }

    /**
     * 更新应用类型
     *
     * @param appPageInput
     * @return int
     */
    public int upAppType(AppPageInput appPageInput) {
        return update("AppManagement.upAppType", appPageInput);
    }

    /**
     * 获取所有/部分应用基本信息以及主图
     *
     * @param appPageInput
     * @return List
     */
    public List<Apps> getAppBaseInfo(AppPageInput appPageInput) {
        return queryForList("AppManagement.getAppBaseInfo", appPageInput);
    }



}
