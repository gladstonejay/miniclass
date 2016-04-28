package com.miniclass.vo;


/**
 * Created by shuaizhiguo on 2016/4/15.
 */
public class UserShowInfoVo extends Vo{

    private Integer count;

    private Integer score;

    private Integer level ;

    private String userNickName;

    private String userType;

    private Integer examCount;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLevel() { return level;}

    public void setLevel(Integer level) {this.level = level;}

    public String getUserNickName(){ return userNickName;}

    public void setUserNickName(String userNickName){

        this.userNickName = userNickName;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }
    public String getUserType(){ return userType;}

    public void setExamCount(Integer examCount) { this.examCount = examCount;}

    public Integer getExamCount(){ return examCount;}
}
