package com.miniclass.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.miniclass.entity.UserBasic;
import com.miniclass.dao.UserBasicDao;
import com.miniclass.service.RankService;

import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/11.
 */

@Service
public class RankServiceImpl implements RankService{

    @Resource
    private UserBasicDao userBasicDao;

    public List<UserBasic> getUserRankByScore()
    {
        return this.userBasicDao.getUserRankByScore();
    }

    public List<UserBasic> getUserRankByScoreAutumn()
    {
        return this.userBasicDao.getUserRankByScoreAutumn();
    }

    public List<UserBasic> getUserRankByScoreWinter()
    {
        return this.userBasicDao.getUserRankByScoreWinter();
    }

}
