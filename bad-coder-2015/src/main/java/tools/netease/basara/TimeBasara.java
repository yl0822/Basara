package tools.netease.basara;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author long.yl.
 */
public class TimeBasara {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_MICROSECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");

    private TimeBasara() {
        //禁止实例化
        throw new AssertionError();
    }

    /**
     * 根据时间戳获取自定义类型时间
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * 根据时间戳获取默认日期时间类型
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取当前时间戳
     */
    public static long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前日期
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeStamp());
    }

    /**
     * 获取当前日期(带微妙 MicroSecond)
     */
    public static String getCurrentTimeInStringInMs() {
        return getTime(getCurrentTimeStamp(), DATE_FORMAT_MICROSECOND);
    }

    /**
     * 获取当前自定义类型日期
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {

        return getTime(getCurrentTimeStamp(), dateFormat);
    }
}
