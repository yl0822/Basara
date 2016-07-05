package com.basara.mainpage;

public class MobileUnitConfig extends BaseMeta {

    /**
     * 主键ID
     */
    private long id;

    /**
     * 版面id
     */
    private long layoutId;

    /**
     * 单元类型
     */
    private int unitType;

    /**
     * 单元顺序
     */
    private int unitOrder;

    /**
     * 图片比例
     */
    private String ratio;

    /**
     * 单元内的分割线，0不显示；1显示
     */
    private int itemDivider;

    /**
     * 单元内下边缘线，0不显示；1显示
     */
    private int unitDivider;

    /**
     * 单元内Item（坑位）直接的间距，单位：像素
     */
    private String itemPadding;

    /**
     * 单元与页面间的左右间距，单位像素
     */
    private String sidePadding;

    /**
     * 状态 0：已下线，1：发布中
     */
    private int configStatus;

    /**
     * 模板数据
     */
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(long layoutId) {
        this.layoutId = layoutId;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getUnitOrder() {
        return unitOrder;
    }

    public void setUnitOrder(int unitOrder) {
        this.unitOrder = unitOrder;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getItemDivider() {
        return itemDivider;
    }

    public void setItemDivider(int itemDivider) {
        this.itemDivider = itemDivider;
    }

    public int getUnitDivider() {
        return unitDivider;
    }

    public void setUnitDivider(int unitDivider) {
        this.unitDivider = unitDivider;
    }

    public String getItemPadding() {
        return itemPadding;
    }

    public void setItemPadding(String itemPadding) {
        this.itemPadding = itemPadding;
    }

    public String getSidePadding() {
        return sidePadding;
    }

    public void setSidePadding(String sidePadding) {
        this.sidePadding = sidePadding;
    }

    public int getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(int configStatus) {
        this.configStatus = configStatus;
    }
}
