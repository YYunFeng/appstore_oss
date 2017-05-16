package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.AppCountParameter;
import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.manager.appManagement.AppCountsManager;
import com.jd.cms.service.appManagement.AppCountsService;
import com.jd.common.web.result.Result;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by YUNFENG on 14-2-17.
 */
public class AppCountsServiceImpl implements AppCountsService {
    private AppCountsManager appCountsManager;
    private String appCountPath;
    private String downloadPath;

    public Result getCountAppsByCp(AppCountParameter appCountParameter, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("appCounts", appCountsManager.getCountAppsByCp(appCountParameter, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result getCountAppByApp(AppCountParameter appCountParameter, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("appCounts", appCountsManager.getCountAppByApp(appCountParameter, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result getCountAppByPhoneImei(AppCountParameter appCountParameter, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("appCounts", appCountsManager.getCountAppByPhoneImei(appCountParameter, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ExportExcelJSON getCountAppExcel(AppCountParameter appCountParameter, Integer metohFlag) {
        ExportExcelJSON exportExcelJSON = new ExportExcelJSON();
        try {
            // 创建工作书册
            short height = 400;
            XSSFWorkbook wb = new XSSFWorkbook();
            // 创建Excel的工作sheet，对应到一个Excel文档中的tab
            XSSFSheet sheet = wb.createSheet("应用到达量统计");

            // 创建Excel的sheet的第一行
            XSSFRow row = sheet.createRow(0);
            row.setHeight(height);
            XSSFCell cell = row.createCell(0);
            // 设置字体 --title
            Font fontTitle = wb.createFont();
            fontTitle.setFontHeightInPoints((short) 12);
            fontTitle.setFontName("微软雅黑");
            fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);

            // 设置字体--内容
            Font fontContent = wb.createFont();
            fontContent.setFontHeightInPoints((short) 10);
            fontContent.setFontName("微软雅黑");

            // 单元格样式 --title属性
            XSSFCellStyle titleStyle = wb.createCellStyle();
            titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            titleStyle.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
            titleStyle.setFont(fontTitle);
            // 91, 155, 213
            titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(91, 155, 213)));
            titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);


            // 单元格属性 --内容属性title
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            cellStyle.setFont(fontContent);
            cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(180, 198, 231)));
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setWrapText(true);

            // 单元格属性 --内容属性content
            XSSFCellStyle cellStyleContent = wb.createCellStyle();
            cellStyleContent.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            cellStyleContent.setFont(fontContent);
            if (metohFlag != null) {
                // 应用到达量统计    按CP查看
                if (metohFlag.intValue() == 0) {
                    List<AppCountResult> appCountResultList = appCountsManager.getCountAppsByCpExcel(appCountParameter);
                    if (appCountResultList != null && appCountResultList.size() > 0) {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
                        // 设置第一行的值
                        if (appCountParameter.getStartTime() == null || appCountParameter.getStartTime() == null || appCountParameter.getStartTime().equals("") || appCountParameter.getEndTime().equals("")) {
                            cell.setCellValue("应用到达量统计");
                        } else {
                            cell.setCellValue("应用到达量统计(" + appCountParameter.getStartTime() + "至" + appCountParameter.getEndTime() + ")");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("CP名称");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("安装量");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("到达量");
                        cell3.setCellStyle(cellStyle);
                        //     开始写入数据
                        for (int i = 0; i < appCountResultList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);
                            XSSFCell cellValidMachineTotal1 = rowStatByApps.createCell(0);
                            cellValidMachineTotal1.setCellValue(appCountResultList.get(i).getAccount());
                            cellValidMachineTotal1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineTotal2 = rowStatByApps.createCell(1);
                            cellValidMachineTotal2.setCellValue(appCountResultList.get(i).getInstallCounts());
                            cellValidMachineTotal2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineTotal3 = rowStatByApps.createCell(2);
                            cellValidMachineTotal3.setCellValue(appCountResultList.get(i).getCountApps());
                            cellValidMachineTotal3.setCellStyle(cellStyleContent);

                        }

                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    //   按应用查看
                } else if (metohFlag.intValue() == 1) {
                    List<AppCountResult> appCountResultList = appCountsManager.getCountAppByAppExcel(appCountParameter);
                    if (appCountResultList != null && appCountResultList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
                        // 设置第一行的值
                        if (appCountParameter.getStartTime() == null || appCountParameter.getStartTime() == null || appCountParameter.getStartTime().equals("") || appCountParameter.getEndTime().equals("")) {
                            cell.setCellValue("应用到达量统计");
                        } else {
                            cell.setCellValue("应用到达量统计(" + appCountParameter.getStartTime() + "至" + appCountParameter.getEndTime() + ")");
                        }

                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("应用名称");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("安装量");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("到达量");
                        cell3.setCellStyle(cellStyle);

                        for (int i = 0; i < appCountResultList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByChannel1 = rowStatByApps.createCell(0);
                            cellValidMachineByChannel1.setCellValue(appCountResultList.get(i).getAppName());
                            cellValidMachineByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel2 = rowStatByApps.createCell(1);
                            cellValidMachineByChannel2.setCellValue(appCountResultList.get(i).getInstallCounts());
                            cellValidMachineByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel3 = rowStatByApps.createCell(2);
                            cellValidMachineByChannel3.setCellValue(appCountResultList.get(i).getCountApps());
                            cellValidMachineByChannel3.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    //  按促销员查看
                } else if (metohFlag.intValue() == 2) {
                    List<AppCountResult> appCountResultList = appCountsManager.getCountAppByPhoneImeiExcel(appCountParameter);
                    if (appCountResultList != null && appCountResultList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
                        // 设置第一行的值
                        if (appCountParameter.getStartTime() == null || appCountParameter.getStartTime() == null || appCountParameter.getStartTime().equals("") || appCountParameter.getEndTime().equals("")) {
                            cell.setCellValue("暂无统计信息");
                        } else {
                            cell.setCellValue("暂无统计信息(" + appCountParameter.getStartTime() + "至" + appCountParameter.getEndTime() + ")");
                        }

                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("应用名称");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("串码");
                        cell2.setCellStyle(cellStyle);

                        for (int i = 0; i < appCountResultList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineBySale1 = rowStatByApps.createCell(0);
                            cellValidMachineBySale1.setCellValue(appCountResultList.get(i).getAppName());
                            cellValidMachineBySale1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale2 = rowStatByApps.createCell(1);
                            cellValidMachineBySale2.setCellValue(appCountResultList.get(i).getPhoneImei());
                            cellValidMachineBySale2.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无公司总收入统计信息--按促销员查看");
                        cell.setCellStyle(cellStyle);
                    }
                }
            }
            String newPath = System.currentTimeMillis() + ".xlsx";
            File installLogExcel = new File(appCountPath);
            if (!installLogExcel.exists()) {
                installLogExcel.mkdirs();
            }
            try {
                FileOutputStream os = new FileOutputStream(appCountPath + "/" + newPath);
                wb.write(os);
                os.close();
                exportExcelJSON.setStatus(1);
                exportExcelJSON.setExcelDownAddress(downloadPath + "companyIncomeExcel/" + newPath);
            } catch (Exception e) {
                exportExcelJSON.setStatus(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exportExcelJSON;
    }


    public String getAppCountPath() {
        return appCountPath;
    }

    public void setAppCountPath(String appCountPath) {
        this.appCountPath = appCountPath;
    }

    public void setAppCountsManager(AppCountsManager appCountsManager) {
        this.appCountsManager = appCountsManager;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
