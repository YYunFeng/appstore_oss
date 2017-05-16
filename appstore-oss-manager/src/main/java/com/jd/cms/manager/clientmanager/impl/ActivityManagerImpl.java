package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.ActivityDao;
import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.domain.clientmanager.AppResult;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.manager.clientmanager.ActivityManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 下午12:05
 * To change this template use File | Settings | File Templates.
 */
public class ActivityManagerImpl extends BaseManager implements ActivityManager {
    private final static Logger log = Logger.getLogger(ActivityManagerImpl.class);
    private ActivityDao activityDao;

    /**
     * 获得活动列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */

    public PaginatedList<Activity> getActivityList(int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        PaginatedList<Activity> activities = new PaginatedArrayList<Activity>(pageIndex, pageSize);
        try {
            if (0 == pageIndex) {
                pageIndex = 1;
            }
            int totalItem = activityDao.getActivityCount();
            activities.setTotalItem(totalItem);
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            baseQuery.setEndRow(pageSize);
            List<Activity> activityList = activityDao.getActivityList(baseQuery);
            activities.addAll(activityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activities;
    }

    /**
     * 创建活动
     *
     * @param activity
     */
    public void createActivity(final Activity activity) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int activityId = (int) sequenceUtil.get(SequenceConstants.ACTIVITY);
                    activity.setId(activityId);
                    activityDao.createActivity(activity);
                } catch (Exception e) {
                    log.info("添加活动异常,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public Integer findActivityBySeq(Integer seq) {
        return activityDao.findActivityBySeq(seq);
    }

    public void updateActivitySeq(final Integer seq) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    activityDao.updateActivitySeq(seq);
                } catch (Exception e) {
                    log.info("方法：updateActivitySeq，更新排序失败,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void updateDelActivitySeq(final Integer seq) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    activityDao.updateDelActivitySeq(seq);
                } catch (Exception e) {
                    log.info("方法：updateDelActivitySeq，更新排序失败,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void deletActivity(final Integer Id, final Integer seq) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //删除活动
                    activityDao.deletActivity(Id);
                    // 更新排序
                    activityDao.updateDelActivitySeq(seq);
                } catch (Exception e) {
                    log.info("方法：deletActivity，删除活动异常,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void updateActivityPubedStatus(final Activity activity) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    activityDao.updateActivityPubedStatus(activity);
                } catch (Exception e) {
                    log.info("方法：updateActivityPubedStatus，更新活动上下线状态异常,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public Activity getActivityById(Activity activity) {
        return activityDao.getActivityById(activity);
    }

    public void updateActivity(final Activity activity) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    activityDao.updateActivity(activity);
                } catch (Exception e) {
                    log.info("方法：updateActivity，更新活动,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void updateActivitySeqBySeq(final Activity activity) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    activityDao.updateActivitySeqBySeq(activity);
                } catch (Exception e) {
                    log.info("方法：updateActivity，更新活动,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public List<PadChannel> getPadChannel() {
        List<PadChannel> padChannelList = new ArrayList<PadChannel>();
        try {
            padChannelList = activityDao.getPadChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return padChannelList;
    }

    public List<ActivityChannel> getActivityChannel(Integer activityId) {
        List<ActivityChannel> activityChannelList = new ArrayList<ActivityChannel>();
        try {
            activityChannelList = activityDao.getActivityChannel(activityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activityChannelList;
    }

    public void createActivityReleanceChannel(final Integer activityId, final ActivityChannel activityChannel) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    // 删除已经关联的信息
                    activityDao.deleteActivityChannel(activityId);
                    if (activityChannel.getCids() != null) {
                        String[] cidTemp = activityChannel.getCids().split(",");
                        for (int i = 0; i < cidTemp.length; i++) {
                            if (cidTemp[i] != null) {
                                int activityChannelId = (int) sequenceUtil.get(SequenceConstants.ACTIVITYCHANNEL);
                                activityChannel.setId(activityChannelId);
                                activityChannel.setcId(Integer.valueOf(cidTemp[i]));
                                activityDao.createActivityChannel(activityChannel);
                            }

                        }
                    }
                } catch (Exception e) {
                    log.info("方法：createActivityReleanceChannel，创建活动关联渠道失败,异常信息：" + e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }

    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

}
