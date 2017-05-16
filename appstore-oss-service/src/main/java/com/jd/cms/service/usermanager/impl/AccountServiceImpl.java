package com.jd.cms.service.usermanager.impl;

import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.cms.manager.usermanager.AccountManager;
import com.jd.cms.service.usermanager.AccountService;
import com.jd.common.web.result.Result;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceImpl implements AccountService {
    /**
     * 用户管理Manager
     */
    private AccountManager accountManagerCached;

    /**
     * 查询用户列表
     *
     * @return
     * @throws Exception
     */
    public Result findAccounts(int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("accounts", accountManagerCached.findAccounts(pageIndex, pageSize));
        return result;
    }

    /**
     * 添加用户
     *
     * @return
     * @throws Exception
     */
    public int createAccount(SupportUsers supportUsers) {
        return accountManagerCached.createAccount(supportUsers);
    }

    /**
     * 修改用户密码
     *
     * @return
     * @throws Exception
     */
    public void doModifiedPassWord(SupportUsers supportUsers) {
        accountManagerCached.doModifiedPassWord(supportUsers);
    }

    /**
     * 初始化添加用户页
     *
     * @return
     * @throws Exception
     */
    public Result findSupportRoles() {
        Result result = new Result();
        result.addDefaultModel("roles", accountManagerCached.findSupportRoles());
        return result;
    }

    /**
     * 初始化设定角色页
     *
     * @return
     * @throws Exception
     */
    public Result findSupportRoles(SupportUsers supportUsers) {
        Result result = new Result();
        result.addDefaultModel("roles", accountManagerCached.findSupportRoles());
        result.addDefaultModel("account", supportUsers.getAccount());
        result.addDefaultModel("roleId", supportUsers.getRoleId());
        return result;
    }

    /**
     * 设定角色
     *
     * @return
     * @throws Exception
     */
    public void doModifiedRole(SupportUsers supportUsers) {
        accountManagerCached.doModifiedRole(supportUsers);
    }

    /**
     * 修改用户状态
     *
     * @return
     * @throws Exception
     */
    public void doModifiedStatus(SupportUsers supportUsers) {
        accountManagerCached.doModifiedStatus(supportUsers);
    }

    /**
     * 查询用户名是否存在
     *
     * @throws Exception
     */
    public SupportUsers checkedAccount(SupportUsers supportUsers) {
        return accountManagerCached.checkedAccount(supportUsers);
    }

    public void createChannelUser(ChannelUser channelUser) {
        accountManagerCached.createChannelUser(channelUser);
    }


    public Result getChannelUser(int userId) {
        Result result = new Result();
        try {
            result.addDefaultModel("channelUser", accountManagerCached.getChannelUser(userId));
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    public void setAccountManagerCached(AccountManager accountManagerCached) {
        this.accountManagerCached = accountManagerCached;
    }
}
