package com.jd.cms.web.action.terminalManagement;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.service.terminalManagement.ScreenService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 屏幕管理action
 */
public class ScreenAction extends BaseAction {
    /**
     * message
     */
    private String message;
    /**
     * service注入
     */
    private ScreenService screenService;
    /**
     * 页面数据接收
     */
    private TerminalpageInput terminalpageInput;
    /**
     * 页面插入数据接收
     */
    private TerminalInsertInput terminalInsertInput;
    /**
     * 页面id接收
     */
    private int id;
    /**
     * 查询所有屏幕集合
     * @return String
     * @throws Exception
     */
    public String findScreenPage() throws Exception{
        message = Integer.toString(hashCode());
        Result results = screenService.findScreenPage(page,PAGE_SIZE);
        toVm(results);
        return SUCCESS;
    }
    /**
     * 创建新的屏幕信息
     * @return String
     * @throws Exception
     */
    public String createScreen() throws Exception{
        Result result = screenService.createScreen(terminalInsertInput);
        toVm(result);
        return null;
    }
    /**
     * 更新屏幕上下架状态
     * @return String
     * @throws Exception
     */
    public String upScreenOnline() throws Exception{
        if(null == terminalpageInput){
            terminalpageInput = new TerminalpageInput();
        }
        terminalpageInput.setScreenSizeId(id);
        screenService.upScreenOnline(terminalpageInput);
        return null;
    }
    /**
     * 删除屏幕信息
     * @return String
     * @throws Exception
     */
    public String delScreen() throws Exception{
        if(null == terminalpageInput){
            terminalpageInput = new TerminalpageInput();
        }
        terminalpageInput.setScreenSizeId(id);
        screenService.delScreen(terminalpageInput);
        return null;
    }
    /**
     * 根据ID查询单条屏幕信息
     * @return String
     * @throws Exception
     */
    public String findScreenById() throws Exception{
        Result result = screenService.findScreenById(id);
        toVm(result);
        return "SCREENEXPATIATION";
    }
    /**
     * 屏幕更新操作
     * @return String
     * @throws Exception
     */
    public String upScreen() throws Exception{
        screenService.upScreen(terminalpageInput);
        return null;
    }
    /**
     * 检查屏幕名
     * @return String
     * @throws Exception
     */
    public String checkScreenName() throws Exception{
        String name = terminalpageInput.getScreenSizeName();
        String check = screenService.checkScreenName(name);
        String json= JSONUtil.serialize(check);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }
    /**
     * 增加屏幕按钮操作
     * @return String
     */
    public String addScreenButton(){
        return "ADDSCREEN";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScreenService getScreenService() {
        return screenService;
    }

    public void setScreenService(ScreenService screenService) {
        this.screenService = screenService;
    }

    public TerminalpageInput getTerminalpageInput() {
        return terminalpageInput;
    }

    public void setTerminalpageInput(TerminalpageInput terminalpageInput) {
        this.terminalpageInput = terminalpageInput;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TerminalInsertInput getTerminalInsertInput() {
        return terminalInsertInput;
    }

    public void setTerminalInsertInput(TerminalInsertInput terminalInsertInput) {
        this.terminalInsertInput = terminalInsertInput;
    }
}
