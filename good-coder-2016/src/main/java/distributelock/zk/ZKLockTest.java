package distributelock.zk;

/**
 * Created by long.yl
 * Created in 2016/8/19
 * Created on Basara_distributelock.zk
 */
public class ZKLockTest {
    public static void main(String[] args) throws Exception {
        ZKLock lock = new ZKLock("", 3000, "");
        lock.tryLock();
        try {
            // todo
        } finally {
//            lock.unlock();
        }
    }
}
