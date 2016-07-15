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
    public int useBlackList(String userId){

        System.out.println("-------------service impl heimingdan " + userId);
        return this.userDao.selectUseBlackList(userId);
    }
    public List<VideoInfo> getAllVideo(){

        return this.videoInfoDao.selectAllVideo();
    }

    public List<VideoInfo> getAllDoneVideo(){

        return this.videoInfoDao.selectAllDoneVideo();
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

    public int updateUserScoreAutumn(String userId){

        return this.userDao.updateUserScoreAutumn(userId);
    }

    public int updateUserScoreWinter(String userId){

        return this.userDao.updateUserScoreWinter(userId);
    }

    public int updateUserScoreSpring(String userId){

        return this.userDao.updateUserScoreSpring(userId);
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

    public List<UserRecord> getUserDoneClassRecord(String userId){

        return this.userRecordDao.getUserDoneClassRecord(userId);
    }

    public int getUserExamCount(String userId){

        return this.userRecordDao.getUserExamCount(userId);
    }
}
