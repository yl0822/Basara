package aop;

import com.basara.service.TextPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author long.yl.
 * @Date 2016/4/16
 */
@ContextConfiguration("classpath:applicationContext-test.xml")
public class AopTest {

    @Autowired
    ApplicationContext applicationContext;


    public static void main(String[] args) {
//        AopTest aopTest = new AopTest();
//        TextPostService service = (TextPostService)aopTest.applicationContext.getBean("textPostService");
//        service.getTestPostById(1);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
        TextPostService service2 = (TextPostService)context.getBean("textPostService");
        service2.getTestPostById(1);
    }
}
