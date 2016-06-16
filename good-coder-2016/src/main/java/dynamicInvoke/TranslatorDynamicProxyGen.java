package dynamicInvoke;

import javassist.ClassPool;
import pattern.proxy.Translator;
import pattern.proxy.TranslatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Larry .Yang
 * on 16/3/28 17:23
 * Package: parent_dynamicInvoke
 */
public class TranslatorDynamicProxyGen {

    //通过jdk的InvocationHandler,动态生成translator的代理类

    public static void main(String[] args) {
        TranslatorImpl translatorImpl = new TranslatorImpl();
        Class[] interfaces = translatorImpl.getClass().getInterfaces();
        ClassLoader classLoader = translatorImpl.getClass().getClassLoader();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(translatorImpl);
        Object o = Proxy.newProxyInstance(classLoader, new Class[]{Translator.class}, invocationHandler);
        Translator translator = (Translator) o;
        translator.transToChiness("invoke");
//        ProxyUtil.genClassByte(translator.getClass(), "translatorInvocationProxy");
    }
}
