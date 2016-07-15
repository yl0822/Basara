package com.basara.mainpage;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * 单元模块数据结构
 *
 * @author qujinuan
 */

@JsonInclude(Include.NON_NULL)
public class MobileUnitVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3069440877983738355L;

    // 单元Id
    private int unitId;

    // 宽高比
    private double ratio;

    // 单元内的分割线，0不显示；1显示
    private Integer itemDivider;

    // 单元下边缘线，0不显示，1显示
    private Integer unitDivider;

    // 单元内Item（坑位）直接的间距，单位：像素
    private Integer itemPadding;

    // 单元与页面间的左右间距，单位像素
    private Integer sidePadding;


    // 单元内容数据
    private JSONObject unitContent;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public Integer getItemDivider() {
        return itemDivider;
    }

    public void setItemDivider(Integer itemDivider) {
        this.itemDivider = itemDivider;
    }

    public Integer getUnitDivider() {
        return unitDivider;
    }

    public void setUnitDivider(Integer unitDivider) {
        this.unitDivider = unitDivider;
    }

    public Integer getItemPadding() {
        return itemPadding;
    }

    public void setItemPadding(Integer itemPadding) {
        this.itemPadding = itemPadding;
    }

    public Integer getSidePadding() {
        return sidePadding;
    }

    public void setSidePadding(Integer sidePadding) {
        this.sidePadding = sidePadding;
    }

    public JSONObject getUnitContent() {
        return unitContent;
    }

    public void setUnitContent(JSONObject unitContent) {
        this.unitContent = unitContent;
    }
}
