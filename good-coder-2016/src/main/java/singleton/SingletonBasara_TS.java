package singleton;

import org.apache.http.annotation.ThreadSafe;

/**
 * @author long.yl.
 * @Date 2016/6/1
 */

@ThreadSafe
public class SingletonBasara_TS {

    /**
     * 直接将整个方法设定为原子操作，解决了线程安全问题，但是可以有效率更高的办法
     * */
    private static SingletonBasara_TS instance;

    private SingletonBasara_TS(){
    }

    public synchronized static SingletonBasara_TS getInstance(){
        if (instance == null){
            instance = new SingletonBasara_TS();
        }
        return instance;
    }
}
