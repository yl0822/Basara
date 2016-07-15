package com.basara.mainpage.unit.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * 图文单元的纯图片坑位
 */
@JsonInclude(Include.NON_NULL)
public class MobileSingleImageItemVO implements Serializable {

    private static final long serialVersionUID = 2214723050002899357L;

    // id
    private String id;

    // 图片链接
    private String imgUrl;

    // 跳转链接
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

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
