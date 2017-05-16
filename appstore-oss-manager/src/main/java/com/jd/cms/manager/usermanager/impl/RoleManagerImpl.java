package com.jd.cms.manager.usermanager.impl;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.dao.usermanager.RoleDao;
import com.jd.cms.domain.usermanager.RoleManagerResult;
import com.jd.cms.manager.contains.SequenceConstants;
import com.jd.cms.manager.usermanager.RoleManager;
import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-15
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class RoleManagerImpl extends BaseManager implements RoleManager {
    private final static Logger log = Logger.getLogger(RoleManagerImpl.class);
    /**
     * 角色管理Dao
     */
    private RoleDao roleDao;
    /**
     * 查询角色列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<RoleManagerResult> findRoles(int pageIndex, int pageSize) {
        if (0 == pageIndex) pageIndex = 1;
        PaginatedList<RoleManagerResult> roles = new PaginatedArrayList<RoleManagerResult>(pageIndex, pageSize);
        try {
            BaseQuery baseQuery = new BaseQuery();
            //查询总记录数
            int totalItem = roleDao.getRolesCount();
            //设置总记录数
            roles.setTotalItem(totalItem);
            //设置查询页号
            baseQuery.setStartRow((pageIndex - 1) * pageSize);
            //设置查询记录数
            baseQuery.setEndRow(pageSize);
            //查询角色列表
            List<RoleManagerResult> role = roleDao.findAccounts(baseQuery);
            //设置角色列表
            roles.addAll(role);
        } catch (Exception ex) {
            log.error("findRoles 分页查询全部角色方法 pageIndex="+pageIndex+" pageSize="+pageSize+" error!", ex);
            throw new RuntimeException("findRoles 分页查询全部角色方法 pageIndex="+pageIndex+" pageSize="+pageSize+" error!", ex);
        }
        return roles;
    }
    /**
     * 查询所有模块
     *
     * @return
     */
    public List<SupportModule> findModules() {
        List<SupportModule> supportModuleList=new ArrayList<SupportModule>();
        try {
            supportModuleList=roleDao.findModules();
        } catch (Exception ex) {
            log.error("findModules 查询全部模块方法 error!", ex);
            throw new RuntimeException("findModules 查询全部模块方法 error!", ex);
        }
        return supportModuleList;
    }
    /**
     * 查询角色是否存在
     *
     * @param supportRole
     * @return
     */
    public SupportRole checkedRole(SupportRole supportRole) {
        SupportRole supportRoleResult=new SupportRole();
        try {
            supportRoleResult=roleDao.checkedRole(supportRole);
        } catch (Exception ex) {
            log.error("checkedRole 验证角色名是否存在方法 supportRole="+supportRole+" error!", ex);
            throw new RuntimeException("checkedRole 验证角色名是否存在方法 supportRole="+supportRole+" error!", ex);
        }
        return supportRoleResult;
    }
    /**
     * 添加角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int createRole(final SupportRole supportRole, final String moduleList) {
        supportRole.setRoleId((int) sequenceUtil.get(SequenceConstants.CMS_SUPPERROLE_SEQUENCE));
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //创建角色
                    roleDao.createRole(supportRole);
                    SupportRoleModule supportRoleModule;
                    //按逗号分割将模块写入字符串数组
                    String[] moduleIdList = moduleList.split(",");
                    //循环插入用户拥有权限
                    for (int i = 0; i < moduleIdList.length; i++) {
                        supportRoleModule = new SupportRoleModule();
                        //创建并设置ID
                        supportRoleModule.setId((int) sequenceUtil.get(SequenceConstants.CMS_SUPPERROLEMODULE_SEQUENCE));
                        //设置角色ID
                        supportRoleModule.setRoleId(supportRole.getRoleId());
                        //设置模块ID
                        supportRoleModule.setModuleId(Integer.parseInt(moduleIdList[i]));
                        //插入角色所属模块
                        roleDao.createRoleModule(supportRoleModule);
                    }
                } catch (Exception ex) {
                    log.error("createRole 增加新角色方法 supportRole="+supportRole+" moduleList="+moduleList+" error!", ex);
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        return supportRole.getRoleId();
    }
    /**
     * 查询用户所属模块
     *
     * @param supportRole
     * @return
     */
    public List<SupportRoleModule> findRoleModules(SupportRole supportRole) {
        List<SupportRoleModule> supportRoleModuleList=new ArrayList<SupportRoleModule>();
        try {
            supportRoleModuleList=roleDao.findRoleModules(supportRole);
        } catch (Exception ex) {
            log.error("findRoleModules 查询已分配给角色的模块方法论 supportRole="+supportRole+" error!", ex);
            throw new RuntimeException("findRoleModules 查询已分配给角色的模块方法论 supportRole="+supportRole+" error!", ex);
        }
        return supportRoleModuleList;
    }
    /**
     * 修改角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int doModifiedRole(final SupportRole supportRole, final String moduleList) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //修改角色
                    roleDao.modifiedRole(supportRole);
                    //删除已有权限
                    roleDao.deleteRoleModule(supportRole);
                    SupportRoleModule supportRoleModule;
                    //按逗号分割将模块写入字符串数组
                    String[] moduleIdList = moduleList.split(",");
                    //循环插入用户拥有权限
                    for (int i = 0; i < moduleIdList.length; i++) {
                        supportRoleModule = new SupportRoleModule();
                        //创建并设置ID
                        supportRoleModule.setId((int) sequenceUtil.get(SequenceConstants.CMS_SUPPERROLEMODULE_SEQUENCE));
                        //设置角色ID
                        supportRoleModule.setRoleId(supportRole.getRoleId());
                        //设置模块ID
                        supportRoleModule.setModuleId(Integer.parseInt(moduleIdList[i]));
                        //插入角色所属模块
                        roleDao.createRoleModule(supportRoleModule);
                    }
                } catch (Exception ex) {
                    log.error("doModifiedRole 修改角色信息方法 supportRole="+supportRole+" moduleList="+moduleList+" error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("doModifiedRole 修改角色信息方法 supportRole="+supportRole+" moduleList="+moduleList+" error!", ex);
                }
            }
        });
        return 1;
    }
    /**
     * 删除角色
     *
     * @param supportRole
     * @return
     */
    public int deleteRole(final SupportRole supportRole) {
        TransactionTemplate transactionTemplate = getDataSourceTransactionManager();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    //删除角色
                    roleDao.deleteRole(supportRole);
                    //删除已有权限
                    roleDao.deleteRoleModule(supportRole);
                    //修改用户角色
                    roleDao.modifiedUserRole(supportRole);
                } catch (Exception ex) {
                    log.error("deleteRole 删除角色方法 supportRole="+supportRole+" error!", ex);
                    transactionStatus.setRollbackOnly();
                    throw new RuntimeException("deleteRole 删除角色方法 supportRole="+supportRole+" error!", ex);
                }
            }
        });
        return 1;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
