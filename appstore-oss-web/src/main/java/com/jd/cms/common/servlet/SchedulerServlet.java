package com.jd.cms.common.servlet;

import com.jd.cms.job.ErpTotalScheduleJob;
import com.jd.cms.manager.schedule.ErpScheduleManager;
import com.jd.cms.service.schedule.ErpScheduleService;
import com.jd.cms.service.schedule.SyncScheduleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.text.ParseException;

/**
 * User: Administrator
 * Date: 12-7-23
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class SchedulerServlet extends HttpServlet {
    private final static Log log = LogFactory.getLog(SchedulerServlet.class);
    /**
     * 静态调度器对像哦
     */
    private static Scheduler scheduler;

    /**
     * 获取Scheduler调度器对像
     * @return
     */
    public static Scheduler getInstanceScheduler() {
        return scheduler;
    }



    /**
     * 初始化Servlet
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取ApplicationContext
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        //获取Scheduler调度器对像
        scheduler = (Scheduler) context.getBean("appstoreScheduler", Scheduler.class);
        //获取同步任务Service
        SyncScheduleService syncScheduleService = (SyncScheduleService) context.getBean("syncScheduleService");
        //获取ERP同步任务Service
        ErpScheduleService erpScheduleService = (ErpScheduleService) context.getBean("erpScheduleService");
        //获取ERP同步任务Manager
        ErpScheduleManager erpScheduleManager = (ErpScheduleManager) context.getBean("erpScheduleManager");
        //周期性后台任务调度
        syncScheduleService.syncTotalSchedule(scheduler);
        //ERP后台任务调度
        erpTotalSchedule(scheduler, erpScheduleService, erpScheduleManager);
    }

    /**
     * ERP后台任务调度
     * @param scheduler
     * @param erpScheduleService
     * @param erpScheduleManager
     */
    public void erpTotalSchedule(Scheduler scheduler, ErpScheduleService erpScheduleService, ErpScheduleManager erpScheduleManager) {
        //实例化JOB类
        JobDetail jobDetail = new JobDetailBean();
        //设置jobID
        jobDetail.setName("erpTotalSchedule");
        //设置业务参数
        jobDetail.getJobDataMap().put("scheduler", scheduler);
        //设置业务参数
        jobDetail.getJobDataMap().put("erpScheduleService", erpScheduleService);
        //设置业务参数
        jobDetail.getJobDataMap().put("erpScheduleManager", erpScheduleManager);
        //设置处理作业的类
        jobDetail.setJobClass(ErpTotalScheduleJob.class);
        //创建周期时间
        String sCronExpression = "0 */2 * * * ?";
        //创建触发器
        getCronTrigger(jobDetail, scheduler, sCronExpression);
    }

    /**
     * ERP后台任务触发器
     * @param jobDetail
     * @param scheduler
     * @param cronExpression
     */
    public void getCronTrigger(JobDetail jobDetail, Scheduler scheduler, String cronExpression) {
        try {
            //添加Job
            scheduler.addJob(jobDetail, true);
            //设置触发器
            CronTrigger cronTrigger = new CronTrigger(jobDetail.getName(), Scheduler.DEFAULT_GROUP, jobDetail.getName(), Scheduler.DEFAULT_GROUP);
            //设置触发时间
            cronTrigger.setCronExpression(cronExpression);
            //将触发器加入调度器
            scheduler.scheduleJob(cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
