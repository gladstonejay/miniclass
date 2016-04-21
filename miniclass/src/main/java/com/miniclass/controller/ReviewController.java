package com.miniclass.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.miniclass.entity.QuestionAnswer;
import com.miniclass.entity.UserRecord;
import com.miniclass.service.ReviewService;
import com.miniclass.service.UserBasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/11.
 */

@Controller
@RequestMapping("/review")
public class ReviewController {

    private static Logger log = LoggerFactory.getLogger(ReviewController.class);
    @Resource
    private ReviewService reviewService;
    @Resource
    private UserBasicService userService;

    @RequestMapping(value="/showTips")
    public ModelAndView showTips(){

        ModelAndView model = new ModelAndView("/review/showTips");
        List<QuestionAnswer> resultWeixin = null;
        try{
            resultWeixin = reviewService.getAllArticle("weixin");
        } catch (Exception e)
        {
            log.error(e.getMessage());
        }
        List<QuestionAnswer> resultPPT = null;
        try{
            resultPPT = reviewService.getAllArticle("ppt");
        }catch (Exception e)
        {
            log.error(e.getMessage());
        }

        model.addObject("weixinList", resultWeixin);
        model.addObject("pptList", resultPPT);

        return model;
    }

    @RequestMapping(value = "showOneTip", method = RequestMethod.GET)
    public ModelAndView showOneTip(HttpServletRequest request)
    {
        Integer id =Integer.parseInt( request.getParameter("id"));
        QuestionAnswer weixin = null;
        String type = new String("weixin");
        weixin = this.reviewService.getOneArticle(id, type);

        ModelAndView modelAndView = new ModelAndView("/review/showOneTip");
        modelAndView.addObject("weixin",weixin);

        HttpSession session = request.getSession();
        String userId = new String();
        userId = (String)session.getAttribute("user");

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(id);
        //type： video, weixin, ppt
        userRecord.setType("weixin");
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
        }

        return modelAndView;
    }

    @RequestMapping(value = "showOnePPT", method = RequestMethod.GET)
    public ModelAndView showOnePPT(HttpServletRequest request)
    {
        Integer id =Integer.parseInt( request.getParameter("id"));
        QuestionAnswer ppt = null;
        String type = new String("ppt");
        ppt = this.reviewService.getOneArticle(id, type);

        ModelAndView modelAndView = new ModelAndView("/review/showOnePPT");
        modelAndView.addObject("ppt",ppt);

        HttpSession session = request.getSession();
        String userId = new String();
        userId = (String)session.getAttribute("user");

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(id);
        //type： video, weixin, ppt
        userRecord.setType("ppt");
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
        }

        return modelAndView;
    }
}
