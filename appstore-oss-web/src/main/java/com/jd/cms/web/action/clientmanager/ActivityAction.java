package com.jd.cms.web.action.clientmanager;

import com.jd.cms.domain.clientmanager.Activity;
import com.jd.cms.domain.clientmanager.ActivityChannel;
import com.jd.cms.domain.clientmanager.ActivityJSON;
import com.jd.cms.service.clientmanager.ActivityService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-6-7
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
public class ActivityAction extends BaseAction {

    private ActivityService activityService;
    private Activity activity;
    ActivityChannel activityChannel;
    private Integer activityId;


    /**
     * 活动列表
     *
     * @return
     */
    public String activityList() {
        try {
            Result result = activityService.getActivityList(page, PAGE_SIZE);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 创建活动
     *
     * @return
     */
    public String createActivity() {
        return SUCCESS;
    }

    /**
     * 创建活动 --- 入库
     *
     * @throws IOException
     * @throws JSONException
     */
    public void saveActivity() throws IOException, JSONException {
        ActivityJSON activityJSON = new ActivityJSON();
        try {
            //用新插的记录去查询排序是否存在
            Integer count = activityService.findActivityBySeq(activity.getSeq());
            if (count != null) {
                if (count == 0) { // 不存在该排序
                    activityService.createActivity(activity);
                } else {  // 存在该排序
                    activityService.updateActivitySeq(activity.getSeq()); // 所有比新插得数据排序降一
                    activityService.createActivity(activity);
                }
            }
            activityJSON.setCode(1);
            activityJSON.setStatus(1);
            activityJSON.setMess("创建成功");
        } catch (Exception e) {
            activityJSON.setCode(0);
            activityJSON.setStatus(0);
            activityJSON.setMess("创建失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(activityJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 删除活动
     *
     * @throws JSONException
     * @throws IOException
     */
    public void deleteActivity() throws JSONException, IOException {
        ActivityJSON activityJSON = new ActivityJSON();
        try {
            activityService.deletActivity(activity.getId(), activity.getSeq());
            activityJSON.setCode(1);
            activityJSON.setStatus(1);
            activityJSON.setMess("删除成功");
        } catch (Exception e) {
            activityJSON.setCode(0);
            activityJSON.setStatus(0);
            activityJSON.setMess("删除失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(activityJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 更新上下线状态
     *
     * @throws JSONException
     * @throws IOException
     */
    public void updateActivityPubedStatus() throws JSONException, IOException {
        ActivityJSON activityJSON = new ActivityJSON();
        try {
            activityService.updateActivityPubedStatus(activity);
            activityJSON.setCode(1);
            activityJSON.setStatus(1);
            activityJSON.setMess("更新上下线成功");
        } catch (Exception e) {
            activityJSON.setCode(1);
            activityJSON.setStatus(1);
            activityJSON.setMess("更新上下线失败");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(activityJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 修改活动
     *
     * @return
     */
    public String modifyActivity() {
        try {
            Result result = activityService.getActivityById(activity);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 修改活动入库
     *
     * @throws JSONException
     * @throws IOException
     */
    public void saveModifyActivity() throws JSONException, IOException {
        ActivityJSON activityJSON = new ActivityJSON();
        try {
            if (activity.getSeq() != null && activity.getSeqParameter() != null) {
                if (activity.getSeq().intValue() != activity.getSeqParameter().intValue()) { //修改了排序
                    activityService.updateActivitySeqBySeq(activity);
                }
                activityService.updateActivity(activity);
                activityJSON.setCode(1);
                activityJSON.setStatus(1);
                activityJSON.setMess("修改成功");
            }
        } catch (Exception e) {
            activityJSON.setStatus(0);
            activityJSON.setCode(0);
            activityJSON.setMess("修改失败！");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(activityJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    /**
     * 获得活动关联渠道信息
     *
     * @return
     */
    public String activityRelevanceChannel() {
        try {
            Result result = activityService.activityReleanceChannel(activityId);
            toVm(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 活动关联渠道
     *
     * @throws JSONException
     * @throws IOException
     */
    public void createActivityReleanceChannel() throws JSONException, IOException {
        ActivityJSON activityJSON = new ActivityJSON();
        try {
            activityService.createActivityReleanceChannel(activityChannel);
            activityJSON.setCode(1);
            activityJSON.setStatus(1);
            activityJSON.setMess("关联渠道成功");
        } catch (Exception e) {
            activityJSON.setStatus(0);
            activityJSON.setCode(0);
            activityJSON.setMess("关联渠道失败！");
            e.printStackTrace();
        }
        String json = JSONUtil.serialize(activityJSON);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }





    /**
     * 电子市场
     */
    public String marketApps() {
        return SUCCESS;
    }

    /**
     * 公司总收入
     *
     * @return
     */
    public String companyIncome() {
        return SUCCESS;
    }

    /**
     * 按渠道查看
     *
     * @return
     */
    public String incomeByChannel() {
        return SUCCESS;
    }


    /**
     * 按促销员
     *
     * @return
     */
    public String incomeBySaler() {
        return SUCCESS;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ActivityChannel getActivityChannel() {
        return activityChannel;
    }

    public void setActivityChannel(ActivityChannel activityChannel) {
        this.activityChannel = activityChannel;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
