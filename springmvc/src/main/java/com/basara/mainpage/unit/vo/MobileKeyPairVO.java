package com.basara.mainpage.unit.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
public class MobileKeyPairVO implements Serializable {

    private static final long serialVersionUID = 7803477082604287969L;

    // id(通用，所以对应String)
    private String id;

    // 名称,对应描述
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
