package cache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
/**
 * @author long.yl.
 * @Date 2016/6/17
 */
public class AccountServiceTest {

    private AccountService accountService1;
    private AccountService_Sc accountService2;

    private final Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService1 = context.getBean("accountService", AccountService.class);
        accountService2 = context.getBean("accountService_Sc", AccountService_Sc.class);
    }

    @Test
    public void testInject(){
        assertNotNull(accountService1);
        assertNotNull(accountService2);
    }

    @Test
    public void testGetAccountByName() throws Exception {
        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");

        accountService1.reload();

        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");
    }

    @Test
    public void testGetAccountByName2() throws Exception {
        System.out.println(accountService2.getAccountByName("accountName"));
        System.out.println(accountService2.getAccountByName("accountName"));

        accountService2.reload();

        System.out.println(accountService2.getAccountByName("accountName"));
        System.out.println(accountService2.getAccountByName("accountName"));
    }
}
