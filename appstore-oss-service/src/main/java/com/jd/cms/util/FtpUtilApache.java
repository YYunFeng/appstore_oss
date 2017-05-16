package com.jd.cms.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FtpUtilApache {

    private Logger log = Logger.getLogger(this.getClass());

    private String ip;
    private int port;
    private String username;
    private String password;

    private String local_dir;
    private String remote_dir;
    private boolean isLogin = false;

    private FTPClient ftpclient;

    public FtpUtilApache(String ip, Integer port, String userName, String password) {

        ftpclient = new FTPClient();
        this.ip = ip;
        this.port = port;
        this.username = userName;
        this.password = password;
        try {
            log.info("正在连接FTP服务器.." + this.ip + ":" + this.port);
            ftpclient.connect(this.ip, this.port);
            int reply = ftpclient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpclient.disconnect();
                log.error("FTP服务器拒绝连接");
                this.isLogin = false;
            }
            if (username != null) {
                if (!ftpclient.login(this.username, this.password)) {
                    ftpclient.disconnect();
                    this.isLogin = false;
                    log.error("登陆验证失败，请检查账号和密码是否正确");
                } else {
                    log.info("登陆成功");
                    this.isLogin = true;
                }
            }
        } catch (SocketException e) {
            log.error("无法连接至指定FTP服务器:" + e.getMessage());
            this.isLogin = false;
        } catch (IOException e) {
            this.isLogin = false;
            log.error("无法用指定用户名和密码连接至指定FTP服务器:" + e.getMessage());
        }
    }


    public boolean isLogin() {
        return this.isLogin;
    }


    /**
     * 从FTP指定的路径下载文件
     *
     * @param remotePath
     * @param localPath
     */
    public void downloadFile(String remotePath, String localPath, String fileName)
            throws Exception {

        OutputStream output = null;
        try {
            File file = null;
            if (checkFileExist(localPath)) {
                file = new File(localPath + fileName);
            }
            output = new FileOutputStream(file);
            log.info("下载文件:" + remotePath + fileName);
            boolean result = ftpclient.retrieveFile(remotePath + fileName, output);
            log.info("下载文件状态:" + result);
            if (!result) {
                throw new Exception("文件下载失败!");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (output != null) {
                output.close();
            }
        }

    }

    /**
     * 改变工作目录，如失败则创建文件夹
     *
     * @param remoteFoldPath
     */
    public void changeDirectory(String remoteFoldPath) throws Exception {

        if (remoteFoldPath != null) {
            boolean flag = ftpclient.changeWorkingDirectory(remoteFoldPath);
            log.info("切换目录:" + remoteFoldPath + " " + flag);
            if (!flag) {
                log.info("切换目录失败");
                boolean temp = ftpclient.makeDirectory(remoteFoldPath);
                log.info("创建目录:" + remoteFoldPath + " 状态:" + temp);
                temp = ftpclient.changeWorkingDirectory(remoteFoldPath);
                log.info("切换目录:" + remoteFoldPath + " 状态:" + temp);
            }
        }

    }

    /**
     * 从FTP指定的路径下载文件
     *
     * @param remoteFilePath
     * @return
     * @throws Exception
     */
    public InputStream downFile(String remoteFilePath) throws Exception {
        return ftpclient.retrieveFileStream(remoteFilePath);
    }

    /**
     * 获取FTP服务器上指定路径下的文件列表
     *
     * @param filePath
     * @return
     */
    public List<String> getFtpServerFileList(String filePath) throws Exception {
        List<String> nlist = new ArrayList<String>();
        FTPListParseEngine engine = ftpclient.initiateListParsing(filePath);
        List<FTPFile> ftpfiles = Arrays.asList(engine.getNext(25));
        return getFTPServerFileList(nlist, ftpfiles);
    }

    public void close() throws Exception {
        ftpclient.disconnect();
        log.info("关闭FTP连接成功");
    }


    public boolean checkFileSize(String filename) {
        log.info("验证FTP服务器上的文件是否正确");
        boolean flag = false;
        try {
            //判断本地文件是否存在并获取大小
            File localfile = new File(filename);
            long filesize = 0;
            if (localfile.exists() && localfile.isFile() && localfile.length() > 0) {
                filesize = localfile.length();
                filename = localfile.getName();
                List<FTPFile> ftpfiles = Arrays.asList(ftpclient.listFiles());
                for (int i = 0; i < ftpfiles.size(); i++) {
                    if (ftpfiles.get(i).isFile() && ftpfiles.get(i).getName().indexOf(filename) > -1) {
                        log.info("文件名一致");
                        if (ftpfiles.get(i).getSize() > 0 && ftpfiles.get(i).getSize() == filesize) {
                            log.info("文件大小一致");
                            log.info("验证文件通过,FTP上的文件大小:" + ftpfiles.get(i).getSize() / 1024 + "KB");
                            flag = true;
                        } else {
                            log.error("验证文件失败,文件大小不一致。FTP上的文件大小:" + ftpfiles.get(i).getSize() / 1024 + "KB");
                            flag = false;
                        }
                    }
                }
                if (!flag) {
                    log.error("验证文件失败,FTP中没有该文件");
                }
            } else {
                log.error("本地文件不正确");
            }

        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 获取FTP服务器上指定路径下的文件列表
     *
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getFileList(String path) throws Exception {

        List<String> nlist = new ArrayList<String>();

        List<FTPFile> ftpfiles = Arrays.asList(ftpclient.listFiles(path));

        return getFTPServerFileList(nlist, ftpfiles);
    }

    /**
     * 列出FTP服务器文件列表信息
     *
     * @param nlist
     * @param ftpFiles
     * @return
     */
    public List<String> getFTPServerFileList(List<String> nlist,
                                             List<FTPFile> ftpFiles) {
        if (ftpFiles == null || ftpFiles.size() == 0)
            return nlist;
        for (FTPFile ftpFile : ftpFiles) {
            if (ftpFile.isFile()) {
                nlist.add(ftpFile.getName());
            }
        }
        return nlist;
    }

    /**
     * 检查文件是否存在
     *
     * @param path
     * @return
     * @throws Exception
     */
    public boolean checkFileExist(String path) throws Exception {
        boolean flag = false;
        File file = new File(path);
        if (file.exists()) {
            flag = true;
        } else {
            file.mkdirs();
            log.info("路径:" + path + " 不存在,建立文件夹");
        }
        if (!file.exists()) {
            throw new Exception("建立文件夹失败");
        } else {
            flag = true;
        }
        return flag;
    }

}
