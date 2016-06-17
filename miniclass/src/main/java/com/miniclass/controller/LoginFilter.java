package com.miniclass.controller;

import com.miniclass.service.UserBasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 * Created by shuaizhiguo on 2016/4/13.
 */
public class LoginFilter extends BaseController implements Filter{

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
    public LoginFilter(){
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 获得请求的URL
        String url = req.getRequestURL().toString();
        // 获得session中的对象
        String userId = new String();
        HttpSession session = req.getSession();
        if (null != session){
            userId = (String)session.getAttribute("user");
        }
        Integer status = 0;


        // url特殊处理：不放行url
        if ( (url.contains("showOneClass.j") || url.endsWith("my.j") || url.contains("showOneTip.j") || url.contains("showOnePPT.j") || url.contains("showOneExam.j")) &&  (null == userId) ){

            res.sendRedirect("/my/login.j");
        }
        else {
            // 满足条件就继续执行
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
