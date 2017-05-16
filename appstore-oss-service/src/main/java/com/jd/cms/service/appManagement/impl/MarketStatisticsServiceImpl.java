package com.jd.cms.service.appManagement.impl;

import com.jd.appstore.domain.InstallStat;
import com.jd.cms.manager.appManagement.MarketStatisticsManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.service.appManagement.MarketStatisticsService;
import com.jd.common.web.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-11
 * Time: 下午4:45
 * To change this template use File | Settings | File Templates.
 */
public class MarketStatisticsServiceImpl implements MarketStatisticsService {
    private MarketStatisticsManager marketStatisticsManager;

    /**
     * 统计应用的总安装量
     *
     * @param startTime
     * @param endTime
     * @param flag
     * @return
     */
    public Result getMarketStat(String startTime, String endTime, Integer flag) {
        Result result = new Result();
        result.addDefaultModel("marketOutput", marketStatisticsManager.getMarketStat(startTime, endTime, flag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 按应用查看
     *
     * @param startTime
     * @param endTime
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result statByApp(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("statOfflineByApp", marketStatisticsManager.statByApp(startTime, endTime, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }


    /**
     * 某个应用按渠道统计安装次数
     *
     * @param startTime
     * @param endTime
     * @param appId
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */

    public Result appGetMarketStatByChannel(String startTime, String endTime, Integer appId, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("marketOutputByChannel", marketStatisticsManager.appGetMarketStatByChannel(startTime, endTime, appId, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 应用每个渠道下按促销员查看
     *
     * @param startTime
     * @param endTime
     * @param appId
     * @param cid
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result appStatsChannelBySaler(String startTime, String endTime, Integer appId, Integer cid, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("appStatsChannelBySaler", marketStatisticsManager.appStatsChannelBySaler(startTime, endTime, appId, cid, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 按渠道查看
     *
     * @param startTime
     * @param endTime
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result statByChannel(String startTime, String endTime, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("statOfflineByChannel", marketStatisticsManager.statByChannel(startTime, endTime, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 离线应用 渠道下按应用查看
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result statChannelByApps(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("statChannelByApps", marketStatisticsManager.statChannelByApps(startTime, endTime, cId, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 渠道下按促销员查看安装次数
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result channlStatBySaler(String startTime, String endTime, int cId, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("channlStatBySaler", marketStatisticsManager.channlStatBySaler(startTime, endTime, cId, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    /**
     * 促销员按应用查看安装次数
     *
     * @param startTime
     * @param endTime
     * @param cId
     * @param saler
     * @param pageIndex
     * @param pageSize
     * @param flag
     * @return
     */
    public Result salerStatsByApps(String startTime, String endTime, int cId, String saler, int pageIndex, int pageSize, Integer flag,Integer statsFlag) {
        Result result = new Result();
        result.addDefaultModel("salerStatsByApps", marketStatisticsManager.salerStatsByApps(startTime, endTime, cId, saler, pageIndex, pageSize, flag,statsFlag));
        result.addDefaultModel("flag", flag);
        return result;
    }

    public void insertOfflineAppStat() {
        List<Integer> appIdList = marketStatisticsManager.getAppIdFromTopicApp();
        int count = 0;
        for (int i = 1; i <= 30; i++) { // 时间3月1号到3月30号
            for (int j = 1; j <= 30; j++) {  //  促销员从SH001到SH030
                int n = appIdList.size();

                List<Integer> randTempList = new ArrayList<Integer>();
                int rand = 0; // 取到的随机数
                boolean flag = false;// 标示  当第一次不比较randTemp和rand的值
                int appId = 0;
                for (int k = 0; k < 10; k++) { // 随机取20个应用算每天的安装量
                    count = count + 1;
                    Random random = new Random();
                    if (!flag) {
                        rand = random.nextInt(n);
                        appId = appIdList.get(rand);
                        randTempList.add(rand);
                    }
                    while (flag) {
                        rand = random.nextInt(n);
                        if (!isHas(rand, randTempList)) {
                            appId = appIdList.get(rand);
                            randTempList.add(rand);
                            break;
                        }
                    }
                    flag = true;
                    InstallStat installStat = new InstallStat();
                    installStat.setYear(2013);
                    installStat.setMonth(4);
                    installStat.setDay(i);
                    installStat.setAppId(appId);
                    installStat.setCid(133);
                    if (j < 10) {
                        installStat.setSaler("SH00" + j);
                    } else {
                        installStat.setSaler("SH0" + j);
                    }
                    installStat.setInstallTimes((int) (Math.random() * 10) + 1);
                    marketStatisticsManager.insertOfflineAppStat(installStat);
                }
            }
        }
        System.out.println("count----------->" + count);
    }

    private static boolean isHas(int tempRandomNum, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (tempRandomNum == arr.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void setMarketStatisticsManager(MarketStatisticsManager marketStatisticsManager) {
        this.marketStatisticsManager = marketStatisticsManager;
    }
}