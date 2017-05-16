package com.jd.cms.dao.usermanager;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.AccountManagerResult;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-6
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */
public interface AccountDao {
    /**
     * 查询用户列表
     *
     * @param query
     * @return
     */
    List<AccountManagerResult> findAccounts(Query query);

    /**
     * 查询用户列表记录数
     *
     * @return
     */
    int getAccountsCount();

    /**
     * 查询全部角色
     *
     * @return
     */
    List<SupportRole> findSupportRoles();

    /**
     * 增加新用户
     *
     * @param supportUsers
     */
    void createAccount(SupportUsers supportUsers);

    /**
     * 修改用户密码
     *
     * @param supportUsers
     */
    void doModifiedPassWord(SupportUsers supportUsers);

    /**
     * 修改用户角色
     *
     * @param supportUsers
     */
    void doModifiedRole(SupportUsers supportUsers);

    /**
     * 修改用户状态
     *
     * @param supportUsers
     */
    void doModifiedStatus(SupportUsers supportUsers);

    /**
     * 检证用户名
     *
     * @param supportUsers
     * @return
     */
    SupportUsers checkedAccount(SupportUsers supportUsers);


    void createChannelUser(ChannelUser channelUser);

    void deleteChannelUser(int userId);

    ChannelUser getChannelUser(int userId);



}
