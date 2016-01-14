package tools.netease.basara;

import tools.netease.basara.util.Constants;
import tools.netease.basara.util.LoggerLevel;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public class LoggerBasara {

    public static void info(Class clazz, String message, String... params){
        System.out.println(packMessage(clazz, LoggerLevel.INFO, message, params));
    }

    public static void debug(Class clazz, String message, String... params){
        System.out.println(packMessage(clazz, LoggerLevel.DEBUG, message, params));
    }

    public static void error(Class clazz, String message, String... params){
        System.out.println(packMessage(clazz, LoggerLevel.ERROR, message, params));
    }

    private static String packMessage(Class clazz, LoggerLevel level, String message, String... params){
        StringBuilder sb = new StringBuilder(clazz.getName());
        sb.append(Constants.LOGGER_SPLIT);
        String result = null;
        boolean isLevel = Constants.LOGGER_LEVEL == level || Constants.LOGGER_LEVEL == LoggerLevel.ALL;
        switch (level){
            case INFO:result = isLevel ? "INFO" : "";break;
            case DEBUG:result = isLevel ? "DEBUG" : "";break;
            case ERROR:result = isLevel ? "ERROR" : "";break;
            default:break;
        }
        if (StringBasara.isEmpty(result)){
            return "";
        }else {
            sb.append(result);
        }
        sb.append(Constants.LOGGER_SPLIT);
        sb.append(TimeBasara.getCurrentTimeInStringInMs());
        sb.append(Constants.LOGGER_SPLIT);
        for (String param : params) {
            message = message.replaceFirst("\\{\\}", param);
        }
        sb.append(message);
        return sb.toString();
    }
}
