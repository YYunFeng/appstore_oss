package com.jd.cms.web.action.usermanager;

import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.common.util.MD5Utils;
import com.jd.cms.domain.cpQualityManagement.PadChannel;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.cms.service.cpQualityManagement.CpQualityManagementService;
import com.jd.cms.service.usermanager.AccountService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import java.io.IOException;


/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 * 用户管理
 */
public class AccountAction extends BaseAction {

    /**
     * 用户管理Serviec
     */
    private AccountService accountService;
    /**
     * 运营支撑系统用户表
     */
    private SupportUsers supportUsers;

    private CpQualityManagementService cpQualityManagementService;

    private Integer userId;

    private ChannelUser channelUser;

    /**
     * 初始化用户管理
     * x a
     *
     * @return
     * @throws Exception
     */
    public String init() throws Exception {
        return "init";
    }

    /**
     * 查询用户列表
     *
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        Result accounts = accountService.findAccounts(page, PAGE_SIZE);
        toVm(accounts);
        return "list";
    }

    /**
     * 添加用户
     *
     * @return
     * @throws Exception
     */
    public String doAdd() throws Exception {

        if (null != supportUsers) {
            //用MD5加密密码
            supportUsers.setPassword(MD5Utils.getMD5Str(supportUsers.getPassword()));
        }
        //插入新用户
        accountService.createAccount(supportUsers);
        return list();
    }

    /**
     * 初始化修改用户密码页
     *
     * @return
     * @throws Exception
     */
    public String modifiedPassWord() throws Exception {
        Result result = new Result();
//        createExcelTemp.getExcel();
        result.addDefaultModel("account", supportUsers.getAccount());
        toVm(result);
        return "password";
    }

    /**
     * 修改用户密码
     *
     * @return
     * @throws Exception
     */
    public String doModifiedPassWord() throws Exception {
        if (null != supportUsers) {
            //用MD5加密密码
            supportUsers.setPassword(MD5Utils.getMD5Str(supportUsers.getPassword()));
        }
        //修改用户密码
        accountService.doModifiedPassWord(supportUsers);
        return list();
    }

    /**
     * 初始化添加用户页
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        //查询角色信息
        Result result = accountService.findSupportRoles();
        toVm(result);
        return "add";
    }

    /**
     * 修改用户状态
     *
     * @return
     * @throws Exception
     */
    public String doModifiedStatus() throws Exception {
        //修改用户状态
        accountService.doModifiedStatus(supportUsers);
        return list();
    }

    /**
     * 查询用户名是否存在
     *
     * @throws Exception
     */
    public void checkedAccount() throws Exception {
        //用户是否存在标识
        String msg;
        //根据用户名查询用户信息
        supportUsers = accountService.checkedAccount(supportUsers);
        //判断用户是否存在
        if (null == supportUsers) {
            //用户存在
            msg = "success";
        } else {
            //用户不存在
            msg = "error";
        }
        //用户是否存在标识定心和JSON
        String json = JSONUtil.serialize(msg);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 初始化设定角色页
     *
     * @return
     * @throws Exception
     */
    public String modifiedRole() throws Exception {
        //查询角色信息
        Result result = accountService.findSupportRoles(supportUsers);
        toVm(result);
        return "role";
    }

    /**
     * 设定角色
     *
     * @return
     * @throws Exception
     */
    public String doModifiedRole() throws Exception {
        //查询角色信息
        accountService.doModifiedRole(supportUsers);
        return list();
    }

    public String relevanceChannel() {
        PadChannel padChannel = new PadChannel();
        Result result = cpQualityManagementService.getChannelCp(padChannel, page, 10000);
        toVm(result);
        Result channelUserResult = accountService.getChannelUser(userId);
        toVm(channelUserResult);
        return SUCCESS;
    }

    public void createChannelUser() throws JSONException, IOException {
        Integer stauts = 0;
        try {
            accountService.createChannelUser(channelUser);
            stauts = 1;
        } catch (Exception e) {
            e.printStackTrace();
            stauts = 0;
        }
        //用户是否存在标识定心和JSON
        String json = JSONUtil.serialize(stauts);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public SupportUsers getSupportUsers() {
        return supportUsers;
    }

    public void setSupportUsers(SupportUsers supportUsers) {
        this.supportUsers = supportUsers;
    }

    public void setCpQualityManagementService(CpQualityManagementService cpQualityManagementService) {
        this.cpQualityManagementService = cpQualityManagementService;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ChannelUser getChannelUser() {
        return channelUser;
    }

    public void setChannelUser(ChannelUser channelUser) {
        this.channelUser = channelUser;
    }
}
