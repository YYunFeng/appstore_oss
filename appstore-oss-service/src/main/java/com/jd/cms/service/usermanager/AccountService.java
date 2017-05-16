package com.jd.cms.service.usermanager;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.AccountManagerResult;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.common.web.result.Result;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午8:54
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {
    /**
     * 查询用户列表
     *
     * @return
     * @throws Exception
     */
    Result findAccounts(int pageIndex, int pageSize);

    /**
     * 添加用户
     *
     * @return
     * @throws Exception
     */
    int createAccount(SupportUsers supportUsers);

    /**
     * 修改用户密码
     *
     * @return
     * @throws Exception
     */
    void doModifiedPassWord(SupportUsers supportUsers);

    /**
     * 初始化添加用户页
     *
     * @return
     * @throws Exception
     */
    Result findSupportRoles();

    /**
     * 初始化设定角色页
     *
     * @return
     * @throws Exception
     */
    Result findSupportRoles(SupportUsers supportUsers);

    /**
     * 设定角色
     *
     * @return
     * @throws Exception
     */
    void doModifiedRole(SupportUsers supportUsers);

    /**
     * 修改用户状态
     *
     * @return
     * @throws Exception
     */
    void doModifiedStatus(SupportUsers supportUsers);

    /**
     * 查询用户名是否存在
     *
     * @throws Exception
     */
    SupportUsers checkedAccount(SupportUsers supportUsers);



    void createChannelUser(ChannelUser channelUser);


    Result getChannelUser(int userId);
}
