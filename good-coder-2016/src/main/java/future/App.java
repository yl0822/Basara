package future;

/**
 * @author long.yl.
 * @Date 2016/6/3
 */
public class App {

    public App() {

    }

    public static void main(String[] args) throws Exception {
        Thread.currentThread().getContextClassLoader().loadClass("java.lang.String");
    }

    public void App() {

    }

    static class 罪犯 {
        public 罪犯() {

        }

        public static void 不许动() {
            System.out.println("继续跑");
        }
    }
}
