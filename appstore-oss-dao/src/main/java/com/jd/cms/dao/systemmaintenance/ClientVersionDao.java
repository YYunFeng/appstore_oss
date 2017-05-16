package com.jd.cms.dao.systemmaintenance;

import com.jd.appstore.domain.ClientPackage;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午12:18
 * To change this template use File | Settings | File Templates.
 */
public interface ClientVersionDao {
    List<ClientPackage> findClientVersion(Query query);

    int getClientVersionCount(Query query);

    void createClientVersion(ClientPackage clientPackage);

    void deleteClientVersion(ClientPackage clientPackage);

    ClientPackage findClientVersionById(ClientPackage clientPackage);

    void updateClientVersion(ClientPackage clientPackage);

    void updateClientVersionValid(ClientPackage clientPackage);

    void checkClientVersionValid(ClientPackage clientPackage);
}
