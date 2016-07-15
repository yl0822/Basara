package singleton;

import org.apache.http.annotation.ThreadSafe;

/**
 * @author long.yl.
 * @Date 2016/6/1
 */
@ThreadSafe
public class SingletonBasara_DC {
    /**
     * 只需要同步（synchronize）初始化instance的那部分代码从而使代码既正确又很有效率。
     * 这就是所谓的“双检锁”机制
     */
    private static SingletonBasara_DC instance;

    private SingletonBasara_DC() {
    }

    public static SingletonBasara_DC getInstance() {
        if (instance == null) {
            synchronized (SingletonBasara_DC.class) {
                if (instance == null) {
                    instance = new SingletonBasara_DC();
                }
            }
        }
        return instance;
    }
}
