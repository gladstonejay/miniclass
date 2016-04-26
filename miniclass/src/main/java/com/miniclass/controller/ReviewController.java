package com.miniclass.controller;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.miniclass.entity.Exam;
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

import java.util.ArrayList;
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
        List<Exam> resultExam = null;
        try{
            resultExam = reviewService.getAllExam();
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
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

        model.addObject("examList", resultExam);
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
        userRecord.setScore(0);
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
        //type： video, weixin, ppt,exam
        userRecord.setType("ppt");
        userRecord.setScore(0);
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
        }

        return modelAndView;
    }

    @RequestMapping(value = "showOneExam", method = RequestMethod.GET)
    public ModelAndView showOneExam(HttpServletRequest request)
    {

        Integer id =Integer.parseInt( request.getParameter("id"));
        List<Exam> exam = this.reviewService.getOneExam(id);

        ModelAndView modelAndView = new ModelAndView("/review/showOneExam");
        modelAndView.addObject("exam", exam);
        modelAndView.addObject("id", id);

        return modelAndView;
    }

    @RequestMapping(value = "examResult", method = RequestMethod.POST)
    public ModelAndView examResult(HttpServletRequest request)
    {

        Integer id =Integer.parseInt(request.getParameter("id"));

        String[] userArray = new String[]{"E","E","E","E","E"};
        List<String> answerList = new ArrayList();
        String[] checkArray = new String[5];
        String right = new String("恭喜你，全部答对，获得100分");
        String wrong = new String("抱歉，");
        for (int i = 0; i<5 ; i++)
        {
            String ident = "picker" + (i+1);
            if ( request.getParameter(ident) != "" ) {
                userArray[i] = request.getParameter(ident);
            }
            log.info("userArray is " + userArray[i]);
        }

        List<Exam> answer = this.reviewService.getOneExam(id);
        for(Exam exam:answer){
            answerList.add(exam.getAnswer());
        }
        String[] answerArray = answerList.toArray(new String[5]);
        for (int i = 0; i<5 ; i++)
        {
            log.info("answerArray is " + answerArray[i]);
        }


        ModelAndView modelAndView = new ModelAndView("/review/examResult");


        //modelAndView.addObject("a",a);

        return modelAndView;
    }

}
