package com.basara.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author long.yl.
 * @Date 2016/3/29
 */
@Component
public class LocationBeanFactoryProcessor implements BeanFactoryPostProcessor {

    /**
     * 调用时间：所有beanDefinition被加载完成之后，bean被实例化之前
     * Spring IoC容器允许BeanFactoryPostProcessor在容器实际实例化任何其它的bean之前读取配置元数据，并有可能修改它。
     * 同时BeanFactoryPostProcessor的回调比BeanPostProcessor要早
     * */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("【IOC容器处理器】所有beanDefinition被加载完成之后，bean被实例化之前...");
        /**
         * 下面的语句会报空指针异常，所以证明该方法调用时间是在bean被实例化之前
         * beanFactory.getBean(Foo.class).service();
         * */
    }
}
