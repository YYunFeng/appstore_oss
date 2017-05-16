package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.ValidMachineJSON;
import com.jd.cms.domain.appManagement.ValidMachineStatistic;
import com.jd.cms.domain.appManagement.ValidMachineStatisticsParameter;
import com.jd.cms.domain.clientmanager.SalerActive;
import com.jd.cms.domain.systemmaintenance.IncomeParameter;
import com.jd.cms.domain.systemmaintenance.IncomeStatistic;
import com.jd.cms.manager.appManagement.SalerActiveManager;
import com.jd.cms.manager.appManagement.ValidMachineStatisticsManager;
import com.jd.cms.manager.appManagement.ValidMachineStatisticsManagerBak1;
import com.jd.cms.manager.appManagement.impl.SalerActiveManagerImpl;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.common.web.result.Result;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by YUNFENG on 14-1-7.
 */
public class ValidMachineStatisticsServiceImpl implements ValidMachineStatisticsService {
    private ValidMachineStatisticsManager validMachineStatisticsManager;
    private SalerActiveManager salerActiveManager;
    private Logger logger = Logger.getLogger(this.getClass());
    private String validMachinePath;
    private String downloadPath;

    public Result totalIncome(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("validMachines", validMachineStatisticsManager.totalIncome(incomeParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeByChannel(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("validMachines", validMachineStatisticsManager.incomeByChannel(incomeParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeByTime(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("validMachines", validMachineStatisticsManager.incomeByTime(incomeParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result incomeBySaler(IncomeParameter incomeParameter) {
        Result result = new Result();
        try {
            result.addDefaultModel("validMachines", validMachineStatisticsManager.incomeBySaler(incomeParameter));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer channelId(Integer userId) {
        return validMachineStatisticsManager.channelId(userId);
    }


    public ValidMachineJSON validMachineExcel(IncomeParameter incomeParameter, Integer flag) {
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
                // 公司总收入统计
                if (flag.intValue() == 0) {
                    IncomeStatistic incomeStatistic = validMachineStatisticsManager.totalIncome(incomeParameter);
                    if (incomeStatistic != null && incomeStatistic.getTotalAppCount().intValue() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
                        // 设置第一行的值
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            cell.setCellValue("公司总收入统计");
                        } else {
                            cell.setCellValue("公司总收入统计(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("装机数\r\n(单位：台)");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell2.setCellValue("精彩推荐应用安装数\r\n(单位：个)");
                        } else {
                            cell2.setCellValue("自有应用安装数\r\n(单位：个)");
                        }
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell3 = row1.createCell(2);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell3.setCellValue("装机必备应用安装数\r\n(单位：个)");
                        } else {
                            cell3.setCellValue("华盛应用安装数\r\n(单位：个)");
                        }
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell4 = row1.createCell(3);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell4.setCellValue("精彩推荐应用收入\r\n(单位：元)");
                        } else {
                            cell4.setCellValue("自有应用收入\r\n(单位：元)");
                        }
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell5 = row1.createCell(4);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell5.setCellValue("装机必备应用收入\r\n(单位：元)");
                        } else {
                            cell5.setCellValue("华盛应用收入\r\n(单位：元)");
                        }
                        cell5.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell6 = row1.createCell(5);
                        cell6.setCellValue("应用总收入\r\n(单位：元)");
                        cell6.setCellStyle(cellStyle);

                        //     开始写入数据
                        XSSFRow rowStatByApps = sheet.createRow(2);
                        rowStatByApps.setHeight(height);
                        XSSFCell cellValidMachineTotal1 = rowStatByApps.createCell(0);
                        cellValidMachineTotal1.setCellValue(incomeStatistic.getVaildMachineCounts());
                        cellValidMachineTotal1.setCellStyle(cellStyleContent);

                        XSSFCell cellValidMachineTotal2 = rowStatByApps.createCell(1);
                        cellValidMachineTotal2.setCellValue(incomeStatistic.getMineAppCounts());
                        cellValidMachineTotal2.setCellStyle(cellStyleContent);

                        XSSFCell cellValidMachineTotal3 = rowStatByApps.createCell(2);
                        cellValidMachineTotal3.setCellValue(incomeStatistic.getHuashengAppCounts());
                        cellValidMachineTotal3.setCellStyle(cellStyleContent);

                        XSSFCell cellValidMachineTotal4 = rowStatByApps.createCell(3);
                        cellValidMachineTotal4.setCellValue(incomeStatistic.getRecommendAppIncomeForCompany());
                        cellValidMachineTotal4.setCellStyle(cellStyleContent);


                        XSSFCell cellValidMachineTotal5 = rowStatByApps.createCell(4);
                        cellValidMachineTotal5.setCellValue(incomeStatistic.getNeedAppIncomeForCompany());
                        cellValidMachineTotal5.setCellStyle(cellStyleContent);

                        XSSFCell cellValidMachineTotal6 = rowStatByApps.createCell(5);
                        cellValidMachineTotal6.setCellValue(incomeStatistic.getTotalIncome());
                        cellValidMachineTotal6.setCellStyle(cellStyleContent);
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无公司总收入统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    // 按渠道查看
                } else if (flag.intValue() == 1) {
                    List<IncomeStatistic> incomeStatisticList = validMachineStatisticsManager.incomeByChannel(incomeParameter);
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
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            //  省办
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按渠道查看");
                            }
                        } else {
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按渠道查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            }
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
                        cell2.setCellValue("装机数\r\n(单位：台)");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell3.setCellValue("精彩推荐应用安装数\r\n(单位：个)");
                        } else {
                            cell3.setCellValue("自有应用安装数\r\n(单位：个)");
                        }
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell4.setCellValue("装机必备应用安装数\r\n(单位：个)");
                        } else {
                            cell4.setCellValue("华盛应用安装数\r\n(单位：个)");
                        }
                        cell4.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第五列
                        XSSFCell cell5 = row1.createCell(4);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell5.setCellValue("精彩推荐应用收入\r\n(单位：元)");
                        } else {
                            cell5.setCellValue("自有应用收入\r\n(单位：元)");
                        }
                        cell5.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第六列
                        XSSFCell cell6 = row1.createCell(5);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell6.setCellValue("装机必备应用收入\r\n(单位：元)");
                        } else {
                            cell6.setCellValue("华盛应用收入\r\n(单位：元)");
                        }
                        cell6.setCellStyle(cellStyle);

                        XSSFCell cell7 = row1.createCell(6);
                        cell7.setCellValue("应用总收入\r\n(单位：元)");
                        cell7.setCellStyle(cellStyle);


                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByChannel1 = rowStatByApps.createCell(0);
                            cellValidMachineByChannel1.setCellValue(incomeStatisticList.get(i).getCname());
                            cellValidMachineByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel2 = rowStatByApps.createCell(1);
                            cellValidMachineByChannel2.setCellValue(incomeStatisticList.get(i).getVaildMachineCounts());
                            cellValidMachineByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel3 = rowStatByApps.createCell(2);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByChannel3.setCellValue(incomeStatisticList.get(i).getRecommendAppCounts());
                            } else {
                                cellValidMachineByChannel3.setCellValue(incomeStatisticList.get(i).getMineAppCounts());
                            }
                            cellValidMachineByChannel3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel4 = rowStatByApps.createCell(3);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByChannel4.setCellValue(incomeStatisticList.get(i).getNeedAppCounts());
                            } else {
                                cellValidMachineByChannel4.setCellValue(incomeStatisticList.get(i).getHuashengAppCounts());
                            }
                            cellValidMachineByChannel4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel5 = rowStatByApps.createCell(4);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByChannel5.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForProvince());
                            } else {
                                cellValidMachineByChannel5.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForCompany());
                            }
                            cellValidMachineByChannel5.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineByChannel6 = rowStatByApps.createCell(5);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByChannel6.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForProvince());
                            } else {
                                cellValidMachineByChannel6.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForCompany());
                            }
                            cellValidMachineByChannel6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByChannel7 = rowStatByApps.createCell(6);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByChannel7.setCellValue(incomeStatisticList.get(i).getTotalIncomeProvince());
                            } else {
                                cellValidMachineByChannel7.setCellValue(incomeStatisticList.get(i).getTotalIncome());
                            }
                            cellValidMachineByChannel7.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无收入统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    //  按促销员查看
                } else if (flag.intValue() == 2) {
                    List<IncomeStatistic> incomeStatisticList = validMachineStatisticsManager.incomeBySaler(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.setColumnWidth(7, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
                        // 设置第一行的值
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息--按促销员查看");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按促销员查看");
                            }
                        } else {
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息--按促销员查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按促销员查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            }
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("促销员编号");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("促销员名称");
                        cell2.setCellStyle(cellStyle);


                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("装机数\r\n(单位：台)");
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(3);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell4.setCellValue("精彩推荐应用安装数\r\n(单位：个)");
                        } else {
                            cell4.setCellValue("自有应用安装数\r\n(单位：个)");
                        }
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(4);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell5.setCellValue("装机必备应用安装数\r\n(单位：个)");
                        } else {
                            cell5.setCellValue("华盛应用安装数\r\n(单位：个)");
                        }
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(5);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell6.setCellValue("精彩推荐应用收入\r\n(单位：元)");
                        } else {
                            cell6.setCellValue("自有应用收入\r\n(单位：元)");
                        }
                        cell6.setCellStyle(cellStyle);


                        XSSFCell cell7 = row1.createCell(6);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell7.setCellValue("装机必备应用收入\r\n(单位：元)");
                        } else {
                            cell7.setCellValue("华盛应用收入\r\n(单位：元)");
                        }
                        cell7.setCellStyle(cellStyle);


                        XSSFCell cell8 = row1.createCell(7);
                        cell8.setCellValue("应用总收入\r\n(单位：元)");
                        cell8.setCellStyle(cellStyle);


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
                            cellValidMachineBySale3.setCellValue(incomeStatisticList.get(i).getVaildMachineCounts());
                            cellValidMachineBySale3.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(3);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getRecommendAppCounts());
                            } else {
                                cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getMineAppCounts());
                            }
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(4);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getNeedAppCounts());
                            } else {
                                cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getHuashengAppCounts());
                            }
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(5);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForProvince());
                            } else {
                                cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForCompany());
                            }
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale7 = rowStatByApps.createCell(6);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForProvince());
                            } else {
                                cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForCompany());
                            }
                            cellValidMachineBySale7.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale8 = rowStatByApps.createCell(7);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale8.setCellValue(incomeStatisticList.get(i).getTotalIncomeProvince());
                            } else {
                                cellValidMachineBySale8.setCellValue(incomeStatisticList.get(i).getTotalIncome());
                            }
                            cellValidMachineBySale8.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无收入统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    //   按日期查看
                } else if (flag.intValue() == 3) {
                    List<IncomeStatistic> incomeStatisticList = validMachineStatisticsManager.incomeByTime(incomeParameter);
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
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息--按日期查看");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按日期查看");
                            }
                        } else {
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cell.setCellValue("省办收入统计信息--按日期查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            } else {
                                cell.setCellValue("公司总收入统计信息--按日期查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                            }
                        }

                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("日期");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("装机数\r\n(单位：台)");
                        cell2.setCellStyle(cellStyle);

                        XSSFCell cell3 = row1.createCell(2);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell3.setCellValue("精彩推荐应用安装数\r\n(单位：个)");
                        } else {
                            cell3.setCellValue("自有应用安装数\r\n(单位：个)");
                        }
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(3);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell4.setCellValue("装机必备应用安装数\r\n(单位：个)");
                        } else {
                            cell4.setCellValue("华盛应用安装数\r\n(单位：个)");
                        }
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(4);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell5.setCellValue("精彩推荐应用收入\r\n(单位：元)");
                        } else {
                            cell5.setCellValue("自有应用收入\r\n(单位：元)");
                        }
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(5);
                        if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                            cell6.setCellValue("装机必备应用收入\r\n(单位：元)");
                        } else {
                            cell6.setCellValue("华盛应用收入\r\n(单位：元)");
                        }
                        cell6.setCellStyle(cellStyle);


                        XSSFCell cell7 = row1.createCell(6);
                        cell7.setCellValue("应用总收入\r\n(单位：元)");
                        cell7.setCellStyle(cellStyle);

                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellValidMachineByTime1 = rowStatByApps.createCell(0);
                            cellValidMachineByTime1.setCellValue(incomeStatisticList.get(i).getInstallTime());
                            cellValidMachineByTime1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByTime2 = rowStatByApps.createCell(1);
                            cellValidMachineByTime2.setCellValue(incomeStatisticList.get(i).getVaildMachineCounts());
                            cellValidMachineByTime2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineByTime3 = rowStatByApps.createCell(2);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineByTime3.setCellValue(incomeStatisticList.get(i).getRecommendAppCounts());
                            } else {
                                cellValidMachineByTime3.setCellValue(incomeStatisticList.get(i).getMineAppCounts());
                            }
                            cellValidMachineByTime3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(3);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getNeedAppCounts());
                            } else {
                                cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getHuashengAppCounts());

                            }
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(4);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForProvince());
                            } else {
                                cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForCompany());
                            }
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(5);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForProvince());
                            } else {
                                cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForCompany());
                            }
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale7 = rowStatByApps.createCell(6);
                            if (incomeParameter.getExcelFlag() != null && incomeParameter.getExcelFlag().intValue() == 1) {
                                cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getTotalIncomeProvince());
                            } else {
                                cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getTotalIncome());
                            }
                            cellValidMachineBySale7.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无收入统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                } else if (flag.intValue() == 4) { // 省办每个促销员的统计信息
                    List<IncomeStatistic> incomeStatisticList = validMachineStatisticsManager.getAllSaler(incomeParameter);
                    if (incomeStatisticList != null && incomeStatisticList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.setColumnWidth(7, 5000);
                        sheet.setColumnWidth(8, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
                        // 设置第一行的值
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            cell.setCellValue("省办收入统计信息--按促销员查看");

                        } else {
                            cell.setCellValue("省办收入统计信息--按促销员查看(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell0 = row1.createCell(0);
                        cell0.setCellValue("省份");
                        cell0.setCellStyle(cellStyle);

                        XSSFCell cell1 = row1.createCell(1);
                        cell1.setCellValue("促销员编号");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(2);
                        cell2.setCellValue("促销员名称");
                        cell2.setCellStyle(cellStyle);


                        XSSFCell cell3 = row1.createCell(3);
                        cell3.setCellValue("装机数\r\n(单位：台)");
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(4);
                        cell4.setCellValue("精彩推荐应用安装数\r\n(单位：个)");
                        cell4.setCellStyle(cellStyle);

                        XSSFCell cell5 = row1.createCell(5);
                        cell5.setCellValue("装机必备应用安装数\r\n(单位：个)");
                        cell5.setCellStyle(cellStyle);

                        XSSFCell cell6 = row1.createCell(6);
                        cell6.setCellValue("精彩推荐应用收入\r\n(单位：元)");
                        cell6.setCellStyle(cellStyle);


                        XSSFCell cell7 = row1.createCell(7);
                        cell7.setCellValue("装机必备应用收入\r\n(单位：元)");
                        cell7.setCellStyle(cellStyle);


                        XSSFCell cell8 = row1.createCell(8);
                        cell8.setCellValue("应用总收入\r\n(单位：元)");
                        cell8.setCellStyle(cellStyle);


                        for (int i = 0; i < incomeStatisticList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);


                            XSSFCell cellValidMachineBySale0 = rowStatByApps.createCell(0);
                            cellValidMachineBySale0.setCellValue(incomeStatisticList.get(i).getCname());
                            cellValidMachineBySale0.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale1 = rowStatByApps.createCell(1);
                            cellValidMachineBySale1.setCellValue(incomeStatisticList.get(i).getSalerNo());
                            cellValidMachineBySale1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale2 = rowStatByApps.createCell(2);
                            cellValidMachineBySale2.setCellValue(incomeStatisticList.get(i).getSalerName());
                            cellValidMachineBySale2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale3 = rowStatByApps.createCell(3);
                            cellValidMachineBySale3.setCellValue(incomeStatisticList.get(i).getVaildMachineCounts());
                            cellValidMachineBySale3.setCellStyle(cellStyleContent);


                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(4);
                            cellValidMachineBySale4.setCellValue(incomeStatisticList.get(i).getRecommendAppCounts());
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale5 = rowStatByApps.createCell(5);
                            cellValidMachineBySale5.setCellValue(incomeStatisticList.get(i).getNeedAppCounts());
                            cellValidMachineBySale5.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale6 = rowStatByApps.createCell(6);
                            cellValidMachineBySale6.setCellValue(incomeStatisticList.get(i).getRecommendAppIncomeForProvince());
                            cellValidMachineBySale6.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale7 = rowStatByApps.createCell(7);
                            cellValidMachineBySale7.setCellValue(incomeStatisticList.get(i).getNeedAppIncomeForProvince());
                            cellValidMachineBySale7.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale8 = rowStatByApps.createCell(8);
                            cellValidMachineBySale8.setCellValue(incomeStatisticList.get(i).getTotalIncomeProvince());
                            cellValidMachineBySale8.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无收入统计信息");
                        cell.setCellStyle(cellStyle);
                    }
                    // 促销员活跃度统计
                } else if (flag.intValue() == 5) {
                    List<SalerActive> salerActiveList = salerActiveManager.salerActive(0, 0, incomeParameter.getStartTime(), incomeParameter.getEndTime(), 1, incomeParameter.getCid());
                    if (salerActiveList != null && salerActiveList.size() > 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        if (incomeParameter.getStartTime() == null || incomeParameter.getStartTime() == null || incomeParameter.getStartTime().equals("") || incomeParameter.getEndTime().equals("")) {
                            cell.setCellValue("促销员活跃度统计");

                        } else {
                            cell.setCellValue("促销员活跃度统计(" + incomeParameter.getStartTime() + "至" + incomeParameter.getEndTime() + ")");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);
                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight((short) 700);
                        XSSFCell cell0 = row1.createCell(0);
                        cell0.setCellValue("省份");
                        cell0.setCellStyle(cellStyle);

                        XSSFCell cell1 = row1.createCell(1);
                        cell1.setCellValue("促销员");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(2);
                        cell2.setCellValue("唯一号");
                        cell2.setCellStyle(cellStyle);


                        XSSFCell cell3 = row1.createCell(3);
                        cell3.setCellValue("装机数量\r\n(单位：个)");
                        cell3.setCellStyle(cellStyle);

                        XSSFCell cell4 = row1.createCell(4);
                        cell4.setCellValue("活跃度");
                        cell4.setCellStyle(cellStyle);


                        for (int i = 0; i < salerActiveList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);


                            XSSFCell cellValidMachineBySale0 = rowStatByApps.createCell(0);
                            cellValidMachineBySale0.setCellValue(salerActiveList.get(i).getChannelName());
                            cellValidMachineBySale0.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale1 = rowStatByApps.createCell(1);
                            cellValidMachineBySale1.setCellValue(salerActiveList.get(i).getSalerName());
                            cellValidMachineBySale1.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale2 = rowStatByApps.createCell(2);
                            cellValidMachineBySale2.setCellValue(salerActiveList.get(i).getSaler());
                            cellValidMachineBySale2.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale3 = rowStatByApps.createCell(3);
                            cellValidMachineBySale3.setCellValue(salerActiveList.get(i).getPhoneTimes());
                            cellValidMachineBySale3.setCellStyle(cellStyleContent);

                            XSSFCell cellValidMachineBySale4 = rowStatByApps.createCell(4);
                            cellValidMachineBySale4.setCellValue(salerActiveList.get(i).getActiveDayPercentage());
                            cellValidMachineBySale4.setCellStyle(cellStyleContent);
                        }
                    } else {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
                        cell.setCellValue("暂无促销员活跃度信息");
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
                    logger.error("创建Excel失败，失败原因：" + e.getMessage());
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


    public void setSalerActiveManager(SalerActiveManager salerActiveManager) {
        this.salerActiveManager = salerActiveManager;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public void setValidMachineStatisticsManager(ValidMachineStatisticsManager validMachineStatisticsManager) {
        this.validMachineStatisticsManager = validMachineStatisticsManager;
    }
}
