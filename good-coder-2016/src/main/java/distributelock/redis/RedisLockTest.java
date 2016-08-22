package distributelock.redis;

/**
 * Created by long.yl
 * Created in 2016/8/19
 * Created on Basara_distributelock.redis
 */
public class RedisLockTest {
    public static void main(String[] args) {
        RedisLock lock = RedisLock.getInstance("abc");
        lock.lock();
        try {
            // todo
        } finally {
            lock.unlock();
        }
    }
}
