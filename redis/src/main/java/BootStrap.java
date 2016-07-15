import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long.yl.
 * @Date 2016/3/14
 */
public class BootStrap {
    public static void main(String[] args) throws Throwable {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext-redis.xml"});
        context.start();
        //为保证服务一直开启，利用输入流的阻塞来模拟
        System.out.println("dubbo服务启动中...");
        System.in.read();
        System.out.println("dubbo服务启动关闭...");
    }
}