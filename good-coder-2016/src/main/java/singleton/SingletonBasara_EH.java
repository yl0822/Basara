package singleton;

/**
 * @author long.yl.
 * @Date 2016/6/1
 */
public class SingletonBasara_EH {
    /**
     * 饿汉式提前实例化，没有懒汉式中多线程问题，但不管我们是不是调用getInstance()都会存在一个实例在内存中
     */

    private static SingletonBasara_EH instance = new SingletonBasara_EH();

    private SingletonBasara_EH() {
    }

    public static SingletonBasara_EH getInstance() {
        return instance;
    }
}
