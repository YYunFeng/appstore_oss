package com.jd.cms.common.interceptor;

import com.jd.cms.dao.login.LoginDao;
import com.jd.cms.domain.usermanager.PowerQuery;
import com.jd.cms.service.login.LoginService;
import com.jd.common.web.cookie.CookieUtils;
import com.jd.digital.common.util.tool.WebHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: LiangYu
 * Date: 12-9-3
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
public class PowerInterceptor extends MethodFilterInterceptor implements Interceptor {
    /**
     * 登录Service
     */
    private LoginService loginService;
    /**
     * cookie工具类
     */
    protected CookieUtils cookieUtils;
    private final static Log log = LogFactory.getLog(PowerInterceptor.class);

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获取request
        ActionContext context = actionInvocation.getInvocationContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);

        //获取请求的路径
        String path = httpServletRequest.getRequestURI();
        //获取cookie值
        String cookieValue = WebHelper.getPin();
        //是否为欢迎页Action
        if (path.equals("/login/init.action")) {
            //正常处理
            return actionInvocation.invoke();
        } else {
            try {
                //根据用户名和ActionUrl查询是否有此权限
                PowerQuery powerResult = loginService.findSupportUserModule(cookieValue, path);
                //权限是否存在
                if (null == powerResult) {
                    //返回无权限页
                    return Action.NONE;
                }
            } catch (Exception ex) {
                log.error("权限拦截器 error", ex);
                throw new RuntimeException("Interceptor error!", ex);
            }
        }
        //正常处理
        return actionInvocation.invoke();
    }

    public void setCookieUtils(CookieUtils cookieUtils) {
        this.cookieUtils = cookieUtils;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
