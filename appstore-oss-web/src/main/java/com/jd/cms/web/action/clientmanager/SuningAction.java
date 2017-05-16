package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.Suning;
import com.jd.cms.domain.clientmanager.SuningJSON;
import com.jd.cms.service.clientmanager.SuningService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created by YUNFENG on 14-2-11.
 */
public class SuningAction extends BaseAction {
    private SuningService suningService;
    private Suning suning;
    private Integer id;

    /**
     * 苏宁易购的安装
     *
     * @return
     */
    public String suNingApps() {
        try {
            Result result = suningService.getSuning();
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String addSuning() {
        return SUCCESS;
    }

    public void saveSuning() throws JSONException, IOException {
        SuningJSON suningJSON = new SuningJSON();
        try {
            suningService.createSuning(suning);
            suningJSON.setCode(1);
            suningJSON.setMess("成功");
        } catch (Exception e) {
            suningJSON.setCode(0);
            suningJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(suningJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void deleteSuning() throws JSONException, IOException {
        SuningJSON suningJSON = new SuningJSON();
        try {
            if (id != null) {
                suningService.deleteSuning(id);
                suningJSON.setCode(1);
                suningJSON.setMess("删除成功");
            }
        } catch (Exception e) {
            suningJSON.setCode(0);
            suningJSON.setMess("系统异常，请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(suningJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public String modifySuning() {
        try {
            Result result = suningService.modifySuning(id);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void updateSuning() throws JSONException, IOException {
        SuningJSON suningJSON = new SuningJSON();
        try {
            if (suning != null) {
                suningService.updateSuning(suning);
                suningJSON.setCode(1);
                suningJSON.setMess("更新成功");
            }
        } catch (Exception e) {
            suningJSON.setCode(0);
            suningJSON.setMess("系统异常,请重试");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(suningJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setSuningService(SuningService suningService) {
        this.suningService = suningService;
    }

    public Suning getSuning() {
        return suning;
    }

    public void setSuning(Suning suning) {
        this.suning = suning;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
