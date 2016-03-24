import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long.yl.
 * @Date 2016/3/11
 */
//@ImportResource({"classpath:config/contentProvider.xml"} )
//@Configuration
//@ComponentScan
//@ContextConfiguration(locations = {"classpath:applicationContext-dubbo.xml"})
public class Provider {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String []{"classpath:applicationContext-dubbo.xml"});
        context.start();
        //为保证服务一直开启，利用输入流的阻塞来模拟
        System.out.println("dubbo服务启动中...");
        System.in.read();
        System.out.println("dubbo服务启动关闭...");
    }
}
