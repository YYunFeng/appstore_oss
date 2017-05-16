package com.jd.cms.web.action.usermanager;

import com.jd.appstore.domain.PicResolutionEnum;
import com.jd.appstore.domain.SupportRole;
import com.jd.cms.service.usermanager.RoleService;
import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import org.apache.struts2.json.JSONUtil;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-7-6
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 * 角色管理
 */
public class RoleAction extends BaseAction {
    /**
     * 角色管理Service
     */
    private RoleService roleService;
    /**
     * 运营支撑系统角色表
     */
    private SupportRole supportRole;
    /**
     * 角色ID集合
     */
    private String moduleList;

    /**
     * 查询角色列表
     *
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        Result roles = roleService.findRoles(page, PAGE_SIZE);
        toVm(roles);
        return "list";
    }

    /**
     * 初始化角色添加页
     *
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
        Result modules = roleService.findModules();
        toVm(modules);
        return "add";
    }

    /**
     * 添加角色
     *
     * @return
     * @throws Exception
     */
    public String doAdd() throws Exception {
        roleService.createRole(supportRole, moduleList);
        return list();

    }

    /**
     * 查询角色是否存在
     *
     * @throws Exception
     */
    public void checkedRole() throws Exception {
        String msg;
        supportRole = roleService.checkedRole(supportRole);
        if (null == supportRole) {
            msg = "success";
        } else {
            msg = "error";
        }
        String json = JSONUtil.serialize(msg);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 初始化修改角色页
     *
     * @return
     * @throws Exception
     */
    public String modifiedRole() throws Exception {
        Result result = roleService.modifiedRole(supportRole);
        toVm(result);
        return "modified";
    }

    /**
     * 修改角色
     *
     * @return
     * @throws Exception
     */
    public String doModifiedRole() throws Exception {
        roleService.doModifiedRole(supportRole, moduleList);
        return list();
    }

    /**
     * 删除角色
     *
     * @return
     * @throws Exception
     */
    public String deleteRole() throws Exception {
        roleService.deleteRole(supportRole);
        return list();
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public SupportRole getSupportRole() {
        return supportRole;
    }

    public void setSupportRole(SupportRole supportRole) {
        this.supportRole = supportRole;
    }

    public String getModuleList() {
        return moduleList;
    }

    public void setModuleList(String moduleList) {
        this.moduleList = moduleList;
    }
}
