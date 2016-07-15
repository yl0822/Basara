package com.redis.dc.base;

import com.redis.dc.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
//@Configuration
public abstract class BaseClient implements Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseClient.class);

    //    @Autowired
    protected Jedis jedis;

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    protected BaseClient() {
        LOGGER.info("初始化Jedis...");
//        initBySpring();
        initWithoutSpring();
    }


    private void initBySpring() {
        jedis = new Jedis(host, port);
    }


    private void initWithoutSpring() {
        Properties properties;
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("redis.properties")) {
            properties = new Properties();
            properties.load(is);
            String host = properties.get("redis.host").toString();
            Integer port = Integer.valueOf(properties.get("redis.port").toString());
            jedis = new Jedis(host, port);
        } catch (Exception e) {
            LOGGER.error("初始化Jedis失败，原因:" + e.getMessage());
        }
    }

    protected void close() {
        LOGGER.info("关闭Jedis...");
        jedis.close();
    }
}
