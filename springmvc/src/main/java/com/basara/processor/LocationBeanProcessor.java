package com.basara.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Larry .Yang
 * on 16/3/25 16:20
 * Package: parent_com.basara.processor
 */
@Component
public class LocationBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【处理器初始化】实例化" + beanName + "Bean之前调用...");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【处理器初始化】实例化" + beanName + "之后调用...");
        return bean;
    }
}
