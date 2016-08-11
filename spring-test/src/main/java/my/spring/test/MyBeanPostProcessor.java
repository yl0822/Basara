package my.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by long.yl
 * Created in 2016/8/11
 * Created on Basara_my.spring.test
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(
                "postProcessBeforeInitialization - bean name : " + beanName + "bean class : " + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 这里可以进行bean的代理工作
        System.out.println(
                "postProcessAfterInitialization - bean name : " + beanName + "bean class : " + bean.getClass());
        return bean;
    }
}
