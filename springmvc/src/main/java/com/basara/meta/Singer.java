package com.basara.meta;

import java.io.Serializable;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public class Singer implements Serializable {
    private static final long serialVersionUID = -1822383005047359295L;
    private long id;
    private String name;
    private String nickName;
    private String introduce;
    private int tag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
