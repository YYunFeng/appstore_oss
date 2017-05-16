package com.jd.cms.common.util;

import com.jd.cms.domain.systemmaintenance.Content;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * YYF on 2014/12/30.
 */
public class AnalysisExcel {

    public static void main(String arg[]) {
        try {
           /* XSSFWorkbook xwb = null;
            XSSFSheet sheet = null;
            XSSFRow row = null;
            String cell = null;
            List<String> list = new ArrayList();
            Content c = null;
            xwb = new XSSFWorkbook("F:\\PPAD 项目\\华盛\\华盛统计数据\\UC浏览器6月至12月安装的手机串号.xlsx");
            // 循环sheet
            for (int i = 0; i < 1; i++) {
                sheet = xwb.getSheetAt(i);
                for (int j = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); j++) {
                    row = sheet.getRow(j);
                    cell = row.getCell(0).toString();
                    System.out.println(row.getCell(0));
                }
            }*/

            System.out.println(reg("800075675267196"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean reg(String s) {
        String pattern = "^[8][0-9]{15}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        return m.matches();
    }

}
