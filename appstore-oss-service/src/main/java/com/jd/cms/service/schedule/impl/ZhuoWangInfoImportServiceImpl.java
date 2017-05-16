package com.jd.cms.service.schedule.impl;

import com.jd.appstore.domain.ZhuoWangAppMessage;
import com.jd.cms.manager.schedule.ZhuoWangInfoImportManager;
import com.jd.cms.service.ftp.FtpService;
import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import com.jd.cms.service.systemmaintenance.BulkUploadService;
import com.jd.cms.util.CategoryIdUtil;
import com.jd.cms.util.ZhuoWangAppsGetAccountIdUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * User: YYF
 * Date: 13-2-28
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangInfoImportServiceImpl implements ZhuoWangInfoImportService {

    private Logger logger = Logger.getLogger(this.getClass());
    public BulkUploadService bulkUploadService;
    private ZhuoWangInfoImportManager zhuoWangInfoImportManager;
    private ZhuoWangAppsGetAccountIdUtil zhuoWangAppsGetAccountIdUtil;
    CategoryIdUtil categoryIdUtil;
    private FtpService ftpService;

    /**
     * 解析Excel文件
     *
     * @param filePath
     * @return
     */
    private void getAppList(String filePath, Integer accountId) throws ArrayIndexOutOfBoundsException {
        List<ZhuoWangAppMessage> zhuoWangAppMessageList = new ArrayList<ZhuoWangAppMessage>();
        if (filePath != null && !"".equals(filePath)) {
            ZhuoWangAppMessage zhuoWangAppMessage = null;
            String[] zhuoWangAppFullMess = null;
            try {
                File intro = new File(filePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(intro)), 5 * 1024 * 1024);
                String rec = null;
                while ((rec = br.readLine()) != null) {
                    try {
                        /*    if (rec.toLowerCase().indexOf("android") == -1)
                        continue;*/
                        //  去除双引号和空格
                        rec = rec.replaceAll("\"", "").replaceAll("\\{", "").replaceAll("}", "").trim();
                        //  按| 分组数据
                        zhuoWangAppFullMess = rec.split("\\|");
                        if (zhuoWangAppFullMess.length != 22) {
                            logger.error("import error,appId:" + zhuoWangAppFullMess[0] + ",text:" + rec + ",String[] length:" + zhuoWangAppFullMess.length);
                            continue;
                        }

                        if (zhuoWangAppFullMess[12].indexOf("146820") == -1)
                            continue;

                        //  一级类目不为0 或者不为1 价格不等于0
                        if (Integer.valueOf(zhuoWangAppFullMess[13]).intValue() != 0)
                            continue;
                        if(Integer.valueOf(zhuoWangAppFullMess[6]).intValue()!=0&&Integer.valueOf(zhuoWangAppFullMess[6]).intValue()!=1)
                            continue;
                        zhuoWangAppMessage = new ZhuoWangAppMessage();
                        if (zhuoWangAppFullMess[6] != null && !zhuoWangAppFullMess[6].equals("")) {
                            if (Integer.valueOf(zhuoWangAppFullMess[6]).intValue() == 0) {
                                zhuoWangAppMessage.setCategoryId1Id(Integer.valueOf(categoryIdUtil.getMobileSoftId()));
                            }else if (Integer.valueOf(zhuoWangAppFullMess[6]).intValue() == 1) {
                                zhuoWangAppMessage.setCategoryId1Id(Integer.valueOf(categoryIdUtil.getMobileGameId()));
                            }
                        }
                        zhuoWangAppMessage.setZhuoWangId(zhuoWangAppFullMess[0]);
                        zhuoWangAppMessage.setContentMessage(zhuoWangAppFullMess[1].length() > 30 ? zhuoWangAppFullMess[1].substring(0, 30) : zhuoWangAppFullMess[1]);
                        zhuoWangAppMessage.setCompanyCode(zhuoWangAppFullMess[2]);
                        zhuoWangAppMessage.setCompanyName(zhuoWangAppFullMess[3]);
                        zhuoWangAppMessage.setUpdateTime(zhuoWangAppFullMess[4]);
                        zhuoWangAppMessage.setRecommendStar(Integer.valueOf(zhuoWangAppFullMess[5]));

                        zhuoWangAppMessage.setCategoryId2Id(Integer.valueOf(zhuoWangAppFullMess[7]));
                        zhuoWangAppMessage.setAppsMark(Integer.valueOf(zhuoWangAppFullMess[8]));
                        zhuoWangAppMessage.setKeyWord(zhuoWangAppFullMess[9]);
                        zhuoWangAppMessage.setBusinessIntroduction(zhuoWangAppFullMess[10]);
                        zhuoWangAppMessage.setViewNum(Integer.valueOf(zhuoWangAppFullMess[11]));
                        zhuoWangAppMessage.setFitModelsList(zhuoWangAppFullMess[12]);
                        zhuoWangAppMessage.setPrice(zhuoWangAppFullMess[13]);
                        zhuoWangAppMessage.setPicUrl1(zhuoWangAppFullMess[14]);
                        zhuoWangAppMessage.setPicUrl2(zhuoWangAppFullMess[15]);
                        zhuoWangAppMessage.setPicUrl3(zhuoWangAppFullMess[16]);
                        zhuoWangAppMessage.setPicUrl4(zhuoWangAppFullMess[17]);
                        zhuoWangAppMessage.setPicUrl5(zhuoWangAppFullMess[18]);
                        zhuoWangAppMessage.setPicUrl6(zhuoWangAppFullMess[19]);
                        zhuoWangAppMessage.setMobileSystem(zhuoWangAppFullMess[20]);
                        zhuoWangAppMessage.setAddDeleteMark(Integer.valueOf(zhuoWangAppFullMess[21].replaceAll(",", "")));
                        zhuoWangAppMessageList.add(zhuoWangAppMessage);
                        if (zhuoWangAppMessageList.size() >= 200) {
                            logger.info("insert db......................." + ",listSize=" + zhuoWangAppMessageList.size());
                            zhuoWangInfoImportManager.createZhuoWangApp(zhuoWangAppMessageList, accountId);
                            //  将zhuoWangAppMessageList中的数据清空
                            zhuoWangAppMessageList.clear();
                        }
                    } catch (Exception e) {
                        logger.error("import error,appId:" + zhuoWangAppFullMess[0] + ",text:" + rec + ",exception:" + e.getMessage());
                    }
                }
                if (zhuoWangAppMessageList != null && zhuoWangAppMessageList.size() > 0) {
                    logger.info("insert db..................................");
                    zhuoWangInfoImportManager.createZhuoWangApp(zhuoWangAppMessageList, accountId);
                }
                logger.info("finish!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void importFullApp() {
        String filePath = ftpService.downloadFullAppFile();
        Integer accountId = zhuoWangAppsGetAccountIdUtil.getAccountId();
        if (filePath != null) {
            importFullApp(filePath, accountId);
        }
    }

    /**
     * 定时更新卓望接口增量应用
     */

    public void importNewApp() {
        String filePath = ftpService.downloadNewAppFile();
        if (filePath != null) {
            Integer accountId = zhuoWangAppsGetAccountIdUtil.getAccountId();
            importNewApp(filePath, accountId);
        }
    }

    // 导入全量数据
    public void importFullApp(String filePath, Integer accountId) {
        try {
            // 删除所有关于卓望的数据
            zhuoWangInfoImportManager.deleteZhuoWangApp();
            getAppList(filePath, accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 导入增量数据
    public void importNewApp(String filePath, Integer accountId) {
        try {
            getAppList(filePath, accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void importCategory() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void importTop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public FtpService getFtpService() {
        return ftpService;
    }

    public void setZhuoWangAppsGetAccountIdUtil(ZhuoWangAppsGetAccountIdUtil zhuoWangAppsGetAccountIdUtil) {
        this.zhuoWangAppsGetAccountIdUtil = zhuoWangAppsGetAccountIdUtil;
    }

    public void setFtpService(FtpService ftpService) {
        this.ftpService = ftpService;
    }

    public void setCategoryIdUtil(CategoryIdUtil categoryIdUtil) {
        this.categoryIdUtil = categoryIdUtil;
    }

    public void setBulkUploadService(BulkUploadService bulkUploadService) {
        this.bulkUploadService = bulkUploadService;
    }


    public void setZhuoWangInfoImportManager(ZhuoWangInfoImportManager zhuoWangInfoImportManager) {
        this.zhuoWangInfoImportManager = zhuoWangInfoImportManager;
    }
}
