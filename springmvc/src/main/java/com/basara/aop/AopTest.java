package com.basara.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author long.yl.
 * @Date 2016/4/16
 */
public class AopTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Class.forName("com.basara.aop.AopConfig");
        RealObject object = (RealObject) context.getBean("realObject");
        System.out.println("------------------------------");
        object.finalMethodTest();
        System.out.println("------------------------------");
        object.returnMethodTest();
        System.out.println("------------------------------");
        object.normalMethodTest();
        System.out.println("------------------------------");
        object.exceptionMethodTest();
        System.out.println("------------------------------");
    }
}
