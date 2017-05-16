package com.jd.cms.job;

import com.jd.cms.domain.clientmanager.CpDateImport;
import com.jd.cms.domain.clientmanager.CpPhoneimei;
import com.jd.cms.manager.clientmanager.CpDateImportManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNFENG on 14-2-25.
 */
public class ImportCpDate implements Runnable {
    private final static Logger log = Logger.getLogger(ImportCpDate.class);
    private String filePath;
    private String fileName;
    private Integer id;
    private String appid;
    private CpDateImportManager cpDateImportManager;

    public void run() {
        log.info("--解析Excel文件开始--");
        String file = filePath + "/" + fileName;
        CpDateImport cpDateImport = new CpDateImport();
        if (file != null && !"".equals(file)) {
            cpDateImport.setId(id);
            String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (extName.toLowerCase().equals("xlsx") || extName.toLowerCase().equals("xls")) {
                XSSFWorkbook xwb = null;
                XSSFSheet sheet = null;
                XSSFRow row = null;
                XSSFCell hssfCell = null;
                String cell = null;
                try {
                    CpPhoneimei cpPhoneimei = null;
                    xwb = new XSSFWorkbook(file);
                    sheet = xwb.getSheetAt(0);
                    // 循环输出表格中的内容
                    int j = 0;
                    int n = 0;
                    for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
                        cpPhoneimei = new CpPhoneimei();
                        row = sheet.getRow(i);
                        if (!this.isNullRow(row)) {
                            hssfCell = row.getCell(0);
                            hssfCell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            cell = hssfCell.getStringCellValue();
                            cpPhoneimei.setAppid(appid);
                            cpPhoneimei.setCpImportId(id);
                            cpPhoneimei.setPhoneImei(cell);
                            try {
                                cpDateImportManager.createCpPhoneimei(cpPhoneimei);
                                j = j + 1;

                            } catch (Exception e) {
                                log.error("插入数据库异常，异常信息：" + e.getMessage());
                            }
                            n = n + 1;
                        }
                    }
                    cpDateImport.setAmount(j);
                    if(n==j){
                        cpDateImport.setStatus(1);
                        cpDateImport.setMess("成功");
                    }else{
                        cpDateImport.setStatus(0);
                        cpDateImport.setMess("导入条数不对");
                    }
                } catch (Exception e) {
                    log.error("解析异常，异常信息：" + e.getMessage());
                    cpDateImport.setMess("系统异常");
                    cpDateImport.setStatus(0);
                }
            } else {
                cpDateImport.setStatus(0);
                cpDateImport.setMess("解析异常,文件格式不对");
                log.error("解析异常,文件格式不对");
            }
        }
        log.info("--解析Excel文件结束--");
        cpDateImportManager.updateCpDateImport(cpDateImport);
    }


    private boolean isNullRow(XSSFRow row) {
        if (row == null) {
            return true;
        }
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            if (row.getCell(i) != null && !"".equals(row.getCell(i).toString())) {
                return false;
            }
        }
        return true;
    }

    public void setCpDateImportManager(CpDateImportManager cpDateImportManager) {
        this.cpDateImportManager = cpDateImportManager;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
