package com.jd.cms.service.systemmaintenance.impl;

import com.jd.appstore.domain.ClientPackage;
import com.jd.cms.aliyun.AliyunService;
import com.jd.cms.manager.systemmaintenance.ClientVersionManager;
import com.jd.cms.service.clientmanager.UploadService;
import com.jd.cms.service.systemmaintenance.ClientVersionService;
import com.jd.common.web.result.Result;
import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class ClientVersionServiceImpl implements ClientVersionService {
    private ClientVersionManager clientVersionManagerCached;
    private ClientVersionManager clientVersionManager;
    private AliyunService aliyunService;
    private UploadService uploadService;

    public ClientVersionManager getClientVersionManager() {
        return clientVersionManager;
    }

    public void setClientVersionManager(ClientVersionManager clientVersionManager) {
        this.clientVersionManager = clientVersionManager;
    }

    public ClientVersionManager getClientVersionManagerCached() {
        return clientVersionManagerCached;
    }

    public void setClientVersionManagerCached(ClientVersionManager clientVersionManagerCached) {
        this.clientVersionManagerCached = clientVersionManagerCached;
    }

    public Result findClientVersion(int pageIndex, int pageSize, int clientType) {
        Result result = new Result();
        result.addDefaultModel("clientVersions", clientVersionManagerCached.findClientVersion(pageIndex, pageSize, clientType));
        return result;
    }

    public Result findClientVersionById(ClientPackage clientPackage) {
        Result result = new Result();
        result.addDefaultModel("clientVersion", clientVersionManager.findClientVersionById(clientPackage));
        return result;
    }

    public void createClientVersion(ClientPackage clientPackage) {
        try {
            if (StringUtils.isNotBlank(clientPackage.getPackageUrl())) {
                aliyunService.putObject(uploadService.getAndroidCilentPath() + "/" + clientPackage.getPackageUrl(), "androidClient/" + clientPackage.getPackageUrl(), 0);
                clientVersionManager.createClientVersion(clientPackage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClientVersion(ClientPackage clientPackage) {
        clientVersionManager.deleteClientVersion(clientPackage);
    }

    public void updateClientVersion(ClientPackage clientPackage) {
        try {
            if (StringUtils.isNotBlank(clientPackage.getPackageUrl())) {
                aliyunService.putObject(uploadService.getAndroidCilentPath() + "/" + clientPackage.getPackageUrl(), "androidClient/" + clientPackage.getPackageUrl(), 0);
                clientVersionManager.updateClientVersion(clientPackage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateClientVersionValid(ClientPackage clientPackage) {
        clientVersionManager.updateClientVersionValid(clientPackage);
    }

    public void checkClientVersionValid(ClientPackage clientPackage) {
        clientVersionManager.checkClientVersionValid(clientPackage);
    }


    public void setAliyunService(AliyunService aliyunService) {
        this.aliyunService = aliyunService;
    }

    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}
