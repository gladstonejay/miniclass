package com.miniclass.controller;

import com.miniclass.entity.UserBasic;

import javax.servlet.*;
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
        if (null != session)
            //user = (UserBasic) session.getAttribute("user");
            userId = (String)session.getAttribute("user");
        // url特殊处理：放行url
        if ( (url.contains("showOneClass.j") || url.endsWith("my.j") || url.contains("showOneTip.j") || url.contains("showOnePPT.j")) &&  null == userId ){
        //if ( url.endsWith("my.j")  &&  null == user ){

            //不满足条件就跳转到其他页面
            //String withdrawUrl = ResourceBundle.getBundle("config").getString("projectUrl");
            //res.sendRedirect(withdrawUrl);
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
