package com.basara.mainpage.unit.vo;

import java.io.Serializable;

public class MobileSingleImageTextItemVO implements Serializable {

    private static final long serialVersionUID = 9062643510002909167L;
    // 对应的id
    private String id;

    // 图片url
    private String imgUrl;

    // 文字1
    private String text1;

    // 文字2
    private String text2;

    // APP内部跳转URL
    private String linkUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
