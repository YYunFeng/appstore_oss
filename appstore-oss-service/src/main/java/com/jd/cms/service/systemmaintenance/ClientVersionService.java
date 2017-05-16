package com.jd.cms.service.systemmaintenance;

import com.jd.appstore.domain.ClientPackage;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public interface ClientVersionService {
    Result findClientVersion(int pageIndex, int pageSize, int clientType);

    void createClientVersion(ClientPackage clientPackage);

    void deleteClientVersion(ClientPackage clientPackage);

    Result findClientVersionById(ClientPackage clientPackage);

    void updateClientVersion(ClientPackage clientPackage);

    void updateClientVersionValid(ClientPackage clientPackage);

    void checkClientVersionValid(ClientPackage clientPackage);
}
