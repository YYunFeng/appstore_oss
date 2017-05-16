package com.jd.cms.web.action.terminalManagement;

import com.jd.cms.domain.terminalManagement.TerminalInsertInput;
import com.jd.cms.domain.terminalManagement.TerminalpageInput;
import com.jd.cms.service.terminalManagement.OsService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: ZhouNan
 * Date: 12-7-12
 * Time: 下午2:01
 * 平台管理Action
 */
public class OsAction extends BaseAction {
    /**
     * message
     */
    private String message;
    /**
     * service注入
     */
    private OsService osService;
    /**
     * 页面插入数据接收
     */
    private TerminalInsertInput terminalInsertInput;
    /**
     * 页面数据接收
     */
    private TerminalpageInput terminalpageInput;
    /**
     * 页面id接收
     */
    private int id;
    /**
     * 查询所有系统集合
     * @return String
     * @throws Exception
     */
    public String findOsPage() throws Exception{
        message = Integer.toString(hashCode());
        Result results = osService.findOsPage(page,PAGE_SIZE);
        toVm(results);
        return SUCCESS;
    }
    /**
     * 创建新的系统
     * @return String
     * @throws Exception
     */
    public String createOs() throws Exception{
        Result result = osService.createOs(terminalInsertInput);
        toVm(result);
        return null;
    }
    /**
     * 更新系统上下架状态
     * @return String
     * @throws Exception
     */
    public String upOsOnline() throws Exception{
        if(null == terminalpageInput){
            terminalpageInput = new TerminalpageInput();
        }
        terminalpageInput.setOsVersionId(id);
        osService.upOsOnline(terminalpageInput);
        return null;
    }
    /**
     * 删除系统信息
     * @return String
     * @throws Exception
     */
    public String delOs() throws Exception{
        if(null == terminalpageInput){
            terminalpageInput = new TerminalpageInput();
        }
        terminalpageInput.setOsVersionId(id);
        osService.delOs(terminalpageInput);
        return null;
    }
    /**
     * 根据ID查询单条系统信息
     * @return String
     * @throws Exception
     */
    public String findOsById() throws Exception{
        Result result = osService.findOsById(id);
        toVm(result);
        return "OSEXPATIATION";
    }
    /**
     * 系统更新操作
     * @return String
     * @throws Exception
     */
    public String upOs() throws Exception{
        osService.upOs(terminalpageInput);
        return null;
    }
    /**
     * 检查系统名
     * @return String
     * @throws Exception
     */
    public String checkOsName() throws Exception{
        String name = terminalpageInput.getOsVersionName();
        String check = osService.checkOsName(name);
        String json= JSONUtil.serialize(check);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }
    /**
     * 检查版本码
     * @return String
     * @throws Exception
     */
    public String checkOsCode() throws Exception{
        int code = terminalpageInput.getOsVersionCode();
        String check = osService.checkOsCode(code);
        String json= JSONUtil.serialize(check);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        return null;
    }
    /**
     * 增加系统按钮操作
     * @return String
     */
    public String addOsButton(){
        return "ADDOS";
    }
    /**
     * 终端信息管理加载项
     * @return String
     */
    public String init(){
        return "INIT";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public OsService getOsService() {
        return osService;
    }

    public void setOsService(OsService osService) {
        this.osService = osService;
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
