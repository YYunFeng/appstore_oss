package com.jd.cms.manager.systemmaintenance.impl;

import IceGrid.Query;
import com.jd.appstore.domain.ClientPackage;
import com.jd.cms.dao.systemmaintenance.ClientVersionDao;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.systemmaintenance.ClientVersionManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午12:40
 * To change this template use File | Settings | File Templates.
 */
public class ClientVersionManagerImpl extends BaseManager implements ClientVersionManager{
    private ClientVersionDao clientVersionDao;

    public ClientVersionDao getClientVersionDao() {
        return clientVersionDao;
    }

    public void setClientVersionDao(ClientVersionDao clientVersionDao) {
        this.clientVersionDao = clientVersionDao;
    }

    public PaginatedList<ClientPackage> findClientVersion(int pageIndex, int pageSize, int clientType) {
        if(0 == pageIndex)
            pageIndex = 1;
        PaginatedList<ClientPackage> clientPackages = new PaginatedArrayList<ClientPackage>(pageIndex, pageSize);
        try{
            BaseQuery baseQuery = new BaseQuery();
            baseQuery.setId(clientType);
            int totalItem = clientVersionDao.getClientVersionCount(baseQuery);
            clientPackages.setTotalItem(totalItem);
            baseQuery.setStartRow((pageIndex-1)*pageSize);
            baseQuery.setEndRow(pageSize);
            List<ClientPackage> clientPackage = clientVersionDao.findClientVersion(baseQuery);
            clientPackages.addAll(clientPackage);
        }catch(Exception e){
            throw new RuntimeException("findClientVersion error!",e);
        }
        return clientPackages;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createClientVersion(final ClientPackage clientPackage) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    int clientPackageId = (int) sequenceUtil.get(SequenceConstants.CMS_CLIENTMANAGER_VERSION_SEQUENCE);
                    clientPackage.setId(clientPackageId);
                    clientVersionDao.createClientVersion(clientPackage);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();

                }
            }
        });
    }

    public void deleteClientVersion(final ClientPackage clientPackage) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    clientVersionDao.deleteClientVersion(clientPackage);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("deleteClientVersion error", e);
                }
            }
        });
    }

    public ClientPackage findClientVersionById(ClientPackage client) {
        ClientPackage clientVersion = clientVersionDao.findClientVersionById(client);
        return clientVersion;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateClientVersion(final ClientPackage clientPackage) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    clientVersionDao.updateClientVersion(clientPackage);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("UpdateClientVersion error", e);
                }
            }
        });
    }

    public void updateClientVersionValid(final ClientPackage clientPackage) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    clientVersionDao.updateClientVersionValid(clientPackage);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("UpdateClientVersionValid error", e);
                }
            }
        });
    }

    public void checkClientVersionValid(final ClientPackage clientPackage) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    clientVersionDao.checkClientVersionValid(clientPackage);
                }catch(Exception e){
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("checkClientVersionValid error", e);
                }
            }
        });
    }
}
