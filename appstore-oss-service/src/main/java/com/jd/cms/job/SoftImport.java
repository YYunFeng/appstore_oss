package com.jd.cms.job;

import com.jd.appstore.domain.AppResource;
import com.jd.appstore.domain.ImportAppLog;
import com.jd.appstore.domain.utils.VerifyCode;
import com.jd.cms.domain.systemmaintenance.ApkMessJSON;
import com.jd.cms.domain.systemmaintenance.Content;
import com.jd.cms.service.systemmaintenance.BulkImportService;
import com.jd.cms.service.systemmaintenance.BulkUploadService;
import com.jd.cms.util.AnalysisApk;
import com.jd.cms.util.CreateExcel;
import com.jd.cms.util.Util;
import com.jd.digital.common.rpc.manager.img.ImageManager;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-9-15
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class SoftImport implements Runnable {

    private BulkUploadService bulkUploadService;
    private BulkImportService bulkImportService;
    private JssAppManager jssAppManager;
    private ImageManager imageManager;
    private String targetDirectory;
    private String newFileName;
    private String adminId;
    private int accountId;
    private String ip;
    private int appType;
    private int superRoleId;
    private String account;
    Logger logger = Logger.getLogger(this.getClass());

    public void run() {
        logger.info("批量导入后台模式开启!!!!!");
        if (appType == 2) {
            logger.info("管理员：" + adminId + " cp帐号：" + accountId + " 导入应用类型：移动软件");
            importAndroidSoft();
        } else {
            logger.info("管理员：" + adminId + " cp帐号：" + accountId + " 导入应用类型：网页应用");
            importWebSoft();
        }
    }

    /**
     * 批量导入网页应用
     *
     * @return
     */
    public String importWebSoft() {
        // 开始解析Excel
        bulkImportService.initWebCategory();
        bulkImportService.initParseWebExcel(targetDirectory + newFileName);

        List<Content> list = bulkImportService.getWebContentListByExcel();
        ImportAppLog importAppLog = new ImportAppLog();
        importAppLog.setAdminId(superRoleId);
        importAppLog.setCpAccount(accountId);
        importAppLog.setAppType(appType);
        importAppLog.setTotal(list.size());
        importAppLog.setProcessed(0);
        importAppLog.setSucceed(0);
        importAppLog.setFailed(0);
        importAppLog.setStatus(0);
        importAppLog.setDownloaded(0);
        int importId = bulkUploadService.createImportLog(importAppLog);
        // 已经处理条数
        int processed = 0;
        // 成功条数
        int succeed = 0;
        // 失败条数
        int failed = 0;
        Content content;
        for (int i = 0; i < list.size(); i++) {
            content = list.get(i);
            if (content.getStatus() == 0) {
                File file = new File(content.getAppLink());
                if (!file.exists()) {
                    content.setMessage("资源包不存在");
                    content.setStatus(-1);
                } else {
                    if (content.getAppType() == 3) {
                        String flashPath = content.getAppLink() + "/" + content.getApkName();
                        File flash = new File(flashPath);
                        if (!flash.exists()) {
                            content.setMessage("flash文件不存在");
                            content.setStatus(-1);
                        }
                    }
                }
                String coverLogoPath = content.getAppLink() + "/" + content.getLogoUrl();
                File coverLogo = new File(coverLogoPath);
                if (!coverLogo.exists()) {
                    if (content.getMessage().equals("")) {
                        content.setMessage("首图不存在");
                        content.setStatus(-1);
                    } else {
                        content.setMessage(content.getMessage() + ",首图不存在");
                        content.setStatus(-1);
                    }
                }
                if (!"".equals(content.getMessage())) {
                    content.setStatus(-1);
                } else {
                    if (content.getStatus() != -1) {
                        content.setAccountId(accountId);
                        content.setAdminId(adminId);
                        content.setIp(ip);
                        try {
                            // 读取应用简介
                            String introPath = content.getAppLink() + "/intro.txt";
                            File intro = new File(introPath);
                            if (intro.exists() && intro.isFile()) {
                                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(intro)));
                                StringBuffer sb = new StringBuffer();
                                String line = "";
                                while ((line = br.readLine()) != null) {
                                    sb.append(line);
                                }
                                content.setAppIntroduce(sb.toString());
                            } else {
                                content.setAppIntroduce("");
                            }
                        } catch (Exception e) {
                        }
                        List<AppResource> appResources = new ArrayList<AppResource>();
                        // 上传所有资源包
                        //  上传首图
                        String logoPath = content.getAppLink() + "/" + content.getLogoUrl();
                        File logo = new File(logoPath);
                        String logoName = uploadPic(logoPath, logo, true);
                        if (logoName == null) {
                            content.setStatus(-1);
                            content.setMessage("主图上传失败");
                        }
                        content.setNewLogoUrl(logoName);
                        if (content.getAppType() == 3) {
                            String swfPath = content.getAppLink() + "/" + content.getApkName();
                            File swf = new File(swfPath);
                            String jd_swfUrl = uploadApk(swfPath, swf, content.getAppPackage(), Util.getUuid() + accountId + "");
                            if (jd_swfUrl == null) {
                                content.setStatus(-1);
                                if (content.getMessage().equals("") || content.getMessage() == null) {
                                    content.setMessage("swf上传失败");
                                } else {
                                    content.setMessage(",swf上传失败");
                                }
                            }
                            AppResource swfResource = new AppResource();
                            swfResource.setAccountId(accountId);
                            swfResource.setResType(2);
                            swfResource.setResUrl(jd_swfUrl);
                            appResources.add(swfResource);
                        } else if (content.getAppType() == 4) {
                            AppResource urlResource = new AppResource();
                            urlResource.setAccountId(accountId);
                            urlResource.setResType(2);
                            urlResource.setResUrl(content.getApkName());
                            appResources.add(urlResource);
                        }
                        content.setAppResources(appResources);
                        if (content.getStatus() != -1) {
                            succeed++;
                            int status = bulkUploadService.importWebToDataSource(content);
                            content.setStatus(status);
                        }
                    }
                }
            }
            if (content.getStatus() == -1) {
                failed++;
            }
            processed++;
            if (processed % 10 == 0) {
                ImportAppLog processImport = new ImportAppLog();
                processImport.setId(importId);
                processImport.setProcessed(processed);
                processImport.setSucceed(succeed);
                processImport.setFailed(failed);
                bulkUploadService.processImport(processImport);
            }
        }

        ImportAppLog completeImport = new ImportAppLog();
        completeImport.setId(importId);
        completeImport.setFailed(failed);
        completeImport.setProcessed(processed);
        completeImport.setSucceed(succeed);
        completeImport.setStatus(1);
        bulkUploadService.completeImport(completeImport);
        String message = CreateExcel.newWebExcel(list, targetDirectory + newFileName);
        String tempNewName = message.substring(message.lastIndexOf("excelTemp/") + 10, message.length());
        String str = null;
        try {
            File destTarget = new File(bulkUploadService.getUploadReAPKPath() + "/" + tempNewName);
            File srcTarget = new File(bulkUploadService.getUploadExcelPath() + "/" + tempNewName);
            FileUtils.copyFile(srcTarget, destTarget);
            str = tempNewName;
            int c = 0;
            while (!destTarget.delete() && c < 200) {
                c++;
                Thread.sleep(50);
            }

            int c2 = 0;
            while (!srcTarget.delete() && c2 < 200) {
                c2++;
                Thread.sleep(50);
            }

        } catch (Exception e) {
            logger.info("导入报告上传云服务器异常", e);
            e.printStackTrace();
        }
        ImportAppLog uploadExcelLog = new ImportAppLog();
        uploadExcelLog.setId(importId);
        uploadExcelLog.setExcelUrl(str);
        uploadExcelLog.setStatus(2);
        bulkUploadService.uploadExcelLog(uploadExcelLog);
        return message;
    }

    /**
     * 批量导入移动应用
     *
     * @return
     */
    public String importAndroidSoft() {
        // 开始解析Excel

        bulkImportService.initParseExcel(targetDirectory + newFileName);

        List<Content> list = bulkImportService.getContentListByExcel();

        ImportAppLog importAppLog = new ImportAppLog();
        importAppLog.setAdminId(superRoleId);
        importAppLog.setCpAccount(accountId);
        importAppLog.setAppType(appType);
        importAppLog.setTotal(list.size());
        importAppLog.setProcessed(0);
        importAppLog.setSucceed(0);
        importAppLog.setFailed(0);
        importAppLog.setStatus(0);
        importAppLog.setDownloaded(0);
        int importId = bulkUploadService.createImportLog(importAppLog);
        // 已经处理条数
        int processed = 0;
        // 成功条数
        int succeed = 0;
        // 失败条数
        int failed = 0;
        Content content;
        for (int i = 0; i < list.size(); i++) {
            content = list.get(i);
            if (content.getStatus() == 0) {
                File file = new File(content.getAppLink());
                if (!file.exists()) {
                    content.setMessage("APK文件不存在");
                    content.setStatus(-1);
                } else {
                    String apkPath = content.getAppLink() + "/" + content.getApkName();
                    File apk = new File(apkPath);
                    if (!apk.exists()) {
                        content.setMessage("APK文件不存在");
                        content.setStatus(-1);
                    } else {
                        try {
                            ApkMessJSON apkMessJSON = AnalysisApk.unZip(apkPath);
                            if (apkMessJSON != null) {
                                // 包名
                                if (apkMessJSON.getPackageName() != null) {
                                    content.setAppPackage(apkMessJSON.getPackageName());
                                    // App版本号
                                    if (apkMessJSON.getVersion() != null) {
                                        String tempVersion = apkMessJSON.getVersion();
                                        if (tempVersion.length() > 10) tempVersion = tempVersion.substring(0, 10);
                                        content.setAppVersion(tempVersion);
                                        // apk包的size
                                        if (apkMessJSON.getSize() != null) {
                                            content.setPkgSize(Integer.parseInt(apkMessJSON.getSize()));
                                            // apk适配的最低版本
                                            if (apkMessJSON.getMinSdkVersion() != null) {
                                                content.setOsVersionId(Integer.parseInt(apkMessJSON.getMinSdkVersion()));
                                                if (apkMessJSON.getVersionCode() != null) {
                                                    content.setAppVersionCode(Integer.parseInt(apkMessJSON.getVersionCode()));
                                                } else {
                                                    content.setAppVersionCode(1);
                                                }
                                            } else {
                                                content.setOsVersionId(8);
                                            }
                                        } else {
                                            content.setStatus(-1);
                                            content.setMessage("APK解析失败");
                                        }
                                    } else {
                                        content.setStatus(-1);
                                        content.setMessage("APK解析失败");
                                    }
                                } else {
                                    content.setStatus(-1);
                                    content.setMessage("APK解析失败");
                                }
                            } else {
                                content.setStatus(-1);
                                content.setMessage("APK解析失败");
                            }
                            if (content.getStatus() > -1) {
                                // 重复的应用不上传
                                int count = bulkUploadService.findAppsByPkg(apkMessJSON.getPackageName());
                                if (count > 0) {
                                    content.setStatus(-1);
                                    content.setMessage("该应用已存在");
                                }
                            }
                        } catch (Exception e) {
                            content.setStatus(-1);
                            content.setMessage("该APK包解析不成功");
                        }
                    }
                    String logoPath = content.getAppLink() + "/" + content.getLogoUrl();
                    File logo = new File(logoPath);
                    if (!logo.exists()) {
                        if (content.getMessage().equals("")) {
                            content.setMessage("首图不存在");
                            content.setStatus(-1);
                        } else {
                            content.setMessage(content.getMessage() + ",首图不存在");
                            content.setStatus(-1);
                        }
                    }
                    File snapshot = new File(content.getAppLink() + "/snapshot");
                    if (!snapshot.exists()) {
                        if (content.getMessage().equals("")) {
                            content.setMessage("截图不存在");
                            content.setStatus(-1);
                        } else {
                            content.setMessage(content.getMessage() + ",截图不存在");
                            content.setStatus(-1);
                        }
                    } else {
                        File snapshotPic[] = snapshot.listFiles();
                        if (snapshotPic.length <= 0) {
                            if (content.getMessage().equals("")) {
                                content.setMessage("截图不存在");
                                content.setStatus(-1);
                            } else {
                                content.setMessage(content.getMessage() + ",截图不存在");
                                content.setStatus(-1);
                            }
                        }
                    }
                }
                if (!"".equals(content.getMessage())) {
                    content.setStatus(-1);
                } else {
                    if (content.getStatus() != -1) {

                        content.setAccountId(accountId);
                        content.setAdminId(adminId);
                        content.setIp(ip);
                        content.setAppType(appType);

                        try {
                            // 读取应用简介
                            String introPath = content.getAppLink() + "/intro.txt";
                            File intro = new File(introPath);
                            if (intro.exists() && intro.isFile()) {
                                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(intro));
                                BufferedReader br = new BufferedReader(inputStreamReader);
                                StringBuffer sb = new StringBuffer();
                                String line = "";
                                while ((line = br.readLine()) != null) {
                                    sb.append(line);
                                }
                                content.setAppIntroduce(sb.toString());
                            } else {
                                content.setAppIntroduce("");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        List<AppResource> appResources = new ArrayList<AppResource>();
                        // 上传所有资源包
                        //  上传首图
                        String logoPath = content.getAppLink() + "/" + content.getLogoUrl();
                        File logo = new File(logoPath);
                        String logoName = uploadPic(logoPath, logo, true);
                        if (logoName == null) {
                            content.setStatus(-1);
                            content.setMessage("主图上传失败");
                        }
                        content.setNewLogoUrl(logoName);
                        // 上传APK包
                        String apkPath = content.getAppLink() + "/" + content.getApkName();
                        File apk = new File(apkPath);
                        VerifyCode verifyCode = new VerifyCode(apk);
                        content.setApkCode(verifyCode.verifyCode());
                        content.setZhuoWangMark(0);
                        String jd_apkUrl = uploadApk(apkPath, apk, content.getAppPackage(), content.getAppVersionCode() + "");
                        if (jd_apkUrl == null) {
                            content.setStatus(-1);
                            if (content.getMessage().equals("") || content.getMessage() == null) {
                                content.setMessage("APK上传失败");
                            } else {
                                content.setMessage(",APK上传失败");
                            }
                        }
                        AppResource apkResource = new AppResource();
                        apkResource.setAccountId(accountId);
                        apkResource.setResType(1);
                        apkResource.setResUrl(jd_apkUrl);
                        appResources.add(apkResource);
                        // 上传截图
                        File snapshot = new File(content.getAppLink() + "/snapshot");
                        File snapshotPic[] = snapshot.listFiles();
                        for (int j = 0; j < snapshotPic.length; j++) {
                            File pic = new File(content.getAppLink() + "/snapshot/" + snapshotPic[j].getName());
                            String picName = uploadPic(content.getAppLink() + "/snapshot/" + snapshotPic[j].getName(), pic, false);
                            if (picName == null) {
                                content.setStatus(-1);
                                if (content.getMessage().equals("") || content.getMessage() == null) {
                                    content.setMessage("截图上传失败");
                                } else {
                                    content.setMessage(",截图上传失败");
                                }
                            }
                            AppResource picResource = new AppResource();
                            picResource.setAccountId(accountId);
                            picResource.setResType(0);
                            picResource.setResUrl(picName);
                            appResources.add(picResource);
                        }
                        content.setAppResources(appResources);
                        // 创建应用 操作数据库
                        if (content.getStatus() != -1) {
                            succeed++;
                            int status = bulkUploadService.importToDataSource(content);
                            content.setStatus(status);
                        }
                    }
                }
            }
            if (content.getStatus() == -1) {
                failed++;
            }
            processed++;
            if (processed % 10 == 0) {
                ImportAppLog processImport = new ImportAppLog();
                processImport.setId(importId);
                processImport.setProcessed(processed);
                processImport.setSucceed(succeed);
                processImport.setFailed(failed);
                bulkUploadService.processImport(processImport);
            }

        }
        ImportAppLog completeImport = new ImportAppLog();
        completeImport.setId(importId);
        completeImport.setFailed(failed);
        completeImport.setProcessed(processed);
        completeImport.setSucceed(succeed);
        completeImport.setStatus(1);
        bulkUploadService.completeImport(completeImport);

        // 重写excel
        String message = CreateExcel.newExcel(list, targetDirectory + newFileName);
        //总计10个应用，成功上传0个，失败10个。+excelTemp/D29AF63E63884778AFEB1D225E08B385_report.xlsx
        String tempNewName = message.substring(message.lastIndexOf("excel/"), message.length());
        String str = null;
        try {
            File srcTarget = new File(bulkUploadService.getUploadExcelPath() + "/" + tempNewName);
            str = tempNewName;
        } catch (Exception e) {
            logger.info("导入报告上传云服务器异常", e);
            e.printStackTrace();
        }
        ImportAppLog uploadExcelLog = new ImportAppLog();
        uploadExcelLog.setId(importId);
        uploadExcelLog.setExcelUrl(str);
        uploadExcelLog.setStatus(2);
        bulkUploadService.uploadExcelLog(uploadExcelLog);
        return message;
    }

    private String uploadApk(String apkName, File file, String pkgName, String versionCode) {
        String targetDirectory = bulkUploadService.getUploadReAPKPath() + "/" + this.account;
        String extName = apkName.substring(apkName.lastIndexOf("."));
        String newName = Util.getUuid() + extName;
        String str = null;
        try {
            File target = new File(targetDirectory, newName);
            FileUtils.copyFile(file, target);
            str = this.account + "/" + newName;
        } catch (Exception e) {
            logger.info("文件目录：" + targetDirectory + " 文件名：" + apkName, e);
            e.printStackTrace();
        }
        return str;
    }

    private String uploadPic(String picName, File file, boolean flag) {
        String targetDirectory = null;
        if (flag) {
            targetDirectory = bulkUploadService.getUploadCoverPicPath() + "/" + this.account;
        } else {
            targetDirectory = bulkUploadService.getUploadImgPicPath() + "/" + this.account;
        }
        String extName = picName.substring(picName.lastIndexOf("."));
        String newName = Util.getUuid() + extName;
        String dest = null;
        try {
            File target = new File(targetDirectory, newName);
            FileUtils.copyFile(file, target);
            dest = this.account + "/" + newName;
        } catch (Exception e) {
            logger.info("文件目录：" + targetDirectory + " 文件名：" + picName, e);
            e.printStackTrace();
        }
        return dest;
    }

    public BulkUploadService getBulkUploadService() {
        return bulkUploadService;
    }

    public void setBulkUploadService(BulkUploadService bulkUploadService) {
        this.bulkUploadService = bulkUploadService;
    }

    public BulkImportService getBulkImportService() {
        return bulkImportService;
    }

    public void setBulkImportService(BulkImportService bulkImportService) {
        this.bulkImportService = bulkImportService;
    }

    public JssAppManager getJssAppManager() {
        return jssAppManager;
    }

    public void setJssAppManager(JssAppManager jssAppManager) {
        this.jssAppManager = jssAppManager;
    }

    public ImageManager getImageManager() {
        return imageManager;
    }

    public void setImageManager(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    public String getTargetDirectory() {
        return targetDirectory;
    }

    public void setTargetDirectory(String targetDirectory) {
        this.targetDirectory = targetDirectory;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getSuperRoleId() {
        return superRoleId;
    }

    public void setSuperRoleId(int superRoleId) {
        this.superRoleId = superRoleId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
