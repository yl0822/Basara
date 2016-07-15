package com.basara.meta;

import java.io.Serializable;
import java.util.Date;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public class TextPost implements Serializable {

    private static final long serialVersionUID = -4129151681391522543L;

    private long id;

    private String title;

    private String content;

    private String authName;

    private Date createTime;

    private int tag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TextPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authName='" + authName + '\'' +
                ", createTime=" + createTime +
                ", tag=" + tag +
                '}';
    }
}
