package com.jd.cms.dao.systemmaintenance.impl;

import com.jd.appstore.domain.ClientPackage;
import com.jd.cms.dao.systemmaintenance.ClientVersionDao;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午12:21
 * To change this template use File | Settings | File Templates.
 */
public class ClientVersionDaoImpl extends BaseDao implements ClientVersionDao{
    public List<ClientPackage> findClientVersion(Query query) {
        return queryForList("ClientVersionManager.findClientVersion", query);
    }

    public int getClientVersionCount(Query query) {
        return (Integer)queryForObject("ClientVersionManager.getClientVersionCount",query);
    }

    public void createClientVersion(ClientPackage clientPackage) {
        insert("ClientVersionManager.createClientVersion", clientPackage);
    }

    public void deleteClientVersion(ClientPackage clientPackage){
        delete("ClientVersionManager.deleteClientVersion", clientPackage);
    }

    public ClientPackage findClientVersionById(ClientPackage clientPackage){
        return (ClientPackage)queryForObject("ClientVersionManager.findClientVersionById", clientPackage);
    }

    public void updateClientVersion(ClientPackage clientPackage){
        update("ClientVersionManager.updateClientVersion", clientPackage);
    }

    public void updateClientVersionValid(ClientPackage clientPackage) {
        update("ClientVersionManager.updateClientVersionValid", clientPackage);
    }

    public void checkClientVersionValid(ClientPackage clientPackage) {
        update("ClientVersionManager.checkClientVersionValid", clientPackage);
    }

}
