import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * @author long.yl.
 * @Date 2016/3/14
 */
public class BootStrap {
    public static void main(String[] args)throws Throwable{
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.lset("total", 1, "32");
        jedis.lset("total", 2, "22");
        jedis.lset("total", 3, "32456");
        jedis.lset("total", 4, "432");
        jedis.lset("total", 5, "100");
//        jedis.sort("total");
        System.out.println(jedis.lpop("total"));
        jedis.close();
    }
}