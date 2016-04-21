package com.miniclass.service;

import com.miniclass.entity.QuestionAnswer;
import java.util.List;

/**
 * Created by shuaizhiguo on 2016/4/11.
 */
public interface ReviewService {

    public List<QuestionAnswer> getAllArticle(String type);
    public QuestionAnswer getOneArticle(Integer id, String type);
}
