package com.jd.cms.job;

import com.jd.cms.service.schedule.ZhuoWangInfoImportService;
import com.jd.cms.util.ZhuoWangAppsGetAccountIdUtil;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-7
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangFullAppJob implements Runnable {
    private ZhuoWangInfoImportService zhuoWangInfoImportService;
    private ZhuoWangAppsGetAccountIdUtil zhuoWangAppsGetAccountIdUtil;
    Logger logger = Logger.getLogger(this.getClass());

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private boolean running=false;

    public void run() {
        running=true;
        try{
            logger.info("卓望全量数据导入线程启动");
            zhuoWangInfoImportService.importFullApp();
        }catch (Exception e){
            logger.info("同步异常");
        }
        running=false;

    }


    public ZhuoWangInfoImportService getZhuoWangInfoImportService() {
        return zhuoWangInfoImportService;
    }

    public void setZhuoWangInfoImportService(ZhuoWangInfoImportService zhuoWangInfoImportService) {
        this.zhuoWangInfoImportService = zhuoWangInfoImportService;
    }

    public void setZhuoWangAppsGetAccountIdUtil(ZhuoWangAppsGetAccountIdUtil zhuoWangAppsGetAccountIdUtil) {
        this.zhuoWangAppsGetAccountIdUtil = zhuoWangAppsGetAccountIdUtil;
    }
}
