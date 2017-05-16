package com.jd.cms.manager.usermanager.impl;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.domain.usermanager.AccountManagerResult;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.usermanager.AccountManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-18
 * Time: 下午5:36
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerCachedImpl implements AccountManager {
    /**
     * memcache工具类
     */
    private CacheUtils cacheUtils;
    /**
     * 用户管理Manager
     */
    private AccountManager accountManager;
    private final static Log log = LogFactory.getLog(AccountManagerCachedImpl.class);

    /**
     * 记录页号
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<AccountManagerResult> findAccounts(int pageIndex, int pageSize) {
        PaginatedList<AccountManagerResult> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_ACCOUNTMANAGER_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询用户信息列表
        paginatedList = accountManager.findAccounts(pageIndex, pageSize);
        //用户信息列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ACCOUNTMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findAccounts(pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ACCOUNTMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回用户信息列表
        return paginatedList;
    }

    /**
     * 初始化添加用户页
     *
     * @return
     * @throws Exception
     */
    public List<SupportRole> findSupportRoles() {
        return accountManager.findSupportRoles();
    }

    /**
     * 添加用户
     *
     * @return
     * @throws Exception
     */
    public int createAccount(SupportUsers supportUsers) {
        return accountManager.createAccount(supportUsers);
    }

    /**
     * 修改用户密码
     *
     * @return
     * @throws Exception
     */
    public void doModifiedPassWord(SupportUsers supportUsers) {
        accountManager.doModifiedPassWord(supportUsers);
    }

    /**
     * 设定角色
     *
     * @return
     * @throws Exception
     */
    public void doModifiedRole(SupportUsers supportUsers) {
        accountManager.doModifiedRole(supportUsers);
    }

    /**
     * 修改用户状态
     *
     * @return
     * @throws Exception
     */
    public void doModifiedStatus(SupportUsers supportUsers) {
        accountManager.doModifiedStatus(supportUsers);
    }

    /**
     * 查询用户名是否存在
     *
     * @throws Exception
     */
    public SupportUsers checkedAccount(SupportUsers supportUsers) {
        return accountManager.checkedAccount(supportUsers);
    }

    public void createChannelUser(ChannelUser channelUser) {
        accountManager.createChannelUser(channelUser);
    }

    public void deleteChannelUser(int userId) {
        accountManager.deleteChannelUser(userId);
    }

    public ChannelUser getChannelUser(int userId) {
        return accountManager.getChannelUser(userId);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}
