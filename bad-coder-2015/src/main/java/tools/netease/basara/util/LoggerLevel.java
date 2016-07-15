package tools.netease.basara.util;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public enum LoggerLevel {
    ALL(0, "全部信息"),
    INFO(1, "一般信息"),
    DEBUG(2, "调试信息"),
    ERROR(3, "错误信息");

    private int value;
    private String desc;

    private LoggerLevel(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
