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

    Integer selectUserId(String userId);

    Integer selectUserNname(String userNname);

    Integer selectUserPassword(String password);

    Integer selectUseBlackList(String userId);

    //获得用户的积分排名，20160617改成分为第三季度与第四季度两个季度
    public List<UserBasic> getUserRankByScore();

    public List<UserBasic> getUserRankByScoreAutumn();

    public List<UserBasic> getUserRankByScoreWinter();

    //给用户增加10分积分
    public Integer updateUserScore(String userId);

    public Integer updateUserScoreAutumn(String userId);

    public Integer updateUserScoreWinter(String userId);

    public Integer updateUserScoreSpring(String userId);

    public UserBasic getUserById(String userId);

}