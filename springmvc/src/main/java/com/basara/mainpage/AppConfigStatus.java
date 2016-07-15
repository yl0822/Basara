package com.basara.mainpage;

public enum AppConfigStatus {

    /**
     *
     */
    NULL(-1, "未知"),
    /**
     * 未发布
     */
    SAVED(0, "未发布"),
    /**
     * 已发布
     */
    PUBLISHED(1, "已发布"),
    /**
     * 已删除
     */
    DELETED(2, "已删除");

    /**
     * 值
     */
    private final int value;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 构造函数
     */
    private AppConfigStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getIntValue() {
        return value;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
}
