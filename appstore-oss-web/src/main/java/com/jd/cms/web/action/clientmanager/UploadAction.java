package com.jd.cms.web.action.clientmanager;

import com.jd.cms.aliyun.AliyunService;
import com.jd.cms.common.util.Util;
import com.jd.cms.service.clientmanager.UploadService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.util.StringUtils;
import com.jd.digital.common.rpc.manager.img.ImageManager;
import com.jd.digital.common.rpc.manager.jss.JssAppManager;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
public class UploadAction extends BaseAction {
    private File uploadFile;
    private String uploadContentType;
    private String uploadFileName;
    private String fileName;
    private String savePath;
    private ImageManager imageManager;
    private JssAppManager jssAppManager;
    private UploadService uploadService;

    private AliyunService aliyunService;

    private Integer flag;

    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
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

    public void uploadImg() throws IOException {
        // 上传到专题目录
        String targetDirectory = "";
        if (flag != null && flag.intValue() == 1) {
            targetDirectory = uploadService.getTopPath() + "/";
        } else if (flag != null && flag.intValue() == 2) {
            targetDirectory = uploadService.getActivity() + "/";
        } else if (flag != null && flag.intValue() == 3) {
            targetDirectory = uploadService.getSuningPackAge() + "/";
        } else if (flag != null && flag.intValue() == 4) {
            targetDirectory = uploadService.getCpDateFile() + "/";
        } else {
            targetDirectory = uploadService.getPicPath() + "/";
        }
        String extName = "";
        String newFileName = "";
        String str = null;
        File fl = new File(targetDirectory);
        if (!fl.exists()) {
            fl.mkdirs();
        }
        String names[] = ((MultiPartRequestWrapper) this.request).getFileNames("uploadFile");
        if (names[0].lastIndexOf(".") >= 0) {
            extName = names[0].substring(names[0].lastIndexOf("."));
        }
        newFileName = Util.getUuid() + extName;
        File target = new File(targetDirectory, newFileName);
        FileUtils.copyFile(uploadFile, target);
        if (flag != null && flag.intValue() == 1) {
            String filePath = targetDirectory + "/" + newFileName;
            String eTag = aliyunService.putObject(filePath, "topicImage/" + newFileName, 1);
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(newFileName);
    }

    /*public void uploadImg() throws IOException {
        // 上传到专题目录
        String targetDirectory = "";
        if (flag != null && flag.intValue() == 1) {
            targetDirectory = uploadService.getTopPath() + "/";
        } else if (flag != null && flag.intValue() == 2) {
            targetDirectory = uploadService.getActivity() + "/";
        } else if (flag != null && flag.intValue() == 3) {
            targetDirectory = uploadService.getSuningPackAge() + "/";
        } else if (flag != null && flag.intValue() == 4) {
            targetDirectory = uploadService.getCpDateFile() + "/";
        } else {
            targetDirectory = uploadService.getPicPath() + "/";
        }

        String extName = "";
        String newFileName = "";
        String str = null;
        File fl = new File(targetDirectory);
        if (!fl.exists()) {
            fl.mkdirs();
        }
        String names[] = ((MultiPartRequestWrapper) this.request).getFileNames("uploadFile");
        if (names[0].lastIndexOf(".") >= 0) {
            extName = names[0].substring(names[0].lastIndexOf("."));
        }
        newFileName = Util.getUuid() + extName;
        File target = new File(targetDirectory, newFileName);
        FileUtils.copyFile(uploadFile, target);

        response.setCharacterEncoding("utf-8");
        response.getWriter().write(newFileName);
    }*/


    /**
     * 上传客户端
     *
     * @throws Exception
     */
    public void uploadClientVersion() throws Exception {
        String targetDirectory = uploadService.getAndroidCilentPath() + "/";
        String extName = "";
        String newFileName = "";
        String str = null;
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
            str = newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(str);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public void setAliyunService(AliyunService aliyunService) {
        this.aliyunService = aliyunService;
    }
}
