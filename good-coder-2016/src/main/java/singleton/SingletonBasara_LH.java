package singleton;

/**
 * @author long.yl.
 * @Date 2016/6/1
 */
public class SingletonBasara_LH {
    /**
     * 在懒汉式中，实现了延迟加载(使用的时候才会开始实例化)
     * 但是出现了线程安全问题，也就是存在`读取-判断-操作`的竞态条件。
     */

    private static SingletonBasara_LH instance;

    private SingletonBasara_LH() {
    }

    public static SingletonBasara_LH getInstance() {
        if (instance == null) {
            instance = new SingletonBasara_LH();
        }
        return instance;
    }
}
