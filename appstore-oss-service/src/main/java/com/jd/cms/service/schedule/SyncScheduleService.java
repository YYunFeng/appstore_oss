package com.jd.cms.service.schedule;

import org.quartz.Scheduler;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-20
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public interface SyncScheduleService {


    void syncTotalSchedule(Scheduler scheduler);

    void actDateSyncSchedule(Scheduler scheduler);

    void contractExpirationWarningSchedule(Scheduler scheduler);

    void downloadStatisticalDailySchedule(Scheduler scheduler);

    void updateTopSchedule(Scheduler scheduler);

    void importNewAppSchedule(Scheduler scheduler);

    void createIncomeStatistic();

    /**
     * 获取每日促销员的到达数据
     */
    void salerStatistic();
}
