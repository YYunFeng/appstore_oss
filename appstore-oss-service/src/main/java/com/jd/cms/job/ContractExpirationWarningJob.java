package com.jd.cms.job;

import com.jd.appstore.domain.CpBaseInfo;
import com.jd.appstore.domain.CpReginfo;
import com.jd.cms.domain.taskmanager.CpInfoResult;
import com.jd.cms.manager.schedule.SyncScheduleManager;
import com.jd.digital.common.rpc.domain.bean.CommonResult;
import com.jd.digital.common.rpc.manager.email.EmailManager;
import com.jd.digital.common.rpc.manager.sms.SMSManager;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-26
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 * 合同到期预警检测JOB
 */
public class ContractExpirationWarningJob extends QuartzJobBean implements StatefulJob {
    /**
     * execute方法，默执行的方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //从JobExecutionContext获取jobDetail对像
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //从JobDetail获取SyncScheduleManager对像
        SyncScheduleManager syncScheduleManager = (SyncScheduleManager) jobDetail.getJobDataMap().get("syncScheduleManager");
        //从JobDetail获取EmailManager对像
        EmailManager emailManager = (EmailManager) jobDetail.getJobDataMap().get("emailManager");
        //从JobDetail获取SMSManager对像
        SMSManager smsManager = (SMSManager) jobDetail.getJobDataMap().get("smsManager");
        //查询差一个月到期的cp
        List<CpInfoResult> cpInfoResultList = syncScheduleManager.findCpInfoResult();
        if (null != cpInfoResultList && cpInfoResultList.size() > 0) {
            CpBaseInfo cpBaseInfo;
            //循环给差一个到期的cp发送邮件和短信
            for (int i = 0; i < cpInfoResultList.size(); i++) {
                cpBaseInfo = new CpBaseInfo();
                //设置cp帐号
                cpBaseInfo.setId(cpInfoResultList.get(i).getAccountId());
                //获取手机绑定状态
                Integer mobileBinded = cpInfoResultList.get(i).getMobileBinded();
                //获取Email验证状态
                Integer emailChecked = cpInfoResultList.get(i).getEmailChecked();
                //获取是否发送预警邮件1
                Integer mailSent1 = cpInfoResultList.get(i).getMailSent1();
                if (null == mailSent1) {
                    mailSent1 = 0;
                }
                //获取是否发送预警邮件2
                Integer mailSent2 = cpInfoResultList.get(i).getMailSent2();
                if (null == mailSent2) {
                    mailSent2 = 0;
                }
                //获取是否发送短信预警
                Integer smsSent2 = cpInfoResultList.get(i).getSmsSent2();
                if (null == smsSent2) {
                    smsSent2 = 0;
                }
                if (null != mobileBinded && 1 == mobileBinded && 1 != smsSent2) {
                    //调用短信接口
                    CommonResult commonResult = smsManager.sendSMS(cpInfoResultList.get(i).getMobile(), "你中大奖了", "");/*CP绑定手机号*/

                    //短信发送是否成功
                    if (commonResult.isSuccess()) {
                        //设置短信已发送标识
                        cpBaseInfo.setSmsSent2(1);
                    } else {
                        //设置短信未发送标识
                        cpBaseInfo.setSmsSent2(0);
                    }
                }
                if (null != emailChecked && 1 == emailChecked && 1 != mailSent1) {
                    //调用Email接口
                    CommonResult commonResult = emailManager.sendEmail("<xml><email>" + cpInfoResultList.get(i).getEmail() + "</email><content>" + "发送CP绑定邮箱测试邮件" + "</content></xml>");/*CP绑定邮箱*/
                    if (commonResult.isSuccess()) {
                        //设置邮件1已发送标识
                        cpBaseInfo.setMailSent1(1);
                    } else {
                        //设置邮件1未发送标识
                        cpBaseInfo.setMailSent1(0);
                    }
                }
                if (1 != mailSent2) {
                    //调用Email接口
                    CommonResult commonResult = emailManager.sendEmail("<xml><email>abc@gmail.com</email><content>发送CMS管理邮箱测试邮件</content></xml>");/*CMS管理邮箱*/
                    if (commonResult.isSuccess()) {
                        //设置邮件1已发送标识
                        cpBaseInfo.setMailSent2(1);
                    } else {
                        //设置邮件1未发送标识
                        cpBaseInfo.setMailSent2(0);
                    }
                }
                //更新合同预警状态
                syncScheduleManager.updateCpBaseInfo(cpBaseInfo);
            }
        }
        //根据合到期预警检测同步任务ID更新实际执行时间
        syncScheduleManager.updateTaskFactTime(Integer.parseInt(jobDetail.getName()), new Date());
    }
}
