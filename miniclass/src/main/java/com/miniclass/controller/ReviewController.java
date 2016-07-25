package com.miniclass.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by shuaizhiguo on 2016/4/11.
 */

@Controller
@RequestMapping("/review")
public class ReviewController {

    private static Logger log = LoggerFactory.getLogger(ReviewController.class);
    private static final String CURRENT_USER =  ResourceBundle.getBundle("config").getString("cookie_user_name");
    private static final int LastTime = Integer.parseInt(ResourceBundle.getBundle("config").getString("cookie_last_time"));
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

    /**
     * 答疑学习
     * @param request
     * @return
     */
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
        String userId1 = new String();
        userId1 = (String)session.getAttribute(CURRENT_USER);
        //String userId = this.GetUserIdByCookie(request);
        String userId2 = this.GetUserIdByCookie(request);
        log.info("----------------通过cookie获取的用户名字是：" + userId2);

        String userId = null;
        if( userId1.length() == 11){
            userId = userId1;
        }
        else {
            userId = userId2;
        }
        log.info("---------------最终的用户名字是：" + userId);

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(id);
        //type： video, weixin, ppt,exam
        userRecord.setType("weixin");
        userRecord.setScore(0);
        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        userRecord.setMonth(month);
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
            if(month == 6 || month == 7 ||  month == 8 ||month == 9){
                this.userService.updateUserScoreAutumn(userId);
            } else if(month == 10 ||  month == 11 ||month == 12){
                this.userService.updateUserScoreWinter(userId);
            }else{
                this.userService.updateUserScoreSpring(userId);
            }
        }

        return modelAndView;
    }

    /**
     * 课件学习
     * @param request
     * @return
     */
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
        String userId1 = new String();
        userId1 = (String)session.getAttribute(CURRENT_USER);
        //String userId = this.GetUserIdByCookie(request);
        String userId2 = this.GetUserIdByCookie(request);
        log.info("----------------通过cookie获取的用户名字是：" + userId2);

        String userId = null;
        if( userId1.length() == 11){
            userId = userId1;
        }
        else {
            userId = userId2;
        }
        log.info("---------------最终的用户名字是：" + userId);

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(id);
        //type： video, weixin, ppt,exam
        userRecord.setType("ppt");
        userRecord.setScore(0);
        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        userRecord.setMonth(month);
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
            if(month == 6 || month == 7 ||  month == 8 ||month == 9){
                this.userService.updateUserScoreAutumn(userId);
            } else if(month == 10 ||  month == 11 ||month == 12){
                this.userService.updateUserScoreWinter(userId);
            }else{
                this.userService.updateUserScoreSpring(userId);
            }
        }

        return modelAndView;
    }

    /**
     * 展示考试
     * @param request
     * @return
     */
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

    /**
     * 处理考试结果
     * @param request
     * @return
     */
    @RequestMapping(value = "examResult", method = RequestMethod.POST)
    public ModelAndView examResult(HttpServletRequest request)
    {

        Integer id =Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("/review/examResult");

        String[] userArray = new String[]{"E","E","E","E","E"};
        List<String> answerList = new ArrayList();
        List<String> checkArray = new ArrayList();
        String right = new String("恭喜你，全部答对，获得100分");
        String wrong = new String("抱歉，");
        for (int i = 0; i<5 ; i++) {
            String ident = "picker" + (i+1);
            if ( request.getParameter(ident) != "" ) {
                userArray[i] = request.getParameter(ident);
            }
        }

        List<Exam> answer = this.reviewService.getOneExam(id);
        for(Exam exam:answer){
            answerList.add(exam.getAnswer());
        }
        String[] answerArray = answerList.toArray(new String[5]);

        int score = 0;
        for(int i=0; i<5 ; i++){
            if (userArray[i].equals(answerArray[i]))
            {
                score += 20;
            }
            else{
                checkArray.add(Integer.toString(i+1));
            }
        }

        if (score != 100 ) {

            wrong +=  "您的得分最后为 :" + score + "," ;
            for (String tmp : checkArray) {

                Exam exam = this.reviewService.getOneExamContext(id, Integer.parseInt(tmp));
                wrong += "<br>其中第" + tmp + "题" + exam.getContext() + "的答案为 ：<br>" + exam.getAnswerContext() + "; ";
            }
            modelAndView.addObject("result",wrong);
        }
        else {
            modelAndView.addObject("result", right);
        }

        HttpSession session = request.getSession();
        String userId1 = new String();
        userId1 = (String)session.getAttribute(CURRENT_USER);
        //String userId = this.GetUserIdByCookie(request);
        String userId2 = this.GetUserIdByCookie(request);
        log.info("----------------通过cookie获取的用户名字是：" + userId2);

        String userId = null;
        if( userId1.length() == 11){
            userId = userId1;
        }
        else {
            userId = userId2;
        }
        log.info("---------------最终的用户名字是：" + userId);

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(id);
        //type： video, weixin, ppt,exam
        userRecord.setType("exam");
        userRecord.setScore(score);
        Calendar cal = Calendar.getInstance();
        Integer month = cal.get(Calendar.MONTH) + 1;
        userRecord.setMonth(month);
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
            if(month == 6 || month == 7 ||  month == 8 ||month == 9){
                this.userService.updateUserScoreAutumn(userId);
            } else if(month == 10 ||  month == 11 ||month == 12){
                this.userService.updateUserScoreWinter(userId);
            }else{
                this.userService.updateUserScoreSpring(userId);
            }
        }

        return modelAndView;
    }

    /**
     * 从cookie中获取用户名
     * @param request
     * @return
     */
    public String GetUserIdByCookie(HttpServletRequest request){


        log.info("------------学习-------------");
        String userId = new String();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (CURRENT_USER.equals(cookie.getName())) {
                userId = cookie.getValue();
            }
        }
        log.info("------------学习页面用户" + userId);

        return userId;
    }

}
