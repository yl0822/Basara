package my.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by long.yl Created in 2016/8/11 Created on Basara_PACKAGE_NAME
 */
public class AbcServiceImpl implements AbcService, InitializingBean, ApplicationContextAware {

    private String abc;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext ... ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet ... ");
	}

    public void init(){
        System.out.println("initing ... ");
    }

	public AbcServiceImpl() {
        abc = "abc";
		System.out.println("construct abc service ... ");
	}

	@Override
	public void doAbc() {
		System.out.println("do sevice ... ");
	}
}
