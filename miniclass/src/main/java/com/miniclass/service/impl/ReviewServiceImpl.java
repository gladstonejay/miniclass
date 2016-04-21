package com.miniclass.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.miniclass.entity.QuestionAnswer;
import com.miniclass.dao.QuestionAnswerDao;
import com.miniclass.service.ReviewService;

import java.util.List;
/**
 * Created by shuaizhiguo on 2016/4/11.
 */

@Service
public class ReviewServiceImpl implements ReviewService{

    @Resource
    private QuestionAnswerDao userDao;

    public List<QuestionAnswer> getAllArticle(String type){

        return this.userDao.getAllArticle(type);
    }

    public QuestionAnswer getOneArticle(Integer id, String type){

        return this.userDao.getOneArticle(id,type);
    }
}
