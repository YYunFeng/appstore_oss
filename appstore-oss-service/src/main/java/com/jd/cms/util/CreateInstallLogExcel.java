package com.jd.cms.util;


import com.jd.cms.domain.appManagement.MarketStatOutput;
import com.jd.cms.manager.appManagement.MarketStatisticsManager;
import com.jd.common.util.PaginatedList;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;


/**
 * User: YUNFENG
 * Date: 13-3-28
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class CreateInstallLogExcel {
    private Logger logger = Logger.getLogger(this.getClass());
    private MarketStatisticsManager marketStatisticsManager;
    private String downloadPath;
    private static final String INSTALLTIMES = "安裝量（次）";
    private static final String ALLINSTALLTIMES = "总安装量（次）";
    private static final String APPSNAME = "应用名称";
    private static final String CHANNELNAME = "渠道名称";
    private static final String PHONEINSTALLCOUNT = "安装手机台数（台）";
    private static final String SALERNO = "促销员编号";
    private static final String SALERNAME = "操作员";
    private static final String SHOPNAME = "门店名称";
    private static final String ACTIVEDAYS = "活跃天数";
    private static final String LEVEL = "促销员类别";
    private static final String PHONENUMBER = "手机号码";

    public String CreateInstallLogExcel(String startTime, String endTime, Integer appId, Integer channelId, String saler, Integer methodFlag, Integer flag) {
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
        cellStyle.setFont(fontContent);
        cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(180, 198, 231)));
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        // 单元格属性 --内容属性content
        XSSFCellStyle cellStyleContent = wb.createCellStyle();
        cellStyleContent.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleContent.setFont(fontContent);
        String appType = null;
        if (methodFlag != null) {
            // 离线应用
            if (flag != null && flag.intValue() == 0) {
                appType = "离线应用";
            }
            if (flag != null && flag.intValue() == 1) {
                appType = "在线应用";
            }
            // 统计应用的总安装量
            if (methodFlag.intValue() == 0) {
                logger.info("统计应用的总安装量导出报表");
                try {
                    MarketStatOutput allTnstallTimes = marketStatisticsManager.getMarketStat(startTime, endTime, flag);
                    if (allTnstallTimes != null) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + "-应用安装总量");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行                                                            l
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);

                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(PHONEINSTALLCOUNT);
                        cell1.setCellStyle(cellStyle);

                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(ALLINSTALLTIMES);
                        cell2.setCellStyle(cellStyle);

                        XSSFRow row2 = sheet.createRow(2);
                        row2.setHeight(height);
                        XSSFCell cell3 = row2.createCell(0);
                        cell3.setCellValue(allTnstallTimes.getPhoneTimes());
                        cell3.setCellStyle(cellStyleContent);

                        XSSFCell cell4 = row2.createCell(1);
                        cell4.setCellValue(allTnstallTimes.getInstallTimes());
                        cell4.setCellStyle(cellStyleContent);
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e1) {
                    logger.error("导出报表：统计应用的总安装量失败，失败原因：" + e1.getMessage());
                }
            }
            // 按应用查看
            if (methodFlag.intValue() == 1) {
                // 查询数据
                try {
                    logger.info("按应用查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.statByApp(startTime, endTime, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + "-按应用查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(APPSNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);


                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellStatByApps1 = rowStatByApps.createCell(0);
                            cellStatByApps1.setCellValue(marketStatOutputs.get(i).getAppName());
                            cellStatByApps1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps2 = rowStatByApps.createCell(1);
                            cellStatByApps2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellStatByApps2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps3 = rowStatByApps.createCell(2);
                            cellStatByApps3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellStatByApps3.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e2) {
                    logger.error("导出报表：按应用查看失败，失败原因：" + e2.getMessage());
                }
            }
            //按应用查看 --> 按渠道查看
            if (methodFlag.intValue() == 2) {
                try {
                    logger.info("按应用查看 --> 按渠道查看");
                    // 查询数据
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.appGetMarketStatByChannel(startTime, endTime, appId, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + "," + marketStatOutputs.get(0).getAppName() + "按渠道查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(CHANNELNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);

                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowAppGetMarketStatByChannel = sheet.createRow(i + 2);
                            rowAppGetMarketStatByChannel.setHeight(height);

                            XSSFCell cellAppGetMarketStatByChannel1 = rowAppGetMarketStatByChannel.createCell(0);
                            cellAppGetMarketStatByChannel1.setCellValue(marketStatOutputs.get(i).getPadName());
                            cellAppGetMarketStatByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellAppGetMarketStatByChannel2 = rowAppGetMarketStatByChannel.createCell(1);
                            cellAppGetMarketStatByChannel2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellAppGetMarketStatByChannel2.setCellStyle(cellStyleContent);


                            XSSFCell cellAppGetMarketStatByChannel3 = rowAppGetMarketStatByChannel.createCell(2);
                            cellAppGetMarketStatByChannel3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellAppGetMarketStatByChannel3.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e4) {
                    logger.error("导出报表：按应用查看 --> 按渠道查看失败，失败原因：" + e4.getMessage());
                }
            }
            //按应用查看 --> 按渠道查看 -->按促销员查看
            if (methodFlag.intValue() == 3) {
                try {
                    logger.info("按应用查看 --> 按渠道查看 -->按促销员查看");
                    // 查询数据
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.appStatsChannelBySaler(startTime, endTime, appId, channelId, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + "," + marketStatOutputs.get(0).getAppName() + marketStatOutputs.get(0).getPadName() + "下按促销员查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(SALERNO);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue(SALERNAME);
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue(SHOPNAME);
                        cell5.setCellStyle(cellStyle);


                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowAppGetMarketStatByChannel = sheet.createRow(i + 2);
                            rowAppGetMarketStatByChannel.setHeight(height);

                            XSSFCell cellChannelStatBySaler1 = rowAppGetMarketStatByChannel.createCell(0);
                            cellChannelStatBySaler1.setCellValue(marketStatOutputs.get(i).getSaler());
                            cellChannelStatBySaler1.setCellStyle(cellStyleContent);

                            XSSFCell cellChannelStatBySaler2 = rowAppGetMarketStatByChannel.createCell(1);
                            cellChannelStatBySaler2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellChannelStatBySaler2.setCellStyle(cellStyleContent);

                            XSSFCell cellChannelStatBySaler3 = rowAppGetMarketStatByChannel.createCell(2);
                            cellChannelStatBySaler3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellChannelStatBySaler3.setCellStyle(cellStyleContent);

                            XSSFCell cellChannelStatBySaler4 = rowAppGetMarketStatByChannel.createCell(3);
                            cellChannelStatBySaler4.setCellValue(marketStatOutputs.get(i).getSalerName());
                            cellChannelStatBySaler4.setCellStyle(cellStyleContent);


                            XSSFCell cellChannelStatBySaler5 = rowAppGetMarketStatByChannel.createCell(4);
                            cellChannelStatBySaler5.setCellValue(marketStatOutputs.get(i).getShopName());
                            cellChannelStatBySaler5.setCellStyle(cellStyleContent);


                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e5) {
                    logger.error("导出报表：按应用查看 --> 按渠道查看 -->按促销员查看失败，失败原因：" + e5.getMessage());
                }
            }
            //按渠道查看
            if (methodFlag.intValue() == 4) {
                try {
                    logger.info("按渠道查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.statByChannel(startTime, endTime, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + ",按渠道查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(CHANNELNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);

                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowStatByChannel = sheet.createRow(i + 2);
                            rowStatByChannel.setHeight(height);

                            XSSFCell cellStatByChannel1 = rowStatByChannel.createCell(0);
                            cellStatByChannel1.setCellValue(marketStatOutputs.get(i).getPadName());
                            cellStatByChannel1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByChannel2 = rowStatByChannel.createCell(1);
                            cellStatByChannel2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellStatByChannel2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByChannel3 = rowStatByChannel.createCell(2);
                            cellStatByChannel3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellStatByChannel3.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e6) {
                    logger.error("导出报表：按渠道查看失败，失败原因：" + e6.getMessage());
                }
            }
            // 按渠道查看 -->按应用查看
            if (methodFlag.intValue() == 5) {
                try {
                    logger.info("按渠道查看 -->按应用查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.statChannelByApps(startTime, endTime, channelId, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + marketStatOutputs.get(0).getPadName() + "下，按应用查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(APPSNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);

                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowStatChannelByApps = sheet.createRow(i + 2);
                            rowStatChannelByApps.setHeight(height);

                            XSSFCell cellStatByChannelByApps1 = rowStatChannelByApps.createCell(0);
                            cellStatByChannelByApps1.setCellValue(marketStatOutputs.get(i).getAppName());
                            cellStatByChannelByApps1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByChannelByApps2 = rowStatChannelByApps.createCell(1);
                            cellStatByChannelByApps2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellStatByChannelByApps2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByChannelByApps3 = rowStatChannelByApps.createCell(2);
                            cellStatByChannelByApps3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellStatByChannelByApps3.setCellStyle(cellStyleContent);
                        }

                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e7) {
                    logger.error("导出按渠道查看 -->按应用查看失败,失败原因，" + e7.getMessage());
                }
            }
            // 按渠道查看 -->按应用查看-->按促销员查看
            if (methodFlag.intValue() == 6) {
                try {
                    logger.info("按渠道查看 -->按应用查看-->按促销员查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.appStatsChannelBySaler(startTime, endTime, appId, channelId, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + marketStatOutputs.get(0).getPadName() + "," + marketStatOutputs.get(0).getAppName() + "下，按促销员查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(SALERNO);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue(SALERNAME);
                        cell4.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第五列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue(SHOPNAME);
                        cell5.setCellStyle(cellStyle);


                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow rowAppStatsChannelBySaler = sheet.createRow(i + 2);
                            rowAppStatsChannelBySaler.setHeight(height);

                            XSSFCell cellAppStatsChannelBySaler1 = rowAppStatsChannelBySaler.createCell(0);
                            cellAppStatsChannelBySaler1.setCellValue(marketStatOutputs.get(i).getSaler());
                            cellAppStatsChannelBySaler1.setCellStyle(cellStyleContent);

                            XSSFCell cellAppStatsChannelBySaler2 = rowAppStatsChannelBySaler.createCell(1);
                            cellAppStatsChannelBySaler2.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cellAppStatsChannelBySaler2.setCellStyle(cellStyleContent);

                            XSSFCell cellAppStatsChannelBySaler3 = rowAppStatsChannelBySaler.createCell(2);
                            cellAppStatsChannelBySaler3.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cellAppStatsChannelBySaler3.setCellStyle(cellStyleContent);

                            XSSFCell cellAppStatsChannelBySaler4 = rowAppStatsChannelBySaler.createCell(3);
                            cellAppStatsChannelBySaler4.setCellValue(marketStatOutputs.get(i).getSalerName());
                            cellAppStatsChannelBySaler4.setCellStyle(cellStyleContent);

                            XSSFCell cellAppStatsChannelBySaler5 = rowAppStatsChannelBySaler.createCell(4);
                            cellAppStatsChannelBySaler5.setCellValue(marketStatOutputs.get(i).getShopName());
                            cellAppStatsChannelBySaler5.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e8) {
                    logger.error("导出报表：按渠道查看 -->按应用查看-->按促销员查看失败，失败原因：" + e8.getMessage());
                }
            }
            // 按渠道查看 -->按促销员查看
            if (methodFlag.intValue() == 7) {
                try {
                    logger.info("导出报表按渠道查看 -->按促销员查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.channlStatBySaler(startTime, endTime, channelId, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);
                        sheet.setColumnWidth(6, 5000);
                        sheet.setColumnWidth(7, 5000);
                        sheet.setColumnWidth(8, 5000);
                        sheet.setColumnWidth(9, 5000);
                        sheet.setColumnWidth(10, 5000);
                        sheet.setColumnWidth(11, 5000);
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + marketStatOutputs.get(0).getPadName() + "下，按促销员查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(SALERNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("省份");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell5 = row1.createCell(2);
                        cell5.setCellValue("城市");
                        cell5.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell6 = row1.createCell(3);
                        cell6.setCellValue(SHOPNAME);
                        cell6.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第五列
                        XSSFCell cell7 = row1.createCell(4);
                        cell7.setCellValue(LEVEL);
                        cell7.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第六列
                        XSSFCell cell11 = row1.createCell(5);
                        cell11.setCellValue(PHONENUMBER);
                        cell11.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第七列
                        XSSFCell cell12 = row1.createCell(6);
                        cell12.setCellValue(INSTALLTIMES);
                        cell12.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第八列
                        XSSFCell cell13 = row1.createCell(7);
                        cell13.setCellValue("安装软件平均数");
                        cell13.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第九列
                        XSSFCell cell14 = row1.createCell(8);
                        cell14.setCellValue("安装手机台数");
                        cell14.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第十列
                        XSSFCell cell15 = row1.createCell(9);
                        cell15.setCellValue(ACTIVEDAYS);
                        cell15.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第十一列
                        XSSFCell cell16 = row1.createCell(10);
                        cell16.setCellValue("日安装手机数");
                        cell16.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第十一列
                        XSSFCell cell17 = row1.createCell(11);
                        cell17.setCellValue("排名");
                        cell17.setCellStyle(cellStyle);

                        DecimalFormat df = new DecimalFormat(".#");
                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            if (!marketStatOutputs.get(i).getSaler().equals("1")) {
                                XSSFRow row2 = sheet.createRow(i + 2);
                                row2.setHeight(height);

                                XSSFCell cell3 = row2.createCell(0);
                                cell3.setCellValue(marketStatOutputs.get(i).getSalerName());
                                cell3.setCellStyle(cellStyleContent);

                                XSSFCell cell4 = row2.createCell(1);
                                cell4.setCellValue("上海");
                                cell4.setCellStyle(cellStyleContent);

                                XSSFCell cell8 = row2.createCell(2);
                                cell8.setCellValue("上海");
                                cell8.setCellStyle(cellStyleContent);

                                XSSFCell cell9 = row2.createCell(3);
                                cell9.setCellValue(marketStatOutputs.get(i).getShopName());
                                cell9.setCellStyle(cellStyleContent);

                                XSSFCell cell10 = row2.createCell(4);
                                cell10.setCellValue(marketStatOutputs.get(i).getLevel());
                                cell10.setCellStyle(cellStyleContent);


                                XSSFCell cellChannelStatBySaler6 = row2.createCell(5);
                                cellChannelStatBySaler6.setCellType(HSSFCell.CELL_TYPE_ERROR);
                                if (marketStatOutputs.get(i).getPhoneNumber() != null) {
                                    cellChannelStatBySaler6.setCellValue(marketStatOutputs.get(i).getPhoneNumber());
                                } else {
                                    cellChannelStatBySaler6.setCellValue("");
                                }
                                cellChannelStatBySaler6.setCellStyle(cellStyleContent);

                                XSSFCell cellChannelStatBySaler7 = row2.createCell(6);
                                cellChannelStatBySaler7.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                                cellChannelStatBySaler7.setCellStyle(cellStyleContent);


                                XSSFCell cellChannelStatBySaler8 = row2.createCell(7);
                                cellChannelStatBySaler8.setCellValue(Double.valueOf(df.format((double) marketStatOutputs.get(i).getInstallTimes() / (double) marketStatOutputs.get(i).getPhoneTimes())));
                                cellChannelStatBySaler8.setCellStyle(cellStyleContent);


                                XSSFCell cellChannelStatBySaler9 = row2.createCell(8);
                                cellChannelStatBySaler9.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                                cellChannelStatBySaler9.setCellStyle(cellStyleContent);


                                XSSFCell cellChannelStatBySaler10 = row2.createCell(9);
                                cellChannelStatBySaler10.setCellValue(marketStatOutputs.get(i).getActiveDays());
                                cellChannelStatBySaler10.setCellStyle(cellStyleContent);

                                XSSFCell cellChannelStatBySaler11 = row2.createCell(10);
                                cellChannelStatBySaler11.setCellValue(Double.valueOf(df.format((double) marketStatOutputs.get(i).getPhoneTimes() / (double) marketStatOutputs.get(i).getActiveDays())));
                                cellChannelStatBySaler11.setCellStyle(cellStyleContent);


                                XSSFCell cellChannelStatBySaler12 = row2.createCell(11);
                                cellChannelStatBySaler12.setCellValue(i + 1);
                                cellChannelStatBySaler12.setCellStyle(cellStyleContent);
                            } else {
                                marketStatOutputs.remove(i);
                                i--;
                            }
                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e9) {
                    logger.error("导出报表：按渠道查看 -->按促销员查看失败，失败原因：" + e9.getMessage());
                }
            }
            // 按渠道查看 -->按促销员查看-->按应用查看
            if (methodFlag.intValue() == 8) {
                try {
                    logger.info("导出报表：按渠道查看 -->按促销员查看-->按应用查看");
                    PaginatedList<MarketStatOutput> marketStatOutputs = marketStatisticsManager.salerStatsByApps(startTime, endTime, channelId, saler, 0, 0, flag, 1);
                    if (marketStatOutputs != null && marketStatOutputs.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
                        // 设置第一行的值
                        cell.setCellValue(startTime + "至" + endTime + "," + appType + marketStatOutputs.get(0).getPadName() + marketStatOutputs.get(0).getSaler() + "按应用查看");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue(APPSNAME);
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue(PHONEINSTALLCOUNT);
                        cell2.setCellStyle(cellStyle);

                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue(INSTALLTIMES);
                        cell3.setCellStyle(cellStyle);


                        for (int i = 0; i < marketStatOutputs.size(); i++) {
                            XSSFRow row2 = sheet.createRow(i + 2);
                            row2.setHeight(height);

                            XSSFCell cell6 = row2.createCell(0);
                            cell6.setCellValue(marketStatOutputs.get(i).getAppName());
                            cell6.setCellStyle(cellStyleContent);

                            XSSFCell cell7 = row2.createCell(1);
                            cell7.setCellValue(marketStatOutputs.get(i).getPhoneTimes());
                            cell7.setCellStyle(cellStyleContent);

                            XSSFCell cell8 = row2.createCell(2);
                            cell8.setCellValue(marketStatOutputs.get(i).getInstallTimes());
                            cell8.setCellStyle(cellStyleContent);

                        }
                    } else {
                        cell.setCellValue(startTime + "至" + endTime + appType + "暂无安装日志");
                        cell.setCellStyle(cellStyle);
                    }
                } catch (Exception e10) {
                    logger.error("导出报表：按渠道查看 -->按促销员查看-->按应用查看失败，" + e10.getMessage());
                }
            }
        }
        String newPath = startTime + endTime + System.currentTimeMillis() + ".xlsx";
        String targetDirectory = marketStatisticsManager.getInstallLogExcelPath();
        File installLogExcel = new File(targetDirectory);
        if (!installLogExcel.exists()) {
            installLogExcel.mkdirs();
            logger.info("目录不存在，创建新目录：" + targetDirectory);
        }
        try {
            FileOutputStream os = new FileOutputStream(targetDirectory + "/" + newPath);
            wb.write(os);
            os.close();
        } catch (Exception e) {
            logger.error("创建Excel失败，失败原因：" + e.getMessage());
        }
        logger.info(downloadPath + "installlogExcel/" + newPath);
        return downloadPath + "installlogExcel/" + newPath;
    }

    public void setMarketStatisticsManager(MarketStatisticsManager marketStatisticsManager) {
        this.marketStatisticsManager = marketStatisticsManager;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}
