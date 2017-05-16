package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.Category;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.cms.manager.systemmaintenance.BulkUploadManager;
import com.jd.cms.service.systemmaintenance.BulkImportService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class BulkImportServiceImpl implements BulkImportService {
    private BulkUploadManager bulkUploadManager;
    private String blMobileSoftId;
    private String blMobileGameId;
    private String blWebAppId;

    public void setBlWebAppId(String blWebAppId) {
        this.blWebAppId = blWebAppId;
    }

    public void setBlMobileSoftId(String blMobileSoftId) {
        this.blMobileSoftId = blMobileSoftId;
    }

    public void setBlMobileGameId(String blMobileGameId) {
        this.blMobileGameId = blMobileGameId;
    }

    public BulkUploadManager getBulkUploadManager() {
        return bulkUploadManager;
    }

    public void setBulkUploadManager(BulkUploadManager bulkUploadManager) {
        this.bulkUploadManager = bulkUploadManager;
    }

    private List<Content> content_list = null;

    private List<Category> categoryList = null;

    private List<Content> web_content_list = null;

    private List<Category> webCategoryList = null;


    private String msg = "";

    public BulkImportServiceImpl() {

    }

    public String getMsg() {
        return this.msg;
    }

    public void initCategory(int categoryId) {
        this.categoryList = null;
        this.categoryList = bulkUploadManager.findCategoryList(categoryId);
    }

    public void initWebCategory() {
        this.webCategoryList = null;
        this.webCategoryList = bulkUploadManager.findWebCategoryList(Integer.parseInt(blWebAppId));
    }


    private boolean isNullRow(XSSFRow row) {
        if (row == null) {
            return true;
        }
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            if (row.getCell(i) != null && !"".equals(row.getCell(i).toString())) {
                return false;
            }
        }
        return true;
    }

    public void initParseWebExcel(String filePath) {
        this.web_content_list = null;
        if (filePath != null && !"".equals(filePath)) {
            XSSFWorkbook xwb = null;
            XSSFSheet sheet = null;
            XSSFRow row = null;
            String cell = null;
            try {
                Content c = null;
                xwb = new XSSFWorkbook(filePath);
                sheet = xwb.getSheetAt(0);
                this.web_content_list = new ArrayList<Content>();
                // 循环输出表格中的内容
                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    c = new Content();
                    row = sheet.getRow(i);
                    if (!this.isNullRow(row)) {
                        // 应用链接
                        cell = row.getCell(0) == null ? "" : row.getCell(0).toString();
                        c.setAppLink(cell);
                        // 应用名称
                        cell = row.getCell(1) == null ? "" : row.getCell(1).toString();
                        c.setAppName(cell);
                        /*// 二级分类
                        cell = row.getCell(2)==null?"":row.getCell(2).toString();
                        if(cell.equals("网页应用")){
                            c.setCategoryIdl2(Integer.parseInt(blWebAppId));
                        }else{
                            c.setCategoryIdl2(0);
                        }*/
                        c.setCategoryIdl2(Integer.parseInt(blWebAppId));
                        Category category = null;
                        // 三级分类名1
                        cell = row.getCell(2) == null ? "" : row.getCell(2).toString();
                        for (int j = 0; j < webCategoryList.size(); j++) {
                            category = webCategoryList.get(j);
                            if (cell.equals(category.getCategoryName())) {
                                c.setCategoryId1(category.getCategoryId());
                                break;
                            } else {
                                c.setCategoryId1(0);
                            }
                        }
                        // 三级分类名2
                        cell = row.getCell(3) == null ? "" : row.getCell(3).toString();
                        for (int k = 0; k < webCategoryList.size(); k++) {
                            category = webCategoryList.get(k);
                            if (cell.equals(category.getCategoryName())) {
                                c.setCategoryId2(category.getCategoryId());
                                break;
                            } else {
                                c.setCategoryId2(0);
                            }
                        }
                        // 关键词
                        cell = row.getCell(4) == null ? "" : row.getCell(4).toString();
                        c.setAppTag(cell);
                        // logo文件名
                        cell = row.getCell(5) == null ? "" : row.getCell(5).toString();
                        c.setLogoUrl(cell);
                        // 文件名
                        cell = row.getCell(6) == null ? "" : row.getCell(6).toString();
                        c.setApkName(cell);
                        // 宽
                        cell = row.getCell(7) == null ? "" : row.getCell(7).toString();
                        c.setWidth(cell);
                        // 高
                        cell = row.getCell(8) == null ? "" : row.getCell(8).toString();
                        c.setHeight(cell);
                        // 应用类型
                        cell = row.getCell(9) == null ? "" : row.getCell(9).toString();
                        if (cell.equals("web-iframe")) {
                            c.setAppType(4);
                        } else if (cell.equals("web-flash")) {
                            c.setAppType(3);
                        } else {
                            c.setAppType(-1);
                        }
                        c.setStatus(0);
                        this.web_content_list.add(c);
                    }
                }
                this.checkWebExcel();
            } catch (Exception e) {
                this.msg = "文件解析失败，请联系管理员";
                System.out.println(this.msg);
                e.printStackTrace();
            }
        }
    }

    public void initParseExcel(String filePath) {
        this.msg = "";
        this.content_list = null;
        if (filePath != null && !"".equals(filePath)) {
            XSSFWorkbook xwb = null;
            XSSFSheet sheet = null;
            XSSFRow row = null;
            String cell = null;
            try {
                Content c = null;
                xwb = new XSSFWorkbook(filePath);
                sheet = xwb.getSheetAt(0);
                this.content_list = new ArrayList<Content>();
                // 循环输出表格中的内容
                for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    c = new Content();
                    row = sheet.getRow(i);
                    if (!this.isNullRow(row)) {
                        // 应用链接
                        cell = row.getCell(0) == null ? "" : row.getCell(0).toString();
                        c.setAppLink(cell);
                        // 应用名称
                        cell = row.getCell(1) == null ? "" : row.getCell(1).toString();
                        c.setAppName(cell);
                        // 二级分类
                        cell = row.getCell(2) == null ? "" : row.getCell(2).toString();
                        if (cell.equals("移动游戏")) {
                            c.setCategoryIdl2(Integer.parseInt(blMobileGameId));
                        } else if (cell.equals("移动软件")) {
                            c.setCategoryIdl2(Integer.parseInt(blMobileSoftId));
                        } else {
                            c.setCategoryIdl2(0);
                        }
                        initCategory(c.getCategoryIdl2());
                        Category category = null;
                        // 三级分类名1
                        cell = row.getCell(3) == null ? "" : row.getCell(3).toString();
                        for (int j = 0; j < categoryList.size(); j++) {
                            category = categoryList.get(j);
                            if (cell.equals(category.getCategoryName())) {
                                c.setCategoryId1(category.getCategoryId());
                                break;
                            } else {
                                c.setCategoryId1(0);
                            }
                        }
                        // 三级分类名2
                        cell = row.getCell(4) == null ? "" : row.getCell(4).toString();
                        for (int k = 0; k < categoryList.size(); k++) {
                            category = categoryList.get(k);
                            if (cell.equals(category.getCategoryName())) {
                                c.setCategoryId2(category.getCategoryId());
                                break;
                            } else {
                                c.setCategoryId2(0);
                            }
                        }
                        // 关键词
                        cell = row.getCell(5) == null ? "" : row.getCell(5).toString();
                        c.setAppTag(cell);
                        // logo文件名
                        cell = row.getCell(6) == null ? "" : row.getCell(6).toString();
                        c.setLogoUrl(cell);
                        // 安装包文件名
                        cell = row.getCell(7) == null ? "" : row.getCell(7).toString();
                        c.setApkName(cell);
                        c.setStatus(0);
                        this.content_list.add(c);

                    }

                }
                this.checkExcel();
            } catch (Exception e) {
                this.msg = "文件解析失败，请联系管理员";
                System.out.println(this.msg);
                e.printStackTrace();
            }
        }
    }

    public List<Content> getContentListByExcel() {
        return this.content_list;
    }

    public List<Content> getWebContentListByExcel() {
        return this.web_content_list;
    }

    public List<Category> getCategoryList() {
        return this.categoryList;
    }

    public List<Category> getWebCategoryList() {
        return this.webCategoryList;
    }

    private void checkWebExcel() {
        if (this.web_content_list != null) {
            Content content;
            for (int i = 0; i < this.web_content_list.size(); i++) {
                String message = "";
                content = this.web_content_list.get(i);
                // 判断应用路径
                if (content.getAppLink() == null || "".equals(content.getAppLink().trim())) {
                    message = "目录不存在";
                }
                // 判断应用名称
                if (content.getAppName() == null || "".equals(content.getAppName().trim())) {
                    if (message.equals("")) {
                        message += "应用名称为空";
                    } else {
                        message += ",应用名称为空";
                    }
                }
                if (content.getCategoryId1() == 0) {
                    if (message.equals("")) {
                        message += "三级分类1错误";
                    } else {
                        message += ",三级分类1错误";
                    }
                }
                // 判断logo文件名
                if (content.getLogoUrl() == null || "".equals(content.getLogoUrl().trim())) {
                    if (message.equals("")) {
                        message += "应用logo名为空";
                    } else {
                        message += ",应用logo名为空";
                    }
                }
                // 判断URL和文件名是否正确
                if (content.getAppType() == 3) {
                    if (content.getApkName().lastIndexOf(".swf") == 0) {
                        if (message.equals("")) {
                            message += "flash名不正确";
                        } else {
                            message += ",flash名不正确";
                        }
                    }
                }else if(content.getAppType()==4){
                    if(content.getApkName().indexOf("http://")<0){
                        if (message.equals("")) {
                            message += "URL地址不正确";
                        } else {
                            message += ",URL地址不正确";
                        }
                    }
                }
                if (!"".equals(message)) {
                    content.setStatus(-1);
                    content.setMessage(message);
                } else {
                    content.setMessage("");
                }
            }
        }
    }

    private void checkExcel() {
        if (this.content_list != null) {
            Content content;
            for (int i = 0; i < this.content_list.size(); i++) {
                String message = "";
                content = this.content_list.get(i);
                // 判断应用路径
                if (content.getAppLink() == null || "".equals(content.getAppLink().trim())) {
                    message = "目录不存在";
                }
                // 判断应用名称
                if (content.getAppName() == null || "".equals(content.getAppName().trim())) {
                    if (message.equals("")) {
                        message += "应用名称为空";
                    } else {
                        message += ",应用名称为空";
                    }
                }
                // 判断二级分类
                if (content.getCategoryIdl2() == 0) {
                    if (message.equals("")) {
                        message += "二级分类错误";
                    } else {
                        message += ",二级分类错误";
                    }
                }
                if (content.getCategoryId1() == 0) {
                    if (message.equals("")) {
                        message += "三级分类1错误";
                    } else {
                        message += ",三级分类1错误";
                    }
                }
                // 判断logo文件名
                if (content.getLogoUrl() == null || "".equals(content.getLogoUrl().trim())) {
                    if (message.equals("")) {
                        message += "应用logo名为空";
                    } else {
                        message += ",应用logo名为空";
                    }
                }
                // 判断安装包文件名
                if (content.getApkName().lastIndexOf(".apk") == 0) {
                    if (message.equals("")) {
                        message += "APK名不正确";
                    } else {
                        message += ",APK名不正确";
                    }
                }
                if (!"".equals(message)) {
                    content.setStatus(-1);
                    content.setMessage(message);
                } else {
                    content.setMessage("");
                }
            }
        }
    }

     /*public static void main(String[] args){
        String filePath = "C:\\Users\\hqj\\Desktop\\appsimport\\批量导入\\module.xlsx";
        try {
            BulkImportServiceImpl is = new BulkImportServiceImpl();
            is.initParseWebExcel(filePath);
            System.out.println(is.getMsg());
            List<Content> list = is.getWebContentListByExcel();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " = " + list.get(i).getAppLink());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
