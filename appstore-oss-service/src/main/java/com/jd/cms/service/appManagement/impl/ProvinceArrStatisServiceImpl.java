package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.AppCountResult;
import com.jd.cms.domain.appManagement.ExportExcelJSON;
import com.jd.cms.domain.appManagement.ProvinceArrStatisObj;
import com.jd.cms.domain.appManagement.ProvinceArrStatisParameter;
import com.jd.cms.manager.appManagement.ProvinceArrStatisManager;
import com.jd.cms.service.appManagement.ProvinceArrStatisService;
import com.jd.common.web.result.Result;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by YYF on 2014/7/1.
 */
public class ProvinceArrStatisServiceImpl implements ProvinceArrStatisService {
    private ProvinceArrStatisManager provinceArrStatisManager;
    private String appCountPath;
    private String downloadPath;

    public Result provinceArrStatis(ProvinceArrStatisParameter provinceArrStatisParameter) {
        Result result = new Result();
        result.addDefaultModel("provinceArrStatis", provinceArrStatisManager.provinceArrStatis(provinceArrStatisParameter));
        result.addDefaultModel("cid", provinceArrStatisParameter.getCid());
        return result;
    }

    public Result provinceArrStatisByCid(ProvinceArrStatisParameter provinceArrStatisParameter) {
        Result result = new Result();
        result.addDefaultModel("provinceArrStatisList", provinceArrStatisManager.provinceArrStatisByCid(provinceArrStatisParameter));
        return result;
    }

    public Result provinceArrStatisBySaler(ProvinceArrStatisParameter provinceArrStatisParameter) {
        Result result = new Result();
        result.addDefaultModel("provinceArrStatisList", provinceArrStatisManager.provinceArrStatisBySaler(provinceArrStatisParameter));
        return result;
    }

    public ExportExcelJSON getCountAppExcel(ProvinceArrStatisParameter provinceArrStatisParameter, Integer metohFlag) {
        ExportExcelJSON exportExcelJSON = new ExportExcelJSON();
        try {
            // 创建工作书册
            short height = 400;
            XSSFWorkbook wb = new XSSFWorkbook();
            // 创建Excel的工作sheet，对应到一个Excel文档中的tab
            XSSFSheet sheet = wb.createSheet("省办到达统计");

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
            // 省办到达统计
            if (metohFlag != null) {
                // 按促销员查看
                if (metohFlag.intValue() == 0) {
                    List<ProvinceArrStatisObj> list = provinceArrStatisManager.provinceArrStatisBySaler(provinceArrStatisParameter);
                    // 设置每一列
                    sheet.setColumnWidth(0, 5000);
                    sheet.setColumnWidth(1, 5000);
                    sheet.setColumnWidth(2, 5000);
                    sheet.setColumnWidth(3, 5000);
                    sheet.setColumnWidth(4, 5000);
                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                    // 设置第一行的值
                    if (provinceArrStatisParameter.getStartTime() == null || provinceArrStatisParameter.getStartTime() == null || provinceArrStatisParameter.getStartTime().equals("") || provinceArrStatisParameter.getEndTime().equals("")) {
                        cell.setCellValue("省办到达统计");
                    } else {
                        cell.setCellValue("省办到达统计(" + provinceArrStatisParameter.getStartTime() + "至" + provinceArrStatisParameter.getEndTime() + ")");
                    }
                    // 设置第一行的属性
                    cell.setCellStyle(titleStyle);
                    // 创建Excel的sheet的第二行第一列
                    XSSFRow row1 = sheet.createRow(1);
                    row1.setHeight((short) 700);
                    XSSFCell cell1 = row1.createCell(0);
                    cell1.setCellValue("渠道名称");
                    cell1.setCellStyle(cellStyle);

                    // 创建Excel的sheet的第二行第二列
                    XSSFCell cell2 = row1.createCell(1);
                    cell2.setCellValue("促销员名称");
                    cell2.setCellStyle(cellStyle);

                    // 创建Excel的sheet的第二行第三列
                    XSSFCell cell3 = row1.createCell(2);
                    cell3.setCellValue("安装应用数");
                    cell3.setCellStyle(cellStyle);

                    // 创建Excel的sheet的第二行第三列
                    XSSFCell cell4 = row1.createCell(3);
                    cell4.setCellValue("到达应用数");
                    cell4.setCellStyle(cellStyle);

                    // 创建Excel的sheet的第二行第三列
                    XSSFCell cell5 = row1.createCell(4);
                    cell5.setCellValue("到达率");
                    cell5.setCellStyle(cellStyle);

                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByChannel1 = rowStatByApps.createCell(0);
                            cellValidMachineByChannel1.setCellValue(list.get(i).getChannelName());
                            cellValidMachineByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel2 = rowStatByApps.createCell(1);
                            cellValidMachineByChannel2.setCellValue(list.get(i).getSalerName());
                            cellValidMachineByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel3 = rowStatByApps.createCell(2);
                            cellValidMachineByChannel3.setCellValue(list.get(i).getInstallCounts());
                            cellValidMachineByChannel3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel4 = rowStatByApps.createCell(3);
                            cellValidMachineByChannel4.setCellValue(list.get(i).getArrCounts());
                            cellValidMachineByChannel4.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineByChannel5 = rowStatByApps.createCell(4);
                            cellValidMachineByChannel5.setCellValue(list.get(i).getArrPercentage());
                            cellValidMachineByChannel5.setCellStyle(cellStyleContent);

                        }
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


    public void setProvinceArrStatisManager(ProvinceArrStatisManager provinceArrStatisManager) {
        this.provinceArrStatisManager = provinceArrStatisManager;
    }

    public String getAppCountPath() {
        return appCountPath;
    }

    public void setAppCountPath(String appCountPath) {
        this.appCountPath = appCountPath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
