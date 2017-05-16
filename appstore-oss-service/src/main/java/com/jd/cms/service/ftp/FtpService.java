package com.jd.cms.service.ftp;

/**
 * Created with IntelliJ IDEA.
 * User: gaoyang
 * Date: 13-3-8
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public interface FtpService {

    /**
     * 下载全量更新文件并返回绝对路径
     * @return
     */
    String downloadFullAppFile();

    /**
     * 下载增量更新文件并返回绝对路径
     * @return
     */
    String downloadNewAppFile();


}
