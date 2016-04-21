package com.miniclass.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.miniclass.entity.UserBasic;
import com.miniclass.entity.UserRecord;
import com.miniclass.entity.VideoInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniclass.service.UserBasicService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/5.
 */

@Controller
@RequestMapping("/classLearn")
public class UserBasicController {

    private static Logger log = LoggerFactory.getLogger(UserBasicController.class);
    @Resource
    private UserBasicService userService;

    /**
     * 课程列表
     */
    @RequestMapping(value="/showUserClass")
    public ModelAndView showUserClass(){

        ModelAndView model = new ModelAndView("/classLearn/showUserClass");
        List<VideoInfo> videoInfoList = userService.getAllVideo();
        model.addObject("videoInfoList",videoInfoList);

        return model;
    }

    @RequestMapping(value="/showOneClass",method = RequestMethod.GET)
    public ModelAndView showOneClass(HttpServletRequest request)
    {
        ModelAndView model = new ModelAndView("/classLearn/showOneClass");
        int videoId = Integer.parseInt(request.getParameter("id"));
        VideoInfo videoInfo = this.userService.getVideoById(videoId);
        HttpSession session = request.getSession();
        String userId = new String();
        userId = (String)session.getAttribute("user");

        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(userId);
        userRecord.setMid(videoId);
        //type： video, weixin, ppt
        userRecord.setType("video");
        Integer count = this.userService.isRecorded(userRecord);
        if (count == 0){
            this.userService.insertUserRecord(userRecord);
            this.userService.updateUserScore(userId);
        }
        model.addObject("videoInfo",videoInfo);

        return model;
    }
}
