package com.miniclass.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.miniclass.entity.UserBasic;
import com.miniclass.entity.UserRecord;
import com.miniclass.entity.VideoInfo;
import com.miniclass.vo.VideoInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miniclass.service.UserBasicService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
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
     * 本月课程列表
     */
    @RequestMapping(value="/showUserClass")
    public ModelAndView showUserClass(HttpServletRequest request){

        ModelAndView model = new ModelAndView("/classLearn/showUserClass");
        List<VideoInfo> videoInfoList = userService.getAllVideo();
        List<VideoInfoVo> videoInfoVos = new ArrayList<VideoInfoVo>();
        VideoInfoVo videoInfoVo = null;
        for (VideoInfo videoInfo : videoInfoList) {
            videoInfoVo = new VideoInfoVo(videoInfo);
            videoInfoVos.add(videoInfoVo);
        }
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("user");

        /*
        if (userId != null) {
            List<UserRecord> userRecords = userService.getUserDoneClassRecord(userId);
            if ( userRecords.size() > 0) {
                for (VideoInfo videoInfo : videoInfoList) {
                    videoInfoVo = new VideoInfoVo(videoInfo);
                    videoInfoVos.add(videoInfoVo);
                }
            }
        }
        */
        model.addObject("videoInfoList", videoInfoVos);

        return model;
    }

    /**
     * 历史课程列表
     */
    @RequestMapping(value="/showHistory")
    public ModelAndView showHistory(HttpServletRequest request){

        ModelAndView model = new ModelAndView("/classLearn/showHistory");
        List<VideoInfo> videoInfoList = userService.getAllDoneVideo();
        List<VideoInfoVo> videoInfoVos = new ArrayList<VideoInfoVo>();
        VideoInfoVo videoInfoVo = null;
        for (VideoInfo videoInfo : videoInfoList) {
            videoInfoVo = new VideoInfoVo(videoInfo);
            videoInfoVos.add(videoInfoVo);
        }
        HttpSession session = request.getSession();
        String userId = (String)session.getAttribute("user");

        model.addObject("videoInfoList", videoInfoVos);

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
        //type： video, weixin, ppt,exam
        userRecord.setType("video");
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
        model.addObject("videoInfo",videoInfo);

        return model;
    }
}
