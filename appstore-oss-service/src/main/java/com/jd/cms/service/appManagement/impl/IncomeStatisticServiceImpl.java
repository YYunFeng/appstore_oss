package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatistic;
import com.jd.cms.domain.systemmaintenance.IncomeStatisticNew;
import com.jd.cms.manager.appManagement.IncomeStatisticManager;
import com.jd.cms.service.appManagement.IncomeStatisticService;
import com.jd.common.web.result.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * YYF on 2015/5/19.
 */
public class IncomeStatisticServiceImpl implements IncomeStatisticService {
    private IncomeStatisticManager incomeStatisticManager;
    private String validMachinePath;
    private String downloadPath;

    public Result provinceIncomeStatistic(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("provinceIncomeStatistic", incomeStatisticManager.provinceIncomeStatistic(incomeParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeStatisticChannelType(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("provinceIncomeStatistic", incomeStatisticManager.incomeStatisticChannelType(incomeParameter));
            result.addDefaultModel("cid", incomeParameter.getCid());
            result.addDefaultModel("channelType", incomeParameter.getChannelType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeSaler(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("provinceIncomeStatistic", incomeStatisticManager.incomeSaler(incomeParameter));
            result.addDefaultModel("channelType", incomeParameter.getChannelType());
            result.addDefaultModel("cid", incomeParameter.getCid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeStatisticBySalerDetails(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("provinceIncomeStatistic", incomeStatisticManager.incomeStatisticBySalerDetails(incomeParameter));
            result.addDefaultModel("channelType", incomeParameter.getChannelType());
            result.addDefaultModel("cid", incomeParameter.getCid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ValidMachineJSON exportExcel(IncomeParameter incomeParameter, Integer flag) {
        ValidMachineJSON validMachineJSON = new ValidMachineJSON();
        try {
            // 创建工作书册
            short height = 400;
            XSSFWorkbook wb = new XSSFWorkbook();
            // 创建Excel的工作sheet，对应到一个Excel文档中的tab
            XSSFSheet sheet = wb.createSheet("统计");

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
            if (flag != null) {
                // incomeStatisticContent
                if (flag.intValue() == 1) {
                    List<IncomeStatisticNew> incomeStatisticNewList = incomeStatisticManager.provinceIncomeStatistic(incomeParameter);
                    if (incomeStatisticNewList != null && incomeStatisticNewList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
                        // 设置第一行的值
                        if (StringUtils.isNotBlank(incomeParameter.getStartTime()) && StringUtils.isNotBlank(incomeParameter.getEndTime())) {
                            cell.setCellValue("公司总收入统计(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
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
                        cell2.setCellValue("安装手机台数\r\n(单位：台)");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("安装应用个数\r\n(单位：个)");
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("有效安装个数\r\n(单位：个)");
                        cell4.setCellStyle(cellStyle);

                        // 开始写入数据
                        for (int i = 0; i < incomeStatisticNewList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByChannel1 = rowStatByApps.createCell(0);
                            cellValidMachineByChannel1.setCellValue(incomeStatisticNewList.get(i).getCname());
                            cellValidMachineByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel2 = rowStatByApps.createCell(1);
                            cellValidMachineByChannel2.setCellValue(incomeStatisticNewList.get(i).getPhoneCounts());
                            cellValidMachineByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel3 = rowStatByApps.createCell(2);
                            cellValidMachineByChannel3.setCellValue(incomeStatisticNewList.get(i).getAppCounts());
                            cellValidMachineByChannel3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel4 = rowStatByApps.createCell(3);
                            cellValidMachineByChannel4.setCellValue(incomeStatisticNewList.get(i).getArriveCounts());
                            cellValidMachineByChannel4.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无结算统计");
                        cell.setCellStyle(cellStyle);
                    }
                    // 按渠道类型查看
                } else if (flag.intValue() == 2) {
                    List<IncomeStatisticNew> incomeStatisticList = incomeStatisticManager.incomeStatisticChannelType(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);

                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        if (StringUtils.isNotBlank(incomeParameter.getStartTime()) && StringUtils.isNotBlank(incomeParameter.getEndTime())) {
                            cell.setCellValue("结算统计--按渠道类型查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
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
                        cell2.setCellValue("渠道类型");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("手机安装台数\r\n(单位：台)");
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("安装应用个数\r\n(单位：个)");
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第五列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("有效安装个数\r\n(单位：个)");
                        cell5.setCellStyle(cellStyle);


                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByChannel1 = rowStatByApps.createCell(0);
                            cellValidMachineByChannel1.setCellValue(incomeStatisticList.get(i).getCname());
                            cellValidMachineByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel2 = rowStatByApps.createCell(1);
                            if (incomeStatisticList.get(i).getChannelType().intValue() == 0) {
                                cellValidMachineByChannel2.setCellValue("分销");
                            } else {
                                cellValidMachineByChannel2.setCellValue("零售");
                            }
                            cellValidMachineByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel3 = rowStatByApps.createCell(2);
                            cellValidMachineByChannel3.setCellValue(incomeStatisticList.get(i).getPhoneCounts());
                            cellValidMachineByChannel3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel4 = rowStatByApps.createCell(3);
                            cellValidMachineByChannel4.setCellValue(incomeStatisticList.get(i).getAppCounts());
                            cellValidMachineByChannel4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel5 = rowStatByApps.createCell(4);
                            cellValidMachineByChannel5.setCellValue(incomeStatisticList.get(i).getArriveCounts());
                            cellValidMachineByChannel5.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无结算统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    //  按促销员查看
                } else if (flag.intValue() == 3) {
                    List<IncomeStatisticNew> incomeStatisticList = incomeStatisticManager.incomeSaler(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
                        // 设置第一行的值
                        if (StringUtils.isNotBlank(incomeParameter.getStartTime()) && StringUtils.isNotBlank(incomeParameter.getEndTime())) {
                            cell.setCellValue("结算统计信息--按促销员查看");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("唯一号");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("姓名");
                        cell2.setCellStyle(cellStyle);


                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("店名");
                        cell3.setCellStyle(cellStyle);


                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("促销员类型");
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("手机安装台数\r\n(单位：台)");
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(5);
                        cell6.setCellValue("安装的应用个数\r\n(单位：个)");
                        cell6.setCellStyle(cellStyle);


                        XSSFCell cell7 = row1.createCell(6);
                        cell7.setCellValue("有效安装个数\r\n(单位：个)");
                        cell7.setCellStyle(cellStyle);


                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineBySale1 = rowStatByApps.createCell(0);
                            cellValidMachineBySale1.setCellValue(incomeStatisticList.get(i).getSalerNo());
                            cellValidMachineBySale1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale2 = rowStatByApps.createCell(1);
                            cellValidMachineBySale2.setCellValue(incomeStatisticList.get(i).getSalerName());
                            cellValidMachineBySale2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale3 = rowStatByApps.createCell(2);
                            cellValidMachineBySale3.setCellValue(incomeStatisticList.get(i).getShopName());
                            cellValidMachineBySale3.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(3);
                            if (incomeStatisticList.get(i).getSalerType() == 0) {
                                cellValidMachineBySale4.setCellValue("督导");
                            } else if (incomeStatisticList.get(i).getSalerType() == 1) {
                                cellValidMachineBySale4.setCellValue("店长");
                            } else if (incomeStatisticList.get(i).getSalerType() == 2) {
                                cellValidMachineBySale4.setCellValue("促销员");
                            }
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(4);
                            cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getPhoneCounts());
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(5);
                            cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getAppCounts());
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale7 = rowStatByApps.createCell(6);
                            cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getArriveCounts());
                            cellValidMachineBySale7.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无结算统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                } else if (flag.intValue() == 4) {
                    List<IncomeStatisticNew> incomeStatisticList = incomeStatisticManager.incomeStatisticBySalerDetails(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
                        // 设置第一行的值
                        if (StringUtils.isNotBlank(incomeParameter.getStartTime()) && StringUtils.isNotBlank(incomeParameter.getEndTime())) {
                            cell.setCellValue("结算统计信息--按店员查看");
                        }

                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("唯一号");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("姓名");
                        cell2.setCellStyle(cellStyle);

                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("店名");
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("促销员类型");
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("安装手机台数\r\n(单位：台)");
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(5);
                        cell6.setCellValue("安装应用个数\r\n(单位：个)");
                        cell6.setCellStyle(cellStyle);


                        XSSFCell cell7 = row1.createCell(6);
                        cell7.setCellValue("有效安装个数\r\n(单位：个)");
                        cell7.setCellStyle(cellStyle);

                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByTime1 = rowStatByApps.createCell(0);
                            cellValidMachineByTime1.setCellValue(incomeStatisticList.get(i).getSalerNo());
                            cellValidMachineByTime1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByTime2 = rowStatByApps.createCell(1);
                            cellValidMachineByTime2.setCellValue(incomeStatisticList.get(i).getSalerName());
                            cellValidMachineByTime2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByTime3 = rowStatByApps.createCell(2);
                            cellValidMachineByTime3.setCellValue(incomeStatisticList.get(i).getShopName());
                            cellValidMachineByTime3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(3);
                            if (incomeStatisticList.get(i).getSalerType() == 0) {
                                cellValidMachineBySale4.setCellValue("督导");
                            } else if (incomeStatisticList.get(i).getSalerType() == 1) {
                                cellValidMachineBySale4.setCellValue("店长");
                            } else if (incomeStatisticList.get(i).getSalerType() == 2) {
                                cellValidMachineBySale4.setCellValue("促销员");
                            }
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(4);
                            cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getPhoneCounts());
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(5);
                            cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getAppCounts());
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale7 = rowStatByApps.createCell(6);
                            cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getArriveCounts());
                            cellValidMachineBySale7.setCellStyle(cellStyleContent);

                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无结算统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                } else if (flag.intValue() == 5) { // 省办每个促销员的统计信息
                    List<IncomeStatisticNew> incomeStatisticList = incomeStatisticManager.getAllSaler(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 8000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.setColumnWidth(7, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
                        // 设置第一行的值
                        if (StringUtils.isNotBlank(incomeParameter.getStartTime()) && StringUtils.isNotBlank(incomeParameter.getEndTime())) {
                            cell.setCellValue("结算统计信息");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);

                        XSSFCell cell7 = row1.createCell(0);
                        cell7.setCellValue("渠道名称");
                        cell7.setCellStyle(cellStyle);

                        XSSFCell cell0 = row1.createCell(1);
                        cell0.setCellValue("唯一号");
                        cell0.setCellStyle(cellStyle);

                        XSSFCell cell1 = row1.createCell(2);
                        cell1.setCellValue("姓名");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(3);
                        cell2.setCellValue("店名");
                        cell2.setCellStyle(cellStyle);


                        XSSFCell cell3 = row1.createCell(4);
                        cell3.setCellValue("促销员类型");
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(5);
                        cell4.setCellValue("安装手机台数\r\n(单位：台)");
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(6);
                        cell5.setCellValue("安装应用个数\r\n(单位：个)");
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(7);
                        cell6.setCellValue("有效安装个数\r\n(单位：个)");
                        cell6.setCellStyle(cellStyle);

                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineBySale = rowStatByApps.createCell(0);
                            cellValidMachineBySale.setCellValue(incomeStatisticList.get(i).getCname());
                            cellValidMachineBySale.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineBySale0 = rowStatByApps.createCell(1);
                            cellValidMachineBySale0.setCellValue(incomeStatisticList.get(i).getSalerNo());
                            cellValidMachineBySale0.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale1 = rowStatByApps.createCell(2);
                            cellValidMachineBySale1.setCellValue(incomeStatisticList.get(i).getSalerName());
                            cellValidMachineBySale1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale2 = rowStatByApps.createCell(3);
                            cellValidMachineBySale2.setCellValue(incomeStatisticList.get(i).getShopName());
                            cellValidMachineBySale2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale3 = rowStatByApps.createCell(4);
                            if (incomeStatisticList.get(i).getSalerType() == 0) {
                                cellValidMachineBySale3.setCellValue("督导");
                            } else if (incomeStatisticList.get(i).getSalerType() == 1) {
                                cellValidMachineBySale3.setCellValue("店长");
                            } else if (incomeStatisticList.get(i).getSalerType() == 2) {
                                cellValidMachineBySale3.setCellValue("促销员");
                            }
                            cellValidMachineBySale3.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(5);
                            cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getPhoneCounts());
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(6);
                            cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getAppCounts());
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(7);
                            cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getArriveCounts());
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无结算统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                }
                String newPath = System.currentTimeMillis() + ".xlsx";
                File installLogExcel = new File(validMachinePath);
                if (!installLogExcel.exists()) {
                    installLogExcel.mkdirs();
                }
                try {
                    FileOutputStream os = new FileOutputStream(validMachinePath + "/" + newPath);
                    wb.write(os);
                    os.close();
                    validMachineJSON.setStatus(1);
                    validMachineJSON.setFileName(downloadPath + "companyIncomeExcel/" + newPath);
                } catch (Exception e) {
                    validMachineJSON.setStatus(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validMachineJSON;
    }

    public String getValidMachinePath() {
        return validMachinePath;
    }

    public void setValidMachinePath(String validMachinePath) {
        this.validMachinePath = validMachinePath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public void setIncomeStatisticManager(IncomeStatisticManager incomeStatisticManager) {
        this.incomeStatisticManager = incomeStatisticManager;
    }
}
