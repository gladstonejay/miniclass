package com.miniclass.service.impl;

import javax.annotation.Resource;

import com.miniclass.dao.ExamDao;
import com.miniclass.entity.Exam;
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
    @Resource
    private ExamDao examDao;

    public List<QuestionAnswer> getAllArticle(String type){

        return this.userDao.getAllArticle(type);
    }

    public QuestionAnswer getOneArticle(Integer id, String type){

        return this.userDao.getOneArticle(id,type);
    }
    public List<Exam> getAllExam(){

        return this.examDao.getAllExam();
    }

    public List<Exam> getOneExam(Integer id){

        return this.examDao.getOneExam(id);
    }

    public Exam getOneExamContext(Integer order_id , Integer item_id){

        return this.examDao.getOneExamContext(order_id, item_id);
    }
}
