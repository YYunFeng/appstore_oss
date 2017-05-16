package com.jd.cms.manager.clientmanager.impl;

import com.jd.cms.dao.clientmanager.RankingAppDao;
import com.jd.cms.domain.clientmanager.QueryRanking;
import com.jd.cms.domain.clientmanager.RankingManagerResult;
import com.jd.cms.manager.clientmanager.RankingAppManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.PaginatedArrayList;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-24
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
public class RankingAppManagerImpl extends BaseManager implements RankingAppManager {
    private RankingAppDao rankingAppDao;

    public void setRankingAppDao(RankingAppDao rankingAppDao) {
        this.rankingAppDao = rankingAppDao;
    }

    public PaginatedList<RankingManagerResult> findRankingApps(int pageIndex, int pageSize, int rankingStyle, int rankingType) {
        QueryRanking queryRanking = new QueryRanking();
        if (0 == pageIndex) {
            pageIndex = 1;
        }
        queryRanking.setRankingStyle(rankingStyle);
        queryRanking.setRankingType(rankingType);
        int totalItem = rankingAppDao.getRankingAppCount(queryRanking);
        PaginatedList<RankingManagerResult> rankingApps = new PaginatedArrayList<RankingManagerResult>(pageIndex, pageSize);
        rankingApps.setTotalItem(totalItem);
        queryRanking.setStartRow((pageIndex - 1) * pageSize);
        queryRanking.setEndRow(pageSize);
        List<RankingManagerResult> rankingApp = rankingAppDao.findRankingApp(queryRanking);
        rankingApps.addAll(rankingApp);

        return rankingApps;
    }

    public int updateRankingLocked(final RankingManagerResult rankingManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {

                    rankingAppDao.updateRankingLocked(rankingManagerResult);

                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateRankingLocked error!", e);
                }
            }
        });
        return 1;
    }

    public int findRankingBySeq(RankingManagerResult rankingManagerResult) {
        int count = rankingAppDao.findRankingBySeq(rankingManagerResult);
        return count;
    }

    public int updateRankingSeq(final RankingManagerResult rankingManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    rankingAppDao.updateRankingSeq(rankingManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateRankingSeq error!", e);
                }
            }
        });
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int updateAddRankingSeq(final RankingManagerResult rankingManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    rankingAppDao.updateAddRankingSeq(rankingManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateAddRankingSeq error!", e);
                }
            }
        });
        return 1;
    }

    public void updateRanking(final RankingManagerResult rankingManagerResult) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    rankingAppDao.updateRanking(rankingManagerResult);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("updateRanking error", e);
                }
            }
        });
    }
}
