package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.Category;
import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.cms.manager.systemmaintenance.CategoryMaintenanceManager;
import com.jd.cms.service.systemmaintenance.CategoryMaintenanceService;
import com.jd.common.web.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-6
 * Time: 上午11:57
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMaintenanceServiceImpl implements CategoryMaintenanceService {
    private final static Log log = LogFactory.getLog(CategoryMaintenanceServiceImpl.class);
    /**
     * 类目管理Manager
     */
    private CategoryMaintenanceManager categoryMaintenanceManagerCached;
    /**
     * 二级类目移动软件
     */
    private String mobileSoftId;
    /**
     * 二级类目移动游戏
     */
    private String mobileGameId;
    /**
     * 二级类目web应用
     */
    private String webAppId;
    /**
     * 截图服务器HOST
     */
    private String imgserver;
    /**
     * 本地上传路径
     */
    private String uploadImagePath;

    /**
     * 按二级类目查询三级类目列表
     *
     * @return
     * @throws Exception
     */
    public Result findCategoryByParentId(int pageIndex, int pageSize, int parentId) {
        Result result = new Result();
        result.addDefaultModel("categorys", categoryMaintenanceManagerCached.findCategoryByParentId(pageIndex, pageSize, parentId));
        //父ID
        result.addDefaultModel("parentId", parentId);
        //返回图片尺度
        result.addDefaultModel("picsize", PicResolutionEnum.IMG_N0.getPrefix());
        return result;
    }

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param picUrl
     * @param id
     * @return
     */
    public String updateCategoryPicUrl(String picUrl, int id) {
        categoryMaintenanceManagerCached.updateCategoryPicUrl(picUrl, id);
        return imgserver;
    }

    /**
     * 初始化类目管理
     *
     * @return
     * @throws Exception
     */
    public Result init() {
        Result result = new Result();
        result.addDefaultModel("mobileSoftId", mobileSoftId);
        result.addDefaultModel("mobileGameId", mobileGameId);
        result.addDefaultModel("webAppId", webAppId);
        return result;
    }

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    public Result fintCategoryIntro(int categoryId) {
        Result result = new Result();
        result.addDefaultModel("categoryInfo", categoryMaintenanceManagerCached.fintCategoryIntro(categoryId));
        return result;
    }

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    public void doUpdateCategoryIntro(Category category) {
        categoryMaintenanceManagerCached.doUpdateCategoryIntro(category);
    }

    /**
     * 获取本地上传路径
     *
     * @return
     */
    public String getUploadImagePath() {
        return uploadImagePath;
    }

    public void createCategory(Category category) {
        categoryMaintenanceManagerCached.ceateCategory(category);
    }

    public void deleteCategory(int categoryId) {
        categoryMaintenanceManagerCached.deleteCategory(categoryId);
    }

    public void setCategoryMaintenanceManagerCached(CategoryMaintenanceManager categoryMaintenanceManagerCached) {
        this.categoryMaintenanceManagerCached = categoryMaintenanceManagerCached;
    }

    public void setMobileSoftId(String mobileSoftId) {
        this.mobileSoftId = mobileSoftId;
    }

    public void setMobileGameId(String mobileGameId) {
        this.mobileGameId = mobileGameId;
    }

    public void setWebAppId(String webAppId) {
        this.webAppId = webAppId;
    }

    public void setImgserver(String imgserver) {
        this.imgserver = imgserver;
    }

    public void setUploadImagePath(String uploadImagePath) {
        this.uploadImagePath = uploadImagePath;
    }
}
