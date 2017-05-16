package com.jd.cms.web.action.clientmanager;

import com.jd.appstore.domain.Category;
import com.jd.cms.service.clientmanager.AppService;
import com.jd.cms.service.clientmanager.CategoryService;
import com.jd.cms.service.clientmanager.TopicService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: hqj
 * Date: 12-7-19
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */
public class SearchAction extends BaseAction {
    private String appName;
    private String topicName;
    private String categoryName;
    private int pageSize = 5;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private AppService appService;
    private TopicService topicService;
    private CategoryService categoryService;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }



    public String SearchApp() throws Exception {
        try {
            Result apps = appService.findApps(page, pageSize, appName);
            toVm(apps);
            return "appList";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String SearchAppForTopic() throws Exception{
        try {
            Result apps = appService.findAppsForTopic(page, pageSize, appName, appService.getMobileGameId(), appService.getMobileSoftId());
            toVm(apps);
            return "appList";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String SearchAppForMobile() throws Exception{
        Result apps = appService.findAppsForTopic(page, pageSize, appName, appService.getMobileGameId(), appService.getMobileSoftId());
        toVm(apps);
        return "appListForRecommend";
    }

    public String SearchAppForSoft() throws Exception{
        Result apps = appService.findAppsByModule(page, pageSize, appName, appService.getMobileSoftId());
        toVm(apps);
        return "appListForRecommend";
    }

    public String SearchAppForGame() throws Exception{
        Result apps = appService.findAppsByModule(page, pageSize, appName, appService.getMobileGameId());
        toVm(apps);
        return "appListForRecommend";
    }

    public String SearchAppForWeb() throws Exception{
        Result apps = appService.findAppsByModule(page, pageSize, appName, appService.getWebAppId());
        toVm(apps);
        return "appListForRecommend";
    }

    public String SearchAppForRecommend() throws Exception{
        try{
            Result apps = appService.findApps(page, pageSize, appName);
            toVm(apps);
            return "appListForRecommend";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String SearchRankingApp() throws Exception{
        try{
            Result result = appService.findApps(page, pageSize,appName);
            toVm(result);
            String json = JSONUtil.serialize(result);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void SearchAppJson() throws Exception {
        Result result = new Result();
        result = appService.findApps(page, pageSize,appName);
        String json = JSONUtil.serialize(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void searchCategoryJson() throws Exception{
        Result categorys = categoryService.findCategoryByParentId(category);
        String json = JSONUtil.serialize(categorys);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public void SearchTopic() throws Exception {
        Result topics = topicService.findTopicByName(topicName);
        String json = JSONUtil.serialize(topics);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    public String SearchTopicForRecommend() throws Exception {
        Result topics = topicService.findTopicByNamePage(page, pageSize,topicName);
        toVm(topics);
        return "TopicForRecommend";
    }

    public void SearchCategory() throws Exception {
        Result categorys = categoryService.findCategory(categoryName);
        String json = JSONUtil.serialize(categorys);
        response.setCharacterEncoding("utf-8");
        System.out.println(json);
        response.getWriter().write(json);
    }


}
