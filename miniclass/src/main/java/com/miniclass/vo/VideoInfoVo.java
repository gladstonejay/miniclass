package com.miniclass.vo;

import com.miniclass.entity.VideoInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rrd on 2016/4/22.
 */

public class VideoInfoVo  extends Vo  {

    private Integer id;

    private Integer orderId;

    private String title;

    private String videoId;

    private String type;

    private String summary;

    private String timestamp;

    private Integer userDone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserDone() {return userDone;}

    public void setUserDone(Integer userDone ) { this.userDone = userDone;}

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public VideoInfoVo(VideoInfo info){
        this.setId(info.getId());
        this.setOrderId(info.getOrderId());
        this.setSummary(info.getSummary());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String dateString = format.format(info.getTimestamp());
        this.setTimestamp(dateString);
        this.setTitle(info.getTitle());
        this.setVideoId(info.getVideoId());
        this.setType(info.getType());
    }
}
