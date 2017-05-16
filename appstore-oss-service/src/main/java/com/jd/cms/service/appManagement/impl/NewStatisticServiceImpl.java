package com.jd.cms.service.appManagement.impl;

import com.jd.cms.domain.appManagement.MarketStatInput;
import com.jd.cms.manager.appManagement.NewStatisticManager;
import com.jd.cms.service.appManagement.NewStatisticService;
import com.jd.common.web.result.Result;

/**
 * YYF on 2015/4/16.
 */
public class NewStatisticServiceImpl implements NewStatisticService {
    private NewStatisticManager newStatisticManager;

    /**
     * 应用安装总数
     *
     * @param marketStatInput
     * @return
     */
    public Result appIntallTotal(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("appInstallTotal", newStatisticManager.appInstallTotal(marketStatInput));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 安装总量按应用查看
     *
     * @param marketStatInput
     * @return
     */
    public Result totalByApp(MarketStatInput marketStatInput, int pageIndex, int pageSize) {
        Result result = new Result();
        try {
            result.addDefaultModel("totalByApp", newStatisticManager.totalByApp(marketStatInput, pageIndex, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 安装总量按渠道查看
     *
     * @param marketStatInput
     * @return
     */
    public Result totalByChannel(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("totalByChannel", newStatisticManager.totalByChannel(marketStatInput));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看渠道下店长和督导的安装量
     *
     * @param marketStatInput
     * @return
     */
    public Result channelBySaler(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("channelBySaler", newStatisticManager.channelBySaler(marketStatInput));
            result.addDefaultModel("userCid", marketStatInput.getUserCid());
            result.addDefaultModel("cid", marketStatInput.getCid());
            result.addDefaultModel("channelType", marketStatInput.getChannelType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 按渠道类型查看
     *
     * @param marketStatInput
     * @return
     */
    public Result channelType(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("channelType", newStatisticManager.channelType(marketStatInput));
            result.addDefaultModel("userCid", marketStatInput.getUserCid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看督导或者店长下促销员的安装详情
     *
     * @param marketStatInput
     * @return
     */
    public Result channelBySalerDetails(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("channelBySalerDetails", newStatisticManager.channelBySalerDetails(marketStatInput));
            result.addDefaultModel("cid", marketStatInput.getCid());
            result.addDefaultModel("userCid", marketStatInput.getUserCid());
            result.addDefaultModel("channelType", marketStatInput.getChannelType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看促销员的安装的应用
     *
     * @param marketStatInput
     * @return
     */
    public Result appBySalerNo(MarketStatInput marketStatInput) {
        Result result = new Result();
        try {
            result.addDefaultModel("appBySalerNo", newStatisticManager.appBySalerNo(marketStatInput));
            result.addDefaultModel("saler", marketStatInput.getParentId());
            result.addDefaultModel("cid", marketStatInput.getCid());
            result.addDefaultModel("userCid", marketStatInput.getUserCid());
            result.addDefaultModel("channelType", marketStatInput.getChannelType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void setNewStatisticManager(NewStatisticManager newStatisticManager) {
        this.newStatisticManager = newStatisticManager;
    }
}
