package com.miniclass.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;


import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.code.kaptcha.servlet.KaptchaExtend;


import com.miniclass.vo.UserBasicVo;
import com.miniclass.entity.UserBasic;
import com.miniclass.service.UserBasicService;
import com.miniclass.vo.UserShowInfoVo;


/**
 * Created by shuaizhiguo on 2016/3/30.
 */

@Controller
@RequestMapping("/my")
public class MyController extends KaptchaExtend {

    private static final String CURRENT_USER = "user";
    private static final int LastTime = 60*10;
    private static Logger log = LoggerFactory.getLogger(MyController.class);
    @Resource
    private UserBasicService userBasicService;

    /**
     * 登录界面
     */
    @RequestMapping(value="/login")
    public ModelAndView login()  {

        ModelAndView model = new ModelAndView("/my/login");

        return model;
    }

    /**
     * 注册界面
     */
    @RequestMapping(value="/regist")
    public ModelAndView regist(){

        ModelAndView model = new ModelAndView("/my/regist");

        return model;
    }

    /**
     * 个人界面
     */
    @RequestMapping(value="/my")
    public ModelAndView my(HttpServletRequest request)  {

        ModelAndView model = new ModelAndView("/my/my");
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("user");
        UserBasic userBasic = null;
        userBasic = this.userBasicService.getUserById(userId);
        UserShowInfoVo userShowInfoVo = new UserShowInfoVo();
        Integer score = userBasic.getScore();
        userShowInfoVo.setCount( this.userBasicService.getUserRecordCount(userId));
        userShowInfoVo.setScore(score);
        userShowInfoVo.setLevel((score - score % 100) / 100 + 1);
        userShowInfoVo.setUserNickName(userBasic.getUserNname());
        userShowInfoVo.setUserType(userBasic.getUserType());

        model.addObject("userShowInfo",userShowInfoVo);
        return model;
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void captcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.captcha(req, resp);
    }

    /**
     * 验证码校验
     */
    @RequestMapping(value = "captchaCheck" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> captchaCheck(HttpServletRequest req ) throws ServletException , IOException {

        String code = req.getParameter("code");
        Integer a = 1;
        if (code.equals(getGeneratedKey(req))) {
            a=0;
        }
        Map<String, Integer> map = new HashMap<String,Integer>(1);
        map.put("success",a);

        return map;
    }

    /**
     * 登录验证
     */
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView loginPost( HttpServletRequest request){

        ModelAndView errorModel = new ModelAndView("my/login");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        Integer a = userBasicService.userIdExist(userId);
        if (a == 0){
            errorModel.addObject("errorId","电话号码不存在");
        }
        String newstr = new String();
        try {
            newstr = md5Encode(password);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        Integer b = userBasicService.userPasswordExist(newstr);
        if (b == 0 ){
            errorModel.addObject("errorNname","密码不正确");
        }
        if ( (a == 0) || (b==0) ){
            return errorModel;
        }
        else{

            UserBasic userBasic = new UserBasic();
            userBasic.setUserId(userId);
            HttpSession session = request.getSession();
            session.setAttribute(CURRENT_USER, userBasic.getUserId());
            session.setMaxInactiveInterval( LastTime );

            return new ModelAndView("redirect:/my/my.j");
        }

    }


    /**
     * 注册验证及插入数据
     */
    @RequestMapping(value = "/registCheck")
    public ModelAndView registerPost( UserBasicVo ubVo , HttpServletRequest request, HttpServletResponse response){

        ModelAndView errorModel = new ModelAndView("my/regist");

        Integer a = userBasicService.userIdExist(ubVo.getUserId());
        if (a == 1){
            errorModel.addObject("errorId","电话号码已存在");
        }
        Integer b = userBasicService.userNnameExist(ubVo.getUserNname());
        if (b == 1 ){
            errorModel.addObject("errorNname","昵称已存在");
        }
        if ( (a == 1) || (b==1) ){
            return errorModel;
        }
        else{
            String newstr = new String();
            try {
                newstr = md5Encode(ubVo.getPassword());
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            UserBasic userBasic = new UserBasic();
            userBasic.setUserId(ubVo.getUserId());
            userBasic.setUserNname((ubVo.getUserNname()));
            userBasic.setPassword(newstr);
            userBasic.setUserType("n");
            userBasic.setScore(0);
            userBasicService.insertNewUser(userBasic);

            /*
            Cookie cookie = new Cookie("userId", ubVo.getUserId());
            cookie.setMaxAge(LastTime);
            response.addCookie(cookie);
            log.info("cookie is "+ cookie );
            */

            HttpSession session = request.getSession();
            session.setAttribute(CURRENT_USER, userBasic.getUserId());
            session.setMaxInactiveInterval(LastTime);

            return new ModelAndView("redirect:/my/my.j");
        }

    }

    /**
     * MD5 生成函数
     */
    public static String md5Encode(String inStr) throws Exception {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}


