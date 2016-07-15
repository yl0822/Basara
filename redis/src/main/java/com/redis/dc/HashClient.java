package com.redis.dc;

import com.redis.dc.base.BaseClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public class HashClient extends BaseClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashClient.class);


    @Override
    public String getDesc() {
        return new StringBuilder("Hash是一种数据结构，一般翻译做“散列”，也有直接音译为“哈希”。")
                .append("Redis  hash  是一个string类型的field和value的映射表。它特别适合用于存储对象。")
                .append("同将对象的每个字段存成单个string类型，存储为hash类型会占用更少的内存，并且方便的存")
                .append("取整个对象。").toString();
    }

    @Override
    public void destroy() {
        close();
    }

    /**
     * 添加或修改键值对
     */
    public
    @Override
    boolean set(String key, Object value) throws IllegalAccessException {
        Long result = null;
        for (Field field : value.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            result = jedis.hset(key, field.getName(), field.get(value).toString());
        }
        return (result != null && result > 0);
    }

    /**
     * 获取存储在指定的键散列字段的值
     */
    public
    @Override
    String get(String key, String field) {
        return jedis.hget(key, field);
    }


    /**
     * 返回 key 指定的哈希集中所有的字段和值。返回值中，每个字段名的下一个是它的值，所以返回值的长度是哈希集大小的两倍
     */
    public
    @Override
    Object get(String key, Class clazz) throws IllegalAccessException, InstantiationException {
        Map<String, String> data = jedis.hgetAll(key);
        Object result = null;
        if (data != null && data.size() >= 0) {
            result = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                int mod = field.getModifiers();
                //static和final必须在实例化的就完成初始化
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                if (field.getType().getSimpleName().equals(Long.class.getSimpleName())) {
                    field.set(result, Long.valueOf(data.get(field.getName())));
                } else if (field.getType().getSimpleName().equals(Integer.class.getSimpleName())) {
                    field.set(result, Integer.valueOf(data.get(field.getName())));
                } else {
                    field.set(result, data.get(field.getName()));
                }
            }
        }
        return result;
    }

    /**
     * 增加key指定的哈希集中指定字段的数值。如果key不存在，会创建一个新的哈希集并与key关联。
     * 如果字段不存在，则字段的值在该操作执行前被设置为0
     */
    public
    @Override
    long incr(String key, String field) {
        return jedis.hincrBy(key, field, 1l);
    }
}
