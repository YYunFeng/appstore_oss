package com.jd.cms.service.schedule.impl;

import com.jd.appstore.domain.utils.MailConstant;
import com.jd.cms.manager.appManagement.MarketStatisticsManager;
import com.jd.cms.manager.appManagement.SalesStatisticsManager;
import com.jd.cms.service.schedule.DailyReportService;
import com.jd.cms.util.CreateInstallLogExcel;
import com.jd.cms.util.StatisticsExcel;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 生成每日报表
 * User: YUNFENG
 * Date: 13-9-27
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public class DailyReportServiceImpl implements DailyReportService {
    private Logger logger = Logger.getLogger(this.getClass());
    private CreateInstallLogExcel createInstallLogExcel;
    private StatisticsExcel statisticsExcel;
    private MarketStatisticsManager marketStatisticsManager;
    private SalesStatisticsManager salesStatisticsManager;
    String dayReportPath;

    public void CreateDailyReport() throws IOException {
        try {
            logger.info("生成文件开始。。。。");
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            //当前月的第一天
            cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
            Date beginTime = cal.getTime();
            String startTime = datef.format(beginTime);
            logger.info("startTime" + startTime);
            String endTime = "";
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE, -1);
            Date time = cal1.getTime();
            endTime = datef.format(time);
            logger.info("startTime" + endTime);
            String[] strings = new String[2];
            String personInstall = createInstallLogExcel.CreateInstallLogExcel(startTime, endTime, null, 139, null, 7, 0);
            String dayInstall = statisticsExcel.CreateStatisticsExcel(null,null,null,2);
            strings[0] = marketStatisticsManager.getInstallLogExcelPath() + "/" + personInstall.substring(personInstall.lastIndexOf("/") + 1);
            logger.info("strings[0]" + strings[0]);
            strings[1] = salesStatisticsManager.getInstallLogExcelPath() + "/" + dayInstall.substring(dayInstall.lastIndexOf("/") + 1);
            logger.info("strings[1]" + strings[1]);

            logger.info("开始压缩EXCEL文件");
            SimpleDateFormat datef1 = new SimpleDateFormat("yyyyMMdd");
            String extName = datef1.format(time) + ".zip";
            String zipfile = this.dayReportPath;
            File targetDirectory = new File(zipfile);
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs();
                logger.info("目录不存在，创建新目录：" + targetDirectory);
            }
            zipfile = this.dayReportPath + "/" + extName;
            // 根据文件路径构造一个文件实例
            File ff = new File(zipfile);
            // 判断目前文件是否存在,如果不存在,则新建一个
            if (!ff.exists()) {
                ff.createNewFile();
            }
            // 根据文件路径构造一个文件输出流
            FileOutputStream out = new FileOutputStream(zipfile);
            // 传入文件输出流对象,创建ZIP数据输出流对象
            ZipOutputStream zipOut = new ZipOutputStream(out);
            int fileCount = 0;
            // 循环待压缩的文件列表
            for (int i = 0; i < strings.length; i++) {
                File f = new File(strings[i]);
                if (!f.exists()) {
                    logger.info("压缩文件不存在,文件名称：" + strings[i]);
                } else {
                    fileCount = fileCount + 1;
                    // 创建文件输入流对象
                    FileInputStream in = new FileInputStream(strings[i]);
                    try {
                        // 得到当前文件的文件名称
                        String fileName = "";
                        if (i == 0) {
                            fileName = MailConstant.SHANGHAIGEREN + datef1.format(time) + ".xlsx";
                        } else if (i == 1) {
                            fileName = MailConstant.SHANGHAIMEIRI + datef1.format(time) + ".xlsx";
                        }
                        // 创建指向压缩原始文件的入口
                        ZipEntry entry = new ZipEntry(fileName);
                        zipOut.putNextEntry(entry);
                        // 向压缩文件中输出数据
                        int nNumber = 0;
                        byte[] buffer = new byte[512];
                        while ((nNumber = in.read(buffer)) != -1) {
                            zipOut.write(buffer, 0, nNumber);
                        }
                        // 关闭创建的流对象
                        in.close();
                    } catch (IOException e) {
                        logger.error("压缩文件异常,异常信息：" + e.getMessage());
                    }
                }
            }
            zipOut.close();
            out.close();
            logger.info("压缩文件结束");
        } catch (Exception e) {
            logger.error("系统异常，异常信息：" + e.getMessage());
        }
    }

    public void setSalesStatisticsManager(SalesStatisticsManager salesStatisticsManager) {
        this.salesStatisticsManager = salesStatisticsManager;
    }

    public void setMarketStatisticsManager(MarketStatisticsManager marketStatisticsManager) {
        this.marketStatisticsManager = marketStatisticsManager;
    }

    public void setStatisticsExcel(StatisticsExcel statisticsExcel) {
        this.statisticsExcel = statisticsExcel;
    }

    public void setCreateInstallLogExcel(CreateInstallLogExcel createInstallLogExcel) {
        this.createInstallLogExcel = createInstallLogExcel;
    }

    public String getDayReportPath() {
        return dayReportPath;
    }

    public void setDayReportPath(String dayReportPath) {
        this.dayReportPath = dayReportPath;
    }
}
