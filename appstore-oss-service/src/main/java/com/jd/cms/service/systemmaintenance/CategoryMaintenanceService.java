package com.jd.cms.service.systemmaintenance;

import com.jd.appstore.domain.Category;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-6
 * Time: 上午11:57
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryMaintenanceService {
    /**
     * 按二级类目查询三级类目列表
     *
     * @return
     * @throws Exception
     */
    Result findCategoryByParentId(int pageIndex, int pageSize, int parentId);

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param picUrl
     * @param id
     * @return
     */
    String updateCategoryPicUrl(String picUrl, int id);

    /**
     * 初始化类目管理
     *
     * @return
     * @throws Exception
     */
    Result init();

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    Result fintCategoryIntro(int categoryId);

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    void doUpdateCategoryIntro(Category category);

    String getUploadImagePath();

    void createCategory(Category category);

    void deleteCategory(int categoryId);
}
