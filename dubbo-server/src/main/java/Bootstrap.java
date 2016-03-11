import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long.yl.
 * @Date 2016/3/11
 */
//@ImportResource({"classpath:config/contentProvider.xml"} )
@Configuration
@ComponentScan
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String []{"classpath:demoProvider.xml"});
        context.start();
        //为保证服务一直开启，利用输入流的阻塞来模拟
        System.in.read();
    }
}
