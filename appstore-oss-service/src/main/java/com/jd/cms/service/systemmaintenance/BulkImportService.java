package com.jd.cms.service.systemmaintenance;

import com.jd.appstore.domain.Category;
import com.jd.cms.domain.systemmaintenance.Content;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public interface BulkImportService {
    public void initParseExcel(String filePath);

    public void initParseWebExcel(String filePath);

    public List<Content> getContentListByExcel();

    public List<Content> getWebContentListByExcel();

    public String getMsg();

    public void initCategory(int categoryId);

    public void initWebCategory();

    public List<Category> getCategoryList();

    public List<Category> getWebCategoryList();
}
