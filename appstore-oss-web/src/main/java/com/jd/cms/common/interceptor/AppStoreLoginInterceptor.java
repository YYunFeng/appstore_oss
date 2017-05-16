package com.jd.cms.common.interceptor;


import com.jd.common.struts.interceptor.JdInterceptor;
import com.jd.common.util.StringUtils;
import com.jd.common.web.security.FilePathSecurity;
import com.jd.common.web.url.JdUrlUtils;
import com.jd.digital.common.util.tool.WebHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 * appstore登录拦截器
 * Created by IntelliJ IDEA.
 * User: john
 * Date: 12-8-29
 * Time: 下午7:02
 * To change this template use File | Settings | File Templates.
 */
public class AppStoreLoginInterceptor extends JdInterceptor {
    private Logger logger = Logger.getLogger(this.getClass());


    private FilePathSecurity jdSecurity;

    public String intercept(ActionInvocation invocation) throws Exception {
        if (jdSecurity != null) {
            ActionContext actionContext = invocation.getInvocationContext();
            HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
            logger.info(request.getRequestURI());
            if (jdSecurity.isProtected(request.getRequestURI())) {
                String pin = WebHelper.getPin();
                if (StringUtils.isBlank(pin)) {
                   // 重定向到登录界面
                    return Action.LOGIN;
                }
            }
        }
        return invocation.invoke();
    }


    public void setJdSecurity(FilePathSecurity jdSecurity) {
        this.jdSecurity = jdSecurity;
    }

}
