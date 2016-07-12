package com.redis.dc;

import com.google.common.collect.Maps;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by long.yl on 2016/7/12.
 */
public class RedisLock implements Lock {

    private Jedis jedis;

    private String key;

    private static final int timeout = 30000;

    private static final String LOCKED = "TURE";

    private static final int expire = 30;

    private volatile boolean locked = false;

    private static ConcurrentMap<String, RedisLock> map = Maps.newConcurrentMap();

    public RedisLock(String key) {
        this.key = "_LOCK_" + key;
        jedis = new Jedis();
    }

    public static void main(String[] args) {
        RedisLock lock = RedisLock.getInstance("abc");
        lock.lock();
        try {
            // todo
        }finally {
            lock.unlock();
        }
    }

    public static RedisLock getInstance(String key) {
        RedisLock lock = null;
        synchronized (RedisLock.class){
            lock = map.get(key);
            if (lock == null){
                lock = new RedisLock(key);
            }
            return lock;
        }
    }

    public void lock(long timeout){
        long nano = System.nanoTime();
        timeout *= 1000000;
        final Random r = new Random();
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (jedis.setnx(key.getBytes(), LOCKED.getBytes()) > 0){
                    jedis.expire(key, expire);
                    locked = true;
                    System.out.println("add RedisLock[" + key + "].");
                    break;
                }
                Thread.sleep(3, r.nextInt(500));
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void lock() {
        lock(timeout);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if (locked) {
            System.out.println("release RedisLock[" + key + "].");
            jedis.del(key);
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
