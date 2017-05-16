package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.RecommendDao;
import com.jd.cms.domain.clientmanager.ClientRecommend;
import com.jd.cms.domain.clientmanager.QueryRecommend;
import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.cms.manager.clientmanager.RecommendManager;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-18
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class RecommendManagerImpl extends BaseManager implements RecommendManager {
    private final static Logger log = Logger.getLogger(RecommendManagerImpl.class);
    private RecommendDao recommendDao;

    public RecommendDao getRecommendDao() {
        return recommendDao;
    }

    public void setRecommendDao(RecommendDao recommendDao) {
        this.recommendDao = recommendDao;
    }


    public PaginatedList<RecommendManagerResult> findRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        log.info("客户端类型=" + clientType + " 模块=" + moduleId + " 区块=" + areaId);
        QueryRecommend queryRecommend = new QueryRecommend();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        queryRecommend.setClientType(clientType);
        queryRecommend.setModuleId(moduleId);
        queryRecommend.setAreaId(areaId);
        int totalItem = recommendDao.getRecommendCount(queryRecommend);
        PaginatedList<RecommendManagerResult> recommends = new PaginatedArrayList<RecommendManagerResult>(pageIndex, pageSize);
        recommends.setTotalItem(totalItem);
        queryRecommend.setStartRow((pageIndex - 1) * pageSize);
        queryRecommend.setEndRow(pageSize);
        List<RecommendManagerResult> recommend = recommendDao.findRecommend(queryRecommend);
        recommends.addAll(recommend);

        return recommends;
    }

    public PaginatedList<RecommendManagerResult> findPhoneRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        log.info("客户端类型=" + clientType + " 模块=" + moduleId + " 区块=" + areaId);
        QueryRecommend queryRecommend = new QueryRecommend();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        queryRecommend.setClientType(clientType);
        queryRecommend.setModuleId(moduleId);
        queryRecommend.setAreaId(areaId);
        //List<RecommendManagerResult> re = recommendDao.findPhoneRecommendForCount(queryRecommend);
        int totalItem = recommendDao.getPhoneRecommendCount(queryRecommend);
        PaginatedList<RecommendManagerResult> recommends = new PaginatedArrayList<RecommendManagerResult>(pageIndex, pageSize);
        recommends.setTotalItem(totalItem);
        queryRecommend.setStartRow((pageIndex - 1) * pageSize);
        queryRecommend.setEndRow(pageSize);
        List<RecommendManagerResult> recommend = recommendDao.findPhoneRecommend(queryRecommend);
        recommends.addAll(recommend);
        return recommends;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaginatedList<RecommendManagerResult> findPadRecommend(int pageIndex, int pageSize, int clientType, int moduleId, int areaId) {
        log.info("客户端类型=" + clientType + " 模块=" + moduleId + " 区块=" + areaId);
        QueryRecommend queryRecommend = new QueryRecommend();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        queryRecommend.setClientType(clientType);
        queryRecommend.setModuleId(moduleId);
        queryRecommend.setAreaId(areaId);
        int totalItem = recommendDao.getPadRecommendCount(queryRecommend);
        PaginatedList<RecommendManagerResult> recommends = new PaginatedArrayList<RecommendManagerResult>(pageIndex, pageSize);
        recommends.setTotalItem(totalItem);
        queryRecommend.setStartRow((pageIndex - 1) * pageSize);
        queryRecommend.setEndRow(pageSize);
        List<RecommendManagerResult> recommend = recommendDao.findPadRecommend(queryRecommend);
        recommends.addAll(recommend);
        return recommends;
    }


    public int createRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int recommendId = (int) sequenceUtil.get(SequenceConstants.CMS_RECOMMEND_SEQUENCE);
                    if (recommendManagerResult.getClientType() == 0) {
//                        int seq = (int) sequenceUtil.get(SequenceConstants.CMS_RECOMMEND_PHONE_SEQ_SEQUENCE);
                        int seq = recommendManagerResult.getHomeAreaId();
                        recommendManagerResult.setSeq(seq);
                    }
                    if (recommendManagerResult.getClientType() == 1) {
//                        int seq = (int) sequenceUtil.get(SequenceConstants.CMS_RECOMMEND_PAD_SEQ_SEQUENCE);
                        int seq = recommendManagerResult.getHomeAreaId();
                        recommendManagerResult.setSeq(seq);
                    }
                    recommendManagerResult.setId(recommendId);
                    String u = recommendManagerResult.getLinkedUrl();
                    if (u!=null && !u.toLowerCase().startsWith("http://")) {
                        u = "http://" + u;
                        recommendManagerResult.setLinkedUrl(u);
                    }
                    recommendDao.createRecommend(recommendManagerResult);
                } catch (Exception e) {
                    log.info("createRecommend error", e);
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        return recommendManagerResult.getId();
    }

    public int addHomeAreaType(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int recommendId = (int) sequenceUtil.get(SequenceConstants.CMS_RECOMMEND_SEQUENCE);
                    recommendManagerResult.setId(recommendId);
                    recommendDao.addHomeAreaType(recommendManagerResult);
                } catch (Exception e) {
                    log.info("addHomeAreaType error!!!", e);
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findHomeAreaTypeByAreaId(RecommendManagerResult recommendManagerResult) {
        return recommendDao.findHomeAreaTypeByAreaId(recommendManagerResult);
    }

    public int getSeq(RecommendManagerResult queryRecommend) {
        return recommendDao.getSeq(queryRecommend);
    }

    public int updateAddAreaType(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateAddAreaType(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateAddAreaType error", e);
                    throw new RuntimeException("UpdateAddAreaType error", e);
                }
            }
        });
        return 1;
    }


    public int updatePhoneRecommendSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updatePhoneRecommendSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updatePhoneRecommendSeq error", e);
                    throw new RuntimeException("UpdatePhoneRecommendSeq error", e);
                }
            }
        });
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updatePhoneRecommendSeqWithOut(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updatedPhoneRecommendSeqWithOut(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updatePhoneRecommendSeqWithOut error", e);
                    throw new RuntimeException("updatePhoneRecommendSeqWithOut error", e);
                }
            }
        });
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddPhoneRecommendSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    int i = recommendDao.updateAddAreaType(recommendManagerResult);
                    if (i > 0) {
                        recommendDao.updatePhoneRecommendSeq(recommendManagerResult);
                    }
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateAddPhoneRecommendSeq error !!!", e);
                    throw new RuntimeException("updateAddPhoneRecommendSeq", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelPhoneRecommendSeq(RecommendManagerResult recommendManagerResult) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {

                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateDelPhoneRecommendSeq", e);
                }
            }
        });
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelAreaType(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateDelAreaType(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateDelAreaType error", e);
                    throw new RuntimeException("UpdateDelAreaType error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int deleteAreaType(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.deleteAreaType(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("deleteAreaType error", e);
                    throw new RuntimeException("deleteAreaType error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public int deleteRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.deleteRecommend(recommendManagerResult);
                } catch (Exception ex) {
                    transactionStatus.setRollbackOnly();
                    log.info("deleteBanner error", ex);
                    throw new RuntimeException("deleteBanner error!", ex);
                }
            }
        });

        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRecommendSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateRecommendSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateRecommendSeq error ", e);
                    throw new RuntimeException("UpdateRecommendSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateAddSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateAddSeq error", e);
                    throw new RuntimeException("UpdateAddSeq error!", e);
                }
            }
        });

        return 1;
    }

    public int updateCPAddSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateCPAddSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateCPAddSeq error", e);
                    throw new RuntimeException("UpdateCPAddSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateDelSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateDelSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateDelSeq error", e);
                    throw new RuntimeException("UpdateDelSeq error", e);
                }
            }
        });
        return 1;
    }

    public int updateCPDelSeq(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateCPDelSeq(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateCPDelSeq error", e);
                    throw new RuntimeException("UpdateCPDelSeq error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateRecommendPubedStatus(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateRecommendPubedStatus(recommendManagerResult);
                    if (recommendManagerResult.getClientType() != null && recommendManagerResult.getAreaId() != null) {
                        //WEB通栏广告上线时，其它广告下线
                        if (recommendManagerResult.getClientType() == 2 && recommendManagerResult.getAreaId() >= 21 && recommendManagerResult.getAreaId() <= 29 && recommendManagerResult.getPubedStatus() == 1) {
                            recommendDao.updateRecommendADPubedStatus(recommendManagerResult);
                        }
                    }

                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateRecommendPubedStatus error ", e);
                    throw new RuntimeException("updateRecommendPubedStatus error", e);
                }
            }
        });
        return 1;
    }

    public void updateRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateRecommend(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateRecommend error ", e);
                    throw new RuntimeException("updateRecommend error", e);
                }
            }
        });
    }

    public int updatePhoneRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updatePhoneRecommend(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updatePhoneRecommend error", e);
                    throw new RuntimeException("updatePhoneRecommend error", e);
                }
            }
        });
        return 1;
    }

    public void updateCPRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    String u = recommendManagerResult.getLinkedUrl();
                    if (u!=null && !u.toLowerCase().startsWith("http://")) {
                        u = "http://" + u;
                        recommendManagerResult.setLinkedUrl(u);
                    }
                    recommendDao.updateCPRecommend(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateCPRecommend error", e);
                    throw new RuntimeException("updateCPRecommend error", e);
                }
            }
        });
    }

    public int updateWebRecommend(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updateWebRecommend(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updateWebRecommend error", e);
                    throw new RuntimeException("updateWebRecommend error", e);
                }
            }
        });
        return 1;
    }

    public int updatePhoneRecommendPubedStatus(final RecommendManagerResult recommendManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    recommendDao.updatePhoneRecommendPubedStatus(recommendManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    log.info("updatePhoneRecommendPubedStatus error", e);
                    throw new RuntimeException("updatePhoneRecommendPubedStatus error", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int findRecommendBySeq(final RecommendManagerResult recommendManagerResult) {
        int count = recommendDao.findRecommendBySeq(recommendManagerResult);
        return count;
    }

    public int findCPRecommendBySeq(final RecommendManagerResult recommendManagerResult) {
        return recommendDao.findCPRecommendBySeq(recommendManagerResult);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public ClientRecommend findRecommendById(RecommendManagerResult recommendManagerResult) {
        ClientRecommend clientRecommend = recommendDao.findRecommendById(recommendManagerResult);
        return clientRecommend;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public RecommendManagerResult findCPRecommendById(RecommendManagerResult recommend) {
        RecommendManagerResult recommendManagerResult = recommendDao.findCPRecommendById(recommend);
        return recommendManagerResult;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
