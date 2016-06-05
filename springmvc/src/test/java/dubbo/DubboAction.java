package dubbo;

import com.dubbo.demo.DemoService;
import com.redis.dc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author long.yl.
 * @Date 2016/3/17
 */
//@ContextConfiguration("classpath:applicationContext-test.xml")

//注解表示该类为一个spring容器，可以在里面用@Bean来完成bean的注册
//@Configuration
public class DubboAction {

//    @Autowired
//    Client hashClient;

    @Autowired
    DemoService demoService;

//    @Autowired
//    Hibernate hibernate;

//    static {
//        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:redis-dubbo-consumer.xml");
//        demoService = (DemoService)context.getBean("demoService");
//        hashClient = (Client)context.getBean("hashClient");
//    }
    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String []{"classpath:redis-dubbo-consumer.xml"});
//        context.start();
    }

    public DubboAction() throws Throwable{
        ApplicationContext context;
        boolean userClassSystem = true;
        if (userClassSystem){
            context = new ClassPathXmlApplicationContext(new String []{"classpath:redis-dubbo-consumer.xml"});
        }else {
            context = new FileSystemXmlApplicationContext("classpath:redis-dubbo-consumer.xml");
        }
        Class.forName("dubbo.SpringAnnotationConfigurationTest");
        demoService = (DemoService)context.getBean("demoService");
//        hashClient = (Client)context.getBean("hashClient");
//        hibernate = (Hibernate) context.getBean("hibernate");
    }

    public static void main(String[] args) throws Throwable{
        DubboAction da = new DubboAction();
        da.say();
        da.get();
//        da.print();
    }

    private void say(){
        System.out.println(demoService.sayHello());
    }

    private void get(){
//        System.out.println(hashClient.getDesc());
    }

    private void print(){
//        System.out.println(hibernate.toString());
    }

}
