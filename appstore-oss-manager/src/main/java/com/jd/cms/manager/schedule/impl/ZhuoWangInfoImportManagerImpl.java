package com.jd.cms.manager.schedule.impl;

import com.jd.appstore.domain.*;
import com.jd.cms.dao.schedule.ZhuoWangInfoImportDao;
import com.jd.cms.manager.contains.CommonContants;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.schedule.ZhuoWangInfoImportManager;
import com.jd.common.manager.BaseManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 13-3-4
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class ZhuoWangInfoImportManagerImpl extends BaseManager implements ZhuoWangInfoImportManager {
    private ZhuoWangInfoImportDao zhuoWangInfoImportDao;

    /**
     * 卓望数据入库
     *
     * @param zhuoWangAppMessageList
     * @param accountId
     */
    public void createZhuoWangApp(final List<ZhuoWangAppMessage> zhuoWangAppMessageList, final Integer accountId) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                int size = zhuoWangAppMessageList.size();
                List<Apps> appsList = new ArrayList<Apps>();
                List<AppLog> appLogList = new ArrayList<AppLog>();
                List<AppDetailsLog> appDetailsLogList = new ArrayList<AppDetailsLog>();
                List<AppDetails> appDetailsList = new ArrayList<AppDetails>();
                Apps apps = null;
                AppLog appLog = null;
                AppDetailsLog appDetailsLog = null;
                AppDetails appDetails = null;
                    for (int i = 0; i < size; i++) {
                        if (zhuoWangAppMessageList.get(i).getAddDeleteMark() != null && zhuoWangAppMessageList.get(i).getAddDeleteMark() == 1) {   // 增删标识为1  添加数据
                            if (zhuoWangAppMessageList.get(i).getCompanyCode() != null) {
                                //  app 应用基本信息
                                int appId = (int) sequenceUtil.get(SequenceConstants.APPS) + CommonContants.APPSTORE_APK_SKU_START_NUM;
                                int id = (int) sequenceUtil.get(SequenceConstants.APP_DETAILS);
                                apps = new Apps();
                                apps.setAppId(appId);
                                apps.setDefaultDetailId(id);
                                apps.setAppName(zhuoWangAppMessageList.get(i).getContentMessage());
                                apps.setAppPackage("com.zhuowang.apps." + zhuoWangAppMessageList.get(i).getZhuoWangId());
                                //  0：android-phone；1：android-PAD；2：android-ALL
                                apps.setAppType(0);
                                apps.setCategoryIdl2(zhuoWangAppMessageList.get(i).getCategoryId1Id());
                                apps.setCategoryId1(zhuoWangAppMessageList.get(i).getCategoryId2Id());
                                apps.setZhuoWangMark(1);
                                apps.setDefaultDetailId(id);

                                //  app应用基本信息日志
                                int appLogId = (int) sequenceUtil.get(SequenceConstants.APP_LOG);
                                appLog = new AppLog();
                                appLog.setId(appLogId);
                                appLog.setAppId(appId);
                                appLog.setAppPackage("com.zhuowang.apps." + zhuoWangAppMessageList.get(i).getZhuoWangId());
                                appLog.setAppName(zhuoWangAppMessageList.get(i).getContentMessage());
                                appLog.setAppType(0);
                                appLog.setCategoryIdl2(zhuoWangAppMessageList.get(i).getCategoryId1Id());
                                appLog.setCategoryId1(zhuoWangAppMessageList.get(i).getCategoryId2Id());


                                // app应用详情日志
                                appDetailsLog = new AppDetailsLog();
                                int appDetailsLogId = (int) sequenceUtil.get(SequenceConstants.APP_DETAIL_LOG);
                                appDetailsLog.setId(appDetailsLogId);
                                appDetailsLog.setAppId(appId);
                                appDetailsLog.setAccountId(accountId);
                                appDetailsLog.setAppVersion("1.0.1");
                                appDetailsLog.setAppVersioCode(100);
                                appDetailsLog.setOsVersionId(8);
                                appDetailsLog.setZhuoWangMark(1);
                                appDetailsLog.setLogoUrl(zhuoWangAppMessageList.get(i).getPicUrl1());
                                appDetailsLog.setAppTag(zhuoWangAppMessageList.get(i).getKeyWord());
                                appDetailsLog.setAppIntroduce(zhuoWangAppMessageList.get(i).getBusinessIntroduction());

                                appDetails = new AppDetails();
                                appDetails.setId(id);
                                appDetails.setAppId(appId);
                                appDetails.setAccountId(accountId);
                                appDetails.setAppVersion("1.0.1");
                                appDetails.setAppVersioCode(100);
                                appDetails.setOnline(1);
                                appDetails.setFeeMode(0);
                                appDetails.setPrice(0);
                                appDetails.setOsVersionId(8);
                                appDetails.setZhuoWangMark(1);
                                appDetails.setLogoUrl(zhuoWangAppMessageList.get(i).getPicUrl1());
                                appDetails.setAppTag(zhuoWangAppMessageList.get(i).getKeyWord());
                                appDetails.setAppIntroduce(zhuoWangAppMessageList.get(i).getBusinessIntroduction());
                                appDetailsList.add(appDetails);

                                // 资源列表
                                List<AppResource> appResourceList = new ArrayList<AppResource>();
                                if (zhuoWangAppMessageList.get(i).getPicUrl3() != null && !zhuoWangAppMessageList.get(i).getPicUrl3().equals("")) {
                                    int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                                    AppResource appResource = new AppResource();
                                    appResource.setResUrl(zhuoWangAppMessageList.get(i).getPicUrl3());
                                    appResource.setResType(0);
                                    appResource.setResId(resId);
                                    appResource.setAccountId(accountId);
                                    appResource.setAppId(appId);
                                    appResource.setCopy(0);
                                    appResource.setZhuoWangMark(1);
                                    appResourceList.add(appResource);
                                }
                                if (zhuoWangAppMessageList.get(i).getPicUrl4() != null && !zhuoWangAppMessageList.get(i).getPicUrl4().equals("")) {
                                    int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                                    AppResource appResource = new AppResource();
                                    appResource.setResUrl(zhuoWangAppMessageList.get(i).getPicUrl4());
                                    appResource.setResId(resId);
                                    appResource.setResType(0);
                                    appResource.setAccountId(accountId);
                                    appResource.setAppId(appId);
                                    appResource.setCopy(0);
                                    appResource.setZhuoWangMark(1);
                                    appResourceList.add(appResource);
                                }
                                if (zhuoWangAppMessageList.get(i).getPicUrl5() != null && !zhuoWangAppMessageList.get(i).getPicUrl5().equals("")) {
                                    int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                                    AppResource appResource = new AppResource();
                                    appResource.setResUrl(zhuoWangAppMessageList.get(i).getPicUrl5());
                                    appResource.setResId(resId);
                                    appResource.setResType(0);
                                    appResource.setAccountId(accountId);
                                    appResource.setAppId(appId);
                                    appResource.setCopy(0);
                                    appResource.setZhuoWangMark(1);
                                    appResourceList.add(appResource);
                                }
                                if (zhuoWangAppMessageList.get(i).getPicUrl6() != null && !zhuoWangAppMessageList.get(i).getPicUrl6().equals("")) {
                                    int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                                    AppResource appResource = new AppResource();
                                    appResource.setResUrl(zhuoWangAppMessageList.get(i).getPicUrl6());
                                    appResource.setResId(resId);
                                    appResource.setResType(0);
                                    appResource.setAccountId(accountId);
                                    appResource.setAppId(appId);
                                    appResource.setCopy(0);
                                    appResource.setZhuoWangMark(1);
                                    appResourceList.add(appResource);
                                }
                                //  应用的下载地址
                                int resId = (int) sequenceUtil.get(SequenceConstants.APP_RESOURCE);
                                AppResource appResource = new AppResource();
                                appResource.setResUrl("http://img.appstore.taotaojing.cn/apk/yyf/06CE567BD2C04E90B78B997E982C3E5E.apk");
                                appResource.setResId(resId);
                                appResource.setResType(1);
                                appResource.setCopy(0);
                                appResource.setAccountId(accountId);
                                appResource.setAppId(appId);
                                appResource.setZhuoWangMark(1);
                                appResourceList.add(appResource);

                                //  系统任务日志
                                apps.setAppResourceList(appResourceList);
                                appsList.add(apps);
                                appLogList.add(appLog);
                                appDetailsLogList.add(appDetailsLog);
                            }
                        } else {       //  增删标记为2的  删除该应用
                            Integer appId = zhuoWangInfoImportDao.getAppId("com.zhuowang.apps." + zhuoWangAppMessageList.get(i).getZhuoWangId());
                            zhuoWangInfoImportDao.deleteZhuoWangAppsByAppId(appId);
                        }
                    }
                      zhuoWangInfoImportDao.batchInsertApps(appsList, appLogList, appDetailsLogList, appDetailsList);
            }
        });
    }

    public void deleteZhuoWangApp() {
        zhuoWangInfoImportDao.deleteZhuoWangApps();
    }


    public void setZhuoWangInfoImportDao(ZhuoWangInfoImportDao zhuoWangInfoImportDao) {
        this.zhuoWangInfoImportDao = zhuoWangInfoImportDao;
    }

    /**
     * 延迟一分钟
     */
    public Date addDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 1);
        date = calendar.getTime();
        return date;
    }
}
