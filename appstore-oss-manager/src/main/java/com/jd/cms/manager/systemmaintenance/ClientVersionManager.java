package com.jd.cms.manager.systemmaintenance;

import com.jd.appstore.domain.ClientPackage;
import com.jd.common.util.PaginatedList;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午12:39
 * To change this template use File | Settings | File Templates.
 */
public interface ClientVersionManager {
    PaginatedList<ClientPackage> findClientVersion(int pageIndex, int pageSize, int clientType);

    void createClientVersion(ClientPackage clientPackage);

    void deleteClientVersion(ClientPackage clientPackage);

    ClientPackage findClientVersionById(ClientPackage clientPackage);

    void updateClientVersion(ClientPackage clientPackage);

    void updateClientVersionValid(ClientPackage clientPackage);

    void checkClientVersionValid(ClientPackage clientPackage);
}
