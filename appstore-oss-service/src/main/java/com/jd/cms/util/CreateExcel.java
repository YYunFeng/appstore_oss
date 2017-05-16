package com.jd.cms.util;

import com.jd.cms.domain.systemmaintenance.Content;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-15
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */
public class CreateExcel {
    public static String newWebExcel(List<Content> contents, String path){
        // 创建工作书册
        XSSFWorkbook wb = new XSSFWorkbook();
        // 创建Excel的工作sheet，对应到一个Excel文档中的tab
        XSSFSheet sheet = wb.createSheet("sheet1");
        // 设定每一列的宽度 ，0 表示列号 ， 4000表示宽度
        sheet.setColumnWidth(0,6000);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 3000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 2000);
        sheet.setColumnWidth(8, 2000);
        sheet.setColumnWidth(9, 2000);
        sheet.setColumnWidth(10, 2000);
        sheet.setColumnWidth(11, 5000);

        // 设置单元格样式
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);

        // 创建Excel的sheet的第一行
        XSSFRow row = sheet.createRow(0);
        row.setHeight((short)500);
        XSSFCell cell0 = row.createCell(0);
        cell0.setCellValue("应用路径");
        cell0.setCellStyle(style);

        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("应用名称");
        cell1.setCellStyle(style);

        XSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("三级分类名1");
        cell2.setCellStyle(style);

        XSSFCell cell3 = row.createCell(3);
        cell3.setCellValue("三级分类名2");
        cell3.setCellStyle(style);

        XSSFCell cell4 = row.createCell(4);
        cell4.setCellValue("关键词");
        cell4.setCellStyle(style);

        XSSFCell cell5 = row.createCell(5);
        cell5.setCellValue("logo文件名");
        cell5.setCellStyle(style);

        XSSFCell cell6 = row.createCell(6);
        cell6.setCellValue("URL或文件名");
        cell6.setCellStyle(style);

        XSSFCell cell7 = row.createCell(7);
        cell7.setCellValue("宽");
        cell7.setCellStyle(style);

        XSSFCell cell8 = row.createCell(8);
        cell8.setCellValue("高");
        cell8.setCellStyle(style);

        XSSFCell cell9 = row.createCell(9);
        cell9.setCellValue("应用类型");
        cell9.setCellStyle(style);

        XSSFCell cell10 = row.createCell(10);
        cell10.setCellValue("上传状态");
        cell10.setCellStyle(style);

        XSSFCell cell11 = row.createCell(11);
        cell11.setCellValue("异常信息");
        cell11.setCellStyle(style);
        Content content;
        String message = "";
        int success = 0;
        for(int i=0; i<contents.size(); i++){
            content = contents.get(i);
            if(content.getStatus()==1){
                success = success + 1;
            }
            XSSFRow rowContent = sheet.createRow(i+1);
            rowContent.setHeight((short) 500);

            XSSFCell cellContent0 = rowContent.createCell(0);
            cellContent0.setCellValue(content.getAppLink());
            cellContent0.setCellStyle(style);

            XSSFCell cellContent1 = rowContent.createCell(1);
            cellContent1.setCellValue(content.getAppName());
            cellContent1.setCellStyle(style);

            XSSFCell cellContent2 = rowContent.createCell(2);
            cellContent2.setCellValue(content.getCategoryId1());
            cellContent2.setCellStyle(style);

            XSSFCell cellContent3 = rowContent.createCell(3);
            cellContent3.setCellValue(content.getCategoryId2());
            cellContent3.setCellStyle(style);

            XSSFCell cellContent4 = rowContent.createCell(4);
            cellContent4.setCellValue(content.getAppTag());
            cellContent4.setCellStyle(style);

            XSSFCell cellContent5 = rowContent.createCell(5);
            cellContent5.setCellValue(content.getLogoUrl());
            cellContent5.setCellStyle(style);

            XSSFCell cellContent6 = rowContent.createCell(6);
            cellContent6.setCellValue(content.getApkName());
            cellContent6.setCellStyle(style);

            XSSFCell cellContent7 = rowContent.createCell(7);
            cellContent7.setCellValue(content.getWidth());
            cellContent7.setCellStyle(style);

            XSSFCell cellContent8 = rowContent.createCell(8);
            cellContent8.setCellValue(content.getHeight());
            cellContent8.setCellStyle(style);

            XSSFCell cellContent9 = rowContent.createCell(9);
            if(content.getAppType()==3){
                cellContent9.setCellValue("web-flash");
            }else if(content.getAppType()==4){
                cellContent9.setCellValue("web-iframe");
            }
            cellContent9.setCellStyle(style);

            XSSFCell cellContent10 = rowContent.createCell(10);
            cellContent10.setCellValue(content.getStatus());
            cellContent10.setCellStyle(style);

            XSSFCell cellContent11 = rowContent.createCell(11);
            cellContent11.setCellValue(content.getMessage());
            cellContent11.setCellStyle(style);
        }
        message = "总计"+contents.size()+"个应用，成功上传"+success+"个，失败"+(contents.size()-success)+"个。";
        String newPath = path.substring(0,path.lastIndexOf("."))+"_report"+path.substring(path.lastIndexOf("."),path.length());
        String fileName = newPath.substring(newPath.lastIndexOf("excel"),newPath.length());
        try {
            FileOutputStream os = new FileOutputStream(newPath);
            wb.write(os);
            os.close();
        } catch (Exception e) {
            throw new RuntimeException("创建Excel出错", e);
        }
        return message + "+" + fileName;

    }


    public static String newExcel(List<Content> contents, String path){
        // 创建工作书册
        XSSFWorkbook wb = new XSSFWorkbook();
        // 创建Excel的工作sheet，对应到一个Excel文档中的tab
        XSSFSheet sheet = wb.createSheet("sheet1");
        // 设定每一列的宽度 ，0 表示列号 ， 4000表示宽度
        sheet.setColumnWidth(0,6000);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 3000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);
        sheet.setColumnWidth(8, 2000);
        sheet.setColumnWidth(9, 5000);

        // 设置单元格样式
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);

        // 创建Excel的sheet的第一行
        XSSFRow row = sheet.createRow(0);
        row.setHeight((short)500);
        XSSFCell cell0 = row.createCell(0);
        cell0.setCellValue("应用路径");
        cell0.setCellStyle(style);

        XSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("应用名称");
        cell1.setCellStyle(style);

        XSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("二级分类");
        cell2.setCellStyle(style);

        XSSFCell cell3 = row.createCell(3);
        cell3.setCellValue("三级分类名1");
        cell3.setCellStyle(style);

        XSSFCell cell4 = row.createCell(4);
        cell4.setCellValue("三级分类名2");
        cell4.setCellStyle(style);

        XSSFCell cell5 = row.createCell(5);
        cell5.setCellValue("关键词");
        cell5.setCellStyle(style);

        XSSFCell cell6 = row.createCell(6);
        cell6.setCellValue("logo文件名");
        cell6.setCellStyle(style);

        XSSFCell cell7 = row.createCell(7);
        cell7.setCellValue("安装包文件名");
        cell7.setCellStyle(style);

        XSSFCell cell8 = row.createCell(8);
        cell8.setCellValue("上传状态");
        cell8.setCellStyle(style);

        XSSFCell cell9 = row.createCell(9);
        cell9.setCellValue("错误信息");
        cell9.setCellStyle(style);

        Content content;
        String message = "";
        int success = 0;
        for(int i=0; i<contents.size(); i++){
            content = contents.get(i);
            if(content.getStatus()==1){
                success = success + 1;
            }
            XSSFRow rowContent = sheet.createRow(i+1);
            rowContent.setHeight((short) 500);

            XSSFCell cellContent0 = rowContent.createCell(0);
            cellContent0.setCellValue(content.getAppLink());
            cellContent0.setCellStyle(style);

            XSSFCell cellContent1 = rowContent.createCell(1);
            cellContent1.setCellValue(content.getAppName());
            cellContent1.setCellStyle(style);

            XSSFCell cellContent2 = rowContent.createCell(2);
            cellContent2.setCellValue(content.getCategoryIdl2());
            cellContent2.setCellStyle(style);

            XSSFCell cellContent3 = rowContent.createCell(3);
            cellContent3.setCellValue(content.getCategoryId1());
            cellContent3.setCellStyle(style);

            XSSFCell cellContent4 = rowContent.createCell(4);
            cellContent4.setCellValue(content.getCategoryId2());
            cellContent4.setCellStyle(style);

            XSSFCell cellContent5 = rowContent.createCell(5);
            cellContent5.setCellValue(content.getAppTag());
            cellContent5.setCellStyle(style);

            XSSFCell cellContent6 = rowContent.createCell(6);
            cellContent6.setCellValue(content.getLogoUrl());
            cellContent6.setCellStyle(style);

            XSSFCell cellContent7 = rowContent.createCell(7);
            cellContent7.setCellValue(content.getApkName());
            cellContent7.setCellStyle(style);

            XSSFCell cellContent8 = rowContent.createCell(8);
            cellContent8.setCellValue(content.getStatus());
            cellContent8.setCellStyle(style);

            XSSFCell cellContent9 = rowContent.createCell(9);
            cellContent9.setCellValue(content.getMessage());
            cellContent9.setCellStyle(style);
        }
        message = "总计"+contents.size()+"个应用，成功上传"+success+"个，失败"+(contents.size()-success)+"个。";
        String newPath = path.substring(0,path.lastIndexOf("."))+"_report"+path.substring(path.lastIndexOf("."),path.length());
        String fileName = newPath.substring(newPath.lastIndexOf("excel"),newPath.length());
        try {
            FileOutputStream os = new FileOutputStream(newPath);
            wb.write(os);
            os.close();
        } catch (Exception e) {
            throw new RuntimeException("创建Excel出错", e);
        }
        return message + "+" + fileName;
    }
}
