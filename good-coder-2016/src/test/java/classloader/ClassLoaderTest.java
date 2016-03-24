package classloader;

/**
 * @author long.yl.
 * @Date 2016/3/21
 */
public class ClassLoaderTest {
    public static void main(String[] args)throws Throwable{
        SubClassLoader classLoader = new SubClassLoader();
        classLoader.findClass("socket.SocketServer");

    }
}
