package com.jd.cms.manager.systemmaintenance.impl;

import com.jd.appstore.domain.ClientPackage;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.systemmaintenance.ClientVersionManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
public class ClientVersionManagerCahedImpl implements ClientVersionManager {
    private ClientVersionManager clientVersionManager;
    private CacheUtils cacheUtils;

    public ClientVersionManager getClientVersionManager() {
        return clientVersionManager;
    }

    public void setClientVersionManager(ClientVersionManager clientVersionManager) {
        this.clientVersionManager = clientVersionManager;
    }

    public CacheUtils getCacheUtils() {
        return cacheUtils;
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public PaginatedList<ClientPackage> findClientVersion(int pageIndex, int pageSize, int clientType) {
        PaginatedList<ClientPackage> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        if (0 == pageIndex) {
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_CLIENTVERSIONMANAGER_PAGER_CACHED + "_" + ip);
            if (null != pager) {
                pageIndex = pager;
            }
        }
        paginatedList = clientVersionManager.findClientVersion(pageIndex, pageSize, clientType);
        if (0 == paginatedList.size() && 1 < pageIndex) {

            pageIndex = pageIndex - 1;
            cacheUtils.set(CategoryConstants.CMS_CLIENTVERSIONMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            paginatedList = findClientVersion(pageIndex, pageSize, clientType);

        } else {
            cacheUtils.set(CategoryConstants.CMS_CLIENTVERSIONMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        return paginatedList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createClientVersion(ClientPackage clientPackage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteClientVersion(ClientPackage clientPackage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ClientPackage findClientVersionById(ClientPackage clientPackage) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateClientVersion(ClientPackage clientPackage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateClientVersionValid(ClientPackage clientPackage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void checkClientVersionValid(ClientPackage clientPackage) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
