package com.basara.meta;

import java.io.Serializable;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public class CloudSong implements Serializable {

    private static final long serialVersionUID = 1260621142721838402L;

    private long id;

    //歌手
    private long singerId;

    //歌名
    private String title;

    //时长
    private int duration;

    //歌词
    private String lyrics;

    //歌曲文件存放地址
    private String url;

    //标签
    private int tag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSingerId() {
        return singerId;
    }

    public void setSingerId(long singerId) {
        this.singerId = singerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
