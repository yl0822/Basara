package other;

/**
 * @author long.yl.
 * @Date 2016/3/18
 */
public class StaticTest {
    static {
        System.out.println("静态块被执行了");
    }

    public StaticTest() {
        System.out.println("staticTest被初始化了");
    }

    public static void main(String[] args) throws Throwable {
//        Class.forName("other.StaticTest");
        StaticTest test = new StaticTest();
    }
}
