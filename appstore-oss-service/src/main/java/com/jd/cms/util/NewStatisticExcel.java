package com.jd.cms.util;


import com.jd.cms.manager.appManagement.NewStatisticManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 新版统计导出EXCEL文件
 * YYF on 2015/5/18.
 */
public class NewStatisticExcel {
    private Logger logger = Logger.getLogger(this.getClass());

    private NewStatisticManager newStatisticManager;


    private String createExcel() {
        short height = 400;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setNewStatisticManager(NewStatisticManager newStatisticManager) {
        this.newStatisticManager = newStatisticManager;
    }
}
