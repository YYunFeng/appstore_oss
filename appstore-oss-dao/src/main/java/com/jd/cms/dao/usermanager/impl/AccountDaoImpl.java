package com.jd.cms.dao.usermanager.impl;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.dao.usermanager.AccountDao;
import com.jd.cms.domain.usermanager.AccountManagerResult;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */
public class AccountDaoImpl extends BaseDao implements AccountDao {
    /**
     * 查询用户列表
     *
     * @param query
     * @return
     */
    public List<AccountManagerResult> findAccounts(Query query) {
        return queryForList("UserManager.findAccountManagerResult", query);
    }

    /**
     * 查询用户列表记录数
     *
     * @return
     */
    public int getAccountsCount() {
        return (Integer) queryForObject("UserManager.getAccountsCount");
    }

    /**
     * 查询全部角色
     *
     * @return
     */
    public List<SupportRole> findSupportRoles() {
        return queryForList("UserManager.findSupportRoles");
    }

    /**
     * 增加新用户
     *
     * @return
     */
    public void createAccount(SupportUsers supportUsers) {
        insert("UserManager.createSupportUsers", supportUsers);
    }

    /**
     * 修改用户密码
     *
     * @param supportUsers
     */
    public void doModifiedPassWord(SupportUsers supportUsers) {
        update("UserManager.modifiedSupportUsersPwd", supportUsers);
    }

    /**
     * 修改用户角色
     *
     * @param supportUsers
     */
    public void doModifiedRole(SupportUsers supportUsers) {
        update("UserManager.modifiedSupportUsersRole", supportUsers);
    }

    /**
     * 修改用户状态
     *
     * @param supportUsers
     */
    public void doModifiedStatus(SupportUsers supportUsers) {
        update("UserManager.modifiedSupportUsersStatus", supportUsers);
    }

    /**
     * 检证用户名
     *
     * @param supportUsers
     * @return
     */
    public SupportUsers checkedAccount(SupportUsers supportUsers) {
        return (SupportUsers) queryForObject("UserManager.checkedAccount", supportUsers);
    }

    public void createChannelUser(ChannelUser channelUser) {
        insert("UserManager.createChannelUser", channelUser);
    }

    public void deleteChannelUser(int userId) {
        delete("UserManager.deleteChannelUser", userId);
    }

    public ChannelUser getChannelUser(int userId) {
        return (ChannelUser)queryForObject("UserManager.getChannelUser", userId);
    }
}
