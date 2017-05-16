package com.jd.cms.web.action.appManagement;

import com.jd.cms.domain.appManagement.*;
import com.jd.cms.service.appManagement.SalesStatisticsService;
import com.jd.cms.service.appManagement.ValidMachineStatisticsService;
import com.jd.cms.service.login.LoginService;
import com.jd.cms.util.StatisticsExcel;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-7-23
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class SalesStatisticsAction extends BaseAction {
    private SalesStatisticsService salesStatisticsService;
    private SalerRankingParameter salerRankingParameter;
    private StatisticsExcel statisticsExcel;
    private PhoneIntallMessParameter phoneIntallMessParameter;
    private Integer flag;
    private ProvinceStatisParameter provinceStatisParameter;
    private InstaisticNorm instaisticNorm;


    /**
     * 获取促销员排名
     *
     * @return
     */
    public String salerRankingManager() {
        return SUCCESS;
    }

    /**
     * 促销员排名
     *
     * @return
     */
    public String salerRanking() {
        Result result = salesStatisticsService.getSalerRanking(salerRankingParameter);
        toVm(result);
        return SUCCESS;
    }

    public String phoneInstallMess() {
        return SUCCESS;
    }

    /**
     * 手机安装信息
     *
     * @return
     */
    public String phoneInstallMessContent() {
        phoneIntallMessParameter.setFlag(0);
        Result result = salesStatisticsService.getPhoneInstallMess(phoneIntallMessParameter, page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 导出EXCEL
     *
     * @throws IOException
     * @throws JSONException
     */
    public void statisticsExcel() throws IOException, JSONException {
        ExportExcelJSON exportExcelJSON = new ExportExcelJSON();
        try {
            exportExcelJSON.setStatus(1);
            exportExcelJSON.setExcelDownAddress(statisticsExcel.CreateStatisticsExcel(salerRankingParameter, phoneIntallMessParameter, provinceStatisParameter, flag));
            exportExcelJSON.setMess("导出报表成功");
        } catch (Exception e) {
            exportExcelJSON.setStatus(0);
            exportExcelJSON.setMess(e.getMessage());
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(exportExcelJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }


    /**
     * 按每天查看应用的安装情况
     *
     * @return
     */
    public String dayInstallMess() {
        Result result = salesStatisticsService.getDayInstallMess(page, PAGE_SIZE);
        toVm(result);
        return SUCCESS;
    }

    public String provinceMonthly() {
        return SUCCESS;
    }

    public String provinceMonthlyContent() {
        Result result = salesStatisticsService.provinceStatis(provinceStatisParameter);
        toVm(result);
        return SUCCESS;
    }

    /**
     * 设置各个省份的统计标准
     *
     * @throws JSONException
     * @throws IOException
     */
    public void incomeTarget() throws JSONException, IOException {
        StatusJSON statusJSON = new StatusJSON();
        try {
            if (instaisticNorm != null && instaisticNorm.getCid() != null) {
                instaisticNorm.setTime(instaisticNorm.getTime().substring(0, instaisticNorm.getTime().lastIndexOf("-")));
                Integer id = salesStatisticsService.getInstaisticNorm(instaisticNorm);
                if (id != null && id.intValue() > 0) {  // 已经有该渠道的统计标准
                    instaisticNorm.setId(id);
                    salesStatisticsService.updateInstaisticNorm(instaisticNorm);
                    statusJSON.setMess("更新成功");
                } else {
                    salesStatisticsService.createInstaisticNorm(instaisticNorm);
                    statusJSON.setMess("创建成功");
                }
                statusJSON.setStatus(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(statusJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void setSalesStatisticsService(SalesStatisticsService salesStatisticsService) {
        this.salesStatisticsService = salesStatisticsService;
    }

    public SalerRankingParameter getSalerRankingParameter() {
        return salerRankingParameter;
    }

    public void setSalerRankingParameter(SalerRankingParameter salerRankingParameter) {
        this.salerRankingParameter = salerRankingParameter;
    }

    public void setStatisticsExcel(StatisticsExcel statisticsExcel) {
        this.statisticsExcel = statisticsExcel;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public PhoneIntallMessParameter getPhoneIntallMessParameter() {
        return phoneIntallMessParameter;
    }

    public void setPhoneIntallMessParameter(PhoneIntallMessParameter phoneIntallMessParameter) {
        this.phoneIntallMessParameter = phoneIntallMessParameter;
    }

    public ProvinceStatisParameter getProvinceStatisParameter() {
        return provinceStatisParameter;
    }

    public void setProvinceStatisParameter(ProvinceStatisParameter provinceStatisParameter) {
        this.provinceStatisParameter = provinceStatisParameter;
    }

    public InstaisticNorm getInstaisticNorm() {
        return instaisticNorm;
    }

    public void setInstaisticNorm(InstaisticNorm instaisticNorm) {
        this.instaisticNorm = instaisticNorm;
    }
}
