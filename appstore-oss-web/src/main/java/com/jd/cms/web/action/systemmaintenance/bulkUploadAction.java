package com.jd.cms.web.action.systemmaintenance;

import com.jd.appstore.domain.ImportAppLog;
import com.jd.cms.common.util.ClientIp;
import com.jd.cms.common.util.Util;
import com.jd.cms.domain.systemmaintenance.ZhuoWangFullAppStatusJSON;
import com.jd.cms.job.SoftImport;
import com.jd.cms.job.ZhuoWangFullAppJob;
import com.jd.cms.service.login.LoginService;
import com.jd.cms.service.systemmaintenance.BulkImportService;
import com.jd.cms.service.systemmaintenance.BulkUploadService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.util.StringUtils;
import com.jd.common.web.result.Result;
import com.jd.digital.common.rpc.manager.img.ImageManager;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;
import com.jd.digital.common.util.tool.WebHelper;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-22
 * Time: 上午11:26
 * To change this template use File | Settings | File Templates.
 */
public class bulkUploadAction extends BaseAction {
    private BulkUploadService bulkUploadService;
    private BulkImportService bulkImportService;
    private int id;
    private SoftImport softImport;
    private ZhuoWangFullAppJob zhuoWangFullAppJob;
    private String cpName;
    private int pageSize = 10;
    private JssAppManager jssAppManager;
    private ImageManager imageManager;
    private File uploadFile;
    private String uploadContentType;
    private String uploadFileName;
    private String savePath;
    private String fileName;
    private LoginService loginService;

    public String bulkUploadStart() throws Exception {
        String adminId = WebHelper.getPin();
        String ip = ClientIp.getIp(request);
        Result result = bulkUploadService.loadUpload(adminId);
        result.addDefaultModel("adminId", adminId);
        result.addDefaultModel("ip", ip);
        toVm(result);
        return "bulkUploadStart";
    }

    public void updateImport() {
        bulkUploadService.updateImport(id);
    }

    public String findCPList() {
        try {
            Result result = bulkUploadService.findCpList(page, pageSize, cpName);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cpList";
    }

    public void load() throws Exception {

    }

    public void deleteImportLog() {
        ImportAppLog importAppLog = new ImportAppLog();
        importAppLog.setAdminId(id);
        bulkUploadService.deleteImportLog(importAppLog);
    }

    public void uploadExcel() throws Exception {
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int appType = Integer.parseInt(request.getParameter("appType"));
        String adminId = request.getParameter("adminId");
        String account = request.getParameter("account");
        String ip = request.getParameter("ip");
        String targetDirectory = bulkUploadService.getUploadExcelPath() + "/";
        String extName = "";
        String newFileName = "";

        File fl = new File(targetDirectory);
        if (!fl.exists()) {
            fl.mkdirs();
        }
        String names[] = ((MultiPartRequestWrapper) this.request).getFileNames("uploadFile");

        if (names[0].lastIndexOf(".") >= 0) {
            extName = names[0].substring(names[0].lastIndexOf("."));
        }
        newFileName = Util.getUuid() + extName;
        try {
            File target = new File(targetDirectory, newFileName);
            FileUtils.copyFile(uploadFile, target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int superRoleId = bulkUploadService.findSuperRoleId(adminId);
        ImportAppLog importAppLog = new ImportAppLog();
        importAppLog.setAdminId(superRoleId);
        importAppLog.setCpAccount(accountId);
        importAppLog.setAppType(appType);

        bulkUploadService.deleteImportLog(importAppLog);

        softImport.setTargetDirectory(targetDirectory);
        softImport.setNewFileName(newFileName);
        softImport.setAccountId(accountId);
        softImport.setAdminId(adminId);
        softImport.setIp(ip);
        softImport.setAppType(appType);
        softImport.setAccount(account);
        softImport.setSuperRoleId(superRoleId);
        Thread thread = new Thread(softImport);
        thread.start();

        String message = "上传线程已开启";
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(message);

    }

    /**
     * 检查是否有卓望数据同步的权限
     */
    public void CheckPowerForZhuoWangApp(){

    }

    /**
     * 卓望数据的同步
     *
     */
    public void zhuoWangApp() throws IOException, JSONException {
        ZhuoWangFullAppStatusJSON zhuoWangFullAppStatusJSON = new ZhuoWangFullAppStatusJSON();
        if (zhuoWangFullAppJob != null && !zhuoWangFullAppJob.isRunning()) {
            Thread thread = new Thread(zhuoWangFullAppJob);
            thread.start();
            zhuoWangFullAppStatusJSON.setCode("0");
            zhuoWangFullAppStatusJSON.setStatus(true);
            zhuoWangFullAppStatusJSON.setMess("卓望全量数据开始同步！");
        } else {
            zhuoWangFullAppStatusJSON.setCode("-1");
            zhuoWangFullAppStatusJSON.setStatus(false);
            zhuoWangFullAppStatusJSON.setMess("卓望全量数据正在同步，请耐心等待！");
        }
        String json = JSONUtil.serialize(zhuoWangFullAppStatusJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath("");
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSoftImport(SoftImport softImport) {
        this.softImport = softImport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZhuoWangFullAppJob(ZhuoWangFullAppJob zhuoWangFullAppJob) {
        this.zhuoWangFullAppJob = zhuoWangFullAppJob;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
