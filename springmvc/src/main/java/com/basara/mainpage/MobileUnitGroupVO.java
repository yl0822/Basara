package com.basara.mainpage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hzlifangjian on 2016/6/17.
 */
public class MobileUnitGroupVO implements Serializable {

    private static final long serialVersionUID = 365527313563586404L;

    // 分组id
    private String id;

    // 图标链接
    private String icon;

    // 版面名称
    private String name;

    // 摘要
    private String summary;

    // 标题栏高度，单位：像素
    private Integer titleHigh;

    // 标题栏文字颜色，6位RGB值
    private String titleColor;

    // 0：不显示；1：显示更多入口
    private int showMore;

    //剩余时间
    private long countDownTime;

    //结束时间
    private long endTime;

    //1未开始，2在售，3过期
    private int poStatus;

    // 更多入口的内部跳转链接
    private String moreLink;

    // 单元列表
    private List<MobileUnitVO> unitList;

    // 是否有更多数据
    private boolean hasNext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getTitleHigh() {
        return titleHigh;
    }

    public void setTitleHigh(Integer titleHigh) {
        this.titleHigh = titleHigh;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public int getShowMore() {
        return showMore;
    }

    public void setShowMore(int showMore) {
        this.showMore = showMore;
    }

    public long getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(long countDownTime) {
        this.countDownTime = countDownTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(int poStatus) {
        this.poStatus = poStatus;
    }

    public String getMoreLink() {
        return moreLink;
    }

    public void setMoreLink(String moreLink) {
        this.moreLink = moreLink;
    }

    public List<MobileUnitVO> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<MobileUnitVO> unitList) {
        this.unitList = unitList;
    }

    /**
     * @return the hasNext
     */
    public boolean isHasNext() {
        return hasNext;
    }

    /**
     * @param hasNext the hasNext to set
     */
    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
