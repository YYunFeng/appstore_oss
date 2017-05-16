package com.jd.cms.common.interceptor;

import com.jd.common.struts.context.LoginContext;
import com.jd.common.struts.interceptor.NewLoginContextInterceptor;
import com.jd.common.struts.interceptor.dotnet.DotnetAuthenticationUtil;
import com.jd.common.struts.interceptor.dotnet.FormsAuthenticationTicket;
import com.jd.digital.common.rpc.domain.web.JdAppLoginContext;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc:
 * User: chenbaoan@360buy.com
 * Date: 11-12-29
 * Time: 上午11:22
 */
public class JdAppStoreLoginContextInterceptor extends NewLoginContextInterceptor {
    private final static Log log = LogFactory.getLog(JdAppStoreLoginContextInterceptor.class);

    private static final long serialVersionUID = 4139448550703417383L;

    protected String dotnetAuthCookieName = "ceshi3.com";

    protected String dotnetAuthenticationKey;

    @Override
    protected JdAppLoginContext getLoginContext(String cookieValue) {
        return JdAppLoginContext.parse(cookieValue);
    }

    protected void updateLogin(HttpServletRequest request, HttpServletResponse response) {
        //判断是否配置了cookie的cookie名称
        if (loginCookieKey != null) {
            try {
                String value = cookieUtils.getCookieValue(request, loginCookieKey);
                if (StringUtils.isNotBlank(value)) {//能取到值
                    LoginContext context = getLoginContext(value);
                    if (context != null) {//又能解出来
                        long current = System.currentTimeMillis();
                        long created = context.getCreated();
                        long expires = context.getExpires();
                        long timeout = expires == 0 ? sessionTimeout * 1000 : expires - created;//如果没有设置过期时间，则使用默认的
                        if (current - created < timeout) { //如果没有过期
                            LoginContext.setLoginContext(context);
                            if ((current - created) * rate > timeout) {//如果剩下的时间只有2/3，就需要重新派发cookie
                                log.debug("session cookie[" + loginCookieKey + "] rewrite!");
                                //写最后一次访问的cookie
                                context.setCreated(current);
                                if (expires != 0) {
                                    context.setTimeout(timeout);
                                }
                                cookieUtils.setCookie(response, loginCookieKey, context.toCookieValue());
                            }
//                        } else if (expires == 0) {//如果没有设置过期时间。应该不能做特殊处理。否则就会兼容以前的。
//                           cookieUtils.setCookie(response, loginCookieKey, context.toCookieValue());
                        } else {
                            log.debug("session cookie[" + loginCookieKey + "] is valid!");
                            //超时后，要清空
                            cookieUtils.invalidate(request, response);
                        }
                    } else {
                        log.debug("session cookie[" + loginCookieKey + "] is error!");
                    }
                }
            } catch (Exception e) {
                log.error("login intercept error", e);
            }
        } else {
            log.debug("session cookie key is empty!");
        }

    }




    public void setDotnetAuthCookieName(String dotnetAuthCookieName) {
        this.dotnetAuthCookieName = dotnetAuthCookieName;
    }

    public void setDotnetAuthenticationKey(String dotnetAuthenticationKey) {
        this.dotnetAuthenticationKey = dotnetAuthenticationKey;
    }
}
