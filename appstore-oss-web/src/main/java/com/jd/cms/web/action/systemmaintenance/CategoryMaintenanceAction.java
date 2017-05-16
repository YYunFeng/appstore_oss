package com.jd.cms.web.action.systemmaintenance;

import com.jd.appstore.domain.Category;
import com.jd.cms.common.util.Util;
import com.jd.cms.service.systemmaintenance.CategoryMaintenanceService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.manager.img.ImageManager;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.File;
import java.io.IOException;


/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-8-6
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class CategoryMaintenanceAction extends BaseAction {
    /**
     * 类目管理Service
     */
    private CategoryMaintenanceService categoryMaintenanceService;
    /**
     * 图片上传接口
     */
    private ImageManager imageManager;
    /**
     * 父ID
     */
    private int parentId;
    /**
     * 类目ID
     */
    private int categoryId;
    /**
     * 上传文件
     */
    private File uploadFile;
    /**
     * 类目描述
     */
    private String categoryIntro;
    /**
     * cookie工具类
     */
    protected CookieUtils cookieUtils;

    private Category category;

    /**
     * 初始化类目管理
     *
     * @return
     * @throws Exception
     */
    public String init() throws Exception {
        Result result = categoryMaintenanceService.init();
        toVm(result);
        return "init";
    }

    /**
     * 按二级类目查询三级类目列表
     *
     * @return
     * @throws Exception
     */
    public String categoryList() throws Exception {
        Result result = categoryMaintenanceService.findCategoryByParentId(page, PAGE_SIZE, parentId);
        toVm(result);
        return "list";
    }

    /**
     * 上传类目图片
     *
     * @throws IOException
     */
    public void uploadPic() throws IOException, JSONException {
        //设置上传本地路径
        String targetDirectory = categoryMaintenanceService.getUploadImagePath();
        //创建本地路径file对像
        File fl = new File(targetDirectory);
        //判断目录是否存在
        if (!fl.exists()) {
            //如果不存在，则创建目录
            fl.mkdirs();
        }
        //上传文件
        String extName = "";
        //获取上传文件
        String names[] = ((MultiPartRequestWrapper) this.request).getFileNames("uploadFile");
        //文件是否存在
        if (names[0].lastIndexOf(".") >= 0) {
            //修改上传文件名
            extName = Util.getUuid() + names[0].substring(names[0].lastIndexOf("."));
        }
        try {
            //创建file对像
            File target = new File(targetDirectory, extName);
            //上传文件到本地
            FileUtils.copyFile(uploadFile, target);
            /*   //上传到截图服务器
          uploadPath = imageManager.uploadImage(target);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        //以修改方式将图片路径写入数据库，并返回图片服务器HOST
        String imgserver = categoryMaintenanceService.updateCategoryPicUrl(extName, categoryId);
        //图片完整路径

        response.setCharacterEncoding("utf-8");
        response.getWriter().write(extName);
    }

    /**
     * 以修改方式将图片路径设置为NULL，达到删除类目图片的目的
     *
     * @throws Exception
     */
    public void deleteImage() throws Exception {
        String isSuccess = "error";
        String imgserver = categoryMaintenanceService.updateCategoryPicUrl(null, categoryId);
        if (imgserver != "") {
            isSuccess = "success";
        }
        String json = JSONUtil.serialize(isSuccess);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    public String updateCategoryIntro() throws Exception {
        Result result = categoryMaintenanceService.fintCategoryIntro(categoryId);
        toVm(result);
        return "intro";
    }

    /**
     * 初始化修改类目描述页
     *
     * @return
     * @throws Exception
     */
    public String addCategory() throws Exception {
        return "addCategory";
    }

    /**
     * 添加类目
     *
     * @return
     * @throws Exception
     */
    public String saveCategory() throws Exception {
        categoryMaintenanceService.createCategory(category);
        parentId = category.getParentId();
        return categoryList();
    }

    /**
     * 删除类目
     * @return
     * @throws Exception
     */

    public String deleteCategory() throws Exception{
        categoryMaintenanceService.deleteCategory(categoryId);
        return categoryList();
    }

    /**
     * 修改类目描述
     *
     * @return
     * @throws Exception
     */
    public String doUpdateCategoryIntro() throws Exception {
        categoryMaintenanceService.doUpdateCategoryIntro(category);
         parentId = category.getParentId();
        return categoryList();
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public void setCategoryMaintenanceService(CategoryMaintenanceService categoryMaintenanceService) {
        this.categoryMaintenanceService = categoryMaintenanceService;
    }

    public void setImageManager(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    public String getCategoryIntro() {
        return categoryIntro;
    }

    public void setCategoryIntro(String categoryIntro) {
        this.categoryIntro = categoryIntro;
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
