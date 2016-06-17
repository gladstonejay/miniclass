package com.miniclass.dao;

import com.miniclass.entity.UserBasic;
import com.miniclass.entity.UserRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBasicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBasic record);

    int insertSelective(UserBasic record);

    UserBasic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBasic record);

    int updateByPrimaryKey(UserBasic record);

    int selectUserId(String userId);

    int selectUserNname(String userNname);

    int selectUserPassword(String password);

    int selectUseBlackList(String userId);

    //获得用户的积分排名，20160617改成分为第三季度与第四季度两个季度
    public List<UserBasic> getUserRankByScore();

    public List<UserBasic> getUserRankByScoreAutumn();

    public List<UserBasic> getUserRankByScoreWinter();

    //给用户增加10分积分
    public int updateUserScore(String userId);

    public int updateUserScoreAutumn(String userId);

    public int updateUserScoreWinter(String userId);

    public int updateUserScoreSpring(String userId);

    public UserBasic getUserById(String userId);

}