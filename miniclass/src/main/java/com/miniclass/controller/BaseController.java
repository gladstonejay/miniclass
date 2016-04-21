package com.miniclass.controller;

import com.miniclass.entity.UserBasic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础controller
 * Created by shuaizhiguo on 2016/4/13.
 */
@Controller
@SuppressWarnings("all")
public class BaseController {
    private static final Logger dbLog = LoggerFactory.getLogger("dbLogger");

    protected static final String CURRENT_USER = "user";

    public UserBasic getCurrentUser() {
        if (null == getSession())
            return null;
        return (UserBasic) getSession().getAttribute(CURRENT_USER);
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }


}
