package com.miniclass.dao;

import com.miniclass.entity.VideoInfo;

import java.util.List;

public interface VideoInfoDao {

    int deleteByPrimaryKey(Integer id);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    VideoInfo selectByPrimaryKey(Integer id);

    List<VideoInfo> selectAllVideo();

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);

    VideoInfo getVideoById(Integer videoId);
}