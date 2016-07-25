package com.miniclass.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * 登录过滤器
 * Created by shuaizhiguo on 2016/4/13.
 */
public class LoginFilter extends BaseController implements Filter{

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
    private static final String CURRENT_USER =  ResourceBundle.getBundle("config").getString("cookie_user_name");
    private static final int LastTime = Integer.parseInt(ResourceBundle.getBundle("config").getString("cookie_last_time"));
    public LoginFilter(){
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        // 获得请求的URL
        String url = request.getRequestURL().toString();
        // 获得session中的对象
        String userId = (String)session.getAttribute(CURRENT_USER);
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (CURRENT_USER.equals(cookie.getName())) {
                    log.info("------------刚进入过滤器，获取到的用户名应该为空" + userId);
                    userId = cookie.getValue();
                    log.info("------------从cookie中拿到用户名，获取到的Userld为" + userId);
                    session.setAttribute(CURRENT_USER, userId);
                    session.setMaxInactiveInterval( LastTime );
                    log.info("------------打session，从sessino中过去用户名" + session.getAttribute(CURRENT_USER));
                }
            }
        }
        log.info("-------------filter---------------userid is " + userId);
        // url特殊处理：不放行url
        if ( (url.contains("showOneClass.j") || url.endsWith("my.j") || url.contains("showOneTip.j") || url.contains("showOnePPT.j") || url.contains("showOneExam.j")) &&  (null == userId) ){

            response.sendRedirect("/my/login.j");
        }
        else {
            // 满足条件就继续执行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
