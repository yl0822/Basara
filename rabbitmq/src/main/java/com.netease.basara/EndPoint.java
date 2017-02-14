package com.netease.basara;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author:long.yl
 * @Date:2017/1/23
 * @Package:com.netease.basara
 * @Desc:抽象出连接对象
 */
public class EndPoint {
    private Connection connection;
    private Channel channel;
    private String endPointName;

    public EndPoint(String endPointName) throws IOException{
        this.endPointName = endPointName;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(endPointName, false, false, false, null);
    }

    public void close() throws IOException{
        this.channel.close();
        this.connection.close();
    }

    public static void set(){
        ThreadLocal<Long> num = new ThreadLocal<>();
        num.set(5L);
    }
}
