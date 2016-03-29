package com.basara.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.lang.reflect.Proxy;

/**
 * Created by Larry .Yang
 * on 16/3/25 16:36
 * Package: parent_com.basara.processor
 */
@Component
public class Bar implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    @Value("bar")
    private String value;

    private BeanFactory beanFactory;
    private String beanName;

    public Bar(){
        System.out.println("【类本身构造器】调用Person的构造器实例化");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        System.out.println("【一般属性注入】注入属性value");
        this.value = value;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("【注解的初始化】调用PostConstruct注解指定的方法");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("【注解的销毁】调用PreDestroy注解指定的方法");
    }

    public void doPrint(){
        System.out.println("【业务处理】bar实现的一些操作...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【特殊属性注入】BeanFactoryAware接口，调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【特殊属性注入】BeanNameAware接口，调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【接口的销毁】DiposibleBean接口，调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out
                .println("【接口的初始化】InitializingBean接口，调用InitializingBean.afterPropertiesSet()");
    }

    public void myinit(){
        System.out.println("【自定义初始化】<bean>中配置的init-method调用的方法");
    }

    public void mydes(){
        System.out.println("【自定义销毁】<bean>中配置的destroy-method调用的方法");
    }
}
