package com.jd.cms.service.ftp.impl;

import com.jd.cms.service.ftp.FtpService;
import com.jd.cms.util.FtpUtilApache;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-3-8
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class FtpServiceImpl implements FtpService {
//
//    private String ip = "127.0.0.1";
//    private Integer port = 21;
//    private String userName = "test";
//    private String password = "test";
//    private String remotePath = "";
//    private String localPath = "d:/ftpdownload";

    private String ip;
    private Integer port;
    private String userName;
    private String password;
    private String remotePath;
    private String localPath;
    private FtpUtilApache ftpUtilApache;

    private static final int APPFULL_FILE = 0;
    private static final int APPNEW_FILE = 1;
    private static final String APPFULL_FILE_NAME = "APPFull_";
    private static final String APPNEW_FILE_NAME = "APPNew_";


    private Logger logger = Logger.getLogger(this.getClass());

    public String downloadFullAppFile() {
        String result = null;
        try {
            logger.info("全量数据导入下载文件开始");
            ftpUtilApache = new FtpUtilApache(this.ip, this.port, this.userName, this.password);
            //登录成功
            if (ftpUtilApache.isLogin()) {
                String newestFileName = getNewestFileName(APPFULL_FILE);
                if (newestFileName != null) {
                    ftpUtilApache.downloadFile(remotePath, this.localPath, newestFileName);
                    if (isDownloadFinish(this.localPath + newestFileName))
                        result = this.localPath + newestFileName;
                }
            }
            logger.info("全量数据导入下载文件结束.");
        } catch (Exception e) {
            logger.error("全量数据导入文件下载异常:" + e.getMessage());
        }
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public String downloadNewAppFile() {
        String result = null;
        try {
            logger.info("增量数据导入下载文件开始");
            ftpUtilApache = new FtpUtilApache(this.ip, this.port, this.userName, this.password);
            //登录成功
            if (ftpUtilApache.isLogin()) {
                String newestFileName = getNewestFileName(APPNEW_FILE);
                if (newestFileName != null) {
                    //先判断本地是否已经有这个文件了,如果有了就不再下载了并且返回null;
                    if (!isDownloadFinish(this.localPath + newestFileName)) {
                        ftpUtilApache.downloadFile(remotePath, this.localPath, newestFileName);
                        if (isDownloadFinish(this.localPath + newestFileName))
                            result = this.localPath + newestFileName;
                    } else {
                        logger.info("增量数据导入下载失败:本地已经包含此文件");
                        return null;
                    }
                }
            }
            logger.info("增量数据导入下载文件结束.");
        } catch (Exception e) {
            logger.error("增量数据导入文件下载异常:" + e.getMessage());
        }
        return result;
    }


    /**
     * 判断文件确实已经下载到本地
     *
     * @param path
     * @return
     */
    private Boolean isDownloadFinish(String path) {
        try {
            File csvFile = new File(path);
            if (csvFile.isFile() && csvFile.canRead())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    /**
     * 根据fileType获取最新的文件名
     *
     * @param fileType
     * @return
     */
    private String getNewestFileName(int fileType) {
        logger.info("获取最新文件....");
        String result = null;
        try {
            List<String> fileNameList = ftpUtilApache.getFileList(remotePath);
            List<String> fileDateList = null;
            if (fileNameList != null && fileNameList.size() > 0) {
                String fileDateStr = "";
                String containsStr = "";
                if (fileType == APPFULL_FILE)
                    containsStr = APPFULL_FILE_NAME;
                if (fileType == APPNEW_FILE)
                    containsStr = APPNEW_FILE_NAME;
                fileDateList = new ArrayList<String>();
                for (String fileName : fileNameList) {
                    if (StringUtils.contains(fileName, containsStr)) {
                        fileDateStr = fileName.substring(fileName.indexOf("_") + 1, fileName.indexOf("."));
                        fileDateList.add(fileDateStr);
                    }
                }
                //当前时间
                Date current = new Date();
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                //时间差异
                long timeDifference = 0;
                //最大时间差异
                long topTimeDifference = 0;
                //最大时间差异的时间字符串
                String topTimeDifferenceStr = "";
                for (String fileDate : fileDateList) {
                    timeDifference = current.getTime() - df.parse(fileDate).getTime();
                    if (topTimeDifference == 0)
                        topTimeDifference = timeDifference;
                    if (topTimeDifference >= timeDifference) {
                        topTimeDifference = timeDifference;
                        topTimeDifferenceStr = fileDate;
                    }
                }
                if (StringUtils.isNotBlank(topTimeDifferenceStr)) {
                    logger.info("最新的文件:" + containsStr + topTimeDifferenceStr + ".csv");
                    result = containsStr + topTimeDifferenceStr + ".csv";
                } else {
                    logger.error("获取最新的文件名错误,fileType:" + fileType);
                }
            }
        } catch (Exception e) {
            logger.error("获取最新的文件名错误,fileType:" + fileType + "," + e.getMessage());
            return null;
        }
        return result;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}
