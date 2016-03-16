package com.redis.dc;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public interface Client {

    String getDesc();

    void destroy();

    //针对redis的各种基本数据结构的getter和setter实现方式不太一样，参数列表无法确定，所以不能这这个层面来确定规则
//    boolean set(String key, Object obj) throws Exception;

//    Object get(String key) throws Exception;
}
