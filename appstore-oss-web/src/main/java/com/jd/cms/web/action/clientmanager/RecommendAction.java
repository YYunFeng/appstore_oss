package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.RecommendManagerResult;
import com.jd.cms.service.clientmanager.RecommendService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-26
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
public class RecommendAction extends BaseAction {
    private RecommendService recommendService;
    private RecommendManagerResult recommendManagerResult;
    private int pageSize = 10;
    private int clientType;
    private int moduleId;
    private int areaId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RecommendManagerResult getRecommendManagerResult() {
        return recommendManagerResult;
    }

    public void setRecommendManagerResult(RecommendManagerResult recommendManagerResult) {
        this.recommendManagerResult = recommendManagerResult;
    }

    public RecommendService getRecommendService() {
        return recommendService;
    }

    public void setRecommendService(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getClientType() {
        return clientType;
    }

    public void setClientType(int clientType) {
        this.clientType = clientType;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String init() {
        return "init";
    }

    public void initParentId() throws Exception {
        Result result = recommendService.initParentId();
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void initWebParentId() throws Exception {
        Result result = recommendService.initWebParentId();
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public String getPhoneRecommend() throws Exception {
        Result result = recommendService.findPhoneRecommend(page, pageSize, clientType, moduleId, areaId);
        toVm(result);
        return "phoneRecommendList";
    }

    public String getPadRecommend() throws Exception {
        Result result = recommendService.findPadRecommend(page, pageSize, clientType, moduleId, areaId);
        toVm(result);
        return "padRecommendList";
    }

    public String addHomeAreaType() {
        return "selectHomeAreaType";
    }

    public String addPadHomeAreaType() {
        return "selectPadHomeAreaType";
    }

    public String load() {
        return "load";
    }

    public String loadPad() {
        return "loadPad";
    }

    public String getWebRecommend() throws Exception {
        Result result = recommendService.findRecommend(page, pageSize, clientType, moduleId, areaId);
        toVm(result);
        return "webRecommendList";
    }

    public String getPCRecommend() throws Exception {
        Result result = null;
        try {
            result = recommendService.findRecommend(page, pageSize, clientType, moduleId, areaId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        toVm(result);
        return "pcRecommendList";
    }

    public String getCPServer() throws Exception {
        Result result = null;
        try {
            result = recommendService.findRecommend(page, pageSize, clientType, moduleId, areaId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        toVm(result);
        return "cpRecommendList";
    }

    public String addWebRecommend() throws Exception {
        return "addWebRecommend";
    }

    public String addPCRecommend() throws Exception {
        return "addPCRecommend";
    }

    public String addCPRecommend() throws Exception {
        return "addCPRecommend";
    }

    public void doAddRecommend() throws Exception {
        Result result = null;
        int isExist = findRecommendBySeq();
        int flag = 0;
        if (recommendManagerResult != null && recommendManagerResult.getLinkType() != null) {
            if (0 != isExist) {
                recommendService.updateAddSeq(recommendManagerResult);
                result = recommendService.createRecommend(recommendManagerResult);
            } else {
                result = recommendService.createRecommend(recommendManagerResult);
            }
        } else {
            flag = 1;
        }
        String json = JSONUtil.serialize(flag);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public void doAddCPRecommend() throws Exception {
        Result result = null;
        int flag = 0;
        if (recommendManagerResult != null && recommendManagerResult.getLinkType() != null) {
            int isExist = recommendService.findCPRecommendBySeq(recommendManagerResult);
            if (0 != isExist) {
                recommendService.updateCPAddSeq(recommendManagerResult);
                result = recommendService.createRecommend(recommendManagerResult);
            } else {
                result = recommendService.createRecommend(recommendManagerResult);
            }
        } else {
            flag = 1;
        }
        String json = JSONUtil.serialize(flag);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public void doAddHomeAreaType() throws Exception {
        Result result = null;
        int areaId = recommendService.getSeq(recommendManagerResult);
        recommendManagerResult.setHomeAreaId(areaId + 1);
        int isExist = recommendService.findHomeAreaTypeByAreaId(recommendManagerResult);
        if (0 != isExist) {
            recommendService.updateAddAreaType(recommendManagerResult);
            if (recommendManagerResult.getHomeAreaType() == 1) {
                result = recommendService.createRecommend(recommendManagerResult);
            } else {
                for (int i = 0; i < 3; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            }
        } else {
            if (recommendManagerResult.getHomeAreaType() == 1) {
                result = recommendService.createRecommend(recommendManagerResult);
            } else {
                for (int i = 0; i < 3; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            }

        }
    }

    public void doAddPadHomeAreaType() throws Exception {
        Result result = null;
        int areaId = recommendService.getSeq(recommendManagerResult);
        recommendManagerResult.setHomeAreaId(areaId + 1);
        int isExist = recommendService.findHomeAreaTypeByAreaId(recommendManagerResult);
        if (0 != isExist) {
            recommendService.updateAddAreaType(recommendManagerResult);
            if (recommendManagerResult.getHomeAreaType() == 3) {
                for (int i = 0; i < 4; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            }
        } else {
            if (recommendManagerResult.getHomeAreaType() == 3) {
                for (int i = 0; i < 4; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    result = recommendService.createRecommend(recommendManagerResult);
                }
            }
        }
    }

    public int findRecommendByAreaId() throws Exception {
        int count = recommendService.findHomeAreaTypeByAreaId(recommendManagerResult);
        return count;
    }

    public void updateRecommendSeq() throws Exception {
        int isExist = findRecommendBySeq();
        if (0 != isExist) {
            recommendService.updateAddSeq(recommendManagerResult);
            recommendService.updateRecommendSeq(recommendManagerResult);
        } else {
            recommendService.updateRecommendSeq(recommendManagerResult);
        }
    }

    public void updatePhoneRecommendSeq() throws Exception {
        int isExist = recommendService.findHomeAreaTypeByAreaId(recommendManagerResult);
        if (this.recommendManagerResult.getId() > this.recommendManagerResult.getHomeAreaId()) {
            this.recommendManagerResult.setGreater("1");
        } else {
            this.recommendManagerResult.setGreater("0");
        }
        if (0 != isExist) {
            recommendService.updateAddPhoneRecommendSeq(recommendManagerResult);
        } else {
            recommendService.updatePhoneRecommendSeqWithOut(recommendManagerResult);
        }
    }


    public int findRecommendBySeq() throws Exception {
        int count = recommendService.findRecommendBySeq(recommendManagerResult);
        return count;
    }

    public void deleteRecommend() throws Exception {
        recommendService.updateDelSeq(recommendManagerResult);
        recommendService.deleteRecommend(recommendManagerResult);
    }

    public void deletePhoneRecommend() throws Exception {
        recommendService.deleteAreaType(recommendManagerResult);
        recommendService.updateDelAreaType(recommendManagerResult);
    }

    public void updateRecommendPub() throws Exception {
        recommendService.updateRecommendPubedStatus(recommendManagerResult);
    }

    public void updateRecommend() throws Exception {
        recommendService.updateRecommend(recommendManagerResult);
    }

    public void updatePhonePubedStatus() throws Exception {
        try {
            recommendService.updatePhoneRecommendPubStatus(recommendManagerResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePhoneRecommend() throws Exception {
        recommendService.updatePhoneRecommend(recommendManagerResult);
    }

    public void updateCPRecommend() throws Exception {
        recommendService.updateCPRecommend(recommendManagerResult);
    }

    public void updateWebRecommend() throws Exception {
        recommendService.updateWebRecommend(recommendManagerResult);
    }

    public String editPhoneRecommend() throws Exception {
        Result result = recommendService.findRecommendById(recommendManagerResult);
        toVm(result);
        return "editPhoneRecommend";
    }

    public String editPadRecommend() throws Exception {
        Result result = recommendService.findRecommendById(recommendManagerResult);
        toVm(result);
        return "editPadRecommend";
    }

    public String editWebRecommend() throws Exception {
        Result result = recommendService.findRecommendById(recommendManagerResult);
        toVm(result);
        return "editWebRecommend";
    }

    public String editCPRecommend() throws Exception {
        Result result = recommendService.findCPRecommendById(recommendManagerResult);
        toVm(result);
        return "editCPRecommend";
    }

    public String editPCRecommend() throws Exception {
        Result result = recommendService.findRecommendById(recommendManagerResult);
        toVm(result);
        return "editPCRecommend";
    }


}
