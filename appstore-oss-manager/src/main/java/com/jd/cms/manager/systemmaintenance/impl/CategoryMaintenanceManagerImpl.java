package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.dao.systemmaintenance.CategoryMaintenanceDao;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.systemmaintenance.CategoryMaintenanceManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-6
 * Time: 下午12:10
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMaintenanceManagerImpl extends BaseManager implements CategoryMaintenanceManager {
    private final static Logger log = Logger.getLogger(CategoryMaintenanceManagerImpl.class);
    private CategoryMaintenanceDao categoryMaintenanceDao;

    /**
     * 按二级类目查询三级类目列表
     *
     * @return
     * @throws Exception
     */
    public PaginatedList<Category> findCategoryByParentId(int pageIndex, int pageSize, int parentId) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<Category> categorys = new PaginatedArrayList<Category>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            //设置父ID
            baseQuery.setId(parentId);
            //查询总记录数
            int totalItem = categoryMaintenanceDao.getCategoryByParentId(baseQuery);
            //设置总记录数
            categorys.setTotalItem(totalItem);
            //设置查询页号
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            //设置记录数
            baseQuery.setEndRow(pageSize);
            //查询类目列表
            List<Category> category = categoryMaintenanceDao.findCategoryByParentId(baseQuery);
            //设置类目列表
            categorys.addAll(category);
        } catch (Exception ex) {
            log.error("findCategoryByParentId 按二级分类分页查询类目信息方法 pageIndex=" + pageIndex + " pageSize=" + pageSize + " parentId=" + parentId + " error!", ex);
            throw new RuntimeException("findCategoryByParentId 按二级分类分页查询类目信息方法 pageIndex=" + pageIndex + " pageSize=" + pageSize + " parentId=" + parentId + " error!", ex);
        }
        return categorys;
    }

    /**
     * 修改类目图片路径，并返回图片服务器HOST
     *
     * @param picUrl
     * @param id
     * @return
     */
    public void updateCategoryPicUrl(final String picUrl, final int id) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    BaseQuery baseQuery = new BaseQuery();
                    //设置ID
                    baseQuery.setId(id);
                    //设置图片URL
                    baseQuery.setValue(picUrl);
                    categoryMaintenanceDao.updateCategoryPicUrl(baseQuery);
                } catch (Exception ex) {
                    log.error("updateCategoryPicUrl 更新类目图标方法 picUrl=" + picUrl + " id=" + id + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateCategoryPicUrl 更新类目图标方法 picUrl=" + picUrl + " id=" + id + " error!", ex);
                }
            }
        });
    }

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    public void doUpdateCategoryIntro(Category category) {
        try {
            categoryMaintenanceDao.doUpdateCategoryIntro(category);
        } catch (Exception ex) {
            log.error("doUpdateCategoryIntro 更新类目描述方法论 error!", ex);
            throw new RuntimeException("doUpdateCategoryIntro 更新类目描述方法论  error!", ex);
        }
    }

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    public Category fintCategoryIntro(int categoryId) {
        Category category = null;
        try {
            BaseQuery baseQuery = new BaseQuery();
            //设置类目ID
            baseQuery.setId(categoryId);
            category = categoryMaintenanceDao.fintCategoryIntro(baseQuery);
        } catch (Exception ex) {
            log.error("doUpdateCategoryIntro 更新类目描述方法 categoryId=" + categoryId + " error!", ex);
            throw new RuntimeException("doUpdateCategoryIntro 更新类目描述方法 categoryId=" + categoryId + " error!", ex);
        }
        return category;
    }

    public void ceateCategory(final Category category) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int categoryId = (int) sequenceUtil.get(SequenceConstants.CATEGORY_SEQUENCE);
                    category.setCategoryId(categoryId);
                    category.setExpiredStatus(0);
                    category.setLevel(3);
                    category.setLeaf(3);
                    category.setPubedStatus(1);
                    categoryMaintenanceDao.createCategory(category);
                } catch (Exception e) {
                    log.info("createRecommend error", e);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("doUpdateCategoryIntro 添加类目描述  error!", e);
                }
            }
        });
    }

    public void deleteCategory(int categoryId) {
        try {
            categoryMaintenanceDao.deleteCategory(categoryId);
        } catch (Exception e) {
            log.error("deleteCategory 删除出错", e);
            throw new RuntimeException("删除出错！", e);
        }
    }


    public void setCategoryMaintenanceDao(CategoryMaintenanceDao categoryMaintenanceDao) {
        this.categoryMaintenanceDao = categoryMaintenanceDao;
    }
}
