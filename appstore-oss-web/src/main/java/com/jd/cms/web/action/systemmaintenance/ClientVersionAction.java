package com.jd.cms.web.action.systemmaintenance;

import com.jd.appstore.domain.ClientPackage;
import com.jd.cms.service.systemmaintenance.ClientVersionService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;


/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-8-27
 * Time: 上午11:15
 * To change this template use File | Settings | File Templates.
 */
public class ClientVersionAction extends BaseAction {
    private ClientVersionService clientVersionService;
    private ClientPackage clientPackage;
    private int clientType;
    private int PAGE_SIZE = 20;


    public String loadVersionList() {
        return "clientVersionList";
    }

    public String addClientVersion() {
        return "addClientVersion";
    }

    public void doAddClientVersion() {
        clientVersionService.createClientVersion(clientPackage);
    }

    public String getVersionList() {
        Result result = clientVersionService.findClientVersion(page, PAGE_SIZE, clientType);
        toVm(result);
        return "clientVersionResult";
    }

    public void deleteClientVersion() {
        clientVersionService.deleteClientVersion(clientPackage);
    }

    public String editClientVersion() {
        Result result = clientVersionService.findClientVersionById(clientPackage);
        toVm(result);
        return "editClientVersion";
    }

    public void updateClientVersion() {
        clientVersionService.updateClientVersion(clientPackage);
    }

    public void updateClientVersionValid() {
        if (clientPackage.getValid() == 1) {
            clientVersionService.checkClientVersionValid(clientPackage);
            clientVersionService.updateClientVersionValid(clientPackage);
        } else {
            clientVersionService.updateClientVersionValid(clientPackage);
        }
    }

    public ClientVersionService getClientVersionService() {
        return clientVersionService;
    }

    public void setClientVersionService(ClientVersionService clientVersionService) {
        this.clientVersionService = clientVersionService;
    }

    public ClientPackage getClientPackage() {
        return clientPackage;
    }

    public void setClientPackage(ClientPackage clientPackage) {
        this.clientPackage = clientPackage;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getPAGE_SIZE() {
        return PAGE_SIZE;
    }

    public void setPAGE_SIZE(int PAGE_SIZE) {
        this.PAGE_SIZE = PAGE_SIZE;
    }


}
