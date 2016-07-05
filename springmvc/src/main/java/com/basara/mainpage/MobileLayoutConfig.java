package com.basara.mainpage;

public class MobileLayoutConfig extends BaseMeta {

    /**
     * 主键ID
     */
    private long id;

    /**
     * 页面id: 1:首页，2:跨境首页，3:品类banner，4:推荐品牌，5:发现列表
     */
    private int pageId;

    /**
     * 版面顺序
     */
    private int layoutOrder;

    /**
     * 图标链接
     */
    private String icon;

    /**
     * 版面名称
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 标题栏高度，单位：像素
     */
    private String titleHigh;

    /**
     * 标题栏文字颜色，6位RGB值
     */
    private String titleColor;

    /**
     * 更多入口： 0：不显示；1：显示更多入口
     */
    private int showMore;

    /**
     * 状态：0：下线，1：上线
     */
    private int configStatus;

    /**
     * 档期开始时间
     */
    private long startTime;

    /**
     * 档期结束时间
     */
    private long endTime;

    /**
     * 更多链接
     */
    private String linkUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getLayoutOrder() {
        return layoutOrder;
    }

    public void setLayoutOrder(int layoutOrder) {
        this.layoutOrder = layoutOrder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getShowMore() {
        return showMore;
    }

    public void setShowMore(int showMore) {
        this.showMore = showMore;
    }

    public String getTitleHigh() {
        return titleHigh;
    }

    public void setTitleHigh(String titleHigh) {
        this.titleHigh = titleHigh;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public int getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(int configStatus) {
        this.configStatus = configStatus;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
