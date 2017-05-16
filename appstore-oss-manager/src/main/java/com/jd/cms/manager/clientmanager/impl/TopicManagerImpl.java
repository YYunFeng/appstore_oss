package com.jd.cms.manager.clientmanager.impl;

import com.jd.appstore.domain.Topic;
import com.jd.appstore.domain.TopicApp;
import com.jd.cms.dao.clientmanager.TopicDao;
import com.jd.cms.domain.clientmanager.ChannelTopic;
import com.jd.cms.domain.clientmanager.TopicAppResult;
import com.jd.cms.manager.clientmanager.TopicManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.systemmaintenance.LogsManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午6:12
 * To change this template use File | Settings | File Templates.
 */
public class TopicManagerImpl extends BaseManager implements TopicManager {
    private final static Logger log = Logger.getLogger(TopicManagerImpl.class);
    private TopicDao topicDao;
    private LogsManager logsManager;

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public List<Topic> findTopicByName(String query) {
        List<Topic> topic = topicDao.findTopicByName(query);
        return topic;
    }

    public Topic findTopicById(Topic topic) {
        Topic topicResult = topicDao.findTopicById(topic);
        return topicResult;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<TopicAppResult> findTopicAppByTopicId(Topic topicApp) {
        List<TopicAppResult> topicAppResult = topicDao.findTopicAppByTopicId(topicApp);
        return topicAppResult;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaginatedList<Topic> findTopic(int pageIndex, int pageSize, int type) {
        BaseQuery baseQuery = new BaseQuery();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        int totalItem = topicDao.getTopicCount(type);
        PaginatedList<Topic> topics = new PaginatedArrayList<Topic>(pageIndex, pageSize);
        topics.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex - 1) * pageSize);
        baseQuery.setEndRow(pageSize);
        baseQuery.setId(type);
        List<Topic> topic = topicDao.findTopic(baseQuery);
        topics.addAll(topic);
        return topics;

    }

    public PaginatedList<Topic> findTopicByNamePage(int pageIndex, int pageSize, String topicName) {
        BaseQuery baseQuery = new BaseQuery();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        baseQuery.setValue(topicName);
        int totalItem = topicDao.findTopicCount(baseQuery);
        PaginatedList<Topic> topics = new PaginatedArrayList<Topic>(pageIndex, pageSize);
        topics.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex - 1) * pageSize);
        baseQuery.setEndRow(pageSize);
        List<Topic> topic = topicDao.findTopicByNamePage(baseQuery);
        topics.addAll(topic);
        return topics;

    }

    public PaginatedList<Topic> findTopicByPub(int pageIndex, int pageSize, int pubedStatus) {
        BaseQuery baseQuery = new BaseQuery();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        baseQuery.setId(pubedStatus);
        int totalItem = topicDao.getTopicCountByPub(baseQuery);
        PaginatedList<Topic> topics = new PaginatedArrayList<Topic>(pageIndex, pageSize);
        topics.setTotalItem(totalItem);
        baseQuery.setStartRow((pageIndex - 1) * pageSize);
        baseQuery.setEndRow(pageSize);

        List<Topic> topic = topicDao.findTopicByPub(baseQuery);
        topics.addAll(topic);
        return topics;
    }

    public int updateTopicPubedStatus(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateTopicPubedStatus(topic);
                    if (topic.getPubedStatus() == 0) {
                        topicDao.removeTopicFromRecommend(topic);
                    }

                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateTopicPubedStatus error", e);
                    throw new RuntimeException("updateTopicPubedStatus error!", e);
                }
            }
        });

        return 1;
    }

    public int deleteTopic(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.deleteTopic(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("deleteTopic error", e);
                    throw new RuntimeException("delete topic error!", e);
                }
            }
        });
        return 1;
    }

    public int deleteTopicApp(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.deleteTopicApp(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("deleteTopicApp error", e);
                    throw new RuntimeException("delete topicApp error!", e);
                }

            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteTopicAppById(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.deleteTopicAppById(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("deleteTopicAppById error", e);
                    throw new RuntimeException("delete topicAppById error!", e);
                }

                try {
                    logsManager.createOperateLog(topicApp.getAppId(), 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return 1;
    }

    public int updateTopic(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateTopic(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updasteTopic error", e);
                    throw new RuntimeException("updateTopic error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateChannelTopic(ChannelTopic channelTopic) {
        try {
            // 先删除已经关联的渠道
            topicDao.deleteChannelTopic(channelTopic.getTopicId());
            String[] idsTemp = channelTopic.getCids().split(",");
            Integer[] ids = new Integer[100];
            for (int i = 0; i < idsTemp.length; i++) {
                ids[i] = Integer.valueOf(idsTemp[i]);
            }
            int length = ids.length;
            for (int i = 0; i < length; i++) {
                if (ids[i] != null && ids[i].intValue() != 0) {
                    int id = (int) sequenceUtil.get(SequenceConstants.CHANNELTOPIC_SEQUENCE);
                    channelTopic.setId(id);
                    channelTopic.setcId(ids[i]);
                    topicDao.createChannelTopic(channelTopic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ChannelTopic> getChannelTopic(int topicId) {
        return topicDao.getChannelTopic(topicId);
    }

    public void updateActivation(TopicApp topicApp) {
        topicDao.updateActivation(topicApp);
    }

    public void changeStatusForApp(TopicApp topicApp) {
        topicDao.changeStatusForApp(topicApp);
        try {
            logsManager.createOperateLog(topicApp.getAppId(), Integer.valueOf(topicApp.getPubedStatus()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int findTopicBySeq(Topic topic) {
        int count = topicDao.findTopicBySeq(topic);
        return count;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findTopicAppBySeq(TopicApp topicApp) {
        int count = topicDao.findTopicAppBySeq(topicApp);
        return count;
    }

    public int updateAddTopicSeq(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateAddTopicSeq(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateAddNoticeSeq error", e);
                    throw new RuntimeException("updateAddNoticeSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddTopicAppSeq(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateAddTopicAppSeq(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateAddTopicAppSeq error", e);
                    throw new RuntimeException("updateAddTopicAppSeq error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelTopicSeq(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateDelTopicSeq(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateDelTopicSeq error", e);
                    throw new RuntimeException("updateDelTopicSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelTopicAppSeq(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateDelTopicAppSeq(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateDelTopicAppSeq error", e);
                    throw new RuntimeException("updateDelTopicAppSeq error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopicSeq(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateTopicSeq(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateTopicSeq error", e);
                    throw new RuntimeException("updateTopicSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateTopicAppSeq(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    topicDao.updateTopicAppSeq(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateTopicAppSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int addTopic(final Topic topic) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int topicId = (int) sequenceUtil.get(SequenceConstants.CMS_TOPIC_SEQUENCE);
                    topic.setTopicId(topicId);
                    topicDao.addTopic(topic);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }


            }
        });
        return topic.getTopicId();
    }

    public int addTopicApp(final TopicApp topicApp) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int topicAppId = (int) sequenceUtil.get(SequenceConstants.CMS_TOPIC_APP_SEQUENCE);
                    topicApp.setId(topicAppId);
                    topicDao.addTopicApp(topicApp);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }

                try {
                    logsManager.createOperateLog(topicApp.getAppId(), 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return topicApp.getId();
    }


    public void setLogsManager(LogsManager logsManager) {
        this.logsManager = logsManager;
    }
}
