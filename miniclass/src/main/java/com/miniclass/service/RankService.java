package com.miniclass.service;

import com.miniclass.entity.UserBasic;
import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/11.
 */
public interface RankService {

    public List<UserBasic> getUserRankByScore();
    public List<UserBasic> getUserRankByScoreAutumn();
    public List<UserBasic> getUserRankByScoreWinter();
}
