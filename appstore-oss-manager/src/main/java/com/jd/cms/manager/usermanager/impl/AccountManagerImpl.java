package com.jd.cms.manager.usermanager.impl;

import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportUsers;
import com.jd.cms.dao.usermanager.AccountDao;
import com.jd.cms.domain.usermanager.AccountManagerResult;
import com.jd.cms.domain.usermanager.ChannelUser;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.usermanager.AccountManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午8:51
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerImpl extends BaseManager implements AccountManager {
    private final static Logger logger = Logger.getLogger(AccountManagerImpl.class);
    /**
     * 用户管理Dao
     */
    private AccountDao accountDao;

    /**
     * 查询用户列表
     *
     * @return
     * @throws Exception
     */
    public PaginatedList<AccountManagerResult> findAccounts(int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<AccountManagerResult> accounts = new PaginatedArrayList<AccountManagerResult>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            //查询用户列表记录数
            int totalItem = accountDao.getAccountsCount();
            //设置记录总数到PaginatedList
            accounts.setTotalItem(totalItem);
            //设置从第几页开始查询
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            //设置查询多少条
            baseQuery.setEndRow(pageSize);
            //查询用户列表
            List<AccountManagerResult> account = accountDao.findAccounts(baseQuery);
            //设置用户列表到PaginatedList
            accounts.addAll(account);
        } catch (Exception ex) {
            logger.error("findAccounts 分页查询全部用户方法 pageIndex=" + pageIndex + " pageSize=" + pageSize + "  error!", ex);
            throw new RuntimeException("findAccounts 分页查询全部用户方法 pageIndex=" + pageIndex + " pageSize=" + pageSize + "  error!", ex);
        }
        return accounts;
    }

    /**
     * 初始化添加用户页
     *
     * @return
     * @throws Exception
     */
    public List<SupportRole> findSupportRoles() {
        List<SupportRole> supportRoleList = new ArrayList<SupportRole>();
        try {
            //查询全部角色
            supportRoleList = accountDao.findSupportRoles();
        } catch (Exception ex) {
            logger.error("findSupportRoles 查询全部角色方法 error!", ex);
            throw new RuntimeException("findSupportRoles 查询全部角色方法 error!", ex);
        }
        return supportRoleList;
    }

    /**
     * 添加用户
     *
     * @return
     * @throws Exception
     */
    public int createAccount(final SupportUsers supportUsers) {
        //获取主键
        int id = (int) sequenceUtil.get(SequenceConstants.CMS_SUPPERUSERS_SEQUENCE);
        supportUsers.setId(id);
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //增加新用户
                    accountDao.createAccount(supportUsers);
                } catch (Exception ex) {
                    logger.error("createAccount 增加新用户方法 supportUsers=" + supportUsers + " error!", ex);
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        return id;
    }

    /**
     * 修改用户密码
     *
     * @return
     * @throws Exception
     */
    public void doModifiedPassWord(final SupportUsers supportUsers) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //修改用户密码
                    accountDao.doModifiedPassWord(supportUsers);
                } catch (Exception ex) {
                    logger.error("modifiedPassWord 修改用户密码方法 supportUsers=" + supportUsers + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("modifiedPassWord 修改用户密码方法 supportUsers=" + supportUsers + " error!", ex);
                }
            }
        });
    }

    /**
     * 设定角色
     *
     * @return
     * @throws Exception
     */
    public void doModifiedRole(final SupportUsers supportUsers) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //修改用户角色
                    accountDao.doModifiedRole(supportUsers);
                } catch (Exception ex) {
                    logger.error("doModifiedRole 修改用户角色方法  supportUsers=" + supportUsers + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("doModifiedRole 修改用户角色方法 supportUsers=" + supportUsers + " error!", ex);
                }
            }
        });
    }

    /**
     * 修改用户状态
     *
     * @return
     * @throws Exception
     */
    public void doModifiedStatus(final SupportUsers supportUsers) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //修改用户状态
                    accountDao.doModifiedStatus(supportUsers);
                } catch (Exception ex) {
                    logger.error("doModifiedStatus 修改用户状态方法 supportUsers=" + supportUsers + " error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("doModifiedStatus 修改用户状态方法 supportUsers=" + supportUsers + " error!", ex);
                }
            }
        });
    }

    /**
     * 查询用户名是否存在
     *
     * @throws Exception
     */
    public SupportUsers checkedAccount(SupportUsers supportUsers) {
        SupportUsers supportUsersResult = new SupportUsers();
        try {
            //检证用户名
            supportUsersResult = accountDao.checkedAccount(supportUsers);
        } catch (Exception ex) {
            logger.error("checkedAccount 检证用户名方法 supportUsers=" + supportUsers + "  error!", ex);
            throw new RuntimeException("checkedAccount 检证用户名方法 supportUsers=" + supportUsers + "  error!", ex);
        }
        return supportUsersResult;
    }

    public void createChannelUser(ChannelUser channelUser) {
        try {
            accountDao.deleteChannelUser(channelUser.getUserId());
            accountDao.createChannelUser(channelUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteChannelUser(int userId) {
        accountDao.deleteChannelUser(userId);
    }

    public ChannelUser getChannelUser(int userId) {
        ChannelUser channelUser = null;
        try {
            channelUser = accountDao.getChannelUser(userId);
            if (channelUser == null) {
                channelUser = new ChannelUser();
            }
            channelUser.setUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelUser;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
