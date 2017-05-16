package com.jd.cms.manager.usermanager.impl;

import com.jd.appstore.domain.SupportModule;
import com.jd.appstore.domain.SupportRole;
import com.jd.appstore.domain.SupportRoleModule;
import com.jd.cms.domain.usermanager.RoleManagerResult;
import com.jd.cms.manager.contains.CategoryConstants;
import com.jd.cms.manager.usermanager.RoleManager;
import com.jd.common.util.PaginatedList;
import com.jd.digital.common.util.cache.CacheUtils;
import com.jd.digital.common.util.tool.WebHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-18
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class RoleManagerCachedImpl implements RoleManager {
    /**
     * memcache工具类
     */
    private CacheUtils cacheUtils;
    /**
     * 角色管理Manager
     */
    private RoleManager roleManager;
    private final static Log log = LogFactory.getLog(RoleManagerCachedImpl.class);

    /**
     * 记录页号
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PaginatedList<RoleManagerResult> findRoles(int pageIndex, int pageSize) {
        PaginatedList<RoleManagerResult> paginatedList;
        String ip = WebHelper.getRemoteIP() + "_" + WebHelper.getPin();
        //如果在当前页做编辑、删除等操作时会返为页号为0，这时仍然想显示在当前页上时，则需要判断当前页号是为是0；
        if (0 == pageIndex) {
            //在memcache中取出页号
            Integer pager = (Integer) cacheUtils.get(CategoryConstants.CMS_ROLEMANAGER_PAGER_CACHED + "_" + ip);
            //页号是否存在
            if (null != pager) {
                //设置页号
                pageIndex = pager;
            }
        }
        //查询角色信息列表
        paginatedList = roleManager.findRoles(pageIndex, pageSize);
        //角色信息列表是否存在和是否为第一页
        if (0 == paginatedList.size() && 1 < pageIndex) {
            //页号大于1，则当前页减1
            pageIndex = pageIndex - 1;
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ROLEMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
            //递归调用本方法
            paginatedList = findRoles(pageIndex, pageSize);
        } else {
            //将页号写入memcached
            cacheUtils.set(CategoryConstants.CMS_ROLEMANAGER_PAGER_CACHED + "_" + ip, CategoryConstants.CMS_EXPIRE_TIME, pageIndex);
        }
        //返回角色信息列表
        return paginatedList;
    }

    /**
     * 查询所有模块
     *
     * @return
     */
    public List<SupportModule> findModules() {
        return roleManager.findModules();
    }

    /**
     * 查询角色是否存在
     *
     * @param supportRole
     * @return
     */
    public SupportRole checkedRole(SupportRole supportRole) {
        return roleManager.checkedRole(supportRole);
    }

    /**
     * 添加角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int createRole(SupportRole supportRole, String moduleList) {
        return roleManager.createRole(supportRole, moduleList);
    }

    /**
     * 查询用户所属模块
     *
     * @param supportRole
     * @return
     */
    public List<SupportRoleModule> findRoleModules(SupportRole supportRole) {
        return roleManager.findRoleModules(supportRole);
    }

    /**
     * 修改角色
     *
     * @param supportRole
     * @param moduleList
     * @return
     */
    public int doModifiedRole(SupportRole supportRole, String moduleList) {
        return roleManager.doModifiedRole(supportRole, moduleList);
    }

    /**
     * 删除角色
     *
     * @param supportRole
     * @return
     */
    public int deleteRole(SupportRole supportRole) {
        return roleManager.deleteRole(supportRole);
    }

    public void setCacheUtils(CacheUtils cacheUtils) {
        this.cacheUtils = cacheUtils;
    }

    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }
}
