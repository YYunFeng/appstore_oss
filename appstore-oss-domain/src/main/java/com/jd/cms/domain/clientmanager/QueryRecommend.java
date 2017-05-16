package com.jd.cms.domain.clientmanager;

import com.jd.common.util.base.BaseQuery;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-26
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public class QueryRecommend extends BaseQuery{
    private Integer clientType;
    private Integer moduleId;
    private Integer areaId;

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
