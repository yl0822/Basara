import my.spring.test.AbcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by long.yl
 * Created in 2016/8/11
 * Created on Basara_my.spring.test
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AbcService abcService = ac.getBean("abcService2", AbcService.class);
        abcService.doAbc();
        System.out.println(ac.getApplicationName());
    }
}
