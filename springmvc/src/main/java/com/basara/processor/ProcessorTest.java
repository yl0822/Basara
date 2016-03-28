package com.basara.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Larry .Yang
 * on 16/3/25 16:24
 * Package: parent_com.basara.processor
 */
public class ProcessorTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(context.getApplicationName());
        System.out.println(context.getDisplayName());
        System.out.println(context.getId());
//        System.out.println(context.getParent().getApplicationName());
        ((LocationBean)context.getBean(LocationBean.class)).doPrint();
    }
}
