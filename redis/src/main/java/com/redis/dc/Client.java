package com.redis.dc;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public interface Client {

    String getDesc();

    void destroy();

    boolean set(String str, Object obj) throws Exception;

    String get(String str1, String str2) throws Exception;

    Object get(String str, Class clazz) throws Exception;

    long incr(String str1, String str2) throws Exception;

}
