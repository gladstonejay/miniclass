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

    public List<UserBasic> getUserRankByScore();

    //给用户增加10分积分getAllVideo
    public int updateUserScore(String userId);

    public UserBasic getUserById(String userId);

}