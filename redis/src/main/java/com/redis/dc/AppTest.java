package com.redis.dc;

import org.apache.commons.lang3.time.StopWatch;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by long.yl
 * Created in 2016/12/28
 * Created on Basara_com.redis.dc
 */
public class AppTest {
    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.currentThread().sleep(300);
        stopWatch.stop();
        System.out.println("cast time 1: " +stopWatch.getTime());
        Thread.currentThread().sleep(300);
        System.out.println("cast time 2: " +stopWatch.getTime());
        stopWatch.stop();
        System.out.println("cast time 3: " +stopWatch.getTime());
    }
}
