package mode.neteas.basara;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public abstract class SingletonBasara<T> {

    //单例化对象私有
    //这里采用泛型来实现单例，比直接在类创建层面上就添加单例属性的可扩展和通用性更好
    private T instance;

    //本方法由单例化对象实现
    protected abstract T newInstance();

    /**
     * 本方法作为获取单例对象的入口
     * public final T getInstance() {
     * if (instance == null) {
     * instance = newInstance();
     * }
     * ｝
     * 那么如果这个入口为什么不用上面这种实现，而用下面的实现
     * 1.第一次判断instance是否为null后，有可能出现多线程冲突情况，不能完全保证单例性，所以之后加了个锁操作来保证单例。
     * 2.为什么要加上第二次判断，或者说为什么要加第一个判断，是为了效率考虑，因为上述的多线程冲突情况只会出现在首次单例生成的时候
     * 3.如果去除第一次判断，那么该入口每次调用都会执行加锁操作，是非常影响效率的，所以有必要加上第一次的判断
     * 4.又忘记了，:-(。我也不清楚这次能不能完成使命，还是等OK了再考虑其他
     * 5.校招笔试-》简历不通过2次-》电一面完全没通过-》简历不通过2次-》电一面可惜没通过-》电二面等待结果。
     * 6.回头看起来好曲折啊
     */
    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonBasara.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
