package com.miniclass.service.impl;

import javax.annotation.Resource;

import com.miniclass.dao.UserRecordDao;
import com.miniclass.entity.UserRecord;
import com.miniclass.entity.VideoInfo;
import org.springframework.stereotype.Service;
import com.miniclass.entity.UserBasic;
import com.miniclass.service.UserBasicService;
import com.miniclass.dao.UserBasicDao;
import com.miniclass.dao.VideoInfoDao;

import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/5.
 */

@Service
public class UserBasicServiceImpl implements UserBasicService{

    @Resource
    private UserBasicDao userDao;
    @Resource
    private VideoInfoDao videoInfoDao;
    @Resource
    private UserRecordDao userRecordDao;

    public UserBasic getUserById(int userId) {

        return this.userDao.selectByPrimaryKey(userId);
    }
    public int insertNewUser(UserBasic user){

        return this.userDao.insert(user);
    }
    public int userIdExist(String userId){

        return this.userDao.selectUserId(userId);
    }
    public int userNnameExist(String userNname){

        return this.userDao.selectUserNname(userNname);
    }
    public int userPasswordExist(String password){

        return this.userDao.selectUserPassword(password);
    }
    public List<VideoInfo> getAllVideo(){

        return this.videoInfoDao.selectAllVideo();
    }

    public VideoInfo getVideoById(int videoId)
    {
        return this.videoInfoDao.getVideoById(videoId);
    }

    public int insertUserRecord(UserRecord userRecord){

        return this.userRecordDao.insert(userRecord);
    }

    public int updateUserScore(String userId){

        return this.userDao.updateUserScore(userId);
    }

    public int isRecorded(UserRecord userRecord){

        return this.userRecordDao.isRecord(userRecord);
    }

    public int getUserRecordCount(String userId){

        return this.userRecordDao.getUserRecordCount(userId);
    }

    public UserBasic getUserById(String userId) {

        return this.userDao.getUserById(userId);
    }
}
