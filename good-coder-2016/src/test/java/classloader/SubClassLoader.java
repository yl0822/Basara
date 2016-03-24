package classloader;

/**
 * @author long.yl.
 * @Date 2016/3/21
 */
public class SubClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
