package com.jd.cms.util;

import com.jd.cms.domain.appManagement.*;
import com.jd.cms.manager.appManagement.SalesStatisticsManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-24
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class StatisticsExcel {
    private Logger logger = Logger.getLogger(this.getClass());
    private SalesStatisticsManager salesStatisticsManager;
    private String downloadPath;

    public String CreateStatisticsExcel(SalerRankingParameter salerRankingParameter, PhoneIntallMessParameter phoneIntallMessParameter, ProvinceStatisParameter provinceStatisParameter, Integer flag) {
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
        if (flag != null) {
            //  促销员排名
            if (flag.intValue() == 0) {
                logger.info("促销员排名");
                try {
                    List<SalerRankingRes> salerRankingParameterList = salesStatisticsManager.getSalerRanking(salerRankingParameter);
                    if (salerRankingParameterList != null && salerRankingParameterList.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        //合并低一列的第一行到第五行
                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

                        // 设置第一行的值
                        if (salerRankingParameter.getStartTime() == null || salerRankingParameter.getStartTime() == null || salerRankingParameter.getStartTime().equals("") || salerRankingParameter.getEndTime().equals("")) {
                            cell.setCellValue("促销员排名");
                        } else {
                            cell.setCellValue("促销员排名(" + salerRankingParameter.getStartTime() + "至" + salerRankingParameter.getEndTime() + ")");
                        }
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("排名");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("促销员名称");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("安装手机台数");
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("安装量");
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("平均每台手机安装量");
                        cell5.setCellStyle(cellStyle);

                        for (int i = 0; i < salerRankingParameterList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellStatByApps1 = rowStatByApps.createCell(0);
                            cellStatByApps1.setCellValue(salerRankingParameterList.get(i).getRanking() ? i + 1 + "" : "--");
                            cellStatByApps1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps2 = rowStatByApps.createCell(1);
                            cellStatByApps2.setCellValue(salerRankingParameterList.get(i).getSaler());
                            cellStatByApps2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps3 = rowStatByApps.createCell(2);
                            cellStatByApps3.setCellValue(salerRankingParameterList.get(i).getPhoneTimes());
                            cellStatByApps3.setCellStyle(cellStyleContent);


                            XSSFCell cellStatByApps4 = rowStatByApps.createCell(3);
                            cellStatByApps4.setCellValue(salerRankingParameterList.get(i).getInstallTimes());
                            cellStatByApps4.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps5 = rowStatByApps.createCell(4);
                            cellStatByApps5.setCellValue(salerRankingParameterList.get(i).getAverageInstallTimes());
                            cellStatByApps5.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue("暂无排名");
                        cell.setCellStyle(cellStyle);
                    }

                } catch (Exception e) {
                    logger.error("导出报表：促销员排名失败，失败原因：" + e.getMessage());
                }
            } else if (flag.intValue() == 1) {
                try {
                    logger.info("手机安装信息");
                    List<PhoneIntallMess> phoneInstallMessExcel = salesStatisticsManager.getPhoneInstallMessExcel(phoneIntallMessParameter);
                    if (phoneInstallMessExcel != null && phoneInstallMessExcel.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);

                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
                        // 设置第一行的值
                        cell.setCellValue("手机安装信息");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("串码");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("促销员");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("省份");
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("手机型号");
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("安装时间");
                        cell5.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell6 = row1.createCell(5);
                        cell6.setCellValue("应用名称");
                        cell6.setCellStyle(cellStyle);

                        for (int i = 0; i < phoneInstallMessExcel.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellStatByApps1 = rowStatByApps.createCell(0);
                            cellStatByApps1.setCellValue(phoneInstallMessExcel.get(i).getPhoneImei());
                            cellStatByApps1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps2 = rowStatByApps.createCell(1);
                            cellStatByApps2.setCellValue(phoneInstallMessExcel.get(i).getSalerName());
                            cellStatByApps2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps3 = rowStatByApps.createCell(2);
                            cellStatByApps3.setCellValue(phoneInstallMessExcel.get(i).getCname());
                            cellStatByApps3.setCellStyle(cellStyleContent);


                            XSSFCell cellStatByApps4 = rowStatByApps.createCell(3);
                            cellStatByApps4.setCellValue(phoneInstallMessExcel.get(i).getPhoneModelName());
                            cellStatByApps4.setCellStyle(cellStyleContent);


                            XSSFCell cellStatByApps5 = rowStatByApps.createCell(4);
                            cellStatByApps5.setCellValue(phoneInstallMessExcel.get(i).getInstallTime());
                            cellStatByApps5.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps6 = rowStatByApps.createCell(5);
                            cellStatByApps6.setCellValue(phoneInstallMessExcel.get(i).getAppName());
                            cellStatByApps6.setCellStyle(cellStyleContent);
                        }
                    } else {
                        cell.setCellValue("暂无信息");
                        cell.setCellStyle(cellStyle);
                    }

                } catch (Exception e) {
                    logger.error("导出报表：手机安装信息，失败原因：" + e.getMessage());
                }
            } else if (flag.intValue() == 2) {
                try {
                    logger.info("按天查看应用安装情况");
                    List<DayIntallLog> dayIntallLogList = salesStatisticsManager.byDayCheckInstallExcel();

                    if (dayIntallLogList != null && dayIntallLogList.size() != 0) {
                        // 设置每一列
                        sheet.setColumnWidth(0, 5000);
                        sheet.setColumnWidth(1, 5000);
                        sheet.setColumnWidth(2, 5000);
                        sheet.setColumnWidth(3, 5000);
                        sheet.setColumnWidth(4, 5000);
                        sheet.setColumnWidth(5, 5000);

                        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
                        // 设置第一行的值
                        cell.setCellValue("每天应用安装信息");
                        // 设置第一行的属性
                        cell.setCellStyle(titleStyle);

                        // 创建Excel的sheet的第二行第一列
                        XSSFRow row1 = sheet.createRow(1);
                        row1.setHeight(height);
                        XSSFCell cell1 = row1.createCell(0);
                        cell1.setCellValue("时间");
                        cell1.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第二列
                        XSSFCell cell2 = row1.createCell(1);
                        cell2.setCellValue("安装手机台数");
                        cell2.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell3 = row1.createCell(2);
                        cell3.setCellValue("安装的店数");
                        cell3.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第四列
                        XSSFCell cell4 = row1.createCell(3);
                        cell4.setCellValue("安装的应用数");
                        cell4.setCellStyle(cellStyle);

                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell5 = row1.createCell(4);
                        cell5.setCellValue("平均每台手机安装量");
                        cell5.setCellStyle(cellStyle);


                        // 创建Excel的sheet的第二行第三列
                        XSSFCell cell6 = row1.createCell(5);
                        cell6.setCellValue("平均每个店安装台数");
                        cell6.setCellStyle(cellStyle);

                        for (int i = 0; i < dayIntallLogList.size(); i++) {
                            XSSFRow rowStatByApps = sheet.createRow(i + 2);
                            rowStatByApps.setHeight(height);

                            XSSFCell cellStatByApps1 = rowStatByApps.createCell(0);
                            cellStatByApps1.setCellValue(dayIntallLogList.get(i).getDateTime());
                            cellStatByApps1.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps2 = rowStatByApps.createCell(1);
                            cellStatByApps2.setCellValue(dayIntallLogList.get(i).getPhoneTimes());
                            cellStatByApps2.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps3 = rowStatByApps.createCell(2);
                            cellStatByApps3.setCellValue(dayIntallLogList.get(i).getShopTimes());
                            cellStatByApps3.setCellStyle(cellStyleContent);


                            XSSFCell cellStatByApps4 = rowStatByApps.createCell(3);
                            cellStatByApps4.setCellValue(dayIntallLogList.get(i).getAppsTimes());
                            cellStatByApps4.setCellStyle(cellStyleContent);


                            XSSFCell cellStatByApps5 = rowStatByApps.createCell(4);
                            cellStatByApps5.setCellValue(Double.valueOf(dayIntallLogList.get(i).getPhoneAverageInstallTimes()));
                            cellStatByApps5.setCellStyle(cellStyleContent);

                            XSSFCell cellStatByApps6 = rowStatByApps.createCell(5);
                            cellStatByApps6.setCellValue(Double.valueOf(dayIntallLogList.get(i).getShopAverageInstallTimes()));
                            cellStatByApps6.setCellStyle(cellStyleContent);
                        }

                    } else {
                        cell.setCellValue("暂无信息");
                        cell.setCellStyle(cellStyle);
                    }

                } catch (Exception e) {
                    logger.error("导出报表：按天查看应用安装情况，失败原因：" + e.getMessage());
                }

            } else if (flag.intValue() == 3) {
                List<ProvinceStatisRes> provinceStatisResList = salesStatisticsManager.provinceStatis(provinceStatisParameter);
                if (provinceStatisResList != null && provinceStatisResList.size() != 0) {
                    int mark = provinceStatisResList.get(0).getFlag();
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
                    sheet.setColumnWidth(9, 5000);
                    sheet.setColumnWidth(10, 5000);

                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
                    // 设置第一行的值
                    if (mark == 1) {
                        cell.setCellValue("各省份月统计信息");
                    } else {
                        cell.setCellValue("各省份" + provinceStatisParameter.getStartTime() + "统计信息");
                    }

                    // 设置第一行的属性
                    cell.setCellStyle(titleStyle);

                    // 创建Excel的sheet的第二行第一列
                    XSSFRow row1 = sheet.createRow(1);
                    row1.setHeight(height);
                    XSSFCell cell1 = row1.createCell(0);
                    cell1.setCellValue("省份");
                    cell1.setCellStyle(cellStyle);

                    XSSFCell cell2 = row1.createCell(1);
                    if (mark == 1) {
                        cell2.setCellValue("总收入");
                    } else {
                        cell2.setCellValue("当日收入");
                    }
                    cell2.setCellStyle(cellStyle);

                    XSSFCell cell3 = row1.createCell(2);
                    cell3.setCellValue("收入目标");
                    cell3.setCellStyle(cellStyle);


                    XSSFCell cell4 = row1.createCell(3);
                    cell4.setCellValue("完成率");
                    cell4.setCellStyle(cellStyle);

                    XSSFCell cell5 = row1.createCell(4);
                    cell5.setCellValue("部署人数");
                    cell5.setCellStyle(cellStyle);


                    XSSFCell cell6 = row1.createCell(5);
                    if (mark == 1) {
                        cell6.setCellValue("安装台数");
                    } else {
                        cell6.setCellValue("当日安装台数");
                    }
                    cell6.setCellStyle(cellStyle);


                    XSSFCell cell7 = row1.createCell(6);
                    cell7.setCellValue("人均日安装台数");
                    cell7.setCellStyle(cellStyle);


                    XSSFCell cell9 = row1.createCell(7);
                    cell9.setCellValue("人均日安装台数目标");
                    cell9.setCellStyle(cellStyle);

                    XSSFCell cell10 = row1.createCell(8);
                    cell10.setCellValue("台数达成率");
                    cell10.setCellStyle(cellStyle);

                    XSSFCell cell11 = row1.createCell(9);
                    cell11.setCellValue("日均活跃人数");
                    cell11.setCellStyle(cellStyle);

                    XSSFCell cell12 = row1.createCell(10);
                    cell12.setCellValue("日均活跃人数比例");
                    cell12.setCellStyle(cellStyle);


                    for (int i = 0; i < provinceStatisResList.size(); i++) {
                        XSSFRow rowStatByApps = sheet.createRow(i + 2);
                        rowStatByApps.setHeight(height);

                        XSSFCell cellStatByApps1 = rowStatByApps.createCell(0);
                        cellStatByApps1.setCellValue(provinceStatisResList.get(i).getProvince());
                        cellStatByApps1.setCellStyle(cellStyleContent);

                        XSSFCell cellStatByApps2 = rowStatByApps.createCell(1);
                        cellStatByApps2.setCellValue(provinceStatisResList.get(i).getIncome());
                        cellStatByApps2.setCellStyle(cellStyleContent);

                        XSSFCell cellStatByApps3 = rowStatByApps.createCell(2);
                        if (provinceStatisResList.get(i).getIncomeTarget() != null) {
                            cellStatByApps3.setCellValue(provinceStatisResList.get(i).getIncomeTarget());
                        } else {
                            cellStatByApps3.setCellValue("");
                        }
                        cellStatByApps3.setCellStyle(cellStyleContent);


                        XSSFCell cellStatByApps4 = rowStatByApps.createCell(3);
                        cellStatByApps4.setCellValue(provinceStatisResList.get(i).getCompletionRate());
                        cellStatByApps4.setCellStyle(cellStyleContent);


                        XSSFCell cellStatByApps5 = rowStatByApps.createCell(4);
                        if (provinceStatisResList.get(i).getDeployPeople() != null) {
                            cellStatByApps5.setCellValue(provinceStatisResList.get(i).getDeployPeople());
                        } else {
                            cellStatByApps5.setCellValue("");
                        }
                        cellStatByApps5.setCellStyle(cellStyleContent);


                        XSSFCell cellStatByApps6 = rowStatByApps.createCell(5);
                        cellStatByApps6.setCellValue(provinceStatisResList.get(i).getPhoneTimes());
                        cellStatByApps6.setCellStyle(cellStyleContent);

                        XSSFCell cellStatByApps7 = rowStatByApps.createCell(6);
                        cellStatByApps7.setCellValue(provinceStatisResList.get(i).getEveryPerPhones());
                        cellStatByApps7.setCellStyle(cellStyleContent);

                        XSSFCell cellStatByApps8 = rowStatByApps.createCell(7);
                        if (provinceStatisResList.get(i).getEveryPerPhonesTarget() != null) {
                            cellStatByApps8.setCellValue(provinceStatisResList.get(i).getEveryPerPhonesTarget());
                        } else {
                            cellStatByApps8.setCellValue("");
                        }
                        cellStatByApps8.setCellStyle(cellStyleContent);


                        XSSFCell cellStatByApps9 = rowStatByApps.createCell(8);
                        cellStatByApps9.setCellValue(provinceStatisResList.get(i).getPhoneCompletionRate());
                        cellStatByApps9.setCellStyle(cellStyleContent);

                        XSSFCell cellStatByApps10 = rowStatByApps.createCell(9);
                        cellStatByApps10.setCellValue(provinceStatisResList.get(i).getIntallSalerTimes());
                        cellStatByApps10.setCellStyle(cellStyleContent);


                        XSSFCell cellStatByApps11 = rowStatByApps.createCell(10);
                        cellStatByApps11.setCellValue(provinceStatisResList.get(i).getActiveRatio());
                        cellStatByApps11.setCellStyle(cellStyleContent);


                       /* XSSFCell cellStatByApps5 = rowStatByApps.createCell(4);
                        if (mark == 1) {
                            cellStatByApps5.setCellValue(provinceStatisResList.get(i).getArrRate());
                        } else {
                            cellStatByApps5.setCellValue(provinceStatisResList.get(i).getPerInstallTimes());
                        }
                        cellStatByApps5.setCellStyle(cellStyleContent);*/
                    }
                } else {
                    cell.setCellValue("暂无信息");
                    cell.setCellStyle(cellStyle);
                }
            }

            String newPath = System.currentTimeMillis() + ".xlsx";
            String targetDirectory = salesStatisticsManager.getInstallLogExcelPath();
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
            return downloadPath + "installlogExcel/" + newPath;
        } else {
            return null;
        }

    }

    public void setSalesStatisticsManager(SalesStatisticsManager salesStatisticsManager) {
        this.salesStatisticsManager = salesStatisticsManager;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }
}

